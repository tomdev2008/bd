/**
 * Created by qiyao on 2014/6/2.
 * email : yao.qi@changhong.com
 * 报表设计工具入口
 */
define([
    "../../base/base"
], function (base) {
    "use strict";
    var V = base.BaseView;
    return V.extend({
        render:function(){
            this.$el.html("报表设计工具");
            return this;
        }
    });
});