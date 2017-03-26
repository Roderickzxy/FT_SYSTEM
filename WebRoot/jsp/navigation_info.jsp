<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>栏目导航</title>
<link type="text/css" rel="stylesheet" href="../css/main.css"/>
<style type="text/css">
body{width:100%;height:100%;background-color: #FFFFFF;text-align: center;}
.input_txt{width:800px;height:20px;line-height:20px;}
.info{height:40px;line-height:40px;}
.info th{text-align: right;width:65px;color: #4f4f4f;padding-right:5px;font-size: 13px;}
.info td{text-align:left;}
form {margin: 0;}
textarea {display: block;}
</style>
<link rel="stylesheet" href="../kindeditor/themes/default/default.css" />
<script charset="utf-8" src="../kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="../kindeditor/lang/zh_CN.js"></script>
<script type="text/javascript">
KindEditor.ready(function(K) {
	var editor = K.editor({
		allowFileManager : true
	});
	K('#image1').click(function() {
		editor.loadPlugin('image', function() {
			editor.plugin.imageDialog({
				showRemote : false,
				imageUrl : K('#pic').val(),
				clickFn : function(url, title, width, height, border, align) {
					K('#pic').val(url);
					editor.hideDialog();
				}
			});
		});
	});
}); 
</script>
</head>
<body>
	<form action="save.html" name="navigationForm" id="navigationForm" target="result" method="post">
	<input type="hidden" name="id" id="id" value="${navigation.id}"/>
	<table border="0" cellpadding="0" cellspacing="0">
		<tr class="info">
			<th>名　称:</th>
			<td><input type="text" name="name" id="name" class="input_txt" value="${navigation.name}"/></td>
		</tr>
		<tr class="info">
			<th>代　号:</th>
			<td><input type="text" name="code" id="code" class="input_txt" value="${navigation.code}"/></td>
		</tr>
		<tr class="info">
			<th>链接地址:</th>
			<td><input type="text" name="url" id="url" class="input_txt" value="${navigation.url}"/></td>
		</tr>
		<tr class="info">
			<th>背景图:</th>
			<td>
			<input type="text" id="pic" name="pic" value="${navigation.pic}"/>
			<input type="button" id="image1" value="选择图片" />
			</td>
		</tr>
	</table>
	</form>
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	
	<script type="text/javascript" src="../js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="../jquery-easyui-1.4/jquery.easyui.min.js"></script>
	<script type="text/javascript">
		function saveInfo(){
			if($("#name").val()==""){
				alert("请输入名称!");
				$("#name").focus();
				return false;
			}
			if($("#code").val()==""){
				alert("请输入代号!");
				$("#code").focus();
				return false;
			}
			if($("#url").val()==""){
				alert("请输入链接地址!");
				$("#url").focus();
				return false;
			}
			//保存数据
			$("#navigationForm").submit();
			alert("恭喜您，保存成功！");
	        return true;
		}

	</script>
</body>
</html>