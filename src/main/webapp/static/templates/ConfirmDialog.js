define([
    "dojo/_base/declare",
    "dijit/_WidgetBase",
    "dijit/_OnDijitClickMixin",
    "dijit/_TemplatedMixin",
    "dijit/_WidgetsInTemplateMixin",
    "dojo/aspect",
    "dijit/Dialog",
    "dijit/form/Button",
    "dojo/text!./ConfirmDialog.html"
], function(declare, _WidgetBase, _OnDijitClickMixin, _TemplatedMixin,
            _WidgetsInTemplateMixin, aspect, Dialog, Button, template) {

    return declare( [_WidgetBase, _OnDijitClickMixin,
        _TemplatedMixin, _WidgetsInTemplateMixin
    ], {
        templateString: template,

        content:"", //动态内容


        show:function(){

            this.confirmDialog.show();
        },
        postCreate:function(){

            var confirmDialog = this.confirmDialog;
            //销毁对象,避免内存泄露
            var click = aspect.after(this.confirmButon,"onClick",function(){
                click.remove();
                confirmDialog.destroyRecursive();
            });
            var cancel = aspect.after(confirmDialog, "onCancel", function() {
                cancel.remove();
                this.destroyRecursive();
            });
        }
    });

});