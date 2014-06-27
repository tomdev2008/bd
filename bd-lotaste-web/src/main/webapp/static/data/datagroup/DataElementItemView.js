/**
 * Created by qiyao on 2014/6/11.
 * email : yao.qi@changhong.com
 */
define([
    "underscore",
    "../../base/base",
    "text!./dataelementitem.html"
], function (_, base, tpl) {
    "use strict";
    var V = base.BaseView;
    return V.extend({
        template: _.template(tpl, null, {variable:"args"}),
        tagName:"tr",
        render:function(){
            this.$el.html(this.template(this.model.toJSON()));
            return this;
        }
    });
});