/**
 * Created by qiyao on 2014/5/27.
 * email : yao.qi@changhong.com
 * 管理台入口View
 */
define([
    "underscore",
    "backbone",
    "../../base/base",
    "text!./index.html",
    "../menu/IndexView",
    "css!./index.css"
], function (_, B, base, tpl, MenuIndex) {
    "use strict";
    var V = base.BaseView;
    return V.extend({
        template: _.template(tpl, null, {variable:"args"}),
        events:{
            "click .a-sign-out":"onSignOut"
        },
        initialize:function(opt){
            window.eb = _.extend({}, B.Events);

            opt.$element.append(this.el);

            this.$el.html(this.template(opt));

            this.$left = this.$(".left-menu-catalog");
            this.$right = this.$(".right-container");

            this.$container = null;
            this.menus = new MenuIndex({
                $element:this.$left
            });
            this.menus.render();

            this.$loading = null;
        },
        render:function(){
            this.addEventBus();
            return this;
        },
        addEventBus:function(){
            var self = this,
                view;
            this.listenTo(window.eb,"open:menu",
                /**
                 * @param opt.menuType 菜单类型, 1 requirejs模块加载类型 10 iframe
                 */
                function(opt){
                    if(!opt.parameter){
                        opt.parameter = {};
                    }
                    if(opt.menuType === 1){
                        if(!self.$loading){
                            self.$loading = new base.LoadingView({
                                $element:self.$el
                            });

                            self.$loading.render();
                        }
                        requirejs([opt.value],function(View){
                            view = new View(opt.parameter);
                            view.render();
                            self.openRightView(view);
                            if(self.$loading){
                                self.$loading.unRender();
                                self.$loading = null;
                            }
                        });
                    }
                }
            );
        },
        /**
         * 在右侧新开容器视图
         * @param view
         */
        openRightView:function(view){
            if(this.$container){
                this.$container.unRender();
            }
            this.$container = view;
            this.$right.html(this.$container.el);
        },
        /**
         * 退出登陆
         */
        onSignOut:function(){
            $.ajax({
                url:window.basePath+"security/signOut",
                complete:function(){
                    window.location = window.basePath + "security/signIn";
                }
            });
        }
    });
});