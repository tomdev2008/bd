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
        initialize:function(opt){
            this.rep = opt.model;
        },
        url:function(){
            return window.basePath + "data/dataelement/" + this.rep.get("id");
        }
    });
});