<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE HTML>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>DOJO</title>
    <link rel="stylesheet" href="${ctx}/static/dojo/1.8.2/dijit/themes/claro/document.css">
    <link rel="stylesheet" href="${ctx}/static/dojo/1.8.2/dijit/themes/claro/claro.css">
    <%--<link rel="stylesheet" href="${ctx}/static/styles/default.css">--%>
    <link rel="stylesheet" href="http://demos.dojotoolkit.org/demos/themePreviewer/demo.css">

<body class="claro">
<div id="loader"><div id="loaderInner" style="direction:ltr;white-space:nowrap;overflow:visible;">努力载入中 ... </div></div>
<div data-dojo-type="dijit/layout/BorderContainer" data-dojo-props="gutters:true, liveSplitters:false" id="main">
    <div data-dojo-type="dijit/layout/ContentPane" data-dojo-props="region:'top', splitter:false">
        <div id="header">
            <div class="container">
                <span id="logo"><a href="/" title="Home"><img src="http://dojotoolkit.org/api/themes/dtk/images/logo.png" alt="Dojo Toolkit" /></a></span>
                <!--<ul id="navigation">-->
                <!--<li class="home"><a href="/"><span class="homeIcon"></span></a></li>-->
                <!--<li class="download"><a href="/download/">Download</a></li>-->
                <!--<li class="features"><a href="/features/">Features</a></li>-->
                <!--<li class="docs"><a href="/documentation">Documentation</a></li>-->
                <!--<li class="community"><a href="/community">Community</a></li>-->
                <!--<li class="blog"><a href="/blog">Blog</a></li>-->
                <!--</ul>-->
            </div>
        </div>
    </div>
    <div data-dojo-type="dijit/layout/AccordionContainer" data-dojo-props="minSize:20, region:'leading', splitter:true" style="width: 300px;" id="leftAccordion">
        <div data-dojo-type="dijit/layout/AccordionPane" title="One fancy Pane">
            <div id="divTree"></div>
        </div>
        <div data-dojo-type="dijit/layout/AccordionPane" title="Another one">
        </div>
        <div data-dojo-type="dijit/layout/AccordionPane" title="Even more fancy">
        </div>
        <div data-dojo-type="dijit/layout/AccordionPane" title="Last, but not least">
        </div>
    </div><!-- end AccordionContainer -->
    <div data-dojo-type="dijit/layout/TabContainer" data-dojo-props="region:'center', tabStrip:true" id="contentTabs">
        <div data-dojo-type="dijit/layout/ContentPane" title="首页" selected="true">
            这是首页的内容，以后用来放图形统计！
        </div>
    </div><!-- end TabContainer -->
</div><!-- end BorderContainer -->
<script src="${ctx}/static/dojo/1.8.2/dojo/dojo.js"></script>
<script>
    require([
        "dojo/_base/array",
        "dojo/topic",
        "dojo/parser",
        "dojo/dom",
        "dojo/json",
        "dojo/ready",
        "dojo/_base/fx",
        "dijit/registry",
        "dojo/_base/window",
        "dojo/store/Memory",
        "dijit/tree/ObjectStoreModel",
        "dijit/Tree",
        "dijit/layout/TabContainer",
        "dijit/layout/ContentPane",
        "dijit/layout/AccordionContainer",
        "dijit/layout/AccordionPane"
    ], function(array,topic,parser,dom,json,ready,fx,registry,win,Memory,ObjectStoreModel,Tree,TabContainer,ContentPane,AccordionContainer,AccordionPane){

        function smoothScroll(args){

        }
        //bugfix:关闭tab后回退到第一个tab的问题
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
        addTabPane = function(page){

            var title = page.name;
            var id = page.id;
            var p = registry.byId("contentTabs");
            var c = p.getChildren();

            for(var i=0;i<c.length;i++){
                if(c[i].title == title){
                    p.selectChild(c[i]);
                    return;
                }
            }

            var pane = new ContentPane({
                id:id,
                title: title,
                href:"${ctx}/app/tab",
//                content: "<h4>" + title + "</h4>",
                closable: true
            });
            p.addChild(pane);
            p.selectChild(pane);
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
                    "parent": "congress"
                },
                {
                    "name": "Senate",
                    "id": "senate",
                    "parent": "congress"
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

        ready(function(){

            parser.parse();

            //DOM节点加载完毕后清除Loading
            dom.byId("loaderInner").innerHTML += " 完成啦!";
            setTimeout(function hideLoader() {
                fx.fadeOut({node: "loader",duration: 500,onEnd: function(n) {
                    n.style.display = "none";
                }}).play();
            }, 250);

            //树
            var menuTree = new Tree({
                model: menuModel,
                showRoot:false,
                openOnClick:true,
                onClick: function(item, node){
                    addTabPane(item);
                }
            }, "divTree");
            menuTree.startup();
        });
    });
</script>
</body>
</html>