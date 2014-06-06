/**
 * Created by qiyao on 2014/5/28.
 * email : yao.qi@changhong.com
 */
define([
    "backbone",
    "./AccountModel"
], function (B, AccountModel) {
    "use strict";
    var C = B.Collection;
    return C.extend({
        model: AccountModel,
        initialize:function(){
            this.pageNo = 1;
            //TODO
            this.pageSize = 100;
        },
        url:function(){
            return window.basePath + "sys/account";
        },
        parse:function(res){
            return res.datas;
        }
    });
});