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
                        console.log(registry.byId("form-dialog-tab"));
                        alert(JSON.stringify(registry.byId("form-dialog-tab").getValues(), true));
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
                <div class="item">
                    <label>用户名：</label>
                    <label><input data-dojo-type="dijit/form/ValidationTextBox" data-dojo-props="required:true"></label>
                </div>
            </div>
            <div class="dijitDialogPaneActionBar">
                <button type="submit" data-dojo-type="dijit/form/Button" id="submit-form-tab">确定</button>
                <button type="button" data-dojo-type="dijit/form/Button" id="cancel-form-tab">关闭</button>
            </div>
        </form>
    </div>
</body>
</html>