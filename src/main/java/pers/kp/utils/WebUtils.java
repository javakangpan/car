package pers.kp.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebUtils {

	
	public static void showMsg(String msg,HttpServletResponse response,HttpServletRequest request) throws IOException{
		/*PrintWriter out=response.getWriter();
		out.write("<script>");
		out.write("alert('");
		out.write(msg);
		out.write("');");
		out.write("</script>");
		out.flush();
		out.close();*/
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.append("<script type='text/javascript'>");
		out.append("alert('");
		out.append(msg);
		out.append("');");
		out.append("location.href='"+request.getContextPath()+"/login.jsp';");
		out.append("</script>");
		out.flush();
		out.close();
		
	}
	public static void noAccess(String msg,HttpServletResponse response,HttpServletRequest request) throws IOException{
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.append("<script type='text/javascript'>");
		out.append("alert('");
		out.append(msg);
		out.append("');");
		out.append("location.href='"+request.getContextPath()+"/noAccess.jsp';");
		out.append("</script>");
		out.flush();
		out.close();

	}
	public static boolean isEmpty(String str){
		if(str==null||"".equals(str)){
			return true;
		}
		return false;
	}
	
	
}
