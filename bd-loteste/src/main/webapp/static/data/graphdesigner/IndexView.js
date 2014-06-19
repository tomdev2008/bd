/**
 * Created by qiyao on 2014/6/2.
 * email : yao.qi@changhong.com
 * 报表设计工具入口
 */
define([
    "./workspace/DesignSpace",
    "../../base/base",
    "./ReporterModel",
    "css!./index.css"
], function (DesignSpace, base, ReporterModel) {
    "use strict";
    var V = base.BaseView;
    return V.extend({
        className:"graph-designer",
        initialize:function(opt){
            this.model = new ReporterModel({id:opt.reporterId});
        },
        render:function(){
            this.$el.html(new DesignSpace({
                model:this.model
            }).render().el);
            return this;
        }
    });
});