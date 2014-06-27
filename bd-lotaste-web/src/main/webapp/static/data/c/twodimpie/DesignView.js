/**
 * Created by qiyao on 2014/6/16.
 * email : yao.qi@changhong.com
 * 二维饼图
 */
define([
    "underscore",
    "../uic/BaseView",
    "./Attr",
    "echarts",
    "text!./design.html",
    "echarts/chart/pie",
    "echarts/chart/bar",
    "css!./index.css"
], function (_, BaseView, Attr, ec, tpl) {
    "use strict";
    var V = BaseView;
    return V.extend({
        Attr:Attr,
        className:"two-dim-pie",
        template: _.template(tpl, null, {variable:"args"}),
        beforeRender:function(){
            this.$el.html(this.template());
        },
        getOptions:function(){
            var option = {
                tooltip: {
                    show: true
                },
                legend: {
                    data:['销量']
                },
                xAxis : [
                    {
                        type : 'category',
                        data : ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : [
                    {
                        "name":"销量",
                        "type":"bar",
                        "data":[5, 20, 40, 10, 10, 20]
                    }
                ]
            };
            return option;
        },
        postRender:function(){
            var self = this,
                myChart = ec.init(this.$(".chart-inner")[0]),
                refreshChart = _.throttle(function(){
                    console.log("clear");
                    self.myChart.resize();
//                self.myChart.clear();
//                self.myChart.setOption(self.getOptions());
                }, 1000);

            // 为echarts对象加载数据
            myChart.setOption(this.getOptions());
            this.myChart = myChart;

            this.listenTo(this.selfEb, "resizable:stop", function(e, ui){
                refreshChart();
            });
        }
    },{
        Path:"./static/data/c/twodimpie/",
        Properties:[
            {

            }
        ]
    });
});