<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑用户分组</title>
<link type="text/css" rel="stylesheet" href="../css/main.css" />

<style type="text/css">
body {
	width: 100%;
	height: 100%;
	background-color: #FFFFFF;
	text-align: center;
}
</style>
<link rel="stylesheet" href="../kindeditor/themes/default/default.css" />
<script charset="utf-8" src="../kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="../kindeditor/lang/zh_CN.js"></script>
<script type="text/javascript">
	KindEditor.ready(function(K) {
		//新闻编 辑器
		K.create('textarea[name="content"]', {
			uploadJson : '../kindeditor/jsp/upload_json.jsp',
			fileManagerJson : '../kindeditor/jsp/file_manager_json.jsp',
			width : '1300',
			height : '600',
			allowFileManager : true,
			allowImageUpload : true,
			afterCreate : function() {
				this.loadPlugin('autoheight');
			},
			afterBlur : function() {
				this.sync();
			} //Kindeditor下获取文本框信息
		});

		var editor = K.editor({
			allowFileManager : true
		});

	});
</script>
</head>
<body>
	<br>
	<br>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<center>
		<textarea id="content" name="content" style="visibility:hidden;">${link.content}</textarea>
	</center>
	<input type="hidden" value="${link.id}" id="link_id">
	<iframe name="result" id="result" src="about:blank" frameborder="0"
		width="0" height="0"></iframe>

	<script type="text/javascript" src="../js/jquery-1.5.1.min.js"></script>
	<script type="text/javascript"
		src="../js/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	<script type="text/javascript">
		var dg;
		$(document).ready(
				function() {

					dg = frameElement.lhgDG;
					var W = dg.curDoc;//获得父document

					dg.addBtn('ok', '保存', function() {
						$.get("editor_save.html?content=" + $("#content").val()
								+ "&id=" + $("#link_id").val(), null, function(
								message) {
							W.getElementById('content').value = message;
							dg.cancel();

						})

					});

				});
	</script>

</body>
</html>