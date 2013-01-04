<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
    <script>
    require(["dijit/Toolbar","dgrid/Grid"], function(Toolbar,Grid){

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
        }, "grid1");
        grid1.renderArray(data1);

    });
</script>
</head>
<body>
    <div data-dojo-type="dijit/Toolbar">
        <label>用户名:<input data-dojo-type="dijit/form/TextBox" data-dojo-props="trim:true" name="username" class="w100" id="tab-username"/></label>
        <label>编号:<input data-dojo-type="dijit/form/TextBox" data-dojo-props="trim:true" name="code" class="w100" id="tab-code"/></label>
        <label>起始时间:<input data-dojo-type="dijit/form/DateTextBox" name="timestart" class="w100" id="tab-timestart"/></label>
        <label>结束时间:<input data-dojo-type="dijit/form/DateTextBox" name="timeend" class="w100" id="tab-timeend"/></label>
        <div data-dojo-type="dijit/form/Button" id="tab-s">查询</div>
    </div>
    <div data-dojo-type="dijit/Toolbar">

    </div>
    <div id="grid1"></div>

</body>
</html>