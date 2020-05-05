<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <title>乘客投诉</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/style/admin.css" media="all">
</head>
<body>

<div class="layui-fluid" id="component-tabs">
    <div class="layui-row">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">乘客投诉</div>
                <div class="layui-card-body">
                    <div class="layui-tab">
                        <ul class="layui-tab-title">
                            <li class="layui-this">投诉</li>
                            <li>结果查询</li>
                        </ul>
                        <div class="layui-tab-content">
                            <div class="layui-tab-item layui-show">
                                <div class="layui-form" style="padding: 20px 30px 10px 10px;">
                                    <div class="layui-form-item">
                                        <label class="layui-form-label">司机编号</label>
                                        <div class="layui-input-inline">
                                            <input type="text" name="driverId" class="layui-input">
                                        </div>
                                        <div class="layui-form-mid layui-word-aux">非必填，请提供尽可能详细的信息</div>
                                    </div>
                                    <div class="layui-form-item">
                                        <label class="layui-form-label">车辆编号</label>
                                        <div class="layui-input-inline">
                                            <input type="text" name="taxiId" class="layui-input">
                                        </div>
                                        <div class="layui-form-mid layui-word-aux">非必填，请提供尽可能详细的信息</div>
                                    </div>
                                    <div class="layui-form-item">
                                        <label class="layui-form-label">车牌号</label>
                                        <div class="layui-input-inline">
                                            <input type="text" name="plateNum" class="layui-input">
                                        </div>
                                        <div class="layui-form-mid layui-word-aux">非必填，请提供尽可能详细的信息</div>
                                    </div>
                                    <div class="layui-form-item">
                                        <label class="layui-form-label">发生时间</label>
                                        <div class="layui-input-inline">
                                            <input type="text" name="time" class="layui-input" lay-verify="required" id="time_select" autocomplete="off">
                                        </div>
                                    </div>
                                    <div class="layui-form-item">
                                        <label class="layui-form-label">发生地点</label>
                                        <div class="layui-input-block">
                                            <input type="text" name="location" class="layui-input" lay-verify="required">
                                        </div>
                                    </div>
                                    <div class="layui-form-item layui-form-text">
                                        <label class="layui-form-label">投诉内容</label>
                                        <div class="layui-input-block">
                                            <textarea name="reason" placeholder="请输入内容" class="layui-textarea" lay-verify="required"></textarea>
                                        </div>
                                    </div>
                                    <div class="layui-form-item">
                                        <label class="layui-form-label">乘客手机号</label>
                                        <div class="layui-input-inline">
                                            <input type="text" name="phone" lay-verify="required|phone" class="layui-input">
                                        </div>
                                    </div>
                                    <div class="layui-form-item">
                                        <label class="layui-form-label">乘客姓名</label>
                                        <div class="layui-input-inline">
                                            <input type="text" name="passengerName" lay-verify="required" class="layui-input">
                                        </div>
                                    </div>
                                    <div class="layui-form-item">
                                        <div class="layui-input-block">
                                            <div class="layui-footer" style="left: 0;">
                                                <button class="layui-btn" lay-submit lay-filter="complain-form-submit">立即提交</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="layui-tab-item">
                                <div class="layui-form layui-row" lay-filter="query-info" style="padding: 20px 30px 10px 10px;">
                                    <div class="layui-form-item">
                                        <div class="layui-inline">
                                            <label class="layui-form-label">投诉编号</label>
                                            <div class="layui-input-inline">
                                                <input type="text" name="id" autocomplete="off" lay-verify="required" class="layui-input" placeholder="请输入要查询的投诉编号">
                                            </div>
                                        </div>
                                        <div class="layui-inline">
                                            <div class="layui-footer" style="left: 0;">
                                                <button class="layui-btn layui-btn-normal" lay-submit lay-filter="complain-form-query">立即查询</button>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="layui-row layui-hide" id="content_from">
                                        <div class="layui-col-md6">
                                            <div class="layui-form-item">
                                                <label class="layui-form-label">司机编号</label>
                                                <div class="layui-input-block">
                                                    <input type="text" name="driverId" class="layui-input" readonly>
                                                </div>
                                            </div>
                                            <div class="layui-form-item">
                                                <label class="layui-form-label">车辆编号</label>
                                                <div class="layui-input-block">
                                                    <input type="text" name="taxiId" class="layui-input" readonly>
                                                </div>
                                            </div>
                                            <div class="layui-form-item">
                                                <label class="layui-form-label">车牌号</label>
                                                <div class="layui-input-block">
                                                    <input type="text" name="plateNum" class="layui-input" readonly>
                                                </div>
                                            </div>
                                            <div class="layui-form-item">
                                                <label class="layui-form-label">发生时间</label>
                                                <div class="layui-input-block">
                                                    <input type="text" name="time" class="layui-input" autocomplete="off" readonly>
                                                </div>
                                            </div>
                                            <div class="layui-form-item">
                                                <label class="layui-form-label">发生地点</label>
                                                <div class="layui-input-block">
                                                    <input type="text" name="location" class="layui-input" readonly>
                                                </div>
                                            </div>
                                            <div class="layui-form-item">
                                                <label class="layui-form-label">司机姓名</label>
                                                <div class="layui-input-inline">
                                                    <input type="text" name="driverName" class="layui-input" readonly>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="layui-col-md6">
                                            <div class="layui-form-item layui-form-text">
                                                <label class="layui-form-label">投诉内容</label>
                                                <div class="layui-input-block">
                                                    <textarea name="reason" class="layui-textarea" readonly></textarea>
                                                </div>
                                            </div>
                                            <div class="layui-form-item">
                                                <label class="layui-form-label">乘客手机号</label>
                                                <div class="layui-input-block">
                                                    <input type="text" name="passengerPhone" class="layui-input" readonly>
                                                </div>
                                            </div>
                                            <div class="layui-form-item">
                                                <label class="layui-form-label">乘客姓名</label>
                                                <div class="layui-input-inline">
                                                    <input type="text" name="passengerName" class="layui-input" readonly>
                                                </div>
                                            </div>
                                            <div class="layui-form-item">
                                                <label class="layui-form-label">投诉状态</label>
                                                <div class="layui-input-block">
                                                    <input type="text" name="status" class="layui-input" readonly id="status">
                                                </div>
                                            </div>
                                            <div class="layui-form-item">
                                                <label class="layui-form-label">处理结果</label>
                                                <div class="layui-input-block">
                                                    <input type="text" name="result" class="layui-input" readonly>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
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
    }).use(['index', 'sample', 'form', 'laydate'], function () {
        var $ = layui.$, admin = layui.admin, form = layui.form, localData = layui.data(layui.setter.tableName), laydate = layui.laydate;
        laydate.render({
            elem: '#time_select',
            type: 'datetime',
            format: 'yyyy-MM-dd HH:mm:ss'
        });
        form.on('submit(complain-form-submit)', function (data) {
            admin.req({
                url: localData.contextPath + '/api/complain',
                method: 'post',
                data: data.field,
                done: function (res) {
                    layer.alert(res.resultMessage, {icon: res.icon});
                }
            });
        });

        var content_from = $('#content_from');
        var status = $('#status');
        form.on('submit(complain-form-query)', function (data) {
            admin.req({
                url: localData.contextPath + '/api/complain/' + data.field.id,
                method: 'get',
                done: function (res) {
                    if (res.resultCode === 1) {
                        content_from.removeClass('layui-hide');
                        form.val("query-info", res.data);
                        if (res.data.state === 1) {
                            status.val('已处理');
                        } else if (res.data.state === 0) {
                            status.val('待处理');
                        }
                    } else {
                        layer.msg(res.resultMessage, {
                            offset: '15px'
                            , icon: res.icon
                            , time: 1000
                        });
                    }
                }
            });
        })
    });
</script>
</body>
</html>
