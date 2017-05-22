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

<%--<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">--%>
<div class="col-sm-12 col-lg-12  main">
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">

                <div class="searchBorder1">
                    <form name="searchForm" id="searchForm" action="${ctx}/productspecification/productSpecificationList" method="post">
                        <table width="100%" border="0" align="center" cellpadding="2" cellspacing="0">
                            <tr>
                                <td align="right">
                                    产品规格名称：
                                </td>
                                <td class="tdulinput">
                                    <input type="text" name="name" id="name" value="${model.name}"/>
                                </td>
                                <td align="right">
                                    产品价格：
                                </td>
                                <td class="tdulinput">
                                    <input type="text" name="price" id="price" value="${model.price}"/>
                                </td>
                            </tr>
                            <tr align="center">
                                <td colspan="4">
                                    <input type="submit"  value="查 询" class="button primary"/>
                                    <input type="button" value="确 定"  class="button"  onclick="confirmSelect();"/>
                                    <%--<div style="float:right;">--%>
                                        <%--<a class="btn btn-primary" data-dismiss="modal" aria-hidden="true" onclick="select();">确定</a>--%>
                                    <%--</div>--%>
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>
                <div class="panel-body">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th style="width:6%;"><input type="radio" disabled="disabled"/></th>
                            <th>序号</th>
                            <th>产品规格名称</th>
                            <th>产品规格添加时间</th>
                            <th>产品规格是否删除</th>
                            <th>产品规格删除时间</th>
                            <th>产品价格</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pageInfo.data}" var="item" varStatus="status" begin="0" step="1">
                            <c:set var="clazzName" value="${status.count%2==0?'listTableLine1':'listTableLine2'}"></c:set>
                            <tr>
                                <td><input id="ids_${item.id}" name="ids" type="radio"  value="${item.id }"  data-id="${item.id}"/></td>
                                <td align="left">
                                        ${status.index+1}
                                </td>
                                <td align="left">
                                    ${item.name}
                                </td>
                                <td align="left">
                                        <fmt:formatDate value="${item.adddatetime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td align="left">
                                        <c:if test="${item.isdeleted==1}">是</c:if>
                                        <c:if test="${item.isdeleted==0}">否</c:if>
                                </td>
                                <td align="left">
                                        <fmt:formatDate value="${item.deletedatetime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td align="left">
                                        ${item.price}
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
var specificationId="${specification eq '' ? 0 : specification}";
if(specificationId!=0){
    $("input[name='ids'][value='${specification}']").attr("checked",true);
}


    function confirmSelect(){
        var radioId= $("input[name='ids']:checked").val();
        window.opener.setSpecification(radioId);
        window.close();
    }

    function dofuncDelete(id) {
        if (!confirm("是否确认删除？")) {
            return;
        }
        window.location.href="${fullctx}/productspecification/delete?id="+id;
    }
    
    function  doRet() {
        $("#type").val("");
        $("#content").val("");
    }

</script>

</body>

</html>
