/**
 * Created by qiyao on 2014/5/28.
 * email : yao.qi@changhong.com
 */
define([
    "underscore",
    "../../base/base",
    "text!./userdetail.html"
], function (_, base, tpl) {
    "use strict";
    var V = base.BaseView;
    return V.extend({
        template: _.template(tpl, null, {variable:"args"}),
        events:{
            "click .c-a-u-btn":"createAccountByUser"
        },
        initialize:function(opt){
            this.eb = opt.eb;
        },
        render:function(){
            this.$el.html(this.template(this.model.toJSON()));
            this.isHasAccount();
            return this;
        },
        /**
         * 确定这个model是否已经创建了账户
         */
        isHasAccount:function(){
            var self = this;
            $.ajax({
                url:window.basePath + "sys/account/userid/"+this.model.get("userId"),
                success:function(res){
                    if(!res || !res.id){
                        self.$(".c-a-u-btn").removeClass("hidden");
                    }
                },
                error:function(res){
                    console.log(res);
                }
            });
        },
        createAccountByUser:function(){
            var self = this;
            $.ajax({
                url:window.basePath + "sys/account/userid/"+this.model.get("id"),
                type:"POST",
                success:function(){
                    self.$(".c-a-u-btn").addClass("hidden");
                    new base.InfoModalView({
                        data:"成功，初始密码：123456"
                    }).render();
                },
                error:function(res){
                    console.log(res);
                }
            });
        }

    });
});