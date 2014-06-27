/**
 * Created by qiyao on 2014/5/19.
 * email : yao.qi@changhong.com
 * 新闻详细内容
 */
define([
    "../../base/base",
    "backbone"
], function (base, B) {
    "use strict";
    var V = base.BaseView;
    return V.extend({
        tagName:"iframe",
        className:"news-detail",
        initialize:function(){

        },
        render:function(){
            this.$el.attr("src", this.model.get("webUrl"));
            //this.$el.html('<iframe src="'++'"></iframe>');
            return this;
        }
    });
});