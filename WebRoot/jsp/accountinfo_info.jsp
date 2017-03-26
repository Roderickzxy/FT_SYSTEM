<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>账户信息</title>
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
		<input type="hidden" name="id" id="id" value="${accountinfo.id }"/>
		<%-- <input type="hidden" name="user.userId" id="user.userId" value="${customer.user.userId }"/> --%>
<%-- 	<input type="hidden" name="customerid" id="accountinfoid" value="${accountinfo.customer.id}"/>
 --%>	<input type="hidden" name="userid" id="accountinfouserid" value="${accountinfo.user.userId}"/>
	<table border="0" cellpadding="0" cellspacing="0">
		<tr class="info">
			<th>客户:</th>
			<td>
				<select name="customerid" id="customer" style="vertical-align: middle;width: 100px;">
			<option value="" selected>请选择</option>
			</select></td>
		</tr>
		<tr class="info">
			<th>客户佣金:</th>
			<td>
			<select name="khyj" id="khyj" class="input_txt">
				<option value="">请选择</option>
				<option value="0.3%">0.3%</option>
				<option value="0.6%">0.6%</option>
				<option value="0.02%">0.02%</option>
				<option value="0.03%">0.03%</option>
				<option value="0.06%">0.06%</option>
			</select></td>
		</tr>
		<tr class="info">
			<th>三方存管:</th>
			<td><select name="sfck" id="sfck" class="input_txt">
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
			</select></td>
		</tr>
			<tr class="info">
			<th>资金密码:</th>
			<td><input type="password" name="zjpassword" id="zjpassword" class="input_txt" value="${accountinfo.zjpassword }"/></td>
		</tr>
		<tr class="info">
			<th>交易密码:</th>
			<td><input type="password" name="jypassword" id="jypassword" class="input_txt" value="${accountinfo.jypassword }"/></td>
		</tr>
	<%-- 	<tr class="info">
			<th>发生日期:</th>
			<td>
			<input class="easyui-datebox" data-options="formatter:ww4,parser:w4" name="operatedate" id="operatedate" value="${accountinfo.operatedate  }" style="width: 200px"></input>
			</td>
		</tr> --%>
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
			/* 	$("#account").attr("readonly","readonly");
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
				} */
			}
			
				var accountinfoid = $("#accountinfoid").val();
			$.ajax({
			    type:'post', 
  				url: 'getCustomerJSON.html',
  				dataType: 'json',
  				async : false, //默认为true 异步
  				//data: data,
  				success: function(data){
  				  for(var i=0;i<data.length;i++){
  				  if(accountinfoid!=null && (data[i].id == accountinfoid)){
  				  $("#customer").append("<option value='"+data[i].id+"' selected>"+data[i].name+"</option>");
  				  }else{
  				   $("#customer").append("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
  				  }
				  }
  				}
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
			var options=$("#customer option:selected");
			if($("#customer").val()==""){
				alert("请选择客户!");
				$("#customer").focus();
				return false;
			}
			var options=$("#khyj option:selected");
			if($("#khyj").val()==""){
				alert("请选择客户佣金!");
				$("#khyj").focus();
				return false;
			}
			var options=$("#sfck option:selected");
			if($("#sfck").val()==""){
				alert("请选择三方存管!");
				$("#sfck").focus();
				return false;
			}
			if( $("#zjpassword").val()==""){//新增
				alert("请输入资金密码!");
				$("#zjpassword").focus();
				return false;
			}
			if($("#jypassword").val()==""){
				alert("请输入交易密码!");
				$("#jypassword").focus();
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