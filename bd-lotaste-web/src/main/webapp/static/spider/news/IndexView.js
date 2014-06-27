/**
 * Created by qiyao on 2014/5/18.
 * email : yao.qi@changhong.com
 * 装载新闻页面的View
 */
define([
    "underscore",
    "backbone",
    "../../base/base",
    "./Collection",
    "text!./index.html",
    "./NewsItemView",
    "./NewsDetailView"
], function (_, B, base, Collection, tpl, NewsItemView, NewsDetailView) {
    "use strict";
    var V = base.BaseView;
    return V.extend({
        className:"row",
        template: _.template(tpl, null, {variable:"arg"}),
        events:{
            "click .btn-refresh":"refresh",
            "click .btn-search":"refresh"
        },
        initialize:function(){
            this.$el.data("view",this);
            this.collection = new Collection();
            this.listenTo(this.collection, "add", function(model){
                this.addModel(model);
            });
            this.listenTo(this.collection,"click",function(model){
                this.openDetail(model);
            });
            this.listenTo(this.collection, "reset", function(){
                this.clearChildren();
            });
            this.$el.html(this.template());
            this.$search = this.$("#search-text");
            this.$list = this.$(".news-list");
            this.$right = this.$(".news-right");
        },
        render:function(){
            this.refresh();
            return this;
        },
        refresh:function(){
            var searchText = this.$search.val(),
                loading = new base.LoadingView({
                    $element: this.$el
                });
            this.collection.query = encodeURI(encodeURI(searchText));
            loading.render();
            this.collection.fetch({
                //"reset":true,
                success:function(){
                    loading.unRender();
                }
            });
        },
        clearChildren:function(){
            this.collection.remove(this.collection.models);
        },
        /**
         * 添加新闻列表单元
         * @param model
         */
        addModel:function(model){
            var item = new NewsItemView({
                model:model
            });
            item.render();
            this.$list.append(item.el);
        },
        /**
         * 打开新闻详细页面
         * @param model
         */
        openDetail:function(model){
            if(this.detailView){
                this.detailView.unRender();
            }
            this.detailView = new NewsDetailView({
                model:model
            });
            this.detailView.render();
            this.$right.html(this.detailView.el);
        }
    });
});