<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
    <script>
        require([
            "dojo/aspect",
            "dojo/dom",
            "dojo/json",
            "dojo/on",
            "dijit/registry",
            "dijit/form/Button",
            "dgrid/Grid"
        ], function(aspect,dom,JSON,on,registry,Button,Grid){

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
                //添加
                registry.byId("add-toolbar-tab").on("click",function(){
                    registry.byId("dialog-tab").set("title","添加");
                    registry.byId("dialog-tab").show();
                });
                //修改
                registry.byId("modify-toolbar-tab").on("click",function(){
                    registry.byId("dialog-tab").set("title","修改");
                    registry.byId("dialog-tab").show();
                });
                //关闭
                registry.byId("cancel-form-tab").on("click",function(){
                    registry.byId("form-dialog-tab").reset();
                    registry.byId("dialog-tab").hide();
                });
                //提交
                registry.byId("form-dialog-tab").on("submit",function(){
                    if(this.validate()){

                        alert(JSON.stringify(registry.byId("form-dialog-tab").get('value'), true));
                        return false;
                    }else{
                        alert('Form contains invalid data.  Please correct first');
                        return false;
                    }
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
        <button data-dojo-type="dijit/form/Button" type="button" id="search-toolbar-tab">查询</button>
    </div>
    <div data-dojo-type="dijit/Toolbar" id="toolbar-tab">
        <button data-dojo-type="dijit/form/Button" type="button" id="add-toolbar-tab">添加</button>
        <button data-dojo-type="dijit/form/Button" type="button" id="modify-toolbar-tab">修改</button>
        <button data-dojo-type="dijit/form/Button" type="button" id="delete-toolbar-tab">删除</button>
    </div>
    <div id="grid-tab"></div>
    <div data-dojo-type="dijit/Dialog" title="" id="dialog-tab">
        <form data-dojo-type="dijit/form/Form"  id="form-dialog-tab">
            <div class="dijitDialogPaneContentArea">
                <div class="form-item">
                    <label for="code-form-tab" class="form-label">编号：</label>
                    <input data-dojo-type="dijit/form/ValidationTextBox" data-dojo-props="required:true" name="code" id="code-form-tab">
                    <label for="name-form-tab" class="form-label">姓名：</label>
                    <input data-dojo-type="dijit/form/ValidationTextBox" data-dojo-props="required:true" name="name" id="name-form-tab">
                </div>
                <div class="form-item">
                    <label for="c1-form-tab" class="form-label">内容1：</label>
                    <input data-dojo-type="dijit/form/ValidationTextBox" data-dojo-props="required:true" name="c1" id="c1-form-tab">
                    <label for="c2-form-tab"  class="form-label">内容2：</label>
                    <input data-dojo-type="dijit/form/ValidationTextBox" data-dojo-props="required:true" name="c2" id="c2-form-tab">
                    <label for="c3-form-tab"  class="form-label">内容3：</label>
                    <input data-dojo-type="dijit/form/ValidationTextBox" data-dojo-props="required:true" name="c3" id="c3-form-tab">

                </div>

            </div>
            <div class="dijitDialogPaneActionBar">
                <button type="submit" data-dojo-type="dijit/form/Button" id="submit-form-tab">确定</button>
                <button type="button" data-dojo-type="dijit/form/Button" id="cancel-form-tab">关闭
                    <%--<script type="dojo/on" data-dojo-event="click">--%>
                        <%--var registry = require("dijit/registry");--%>
                        <%--registry.byId("dialog-tab").hide();--%>
                    <%--</script>--%>
                </button>
            </div>
        </form>
    </div>
</body>
</html>