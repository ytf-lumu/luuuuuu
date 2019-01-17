var element;
layui.use(['element','layer'], function(){
    var $ = layui.jquery;
    element= layui.element;
    var layer= layui.layer;
});

var vm = new Vue({
    el: "#app",
    data: {
        title: '首页',
        yh: []
    },
    mounted: function () {
        this.getlist();//vue实例后调用这个函数
    },
    methods: {
        getlist: function () {
            var url = "/menu/indexdata";
            //请求服务器的api获取到品牌的数据列表
            $.ajax({
                //处理服务器异常信息提示
                url: url,
                success: function (response) {
                    vm.$data.yh = response;
                    menudata(response);
                }
            });
        },
        //tab删除选项卡
        tabdel: function () {
                console.info("tabdel");
        }
    }
});

 function  menudata(yh){
    layuiitem = "<ul class=\"layui-nav layui-nav-tree  \"  lay-filter=\"nico-menu\" lay-shrink=\"all\">";
    for (j in yh){
        if(yh[j].yqMenu.menuType == 'M'){
            var item ="<li class=\"layui-nav-item\">"
                + "<a href=\"javascript:;\">"+yh[j].yqMenu.menuName
                // + "<span class=\"layui-nav-more\"></span>"
                + "</a>";
            layuiitem += dgmenu(yh[j].children , item);
            layuiitem +="</li>";
        }else{
            layuiitem += "<li class=\"layui-nav-item\"  >" +
                "<a href=\"javascript:;\"  onclick='tabclick(this)' data-url="+menudata[j].yqMenu.url+" data-id="+yh[j].yqMenu.menuId+">"+
                yh[j].yqMenu.menuName+"</a>" +
                "</li>";
        }
    }
    layuiitem += "</ul>";
    $(".nico-nav").append(layuiitem);
    //重新渲染
    element.render('nav','nico-menu');
}
//递归导航栏
 function dgmenu(menudata, item){
    for (j in menudata){
        item +="<dl class=\"layui-nav-child\" >";
        if(menudata[j].yqMenu.menuType == 'M'){
            var em = " <dd><a href=\"javascript:;\">"+menudata[j].yqMenu.menuName+"</a>";
            item += dgmenu(menudata[j].children , em);
            item += "</dd>";
        }else{
            item += "<dd>" +
                "<a href=\"javascript:;\" onclick='tabclick(this)' data-url="+menudata[j].yqMenu.url+" data-id="+menudata[j].yqMenu.menuId+">"+
                menudata[j].yqMenu.menuName+"</a>" +
                "</dd>";
        }
        item +="</dl>";
    }
    return item;
}
//tab点击事件
 function tabclick(event) {
    //event.target   event.currentTarget  获取当前对象
   // var thisdata =  event.target;
    var tabname = $(event).text();
    var tabid = $(event).attr("data-id");
    var taburl = $(event).attr("data-url");
    var size = $(".layui-tab-title li[lay-id='"+tabid+"']").length;
     var ksize = $(".layui-tab-title li").length;
    console.log(tabname + " id== " + tabid +" size== " + size +"选项卡数："+ksize);

    //新增一个Tab选项
    if ( size == 0 ) {
        if(ksize > 5){
            layer.msg("选项卡数超过限制5");
            return
        }
        element.tabAdd('nicotab', {
            // title: '新选项<i class="layui-icon layui-unselect layui-tab-close">&#x1006;</i>' //用于演示
            title: tabname
            , content: "<iframe src="+taburl+" ></iframe>"
            , id: tabid  //new Date().getTime() //实际使用一般是规定好的id，这里以时间戳模拟下
        });
        element.tabChange('nicotab', tabid); //切换到：用户管理
    }else {
        //切换到指定Tab项
        element.tabChange('nicotab', tabid); //切换到：用户管理
    }
}