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
	width: 500px;
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
	<br>
		<div id="box">
			<br><br><br><br>
			<br><br><br><br>
			<ul id="tab">
				<li class="on" t_index="1" id="tab_1" onclick="switchTab(1)">网络地址</li>
				<li id="tab_2" t_index="2" onclick="switchTab(2)">自定义链接</li>
			</ul>
			<ul id="tab_con">
				<li id="tab_con_1">网络链接地址:<input type="text"
					placeholder="网络地址:http://" class="input_txt"></li>
				<li id="tab_con_2"><input type="text" id="content"
					name="content_source_url" value="" readonly="readonly"
					placeholder="自定义链接地址" class="input_txt" /> <input type="button"
					value="自定义原文链接" onclick="editLink()"></li>
			</ul>
		</div>



	<script type="text/javascript" src="../js/jquery-1.5.1.min.js"></script>
	<script type="text/javascript"
		src="../js/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>

	<script type="text/javascript">
		//选项卡切换	
		function switchTab(n) {
			for ( var i = 1; i <= 2; i++) {
				document.getElementById("tab_" + i).className = "";
				document.getElementById("tab_con_" + i).style.display = "none";
			}
			document.getElementById("tab_" + n).className = "on";
			document.getElementById("tab_con_" + n).style.display = "block";
		}
	</script>
	<script type="text/javascript">
		var dg;

		$(document).ready(
				function() {
					dg = frameElement.lhgDG;
					var W = dg.curDoc;//获得父document
					dg.addBtn('ok', '确定', function() {
						if ($("#tab_con_" + $(".on").attr("t_index")).children(
								".input_txt").val() == "") {
							alert("请编辑链接地址");
						} else {
							dg.cancel();
							W.getElementById('content_source_url').value = $(
									"#tab_con_" + $(".on").attr("t_index"))
									.children(".input_txt").val();
						}
					});
				});
		function editLink() {
			var dg = new $.dialog({
				title : '编辑原文链接',
				id : 'link_editor',
				width : 1360,
				height : 750,
				iconTitle : false,
				cover : true,
				maxBtn : false,
				xButton : true,
				resize : false,
				page : 'editor.html'
			});

			dg.ShowDialog();
		}
	</script>

</body>
</html>