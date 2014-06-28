<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <c:set var="ctx" value="${pageContext.request.contextPath}/" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
商城首页
    <br/>
    设置cookies:<input type="text" id="xyz"/>
    <br/><button onClick="setCookie()">设置</button>
</body>

    <script src="${ctx }static/libs/jquery/jquery-1.11.1.js"></script>
    <script src="${ctx }static/libs/jquery/jquery.cookie.js"></script>
    <script>
    var key = "social_wechat_id",
        value = $.cookie(key);
    if(value){
        $("#xyz").val(value);
    }

    function setCookie(){
        var z = $("#xyz").val();
        $.cookie(key, z , { expires:999 });
    }
    </script>
</html>