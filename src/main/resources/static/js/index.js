//iframe自适应
$(window).on('resize', function () {
    var $content = $('.content');
    $content.height($(this).height() - 160);
    $content.find('iframe').each(function () {
        $(this).height($content.height());
    });
}).resize();


var vm = new Vue({
    el: '#rrapp',
    data: {
        main: "generator.html",//设置首页
        navTitle: "库内表"
    },
    methods: {
        donate: function () {
            layer.open({
                type: 2,
                title: '说明',
                area: ['55%', '70%'],
                closeBtn: 1,
                skin: 'layui-layer-molv',
                anim: 1, //0-6的动画形式，-1不开启
                shadeClose: true,//true:点击阴影关闭窗体
                content: ['main.html']
            });
        }
    }
});

//路由
var router = new Router();
var menus = ["main.html", "generator.html"];
routerList(router, menus);
router.start();

function routerList(router, menus) {
    for (var index in menus) {
        router.add('#' + menus[index], function () {
            var url = window.location.hash;

            //替换iframe的url
            vm.main = url.replace('#', '');

            //导航菜单展开
            $(".treeview-menu li").removeClass("active");
            $("a[href='" + url + "']").parents("li").addClass("active");

            vm.navTitle = $("a[href='" + url + "']").text();
        });
    }
}
