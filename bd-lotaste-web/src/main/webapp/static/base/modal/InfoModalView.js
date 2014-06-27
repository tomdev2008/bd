/**
 * 弹窗信息View
 */
define([
    "underscore",
    "backbone",
    "text!./info.html",
    "bootstrap"
], function (_, B, tpl) {
    "use strict";
    var V = B.View;
    return V.extend({
        template: _.template(tpl,null,{variable:"args"}),
        initialize:function(opt){
            this.data = opt.data;
        },
        render:function(){
            this.$el.html(this.template({
                data:this.data
            }));

            $("body").append(this.el);

            this.modal = this.$(".modal");
            this.modal.modal({
                backdrop:"static",
                show:true
            });
            return this;
        }
    });
});