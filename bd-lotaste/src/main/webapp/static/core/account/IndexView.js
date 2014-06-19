/**
 * Created by qiyao on 2014/5/27.
 * email : yao.qi@changhong.com
 * 操作用户账户 管理入口
 */
define([
    "underscore",
    "backbone",
    "../../base/base",
    "./AccountListView",
    "./AccountDetailView",
    "./AccountAddView",
    "text!./index.html"
], function (_, B, base, AccountListView, AccountDetailView, AccountAddView, tpl) {
    "use strict";
    var V = base.BaseView;
    return V.extend({
        className:"row sys-account-manage",
        template: _.template(tpl, null, {variable:"args"}),
        events:{
            "click .add-account-ic":"onClickAdd"
        },
        initialize:function(){
            this.eb = _.extend({},B.Events);
            this.$el.html(this.template());

            this.$left = this.$(".left-account");
            this.$right = this.$(".right-account");

            this.$listView = new AccountListView({
                eb:this.eb
            }).render();

            this.$rightView = null;

            this.listenTo(this.eb,"open:detail", function(model){
                this.openDetail(model);
            });
            this.listenTo(this.eb,"open:add",function(){
                this.openAddView();
            });
            this.listenTo(this.eb,"account:add",function(model){
                this.$listView.collection.add(model);
            });
        },
        render:function(){
            this.$left.html(this.$listView.el);
            return this;
        },
        openDetail:function(model){
            var view = new AccountDetailView({
                model:model,
                eb:this.eb
            }).render();

            this.openRightView(view);

        },
        openAddView:function(){
            var view = new AccountAddView({
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