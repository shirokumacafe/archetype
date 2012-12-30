<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <title>DOJO</title>
    <link rel="stylesheet" href="${ctx}/static/dojo/1.8.2/dijit/themes/claro/document.css">
    <link rel="stylesheet" href="${ctx}/static/dojo/1.8.2/dijit/themes/claro/claro.css">
    <link rel="stylesheet" href="${ctx}/static/dojo/1.8.2/dojox/layout/resources/ExpandoPane.css">
    <link rel="stylesheet" href="${ctx}/static/styles/app.css">
    <%--<link rel="stylesheet" href="http://demos.dojotoolkit.org/demos/themePreviewer/demo.css">--%>

<body class="claro">
<div id="loader"><div id="loaderInner" style="direction:ltr;white-space:nowrap;overflow:visible;">努力载入中 ... </div></div>
<%--
<div data-dojo-type="dijit.Menu" id="submenu1" data-dojo-props='contextMenuForWindow:true, style:"display:none"' style="display: none;">
    <div data-dojo-type="dijit.MenuItem">Enabled Item</div>
    <div data-dojo-type="dijit.MenuItem" data-dojo-props="disabled:true">Disabled Item</div>
    <div data-dojo-type="dijit.MenuSeparator"></div>
    <div data-dojo-type="dijit.MenuItem" data-dojo-props="iconClass:'dijitIconCut'">Cut</div>
    <div data-dojo-type="dijit.MenuItem" data-dojo-props="iconClass:'dijitIconCopy'">Copy</div>
    <div data-dojo-type="dijit.MenuItem" data-dojo-props="iconClass:'dijitIconPaste'">Paste</div>
    <div data-dojo-type="dijit.MenuSeparator"></div>
    <div data-dojo-type="dijit.PopupMenuItem">
        <span>Enabled Submenu</span>
        <div data-dojo-type="dijit.Menu" id="submenu2">
            <div data-dojo-type="dijit.MenuItem">Submenu Item One</div>
            <div data-dojo-type="dijit.MenuItem">Submenu Item Two</div>
            <div data-dojo-type="dijit.PopupMenuItem">
                <span>Deeper Submenu</span>
                <div data-dojo-type="dijit.Menu" id="submenu4">
                    <div data-dojo-type="dijit.MenuItem">Sub-sub-menu Item One</div>
                    <div data-dojo-type="dijit.MenuItem">Sub-sub-menu Item Two</div>
                </div>
            </div>
        </div>
    </div>
    <div data-dojo-type="dijit.PopupMenuItem" data-dojo-props="disabled:true">
        <span>Disabled Submenu</span>
        <div data-dojo-type="dijit.Menu" id="submenu3" style="display: none;">
            <div data-dojo-type="dijit.MenuItem">Submenu Item One</div>
            <div data-dojo-type="dijit.MenuItem">Submenu Item Two</div>
        </div>
    </div>
    <div data-dojo-type="dijit.PopupMenuItem">
        <span>Different popup</span>
        <div data-dojo-type="dijit.ColorPalette"></div>
    </div>
    <div data-dojo-type="dijit.PopupMenuItem">
        <span>Different popup</span>
        <div data-dojo-type="dijit.Calendar"></div>
    </div>
</div>
--%>
<!-- end contextMenu -->
<div data-dojo-type="dijit/layout/BorderContainer" data-dojo-props="gutters:true" id="main">
    <div dojoType="dojox/layout/ExpandoPane"
         splitter="true"
         duration="125"
         region="left"
         title="主菜单"
         id="leftPane"
         maxSize="275"
         style="width: 275px;">
        <div data-dojo-type="dijit/layout/AccordionContainer" id="leftAccordion"  attachParent="true">

        </div><!-- end AccordionContainer -->
    </div>
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
        "dojox/layout/ContentPane",
        "dijit/layout/AccordionContainer",
        "dijit/layout/AccordionPane"
    ], function(array,topic,parser,dom,json,ready,fx,registry,win,Memory,ObjectStoreModel,Tree,TabContainer,ContentPane,AccordionContainer,AccordionPane,Grid){

        parser.parse();
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
        var addTabPane = function(page){

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
            });

            var leftAccordion = registry.byId("leftAccordion");
            var ap1 = new ContentPane({
                title: "菜单",
                content: menuTree
            });
            var ap2 = new ContentPane({
                title: "菜单2",
                content: "<h4>aaa</h4>"
            });
            leftAccordion.addChild(ap1);
            leftAccordion.addChild(ap2);
            leftAccordion.startup();

        });
    });
</script>
</body>
</html>