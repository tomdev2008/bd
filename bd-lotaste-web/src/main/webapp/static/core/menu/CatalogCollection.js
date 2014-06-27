/**
 * Created by qiyao on 2014/5/27.
 * email : yao.qi@changhong.com
 * 菜单目录 Collection
 */
define([
    "backbone"
], function (B) {
    "use strict";
    var C = B.Collection;
    return C.extend({
        url:function(){
            return window.basePath + "sys/menu";
        },
        parse:function(res){
            return res.datas;
        }
    });
});