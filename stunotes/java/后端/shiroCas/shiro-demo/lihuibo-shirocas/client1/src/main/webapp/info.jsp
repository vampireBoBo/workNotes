<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://shiro.apache.org/tags"  prefix="shiro"%>
<!DOCTYPE html>
<html lang="zh">
	<head>
		<meta charset="utf-8" />
		<title>登录页面</title>
		<meta name="keywords" content="权限控制系统" />
		<meta name="description" content="自定义权限控制系统" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/bootstrap.min.css" />
		<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/font-awesome.min.css" />
		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />
		<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/ace.min.css" />
		<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/ace-rtl.min.css" />
	</head>
	<body >
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<img src="<%=request.getContextPath()%>/resources/images/welcom.png" class="img-responsive" alt="Cinque Terre" >
				</div>
			</div>
		</div>
	</body>
</html>
