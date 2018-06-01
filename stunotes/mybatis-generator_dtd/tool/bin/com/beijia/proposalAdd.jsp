<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
function addPerson() {
	$('#jointlyPersonAdd').dialog('close');  
	$('#personList').datagrid({    
	    url:'jsp/personDeputy/proposalSuggest/personList.json',    
	    
	}); 
	$('#personNum').textbox('setValue','6');
}
function addOnePerson() {
	$('#jointlyOnePersonAdd').dialog('close'); 
	$('#name1').textbox('setValue','李四');
}
function addOnePerson1() {
	$('#jointlyOnePersonAdd1').dialog('close');  
	$('#name2').textbox('setValue','王五');
}
function selectPublic(val) {
	if(val == "3") {
		$("#summaryPublic").show();
		$("#openType").val("2");
	} else if(val == "1"){
		$("#summaryPublic").hide();
		$("#openType").val("0");
	} else if(val == "2"){
		$("#summaryPublic").hide();
		$("#openType").val("1");
	}
}
function openLcts(){
	$("#proposalImg").show();
	openDialog('proposalImg','流程图','','','900','600',true);
}
$(function(){
	//表单提交验证   
    $('#billAddForm').form({
        url:'insertObject_BillAction.action', 
        type:'post',
        onSubmit:function(){
            return $(this).form('validate');  
        },  
        success:function(data){
        	var result = eval('(' + data + ')');
        	 if (result.success){    
        		 alertMessage(result.message,"info"); 
             	 closeTab("新增议案", "proposalSuggestListNow");
             }else if(result.dataExist) { 
             	alertMessage(result.message,"info");
             }else{
             	//提示错误信息
             	showErrorInfo(result);
             } 
        },
        error:function(data){
        	var result = eval('(' + data + ')');
        	alertMessage(result.message,"warning"); 
        }
        
    });  
});
function billSubmit() {
	$("#billAddForm").submit();
}
</script>
<div style="padding:5px;">
	<form id="billAddForm"  class="easyui-form"  method="post" enctype="multipart/form-data">
		<input type="hidden" name="bill.conf_id" value="<s:property value="conferenceid.id" />" />
		<input type="hidden" id="openType" name="bill.opentype" value="0" />
		<input type="hidden" name="bill.checktype" value="0" />
		<input type="hidden" name="bill.del" value="0" />
		<input type="hidden" name="bill.th_id" value="<s:property value="conferenceid.th_id" />" />
		<input type="hidden" name="bill.connumber" value="<s:property value="conferenceid.connumber" />" />
	   	<table width="100%" class="tab" style="margin-bottom: 10px;">
	   		<tr>
	   			<th>会议名称：</th>
	   			<td colspan="3">
	   				<s:property value="conferenceid.th_Name" />第<s:if test="conferenceid.connumber==1">一</s:if><s:if test="conferenceid.connumber==2">二</s:if><s:if test="conferenceid.connumber==3">三</s:if><s:if test="conferenceid.connumber==4">四</s:if><s:if test="conferenceid.connumber==5">五</s:if>次会议
	   			</td>
	   			<th>起止时间：</th>
	   			<td>
	   				<s:property value="conferenceid.begintime" />至<s:property value="conferenceid.endtime" />
	   			</td>
	   		</tr>
	   		<tr>
	   			<th>案由：</th>
	   			<td colspan="5">
	   				<textarea name="bill.name"  data-options="required:true" style="width: 80%;height: 60px;" class="textarea easyui-validatebox" ></textarea>
	   			</td>
	   		</tr>
	   		<tr>
	   			<th>类型：</th>
	   			<td>
	   				<select required="required" name="bill.billtype" class="easyui-combobox"  data-options="url:'searchBillType_BillAction.action', valueField:'id',textField:'name'"  style="width: 150px;"></select>
	   			</td>
	   			<th>代表团：</th>
	   			<td>
	   				<s:property value="cuser.rpsentName" />
	   			</td>
	   			<th>提议案领衔人：</th>
	   			<td>
	   				<input type="hidden" name="bill.billuser_id"  value="<s:property value="cuser.id" />" />
	   				<input id="name1" value="<s:property value="cuser.child_name" />" data-options="required:true" readonly="readonly" class="easyui-textbox" />
	   				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="openDialog('jointlyOnePersonAdd','选择领衔人','jsp/personDeputy/proposalSuggest/jointlyOnePersonAdd.jsp','','600','400',true)">选择</a>
	   			</td>
	   		</tr>
	   		<tr>
	   			<th>联系人姓名：</th>
	   			<td>
	   				<input type="hidden"  name="bill.user_id" value="<s:property value="cuser.id" />" />
	   				<input id="name2" value="<s:property value="cuser.child_name" />" data-options="required:true" readonly="readonly" class="easyui-textbox" />
	   				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="openDialog('jointlyOnePersonAdd1','选择联系人','jsp/personDeputy/proposalSuggest/jointlyOneNamePersonAdd.jsp','','600','400',true)">选择</a>
	   			</td>
	   			<th>联系电话：</th>
	   			<td>
	   				<input data-options="required:true" value="<s:property value="cuser.rpsentPhone" />" class="easyui-textbox" />
	   			</td>
	   		</tr>
	   		<tr>
	   			<th>上传附件：</th>
	   			<td  colspan="5">
	   				<input name="file" type="file" /><img style="width:20px; height:20px;" src="images/doc.png"/>关于陕西省环保问题议案
	   			</td>
		   	</tr>
	   		<tr>
	   			<th>是否公开：</th>
	   			<td colspan="5">
	   				<input type="radio" name="isPublic" checked="checked" onclick="selectPublic(1)" >&nbsp;&nbsp;不公开&nbsp;&nbsp;
	   				<input type="radio" name="isPublic" onclick="selectPublic(2)" >&nbsp;&nbsp;公开&nbsp;&nbsp;
	   				<input type="radio" name="isPublic" onclick="selectPublic(3)" >&nbsp;&nbsp;摘要公开&nbsp;&nbsp;
	   			</td>
	   		</tr>
	   		<tr id="summaryPublic" style="display: none;">
	   			<th>摘要信息：</th>
	   			<td colspan="5">
	   				<textarea id="summaryPublicText" style="width: 99%;height: 60px;" class="textarea easyui-validatebox" ></textarea>
	   			</td>
	   		</tr>
	   	</table>
			<table id="personList" style="" class="easyui-datagrid" title="联名提议案人"
				  checkOnSelect="true" singleSelect="false"
				data-options="
							striped:true,
							rownumbers:true,
							animate:true,
							singleSelect:false,
							toolbar:'#rpsent_toolBar',
							url:'',
							method:'post'
							">
				<thead>
					<tr>
						<th field="bookIndex_ck" checkbox="true"></th>
						<th data-options="field:'name',resizable:true" sortable="true"
							width="20%">代表姓名</th>
						<th data-options="field:'rpsentNo',resizable:true" sortable="true"
							width="15%">代表证号码</th>
						<th data-options="field:'mission',resizable:true" sortable="true"
							width="15%">代表团</th>	
						<th data-options="field:'address',resizable:true" sortable="true"
							width="30%">通讯地址和邮政编码</th>
						<th data-options="field:'tel',resizable:true" sortable="true"
							width="15%">电话号码</th>	
					</tr>
				</thead>
			</table>
			<div id="rpsent_toolBar">
				<div style="margin-bottom: 5px">
					<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="openDialog('jointlyPersonAdd','添加联名提议案人','jsp/personDeputy/proposalSuggest/jointlyPersonAdd.jsp','','600','400',true)">新增</a>
					<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteObjects('bookIndex','url');">删除</a>
				</div>
			</div>
		  <div style="text-align: right; height: 33px;padding-top:5px;margin-top: 10px;">
			  <div style="float: left;height: 28px;line-height:28px;text-align: left;">
				<span style="font-weight: bold;">流程说明:</span>
				人大代表提交议案——>议案组审核——>专门委员会处理议案——>议案组接收处理结果——>大会主席团决定议案——>专门委员会办理议案
				<a href="javascript:openLcts()" style="margin-left: 20px;color: #4a7ec7">查看流程图</a>
			  </div>
		   	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="billSubmit()">保存并提交</a>
		   	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="">保存</a>
		</div>
	</form>	
</div>
<div id="jointlyPersonAdd"></div>
<div id="jointlyOnePersonAdd"></div>
<div id="jointlyOnePersonAdd1"></div>
<!-- 流程图-->
<div id="proposalImg" style="display: none;">
	<img src="images/proposal.png">
</div>
