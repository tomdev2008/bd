/**
 * Created by qiyao on 2014/5/28.
 * email : yao.qi@changhong.com
 * 用户信息
 */
define([
    "../../base/base"
], function (base) {
    "use strict";
    var V = base.BaseView;
    return V.extend({
        tagName:"li",
        className:"list-group-item",
        events:{
            "click":"onClick"
        },
        render:function(){
            this.$el.html(this.model.get("name"));
            return this;
        },
        onClick:function(){
            this.model.trigger("click", this.model);
        }
    });
});