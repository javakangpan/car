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
<form class="form-inline definewidth m20"  id="pager" method="post">
<!-- <form class="form-inline definewidth m20" action="sys/menu_query" id="pager" method="post">   -->  
   
    
    <s:if test="'/sys/menu_getAddData' in #session.LOGIN_INFO.menus ">
    	<button type="button" class="btn btn-success" id="addnew">新增菜单</button>
    </s:if>
  
	
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>id</th>
        <th>菜单名称</th>
        <th>地址</th>
        <th>父菜单编号</th>
        <th>权限描述</th>
        <th>备注</th>
        <th>操作</th>
    </tr>
    </thead>
    
    	<!-- 显示一级菜单 -->
    	<s:iterator value="list.{? #this.pid==0}" var="big">
    		<tr>
	            <td><s:property value="#big.id"/></td>
	            <td><s:property value="#big.menuname"/></td>
	            <td><s:property value="#big.menulink"/></td>
	            <td><s:property value="#big.pid"/></td>
	            <td><s:property value="#big.securyname"/></td>
	            <td><s:property value="#big.memo"/></td>
	            <td>
	                <a href="sys/menu_getUpdateData?id=<s:property value="#big.id"/>">编辑</a>
	                <a href="javascript:void(0)" onclick="del(<s:property value="#big.id"/>);">删除</a>                     
	            </td>
	        </tr>	
        		<!-- 获取一级菜单对应的二级菜单 -->
        		<s:iterator value="list.{? #this.pid==#big.id}" var="second">
        			<tr>
	            		<td style="padding-left: 40px;"><s:property value="#second.id"/></td>
			            <td style="padding-left: 40px;"><s:property value="#second.menuname"/></td>
			            <td><s:property value="#second.menulink"/></td>
			            <td style="padding-left: 40px;"><s:property value="#second.pid"/></td>
			            <td><s:property value="#second.securyname"/></td>
			            <td><s:property value="#second.memo"/></td>
			            <td>
			                <a href="sys/menu_getUpdateData?id=<s:property value="#second.id"/>">编辑</a>  
			                <a href="javascript:void(0)" onclick="del(<s:property value="#second.id"/>);">删除</a>            
			            </td>
			        </tr>	
			        	<!-- 获取二级菜单对应的三级菜单 -->
			        	<s:iterator value="list.{? #this.pid==#second.id}" var="small">
			        		<tr>
			            		<td style="padding-left: 80px;"><s:property value="#small.id"/></td>
					            <td style="padding-left: 80px;"><s:property value="#small.menuname"/></td>
					            <td style="color:red;"><s:property value="#small.menulink"/></td>
					            <td style="padding-left: 80px;"><s:property value="#small.pid"/></td>
					            <td><s:property value="#small.securyname"/></td>
					            <td><s:property value="#small.memo"/></td>
					            <td>
					                <a href="sys/menu_getUpdateData?id=<s:property value="#small.id"/>">编辑</a>                
					          		<a href="javascript:void(0)" onclick="del(<s:property value="#small.id"/>);">删除</a>
					            </td>
					        </tr>	
			        	</s:iterator>
        		</s:iterator>
    	</s:iterator>
    	
	     
</table>
	
</body>
</html>
<script>
    $(function () {
        

		$('#addnew').click(function(){

				window.location.href="sys/menu_getAddData";
		 });
		 
		 $('#synUser').click(function(){

				window.location.href="sys/user_synUser";
		 });


    });

	function del(id)
	{
		
		
		if(confirm("确定要删除吗？"))
		{
		
			var url = "sys/menu_delete?id="+id;
			
			window.location.href=url;		
		
		}
	
	
	
	
	}
</script>
