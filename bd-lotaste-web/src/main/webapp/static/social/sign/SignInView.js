define([
    "underscore",
    "backbone",
    "../../base/base",
    "text!./sign.html"
], function (_, B, base, tpl) {
    "use strict";
    return B.View.extend({
        tagName:"form",
        className:"form-signin",
        template: _.template(tpl),
        events:{
            "click .sign-btn":"sign"
        },
        initialize:function(options){
            this.social = options;
            this.$el.attr("role","form");
        },
        render:function(){
            this.$el.html(this.template());
            this.$button = this.$(".sign-btn");
            return this;
        },
        sign:function(){
            console.log("sign ");
            var self = this;
            this.social.account = this.$(".account").val();
            this.social.password = this.$(".password").val();
            this.$button.button("loading");
            $.ajax({
                url:"./in",
                type:"POST",
                data:this.social,
                success:function(res){
                    console.log(res);
                    new base.InfoModalView({
                        data:res.message
                    }).render();
                },
                error:function(res){
                    console.log(res);
                },
                complete:function(){
                    self.$button.button("reset");
                }
            });
        }
    });
});