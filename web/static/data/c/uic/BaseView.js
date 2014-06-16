/**
 * Created by qiyao on 2014/6/11.
 * email : yao.qi@changhong.com
 * UI 模块视图基类
 */
define([
    "../../../base/base",
    "jqueryui.resizable"
], function (base) {
    "use strict";
    var B = base.B,
        V = base.BaseView;
    return V.extend({
        className:"ui-c absolute-c",
        initialize:function(opt){
            if(opt && opt.attr){
                this.model = new this.Attr(opt.attr);
            }else{
                this.model = new this.Attr();
            }
            this.$el.attr("data", this);
            this.$el.resize();
        },
        beforeRender:function(){

        },
        render:function(){
            var self = this;
            this.beforeRender();

            setTimeout(function(){
                self.postRender();
            }, 0);
            return this;
        },
        postRender:function(){

        }
    });
});