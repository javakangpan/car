<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <base href="<%=basePath%>">
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
<form class="form-inline definewidth m20" action="sys/user_query" id="pager" method="post">    
    用户名称：
    <input type="text" name="username" id="username"class="abc input-default" placeholder="" value="${username}">&nbsp;&nbsp;  
    <s:if test="'/sys/user_query' in #session.LOGIN_INFO.menus "><button type="submit" class="btn btn-primary">查询</button></s:if>&nbsp;&nbsp; <s:if test="'/sys/user_getAddData' in #session.LOGIN_INFO.menus "><button type="button" class="btn btn-success" id="addnew">新增用户</button></s:if>
	
	<s:if test="'/sys/user_synUser' in #session.LOGIN_INFO.menus ">
	<button type="button" class="btn btn-success" id="synUser">同步用户</button>
	</s:if>
	<input type="hidden" id="currentPage" name="currentPage" value="${pageModel.currentPage }">
		<input type="hidden" id="pageSize" name="pageSize" value="${pageModel.pageSize }">
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>用户id</th>
        <th>账号</th>
        <th>密码</th>
        <th>姓名</th>
        <th>性别</th>
        <th>部门编号</th>
        <th>操作</th>
    </tr>
    </thead>
    	<s:iterator value="pageModel.result" var="user">
    		<tr>
            <td><s:property value="id"/></td>
            <td><s:property value="username"/></td>
            <td><s:property value="pwd"/></td>
            <td><s:property value="realname"/></td>
            <td><s:property value="sex"/></td>
            <td><s:property value="depid"/></td>
            <td>
               <a href="sys/user_getUpdateData?id=<s:property value="id"/>">编辑</a>   
                <a href="JavaScript:void(0)" onclick="del(<s:property value="id"/>);">删除</a>               
            </td>
        </tr>	
    	</s:iterator>
    	
    	
	     
</table>
	<%-- <form action="sys/user_query" id="pager" method="post">
		<input type="hidden" id="currentPage" name="currentPage" value="${pageModel.currentPage }">
		<input type="hidden" id="pageSize" name="pageSize" value="${pageModel.pageSize }">
	</form> --%>
 	<jsp:include page="../../pageBar.jsp"></jsp:include> 
</body>
</html>
<script>
    $(function () {
        

		$('#addnew').click(function(){

				window.location.href="sys/user_getAddData";
		 });
		 
		 
		$('#synUser').click(function(){

				window.location.href="sys/user_synUser";
		 });


    });

	function del(id)
	{
		
		
		if(confirm("确定要删除吗？"))
		{
		
			var url = "sys/user_delete?id="+id;
			
			
			window.location.href=url;		
		
		}
	
	
	
	
	}
</script>
