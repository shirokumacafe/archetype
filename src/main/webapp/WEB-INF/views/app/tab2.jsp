<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="${ctx}/static/dojo/1.8.2/dgrid/css/dgrid.css">
<link rel="stylesheet" href="${ctx}/static/dojo/1.8.2/dgrid/css/skins/claro.css">
    <%--<script src="${ctx}/static/dojo/1.8.2/dojo/dojo.js"></script>--%>

    <script>
    require(["dgrid/Grid","dojo/domReady!"], function(Grid){

        var data1 = [
            { first: "Bob", last: "Barker", age: 89 },
            { first: "Vanna", last: "White", age: 55 },
            { first: "Pat", last: "Sajak", age: 65 }
        ];

        var grid1 = new Grid({
            columns: {
                first: "First Name",
                last: "Last Name",
                age: "Age"
            }
        }, "grid2");
        grid1.renderArray(data1);

    });
</script>
</head>
<body>
22222
    <div id="grid2"></div>

</body>
</html>