/**
 * Created by qiyao on 2014/6/11.
 * email : yao.qi@changhong.com
 */
define([
    "backbone"
], function (B) {
    "use strict";
    var C = B.Collection;
    return C.extend({

        url:function(){
            return window.basePath + "data/graphreporter";
        },
        parse:function(res){
            return res.datas;
        }
    });
});