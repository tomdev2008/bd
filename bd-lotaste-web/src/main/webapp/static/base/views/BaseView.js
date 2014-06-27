/**
 * Created by qiyao on 2014/5/19.
 * email : yao.qi@changhong.com
 * 带消亡方法的基类
 */
define([
    "backbone",
    "underscore"
], function (B, _) {
    "use strict";
    var V = B.View;
    return V.extend({
        constructor:function(){
            this.children = [];
            V.prototype.constructor.apply(this, arguments);
        },
        unRender:function(){
            if(this.children && this.children.length>0){
                _.each(this.children,function(child){
                    child.unRender();
                });
            }
            this.remove();
        }
    });
});