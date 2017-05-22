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
                                                <%--<input type="button" value="新 增"  class="button" onclick="window.location.href='${fullctx}/productcommonfault/toAdd'"/>--%>
                                            </td>
                                        </tr>
                                    </table>
                                </form>
                            </div>
                            <div class="panel-body">
                                <table class="table table-striped">
                                    <thead>
                                    <tr>
                                        <th style="width:6%;"><input type="checkbox" disabled="disabled"/></th>
                                        <th>序号</th>
                                        <th>常见问题</th>
                                        <th>故障判定</th>
                                        <th>故障排除</th>
                                        <th>是否排除</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${pageInfo.data}" var="item" varStatus="status" begin="0" step="1">
                                        <c:set var="clazzName" value="${status.count%2==0?'listTableLine1':'listTableLine2'}"></c:set>
                                        <tr>
                                            <td><input id="ids_${item.id}" name="ids" type="checkbox"  value="${item.id }"  data-id="${item.id}"/></td>
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
    //编辑时回带已经选定的值
    //为空时首次新增，不为空需要选定某个值(id不为0)

    var productcommonfaultlistIds="${productcommonfaultlist eq '' ? 0 : productcommonfaultlist}";
    if(productcommonfaultlistIds!='0'){
        var idsValue=productcommonfaultlistIds.split(',');
        for(i=0;i<idsValue.length-1;i++){
            var idValue=idsValue[i];
            $('#ids_'+idValue).attr('checked',true);
            window.parent.addProductCommonFaultId($('#ids_'+idValue).val(), $('#ids_'+idValue).attr("data-id"));
        }
    }


$('input[name="ids"]').click(function(){
    //选中的话给父窗口添加信息
    if(this.checked){
        window.parent.addProductCommonFaultId($(this).val(), $(this).attr("data-id"));
    }else{
        window.parent.removeProductCommonFaultId($(this).val(), $(this).attr("data-id"));
    }
});


</script>

</body>

</html>
