package pers.kp.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import pers.kp.pojo.TMenu;
import pers.kp.service.IMenuService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
public class MenuAction extends ActionSupport implements ModelDriven<TMenu>{
	
	@Resource
	private IMenuService menuService;
	
	private TMenu model = new TMenu();
	
	private List<TMenu> list;
	
	public String query(){
		setList(menuService.query(null));
		return SUCCESS;
		
	}
	
	
	public String getAddData(){
		
		setList(menuService.query(null));
		return "add";
	}
	
	
	
	public String delete(){
		menuService.delete(model);
		return "query";
	}
	public List<TMenu> getList() {
		return list;
	}
	public void setList(List<TMenu> list) {
		this.list = list;
	}
	
	public String save(){
		menuService.save(model);
		return "query";
	}
	
	public String update(){
		menuService.update(model);
		return "query";
		
	}
	
	public String getUpdateData(){
		
		
		model = menuService.queryById(model.getId());
		
		ActionContext.getContext().getValueStack().push(model);
		setList(menuService.query(null));
		
		return "update";
	}
	
	
	
	
	
	@Override
	public TMenu getModel() {
		
		return model;
	}
	
}
