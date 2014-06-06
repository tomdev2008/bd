/**
 * Created by qiyao on 2014/5/19.
 * email : yao.qi@changhong.com
 * 加载转圈view
 */
define([
    "./BaseView"
], function (B) {
    "use strict";
    var DEFAULT_IMG = "/static/base/views/images/load_c.gif";
    return B.extend({
        className:"loading-view",
        /**
         * 初始化方法
         * @param opt.$element 需要转圈的目标节点
         */
        initialize:function(opt){
            this.$el.html('<div class="loading-inner"></div>');
            if(opt.$element){
                opt.$element.append(this.el);
            }
        },
        /**
         * 开始转圈
         * @returns this
         */
        render:function(){
            var path = window.basePath + DEFAULT_IMG,
                $inner = this.$(".loading-inner");

            $inner.html('<img src="'+path+'">');
            return this;
        }
    });
});