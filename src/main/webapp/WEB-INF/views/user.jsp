<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>

    <script>
        var data = [
            { id:1,code: "Bob1", name: "Barker1" },
            { id:2,code: "Bob2", name: "Barker2" },
            { id:3,code: "Bob3", name: "Barker2" },
            { id:4,code: "Bob4", name: "Barker2" },
            { id:5,code: "Bob5", name: "Barker2" },
            { id:6,code: "Bob6", name: "Barker2" },
            { id:7,code: "Bob7", name: "Barker2" },
            { id:8,code: "Bob8", name: "Barker2" },
            { id:9,code: "Bob9", name: "Barker2" },
            { id:10,code: "Bob10", name: "Barker3" },
            { id:11,code: "Bob11", name: "Barker3" }
        ];
        require([
            "dojo/aspect",
            "dojo/dom",
            "dojo/json",
            "dojo/on",
            "dojo/request",
            "dijit/registry",
            "dijit/form/Button",
            "dgrid/Grid",
            "dgrid/extensions/Pagination",
            "dgrid/Selection",
            "dgrid/Keyboard",
            "dojo/store/Memory",
            "dojo/_base/lang",
            "dojo/_base/declare"
        ], function(aspect,dom,JSON,on,request,registry,Button,Grid,Pagination,Selection,Keyboard,Memory,lang,declare){
            var CustomGrid = declare([Grid, Keyboard, Selection ,Pagination]);
            var tabStore = new Memory({identifier: "id",data:data});
            var grid = new CustomGrid({
                store:tabStore,
                columns: {
                    code: "编号",
                    name: "姓名"
                },
                selectionMode: "single",
                pagingLinks: false,
                pagingTextBox: true,
                firstLastArrows: true
            }, "grid-tab");

            //bugfix:解决dijit初始化的问题，代替了ready
            aspect.after(_container_,"onLoad", function(){
                //会重复用到的dijit
                var dialogTab = registry.byId("dialog-tab");
                var formDialogTab = registry.byId("form-dialog-tab");

                //查询
                registry.byId("search-toolbar-tab").on("click",function(){

                });
                //添加
                registry.byId("add-toolbar-tab").on("click",function(){
                    formDialogTab.set("action","${ctx}/app/add");
                    dialogTab.set("title","添加").show();
                });
                //修改
                registry.byId("modify-toolbar-tab").on("click",function(){
                    formDialogTab.set("action","${ctx}/app/update");
                    dialogTab.set("title","修改").show();
                });
                //查看
                registry.byId("view-toolbar-tab").on("click",function(){
                    registry.byId("submit-form-tab").set("style","display:none;");
                    dialogTab.set("title","查看").show();
                });
                //关闭
                registry.byId("cancel-form-tab").on("click",function(){
                    registry.byId("form-dialog-tab").reset();
                    registry.byId("submit-form-tab").set("style","display:inline-block;");
                    dialogTab.hide();

                });
                //提交
                registry.byId("submit-form-tab").on("click",function(e){
                    if(formDialogTab.validate()){
                        var json = JSON.stringify(formDialogTab.get('value'), true);
                        request.post(formDialogTab.domNode.action,{
                            data:json
                        }).then(function(response){
                                    alert("保存成功！");
                                    grid.refresh();
                                    dialogTab.hide();
                        });
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
    <button data-dojo-type="dijit/form/Button" type="button" id="view-toolbar-tab">查看</button>
</div>
<div id="grid-tab"></div>
<div data-dojo-type="dijit/Dialog" title="" id="dialog-tab" style="display: none">
    <div data-dojo-type="dijit/form/Form"  id="form-dialog-tab">
        <div class="dijitDialogPaneContentArea">
            <div>
                <label for="code-form-tab">编号：</label>
                <input data-dojo-type="dijit/form/ValidationTextBox" data-dojo-props="required:true" name="code" id="code-form-tab">
                <label for="name-form-tab">姓名：</label>
                <input data-dojo-type="dijit/form/ValidationTextBox" data-dojo-props="required:true" name="name" id="name-form-tab">
            </div>
            <div>
                <label for="c1-form-tab">内容1：</label>
                <input data-dojo-type="dijit/form/ValidationTextBox" data-dojo-props="" name="c1" id="c1-form-tab">
                <label for="c2-form-tab">内容2：</label>
                <input data-dojo-type="dijit/form/ValidationTextBox" data-dojo-props="" name="c2" id="c2-form-tab">
                <%--<label for="c3-form-tab">内容3：</label>--%>
                <%--<input data-dojo-type="dijit/form/ValidationTextBox" data-dojo-props="" name="c3" id="c3-form-tab">--%>

            </div>

        </div>
        <div class="dijitDialogPaneActionBar">
            <button type="button" data-dojo-type="dijit/form/Button" id="submit-form-tab">确定</button>
            <button type="button" data-dojo-type="dijit/form/Button" id="cancel-form-tab">关闭
                <%--<script type="dojo/on" data-dojo-event="click">--%>
                <%--var registry = require("dijit/registry");--%>
                <%--registry.byId("dialog-tab").hide();--%>
                <%--</script>--%>
            </button>
        </div>
    </div>
</div>
</body>
</html>