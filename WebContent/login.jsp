<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form id="loginSubmit"
		action="${pageContext.request.contextPath }/servlet/loginServlet"
		method="post">
		<input type="text" name="username" /> <input type="password"
			name="password" /> <input type="submit" value="submit提交" /> <input
			type="button" value="click提交" onclick="loginSubmint()">

	</form>

	<input type="button" value="获取用户json" onclick="ajaxGetUsers()" />



	<script type="text/javascript">
		function loginSubmint() {
			document.getElementById("loginSubmit").submit();
		}

		function ajaxGetUsers() {

			var xmlHttp;
			if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
				xmlhttp = new XMLHttpRequest();
			} else {// code for IE6, IE5
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}

			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					console.log(xmlhttp.responseText)
					var json = eval("(" + xmlhttp.responseText + ")");
					for (var i = 0; i < json.length; i++) {
						console.log(json[i]);
					}
				}
			}

			xmlhttp.open("post", "servlet/UsersServlet", true);
			xmlhttp.setRequestHeader("Content-type", "application/json");
			xmlhttp.send('{"id":"xiaohong"}');
		}
	</script>
</body>
</html>