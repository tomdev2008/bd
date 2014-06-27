/**
 * Created by qiyao on 2014/6/8.
 * email : yao.qi@changhong.com
 * 表/视图 元素视图
 */
define([
    "underscore",
    "../../base/base",
    "text!./tableitem.html"
], function (_, base, tpl) {
    "use strict";
    var V = base.BaseView;
    return V.extend({
        tagName:"tr",
        template: _.template(tpl, null, {variable:"args"}),
        events:{
            "click":"onClick"
        },
        initialize:function(opt){
            this.eb = opt.eb;
        },
        render:function(){
            this.$el.html(this.template(this.model.toJSON()));
            return this;
        },
        onClick:function(){
            this.eb.trigger("click:table",this.model, this);
        }

    });
});