/**
 * Created by qiyao on 2014/5/27.
 * email : yao.qi@changhong.com
 * 员工信息管理入口
 */
define([
    "underscore",
    "backbone",
    "text!./index.html",
    "../../base/base",
    "./UserListView",
    "./UserDetailView",
    "./UserAddView",
    "css!./index.css"
], function (_, B, tpl, base, UserListView, UserDetailView, UserAddView) {
    "use strict";
    var V = base.BaseView;
    return V.extend({
        className:"row sys-user-manage",
        template: _.template(tpl, null, {variable:"args"}),
        events:{
            "click .add-user":"onClickAdd"
        },
        initialize:function(){
            this.eb = _.extend({}, B.Events);
            this.$el.html(this.template());

            this.$left = this.$(".left-user-list");
            this.$right = this.$(".right-user-detail");

            this.$listView = new UserListView({
                eb:this.eb
            });
            this.$listView.render();

            this.$rightView = null;
            this.listenTo(this.eb,"open:detail", function(model){
                this.openDetail(model);
            });
            this.listenTo(this.eb,"open:add",function(){
                this.openAddView();
            });
            this.listenTo(this.eb,"user:add",function(model){
                this.$listView.collection.add(model);
            });
        },
        render:function(){
            this.$left.html(this.$listView.el);
            return this;
        },
        openDetail:function(model){
            var view = new UserDetailView({
                model:model,
                eb:this.eb
            }).render();

            this.openRightView(view);

        },
        openAddView:function(){
            var view = new UserAddView({
                eb:this.eb
            }).render();

            this.openRightView(view);
        },
        clearRightView:function(){
            if(this.$rightView){
                this.$rightView.unRender();
            }
        },
        openRightView:function(view){
            this.clearRightView();
            this.$rightView = view;
            this.$right.html(this.$rightView.el);
        },
        onClickAdd:function(){
            this.eb.trigger("open:add");
        }
    });
});