<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <title><sitemesh:title/></title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <meta http-equiv="Cache-Control" content="no-store"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Expires" content="0"/>

    <link type="image/x-icon" href="${ctx}/static/images/favicon.ico" rel="shortcut icon">

    <%--<link rel="stylesheet" href="${ctx}/static/styles/base.css">--%>
    <link rel="stylesheet" href="${ctx}/static/bui/css/dpl-min.css">
    <link rel="stylesheet" href="${ctx}/static/bui/css/bui-min.css">
    <link rel="stylesheet" href="${ctx}/static/styles/main.css">
    <link rel="stylesheet" href="${ctx}/static/styles/page.css">

    <script type="text/javascript" src="${ctx}/static/jquery/jquery-1.8.1.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/bui/bui-min.js"></script>
    <script type="text/javascript" src="${ctx}/static/common/config.js"></script>

    <sitemesh:head/>
</head>

<body <sitemesh:getProperty property="body.class" writeEntireProperty="true"/>>
<sitemesh:body/>
</body>
</html>