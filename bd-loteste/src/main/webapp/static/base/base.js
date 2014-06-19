/**
 *
 */
define([
    "underscore",
    "backbone",
    "./views/BaseView",
    "./modal/ModalView",
    "./modal/InfoModalView",
    "./views/LoadingView",
    "css!./base.css"
], function (_,
             B,
             BaseView,
             ModalView,
             InfoModalView,
             LoadingView) {
    "use strict";
    var col = {
        //Backbone
        _:_,
        B:B,
        //基类
        BaseView: BaseView,
        //弹窗类
        ModalView:ModalView,
        //弹窗modal
        InfoModalView:InfoModalView,
        //加载loading
        LoadingView: LoadingView
    };

    return col;
});