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
            <li class="active">产品问题</li>
        </ol>
    </div><!--/.row-->

    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">

                <div class="searchBorder1">
                    <form name="searchForm" id="searchForm" action="${ctx}/productcommonfault/list" method="post">
                        <table width="100%" border="0" align="center" cellpadding="2" cellspacing="0">
                            <tr>
                                <td align="right">
                                    产品常见问题：
                                </td>
                                <td class="tdulinput">
                                    <input type="text" name="commonfault" id="commonfault" value="${model.commonfault}"/>
                                </td>
                                <td align="right">
                                    产品故障判定：
                                </td>
                                <td class="tdulinput">
                                    <input type="text" name="faultjudgment" id="faultjudgment" value="${model.faultjudgment}"/>
                                </td>
                            </tr>
                            <tr align="center">
                                <td colspan="4">
                                    <input type="submit"  value="查 询" class="button primary"/>
                                    <input type="button" value="重 填"  class="button" onclick="doRet()"/>
                                    <input type="button" value="新 增"  class="button" onclick="window.location.href='${fullctx}/productcommonfault/toAdd'"/>
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>
                <div class="panel-body">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>常见问题</th>
                            <th>故障判定</th>
                            <th>故障排除</th>
                            <th>是否排除</th>
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
                                    ${item.commonfault}
                                </td>
                                <td align="left">
                                        ${item.faultjudgment}
                                </td>
                                <td align="left">
                                        ${item.faultfix}
                                </td>
                                <td align="left">
                                        ${item.isfixed}
                                </td>
                                <td align="left">
                                    <a href="${fullctx}/productcommonfault/toEdit?id=${item.id}" data-toggle="tooltip"  title="编辑产品信息"><span class="glyphicon glyphicon-pencil"></span></a>
                                    <a href="javascript:dofuncDelete(${item.id});" class="trash" data-toggle="tooltip"  title="删除产品信息"><span class="glyphicon glyphicon-trash"></span></a>
                                </td>

                            </tr>
                        </c:forEach>
                        <c:if test="${fn:length(pageInfo.data)==0}">
                            <tr>
                                <td align="center" colspan="4">
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
        window.location.href="${fullctx}/productcommonfault/delete?id="+id;
    }
    
    function  doRet() {
        $("#type").val("");
        $("#content").val("");
    }
</script>

</body>

</html>
