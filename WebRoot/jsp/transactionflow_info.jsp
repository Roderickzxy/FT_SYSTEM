<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>转账</title>
<link type="text/css" rel="stylesheet" href="../css/main.css"/>
<link rel="stylesheet" type="text/css" href="../jquery-easyui-1.4/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../jquery-easyui-1.4/themes/icon.css">
<script type="text/javascript" src="../js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="../jquery-easyui-1.4/jquery.easyui.min.js"></script>
<style type="text/css">
body{width:100%;height:100%;background-color: #FFFFFF;text-align: center;}
.input_txt{width:200px;height:20px;line-height:20px;}
.info{height:40px;line-height:40px;}
.info th{text-align: right;width:95px;color: #4f4f4f;padding-right:5px;font-size: 13px;}
.info td{text-align:left;}
</style>
</head>
<body>
	<form action="save.html" name="transactionflowForm" id="transactionflowForm" target="result" method="post" onsubmit="return checkInfo();">
		<input type="hidden" name="id" id="id" value="${transactionflow.id }"/>
	<table border="0" cellpadding="0" cellspacing="0">
		<tr class="info">
			<th>银行名称:</th>
			<td><%-- <input type="text" name="bankname" id="bankname" class="input_txt" value="${transactionflow.bankname }"/> --%>
			<select name="bankname" id="bankname" class="input_txt">
				<option value="">请选择</option>
				<option value="中行存管">中行存管</option>
				<option value="工行存管">工行存管</option>
				<option value="农行存管">农行存管</option>
				<option value="建行存管">建行存管</option>
				<option value="招行存管">招行存管</option>
				<option value="交行存管">交行存管</option>
				<option value="中信存管">中信存管</option>
				<option value="光大存管">光大存管</option>
				<option value="浦发存管">浦发存管</option>
				<option value="兴业存管">兴业存管</option>
				<option value="广发存管">广发存管</option>
				<option value="平安存管">平安存管</option>
			</select>
			</td>
		</tr>
		<tr class="info">
			<th>操作:</th>
			<td>
			<select name="operate" id="operate" class="input_txt">
				<option value="">请选择</option>
				<option value="银行转证券">银行转证券</option>
				<option value="证券转银行">证券转银行</option>
				<option value="查银行余额">查银行余额</option>
			</select>
			</td>
		</tr>
		<tr class="info">
			<th>货币单位:</th>
			<td>
			<select name="curtype" id="curtype" class="input_txt">
				<option value="">请选择</option>
				<option value="人民币">人民币</option>
				<option value="美元">美元</option>
				<option value="港元">港元</option>
			</select>
			</td>
		</tr>
		<tr class="info">
			<th>转账金额:</th>
			<td><input type="text" name="amount" id="amount" class="input_txt" value="${transactionflow.amount }"/></td>
		</tr>
		<tr class="info">
			<th>密码:</th>
			<td><input type="hidden" name="jypassword" id="jypassword" class="input_txt" value="${accountinfo.jypassword}"/>
			   <input type="password" name="password" id="password" class="input_txt" value=""/></td>
		</tr>
	</table>
	</form>
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	
	<script type="text/javascript" src="../js/jquery-1.5.1.min.js"></script>
	<script type="text/javascript">
		var dg;
		$(document).ready(function(){
			dg = frameElement.lhgDG;
			dg.addBtn('ok','保存',function(){
				$("#transactionflowForm").submit();
			});
		});
		
		  function ww4(date){  
            var y = date.getFullYear();  
            var m = date.getMonth()+1;  
            var d = date.getDate();  
            return  y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d)+'';  
              
        } 
        function w4(s){  
            var reg=/[\u4e00-\u9fa5]/  //利用正则表达式分隔 
            var ss1 = s.replace("[","").replace("]","");
            var ss = (ss1.split("-"));  
            var y = parseInt(ss[0],10);  
            var m = parseInt(ss[1],10);  
            var d = parseInt(ss[2],10);   
            if (!isNaN(y) && !isNaN(m) && !isNaN(d)){  
                return new Date(y,m-1,d);  
            } else {  
                return new Date();  
            }  
        }  
		
		function checkInfo(){
			/* if($("#bankname").val()==""){
				alert("请输入银行名称!");
				$("#bankname").focus();
				return false;
			} */var options=$("#bankname option:selected");
			if($("#bankname").val()==""){
				alert("请选择银行!");
				$("#bankname").focus();
				return false;
			}
		   if(isNaN($("#amount").val())){
				alert("请输入正确的转账金额!");
				$("#amount").focus();
				return false;
			}
			/* if($("#mobile").val()==""){
				alert("请输入手机号码!");
				$("#mobile").focus();
				return false;
			}
			if($("#wechat").val()==""){
				alert("请输入微信号!");
				$("#wechat").focus();
				return false;
			} */
			/* if($("#idCardNum").val()==""){
				alert("请输入身份证号码!");
				$("#idCardNum").focus();
				return false;
			} */
			var options=$("#operate option:selected");
			if($("#operate").val()==""){
				alert("请选择操作!");
				$("#operate").focus();
				return false;
			}
			var options=$("#curtype option:selected");
			if($("#curtype").val()==""){
				alert("请选择货币单位!");
				$("#curtype").focus();
				return false;
			}
			
			 if($("#password").val()==""){
				alert("请输入密码!");
				$("#password").focus();
				return false;
			} 
			
			if($("#password").val()!=""){
			    if($("#jypassword").val()!=$("#password").val()){
				   alert("密码错误!");
				   $("#password").focus();
				   return false;
			        } 
			   }else{
			   alert("请输入密码!");
				$("#password").focus();
				return false;
			   }
			/* if($("#birth").val()==""){
				alert("请选择生日!");
				$("#birth").focus();
				return false;
			} */
			
			/* if($("#emergencyContact").val()==""){
				alert("请输入紧急联络人!");
				$("#emergencyContact").focus();
				return false;
			}
			if($("#emergencyMobile").val()==""){
				alert("请输入紧急联络电话!");
				$("#emergencyMobile").focus();
				return false;
			} */
			return true;
		}
		
		function success(){
			if(dg.curWin.document.forms[0]){
				dg.curWin.document.forms[0].action = dg.curWin.location+"";
				dg.curWin.document.forms[0].submit();
			}else{
				dg.curWin.location.reload();
			}
			dg.cancel();
		}
		
		/*
		function failed(){
			alert("新增失败，该用户名已存在！");
			$("#loginname").select();
			$("#loginname").focus();
		}
		*/
	</script>
</body>
</html>