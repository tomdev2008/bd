/**
 * Created by qiyao on 2014/5/18.
 * email : yao.qi@changhong.com
 * 新闻Collection
 */
define([
    "backbone",
    "./Model"
], function (B, Model) {
    "use strict";
    var C = B.Collection;
    return C.extend({
        model:Model,
        query:"",
        url:function(){
            return window.basePath + "spider/news?query=" + this.query;
        },
        parse: function(res) {
            this.pageNo = res.pageNo;
            this.pageSize = res.pageSize;
            this.count = res.count;
            return res.datas;
        }
    });
});