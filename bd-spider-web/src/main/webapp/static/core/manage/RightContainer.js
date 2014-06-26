/**
 * Created by qiyao on 2014/5/27.
 * email : yao.qi@changhong.com
 * 主界面右侧的容器
 */
define([
    "../../base/base"
], function (base) {
    "use strict";
    var V = base.BaseView;
    return V.extend({
        className:"sys-container",
        initialize:function(opt){
            this.firstView = opt.view;
            this.children.push(opt.view);
        },
        render:function(){
            return this.firstView.el;
        }
    });
});