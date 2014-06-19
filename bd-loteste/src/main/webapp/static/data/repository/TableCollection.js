/**
 * Created by qiyao on 2014/6/8.
 * email : yao.qi@changhong.com
 * 仓库表collection
 */
define([
    "backbone"
], function (B) {
    "use strict";
    var C = B.Collection;
    return C.extend({
        //需要将数据仓库的模型传递给collection用于生成url
        initialize:function(opt){
            this.repository = opt.model;
        },
        url:function(){
            return window.basePath + "data/repository/" + this.repository.get("id");
        }
    });
});