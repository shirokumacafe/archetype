<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<title><sitemesh:title/></title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />

<link type="image/x-icon" href="${ctx}/static/images/favicon.ico" rel="shortcut icon">
<%--<script src="${ctx}/static/dojo/1.8.2/dojo/dojo.js" data-dojo-config="isDebug:true,async: true"></script>--%>
<%--<link href="${ctx}/static/bootstrap/2.2.2/css/bootstrap.min.css" type="text/css" rel="stylesheet" />--%>
<%--<link href="${ctx}/static/jquery-validation/1.10.0/validate.css" type="text/css" rel="stylesheet" />--%>
<%--<link href="${ctx}/static/styles/default.css" type="text/css" rel="stylesheet" />--%>
<%--<script src="${ctx}/static/jquery/jquery-1.8.3.min.js" type="text/javascript"></script>--%>
<%--<script src="${ctx}/static/jquery-validation/1.10.0/jquery.validate.min.js" type="text/javascript"></script>--%>
<%--<script src="${ctx}/static/jquery-validation/1.10.0/messages_bs_zh.js" type="text/javascript"></script>--%>


<sitemesh:head/>
</head>

<body <sitemesh:getProperty property="body.class" writeEntireProperty="true" />>
<sitemesh:body/>
<%--<script src="${ctx}/static/bootstrap/2.2.2/js/bootstrap.min.js" type="text/javascript"></script>--%>
</body>
</html>