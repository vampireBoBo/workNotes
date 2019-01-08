<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	    <meta name="renderer" content="webkit">
	    <meta name="keywords" content="" />
	    <meta name="description" content="" />
	    <meta name="generator" content="" />
	    <meta name="author" content="">
	    <title>pdf</title>
	    
	    <link href="<%=request.getContextPath() %>/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css" rel="stylesheet">
	    <link href="<%=request.getContextPath() %>/resources/plugin-bootstrap-table/bootstrap-table.css" type="text/css" rel="stylesheet">
	</head>
	<body>
		<div class="panel-body">
			<!-- 查询form -->
			<div class="panel panel-default">
				<div class="panel-heading">
					查询条件
				</div>
				<div class="panel-body">
					<form id="formSearch" class="form-horizontal">
						<div class="form-group">
							<label for="uid" class="col-sm-1 control-label">学号</label>
							<div class="col-sm-3">
								<input type="text" class="form-control" id="uid">
							</div>
							<label class="col-sm-1 control-label" for="name">姓名</label>
							<div class="col-sm-3">
								<input id="name" class="form-control" type="text">
							</div>
							<div class="col-sm-4">
								<button class="btn btn-primary" id="btn-query">查询</button>
							</div>
						</div>
					</form>
				</div>
			</div>
			<!-- 按钮组 -->
			<div id="toolbar" class="btn-group">
				<button id="btn_add" type="button" class="btn btn-default">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;新增
				</button>
				<button id="btn_edit" type="button" class="btn btn-default">
					<span class="glyphicon glyphicon-pencil"></span>&nbsp;修改 
				</button>
				<button id="btn_delete" type="button" class="btn btn-default">
					<span class="glyphicon glyphicon-trash"></span>&nbsp;删除
				</button>
			</div>
			<!-- 表单  -->
			<table id="sysTable"></table>
		</div>
		<script type="text/javascript" src="<%=request.getContextPath()%>/resources/jquery-1.9.1.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/resources/plugin-bootstrap-table/bootstrap-table.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/resources/plugin-bootstrap-table/locale/bootstrap-table-zh-CN.js"></script>
		<script type="text/javascript">
			var tab = $('#sysTable');
			$(function (){
				//1.初始化Table
			    var oTable = new TableInit();
			    oTable.Init();
				
			});
			var TableInit = function () {
			    var oTableInit = new Object();
			    //初始化Table
			    oTableInit.Init = function () {
			        $('#sysTable').bootstrapTable({
			            url: '<%=request.getContextPath()%>/student/list',         //请求后台的URL（*）
			            method: 'get',                      //请求方式（*）
			            toolbar: '#toolbar',                //工具按钮用哪个容器
			            striped: true,                      //是否显示行间隔色
			            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			            pagination: true,                   //是否显示分页（*）
			            sortable: false,                     //是否启用排序
			            sortOrder: "asc",                   //排序方式
			            queryParams: oTableInit.queryParams,//传递参数（*）
			            contentType:"application/x-www-form-urlencoded",
			            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
			            pageNumber:1,                       //初始化加载第一页，默认第一页
			            pageSize: 10,                       //每页的记录行数（*）
			            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
			            search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			            strictSearch: true,
			            showColumns: true,                  //是否显示所有的列
			            showRefresh: true,                  //是否显示刷新按钮
			            minimumCountColumns: 2,             //最少允许的列数
			            clickToSelect: true,                //是否启用点击选中行
			            height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
			            uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
			            showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
			            cardView: false,                    //是否显示详细视图
			            detailView: false,                   //是否显示父子表
			            columns: [{
			                checkbox: true
			            }, {
			                field: 'uid',
			                title: '学号'
			            }, {
			                field: 'name',
			                title: '姓名'
			            }, {
			                field: 'age',
			                title: '年龄'
			            }, {
			                field: 'gender',
			                title: '性别'
			            }, ]
			        });
			    };

			    //得到查询的参数
			   /*  oTableInit.queryParams = function (params) {
			        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
			            limit: params.limit,   //页面大小
			            offset: params.offset,  //页码
			            departmentname: $("#txt_search_departmentname").val(),
			            statu: $("#txt_search_statu").val()
			        };
			        return temp;
			    }; */
			    return oTableInit;
			};
		</script>
	</body>
</html>
