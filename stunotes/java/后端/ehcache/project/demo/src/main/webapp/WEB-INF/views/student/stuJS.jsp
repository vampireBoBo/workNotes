<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>	
<script type="text/javascript" >
  
	var app = angular.module('stu',[]);
	
	// 表单controller
	app.controller('listController',function($scope,$http){
		console.info('1===listController开始执行');
		$scope.item = [];
		// ============= 表单回调监听
		$scope.initData = function (){
			$http({
				method:'GET',
				url:'<%=request.getContextPath()%>/spring/student/manageData',
			}).then(function successCallback(response){
				if(response.data.status == 1){
					$scope.stuList = response.data.total;
					// 进行分页处理
					$scope.data = response.data.total;
					$scope.item = $scope.data;
					/* $scope.pageSize = 1;
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
					} */
				}
				if(response.data.status == -1){
					layer.alert('数据查询失败或者数据为空');
				}
			},function errorCallback(response){
				layer.alert("服务器异常请稍后再试");
			});
		}
		
		// 数据初始化
		$scope.initData();
		
		// 删除函数
		$scope.toDel = function (stu){
			layer.alert("确认是否删除？"+stu.sname,{icon:0,title:'温馨提示',btn:['确定','取消'],btn2:function(){
			}},function(){
				$http['delete']('<%=request.getContextPath()%>/spring/student/del/'+stu.id).success(function(data){
					console.info("处理结果："+data);
					if(data){
						location.reload();
						layer.msg('删除成功！');
					}
				}).error(function(data){
					layer.alert('服务器异常请稍后再试');
				});
				layer.closeAll();
			});
			
		}
		// 更新函数
		$scope.toUpd = function ($index){
			
		}
	});

	
	//============= 新增controller  
	app.controller('addController',function($scope,$http){
		console.info('2===addController开始执行');
		//对form表单的某个属性进行监听
		
		$scope.toAddStu = function (){
		 	// $scope.addForm.$valid  即可获得表单的校验
			 $scope.toAddStu = function (){
				// 执行新增
				$http({
					method:'POST',
					url:'<%=request.getContextPath() %>/spring/student/add',
					data:$scope.addStu,
				}).then(function successCallback(response){
					$('#addModal').modal('hide');
					if(response.data){
						layer.alert('数据添加成功！',{icon:6});
						// 刷新表单
						location.reload();
					}
				},function errorCallback(response){
					layer.alert("服务器异常请稍后再试");
				});
			 }
		 }
	});
	
	// ==============测试controller
	app.controller('testCon',function($scope,$http){
		console.info('3===testCon开始执行');
		$scope.addCli = function (){
			console.info('测试');
		}
	});
	
</script>  