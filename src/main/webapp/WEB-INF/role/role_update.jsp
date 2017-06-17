<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="Css/style.css" />
    <script type="text/javascript" src="Js/jquery.js"></script>
    <script type="text/javascript" src="Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="Js/bootstrap.js"></script>
    <script type="text/javascript" src="Js/ckform.js"></script>
    <script type="text/javascript" src="Js/common.js"></script>

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
</head>
<body>
<form action="sys/role_update" method="post" class="definewidth m20">
<table class="table table-bordered table-hover m10">
    <input type="hidden" name="id" value="${id }">
    <tr>
        <td class="tableleft">角色名称</td>
        <%-- <td><input type="text" name="rolename" value="${rolename }"/></td> --%>
        <td><input type="text" name="rolename" value="${rolename}"/></td>
    </tr>
    <tr>
        <td class="tableleft">描述</td>
        <td><input type="text" name="demo" value="${demo }"/></td>
    </tr>
    
    
    <tr>
        <td class="tableleft">
        	菜单<s:property value="menus.{id}"/>
        </td>
        <td>
        	<%-- <c:forEach items="${menuList }" var="menu">
        		<input type="checkbox" name="aa" value="${menu.id }"/>${menu.menuname } <br/>
        	</c:forEach> --%>
        	<!-- 显示一级菜单 -->
        	<s:iterator value="menuList.{? #this.pid==0}" var="big">
        		<input type="checkbox" name="menus.id"  <s:property value="#big.id in menus.{id} ? 'checked':''"/>
        			value="<s:property value="#big.id"/>"/>
        			<s:property value="#big.menuname"/> <br/>
        			
        		<!-- 显示当前一级菜单下的所有的二级菜单 -->
        		<s:iterator value="menuList.{? #this.pid==#big.id}" var="second">
        			&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"  <s:property value="#second.id in menus.{id} ? 'checked':''"/>
        			 name="menus.id" value="<s:property value="#second.id"/>"/>
        			<s:property value="#second.menuname"/> <br/>
        			
        			<!-- 显示当前二级菜单下的所有的三级菜单 -->
        			<s:iterator value="menuList.{? #this.pid==#second.id}" var="small">
        				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        				<input type="checkbox" name="menus.id"   <s:property value="#small.id in menus.{id} ? 'checked':''"/>
        					value="<s:property value="#small.id"/>"/>
        				<s:property value="#small.menuname"/> <br/>
        			</s:iterator>
        		</s:iterator>	
        	</s:iterator>
        	
        	
        
        </td>
    </tr>
    
    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="submit" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
        </td>
    </tr>
</table>
<%-- <!--  -->
<s:debug></s:debug> --%>
</form>
</body>
</html>
<script>
    $(function () {       
		$('#backid').click(function(){
				window.location.href="index.html";
		 });

    });
</script>
