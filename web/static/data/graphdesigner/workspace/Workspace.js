/**
 * Created by qiyao on 2014/6/15.
 * email : yao.qi@changhong.com
 * 图标设计器核心
 */
define([
    "../../../base/base"
], function (base) {
    "use strict";
    var V = base.BaseView;
    return V.extend({
        className:"design-workspace",
        render:function(){
            return this;
        },
        add:function(v){
            this.$el.append(v.el);
        }
    });
});