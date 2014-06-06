/**
 * Created by qiyao on 2014/5/6.
 */
function requirejsInit(path){
    requirejs.config({
        urlArgs: "v=1.0.0",
        baseUrl:path,
        paths:{
            "jquery":"static/libs/jquery/jquery-1.11.1.min",
            "jquery.prefilter":"static/libs/jquery/jquery.prefilter",
            "jquery.serializeJSON":"static/libs/jquery/jquery.serializeJSON",
            "bootstrap":"static/libs/bs/js/bootstrap",
            "domReady":"static/libs/requirejs/domReady",
            "text":"static/libs/requirejs/text",
            "underscore":"static/libs/app/underscore",
            "backbone":"static/libs/app/backbone",
            "echarts" : "static/libs/echart/build/echarts",
            "echarts/chart/bar" : "static/libs/echart/build/echarts",
            "echarts/chart/line" : "static/libs/echart/build/echarts",
            "css": "static/libs/requirejs/css",
            "normalize": "static/libs/requirejs/normalize"
        },

        shim: {
            "underscore":{
                exports:"_"
            },
            "bootstrap": ["jquery"],
            "backbone": {
                deps: ['underscore', 'jquery.prefilter', "jquery.serializeJSON"],
                exports: 'Backbone'
            },
            "jquery.prefilter":["jquery"],
            "jquery.serializeJSON":["jquery"]
        }
//        ,
//        map: {
//            '*': {
//                'css': './static/libs/requirejs/css'
//            }
//        }
    });
}

if(!window.basePath){
    window.basePath = "./";
}
requirejsInit(window.basePath);



