<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="section-box section-box__jg" style="height: 666px;">
  <!--首页标题部分-->
  <div class="section-head-box ">
    <div class="section-box-1280">
      <div class="section-head-title"> <h2>服务开通</h2> </div><!--/ .section-head-box-->
    </div>
  </div><!--/. section-head-box -->
  <!-- tab按钮 -->
  <div class="section-body-box" >
    <div class="section-bb-wrap section-box-1280">
    	<dl class="zwy-tab-box" id="zwy-tab-box">
    		<dt class="zwy-tab__hd f-clear">
	          <h3><a href="javascript:;">新增资源</a></h3>
	          <h3><a href="javascript:;">获取资源</a></h3>
	        </dt><!--/ .zwy-tab__hd -->
    		<dd class="zwy-tab__bd">
    			<!-- 第一个tab信息 -->
         		<div class="zwy-tab__bd-mod">
         			<form id="form1"  action="" method="post" data-validator-option="{timely:3, theme:'mhb_right',focusCleanup:true}" >
					      <div class="zwy-fpanel-box">
								<c:forEach items="${assignvdcEc.vdcEcSubLists}" var="vdcEcSub">
							        <!-- 如果大型Linux6虚拟机存在，展现该内容 -->
							          <div class="zwy-fpanel">
							            <div class="zwy-fp-hd">
							            <h2>
							   			 ${vdcEcSub.title}
							            <c:if test="${vdcEcSub.ec_type=='1'}">大型 </c:if>   
							            <c:if test="${vdcEcSub.ec_type=='2'}">中型</c:if>   
							            <c:if test="${vdcEcSub.ec_type=='3'}">小型</c:if> 
							               ${vdcEcSub.ostype} ${vdcEcSub.ec}台</h2></div><!--/ .zwy-fp-hd --> 
							            <div class="zwy-fp-bd">
							            	<div class="zwy-tabmod-form" style="width:100%">
							            	  <!-- 1行多列 -->
								            	<c:forEach items="${assignvdcEc.assignvdcEcLists}" var="assignvdc" varStatus="s">
								            		<c:if test="${vdcEcSub.id == assignvdc.subId}">
										            	<div class="mhbui-form-item"> 
										            	   <div class="mhbui-inline">
										                  <%-- <input type="hidden" name ="id" value="${assignvdc.id}">  --%>
										                    <label class="mhbui-form-label">虚拟机ID</label>
										                    <div class="mhbui-input-inline">
										                    	<input class="mhbui-input" placeholder="请输入ID" name="cloudecid" type="text" id="cloudecid_${s.index}"  data-rule="required;remote(<%=request.getContextPath()%>/spring/assignvdc/checkCloudecid);" value="${assignvdc.cloudecid}" />
									                    	</div>
										                  </div>   
										            	 <!-- 1块，如1行有多列，加块即可 -->
										                  <div class="mhbui-inline">
										                    <input type="hidden" name ="id" value="${assignvdc.id}"> 
										                    <label class="mhbui-form-label">IP</label>
										                    <div class="mhbui-input-inline">
										                    	<input class="mhbui-input" placeholder="请输入IP" name="ip" type="text" id="ip_${s.index}" value="${assignvdc.ip}" />
									                    	</div>
										                  </div>
										                  <div class="mhbui-inline">
										                    <label class="mhbui-form-label">用户名</label>
										                    <div class="mhbui-input-inline">
										                    	<input class="mhbui-input" placeholder="请输入用户名" name="loginuser" type="text" id="loginuser_${s.index}" value="${assignvdc.loginuser}" />
										                    </div>
										                  </div>
										                  <div class="mhbui-inline">
										                    <label class="mhbui-form-label">密码</label>
										                    <div class="mhbui-input-inline">
										                    	<input class="mhbui-input" placeholder="请输入密码" name="loginpwd" type="text" id="loginpwd_${s.index}" value="${assignvdc.loginpwd}" />
									                    	</div>
										                  </div>
										                </div>
								            		</c:if>
								            		
								            	</c:forEach>
							            	</div>
							            </div> 
							          </div><!--/ .zwy-fpanel -->
								</c:forEach>
					    
					          <div class="mhbui-form-btns zwy-fbtns">
					            <div class="f-tc ">
					                <a href="javascript:;" id="tj" class="mhbui-btn mhbui-btn-normal"  onclick="doSubmit('2');">提交</a>
					            	<a href="javascript:;" id="bc" class="mhbui-btn mhbui-btn-normal"  onclick="doSubmit('1');">保存</a>            	
					            </div>
					          </div>      
					      </div>
					     </form>
         		</div>
         		<!-- 第二个tab信息 -->
         		<div class="zwy-tab__bd-mod">
         			<div class="zwy-tabmod-form zwy-tabmod-form__custom zwy-cform__vdc">
         				
	         			<div class="mhbui-form-btns">
			                <div class="f-tc "><a href="javascript:;" class="mhbui-btn mhbui-btn-normal"  onclick="goPageForURL('pages/nrlb.html');">获取资源</a></div>
			            </div>
			        </div>
         		</div>
         	</dd>
    </div><!--/ .section-bb-wrap -->
  </div><!--/ .section-body-box -->
  <a id="goPageTop" class="goto-page-top" href="javascript:;"><i class="iconfont">&#xe648;</i></a>
</div><!--/ .section-box -->
<script type="text/javascript">
	/* 页面加载完毕 执行匿名函数 */
	$(function (){
		 $(document.body).css({'background-color':'#e6e6e6'});
		    $("#zwy-tab-box").slide({ titCell:".zwy-tab__hd h3", mainCell:".zwy-tab__bd",autoPlay:false,trigger:'click',effect:"fade",delayTime:300 ,defaultIndex:0});
		    //初始化 icheck
		    $('.ickbox').iCheck({
		      checkboxClass: 'icheckbox_square-blue',
		      radioClass: 'iradio_square-blue',
		      increaseArea: '20%'
		  });
		    
	});
	/* 新增资源提交 */
	function doSubmit(type){
		//保存或提交 只能点击一次 
		if(type==='1'){
			var _this = $('#bc');
	     	_this.addClass('mhbui-disabled');
	     	if(!_this.hasClass('mhbui-disabled')){
	   		  return false;
	  	  	}
		}else if(type==='2'){
			var _this = $('#tj');
	     	_this.addClass('mhbui-disabled');
	     	if(!_this.hasClass('mhbui-disabled')){
	   		  return false;
	  	  	}
		}
		var _jsonSub = [];
		$(".mhbui-form-item").each(function (){
			var _this = $(this);
			var _ip = _this.find("input[name='ip']").val();
			var _loginuser=_this.find("input[name='loginuser']").val();
			var _loginpwd=_this.find("input[name='loginpwd']").val();
			var _id=_this.find("input[name='id']").val();
			var _cloudecid=_this.find("input[name='cloudecid']").val();
			var message={
					id:_id,
					ip : _ip,
					loginuser: _loginuser,
					loginpwd:_loginpwd,
					cloudecid:_cloudecid
			}
			_jsonSub.push(message);
		});
		console.info(_jsonSub) ;
		var url="<%=request.getContextPath()%>/spring/assignvdc/savemessage";
		$.ajax({
			type:"POST",//提交数据的类型 POST GET      
	 		url:url,  //提交的网址据
            data:JSON.stringify({   
            	jsonsub:_jsonSub
         	}), //提交的数
            //返回数据的格式
            contentType:"application/json; charset=UTF-8",
            dataType: "json",//"xml", "html", "script", "json", "jsonp", "text".
            //成功返回之后调用的函数         
            success:function(data){
            	
            	if(data){
            		if(type == '2'){
            		 	doComplete();
	       			}else{
	           			alert("数据保存成功");
	    	            //location.href="<%=request.getContextPath()%>/index.jsp#pages/home.jsp"; 
	    	            closeWindow();
	     			}
            	}else{
            		alert(data);
            		alert("保存数据失败");
            	}
            } ,
         
            //调用出错执行的函数
            error: function(){
                //请求出错处理
                alert("保存数据失败");
            } 
		});
  	}

	function doComplete(){
		var url="<%=request.getContextPath()%>/spring/assignvdc/complete";
		$.ajax({
			type:"POST",//提交数据的类型 POST GET      
	 		url:url,  //提交的网址据
            data:JSON.stringify({   
            	taskId:'${taskId}',
            	id:'${assignvdcEc.id}'
         	}), //提交的数
            contentType:"application/json; charset=UTF-8",
            dataType: "json",
            success:function(data){
            	if(data.state == 0 || data.state == '0'){
            		alert("任务办理成功");
            		  location.href="<%=request.getContextPath()%>/index.jsp#pages/home.jsp"; 
            		  //closeWindow();
            	}else{
            		alert("任务办理失败");     
            	}
            } ,
            error: function(){
                //请求出错处理
                alert("任务请求失败！");
            } 
		});
	}
	
	//关闭窗口
	function closeWindow(){
	if (navigator.userAgent.indexOf("MSIE") > -1) {
	    if (navigator.userAgent.indexOf("MSIE 6.0") > -1) {
	      window.opener = null;
	      window.close();
	    } else {
	      window.open('', '_top');
	      window.top.close();
	    }
	  }
	  else if (navigator.userAgent.indexOf("Firefox") > -1) {
	    window.location.href = 'about:blank';
	  } else {
	    window.opener = null;
	    window.open('', '_self', '');
	    window.close();
	  }
	}
	
</script>

