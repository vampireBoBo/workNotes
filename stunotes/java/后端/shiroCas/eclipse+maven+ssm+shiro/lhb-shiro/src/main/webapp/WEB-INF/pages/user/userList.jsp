<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>用户列表</title>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" />
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/font-awesome.min.css" />
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/js/layer/skin/default/layer.css" />
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/js/bootstrap-table/bootstrap-table.css" />
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="page-header">
					<h1>用户管理页面<small>用户</small></h1>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<shiro:hasPermission name="user:all">
					<a href="#">新增</a>&nbsp;&nbsp;&nbsp;
					<a href="#">修改</a>&nbsp;&nbsp;&nbsp;
					<a href="#">删除</a>
				</shiro:hasPermission>
			</div>
			<div class="col-lg-12">
				<table id="userTable"></table>
			</div>
		</div>
	</div>
	<%@ include file="../common.jsp" %>
	<script type="text/javascript">
		var tab = $('#userTable');
		$(function(){
			// bootstrap table
			tab.bootstrap({
				
			});
			
			
			$.ajax({
				url:'<%=request.getContextPath()%>/user/list',
			}); 
		});
	</script>
</body>
</html>