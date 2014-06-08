module.exports = function(grunt) {

    // 配置Grunt各种模块的参数
    grunt.initConfig({
        copy:  {
            spider:{
                expand: true,
                src: ["static/**", "!static/libs/echart/src/**"],
                dest:"../bd-spider/src/main/webapp/"
            },
            mingwang:{
                expand: true,
                src: ["static/**", "!static/libs/echart/src/**"],
                dest:"../bd-mingwang/src/main/webapp/"
            }
        }
    });

    // 从node_modules目录加载模块文件
    grunt.loadNpmTasks('grunt-contrib-copy');

    // 每行registerTask定义一个任务
    grunt.registerTask('default', ['copy']);

};