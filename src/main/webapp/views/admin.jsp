<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <title>管理员端 - 出租车管理系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/style/admin.css" media="all">
</head>
<body>
<div id="LAY_app">
    <div class="layui-layout layui-layout-admin">
        <!-- 头部区域 -->
        <div class="layui-header">
            <ul class="layui-nav layui-layout-left">
                <li class="layui-nav-item layadmin-flexible" lay-unselect>
                    <a href="javascript:;" layadmin-event="flexible" title="侧边伸缩">
                        <i class="layui-icon layui-icon-shrink-right" id="LAY_app_flexible"></i>
                    </a>
                </li>
                <li class="layui-nav-item" lay-unselect>
                    <a href="javascript:;" layadmin-event="refresh" title="刷新">
                        <i class="layui-icon layui-icon-refresh-3"></i>
                    </a>
                </li>
            </ul>
            <ul class="layui-nav layui-layout-right" lay-filter="layadmin-layout-right">
                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <a href="javascript:;" layadmin-event="theme">
                        <i class="layui-icon layui-icon-theme"></i>
                    </a>
                </li>
                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <a href="javascript:;" layadmin-event="note">
                        <i class="layui-icon layui-icon-note"></i>
                    </a>
                </li>
                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <a href="javascript:;" layadmin-event="fullscreen">
                        <i class="layui-icon layui-icon-screen-full"></i>
                    </a>
                </li>
                <li class="layui-nav-item" lay-unselect>
                    <a href="javascript:;">
                        <cite>${sessionScope.currentAdmin.username}</cite>
                    </a>
                    <dl class="layui-nav-child layui-hide-xs">
                        <dd><a lay-href="${pageContext.request.contextPath}/static/pages/password.html">修改密码</a></dd>
                        <hr>
                        <dd style="text-align: center;"><a href="${pageContext.request.contextPath}/logout">退出</a></dd>
                    </dl>
                </li>

                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <a href="javascript:;"><i
                            class="layui-icon layui-icon-more-vertical"></i></a>
                </li>
                <li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-unselect>
                    <a href="javascript:;" layadmin-event="more"><i class="layui-icon layui-icon-more-vertical"></i></a>
                </li>
            </ul>
        </div>

        <!-- 侧边菜单 -->
        <div class="layui-side layui-side-menu">
            <div class="layui-side-scroll">
                <div class="layui-logo">
                    <span>出租车管理系统</span>
                </div>
                <ul class="layui-nav layui-nav-tree" lay-shrink="all" id="LAY-system-side-menu"
                    lay-filter="layadmin-system-side-menu">
                    <li data-name="taxi" class="layui-nav-item layui-nav-itemed">
                        <a href="javascript:;" lay-href="${pageContext.request.contextPath}/static/pages/taxi/taxi_manage.html" lay-tips="车辆管理" lay-direction="2">
                            <i class="layui-icon layui-icon-home"></i>
                            <cite>车辆管理</cite>
                        </a>
                    </li>
                    <li data-name="driver" class="layui-nav-item">
                        <a href="javascript:;" lay-href="${pageContext.request.contextPath}/static/pages/driver/driver_manage.html" lay-tips="驾驶员管理" lay-direction="2">
                            <i class="layui-icon layui-icon-home"></i>
                            <cite>驾驶员管理</cite>
                        </a>
                    </li>
                    <li data-name="contract" class="layui-nav-item">
                        <a href="javascript:;" lay-href="${pageContext.request.contextPath}/static/pages/contract/contract_manage.html" lay-tips="签约管理" lay-direction="2">
                            <i class="layui-icon layui-icon-home"></i>
                            <cite>签约管理</cite>
                        </a>
                    </li>
                    <li data-name="rule" class="layui-nav-item">
                        <a href="javascript:;" lay-href="${pageContext.request.contextPath}/static/pages/rule/rule_manage.html" lay-tips="奖罚管理" lay-direction="2">
                            <i class="layui-icon layui-icon-home"></i>
                            <cite>奖罚管理</cite>
                        </a>
                    </li>
                    <li data-name="complain" class="layui-nav-item">
                        <a href="javascript:;" lay-href="${pageContext.request.contextPath}/static/pages/complain/complain_manage.html" lay-tips="投诉管理" lay-direction="2">
                            <i class="layui-icon layui-icon-home"></i>
                            <cite>投诉管理</cite>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
        <!-- 主体内容 -->
        <div class="layui-body" id="LAY_app_body">
            <div class="layadmin-tabsbody-item layui-show">
                <iframe src="${pageContext.request.contextPath}/static/pages/taxi/taxi_manage.html" frameborder="0" class="layadmin-iframe"></iframe>
            </div>
        </div>
        <!-- 辅助元素，一般用于移动设备下遮罩 -->
        <div class="layadmin-body-shade" layadmin-event="shade"></div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
<script>
    layui.config({
        base: '${pageContext.request.contextPath}/static/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'sample']);
</script>
</body>
</html>