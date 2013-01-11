<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="dojo" value="//ajax.googleapis.com/ajax/libs/dojo/1.8.1"/>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>Dojo Demo</title>
<link rel="stylesheet" href="${ctx}/static/dojo/dijit/themes/claro/document.css">
<link rel="stylesheet" href="${ctx}/static/dojo/dijit/themes/claro/claro.css">
<link rel="stylesheet" href="${ctx}/static/dojo/dojox/layout/resources/ExpandoPane.css">
<%--<link rel="stylesheet" href="${dojo}/dijit/themes/claro/document.css">--%>
<%--<link rel="stylesheet" href="${dojo}/dijit/themes/claro/claro.css">--%>
<%--<link rel="stylesheet" href="${dojo}/dojox/layout/resources/ExpandoPane.css">--%>
<link rel="stylesheet" href="${ctx}/static/dojo/dgrid/css/dgrid.css">
<link rel="stylesheet" href="${ctx}/static/dojo/dgrid/css/skins/claro.css">
<link rel="stylesheet" href="${ctx}/static/styles/base.css">
<link rel="stylesheet" href="${ctx}/static/styles/app.css">
<script>
    <%--var dojoConfig = {--%>
    <%--baseUrl:"${ctx}/static/",--%>
    <%--tlmSiblingOfDojo: false,--%>
    <%--packages:[--%>
    <%--//                 { name: "dojo", location: "dojo/1.8.3/dojo" },--%>
    <%--//                 { name: "dijit", location: "dojo/1.8.3/dijit" },--%>
    <%--//                 { name: "dojox", location: "dojo/1.8.3/dojox" },--%>
    <%--{ name:"dgrid", location: "dgrid/dgrid" },--%>
    <%--{ name:"put-selector", location: "dgrid/put-selector" },--%>
    <%--{ name:"xstyle", location: "dgrid/xstyle" }--%>
    <%--]--%>
    <%--}--%>
</script>
<%--<script src="${dojo}/dojo/dojo.js" data-dojo-config="parseOnLoad: true, async:true,isDebug:true"></script>--%>
<script src="${ctx}/static/dojo/dojo/dojo.js" data-dojo-config="parseOnLoad: true, async:true ,isDebug:true"></script>
<script>
    require([
        "dojo/_base/array",
        "dojo/topic",
        "dojo/dom",
        "dojo/json",
        "dojo/ready",
        "dojo/_base/fx",
        "dijit/registry",
        "dojo/store/Memory",
        "dijit/tree/ObjectStoreModel",
        "dijit/Tree",
        "dijit/layout/TabContainer",
        "dojox/layout/ContentPane"
    ], function(array,topic,dom,json,ready,fx,registry,Memory,ObjectStoreModel,Tree,TabContainer,ContentPane){

        //bugfix:关闭tab后回退到第一个tab的问题
        //据说1.9之后会被修复
        TabContainer.prototype.removeChild = function(page){
            var idx = array.indexOf(this.getChildren(), page);

            require("dijit/_Container").prototype.removeChild.apply(this, arguments);

            if(this._started){
                topic.publish(this.id + "-removeChild", page);
            }

            if(this._descendantsBeingDestroyed){ return; }

            if(this.selectedChildWidget === page){
                this.selectedChildWidget = undefined;
                if(this._started){
                    var children = this.getChildren();
                    if(children.length){
                        this.selectChild(children[Math.max(idx-1, 0)]);
                    }
                }
            }

            if(this._started){
                this.layout();
            }
        };

        //通用添加tab页
        var addTabPane = function(page){
            var title = page.name;
            var id = page.id;
            var url = page.url;
            var p = registry.byId("contentTabs");
            var c = p.getChildren();

            for(var i=0;i<c.length;i++){
                if(c[i].id == id){
                    p.selectChild(c[i]);
                    return c[i];
                }
            }

            var pane = new ContentPane({
                id:id,
                title: title,
                href:"${ctx}/"+url,
//                parseOnLoad:false,
                scriptHasHooks:true,
                closable: true
            });
            p.addChild(pane);
            p.selectChild(pane);
            return pane;
        };

        //初始化菜单的数据
        var menuStore = new Memory({
            data: [{
                "name": "US Government",
                "id": "root"
            },
                {
                    "name": "Congress",
                    "id": "congress",
                    "parent": "root"
                },
                {
                    "name": "House of Representatives",
                    "id": "house",
                    "parent": "congress",
                    "url":"app/tab"
                },
                {
                    "name": "Senate",
                    "id": "senate",
                    "parent": "congress",
                    "url":"app/tab2"

                },
                {
                    "name": "Executive",
                    "id": "exec",
                    "parent": "root"
                },
                {
                    "name": "President",
                    "id": "pres",
                    "parent": "exec"
                },
                {
                    "name": "Vice President",
                    "id": "vice-pres",
                    "parent": "exec"
                },
                {
                    "name": "Secretary of State",
                    "id": "state",
                    "parent": "exec"
                },
                {
                    "name": "Cabinet",
                    "id": "cabinet",
                    "parent": "exec"
                },
                {
                    "name": "National Security Council",
                    "id": "security",
                    "parent": "cabinet"
                },
                {
                    "name": "Council of Economic Advisers",
                    "id": "economic",
                    "parent": "cabinet"
                },
                {
                    "name": "Office of Management and Budget",
                    "id": "budget",
                    "parent": "cabinet"
                },
                {
                    "name": "Judicial",
                    "id": "judicial",
                    "parent": "root"
                }
            ],
            getChildren: function(object){
                return this.query({parent: object.id});
            }
        });

        //数据模型
        var menuModel = new ObjectStoreModel({
            store: menuStore,
            query: {id: 'root'},
            mayHaveChildren: function(object){
                return this.store.getChildren(object).length > 0;
            }
        });

        //树
        var menuTree = new Tree({
            model: menuModel,
            showRoot:false,
            openOnClick:true,
            onClick: function(item, node){
                addTabPane(item);
            }
        });
        ready(function(){

            //DOM节点加载完毕后清除Loading
            dom.byId("loaderInner").innerHTML += " 完成啦!";
            setTimeout(function hideLoader() {
                fx.fadeOut({node: "loader",duration: 500,onEnd: function(n) {
                    n.style.display = "none";
                }}).play();
            }, 250);

            //主体内容
            registry.byId("contentTabs").addChild(new ContentPane({
                title:"动态添加的首页",
                selected:true,
                content: "这是动态添加的首页！以后可以在这里放统计或新来的消息"
            }));

            //菜单
            var accordion = registry.byId("accordion");
            var ap1 = new ContentPane({
                title: "菜单",
                content: menuTree
            });
            var ap2 = new ContentPane({
                title: "菜单2"
            });
            accordion.addChild(ap1);
            accordion.addChild(ap2);

        });
    });
</script>
</head>

<body class="claro">
<div id="loader"><div id="loaderInner" style="direction:ltr;white-space:nowrap;overflow:visible;">努力载入中 ... </div></div>

<div data-dojo-type="dijit/layout/BorderContainer" data-dojo-props="gutters:true" id="main">
    <div data-dojo-type="dojox/layout/ExpandoPane" splitter="true" duration="125" region="left" title="主菜单" maxSize="275" style="width: 275px;">
        <div data-dojo-type="dijit/layout/AccordionContainer" id="accordion"></div>
    </div>
    <div data-dojo-type="dijit/layout/TabContainer" data-dojo-props="region:'center', tabStrip:true" id="contentTabs">
        <%--<div data-dojo-type="dijit/layout/ContentPane" title="首页" selected="true">--%>
        <%--这是首页的内容，以后用来放图形统计！--%>
        <%--</div>--%>
    </div><!-- end TabContainer -->
</div><!-- end BorderContainer -->
</body>
</html>