<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
	<title>邮件发送</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
	<link href="<%=request.getContextPath() %>/resources/plugins/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" >
	<link href="<%=request.getContextPath() %>/resources/plugins/twitter-bootstrap/4.3.1/css/awesome-bootstrap-checkbox.css" rel="stylesheet" >
	<!-- <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" > -->
	<!-- <link href="https://cdn.bootcss.com/awesome-bootstrap-checkbox/1.0.1/awesome-bootstrap-checkbox.min.css" rel="stylesheet"> -->
	
</head>
<body>
	<div class="container" ng-app="send" ng-controller="sendController">
		<form role="form" class="form-horizontal" ng-submit="toSend()">
			<div class="form-group"> 
				<label class="col-lg-2 control-label" for="subject">主题</label>
				<div class="col-lg-9">
					<input type="text" class="form-control" id="subject" placeholder="请输入主题">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-2 control-label" for="content">内容</label>
				<div class="col-lg-9">
					<textarea rows="3" class="form-control center-block" placeholder="请输入邮件内容" id="content"></textarea>
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-2 control-label" for="inputfile">文件</label>
				<div class="col-lg-9">
					<input type="file" id="inputfile">
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-2 control-label" for="toEmail">接收人</label>
				<div class="col-lg-9">
					<label class="checkbox-inline checkbox-primary" for="toEmail1" ng-repeat="per in toperson" ng-show="{{per.email!=null}}">
						<input type="checkbox" id="toEmail1" value="{{per.email}}">{{per.sname}}:{{per.email}}
					</label>
				</div>
			</div>
			<div class="form-group">
				<div class="col-lg-12" align="center">
					<button type="submit" class="btn btn-primary" data-toggle="button">提交</button>
					<span style="margin:0 10px;"></span>
					<button type="reset" class="btn btn-primary" data-toggle="button">重置</button>
				</div>
			</div>
		</form>
	</div>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/plugins/angular-4.13.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/plugins/layer/layer.js"></script>
	<script type="text/javascript">
		var app = angular.module('send',[]);
		app.controller('sendController',function($scope,$http){
			$http({
				method:'GET',
				url:'<%=request.getContextPath()%>/spring/student/manageData',
			}).then(function successCallback(reponse){
				if(reponse.data.status == 1){
					$scope.toperson = reponse.data.total;
				}
				if(response.data.status == -1){
					layer.alert('数据查询失败或者数据为空');
				}
			},function errorCallback(reponse){
				layer.alert('服务器异常请稍后再试');
			});
			
			$scope.toSend = function (){
				layer.alert('表单提交');
			}
		});
	</script>
</body>
</html>