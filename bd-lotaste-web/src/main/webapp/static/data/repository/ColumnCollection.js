/**
 * Created by qiyao on 2014/6/8.
 * email : yao.qi@changhong.com
 */
define([
    "backbone"
], function (B) {
    "use strict";
    var C = B.Collection;
    return C.extend({
        initialize:function(opt){
            this.table = opt.model;
        },
        url:function(){
            return window.basePath + "data/repository/" + this.table.get("repId") + "/" + this.table.get("tableName");
        }
    });
});