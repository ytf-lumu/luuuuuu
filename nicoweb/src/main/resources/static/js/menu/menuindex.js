var layuiitem;
layui.use('element', function() {
    var $ = layui.jquery;
    element = layui.element;
});
var vm = new Vue({
    el: "#app",
    data: {
        title: 'menu',

        yh: []
    },
    mounted: function () {
        //this.getlist();//vue实例后调用这个函数
    },
    methods: {
        getlist: function () {
            var url = "/menu/indexdata";
            //请求服务器的api获取到品牌的数据列表
            $.ajax({
                //处理服务器异常信息提示
                url: url,
                success: function (response) {
                    console.info(response);
                    vm.$data.yh = response;
                    vm.menudata(response);

                }
            });
        }
    }
});