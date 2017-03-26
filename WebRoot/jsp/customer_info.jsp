<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户信息</title>
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
	<form action="save.html" name="customerForm" id="customerForm" target="result" method="post" onsubmit="return checkInfo();">
		<input type="hidden" name="id" id="id" value="${customer.id }"/>
		<input type="hidden" name="user.userId" id="user.userId" value="${customer.user.userId }"/>
	<table border="0" cellpadding="0" cellspacing="0">
		<tr class="info">
			<th>客户编号:</th>
			<td><input type="text" name="account" id="account" class="input_txt" value="${customer.account }"/></td>
		</tr>
		<tr class="info">
			<th>姓名:</th>
			<td><input type="text" name="name" id="name" class="input_txt" value="${customer.name }"/></td>
		</tr>
		<tr class="info">
			<th>密　码:</th>
			<td><input type="password" name="password" id="password" class="input_txt" value="${customer.password }"/></td>
		</tr>
		<tr class="info">
			<th>确认密码:</th>
			<td><input type="password" name="chkpwd" id="chkpwd" class="input_txt" value="${customer.password }"/></td>
		</tr>
		<tr class="info">
			<th>手机号码:</th>
			<td><input type="text" name="mobile" id="mobile" class="input_txt" value="${customer.mobile }"/></td>
		</tr>
		<tr class="info">
			<th>邮箱:</th>
			<td><input type="text" name="email" id="email" class="input_txt" value="${customer.email }"/></td>
		</tr>
		<tr class="info">
			<th>地址:</th>
			<td><input type="text" name="address" id="address" class="input_txt" value="${customer.address }"/></td>
		</tr>
		<tr class="info">
			<th>职业代码:</th>
			<td><input type="text" name="jobcode" id="jobcode" class="input_txt" value="${customer.jobcode }"/></td>
		</tr>
		<tr class="info">
			<th>学历代码:</th>
			<td><input type="text" name="xlcode" id="xlcode" class="input_txt" value="${customer.xlcode }"/></td>
		</tr>
			<tr class="info">
			<th>证件类型:</th>
			<td>
			<select name="idCardType" id="idCardType" class="input_txt">
				<option value="">请选择</option>
				<option value="身份证">身份证</option>
			<!-- 	<option value="学生证">学生证</option> -->
			</select>
			</td>
		</tr>
		<tr class="info">
			<th>身份证号码:</th>
			<td><input type="text" name="idCardNum" id="idCardNum" class="input_txt" value="${customer.idCardNum }"/></td>
		</tr>
		<tr class="info">
			<th>出生年月:</th>
			<td>
			<input class="easyui-datebox" data-options="formatter:ww4,parser:w4" name="birth" id="birth" value="${customer.birth  }" style="width: 200px"></input>
			</td>
		</tr>
		<tr class="info">
			<th>性  别:</th>
			<td>
			<select name="sex" id="sex" class="input_txt">
				<option value="">请选择</option>
				<option value="1">男</option>
				<option value="2">女</option>
			</select>
			</td>
		</tr>
		<tr class="info">
			<th>紧急联络人:</th>
			<td><input type="text" name="emergencyContact" id="emergencyContact" class="input_txt" value="${customer.emergencyContact }"/></td>
		</tr>
		<tr class="info">
			<th>紧急联络电话:</th>
			<td><input type="text" name="emergencyMobile" id="emergencyMobile" class="input_txt" value="${customer.emergencyMobile }"/></td>
		</tr>
		<tr class="info">
			<th>开户机构:</th>
			<td><input type="text" name="signcenter" id="signcenter" class="input_txt" value="${customer.signcenter }"/></td>
		</tr>
			<tr class="info">
			<th>风险等级:</th>
			<td>
			<select name="fxlever" id="fxlever" class="input_txt">
				<option value="">请选择</option>
				<option value="稳健型">稳健型 </option>
				<option value="保守型">保守型</option>
				<option value="进取型">进取型</option>
			</select>
			</td>
		</tr>
				<tr class="info">
			<th>开户日期:</th>
			<td>
			<input class="easyui-datebox" data-options="formatter:ww4,parser:w4" name="opendate" id="opendate" value="${customer.opendate  }" style="width: 200px"></input>
			</td>
		</tr>
			<tr class="info">
			<th>风险测评日:</th>
			<td>
			<input class="easyui-datebox" data-options="formatter:ww4,parser:w4" name="fxcpdate" id="fxcpdate" value="${customer.fxcpdate  }" style="width: 200px"></input>
			</td>
		</tr>
			<tr class="info">
			<th>风险到期日:</th>
			<td>
			<input class="easyui-datebox" data-options="formatter:ww4,parser:w4" name="fxdqdate" id="fxdqdate" value="${customer.fxdqdate  }" style="width: 200px"></input>
			</td>
		</tr>
		<%-- <tr class="info">
			<th>账户:</th>
			<td><input type="text" name="cashaccount" id="cashaccount" class="input_txt" value="${customer.cashaccount }"/></td>
		</tr> --%>
			<tr class="info">
			<th>沪股东代码:</th>
			<td><input type="text" name="hucode" id="hucode" class="input_txt" value="${customer.hucode }"/></td>
		</tr>	<tr class="info">
			<th>深股东代码:</th>
			<td><input type="text" name="shencode" id="shencode" class="input_txt" value="${customer.shencode }"/></td>
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
				$("#customerForm").submit();
			});
			if($("#id").val()!=""){
				$("#account").attr("readonly","readonly");
				$("#account").css("color","gray");
				var sex = "${houseHirer.sex}";
				if(sex!=""){
					$("#sex").val(sex);
				}
				var fxlever = "${customer.fxlever}";
				if(fxlever!=""){
					$("#fxlever").val(fxlever);
				}
				var idCardType = "${customer.idCardType}";
				if(idCardType!=""){
					$("#idCardType").val(idCardType);
				}
			}
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
			if($("#name").val()==""){
				alert("请输入姓名!");
				$("#name").focus();
				return false;
			}
			if($("#id").val()=="" && $("#password").val()==""){//新增
				alert("请输入密码!");
				$("#password").focus();
				return false;
			}
			if($("#password").val()!=$("#chkpwd").val()){
				alert("请确认密码!");
				$("#password").focus();
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
			var options=$("#sex option:selected");
			if($("#sex").val()==""){
				alert("请选择性别!");
				$("#sex").focus();
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