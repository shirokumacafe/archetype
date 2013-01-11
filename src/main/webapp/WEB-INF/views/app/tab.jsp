<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>

    <script>
        var data = [
            { code: "Bob1", name: "Barker1" },
            { code: "Bob2", name: "Barker2" }, { code: "Bob1", name: "Barker1" },
            { code: "Bob2", name: "Barker2" }, { code: "Bob1", name: "Barker1" },
            { code: "Bob2", name: "Barker2" }, { code: "Bob1", name: "Barker1" },
            { code: "Bob2", name: "Barker2" }, { code: "Bob1", name: "Barker1" },
            { code: "Bob2", name: "Barker2" }, { code: "Bob1", name: "Barker1" },
            { code: "Bob2", name: "Barker2" }, { code: "Bob1", name: "Barker1" },
            { code: "Bob2", name: "Barker2" }, { code: "Bob1", name: "Barker1" },
            { code: "Bob2", name: "Barker2" },
            { code: "Bob3", name: "Barker3" }

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
        ], function(aspect,dom,JSON,on,request,registry,Button,Grid,Pagination,Selection,Keyboard,Memory,lang, declare){
            var CustomGrid = declare([Grid,Keyboard,Selection,Pagination]);

            var tabStore = new Memory({data:data});
            var grid = new CustomGrid({
                store:tabStore,
                columns: {
                    code: "编号",
                    name: "姓名"
                },
//                selectionMode: "none",
                pagingLinks: false,
                pagingTextBox: true,
                firstLastArrows: true
            }, "grid_tab");
//            grid.renderArray(tabStore).refresh();

            //bugfix:解决dijit初始化的问题，代替了ready
            aspect.after(_container_,"onLoad", function(){

                var dialog_tab = registry.byId("dialog_tab");
                var form_dialog_tab = registry.byId("form_dialog_tab");

                //查询
                registry.byId("search_toolbar_tab").on("click",function(){

                });
                //添加
                registry.byId("add_toolbar_tab").on("click",function(){
                    form_dialog_tab.set("action","${ctx}/app/add");
                    dialog_tab.set("title","添加").show();
                });
                //修改
                registry.byId("modify_toolbar_tab").on("click",function(){
                    form_dialog_tab.set("action","${ctx}/app/update");
                    dialog_tab.set("title","修改").show();
                });
                //查看
                registry.byId("view_toolbar_tab").on("click",function(){
                    registry.byId("submit_form_tab").set("style","display:none;");
                    dialog_tab.set("title","查看").show();
                });
                //关闭
                registry.byId("cancel_form_tab").on("click",function(){
                    registry.byId("form_dialog_tab").reset();
                    registry.byId("submit_form_tab").set("style","display:inline-block;");
                    dialog_tab.hide();

                });
                //提交
                registry.byId("form_dialog_tab").on("submit",function(e){
                    alert("!");
                    e.stopPropagation();
                    e.preventDefault();
                    if(this.validate()){
                        var json = JSON.stringify(this.get('value'), true);
                        request.post(this.domNode.action,{
                            data:json
                        }).then(function(response){
//                                    tabStore.put({ code: "Bobkkk", name: "Barker1" });
//                                    grid.refresh();
//                                    dialog_tab.hide();
                        });
                    }else{
                        alert('还有未填写正确的数据，请修正后再试！');
                    }
                });
            });

        });
    </script>
</head>
<body>
<div data-dojo-type="dijit/Toolbar">
    <label>用户名:<input data-dojo-type="dijit/form/TextBox" data-dojo-props="trim:true" name="username" class="w100" id="username_toolbar_tab"/></label>
    <label>编号:<input data-dojo-type="dijit/form/TextBox" data-dojo-props="trim:true" name="code" class="w100" id="code_toolbar_tab"/></label>
    <label>起始时间:<input data-dojo-type="dijit/form/DateTextBox" name="sdate" class="w100" id="sdate_toolbar_tab"/></label>
    <label>结束时间:<input data-dojo-type="dijit/form/DateTextBox" name="edate" class="w100" id="edate_toolbar_tab"/></label>
    <button data-dojo-type="dijit/form/Button" type="button" id="search_toolbar_tab">查询</button>
</div>
<div data-dojo-type="dijit/Toolbar" id="toolbar_tab">
    <button data-dojo-type="dijit/form/Button" type="button" id="add_toolbar_tab">添加</button>
    <button data-dojo-type="dijit/form/Button" type="button" id="modify_toolbar_tab">修改</button>
    <button data-dojo-type="dijit/form/Button" type="button" id="delete_toolbar_tab">删除</button>
    <button data-dojo-type="dijit/form/Button" type="button" id="view_toolbar_tab">查看</button>
</div>
<div id="grid_tab"></div>
<div data-dojo-type="dijit/Dialog" title="" id="dialog_tab" style="display: none">
    <div data-dojo-type="dijit/form/Form"  id="form_dialog_tab">
        <div class="dijitDialogPaneContentArea">
            <div class="form-item">
                <label for="code_form_tab" class="form-label">编号：</label>
                <input data-dojo-type="dijit/form/ValidationTextBox" data-dojo-props="required:true" name="code" id="code_form_tab">
                <label for="name_form_tab" class="form-label">姓名：</label>
                <input data-dojo-type="dijit/form/ValidationTextBox" data-dojo-props="required:true" name="name" id="name_form_tab">
            </div>
            <div class="form-item">
                <label for="c1_form_tab" class="form-label">内容1：</label>
                <input data-dojo-type="dijit/form/ValidationTextBox" data-dojo-props="" name="c1" id="c1_form_tab">
                <label for="c2_form_tab"  class="form-label">内容2：</label>
                <input data-dojo-type="dijit/form/ValidationTextBox" data-dojo-props="" name="c2" id="c2_form_tab">
                <label for="c3_form_tab"  class="form-label">内容3：</label>
                <input data-dojo-type="dijit/form/ValidationTextBox" data-dojo-props="" name="c3" id="c3_form_tab">

            </div>

        </div>
        <div class="dijitDialogPaneActionBar">
            <button type="submit" data-dojo-type="dijit/form/Button" id="submit_form_tab">确定</button>
            <button type="button" data-dojo-type="dijit/form/Button" id="cancel_form_tab">关闭
                <%--<script type="dojo/on" data-dojo-event="click">--%>
                <%--var registry = require("dijit/registry");--%>
                <%--registry.byId("dialog_tab").hide();--%>
                <%--</script>--%>
            </button>
        </div>
    </div>
</div>
</body>
</html>