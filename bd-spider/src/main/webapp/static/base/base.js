/**
 *
 */
define([
    "backbone",
    "./views/BaseView",
    "./modal/InfoModalView",
    "./views/LoadingView",
    "css!./base.css"
], function (B,
             BaseView,
             InfoModalView,
             LoadingView) {
    "use strict";
    var col = {
        //Backbone
        B:B,
        //基类
        BaseView: BaseView,
        //弹窗modal
        InfoModalView:InfoModalView,
        //加载loading
        LoadingView: LoadingView
    };

    return col;
});