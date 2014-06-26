<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

	<title>控制台</title>
	
	<link href="${ctx }static/css/base.css" rel="stylesheet">
</head>
<body class="sys-manage">

</body>
	<script type="text/javascript">
        var name = "${user.name }",
            loginName = "${user.loginName }",
            userId = "${user.id }";

		window.basePath = "${ctx}";
	</script>
	<script src="${ctx }static/libs/requirejs/require.js"></script>
	<script src="${ctx }static/libs/requirejs/main.js"></script>
    <script>
    requirejs([ "jquery", "./static/core/manage/IndexView" ], function($, IndexView) {
        "use strict";
        var $body = $("body"),
        	v = new IndexView({
            $element:$body,
            name:name,
            loginName:loginName,
            userId:userId
        });
        v.render();
    });
    </script>
</html>