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
	<base href="<%=basePath%>">
    <title>后台管理系统</title>
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
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
        }

        .form-signin {
            max-width: 300px;
            padding: 19px 29px 29px;
            margin: 0 auto 20px;
            background-color: #fff;
            border: 1px solid #e5e5e5;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            -moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
        }

        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
        }

        .form-signin input[type="text"],
        .form-signin input[type="password"] {
            font-size: 16px;
            height: auto;
            margin-bottom: 15px;
            padding: 7px 9px;
        }

    </style>  
</head>
<body>
<div class="container">

    <form class="form-signin" method="post" action="sys/user_login">
        <h2 class="form-signin-heading">登录系统</h2>
       <input type="text" name="username" class="input-block-level" placeholder="账号">
       <input type="password" name="pwd" class="input-block-level" placeholder="密码">
        <input type="text" name="code" class="input-medium" placeholder="验证码">
      	<img src="img2.jsp" onclick="this.src='img2.jsp?'+new Date()" style="vertical-align: middle;"width="100" height="80" />
       
        <p><button class="btn btn-large btn-primary" type="submit">登录</button>&nbsp&nbsp&nbsp<span style="color:red">${INFO }</span></p>
        <font color="red"><s:actionmessage/></font>
      	
        <s:fielderror fieldName="username" ></s:fielderror><br/>
   		<s:fielderror fieldName="pwd"></s:fielderror>
    </form>

</div>
</body>
</html>