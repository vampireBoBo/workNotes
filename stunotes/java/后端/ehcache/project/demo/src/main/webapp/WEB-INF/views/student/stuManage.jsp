<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>学生列表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
	<link href="<%=request.getContextPath() %>/resources/plugins/twitter-bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet" >
	<style type="text/css">
		#caption{caption-side:top;}
		nav {
	        position: relative;
	        width:100%;
	        height: 50px;
	    }
	    .pagination {
	        right: 0px;
	        position: absolute;
	        top: -30px;
	    }
	    nav li {
	        cursor: pointer;
	    }
	    .spanCol{margin:0 10px;}
	    .container{margin-top:20px;}
	    .row{margin:5px;}
	    .form-control{width:;}
	    .reqSpan{color:red;}
	</style>
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/plugins/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/plugins/twitter-bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/plugins/angular-4.13.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/plugins/layer/layer.js"></script>
	
	<jsp:include page="stuJS.jsp"></jsp:include>
</head>
<body>
	<div class="container" ng-app="stu" >
		<div class="row">
			<div class="col-lg-12">
				<button id="add" class="btn btn-success" data-toggle="modal" data-target="#addModal"><span class="glyphicon glyphicon-pencil"></span>新增</button>
				<span class="spanCol"></span>
				<button id="delbatch" class="btn btn-success"><span class="glyphicon glyphicon-remove"></span>删除</button>
			</div>
		</div>
		<div ng-controller="listController" >
			<table class="table">
				<thead class="thead-blue">
					<tr>
						<th width="10%"><input type="checkbox" id="checkAll"></th>
						<th width="10%">学号</th>
						<th width="20%">姓名</th>
						<th width="20%" >性别</th>
						<th width="20%">年龄</th>
						<th width="20%">操作</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="stu in item">
						<td><input type="checkbox"></td>
						<td>{{stu.sno}}</td>
						<td>{{stu.sname}}</td>
						<td>{{stu.sex}}</td>
						<td>{{stu.age}}</td>
						<td><button class="btn btn-primary" ng-click="toUpd(stu)" data-target="#updModal"><span class="glyphicon glyphicon-pencil"></span>修改</button><span class="spanCol"></span><button class="btn btn-primary" ng-click="toDel(stu)"><span class="glyphicon glyphicon-remove"></span>删除</button></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="6">
							<nav>
								<ul class="pagination pagination-lg" style="margin-top:3%;">
									<li><a ng-click="Previous()" href="#">上一页</a></li>
									<li ng-repeat="btn in pageBtnList" ng-class="active">
										<a href="#">{{btn}}</a>
									</li>
									<li><a ng-click="Next()" href="#" >下一页</a></li>
								</ul>
							</nav>
						</td>
					</tr>
				</tfoot>
			</table>
		</div>
		
		<!-- 新增模态框 -->
		<div ng-controller="addController">
			<div class="modal fade" id="addModal" role="dialog">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header" style="background-color: #337ab7;color:white;font-size:16px;">
							新增用户
						</div>
						<div class="modal-body">
							<!-- novalidate="novalidate" 去除表单自带的校验功能  angularde 的表单校验依靠于name属性  -->
							<form class="form form-horizontal" id="addForm" name="addForm" autocomplete="off" ng-model="addStu" novalidate="novalidate">
								<div class="row">
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 form-group">
										<label class="control-label col-lg-3 col-md-3 col-sm-3 col-xs-4">学号</label>
										<div class="col-lg-9 col-md-9 col-sm-9 col-xs-8">
											<input type="text" class="form-control" placeholder="请输入学号" name="sno"  ng-model="addStu.sno" required ng-maxlength="80" ng-pattern="/^\d{3,}$/">
											<span class="warning text-danger"  ng-show="addForm.sno.$dirty && addForm.sno.$invalid">
												<apan ng-show="addForm.sno.$error.required">该字段为必填字段</apan>
												<apan ng-show="addForm.sno.$error.pattern">该字段为3位以上纯数字</apan>
											</span>
										</div>
									</div>
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 form-group">
										<label class="control-label col-lg-3 col-md-3 col-sm-3 col-xs-4">姓名</label>
										<div class="col-lg-9 col-md-9 col-sm-9 col-xs-8">
											<input type="text" class="col-lg-8 form-control" placeholder="请输入姓名" name="sname" ng-model="addStu.sname" required ng-maxlength="10">
											<span class="warning text-danger" ng-show="addForm.sname.$dirty && addForm.sname.$invalid">
												<span ng-show="addForm.sname.$error.required">该项为必填项</span>
												<span ng-show="addForm.sname.$error.maxlength">该项允许接收10个字符</span>
											</span>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 form-group">
										<label class="control-label col-lg-3 col-md-3 col-sm-3 col-xs-4">性别</label>
										<div class="col-lg-9 col-md-9 col-sm-9 col-xs-8 radio">
											<label><input type="radio" value="0" name="sex" ng-model="addStu.sex" required>男</label>
											<label><input type="radio" value="1" name="sex" ng-model="addStu.sex" required>女</label>
										</div>
									</div>
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 form-group">
										<label class="control-label col-lg-3 col-md-3 col-sm-3 col-xs-4">年龄</label>
										<div class="col-lg-9 col-md-9 col-sm-9 col-xs-8">
											<input type="number" min="10" max="40" class="col-lg-8 form-control" name="age" ng-model="addStu.age" placeholder="年龄范围【10-40】" required>                                          
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 form-group">
										<label class="control-label col-lg-3 col-md-3 col-sm-3 col-xs-4">email</label>
										<div class="col-lg-9 col-md-9 col-sm-9 col-xs-8">
											<input type="email" class="col-lg-8 form-control" placeholder="请输入邮箱" name="email" ng-model="addStu.email">
											<span class="warning text-danger" ng-show="addForm.email.$dirty && addForm.email.$invaild">
												<span ng-show="addForm.email.$error.email">邮箱格式错误</span>
											</span>
										</div>
									</div>
								</div>
								<div class="row modal-footer" style="text-align:center;">
									<button class="btn btn-primary" data-dismiss="modal">取消</button>	
									<button class="btn btn-primary" type="reset" >重置</button>
									<button class="btn btn-primary" ng-click="toAddStu()" ng-disabled="!addForm.$valid">提交</button>	
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<!-- 修改模态框 -->
		<div ng-controller="updController">
			<div class="modal fade" name="updModal">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header" style="background-color: #337ab7;color:white;font-size:16px;">
							更新用户
						</div>
						<div class="modal-body">
							<form class="form form-horizontal" action="" name="updForm" id="updForm" novalidate="novalidate">
								<div class="row">
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 form-group">
										<label class="control-label col-lg-3 col-md-3 col-sm-3 col-xs-4">学号</label>
										<div class="col-lg-9 col-md-9 col-sm-9 col-xs-8">
											<input class="form-control" name="sno" readonly="readonly">
										</div>
									</div>
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 form-group">
										<label class="control-label col-lg-3 col-md-3 col-sm-3 col-xs-4">姓名</label>
										<div class="col-lg-9 col-md-9 col-sm-9 col-xs-8">
											<input class="form-control" name="sname" ng-modal="updStu.sname" ng-patter="/^\d{3,}$/">
										</div>
									</div>
								</div>
							</form>
						</div>
						<div class="modal-footer">
						
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<!-- 测试部分 -->
		<div ng-controller='testCon'>
			<div>
				<div><form class="form form-horizontal"  autocomplete="off"><input ng-model="name" type="text"></form></div>
				<button type="button" ng-click="addCli()">提交</button>
			</div>
			{{name}}
		</div>
		
	</div>
</body>
</html>