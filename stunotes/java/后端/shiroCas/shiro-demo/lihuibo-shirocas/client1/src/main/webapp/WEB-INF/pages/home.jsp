<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://shiro.apache.org/tags"  prefix="shiro"%>
<!DOCTYPE html>
<html lang="zh">
	<head>
		<meta charset="utf-8" />
		<title>client1-home</title>
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
				<div class="col-lg-12" >
					<h1>	lhb -shiro   </h1>
				</div>
			</div>
			<div class="row">
				shiro hello <shiro:principal property="uname"/>   <a href="<%=request.getContextPath()%>/logout">退出</a>
			</div>
			<div class="row">
				<div class="col-lg-2" >
					<ul>
						<!-- 判断用户角色  -->
						<shiro:hasAnyRoles name="systemAdmin,usual">
							<li><a href="<%=request.getContextPath()%>/user/userUI" target="myIframe"> 用户 </a></li>
							<li><a href="<%=request.getContextPath()%>/role/roleUI" target="myIframe"> 角色</a></li>
							<li><a href="<%=request.getContextPath()%>/permission/permissionUI" target="myIframe"> 权限</a></li>
						</shiro:hasAnyRoles>
					</ul>
				</div>
				<div class="col-lg-10" >
					<iframe id="myIframe" name="myIframe" src="<%=request.getContextPath()%>/info.jsp" height="100%" width="100%"  frameborder="0" scrolling="no"></iframe>
				</div>
			</div>
		</div>
	</body>
</html>
