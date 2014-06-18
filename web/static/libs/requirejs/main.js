/**
 * Created by qiyao on 2014/5/6.
 */
function requirejsInit(path){
    requirejs.config({
        urlArgs: "v=1.0.0",
        baseUrl:path,
        paths:{
            "jquery":"static/libs/jquery/jquery-1.11.1",
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
            "echarts/chart/pie" : "static/libs/echart/build/echarts",

            "css": "static/libs/requirejs/css",
            "normalize": "static/libs/requirejs/normalize",
            "jqueryui.core":"static/libs/jqueryui/jquery.ui.core",
            "jqueryui.draggable":"static/libs/jqueryui/jquery.ui.draggable",
            "jqueryui.droppable":"static/libs/jqueryui/jquery.ui.droppable",
            "jqueryui.mouse":"static/libs/jqueryui/jquery.ui.mouse",
            "jqueryui.position":"static/libs/jqueryui/jquery.ui.position",
            "jqueryui.resizable":"static/libs/jqueryui/jquery.ui.resizable",
            "jqueryui.sortable":"static/libs/jqueryui/jquery.ui.sortable",
            "jqueryui.widget":"static/libs/jqueryui/jquery.ui.widget",
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
            "jquery.serializeJSON":["jquery"],
            "jqueryui.core":["jquery"],
            "jqueryui.widget":["jqueryui.core"],
            "jqueryui.position":["jqueryui.core"],
            "jqueryui.mouse":["jqueryui.widget"],
            "jqueryui.sortable":["jqueryui.mouse"],
            "jqueryui.resizable":["jqueryui.mouse"],
            "jqueryui.draggable":["jqueryui.mouse"],
            "jqueryui.droppable":["jqueryui.draggable"],

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



