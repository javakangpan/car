package pers.kp.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.xml.sax.SAXException;

import pers.kp.pojo.TMenu;
import pers.kp.pojo.TUser;
import pers.kp.utils.WebUtils;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Intercepter;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.UnmarshallingContext.State;

public class SecurityInterceptor extends MethodFilterInterceptor{
	private String name;
	@Override
	public void destroy() {
	
		
	}

	@Override
	public void init() {
	
		
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	/**
	 * 处理被拦截的请求
	 * 当用户请求到来的时候，我们是可以确定用户是登录的
	 *    1.我们可以得到当前登录的用户 --> 对应的角色 ---> 对应的菜单
	 *       比如：当前用户是  cs1 --> 菜单的查询和 添加【/sys/menu_query，/sys/menu_getAddData，/sys/menu_save】
	 *    2.通过HttpServletRequest对象可以获取当前请求的地址 http:// .../../sys/menu_query
	 *      
	 */
	
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		HttpSession session=request.getSession();
		
		Object obj=session.getAttribute("LOGIN_INFO");
		
		/*System.out.println(obj.toString());*/
		System.out.println(name);
		
		if(obj!=null){
			
			// 表示当前会话已经登录，放过
			// 1.获取请求的地址
			
			//String  path = request.getRequestURI(); // /Day11_Car/sys/menu_query
			// request.getRequestURL() http://localhost:8081/Day11_Car/sys/menu_query
			// request.getServletPath() /sys/menu_query
			//System.out.println(path+" "+request.getRequestURL()+" "+request.getServletPath());
			
			 String path=request.getServletPath();
			// 2.获取当前用户具有的菜单地址
			// 2.获取当前用户具有的菜单地址  在拦截器中每次处理请求的时候都去数据库中查询用户具有的菜单效率比较低
			// 而且用户具有的菜单一般是不会改变的  在登录成功的时候获取
		
			System.out.println("请求地址:"+path);
			TUser user=(TUser) obj;
			List<String> menus=user.getMenus();
			System.out.println("用户拥有的权限请求地址:"+menus);
			// 3.判断当前请求地址是否在当前用户具有的地址中，有合法，没有非法
			boolean flag=false;//不在权限内
		
			for(String m:menus){
				if(m.equals(path)||(m+".action").equals(path)){
					flag=true;
					break;
				}
			}
			if(flag){
				invocation.invoke();
			}else{
				WebUtils.noAccess("请求权限不够", response, request);
			}
		
				
		
				
			
		}else{
			WebUtils.showMsg("未登录请登录", response, request);
			
		}
		
		return null;
	
		
	}
 


}
