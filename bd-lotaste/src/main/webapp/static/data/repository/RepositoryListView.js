/**
 * Created by qiyao on 2014/6/7.
 * email : yao.qi@changhong.com
 */
define([
    "./RepositoryItemView",
    "./RepositoryCollection",
    "../../base/base"
], function (ItemView, Collection, base) {
    "use strict";
    var V = base.BaseView;
    return V.extend({
        tagName:"tbody",
        initialize:function(opt){
            this.eb = opt.eb;
            this.collection = new Collection();

            this.listenTo(this.collection, "add", function(model){
                var index = this.collection.indexOf(model);
                this.addModel(model, index);
            });
        },
        render:function(){
            this.collection.fetch();
            return this;
        },
        addModel:function(model, index){
            var tr,
                i = new ItemView({
                    model:model,
                    eb:this.eb
                }).render();
            if(0===index){
                i.$el.prependTo(this.$el);
            }else{
                tr = this.$("tr:nth-child("+index+")");
                i.$el.before(tr.$el);
            }
        }
    });
});