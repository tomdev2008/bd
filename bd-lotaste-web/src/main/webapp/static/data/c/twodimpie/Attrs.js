/**
 * Created by qiyao on 2014/6/16.
 * email : yao.qi@changhong.com
 * 属性
 */
define([
    "backbone"
], function (B) {
    "use strict";
    var M = B.Model;
    return M.extend({
        defaults: {
            "width":  "caesar salad",
            "height": "ravioli"
        }
    });
});