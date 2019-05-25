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
	</style>
</head>
<body>
	<div class="container" ng-app="stu" ng-controller="manage">
		<div class="row">
			<div class="col-lg-12">
				<button id="add" class="btn btn-success" data-toggle="modal" data-target="#addModal"><span class="glyphicon glyphicon-pencil"></span>新增</button>
				<span class="spanCol"></span>
				<button id="delbatch" class="btn btn-success"><span class="glyphicon glyphicon-remove"></span>删除</button>
			</div>
		</div>
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
					<td><button class="btn btn-primary" ng-click="toUpd($index)" data-target="#updModal"><span class="glyphicon glyphicon-pencil"></span>修改</button><span class="spanCol"></span><button class="btn btn-primary" ng-click="toDel($index)"><span class="glyphicon glyphicon-remove"></span>删除</button></td>
				</tr>
			</tbody>
		</table>
		<nav>
			<ul class="pagination pagination-lg">
				<li><a ng-click="Previous()" href="#">上一页</a></li>
				<li ng-repeat="btn in pageBtnList" ng-class="active">
					<a href="#">{{btn}}</a>
				</li>
				<li><a ng-click="Next()" href="#" >下一页</a></li>
			</ul>
		</nav>
		<!-- 新增模态框 -->
		<div class="modal fade" id="addModal" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header" style="background-color: #337ab7;color:white;font-size:16px;">
						新增用户
					</div>
					<div class="modal-body">
						<form class="form form-horizontal">
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 form-group">
									<label class="control-label col-lg-3 col-md-3 col-sm-3 col-xs-4">学号</label>
									<div class="col-lg-9 col-md-9 col-sm-9 col-xs-8">
										<input type="text" class="form-control" placeholder="请输入学号">
									</div>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 form-group">
									<label class="control-label col-lg-3 col-md-3 col-sm-3 col-xs-4">姓名</label>
									<div class="col-lg-9 col-md-9 col-sm-9 col-xs-8">
										<input type="text" class="col-lg-8 form-control" placeholder="请输入姓名">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 form-group">
									<label class="control-label col-lg-3 col-md-3 col-sm-3 col-xs-4">性别</label>
									<div class="col-lg-9 col-md-9 col-sm-9 col-xs-8">
										<input type="text" class="col-lg-8 form-control">
									</div>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 form-group">
									<label class="control-label col-lg-3 col-md-3 col-sm-3 col-xs-4">年龄</label>
									<div class="col-lg-9 col-md-9 col-sm-9 col-xs-8">
										<input type="text" class="col-lg-8 form-control">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 form-group">
									<label class="control-label col-lg-3 col-md-3 col-sm-3 col-xs-4">email</label>
									<div class="col-lg-9 col-md-9 col-sm-9 col-xs-8">
										<input type="text" class="col-lg-8 form-control" placeholder="请输入邮箱">
									</div>
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer" style="text-align:center;">
						<button class="btn btn-primary" data-dismiss="modal">取消</button>	
						<button class="btn btn-primary" type="reset" >重置</button>
						<button class="btn btn-primary" type="submit" onclick="add()">提交</button>							
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/plugins/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/plugins/twitter-bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/plugins/angular-4.13.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/plugins/layer/layer.js"></script>
	<script type="text/javascript">
		var app = angular.module('stu',[]);
		app.controller('manage',function($scope,$http){
			$http({
				method:'GET',
				url:'<%=request.getContextPath()%>/spring/student/manageData',
			}).then(function successCallback(response){
				if(response.data.status == 1){
					$scope.stuList = response.data.total;
					// 进行分页处理
					$scope.data = response.data.total;
					$scope.pageSize = 1;
					$scope.pageNo = 1;
					$scope.pageTotal = Math.ceil($scope.data.length/$scope.pageSize);
					$scope.pageBtnList = [];
					$scope.pageButNum = $scope.pageTotal<5?$scope.pageTotal:5;
					for(var i=0;i<$scope.pageButNum;i++){
						$scope.pageBtnList.push(i+1);
					}
					$scope.setDate = function(){
						$scope.item = $scope.data.slice(($scope.pageNo-1)*$scope.pageSize,$scope.pageNo*$scope.pageSize);
					}
					$scope.item = $scope.data.slice(0,$scope.pageSize);
					
					$scope.selectPage=function (page){
						if(page<1 || page>$scope.pageTotal )return;
						if(page>2){
							
						}
					}
					$scope.Previous=function (){
					}
					
					// 删除函数
					$scope.toDel = function ($index){
						layer.alert("确认是否删除？"+$scope.item[$index].sname,{icon:0,title:'温馨提示',btn:['确定','取消'],btn2:function(){
						}},function(){
							layer.alert('删除成功');
						});
						
					}
					
					// 更新
					$scope.toUpd = function ($index){
						
					}
				}
				if(response.data.status == -1){
					layer.alert('数据查询失败或者数据为空');
				}
			},function errorCallback(response){
				layer.alert("服务器异常请稍后再试");
			});
		});
		
	</script>	
</body>
</html>