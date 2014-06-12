/**
 * Created by qiyao on 2014/6/11.
 * email : yao.qi@changhong.com
 */
define([
    "underscore",
    "../../base/base",
    "./ReporterModel",
    "text!./reporteradd.html"
], function (_, base, ReporterModel, tpl) {
    "use strict";
    var V = base.ModalView;
    return V.extend({
        events:{
            "click .btn-confirm":"onConfirm"
        },
        bodyTemplate: _.template(tpl, null, {variable:"args"}),
        beforeRender:function(){
            this.$body = this.$(".modal-body");
            this.$body.html(this.bodyTemplate());
        },
        onConfirm:function(){
            var self = this,
                data = this.$body.serializeJSON(),
                model = new ReporterModel(data);

            model.save({},{
                success:function(){
                    self.opt.eb.trigger("add:reporter", model);
                    self.close();
                },
                error:function(){
                    //ERROR TODO
                }
            });

        }
    });
});