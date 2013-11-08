<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <title>登录页</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <meta http-equiv="Cache-Control" content="no-store"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Expires" content="0"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="shortcut icon" type="image/x-icon" href="${ctx}/static/images/favicon.ico">
    <%--<link href="${ctx}/static/bootstrap/2.3.1/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>--%>

</head>

<body style="background-color:#dedede;">
<form action="${ctx}/login" method="post" class="form-horizontal">
    <table width="1003" border="0" align="center" cellpadding="0" cellspacing="0">
        <tbody>

        <tr>
            <td height="680" valign="top" >
                <div style="position:absolute; height:600px; z-index:2;"></div>
                <div style="margin-top: 250px;margin-left: 35%">
                    <%
                        String error = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
                        if (error != null) {
                    %>
                    <div class="alert alert-error controls input-large">
                        <button class="close" data-dismiss="alert">×</button>
                        <%
                            if (error.contains("DisabledAccountException")) {
                                out.print("用户已被屏蔽,请登录其他用户.");
                            } else {
                                out.print("登录失败，请重试.");
                            }
                        %>
                    </div>
                    <%
                        }
                    %>
                    <div class="control-group">
                        <div class="controls">
                            <h2>用户登录区</h2>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="username"><strong>登录账号:</strong></label>

                        <div class="controls">
                            <input type="text" id="username" name="username" value="" placeholder="请输入账号"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="password"><strong>登录密码:</strong></label>

                        <div class="controls">
                            <input type="password" id="password" name="password" placeholder="请输入密码"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">
                            <label class="checkbox" for="rememberMe">
                                <input type="checkbox" id="rememberMe" name="rememberMe"/>保存用户信息(请不要在公共电脑保存)</label>
                            <input class="btn btn-primary" type="submit" value="登录"/>
                        </div>
                    </div>
                </div>
            </td>

        </tr>
        </tbody>
    </table>
</form>
</body>
</html>
