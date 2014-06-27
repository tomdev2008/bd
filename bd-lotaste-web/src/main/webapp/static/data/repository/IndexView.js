/**
 * Created by qiyao on 2014/6/3.
 * email : yao.qi@changhong.com
 * 数据仓库入口
 */
define([
    "underscore",
    "backbone",
    "../../base/base",
    "./RepositoryListView",
    "./TableListView",
    "./ColumnListView",
    "text!./index.html",
    "css!./index.css"
], function (_, Backbone, base, ListView, TableListView, ColumnListView, tpl) {
    "use strict";
    var V = base.BaseView;
    return V.extend({
        className:"row data-repository",
        template: _.template(tpl, null, {variable:"args"}),
        initialize:function(){
            this.eb = _.extend({}, Backbone.Events);

            this.tableListView = null;
            this.columnListView = null;

            this.$el.html(this.template());

            this.$repository = this.$(".rep-list");
            this.$table = this.$(".table-list");
            this.$column = this.$(".col-list");

            this.$right = this.$(".repository-right");

            this.listenTo(this.eb,"click:repository", function(model){
                this.showTable(model);
            });
            this.listenTo(this.eb,"click:table",function(model){
                this.showColumn(model);
            });
        },
        render:function(){
            this.leftView = new ListView({
                eb:this.eb
            }).render();
            this.$repository.html(this.leftView.el);
            return this;
        },
        showTable:function(model){
            if(this.tableListView){
                this.tableListView.unRender();
            }

            this.tableListView = new TableListView({
                model:model,
                eb:this.eb
            }).render();

            this.$table.html(this.tableListView.el);
        },
        showColumn:function(model){
            if(this.columnListView){
                this.columnListView.unRender();
            }
            this.columnListView = new ColumnListView({
                model:model,
                eb:this.eb
            }).render();
            this.$column.html(this.columnListView.el);
        }
    });
});