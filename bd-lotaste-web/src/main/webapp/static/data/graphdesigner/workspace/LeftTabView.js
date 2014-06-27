/**
 * Created by qiyao on 2014/6/15.
 * email : yao.qi@changhong.com
 */
define([
    "../../../base/base",
    "text!./lefttabview.html"
], function (base, tpl) {
    "use strict";
    var _ = base._,
        B = base.B,
        V = base.BaseView;
    return V.extend({
        template: _.template(tpl, null, {variable:"args"}),
        events:{
            "click .ewbt":"onClick"
        },
        initialize:function(opt){
            this.eb = opt.eb;
            this.$el.html(this.template());
        },
        render:function(){
            return this;
        },
        onClick:function(){
            this.eb.trigger("add:uic",{
                Path:"./static/data/c/twodimpie/"
            });
        }
    });
});