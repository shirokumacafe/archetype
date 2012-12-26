<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<html>
<head>
	<title>任务管理</title>
</head>

<body>
    <div id="header">
        <div id="title">
            <shiro:user>
                <div class="btn-group pull-right">
                    <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="icon-user"></i> <shiro:principal property="name"/>
                        <span class="caret"></span>
                    </a>

                    <ul class="dropdown-menu">
                        <shiro:hasRole name="admin">
                            <li><a href="${ctx}/admin/user">Admin Users</a></li>
                            <li class="divider"></li>
                        </shiro:hasRole>
                        <li><a href="${ctx}/profile">Edit Profile</a></li>
                        <li><a href="${ctx}/logout">Logout</a></li>
                    </ul>
                </div>
            </shiro:user>
        </div>
    </div>
	<c:if test="${not empty message}">
		<div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
	</c:if>
	<div class="row">
		<div class="span4 offset7">
			<form class="form-search" action="#">
			 	<label>名称：</label> <input type="text" name="search_LIKE_title" class="input-medium" value="${param.search_LIKE_title}"> 
			    <button type="submit" class="btn">Search</button>
		    </form>
	    </div>
	    <tags:sort/>
	</div>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>任务</th><th>管理</th></tr></thead>
		<tbody>
		<c:forEach items="${tasks.content}" var="task">
			<tr>
				<td><a href="${ctx}/task/update/${task.id}">${task.title}</a></td>
				<td><a href="${ctx}/task/delete/${task.id}">删除</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<tags:pagination page="${tasks}" paginationSize="5"/>

	<div><a class="btn" href="${ctx}/task/create">创建任务</a></div>
</body>
</html>
