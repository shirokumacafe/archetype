<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>

    <script>
    require(["dojo/dom","dojo/on","dijit/Toolbar","dgrid/Grid","dojo/ready"], function(dom,on,Toolbar,Grid,ready){

        var data = [
            { first: "Bob", last: "Barker", age: 89 },
            { first: "Vanna", last: "White", age: 55 },
            { first: "Pat", last: "Sajak", age: 65 }
        ];

        var grid = new Grid({
            columns: {
                first: "First Name",
                last: "Last Name",
                age: "Age"
            }
        }, "grid-tab");
        grid.renderArray(data);

        ready(function(){
            on(dom.byId("add-toolbar-tab"), "click", function(){
                alert("@");
            });
        });
    });
</script>
</head>
<body>
    <div data-dojo-type="dijit/Toolbar">
        <label>用户名:<input data-dojo-type="dijit/form/TextBox" data-dojo-props="trim:true" name="username" class="w100" id="username-toolbar-tab"/></label>
        <label>编号:<input data-dojo-type="dijit/form/TextBox" data-dojo-props="trim:true" name="code" class="w100" id="code-toolbar-tab"/></label>
        <label>起始时间:<input data-dojo-type="dijit/form/DateTextBox" name="sdate" class="w100" id="sdate-toolbar-tab"/></label>
        <label>结束时间:<input data-dojo-type="dijit/form/DateTextBox" name="edate" class="w100" id="edate-toolbar-tab"/></label>
        <div data-dojo-type="dijit/form/Button" id="search-toolbar-tab" data-dojo-props="onClick:function(){ console.log('clicked combo save') }">查询</div>
    </div>
    <div data-dojo-type="dijit/Toolbar">
        <div data-dojo-type="dijit/form/Button" id="add-toolbar-tab">添加</div>
        <div data-dojo-type="dijit/form/Button" id="modify-toolbar-tab">修改</div>
        <div data-dojo-type="dijit/form/Button" id="delete-toolbar-tab">删除</div>
    </div>
    <div id="grid-tab"></div>

</body>
</html>