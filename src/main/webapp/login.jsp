<!DOCTYPE html>
<!--乱码问题-->
<%@ page language="java"  contentType="text/html; charset=UTF-8" %>
<!--引入ctx变量-->
<%@ include file="/commons/pages/taglibs.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="${ctx}/img/custom.png">
    <title>登录-CRM系统</title>

    <!--全局css.jsp位置-->
    <%@ include file="/commons/pages/css.jsp" %>

    <!--[if lt IE 9]>
    <script src="${ctx}/js/html5shiv.js"></script>
    <script src="${ctx}/js/respond.min.js"></script>
    <![endif]-->

</head>

<body>

<div class="row">
    <div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
        <div class="login-panel panel panel-default">
            <div class="panel-heading">登录</div>
            <div class="panel-body">
                <form role="form"  method="post" action="${ctx}/login/index">
                    <fieldset>
                        <div class="form-group">
                            <input class="form-control" placeholder="username" name="username" type="username" autofocus="">
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="password" name="password" type="password" value="">
                        </div>
                        <div class="checkbox">
                            <label>
                                <input name="remember" type="checkbox" value="">记住我
                            </label>
                        </div>
                        <input type="submit" class="btn btn-primary btn-block" value="登  录"/>
                        <%--<a href="index.jsp" class="btn btn-primary">Login</a>--%>
                    </fieldset>
                </form>
            </div>
        </div>
    </div><!-- /.col-->
</div><!-- /.row -->


<script src="${ctx}/js/jquery-1.11.1.min.js"></script>
<script src="${ctx}/js/bootstrap.min.js"></script>
<script src="${ctx}/js/chart.min.js"></script>
<script>
</script>
</body>

</html>
