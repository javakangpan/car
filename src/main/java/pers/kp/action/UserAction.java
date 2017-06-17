package pers.kp.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;

import pers.kp.pojo.TUser;
import pers.kp.service.IDepartmentService;
import pers.kp.service.IRoleService;
import pers.kp.service.IUserService;
import pers.kp.utils.PageModel;
import pers.kp.utils.WebUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Controller
public class UserAction extends BaseAction implements ModelDriven<TUser>,ServletRequestAware,ServletResponseAware {

	private TUser model = new TUser();
	@Resource
	private IUserService userService;
	@Resource
	private IRoleService roleService;
	@Resource
	private IDepartmentService departmentService;
	
	
	
	
	private Object deptList;
	private Object roleList;
	private HttpServletResponse response;
	private HttpServletRequest request;
	
	public String query(){
		pageModel = userService.queryByPage(currentPage, pageSize, model);
		return super.SUCCESS;
	}
	
	
	public String out(){
		ActionContext.getContext().getSession().clear();
		request.getSession().invalidate();
		return "input";
	}
	
	
	/**
	 * 同步用户数据
	 * @return
	 */
	public String synUser(){
		userService.saveSynUser();
		return "query";
	}
	
	

	@Override
	public TUser getModel() {
		
		return model;
	}
	
	/**
	 * 查询出所有的部门和角色信息
	 * @return
	 */
	public String getAddData(){
		// 查询所有部门信息
		 deptList = departmentService.query(null);
		// 查询所有角色信息
		 roleList = roleService.query(null);
		return "add";
	}
	
	public String save(){
		userService.save(model);
		return "query";
	}

	
	public String login(){
		String rand = (String) request.getSession().getAttribute("rand");
		String code = request.getParameter("code");
		model=(TUser) userService.login(model.getUsername(),model.getPwd());
		
	
		if(model!=null&&!WebUtils.isEmpty(code)&& code.equals(rand)){
			//用户登录成功后，把他对应的菜单权限查出来
			List<String> menus = userService.queryMenuById(model.getId());
		
			model.setMenus(menus);
			request.getSession().setAttribute("LOGIN_INFO", model);
			request.getSession().setMaxInactiveInterval(60 * 15);
			return "login";
		}else{
			this.addActionMessage("用户名或密码输入有误");
			request.getSession().setAttribute("INFO", "用户名或密码输入有误");
			return "input";
			}
		
	}
	
	
	
	public String getUpdateData(){
		model=userService.queryById(model.getId());
		ActionContext.getContext().getValueStack().push(model);
		return "update";
	}
	
	
	
	public Object getDeptList() {
		return deptList;
	}

	public void setDeptList(Object deptList) {
		this.deptList = deptList;
	}

	public Object getRoleList() {
		return roleList;
	}

	public void setRoleList(Object roleList) {
		this.roleList = roleList;
	}

	public String update(){
		
		userService.update(model);
		return "query";
		
	}
	public String delete(){
		userService.delete(model);
		return "query";
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
		
	}



	@Override
	public void setServletRequest(HttpServletRequest request) {
		
		this.request=request;
	}

	

}
