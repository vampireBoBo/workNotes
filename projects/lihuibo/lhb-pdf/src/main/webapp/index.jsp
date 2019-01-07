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
	    
	    <link href="<%=request.getContextPath() %>/resources/bootstrap/bootstrap.min.css" type="text/css" rel="stylesheet"> 
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<table id="sysTable"></table>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="<%=request.getContextPath()%>/resources/jquery-1.9.1.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/resources/bootstrap/bootstarp.min.js"></script>
		<script type="text/javascript">
			var tab = $('#sysTable');
			$(function (){
				// 表格初始化
				tab.bootstrapTable({
					cache:false,
					striped:true,
					classes:'table',
					pagination:false,
					paginationLoop:false,
					silePagination:"server",
					columns:[
					         {field:'uid',title:'学号',halign:'center',align:'center'},
					         {field:'name',title:'姓名',halign:'center',align:'center'},
					         {field:'',title:'操作',halign:'center',align:'center',formatter:function(value, row, index){
					        	 return '<a href="#">导出</a>';
					         }}
					         ]
				});
				
				// 查询数据
				loadTableDatas();
			});
			function loadTableDatas(){
				$.get('<%=request.getContextPath()%>/student/list',
						null,function (_d){
					    if(_d.code==200){
					    	bsTable.bootstrapTable('load', {
								"total": _d.obj,
								"rows":_d.obj.size
							});
							// 子页面高度自适应
						    window.parent.addHeight();
						}else{
							layer.msg("系统异常",{icon: 2});
							// 子页面高度自适应
						    window.parent.iFrameHeight();
						}
					},'json'
				);
			}
		</script>
	</body>
</html>
