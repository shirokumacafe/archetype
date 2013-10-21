<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE HTML>
<html>
<body>

<div class="container">
    <form id="J_Form" class="form-horizontal">

    </form>
</div>

<script type="text/javascript">
    //    BUI.use('common/page'); //页面链接跳转

    BUI.use('bui/form', function (Form) {
        var form = new Form.HForm({
            srcNode: '#J_Form'
        });

        form.render();
    });
</script>
<form class="well form-vertical">
    <fieldset>
        <legend>垂直表单</legend>
        <label>Label name</label>
        <input type="text" class="control-text span-width span6" placeholder="Type something…">
        <span class="auxiliary-text">Associated help text!</span>

        <p class="auxiliary-text">Example block-level help text here.</p>
        <label class="checkbox">
            <input type="checkbox"> Check me out
        </label>
        <button type="submit" class="button">Submit</button>
    </fieldset>
</form>
</body>
</html>