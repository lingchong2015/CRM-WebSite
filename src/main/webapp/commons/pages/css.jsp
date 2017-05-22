<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/commons/pages/taglibs.jsp" %>
<link rel="stylesheet" type="text/css" href="${ctx}/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/datepicker3.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/styles.css" />

<!--自定义表格样式-->
<link rel="stylesheet" type="text/css" href="${ctx}/css/main.css" />
<!--自定义form表单中样式-->
<link rel="stylesheet" type="text/css" href="${ctx}/css/autostyle.css" />
<!--github button样式-->
<link rel="stylesheet" type="text/css" href="${ctx}/css/buttons/github/buttons.css" />

<script type="text/javascript" language="javascript">var rootpath="${fullctx}";</script>
<script type="text/javascript" language="javascript">var ctx="${ctx}";</script>
<!--[if lt IE 9]>
<script src="${ctx}/js/html5shiv.js"></script>
<script src="${ctx}/js/respond.min.js"></script>
<![endif]-->

<script src="${ctx}/js/jquery-1.11.1.min.js"></script>
<script src="${ctx}/js/bootstrap.min.js"></script>
<script src="${ctx}/js/chart.min.js"></script>
<script src="${ctx}/js/chart-data.js"></script>
<script src="${ctx}/js/easypiechart.js"></script>
<script src="${ctx}/js/easypiechart-data.js"></script>
<script src="${ctx}/js/bootstrap-datepicker.js"></script>
<script src="${ctx}/js/bootstrap-table.js"></script>
<script type="text/javascript" language="javascript" src="${ctx}/js/custom/My97DatePicker/WdatePicker.js"></script>
<!--校验-->
<script src="${ctx}/js/custom/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script src="${ctx}/js/custom/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>

<script type="text/javascript">
    !function ($) {
        $(document).on("click","ul.nav li.parent > a > span.icon", function(){
            $(this).find('em:first').toggleClass("glyphicon-minus");
        });
        $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
    }(window.jQuery);

    $(window).on('resize', function () {
        if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
    })
    $(window).on('resize', function () {
        if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
    })
</script>