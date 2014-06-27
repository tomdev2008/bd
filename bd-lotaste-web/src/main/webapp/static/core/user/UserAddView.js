/**
 * Created by qiyao on 2014/5/28.
 * email : yao.qi@changhong.com
 * 添加用户界面
 */
define([
    "jquery",
    "underscore",
    "../../base/base",
    "./UserModel",
    "text!./adduser.html"
], function ($, _, base, UserModel, tpl) {
    "use strict";
    var V = base.BaseView;

    return V.extend({
        template: _.template(tpl, null, {variable:"args"}),
        events:{
            "click .add-user-btn":"onAddClick"
        },
        initialize:function(opt){
            this.eb = opt.eb;
        },
        render:function(){
            this.$el.html(this.template());
            return this;
        },
        onAddClick:function(){
            var form = this.$(".user-add-form").serializeJSON(),
                user = new UserModel(form),
                self = this;

            user.save({},{
                success:function(){
                    console.log("save success");
                    console.log(user.toJSON());
                    self.eb.trigger("user:add", user);
                },
                error:function(){
                    //TODO
                    console.log("save error");
                }
            });

        }
    });
});