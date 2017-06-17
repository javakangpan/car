<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%-- <%@taglib prefix="s" uri="/struts-tags" %> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<form action="sys/user_save" method="post" class="definewidth m20">
<table class="table table-bordered table-hover m10">
    
    <tr>
        <td class="tableleft">账号</td>
        <td><input type="text" name="username"/></td>
    </tr>
    <tr>
        <td class="tableleft">密码</td>
        <td><input type="password" name="pwd"/></td>
    </tr>
    <tr>
        <td class="tableleft">姓名</td>
        <td><input type="text" name="realname"/></td>
    </tr>
    
    <tr>
        <td class="tableleft">性别</td>
        <td>
            <input type="radio" name="sex" value="男" checked/> 男
            <input type="radio" name="sex" value="女"/> 女
        </td>
    </tr>
    
    
    
    <tr>
        <td width="10%" class="tableleft">部门</td>
        <td>
            <select name="depid">
           		<c:forEach items="${deptList }" var="dept">
           			<option value="${dept.id }"> ${dept.name }</option>
           		</c:forEach>     
            </select>
        </td>
    </tr>
    
    <tr>
        <td class="tableleft">角色</td>
        <td>
        	<c:forEach items="${roleList }" var="role">
        		<input type="checkbox" name="roles.id" value="${role.id }"/>${role.rolename } &nbsp;
        	</c:forEach>
        	
        
        </td>
    </tr>
    
    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="submit" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
        </td>
    </tr>
</table>
</form>
<%-- <s:debug></s:debug> --%>

</body>
</html>
<script>
    $(function () {       
		$('#backid').click(function(){
				window.location.href="index.html";
		 });

    });
</script>
