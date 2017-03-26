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

.input_txt {
	width: 200px;
	height: 20px;
	line-height: 20px;
}

.info {
	height: 40px;
	line-height: 40px;
}

.info th {
	text-align: right;
	width: 65px;
	color: #4f4f4f;
	padding-right: 5px;
	font-size: 13px;
}

.info td {
	text-align: left;
}

.groupMsgResource:hover {
	z-index: 99999;
	border: 3px solid red;
	padding: 0px;
}

.selectedBorder {
	border: 5px solid blue;
}

#box {
	width: 100%;
	font-size: 12px
}

#box ul {
	margin: 0;
	padding: 0;
	list-style: none
}

#box #tab {
	height: 25px;
	padding-left: 10px;
	border-bottom: 1px solid #AACBEE
}

#box #tab li {
	width: 25%;
	height: 18px;
	padding-top: 7px;
	margin-right: 10px;
	text-align: center;
	float: left;
	background: #F3F8FD;
	cursor: pointer
}

#box #tab li.on {
	width: 25%;
	height: 19px;
	padding-top: 5px;
	border: 1px solid #AACBEE;
	border-bottom: none;
	color: #00f;
	background: #E8F2F7;
	position: relative;
	top: 1px
}

#box #tab_con {
	border: 1px solid #AACBEE;
	border-top: none;
	padding: 20px
}

#box #tab_con li {
	display: none
}

#box #tab_con #tab_con_1 {
	display: block;
}
</style>
</head>
<body>

	<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<br>
			<br>
			<th>选择做封面图片:<br> <br>
			</th>
		</tr>

		<c:forEach items="${imageResourceList}" var="temp" varStatus="loop">
			<c:if test="${loop.count%4==1}">
				<tr>
			</c:if>
			<td width="18%"><img alt="图片加载失败" src="${temp.url}"
				style="width:300px;height: 300px;" class="groupMsgResource"
				t_id="${temp.media_id}" /><br> ${temp.name}</td>
			<c:if test="${loop.count%4==0}">
				</tr>
			</c:if>
			<c:if test="${loop.count==fn:length(imageResourceList)}">
				</tr>
			</c:if>
		</c:forEach>
		
	</table>
<div class="page_and_btn">${imageResource.page.pageStr}</div>
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

					dg.addBtn('ok', '确定选择这张图片', function() {
						dg.cancel();
						W.getElementById('image').value = $(".selectedBorder")
								.attr("t_id");
						W.getElementById('imageSrc').src=$(".selectedBorder")
						.attr("src");
						
					});

				});

		

		$(".groupMsgResource").toggle(function() {
			$(".groupMsgResource").removeClass("selectedBorder");
			$(this).addClass("selectedBorder");
		}, function() {
			$(".groupMsgResource").removeClass("selectedBorder");
		});
	</script>

</body>
</html>