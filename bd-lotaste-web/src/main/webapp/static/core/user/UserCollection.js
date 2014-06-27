/**
 * Created by qiyao on 2014/5/28.
 * email : yao.qi@changhong.com
 * 用户信息collection
 */
define([
    "backbone",
    "./UserModel"
], function (B, UserModel) {
    "use strict";
    var C = B.Collection;
    return C.extend({
        model:UserModel,
        initialize:function(){
            this.pageNo = 1;
            this.pageSize = 100;
        },
        url:function(){
            return ( window.basePath + "sys/user");
        },
        /**
         * @param res.datas 数据数组
         * @returns {*}
         */
        parse:function(res){
            return res.datas;
        }
    });
});