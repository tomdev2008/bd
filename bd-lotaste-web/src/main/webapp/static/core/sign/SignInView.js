/**
 * Created by qiyao on 2014/5/27.
 * email : yao.qi@changhong.com
 * 登陆view
 */
define([
    "underscore",
    "../../base/base",
    "text!./signin.html",
    "css!./sign.css"
], function (_, base, tpl) {
    "use strict";
    var V = base.BaseView,
        SuccessUrl = window.basePath + "security/index",
        Modal = base.InfoModalView;
    return V.extend({
        template: _.template(tpl,null,{variable:"args"}),
        className:"sign-in",
        events:{
            "keydown input":"onKeydown",
            "click .btn-sign":"onSign"
        },
        render:function(){
            this.$el.html(this.template());
            this.$account = this.$(".input-account");
            this.$password = this.$(".input-password");
            return this;
        },
        onKeydown:function(e){
            if(e.keyCode === 13){
                this.onSign();
            }
        },
        onSign:function(){
            var account = this.$account.val(),
                password =this.$password.val(),
                modal,
                data = {};

            if(account && password){
                data.account = account;
                data.password = password;
                $.ajax({
                    url:window.basePath+"security/signIn",
                    type:"POST",
                    data:data,
                    success:function(data){
                        if(data.status === 200 && "success"===data.message){
                            window.location = SuccessUrl;
                        }else{
                            modal = new Modal({
                                data:data.message
                            });
                            modal.render();
                        }
                    },
                    error:function(resp){
                        modal = new Modal({
                            data:resp.responseText
                        });
                        modal.render();
                    }
                });
            }
        }
    });
});