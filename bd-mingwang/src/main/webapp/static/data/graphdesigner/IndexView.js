/**
 * Created by qiyao on 2014/6/2.
 * email : yao.qi@changhong.com
 * 报表设计工具入口
 */
define([
    "../../base/base",
    "./ReporterModel"
], function (base, ReporterModel) {
    "use strict";
    var V = base.BaseView;
    return V.extend({
        initialize:function(opt){
            this.model = new ReporterModel({id:opt.reporterId});
            this.listenTo(this.model, "change", function(){
                this.fetched();
            });
            this.model.fetch();
        },
        render:function(){
            return this;
        },
        fetched:function(){
            this.$el.html(this.model.get("name"));
        }
    });
});