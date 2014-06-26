<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String contextPath = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+contextPath+"/";
%>
<c:set var="ctx" value="${pageContext.request.contextPath}/" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="绵阳科技城大数据科技有限公司">
    <meta name="author" content="qiyao">

<title>爬虫新闻 - 绵阳科技城大数据科技有限公司</title>

    <link href="${ctx }static/css/base.css" rel="stylesheet">
    <link href="${ctx }static/spider/spider.css" rel="stylesheet">

</head>

<body class="news-page">

	<div id="container" class="container-fluid">

	</div>
	<!-- /container -->

	<script type="text/javascript">
		window.basePath = "${ctx}";
		if(window.basePath===""){
			window.basePath="/";
		}
	</script>
	<script src="${ctx }static/libs/requirejs/require.js"></script>
	<script src="${ctx }static/libs/requirejs/main.js"></script>
	<script>

		requirejs([ "jquery", "./static/spider/news/IndexView" ], function($, IndexView) {
			"use strict";
            var v = new IndexView();
			$("#container").append(v.render().el);
		});
	</script>
</body>
</html>