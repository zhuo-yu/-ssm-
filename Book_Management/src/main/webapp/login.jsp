<%--
  Created by IntelliJ IDEA.
  User: 卓
  Date: 2019/11/15
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN" class="bootstrap-admin-vertical-centered">
<head>
    <meta charset="UTF-8">
    <title>图书馆管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="static/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="static/css/bootstrap-theme.min.css"/>
    <link rel="stylesheet" href="static/css/bootstrap-admin-theme.css"/>
    <link rel="stylesheet" href="static/css/bootstrap-admin-theme.css"/>
    <script src="static/js/bootstrap.min.js"></script>
    <script src="static/jQuery/jquery-3.1.1.min.js"></script>
    <script src="static/ajax-lib/ajaxutils.js"></script>
    <script src="static/js/login.js"></script>
</head>

<style type="text/css">
    .alert{
        margin: 0 auto 20px;
        text-align: center;
    }
</style>

<script src="static/js/jquery.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>


<body class="bootstrap-admin-without-padding">
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <div class="alert alert-info">
                <a class="close" data-dismiss="alert" href="#"></a>
                欢迎登录图书馆管理系统
            </div>

            <form class="bootstrap-admin-login-form" method="post" action="Admin/Login">
                <%
                    String fail = (String)session.getAttribute("fail");//验证登录失败session信息
                    if(fail!=null){
                %>
                <label class="control-label" for="username"><%=fail%>></label>

                <% session.removeAttribute("fail");}%>
                <%
                    String register = (String)session.getAttribute("register");//验证注册成功session信息
                    if(register!=null){
                %>
                <label class="control-label" for="username"><%=register%></label>

                <%session.removeAttribute("register");}%>
                <div class="form-group">
                    <label class="control-label" for="username">账&nbsp;号</label>
                    <input type="text" class="form-control" id="username" name="username" required="required" placeholder="学号"/>
                    <label class="control-label" for="username" style="display:none;"></label>
                </div>
                <div class="form-group">
                    <label class="control-label" for="password">密&nbsp;码</label>
                    <input type="password" class="form-control" id="password" name="password" required="required" placeholder="密码"/>
                    <label class="control-label" for="username" style="display:none;"></label>
                </div>

                <label class="control-label" for="password">没有账号请<a href="Jsp_page/register.jsp" style="color:blue;">注册</a></label>
                <br>
                <input type="submit" class="btn btn-lg btn-primary"  value="登&nbsp;&nbsp;&nbsp;&nbsp;录"/>

            </form>
        </div>
    </div>
</div>
<div class="modal fade" id="modal_info" tabindex="-1" role="dialog" aria-labelledby="addModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="infoModalLabel">提示</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-lg-12" id="div_info"></div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" id="btn_info_close" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
