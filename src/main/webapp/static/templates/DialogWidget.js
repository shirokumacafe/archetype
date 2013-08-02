define([
    "dojo/_base/declare",
    "dijit/_WidgetBase",
    "dijit/_OnDijitClickMixin",
    "dijit/_TemplatedMixin",
    "dijit/_WidgetsInTemplateMixin",
    "dijit/Dialog",
    "dijit/form/Button",
    "dojo/text!./DialogWidget.html"
], function(declare, _WidgetBase, _OnDijitClickMixin, _TemplatedMixin,
            _WidgetsInTemplateMixin, Dialog, Button, template) {

    return declare( [_WidgetBase, _OnDijitClickMixin,
        _TemplatedMixin, _WidgetsInTemplateMixin
    ], {
        templateString: template,

        baseClass:"kkk",
        title:"",

        _onClick: function(){
            console.log("click");
        },

        postCreate: function(){
            this.inherited(arguments);
            this.titleNode.innerHTML = this.title;

        }

    });

});