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
                    <form name="searchForm" id="searchForm" action="${ctx}/productconfiguration/productConfigurationList" method="post">
                        <table width="100%" border="0" align="center" cellpadding="2" cellspacing="0">
                            <tr>
                                <td align="right">
                                    产品配置内容：
                                </td>
                                <td class="tdulinput">
                                    <input type="text" name="content" id="content" value="${model.content}"/>
                                </td>
                                <td colspan="2">
                                    <input type="submit"  value="查 询" class="button primary"/>
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
                            <th>产品配置类型（1-标准配置，2-非标准配置）</th>
                            <th>产品配置内容</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pageInfo.data}" var="item" varStatus="status" begin="0" step="1">
                            <c:set var="clazzName" value="${status.count%2==0?'listTableLine1':'listTableLine2'}"></c:set>
                            <tr>
                                <td><input id="ids_${item.id}" name="ids" type="checkbox"  value="${item.id}"  data-id="${item.id}"/></td>
                                <td align="left">
                                        ${status.index+1}
                                </td>
                                <td align="left">
                                    <c:if test="${item.type==1}">标准配置</c:if>
                                    <c:if test="${item.type==2}">非标准配置</c:if>
                                </td>
                                <td align="left">
                                        ${item.content}
                                </td>

                            </tr>
                        </c:forEach>
                        <c:if test="${fn:length(pageInfo.data)==0}">
                            <tr>
                                <td align="center" colspan="3">
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
    var productconfigurationlistIds="${productconfigurationlist eq '' ? 0 : productconfigurationlist}";
    if(productconfigurationlistIds!='0'){
        var idsValue=productconfigurationlistIds.split(',');
        for(i=0;i<idsValue.length-1;i++){
            var idValue=idsValue[i];
            $('#ids_'+idValue).attr('checked',true);
            window.parent.addProductConfigurationId($('#ids_'+idValue).val(), $('#ids_'+idValue).attr("data-id"));
        }
    }
    

$('input[name="ids"]').click(function(){
    //选中的话给父窗口添加信息
    if(this.checked){
        window.parent.addProductConfigurationId($(this).val(), $(this).attr("data-id"));
    }else{
        window.parent.removeProductConfigurationId($(this).val(), $(this).attr("data-id"));
    }
});


</script>

</body>

</html>
