/**
 * Created by qiyao on 2014/6/7.
 * email : yao.qi@changhong.com
 * 数据仓库 Model
 */
define([
    "backbone"
], function (B) {
    "use strict";
    var M = B.Model;
    return M.extend({
        url:function(){
            return window.basePath + "data/repository"
        }
    });
});