/**
 * Created by qiyao on 2014/5/19.
 * email : yao.qi@changhong.com
 * 新闻列表视图
 */
define([
    "../../base/base",
    "backbone"
], function (base, B) {
    "use strict";
    var V = base.BaseView;
    return V.extend({
        tagName:"tr",
        className:"clickable",
        events:{
            "click":"onClick"
        },
        initialize:function(opt){
            this.model = opt.model;
            this.listenTo(this.model,"remove",function(){
                this.unRender();
            });
        },
        render:function(){
            this.$el.html('<td>'+this.model.get("title")+'</td>');
            return this;
        },
        onClick:function(){
            this.model.trigger("click", this.model);
        }
    });
});