/**
 * Created by qiyao on 2014/6/12.
 * email : yao.qi@changhong.com
 */
define([
    "backbone"
], function (B) {
    "use strict";
    var M = B.Model;
    return M.extend({
        url:function(){
            return window.basePath + "data/graphreporter";
        }
    });
});