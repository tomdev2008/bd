/**
 * Created by qiyao on 2014/5/27.
 * email : yao.qi@changhong.com
 * 菜单主View
 */
define([
    "underscore",
    "../../base/base",
    "./CatalogView",
    "./CatalogCollection",
    "text!./index.html",
    "css!./index.css"
], function (_, base, CatalogView, CatalogCollection, tpl) {
    "use strict";
    var V = base.BaseView;
    return V.extend({
        className:"sys-menus-view panel-group",
        template: _.template(tpl,null,{variable:"args"}),
        initialize:function(opt){
            opt.$element.html(this.el);
            this.catalogCollection = new CatalogCollection();
            this.listenTo(this.catalogCollection,"add",function(model){
                this.addCatalog(model);
            });
        },
        render:function(){
            this.fetch();
            return this;
        },
        fetch:function(){
            this.catalogCollection.fetch();
        },
        addCatalog:function(model){
            var catalog = new CatalogView({
                model:model
            });
            catalog.render();
            this.$el.append(catalog.el);
        }
    });
});