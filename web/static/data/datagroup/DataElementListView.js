/**
 * Created by qiyao on 2014/6/11.
 * email : yao.qi@changhong.com
 */
define([
    "../../base/base",
    "./DataElementCollection",
    "./DataElementItemView"
], function (base, Collection, ItemView) {
    "use strict";
    var V = base.BaseView;
    return V.extend({
        tagName:"tbody",
        initialize:function(opt){
            this.collection = new Collection(opt.list);
        },
        render:function(){
            this.addItem();
            return this;
        },
        addItem:function(){
            this.collection.each(function(model){
                this.$el.append(new ItemView({
                    model:model,
                    eb:this.eb
                }).render().el);
            },this);
        }
    });
});