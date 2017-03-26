<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑图片</title>
<link type="text/css" rel="stylesheet" href="../css/main.css"/>
<link rel="stylesheet" type="text/css" href="../jquery-easyui-1.4/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../jquery-easyui-1.4/themes/icon.css">
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
	//新闻编 辑器
	K.create('textarea[name="descripse"]', {
		uploadJson : '../kindeditor/jsp/upload_json.jsp',
		fileManagerJson : '../kindeditor/jsp/file_manager_json.jsp',
		width : '1000',
		height : '800',
		allowFileManager : true,
		allowImageUpload : true,
		afterCreate : function() {this.loadPlugin('autoheight');},
		afterBlur : function(){ this.sync(); }  //Kindeditor下获取文本框信息
	});
	
	var editor = K.editor({
		allowFileManager : true
	});
	K('#image1').click(function() {
		editor.loadPlugin('image', function() {
			editor.plugin.imageDialog({
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
	<form action="save.html" name="picForm" id="picForm" target="result" method="post">
	<input type="hidden" name="id" id="id" value="${pic.id}"/>
	<table border="0" cellpadding="0" cellspacing="0">
		<tr class="info">
			<th>标　题:</th>
			<td><input type="text" name="title" id="title" class="input_txt" value="${pic.title}"/></td>
		</tr>
		<tr class="info">
			<th>分　类:</th>
			<td>
			 	<input id="bigPicType" class="easyui-combobox"
			 		data-options="valueField: 'id',textField: 'name',
			 				panelHeight:'auto',
					 		url: '../picType/parent.html',
					 		onSelect: function(rec){
					 			var url = '../picType/sub.html?id='+rec.id;
					 			$('#picTypeId').combobox('reload', url);
					 			}">
				<input id="picTypeId" name="picTypeId" class="easyui-combobox" 
					data-options="valueField:'id',textField:'name',panelHeight:'auto'">	 			
			 	
			</td>
		</tr>
		<tr class="info">
			<th>图　片:</th>
			<td>
			<input type="text" id="pic" name="pic" value="${pic.pic}"/>
			<input type="button" id="image1" value="选择图片" />
			</td>
		</tr>
		<tr class="info">
			<th>优先级:</th>
			<td><input type="text" name="priority" id="priority" class="input_txt" value="${pic.priority}"/></td>
		</tr>
		<tr class="info">
			<th>状　态:</th>
			<td>
			<select name="status" id="status"><option value="启用">启用</option><option value="停用">停用</option></select>
			&nbsp;&nbsp;是否形像图:
			<select name="figure" id="figure"><option value="0">否</option><option value="1">是</option></select>
			</td>
		</tr>
		<tr class="info">
			<th>描　述:</th>
			<td>
			<textarea id="descripse" name="descripse" style="visibility:hidden;">${pic.descripse}</textarea>
			</td>
		</tr>
	</table>
	</form>
		
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	
	<script type="text/javascript" src="../js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="../jquery-easyui-1.4/jquery.easyui.min.js"></script>
	<script type="text/javascript">
		function saveInfo(){
			if($("#title").val()==""){
				alert("请输入标题!");
				$("#title").focus();
				return false;
			}
			//保存数据
			$("#picForm").submit();
			alert("恭喜您，保存成功！");
	        return true;
		}
	</script>
</body>
</html>