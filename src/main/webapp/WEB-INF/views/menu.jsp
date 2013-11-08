<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML>
<html>
<body>
    <div class="container">

        <div class="row">
            <div class="span8">
                <div id="bar"></div>
                11111
            </div>
            <div class="span8">
                <div id="bar1"></div>
                222
            </div>
        </div>

        <%--<div class="panel pull-left">--%>
            <%--<div class="panel-header">--%>
                <%--<h3>面板标题</h3>--%>
            <%--</div>--%>
            <%--<div class="panel-body">--%>
                <%--<button type="submit" class="button">Submit</button>--%>
                <%--<div id="tab"></div>--%>
                <%--<div id="panel" class="bordered" style="padding:10px;">--%>
                    <%--<div>第一个面板</div>--%>
                    <%--<div>第二个面板</div>--%>
                    <%--<div>第三个面板</div>--%>
                <%--</div>--%>
                <%--<div id="list1"></div>--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<div class="panel pull-left">--%>
            <%--<div class="panel-header">--%>
                <%--<h3>面板标题</h3>--%>
            <%--</div>--%>
            <%--<div class="panel-body">--%>
                <%--<p>这里是面板内容</p>--%>
            <%--</div>--%>
        <%--</div>--%>
    </div>
    <script type="text/javascript">

        var List = BUI.List

        var items = [
                    {text:'选项1',value:'a'},
                    {text:'选项2',value:'b'},
                    {text:'选项3',value:'c'},
                    {text:"数字值",value:3}
                ],
                list = new List.SimpleList({
                    elCls:'bui-select-list',//默认是'bui-simple-list'
                    width:200,
                    render : '#list1',
                    items : items
                });
        list.render();
        list.on('itemclick', function(ev){
            alert(ev.item.text + '：' + ev.item.value);
        });


        var Tab = BUI.Tab

        var tab = new Tab.TabPanel({
            render : '#tab',
            elCls : 'nav-tabs',
            panelContainer : '#panel',
            selectedEvent : 'mouseenter',//默认为click
            autoRender: true,
            children:[
                {text:'源代码',value:'1'},
                {text:'HTML',value:'2',panelContent : '<p>自定义内部信息</p>'},
                {text:'JS',value:'3',loader : {url : '../dialog/data/text.php'}}
            ]
        });
        tab.setSelected(tab.getItemAt(0));

        var Toolbar = BUI.Toolbar;
        var bar = new Toolbar.Bar({
            render : '#bar',
            elCls: 'toolbar',
            children : [
                {
                    xtype:'button',
                    btnCls : 'button button-small',
                    text:'<i class="icon-white icon-trash"></i>批量删除',
                    listeners : {
                        'click':function(event){
                            alert('批量删除');
                        }
                    }
                },
                {
                    xtype:'button',
                    btnCls : 'button button-small',
                    text:'审核通过',

                    handler:function(event){
                        alert('审核通过');
                    }

                },
                {
                    xtype:'button',
                    btnCls : 'button button-small',
                    text:'审核不通过',
                    handler:function(event){
                        alert('审核不通过');
                    }
                }
            ]
        });
        bar.render();

        var bar1 = new Toolbar.Bar({
            render : '#bar1',
            elCls: 'toolbar',
            children : [
                {
                    content:'<label class="checkbox"><input type="checkbox">全选</label>'
                },
                {
                    xtype:'button',
                    btnCls : 'button button-small',
                    text:'<i class="icon-white icon-trash"></i>批量删除',
                    listeners : {
                        'click':function(event){
                            alert('批量删除');
                        }
                    }
                },
                {
                    xtype:'button',
                    btnCls : 'button button-small',
                    text:'审核通过',

                    handler:function(event){
                        alert('审核通过');
                    }

                },
                {
                    xtype:'button',
                    btnCls : 'button button-small',
                    text:'审核不通过',
                    handler:function(event){
                        alert('审核不通过');
                    }
                }
            ]
        });
        bar1.render();
    </script>
</body>
</html>