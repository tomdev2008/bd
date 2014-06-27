/**
 * Created by qiyao on 2014/5/28.
 * email : yao.qi@changhong.com
 */
define([
    "underscore",
    "../../base/base",
    "text!./addaccount.html",
    "./AccountModel"
], function (_, base, tpl, AccountModel) {
    "use strict";
    var V = base.BaseView;
    return V.extend({
        template: _.template(tpl, null, {variable:"args"}),
        events:{
            "click .add-account-btn":"onAddClick"
        },
        initialize:function(opt){
            this.eb = opt.eb;
        },
        render:function(){
            this.$el.html(this.template());
            return this;
        },
        onAddClick:function(){
            var form = this.$(".user-account-form").serializeJSON(),
                user = new AccountModel(form),
                self = this;

            user.save({},{
                success:function(){
                    console.log("save success");
                    console.log(user.toJSON());
                    self.eb.trigger("account:add", user);
                },
                error:function(){
                    //TODO
                    console.log("save error");
                }
            });

        }

    });
});