/**
 * Created by qiyao on 2014/6/16.
 * email : yao.qi@changhong.com
 * 二维饼图
 */
define([
    "../uic/BaseView",
    "./Attr"
], function (BaseView, Attr) {
    "use strict";
    var V = BaseView;
    return V.extend({
        Attr:Attr,
        beforeRender:function(){
            this.$el.html("我是二维饼图");
        }
    },{
        Path:"./static/data/c/twodimpie/",
        Properties:[
            {

            }
        ]
    });
});