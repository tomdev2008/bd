/**
 * Created by qiyao on 2014/5/6.
 * 在底层预处理Ajax设置
 */
define([
    "jquery",
    "backbone"
], function ($, Backbone) {
    "use strict";
    var setupAjax = function () {
            $.ajaxSetup({
                cache: false
            });
            $.ajaxPrefilter(function (options, originalOptions, jqXHR) {
                //未登录 TODO
//                if(!$.cookie("ci") || !$.cookie("ca")){
//                    window.location=window.basePath + "/security/signin.jsp";
//                }
                var originalContext = originalOptions.context || originalOptions;
                originalContext._error = originalOptions.error;
                options.error = function(jqx, setting, error){
                    if(jqx.responseText.indexOf("needLogin")>-1){
                        window.location = "signin.jsp";
                    }else{
                        originalOptions.error(jqx, setting, error);
                    }
                };
            });
        },

        setupSystemWideEvent = function () {
            $(window).resize(function () {
                core.trigger("window:resize");
                core.trigger("clear:temporary");
            });

            $("html").bind("click contextmenu", function () {
                core.trigger("clear:temporary");
            });

            $('body').on("click contextmenu", ".temporary", function (e) {
                e.stopPropagation();
            });
        };
    setupAjax();
    //setupSystemWideEvent();

    return {};
});

