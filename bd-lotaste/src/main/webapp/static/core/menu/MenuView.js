/**
 * Created by qiyao on 2014/5/27.
 * email : yao.qi@changhong.com
 */
define([
    "underscore",
    "../../base/base"
], function (_, base) {
    "use strict";
    var V = base.BaseView;
    return V.extend({
        tagName:"li",
        className:"list-group-item menu-item-view",
        events:{
            "click":"onClick"
        },
        render:function(){
            this.$el.html(this.model.get("name"));
            return this;
        },
        onClick:function(){
            window.eb.trigger("open:menu", this.model.toJSON());
        }
    });
});