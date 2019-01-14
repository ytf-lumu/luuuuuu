$(function(){

});
var vm = new Vue({
    el: "#app",
    data: {
        title: '首页',
        yh: []
    },
    mounted: function () {
        //this.getlist();//vue实例后调用这个函数
    },
    methods: {
        getlist: function () {
            var url = "/xsll/body";
            //请求服务器的api获取到品牌的数据列表
            $.ajax({
                //处理服务器异常信息提示
                url: url,
                success: function (response) {
                    console.info(response);
                    vm.$data.yh = response;
                    vm.$data.title = "vscode";
                    console.info(vm.$data.title);
                }
            });
        }
    }
});
layui.use('element', function(){
        var element = layui.element;
        console.info("element");
        //导航条点击监听
        element.on('nav(demo)', function(elem) {
            console.log($(this).text() + $(this).attr("data-id"));
            var tabname = $(this).text();
            var tabid = $(this).attr("data-id");
            console.log("id=="+$(".layui-tab-title li[lay-id='"+tabid+"']").length);
            //新增一个Tab选项
            if ( $(".layui-tab-title li[lay-id='"+tabid+"']").length > 0 ) {
            element.tabAdd('nicotab', {
               // title: '新选项<i class="layui-icon layui-unselect layui-tab-close">&#x1006;</i>' //用于演示
                title: tabname
                , content: '内容' + (Math.random() * 1000 | 0)
                , id: tabid  //new Date().getTime() //实际使用一般是规定好的id，这里以时间戳模拟下
            });
            }else {

                //切换到指定Tab项
                 element.tabChange('nicotab', tabid); //切换到：用户管理
            }
        });

    });