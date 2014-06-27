/**
 * Created by qiyao on 2014/6/11.
 * email : yao.qi@changhong.com
 */
define([
    "../../base/base"
], function (base) {
    "use strict";
    var V = base.BaseView;
    return V.extend({
        tagName:"tr",
        events:{
            "click":"onClick"
        },
        initialize:function(opt){
            this.eb = opt.eb;
        },
        render:function(){
            this.$el.html('<td>' + this.model.get("name") + '</td>');
            return this;
        },
        onClick:function(){
            this.eb.trigger("click:datagroup",this.model, this);
        }
    });
});