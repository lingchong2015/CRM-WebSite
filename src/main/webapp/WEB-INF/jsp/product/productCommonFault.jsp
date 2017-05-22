<!DOCTYPE html>
<%@ page language="java"  contentType="text/html; charset=UTF-8" %>
<!--引入ctx变量-->
<%@ include file="/commons/pages/taglibs.jsp" %>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="${ctx}/img/custom.png">
    <title>CRM系统</title>
    <%@ include file="/commons/pages/css.jsp" %>
</head>

<body style="padding-top: 0px;">

<%--<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">--%>
<div class="col-sm-12 col-lg-12  main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
            <li class="active">产品问题${productcommonfaultlist}</li>
        </ol>
    </div><!--/.row-->

    <div class="row">
        <div class="col-lg-12">
                <div>
                        <iframe id="subframe" name="subframe"
                                src="${ctx}/productcommonfault/productCommonFaultList?productcommonfaultlist=${productcommonfaultlist}" frameborder="0" height="400px"
                                <%--src="${ctx}/productcommonfault/productCommonFaultList" frameborder="0" height="400px"--%>
                                width="100%"></iframe>
                </div>
                <div class="searchBorder1">

                    <div class="panel panel-default" style="text-align: left;">
                        <div class="panel-heading" style="line-height: 50px;height: 50px;">
                            <h3 class="panel-title">
                                当前选择了以下配置：
                                <div style="float:right;">
                                    <a class="btn btn-primary" data-dismiss="modal" aria-hidden="true" onclick="select();">确定</a>
                                </div>
                            </h3>
                        </div>
                        <div class="panel-body" id="productCommonFaultIdPanel"></div>
                    </div>


            </div>
        </div>
    </div><!--/.row-->


</div><!--/.main-->

<script src="${ctx}/js/jquery-1.11.1.min.js"></script>
<script src="${ctx}/js/bootstrap.min.js"></script>
<script src="${ctx}/js/chart.min.js"></script>
<script src="${ctx}/js/chart-data.js"></script>
<script src="${ctx}/js/easypiechart.js"></script>
<script src="${ctx}/js/easypiechart-data.js"></script>
<script src="${ctx}/js/bootstrap-datepicker.js"></script>
<script src="${ctx}/js/bootstrap-table.js"></script>
<script>
    function addProductCommonFaultId(id,name){
        $("#productCommonFaultIdPanel").append('<a data-name-a="a" data-id="'+id+'" href="javascript:void();" style="margin-left: 20px;">'+name+' <i class="fa fa-times" style="cursor:pointer;" title="点击移除" onclick="clickRemoveUserFun('+id+')"></i></a>');
    }
    //清除用户(子页面调用)
    function removeProductCommonFaultId(id,name){
        $("#productCommonFaultIdPanel>a[data-id="+id+"]").remove();
    }

    //点击确定传值给上一页,关闭本页
    function select(){
        var ids="";
        $('#productCommonFaultIdPanel > a[data-name-a="a"]').each(function(){
            ids+=$(this).attr("data-id")+",";
        });
        window.opener.setProductcommonfaultlist(ids);
        window.close();
    }

</script>

</body>

</html>
