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
            "width":  "200",
            "height": "200",
            "top":"0",
            "left":"0"
        }
    });
});