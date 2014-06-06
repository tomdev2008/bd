<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}/" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="长虹">
    <meta name="author" content="qiyao">

<title>登陆 - 绵阳科技城大数据科技有限公司</title>

<link href="${ctx }static/css/base.css" rel="stylesheet">
<style type="text/css">
body {
  padding-top: 40px;
  padding-bottom: 40px;
  background-color: #eee;
}

.form-signin {
  max-width: 330px;
  padding: 15px;
  margin: 0 auto;
}
.form-signin .form-signin-heading,
.form-signin .checkbox {
  margin-bottom: 10px;
}
.form-signin .checkbox {
  font-weight: normal;
}
.form-signin .form-control {
  position: relative;
  height: auto;
  -webkit-box-sizing: border-box;
     -moz-box-sizing: border-box;
          box-sizing: border-box;
  padding: 10px;
  font-size: 16px;
}
.form-signin .form-control:focus {
  z-index: 2;
}
.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}
.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}

</style>
</head>

<body>

	<div id="container" class="container">

	</div>
	<!-- /container -->

	<script type="text/javascript">
		window.basePath = "${ctx}";
	</script>
	<script src="${ctx }static/libs/requirejs/require.js"></script>
	<script src="${ctx }static/libs/requirejs/main.js"></script>
	<script>
        var socialType = "${socialType }",
            socialId = "${socialId }";

		requirejs([ "jquery", "./static/social/sign/SignInView" ], function($, SignInView) {
			"use strict";
            var v = new SignInView({
                socialType:socialType,
                socialId:socialId
            });
			$("#container").append(v.render().el);
		});
	</script>
</body>
</html>