/**
 * Created by qiyao on 2014/6/8.
 * email : yao.qi@changhong.com
 * 数据仓库详细信息
 * 显示所有的视图和表
 */
define([
    "underscore",
    "./TableCollection",
    "./TableItemView",
    "../../base/base"
], function (_, Collection, ItemView, base) {
    "use strict";
    var V = base.BaseView;
    return V.extend({
        tagName:"tbody",
        initialize:function(opt){
            this.model = opt.model;
            this.eb = opt.eb;

            this.collection = new Collection({model:this.model});
            this.listenTo(this.collection,"add", function(model){
                this.addItemView(model);
            });
        },
        render:function(){
            this.collection.fetch();
            return this;
        },
        addItemView:function(model){
            model.set("repId", this.model.get("id"));
            var v = new ItemView({
                model:model,
                eb : this.eb
            }).render();
            this.$el.append(v.el);
        }
    });
});