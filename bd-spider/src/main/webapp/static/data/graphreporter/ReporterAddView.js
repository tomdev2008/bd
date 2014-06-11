/**
 * Created by qiyao on 2014/6/11.
 * email : yao.qi@changhong.com
 */
define([
    "underscore",
    "../../base/base",
    "text!./reporteradd.html"
], function (_, base, tpl) {
    "use strict";
    var V = base.ModalView;
    return V.extend({
        events:{
            "click .btn-confirm":"onConfirm"
        },
        bodyTemplate: _.template(tpl, null, {variable:"args"}),
        beforeRender:function(){
            this.$(".modal-body").html(this.bodyTemplate());
        },
        onConfirm:function(){
            //TODO
            console.log("on confirm");
        }
    });
});