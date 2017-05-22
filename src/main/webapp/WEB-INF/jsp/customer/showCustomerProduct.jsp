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

<body style="padding-top:0px;">

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
            <li class="active">客户信息/查看客户购买产品记录</li>
        </ol>
    </div><!--/.row-->

    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">

                <div class="panel-body">
                    <form>
                        <div class="pull-right search">
                            <input type="text" name="productSerial" id="productSerial" placeholder="输入产品编码查询" value="${productSerial}"/>
                        </div>
                        </form>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>客户编码</th>
                            <th>产品编码</th>
                            <th>是否需要配置</th>
                            <th>配置列表</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pageInfo.data}" var="item" varStatus="status" begin="0" step="1">
                            <c:set var="clazzName" value="${status.count%2==0?'listTableLine1':'listTableLine2'}"></c:set>
                            <tr>
                                <td align="left">
                                        ${status.index+1}
                                </td>
                                <td align="left">
                                        ${item.customerserial}
                                    </a>
                                </td>
                                <td align="left">
                                        ${item.productserial}
                                </td>
                                <td align="left">
                                    <c:if test="${item.isconfigurationneed==0}">否</c:if>
                                    <c:if test="${item.isconfigurationneed==1}">是</c:if>
                                </td>
                                <td align="left">
                                    <c:if test="${item.isconfigurationneed==1}">${item.customerconfigurationidlist}</c:if>
                                </td>
                                <td align="left">
                                    <a href="${fullctx}/customer/toEditCustomerProduct?id=${item.id}" data-toggle="tooltip"  title="编辑客户购买产品信息"><span class="glyphicon glyphicon-pencil"></span></a>
                                    <a href="javascript:dofuncDelete(${item.id});" class="trash" data-toggle="tooltip"  title="删除客户信息"><span class="glyphicon glyphicon-trash"></span></a>
                                </td>

                            </tr>
                        </c:forEach>
                        <c:if test="${fn:length(pageInfo.data)==0}">
                            <tr>
                                <td align="center" colspan="6">
                                    暂无信息！
                                </td>
                            </tr>
                        </c:if>
                        </tbody>
                        </table>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="pagebar">
                            <tr>
                                <td>
                                    ${pageInfo.links }
                                </td>
                            </tr>
                        </table>
                </div>
            </div>
        </div>
    </div><!--/.row-->


</div><!--/.main-->

<script>

    function dofuncDelete(id) {
        if (!confirm("是否确认删除？")) {
            return;
        }
        window.location.href="${fullctx}/customer/deleteCustomerProduct?id="+id;
    }
    $('#productSerial').bind('keypress', function (event) {
        if (event.keyCode == "13") {
            var productSerial=$("#productSerial").val();
            window.location.href="${fullctx}/customer/showCustomerProduct?productSerial="+productSerial;
        }
    });

</script>

</body>

</html>
