/**
 * Created by qiyao on 2014/5/20.
 * email : yao.qi@changhong.com
 */
define([
    "jquery"
], function ($) {
    "use strict";
    $.ajaxPrefilter(function (options, originalOptions, jqXHR) {

//        if(!options.contentType){
//            options.contentType = "application/x-www-form-urlencoded; charset=utf-8";
//        }
        //TODO
//        if(!$.cookie("ci") || !$.cookie("ca")){
//            window.location="signin.jsp";
//        }
        //TODO 不能仅仅依靠status做判断，因为很多的dto都有status字段
//        var originalContext = originalOptions.context || originalOptions;
//        originalContext._success = originalContext.success;
//        options.success = function(data, textStatus, jqXHR){
//            if(data.status){
//                //自定义错误
//                if(data.status === 510){
//                    //TODO
//                }else if(data.status != 200){
//                    //TODO
//                }else{
//                    originalContext._success(data, textStatus, jqXHR);
//                }
//            }else{
//                originalContext._success(data, textStatus, jqXHR);
//            }
//
//        }
//        originalContext._error = originalOptions.error;
//        options.error = function(jqx, setting, error){
//            if(jqx.responseText.indexOf("needLogin")>-1){
//                window.location = window.basePath + "security/signIn";
//            }else{
//                originalOptions.error(jqx, setting, error);
//            }
//        };
    });

});