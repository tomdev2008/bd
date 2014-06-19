/**
 * Created by qiyao on 2014/6/11.
 * email : yao.qi@changhong.com
 * TODO colse error
 */
define([
    "underscore",
    "backbone",
    "text!./modal.html"
], function (_, B, tpl) {
    "use strict";
    var M = B.View;
    return M.extend({
        template: _.template(tpl, null, {variable:"args"}),
        /**
         *
         * @param opt.title 标题
         */
        initialize:function(opt){
            this.opt = opt;
            this.$el.html(this.template(opt));

            this.modal = $(this.$(".modal"));
            this.listenTo(this.modal, "hidden.bs.modal", function(){
                this.unRender();
            });

        },
        beforeRender:function(){
            return this;
        },
        render:function(){
            var self = this;
            this.beforeRender();

            $("body").append(this.el);

            this.modal.modal({
                backdrop:"static",
                show:true
            });

            setTimeout(function(){
                self.postRender();
            },0);

            return this;
        },
        close:function(){
            this.modal.modal('hide');
        },
        postRender:function(){
            return this;
        }
    });
});