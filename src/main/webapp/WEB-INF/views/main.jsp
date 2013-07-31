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

        //添加tab页
        var addTabPane = function(data){
            var title = data.name;
            var id = data.id;
            var url = data.link;
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

        //初始化数据
        var menuStore = new Memory({
            data:${menus},
            getChildren: function(object){
                return this.query({pId: object.id});
            }
        });

        parser.parse();

        //菜单
        var accordion = registry.byId("accordion");

        //生成选项卡与树
        menuStore.query({pId:'ROOT'}).forEach(function(data){
            var menuModel = new ObjectStoreModel({
                store: menuStore,
                query: {id: data.id},
                mayHaveChildren: function(object){
                    return this.store.getChildren(object).length > 0;
                }
            });
            var menuTree = new Tree({
                model: menuModel,
                showRoot:false,
                openOnClick:true,
                onClick: function(item, node){
                    addTabPane(item);
                }
            });

            var ap = new ContentPane({
                title: data.name,
                content: menuTree
            });
            accordion.addChild(ap);
        });

        //DOM节点加载完毕后清除Loading
        dom.byId("loaderInner").innerHTML += " 载入完成，进入系统！";
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

    });
</script>
</head>

<body class="claro">
<div id="loader"><div id="loaderInner" style="direction:ltr;white-space:nowrap;overflow:visible;">努力载入中 ... </div></div>

<div data-dojo-type="dijit/layout/BorderContainer" data-dojo-props="gutters:true" id="main" class="borderContainer">
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