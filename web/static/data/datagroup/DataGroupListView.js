/**
 * Created by qiyao on 2014/6/11.
 * email : yao.qi@changhong.com
 */
define([
    "../../base/base",
    "./DataGroupCollection",
    "./DataGroupItemView"
], function (base, DataGroupCollection, DataGroupItemView) {
    "use strict";
    var V = base.BaseView;
    return V.extend({
        tagName:"tbody",
        initialize:function(opt){
            this.eb = opt.eb;
            this.collection = new DataGroupCollection({
                model:opt.model
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
            var v = new DataGroupItemView({
                model:model,
                eb:this.eb
            }).render();

            this.$el.append(v.el);
        }
    });
});