<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>后台管理系统</title>
</head>

<body>
<div class="header">
    <div class="dl-title"><span class="">BUI前端框架简单应用</span></div>
    <div class="dl-log">欢迎您，<span class="dl-log-user">XXX</span>
        <a href="###" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
</div>
<div class="content">
    <div class="dl-main-nav">
        <ul id="J_Nav"  class="nav-list ks-clear">
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-home">首页</div></li>
            <li class="nav-item"><div class="nav-item-inner nav-inventory">搜索页</div></li>
        </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-content">
    </ul>
</div>
<script>
    BUI.use('js/main',function(){
        var config = [{
            id:'home',
//            homePage:'main-menu',
            menu:[{
                text:'首页内容',
                items:[
                    {id:'main-menu',text:'顶部导航',href:'main/menu'},
                    {id:'second-menu',text:'二级菜单',href:'main/second-menu'}
                ]
            }]
        },{
            id:'search',
            menu:[{
                text:'搜索页面',
                items:[
                    {id:'introduce',text:'搜索页面简介',href:'search/introduce.html'}
                ]
            }]
        }];
        new PageUtil.MainPage({
            modulesConfig : config
        });
    });

</script>
</body>
</html>