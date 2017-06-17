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
<form action="sys/menu_update" method="post" class="definewidth m20">
<table class="table table-bordered table-hover m10">
    <s:hidden name="id"></s:hidden>
    <tr>
        <td class="tableleft">角色名称</td>
        <td>
        	<s:textfield name="menuname" theme="simple"></s:textfield>
        </td>
    </tr>
    <tr>
        <td class="tableleft">地址</td>
        <td>
        	<s:textfield name="menulink" theme="simple"></s:textfield>
        </td>
    </tr>
    
     <tr>
        <td class="tableleft">权限描述</td>
        <td>
        	<s:textfield name="securyname" theme="simple"></s:textfield>
        </td>
    </tr>
    
     <tr>
        <td class="tableleft">备注</td>
        <td>
        	<s:textfield name="memo" theme="simple"></s:textfield>
        </td>
    </tr>
    
    <tr>
        <td class="tableleft">父菜单</td>
        <td>
        	<s:select list="list.{? #this.menulink==null}" headerKey="0" headerValue="一级菜单"
        	listKey="id" listValue="menuname" name="pid" theme="simple"></s:select>
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
<s:debug></s:debug>
</body>
</html>
<script>
    $(function () {       
		$('#backid').click(function(){
				window.location.href="index.html";
		 });

    });
</script>
