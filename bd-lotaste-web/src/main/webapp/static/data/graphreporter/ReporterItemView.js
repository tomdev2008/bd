/**
 * Created by qiyao on 2014/6/11.
 * email : yao.qi@changhong.com
 */
define([
    "underscore",
    "../../base/base",
    "text!./reporteritem.html"
], function (_, base, tpl) {
    "use strict";
    var V = base.BaseView;
    return V.extend({
        template: _.template(tpl, null, {variable:"args"}),
        className:"reporter-item",
        events:{
            "click .design-btn":"openDesign",
            "click .play-btn":"openPlay"
        },
        initialize:function(opt){
            this.eb = opt.eb;
        },
        render:function(){
            this.$el.html(this.template(this.model.toJSON()));
            return this;
        },
        openDesign:function(){
            var id = this.model.get("id");
            window.eb.trigger("open:menu",{
                menuType:1,
                value:"./static/data/graphdesigner/IndexView",
                parameter:{
                    reporterId:id
                }
            });
        },
        openPlay:function(){

        }
    });
});