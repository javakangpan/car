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
    角色名称：
    <input type="text" name="rolename" id="rolename"class="abc input-default" placeholder="" value="">&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; 
    <button type="button" class="btn btn-success" id="addnew">新增角色</button>
	<!--  把分页做完-->

</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>角色id</th>
        <th>角色名称</th>
        <th>描述</th>
        <th>操作</th>
      
    </tr>
    </thead>
    <s:iterator value="list" var="role">
    		<tr>
            <td><s:property value="id"/></td>
            <td><s:property value="rolename"/></td>
            <td><s:property value="demo"/></td>
            <td>
                <a href="sys/role_getUpdateData?id=<s:property value="id"/>">编辑</a>   
                <a href="JavaScript:void(0)" onclick="del(<s:property value="id"/>);">删除</a> 
                <%-- <a href="sys/role_getDeleteData?id=<s:property value="id"/>">删除</a>   --%>         
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

				window.location.href="sys/role_getAddData";
		 });
		 
		 
		$('#synUser').click(function(){

				window.location.href="sys/user_synUser";
		 });


    });

	function del(id)
	{
		
		
		if(confirm("确定要删除吗？"))
		{
		
			var url = "sys/role_delete?id="+id;
			
			window.location.href=url;		
		
		}
	
	
	
	
	}
</script>
