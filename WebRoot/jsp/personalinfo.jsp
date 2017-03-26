<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改个人信息</title>
<link type="text/css" rel="stylesheet" href="<%=basePath%>css/main.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>jquery-easyui-1.4/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>jquery-easyui-1.4/themes/icon.css">
<script type="text/javascript" src="<%=basePath%>js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="<%=basePath%>jquery-easyui-1.4/jquery.easyui.min.js"></script>
<style type="text/css">
body{width:80%;height:100%;background-color: #FFFFFF;text-align: left;}
.input_txt{width:200px;height:20px;line-height:20px;}
.info{height:40px;line-height:40px;}
.info th{text-align: right;width:80px;color: #4f4f4f;padding-right:5px; font-size: 13px;}
.info td{text-align:left;}
tr{margin-bottom:5px;}
</style>

<script>
/* function getLng(){
var address = $("#propertyAddr").val(); */
/* if(address!=null){
$.ajax({
	type:'post', 
	url: "getAddressJWJSON.html?address='"+address+"'",
	dataType: 'json',
	async : false, //默认为true 异步
	//data: data,
	success: function(data){
	 var longitude = data[0].lng;
	 var latitude = data[0].lat;
	 $("#longitude").val(longitude);
	 $("#latitude").val(latitude);
	  }
	});	
	}
}; */
</script>
</head>
<body>
	<form  action="/dgzf/personalinfo/save.html" name="customerForm" id="customerForm" target="result" method="post" onsubmit="return checkInfo();">
		<input type="hidden" name="id" id="id" value="${customer.id }"/>
		<input type="hidden" name="user.userId" id="user.userId" value="${customer.user.userId }"/>
<table width="700" border="0" cellpadding="10px">
  <tbody>
    <tr>
      <td align="right" valign="middle">客户编号</td>
      <td align="left" valign="middle">
      <input type="text" name="account" id="account"  value="${customer.account }" onblur="" readonly="readonly" width="600px"/>
      </td>
      <td align="right" valign="middle">姓名</td>
      <td align="left" valign="middle">
      <input type="text" name="name" id="name"  value="${customer.name }" onblur="" width="600px"/>
      </td>
    </tr>
     <tr>
      <td align="right" valign="middle">密码</td>
      <td  align="left" valign="middle">
      <input type="password" name="password" id="password"  value="${customer.password }" onblur=""/>
      </td>
       <td align="right" valign="middle">确认密码</td>
      <td  align="left" valign="middle">
      <input type="password" name="chkpwd" id="chkpwd"  value="${customer.password }" onblur=""/>
      </td>
     </tr>
    <tr>
      <td align="right" valign="middle">手机号码</td>
      <td align="left" valign="middle"><input type="text" name="mobile" id="mobile"  value="${customer.mobile }"/>
       </td>
      <td align="right" valign="middle">邮箱</td>
      <td align="left" valign="middle"><input type="text" name="email" id="email"  value="${customer.email }"/></td>
    </tr>
    <tr>
      <td align="right" valign="middle">地址</td>
      <td align="left" valign="middle"><input type="text" name="address" id="address"  value="${customer.address }"/></td>
      <td align="right" valign="middle">职业代码</td>
      <td align="left" valign="middle"><input type="text" name="jobcode" id="jobcode"  value="${customer.jobcode }"/></td>
    </tr>
     <tr>
      <td align="right" valign="middle">学历代码</td>
      <td align="left" valign="middle"><input type="text" name="xlcode" id="xlcode"  value="${customer.xlcode }"/></td>
      <td align="right" valign="middle">证件类型</td>
      <td align="left" valign="middle"><select name="idCardType" id="idCardType" >
							<option value="">请选择</option>
							<option value="身份证">身份证</option>
					<!-- 		<option value="学生证">学生证</option> -->
						</select></td>   
	</tr>
    <tr>
      <td align="right" valign="middle">身份证号码</td>
      <td align="left" valign="middle"><input type="text" name="idCardNum" id="idCardNum" readonly="readonly" value="${customer.idCardNum }"/></td>
      <td align="right" valign="middle">出生年月</td>
      <td align="left" valign="middle"><input class="easyui-datebox" data-options="formatter:ww4,parser:w4" name="birth" id="birth" value="${customer.birth  }" style="width: 200px"></input>
	</td>
    </tr>
    <tr>
      <td align="right" valign="middle">性别</td>
      <td align="left" valign="middle"><select name="sex" id="sex" >
							<option value="">请选择</option>
				            <option value="1">男</option>
				            <option value="2">女</option>
						</select>			
	  </td>
     <td align="right" valign="middle">紧急联络人</td>
     <td align="left" valign="middle"><input type="text" name="emergencyContact" id="emergencyContact"  value="${customer.emergencyContact }"/></td>
    </tr>
    <tr>
     <td align="right" valign="middle">紧急联络电话</td>
     <td align="left" valign="middle"><input type="text" name="emergencyMobile" id="emergencyMobile"  value="${customer.emergencyMobile }"/></td>
      <td align="right" valign="middle">开户机构</td>
     <td align="left" valign="middle"><input type="text" name="signcenter" id="signcenter"  readonly="readonly" value="${customer.signcenter }"/></td>
   
    </tr>
   <tr>
     <td align="right" valign="middle">开户日期</td>
     <td align="left" valign="middle"><input class="easyui-datebox" readonly="readonly" data-options="formatter:ww4,parser:w4" name="opendate" id="opendate" value="${customer.opendate  }" style="width: 200px"></input>
     <td align="right" valign="middle">风险测评日</td>
     <td align="left" valign="middle"><input class="easyui-datebox" readonly="readonly" data-options="formatter:ww4,parser:w4" name="fxcpdate" id="fxcpdate" value="${customer.fxcpdate  }" style="width: 200px"></input>
     </tr>
    <tr>
      <td align="right" valign="middle">风险等级</td>
     <td align="left" valign="middle"><select name="fxlever" id="fxlever" readonly="readonly" >
							<option value="">请选择</option>
							<option value="稳健型">稳健型 </option>
							<option value="保守型">保守型</option>
							<option value="进取型">进取型</option>
				</select>		</td>
     <td align="right" valign="middle">风险到期日</td>
     <td align="left" valign="middle"><input class="easyui-datebox" readonly="readonly" data-options="formatter:ww4,parser:w4" name="fxdqdate" id="fxdqdate" value="${customer.fxdqdate  }" style="width: 200px"></input>
       </tr>
    <tr>
     <td align="right" valign="middle">账户</td>
     <td align="left" valign="middle"><input type="text" name="cashaccount" id="cashaccount"  value="${customer.cashaccount }"/></td>
      <td align="right" valign="middle">沪股东代码</td>
     <td align="left" valign="middle"><input type="text" name="hucode" id="hucode"  value="${customer.hucode }"/>
    </tr>
        <tr>
     <td align="right" valign="middle">深股东代码</td>
     <td align="left" valign="middle"><input type="text" name="shencode" id="shencode"  value="${customer.shencode }"/></td>
     <td></td><td></td>
    </tr>
    <tr>
    <td colspan="3" align="center"><input type="button" name="savebtn" id="savebtn" value="保存" onclick="javascript:saveaction()"/></td>
    <td></td>
    </tr>
  </tbody>
</table>
</form>
    
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	
    <script type="text/javascript" src="<%=basePath%>js/jquery-1.5.1.min.js"></script>
	<script type="text/javascript">
		var dg;
		$(document).ready(function(){
			/* dg = frameElement.lhgDG;
			dg.addBtn('ok','保存',function(){
				$("#customerForm").submit();
			}); */
			if($("#id").val()!=""){
				$("#account").attr("readonly","readonly");
				$("#account").css("color","gray");
				$("#idCardNum").attr("readonly","readonly");
				$("#idCardNum").css("color","gray");
				$("#name").attr("readonly","readonly");
				$("#name").css("color","gray");
				$("#signcenter").attr("readonly","readonly");
				$("#signcenter").css("color","gray");
				$("#opendate").attr("readonly","readonly");
				$("#opendate").css("color","gray");
				$("#fxcpdate").attr("readonly","readonly");
				$("#fxcpdate").css("color","gray");
				$("#fxdqdate").attr("readonly","readonly");
				$("#fxdqdate").css("color","gray");
				$("#fxlever").attr("editable","editable");
				$("#fxlever").css("color","gray");
				var sex = "${customer.sex}";
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
		
		function saveaction(){
		   $("#customerForm").submit();
		   alert("保存成功");
		}
		
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
			if($("#password").val()==""){//新增
				alert("请输入密码!");
				$("#password").focus();
				return false;
			}
			
			if($("#password").val()!=$("#chkpwd").val()){
				alert("请确认密码!");
				$("#password").focus();
				return false;
			}
			
			var options=$("#sex option:selected");
			if($("#sex").val()==""){
				alert("请选择性别!");
				$("#sex").focus();
				return false;
			}
			
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
		};
		
		function failed(){
			alert("保存失败！");
		}
	</script>
</body>
</html>