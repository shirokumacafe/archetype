<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="dojo" value="//ajax.googleapis.com/ajax/libs/dojo/1.9.0"/>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>Dojo Demo</title>
<%--<link rel="stylesheet" href="${ctx}/static/dijit/themes/claro/document.css">--%>
<%--<link rel="stylesheet" href="${ctx}/static/dijit/themes/claro/claro.css">--%>
<%--<link rel="stylesheet" href="${ctx}/static/dojox/layout/resources/ExpandoPane.css">--%>

<link rel="stylesheet" href="${dojo}/dijit/themes/claro/document.css">
<link rel="stylesheet" href="${dojo}/dijit/themes/claro/claro.css">
<link rel="stylesheet" href="${dojo}/dojox/layout/resources/ExpandoPane.css">

<link rel="stylesheet" href="${ctx}/static/dgrid/css/dgrid.css">
<link rel="stylesheet" href="${ctx}/static/dgrid/css/skins/claro.css">
<link rel="stylesheet" href="${ctx}/static/styles/base.css">
<link rel="stylesheet" href="${ctx}/static/styles/app.css">
<script>
    var dojoConfig = {
        baseUrl:"${ctx}/static/",
        async:true,
        parseOnLoad: false,
        isDebug:true,
        packages:[
//            { name: "dojo", location: "dojo" },
//            { name: "dijit", location: "dijit" },
//            { name: "dojox", location: "dojox" },
            { name:"dgrid", location: "dgrid" },
            { name:"put-selector", location: "put-selector" },
            { name:"xstyle", location: "xstyle" }
        ]
    }
</script>
<script src="${dojo}/dojo/dojo.js"></script>
<%--<script src="${ctx}/static/dojo/dojo.js"></script>--%>
<script>
    require([
        "dojo/_base/array",
        "dojo/topic",
        "dojo/dom",
        "dojo/json",
        "dojo/parser",
        "dojo/_base/fx",
        "dijit/registry",
        "dojo/store/Memory",
        "dijit/tree/ObjectStoreModel",
        "dijit/Tree",
        "dijit/layout/TabContainer",
        "dijit/layout/BorderContainer",
        "dijit/layout/AccordionContainer",
        "dojox/layout/ContentPane",
        "dojox/layout/ExpandoPane",
        "dojo/domReady!"
    ], function(array,topic,dom,json,parser,fx,registry,Memory,ObjectStoreModel,Tree,TabContainer,BorderContainer,AccordionContainer,ContentPane,ExpandoPane){

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

        parser.parse();

        //DOM节点加载完毕后清除Loading
        dom.byId("loaderInner").innerHTML += " 完成啦!";
        setTimeout(function hideLoader() {
            fx.fadeOut({node: "loader",duration: 500,onEnd: function(n) {
                n.style.display = "none";
            }}).play();
        }, 250);

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
</script>
</head>

<body class="claro">
<div id="loader"><div id="loaderInner" style="direction:ltr;white-space:nowrap;overflow:visible;">努力载入中 ... </div></div>

<div data-dojo-type="dijit/layout/BorderContainer" data-dojo-props="gutters:true" id="main">
    <div data-dojo-type="dojox/layout/ExpandoPane" splitter="true" duration="125" region="left" title="主菜单" maxSize="275" style="width: 275px;">
        <div data-dojo-type="dijit/layout/AccordionContainer" id="accordion"></div>
    </div>
    <div data-dojo-type="dijit/layout/TabContainer" data-dojo-props="region:'center', tabStrip:true" id="contentTabs">
        <div data-dojo-type="dijit/layout/ContentPane" title="首页" selected="true">
        这是首页的内容，以后用来放图形统计！
        </div>
    </div><!-- end TabContainer -->
</div><!-- end BorderContainer -->
</body>
</html>