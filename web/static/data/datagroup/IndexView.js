/**
 * Created by qiyao on 2014/6/5.
 * email : yao.qi@changhong.com
 * 数据元素设计工具
 */
define([
    "../../base/base"
], function (base) {
    "use strict";
    var V = base.BaseView;
    return V.extend({

        render:function(){
            this.$el.html("数据元素");
            return this;
        }
    });
});