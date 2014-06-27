/**
 * Created by qiyao on 2014/5/28.
 * email : yao.qi@changhong.com
 */
define([
    "../../base/base"
], function (base) {
    "use strict";
    var V = base.BaseView;
    return V.extend({
        render:function(){
            this.$el.html("detail account");
            return this;
        }
    });
});