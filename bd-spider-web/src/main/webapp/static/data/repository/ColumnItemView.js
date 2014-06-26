/**
 * Created by qiyao on 2014/6/8.
 * email : yao.qi@changhong.com
 * 列元素 item view
 */
define([
    "underscore",
    "../../base/base",
    "text!./columnitem.html"
], function (_, base, tpl) {
    "use strict";
    var V = base.BaseView;
    return V.extend({
        tagName:"tr",
        template: _.template(tpl, null, {variable:"args"}),
        render:function(){
            this.$el.html(this.template(this.model.toJSON()));
            return this;
        }
    });
});