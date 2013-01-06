<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
    <script>
        require([
            "dojo/aspect",
            "dojo/dom",
            "dojo/on",
            "dijit/registry",
            "dijit/form/Button",
            "dgrid/Grid"
        ], function(aspect,dom,on,registry,Button,Grid){

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
            //bugfix:解决异步模式下dijit初始化的问题，代替了ready
            aspect.after(_container_,"onLoad", function(){

                grid.renderArray(data);
                registry.byId("add-toolbar-tab").on("click",function(){
                    alert("添加!")}
                );
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
        <button data-dojo-type="dijit/form/Button" type="button" id="search-toolbar-tab">查询</button>
    </div>
    <div data-dojo-type="dijit/Toolbar">
        <button data-dojo-type="dijit/form/Button" type="button" id="add-toolbar-tab">添加</button>
        <button data-dojo-type="dijit/form/Button" type="button" id="modify-toolbar-tab">修改</button>
        <button data-dojo-type="dijit/form/Button" type="button" id="delete-toolbar-tab">删除</button>
    </div>
    <div id="grid-tab"></div>

</body>
</html>