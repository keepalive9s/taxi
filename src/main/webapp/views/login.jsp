<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <title>登入</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/style/admin.css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/style/login.css" media="all">
</head>
<body>
<div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" style="display: none;">

    <div class="layadmin-user-login-main">
        <div class="layadmin-user-login-box layadmin-user-login-header">
            <h2>TAXI</h2>
            <p>出租车管理系统</p>
        </div>
        <div class="layui-tab layui-tab-brief" lay-filter="login-role-switch">
            <ul class="layui-tab-title layui-row">
                <li class="layui-col-md6 layui-this">司机</li>
                <li class="layui-col-md6">管理员</li>
            </ul>
            <div class="layui-tab-content ">
                <div class="layui-tab-item layui-show">
                    <div class="layadmin-user-login-box layadmin-user-login-body layui-form">
                        <div class="layui-form-item">
                            <label class="layadmin-user-login-icon layui-icon layui-icon-username"></label>
                            <input type="text" name="id" lay-verify="required" placeholder="司机ID" class="layui-input" value="217149">
                        </div>
                        <div class="layui-form-item">
                            <label class="layadmin-user-login-icon layui-icon layui-icon-password"></label>
                            <input type="password" name="password" lay-verify="required" placeholder="密码" class="layui-input" value="124219">
                        </div>
                        <div class="layui-form-item" style="margin-bottom: 20px;">
                            <input type="checkbox" name="remember" lay-skin="primary" title="记住密码">
                        </div>
                        <div class="layui-form-item">
                            <button class="layui-btn layui-btn-fluid" lay-submit lay-filter="driver-login-submit" id="driver_login_btn">登 入</button>
                        </div>
                    </div>
                </div>
                <div class="layui-tab-item">
                    <div class="layadmin-user-login-box layadmin-user-login-body layui-form">
                        <div class="layui-form-item">
                            <label class="layadmin-user-login-icon layui-icon layui-icon-username"></label>
                            <input type="text" name="username" lay-verify="required" placeholder="管理员账号" class="layui-input" value="root">
                        </div>
                        <div class="layui-form-item">
                            <label class="layadmin-user-login-icon layui-icon layui-icon-password"></label>
                            <input type="password" name="password" lay-verify="required" placeholder="密码" class="layui-input" value="root">
                        </div>
                        <div class="layui-form-item" style="margin-bottom: 20px;">
                            <input type="checkbox" name="remember" lay-skin="primary" title="记住密码">
                        </div>
                        <div class="layui-form-item">
                            <button class="layui-btn layui-btn-fluid" lay-submit lay-filter="admin-login-submit" id="admin_login_btn">登 入</button>
                        </div>
                        <div class="layui-trans layui-form-item layadmin-user-login-other">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
<script>
    layui.config({
        base: '${pageContext.request.contextPath}/static/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'user'], function () {
        var $ = layui.$, setter = layui.setter, admin = layui.admin, form = layui.form, element = layui.element;
        layui.data(setter.tableName, {
            key: 'contextPath',
            value: '${pageContext.request.contextPath}'
        });
        var login_btn = $("#driver_login_btn");
        element.on('tab(login-role-switch)', function (data) {
            if (data.index === 0) {
                login_btn = $("#driver_login_btn");
            } else if (data.index === 1) {
                login_btn = $("#admin_login_btn");
            }
        });
        $(document).keydown(function (e) {
            if (e.keyCode === 13) {
                login_btn.trigger("click");
            }
        });

        //司机登陆提交
        form.on('submit(driver-login-submit)', function (obj) {
            //请求登入接口
            admin.req({
                url: '${pageContext.request.contextPath}/api/driver/login'
                , method: "post"
                , data: obj.field
                , done: function (res) {
                    layer.msg(res.resultMessage, {
                        offset: '15px'
                        , icon: res.icon
                        , time: 1000
                    }, function () {
                        if (res.resultCode === 1) {
                            location.href = '${pageContext.request.contextPath}/driver';
                        }
                    });
                }
            });
        });

        //管理员登陆提交
        form.on('submit(admin-login-submit)', function (obj) {
            //请求登入接口
            admin.req({
                url: '${pageContext.request.contextPath}/api/admin/login'
                , method: "post"
                , data: obj.field
                , done: function (res) {
                    layer.msg(res.resultMessage, {
                        offset: '15px'
                        , icon: res.icon
                        , time: 1000
                    }, function () {
                        if (res.resultCode === 1) {
                            location.href = '${pageContext.request.contextPath}/admin';
                        }
                    });
                }
            });
        });
    });
</script>

</body>
</html>
