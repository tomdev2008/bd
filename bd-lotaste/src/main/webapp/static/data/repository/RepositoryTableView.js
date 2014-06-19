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
    "../../base/base",
    "text!./repositorytable.html"
], function (_, Collection, ItemView, base, tpl) {
    "use strict";
    var V = base.BaseView;
    return V.extend({
        template: _.template(tpl, null, {variable:"args"}),
        initialize:function(opt){

            this.model = opt.model;
            this.collection = new Collection({model:this.model});
            this.listenTo(this.collection,"add", function(model){
                this.addItemView(model);
            });

            this.$el.html(this.template());
            this.$top = this.$(".table-list");
            this.$below = this.$(".col-list");
        },
        render:function(){
            this.collection.fetch();
            return this;
        },
        addItemView:function(model){
            var v = new ItemView({
                model:model,
                eb : this.eb
            }).render();
            this.$top.append(v.el);
        }
    });
});