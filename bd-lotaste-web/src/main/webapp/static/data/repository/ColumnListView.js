/**
 * Created by qiyao on 2014/6/8.
 * email : yao.qi@changhong.com
 */
define([
    "./ColumnCollection",
    "../../base/base",
    "./ColumnItemView"
], function (ColumnCollection, base, ItemView) {
    "use strict";
    var V = base.BaseView;
    return V.extend({
        tagName:"tbody",
        initialize:function(opt){
            this.table = opt.model;
            this.eb = opt.eb;

            this.collection = new ColumnCollection({
                model:this.table
            });
            this.listenTo(this.collection, "add", function(model){
                this.addItem(model);
            });
        },
        render:function(){
            this.collection.fetch();
            return this;
        },
        addItem:function(model){
            var v = new ItemView({
                model:model,
                eb:this.eb
            }).render();
            this.$el.append(v.el);
        }
    });
});