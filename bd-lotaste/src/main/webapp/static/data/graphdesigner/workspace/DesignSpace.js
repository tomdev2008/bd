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
            var self = this;
            this.model.fetch({
                success:function(){
                    self.fetched();
                }
            });
            return this;
        },
        fetched:function(){
            var self = this,
                dataconfig = this.model.get("dataconfig"),
                array;
            if(dataconfig){
                array = JSON.parse(dataconfig);
                if(array.length > 0){
                    _.each(array,function(item){
                        self.eb.trigger("add:uic", item);
                    });
                }
            }
        },
        save:function(){
            var datas = [];
            this.$(".data-c").each(function(){
                var v = $(this).data("data-c"),
                    vd = {
                        Path:v.constructor.Path,
                        attr:v.model.toJSON()
                    };
                datas.push(vd);
            });
            this.model.set("dataconfig", JSON.stringify(datas));
            this.model.save();
        },
        addEbEvent:function(){
            var self = this;
            //向面板添加组件
            this.listenTo(this.eb, "add:uic", function(opt){
                requirejs([opt.Path+"DesignView"],function(C){
                    var view = new C(opt);
                    view.render();
                    self.center.add(view);
                });
            });
        }
    });
});