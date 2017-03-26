<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑影像分类</title>
<link type="text/css" rel="stylesheet" href="../css/main.css"/>
<style type="text/css">
body{width:100%;height:100%;background-color: #FFFFFF;text-align: center;}
.input_txt{width:200px;height:20px;line-height:20px;}
.info{height:40px;line-height:40px;}
.info th{text-align: right;width:65px;color: #4f4f4f;padding-right:5px;font-size: 13px;}
.info td{text-align:left;}
</style>
</head>
<body>
	<form  action="save.html" name="msgTypeForm" id="msgTypeForm" target="result" method="post" onsubmit="return checkInfo();">
		<input type="hidden" name="id" id="id" value="${msgType.id }"/>
	<table border="0" cellpadding="0" cellspacing="0">
		<tr class="info">
			<th>从属分类:</th>
			<td>
				<select name="parent" id="parent" class="input_txt" onchange="setMUR()">
					<option value="">请选择</option>
					<c:forEach items="${msgTypeList}" var="msgType">
					<option value="${msgType.id }">${msgType.name }</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr class="info">
			<th>名　称:</th>
			<td><input type="text" name="name" id=name class="input_txt" value="${msgType.name }"/></td>
		</tr>
		<tr class="info">
			<th>代　号:</th>
			<td><input type="text" name="code" id="code" class="input_txt" value="${msgType.code }"/></td>
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
				$("#msgTypeForm").submit();
			});
			if($("#id").val()!=""){
				var parent = "${msgType.parent}";
				if(parent==""){
					$("#parent").attr("disabled",true);
				}else{
					$("#parent").val(parent);
				}
			}
			setMUR();
		});
		
		function checkInfo(){
			if($("#name").val()==""){
				alert("请输入影像分类名称!");
				$("#name").focus();
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
		}
		
		function failed(){
			alert("新增失败！");
		}
		
		function setMUR(){
			$("#code").attr("readonly",false);
			$("#code").removeClass("input_disabled");
		}
	</script>
</body>
</html>