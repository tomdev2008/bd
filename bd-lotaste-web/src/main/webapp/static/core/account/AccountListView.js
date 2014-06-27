/**
 * Created by qiyao on 2014/5/28.
 * email : yao.qi@changhong.com
 * 用户ListView
 */
define([
    "../../base/base",
    "./AccountCollection",
    "./AccountItemView"
], function (base, AccountCollection, AccountItemView) {
    "use strict";
    var V = base.BaseView;
    return V.extend({
        tagName:"ul",
        className:"list-group",
        initialize:function(opt){
            this.eb = opt.eb;
            this.collection = new AccountCollection();
            this.listenTo(this.collection, "add", function(model){
                this.addUser(model);
            });

            this.listenTo(this.collection,"click", function(model){
                this.eb.trigger("open:detail", model);
            });
        },
        render:function(){
            this.fetch();
            return this;
        },
        fetch:function(){
            var data = {
                pageNo:this.collection.pageNo,
                pageSize:this.collection.pageSize
            }
            this.collection.fetch({
                data:data
            });
        },
        addUser:function(model){
            this.$el.append(new AccountItemView({
                model:model
            }).render().el);
        }
    });
});