package pers.kp.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import pers.kp.pojo.TMenu;
import pers.kp.pojo.TRole;
import pers.kp.service.IMenuService;
import pers.kp.service.IRoleService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
public class RoleAction extends ActionSupport  implements ModelDriven<TRole>{

	private List<TRole> list;
	
	private List<TMenu> menuList;
	
	private TRole model = new TRole();

	@Resource
	private IRoleService roleService;
	
	@Resource
	private IMenuService menuService;

	public String query() {
		
		setList(roleService.query(null));
		return SUCCESS;

	}

	public String save(){
		
		roleService.save(model);
		return "query";
		
	}
	
	public void setList(List<TRole> list) {
		this.list = list;
	}

	public List<TRole> getList() {
		return list;
	}
	
	public String getAddData(){
		
		menuList = menuService.query(null);
		return "add";
		
	}
	
	public String update(){
		roleService.update(model);
		return "query";
	}
	
	/**
	 * 获取更新需要的相关数据
	 *    1.当前的角色信息
	 *    2.当前角色所有具有的菜单信息
	 *    3.所有的菜单信息
	 * @return
	 */
	public String getUpdateData(){
		
		//这里要延迟加载  因为要根据查询中间表的数据 session会话关闭后不能通过代理对象查询中间表的数据
		model = roleService.queryById(model.getId());
		// 将model对象放入值栈中
		ActionContext.getContext().getValueStack().push(model);
		// 获取所有的菜单信息
		setMenuList(menuService.query(null));
		
		return "update";
	}
	
	
	public String delete(){
		roleService.delete(model);
		return "query";
	}
	

	public List<TMenu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<TMenu> menuList) {
		this.menuList = menuList;
	}

	@Override
	public TRole getModel() {
	
		return model;
	}
	
}
