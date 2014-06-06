/**
 * Created by qiyao on 2014/5/27.
 * email : yao.qi@changhong.com
 */
define([
    "underscore",
    "../../base/base",
    "./MenuCollection",
    "./MenuView",
    "text!./catalog.html"
], function (_, base, MenuCollection, MenuView, tpl) {
    "use strict";
    var V = base.BaseView;
    return V.extend({
        className:"panel panel-default",
        template: _.template(tpl, null, {variable:"args"}),
        initialize:function(){
            this.menusCollection = new MenuCollection();
            this.listenTo(this.menusCollection, "add", function(model){
                this.addMenu(model);
            });
        },
        render:function(){
            var menus = this.model.get("menus");
            this.$el.html(this.template(this.model.toJSON()));
            this.$listMenu = this.$(".list-menu");
            this.menusCollection.add(menus);
            return this;
        },
        addMenu:function(model){
            var menu = new MenuView({
                model:model
            });
            menu.render();
            this.$listMenu.append(menu.el);
        }
    });
});