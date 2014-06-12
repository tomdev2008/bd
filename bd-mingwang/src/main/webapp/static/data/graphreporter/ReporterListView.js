/**
 * Created by qiyao on 2014/6/11.
 * email : yao.qi@changhong.com
 */
define([
    "underscore",
    "../../base/base",
    "./ReporterCollection",
    "./ReporterItemView",
    "./ReporterAddView",
    "text!./reporterlist.html"
], function (_, base, Collection, ItemView, AddView, tpl) {
    "use strict";
    var V = base.BaseView;
    return V.extend({
        template: _.template(tpl, null, {variable:"args"}),
        events:{
            "click .add-btn":"onAdd"
        },
        initialize:function(opt){
            this.eb = opt.eb;
            this.collection = new Collection();
            this.listenTo(this.collection, "add", function(model){
                this.addItem(model);
            });
            this.listenTo(this.eb, "add:reporter",function(model){
                this.collection.add(model);
            });
            this.$el.html(this.template());
        },
        render:function(){
            this.collection.fetch();
            return this;
        },
        addItem:function(model){
            this.$el.append(new ItemView({
                model:model,
                eb:this.eb
            }).render().el);
        },
        onAdd:function(){
            new AddView({
                eb:this.eb,
                title:"新增报表"
            }).render();
        }
    });
});