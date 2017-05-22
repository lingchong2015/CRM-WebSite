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
            <li class="active">产品问题/新增&编辑</li>
        </ol>
    </div><!--/.row-->

    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="rightWrap1">
                    <div class="bgBorder" style="margin-top: 10px;">
                        <form name="inputForm" id="inputForm" method="post" action="#" onsubmit="return dofunc();">
                            <table width="100%" border="0" cellspacing=" 1" cellpadding="0" class="docBoxNoPanel">
                                <tr>
                                    <td align="right" class="nameInput" width="13%">
                                        产品配置类型：
                                    </td>
                                    <td class="nameInput2">
                                        <%--<input name="type" id="type" type="text" value="${model.type}"/>--%>
                                        <select id="type" name="type" style="width: 160px;">
                                            <option value="">--请选择产品配置类型--</option>
                                            <option value="1" <c:if test="${model.type==1}">selected</c:if>>标准配置</option>
                                            <option value="2" <c:if test="${model.type==2}">selected</c:if>>非标准配置</option>
                                        </select>
                                        <span  style="color:red;">*</span>
                                    </td>
                                    <td align="right" class="nameInput" width="13%">
                                        产品配置内容：
                                    </td>
                                    <td class="nameInput2">
                                        <input name="content" id="content" type="text" value="${model.content}"/>
                                        <span  style="color:red;">*</span>
                                    </td>
                                </tr>

                                <tr>
                                    <td colspan="4" class="nameInput2" style="height:40px;text-align: center;">
                                        <input type="submit"  value="保 存" class="button primary"/>
                                        <input type="button" value="重 填"  class="button" onclick="document.inputForm.reset()"/>
                                        <input type="button" value="返 回"  class="button" onclick="window.location.href='${fullctx}/productconfiguration/list'"/>
                                        <input type="hidden" name="id" id="id" value="${model.id}"/>
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div><!--/.row-->


</div><!--/.main-->

<script>

$().ready(function() {
// 验证提交表单
    $("#inputForm").validate({
        rules: {
            type: "required",
            content:"required",
        },
        messages: {
            type: "必填项",
            content: "必填项"
        }
    });
});

    function dofunc()
    {
        if (document.getElementById("id").value.length > 0) {
            document.inputForm.action = "${fullctx}/productconfiguration/edit";
        } else {
            document.inputForm.action ="${fullctx}/productconfiguration/add";
        }
    }
    focusName="";

</script>

</body>

</html>
