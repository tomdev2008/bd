/**
 * Created by qiyao on 2014/6/5.
 * email : yao.qi@changhong.com
 * 数据元素管理 工具
 */
define([
    "underscore",
    "../../base/base",
    "text!./index.html",
    "../repository/RepositoryListView",
    "./DataGroupListView",
    "./DataElementListView"
], function (_, base, tpl,
             RepositoryListView, DataGroupListView,
             DataElementListView) {
    "use strict";
    var V = base.BaseView;
    return V.extend({
        template: _.template(tpl, null, {variable:"args"}),
        initialize:function(){
            this.$el.html(this.template());
            this.eb = _.extend({},base.B.Events);

            this.$left = this.$(".rep-list");
            this.$centerLeft = this.$(".data-group-list");
            //TODO
            this.$centerRight = this.$(".datagroup-center-right");
            this.$right = this.$(".cols-list");

            this.dataGroupListView = null;
            this.dataElementListView = null;

            this.listenTo(this.eb,"click:repository",function(model){
                this.openDataGroup(model);
            });

            this.listenTo(this.eb,"click:datagroup", function(model){
                this.openDataElement(model.get("dataElements"));
            });
        },
        render:function(){
            var rep = new RepositoryListView({
                eb:this.eb
            }).render();

            this.$left.html(rep.el);
            return this;
        },
        openDataGroup:function(model){
            if(this.dataGroupListView){
                this.dataGroupListView.unRender();
            }
            this.dataGroupListView = new DataGroupListView({
                model:model,
                eb:this.eb
            }).render();
            this.$centerLeft.html(this.dataGroupListView.el);
        },
        openDataElement:function(array){
            if(this.dataElementListView){
                this.dataElementListView.unRender();
            }
            this.dataElementListView = new DataElementListView({
                list:array,
                eb:this.eb
            }).render();

            this.$right.html(this.dataElementListView.el);

        }
    });
});