<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE HTML>
<html>
<body>
    <div class="container">
        <form id="searchForm" class="form-horizontal">
            <div class="row">
                <div class="control-group span8">
                    <label class="control-label">编号：</label>
                    <div class="controls">
                        <input type="text" class="control-text" name="userCode">
                    </div>
                </div>
                <div class="control-group span8">
                    <label class="control-label">姓名：</label>
                    <div class="controls">
                        <input type="text" class="control-text" name="userName">
                    </div>
                </div>
                <div class="control-group span8">
                    <label class="control-label">性别：</label>
                    <div class="controls" >
                        <select name="sex">
                            <option value="">全部</option>
                            <option value="1">男</option>
                            <option value="0">女</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="control-group span9">
                    <label class="control-label">创建时间：</label>
                    <div class="controls">
                        <input type="text" class="calendar" name="startDate"><span> - </span><input name="endDate" type="text" class="calendar">
                    </div>
                </div>
                <div class="span3 offset2">
                    <button  type="button" id="btnSearch" class="button button-primary">搜索</button>
                </div>
            </div>
        </form>

        <div class="search-grid-container">
            <div id="grid"></div>
        </div>

        <div id="content" class="hide">
            <form id="J_Form" class="form-horizontal">
                <div class="row">
                    <div class="control-group span8">
                        <label class="control-label"><s>*</s>用户编码：</label>
                        <div class="controls">
                            <input name="userCode" type="text" data-rules="{required:true}" class="input-normal control-text">
                        </div>
                    </div>
                    <div class="control-group span8">
                        <label class="control-label"><s>*</s>用户名称：</label>
                        <div class="controls">
                            <input name="userName" type="text" data-rules="{required:true}" class="input-normal control-text">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="control-group span8">
                        <label class="control-label">用户账号：</label>
                        <div class="controls">
                            <input name="loginName" type="text" class="input-normal control-text">
                        </div>
                    </div>
                    <div class="control-group span8">
                        <label class="control-label">电话号码：</label>
                        <div class="controls">
                            <input name="tel" type="text" data-rules="{number:true}" class="input-normal control-text">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="control-group span8">
                        <label class="control-label">性别：</label>
                        <div class="controls">
                            <select    name="sex" class="input-normal">
                                <option value="1">男</option>
                                <option value="0">女</option>
                            </select>
                        </div>
                    </div>
                    <div class="control-group span8">
                        <label class="control-label">状态：</label>
                        <div class="controls">
                            <select  data-rules="{required:true}"  name="state" class="input-normal">
                                <option value="1">启用</option>
                                <option value="0">禁用</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="control-group span8">
                        <label class="control-label">入职日期：</label>
                        <div class="controls">
                            <input name="joinDate" class="calendar" type="text">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="control-group span15">
                        <label class="control-label">备注：</label>
                        <div class="controls control-row4">
                            <textarea name="remark" class="input-large" type="text"></textarea>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <script type="text/javascript">
        BUI.use(['common/search'],function (Search) {
            var enumSex = {"1":"男","0":"女"},
              enumState = {"1":"正常","0":"禁用"},
              columns = [
                { title: '用户编码', width: 100, dataIndex: 'userCode'},
                { title: '用户名称', width: 100, dataIndex: 'userName'},
                { title: '性别', width: 100, dataIndex: 'sex', renderer:BUI.Grid.Format.enumRenderer(enumSex)},
                { title: '状态', width: 100, dataIndex: 'state',renderer:BUI.Grid.Format.enumRenderer(enumState)},
                { title: '创建时间', width: 150, dataIndex: 'createTime'},
                { title: '创建人', width: 100, dataIndex: 'createId'},
                { title: '备注', width: 100, dataIndex: 'remark'}
              ],
                store = Search.createStore('${ctx}/user/list'),
                editing = new BUI.Grid.Plugins.DialogEditing({
                    contentId : 'content',
                    triggerCls : 'btn-edit',
                    editor : {
                        success : function(){ //点击确认的时候触发，可以进行异步提交
                            var editor = this,
                                    record = editing.get('record'), // 获取编辑的记录
                                    data = editor.getValue(); //编辑完成的记录
                            editor.valid();
                            if(editor.isValid()){
                                submit(BUI.mix(record,data),editor);
                            }
                        }
                    }
                }),
                gridCfg = Search.createGridCfg(columns,{
                    tbar: {
                        items: [
                            {
                                btnCls: 'button button-small',
                                text: '<i class="icon-plus"></i>添加',
                                listeners : {
                                    'click' : addFunction
                                }
                            },{
                                btnCls: 'button button-small',
                                text: '<i class="icon-edit"></i>修改',
                                listeners : {
                                    'click' : editFunction
                                }
                            },{
                                btnCls: 'button button-small',
                                text: '<i class="icon-remove"></i>删除',
                                listeners : {
                                    'click' : delFunction
                                }
                            }
                        ]
                    },
                    plugins: [BUI.Grid.Plugins.CheckSelection,editing] //勾选插件
                });
                var  search = new Search({
                    store : store,
                    gridCfg : gridCfg
                }),
                grid = search.get('grid');

            function addFunction(){
                var newData = {isNew : true}; //标志是新增加的记录
                editing.add(newData); //添加记录后，直接编辑
            }

            function editFunction(){
                var selections = grid.getSelection();
                if(selections.length==1){
                    editing.edit(selections[0]);
                }else{
                    BUI.Message.Alert("请选中一条记录！");
                }

            }

            function delFunction(){
                var selections = grid.getSelection();
                var ids = [];
                BUI.each(selections,function(item){
                    ids.push(item.userId);
                });
                if(ids.length){
                    BUI.Message.Confirm('确认要删除选中的记录么？',function(){
                        $.ajax({
                            url : '${ctx}/user/delete',
                            type:'post',
                            dataType : 'json',
                            data : {ids : ids.join(',')},
                            success : function(data){
                                if(data.success){ //删除成功
                                    search.load();
                                }else{ //删除失败
                                    BUI.Message.Alert('删除失败！');
                                }
                            }
                        });
                    },'question');
                }
            }

            function submit(record,editor){
                $.ajax({
                    url : record.isNew==true?'${ctx}/user/add':'${ctx}/user/update',
                    dataType : 'json',
                    type:'post',
                    data : record,
                    success : function(data){
                        if(data.success){ //编辑、新建成功
                            editor.accept(); //隐藏弹出框
                            search.load();
                        }else{ //编辑失败失败
                            var msg = data.msg;
                            BUI.Message.Alert('错误原因:' + msg);
                        }
                    }
                });
            }
        });

    </script>
<!-- script end -->
</body>
</html>