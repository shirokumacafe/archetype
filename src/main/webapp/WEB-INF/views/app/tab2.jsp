<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
    <script>
        require(["dijit/Toolbar","dgrid/Grid"], function(Toolbar,Grid){

            var data2 = [
                { first: "Bob", last: "Barker", age: 89 },
                { first: "Vanna", last: "White", age: 55 },
                { first: "Pat", last: "Sajak", age: 65 }
            ];

            var grid2 = new Grid({
                columns: {
                    first: "First Name",
                    last: "Last Name",
                    age: "Age"
                }
            }, "grid2");
            grid2.renderArray(data2);

        });
    </script>
</head>
<body>
<div id="dropDown1" data-dojo-type="dijit/form/DropDownButton"
     data-dojo-props="iconClass:'dijitIconApplication'">
    <span>DropDown</span>
    <div data-dojo-type="dijit/TooltipDialog">
        This is a TooltipDialog. You could even put a form in here!
    </div>
</div>
<div data-dojo-type="dijit/Toolbar">
    <label>用户名:<input data-dojo-type="dijit/form/TextBox" name="username" id="tab2-username"/></label>
    <label>编号:<input data-dojo-type="dijit/form/TextBox" name="code" id="tab2-code"/></label>
    <label>起始时间:<input data-dojo-type="dijit/form/DateTextBox" name="timestart" id="tab2-timestart"/></label>
    <label>结束时间:<input data-dojo-type="dijit/form/DateTextBox" name="timeend" id="tab2-timeend"/></label>
    <div data-dojo-type="dijit/form/Button" iconClass="dijitIconSearch" id="tab2-s">查询</div>

</div>
<div id="grid2"></div>

</body>
</html>