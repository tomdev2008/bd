/**
 * Created by qiyao on 2014/6/15.
 * email : yao.qi@changhong.com
 */
define([
    "../../../base/base",
    "./LeftTabView",
    "./Workspace",
    "./RightTabView",
    "text!./designspace.html"
], function (base, LeftTabView, Workspace, RightTabView, tpl) {
    "use strict";
    var _ = base._,
        B = base.B,
        V = base.BaseView;
    return V.extend({
        className:"design-space",
        template: _.template(tpl, null, {variable:"args"}),
        events:{
            "click .save-btn":"save"
        },
        initialize:function(){
            this.eb = _.extend({}, B.Events);
            this.listenTo(this.model,"change",function(){
                this.fetched();
            });
            this.$el.html(this.template());

            this.$left = this.$(".design-left");
            this.$center = this.$(".design-center");
            this.$right = this.$(".design-right");

            this.leftTab = new LeftTabView({
                eb:this.eb
            }).render();
            this.$left.html(this.leftTab.el);

            this.rightTab = new RightTabView({
                eb:this.eb
            }).render();
            this.$right.html(this.rightTab.el);

            this.center = new Workspace({
                eb:this.eb
            }).render();
            this.$center.html(this.center.el);

            this.addEbEvent();
        },
        render:function(){
            this.model.fetch();
            return this;
        },
        fetched:function(){

        },
        save:function(){
            console.log("save");
        },
        addEbEvent:function(){
            var self = this;
            //向面板添加组件
            this.listenTo(this.eb, "add:uic", function(opt){
                requirejs([opt.Path+"DesignView"],function(C){
                    var view = new C();
                    view.render();
                    self.center.add(view);
                });
            });
        }
    });
});