/**
 * Created by qiyao on 2014/6/11.
 * email : yao.qi@changhong.com
 * UI 模块视图基类
 */
define([
    "../../../base/base",
    "css!./base.css",
    "jqueryui.resizable",
    "jqueryui.draggable"
], function (base) {
    "use strict";
    var _ = base._,
        B = base.B,
        V = base.BaseView;
    return V.extend({
        constructor:function(){
            if(this.className){
                this.className = this.className + " data-c ui-c absolute-c";
            }else{
                this.className = "data-c ui-c absolute-c";
            }
            V.prototype.constructor.apply(this, arguments);
        },
        initialize:function(opt){
            this.selfEb = _.extend({}, B.Events);

            if(opt && opt.attr){
                this.model = new this.Attr(opt.attr);
            }else{
                this.model = new this.Attr();
            }
            this.$el.data("data-c", this);
        },
        beforeRender:function(){

        },
        render:function(){
            var self = this,
                top = parseInt(this.model.get("top"),10),
                left = parseInt(this.model.get("left"),10);

            this.$el.outerHeight(this.model.get("height"));
            this.$el.outerWidth(this.model.get("width"));
            this.$el.css({
                top:top+"px",
                left:left+"px"
            });

            this.beforeRender();

            setTimeout(function(){
                self.postRender();
            }, 0);

            setTimeout(function(){
                self.initResizable();
                self.initDraggable();
            },1000);

            return this;
        },
        postRender:function(){

        },
        initResizable:function(){
            var self = this;
            this.$el.resizable({
                create:function(e, ui){
                    self.selfEb.trigger("resizable:create", e, ui);
                },
                resize:function(e, ui){
                    self.selfEb.trigger("resizable:resize", e, ui);
                },
                start:function(e, ui){
                    self.selfEb.trigger("resizable:start", e, ui);
                },
                stop:function(e, ui){
                    self.selfEb.trigger("resizable:stop", e, ui);
                    //将resize之后的宽度和长度写入model当中以便以后保存到数据库
                    //不论类型，都按照文本进行存储
                    var outerWidth = self.$el.outerWidth(),
                        outerHeight = self.$el.outerHeight();

                    self.model.set("height",outerHeight+"",{
                        silent:true
                    });
                    self.model.set("width", outerWidth+"",{
                        silent:true
                    });

                }
            });
        },
        initDraggable:function(){
            var self = this;
            this.$el.draggable({
                create:function(e, ui){
                    self.selfEb.trigger("draggable:create", e, ui);
                },
                drag:function(e, ui){
                    self.selfEb.trigger("draggable:drag", e, ui);
                },
                start:function(e, ui){
                    self.selfEb.trigger("draggable:start", e, ui);
                },
                stop:function(e, ui){
                    self.selfEb.trigger("draggable:stop", e, ui);
                    //将移动后的top和left写入model中，以字符串进行存储
                    var so = self.$el.offset(),
                        po = self.$el.parent().offset();

                    self.model.set("top", (so.top - po.top)+"",{
                        silent:true
                    });
                    self.model.set("left", (so.left - po.left)+"",{
                        silent:true
                    });
                }
            });
        }
    });
});