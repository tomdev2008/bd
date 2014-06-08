/**
 * Created by qiyao on 2014/6/7.
 * email : yao.qi@changhong.com
 * 数据仓库 collection
 */
define([
    "backbone"
], function (B) {
    "use strict";
    var C = B.Collection;
    return C.extend({
        url:function(){
            return window.basePath + "data/repository";
        },
        parse:function(res){
            return res.datas;
        }
    });
});