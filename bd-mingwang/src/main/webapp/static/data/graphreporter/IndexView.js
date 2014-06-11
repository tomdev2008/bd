/**
 * Created by qiyao on 2014/6/11.
 * email : yao.qi@changhong.com
 */
define([
    "underscore",
    "../../base/base",
    "./ReporterListView",
    "css!./index.css"
], function (_, base, ReporterListView) {
    "use strict";
    var V = base.BaseView;
    return V.extend({
        className:"graph-reporter",
        initialize:function(){
            this.eb = _.extend({}, base.B.Events);
            this.listView = new ReporterListView({
                eb:this.eb
            }).render();
        },
        render:function(){
            this.$el.append(this.listView.el);
            return this;
        }
    });
});