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
            <li class="active">产品信息/新增&编辑</li>
        </ol>
    </div><!--/.row-->

    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="rightWrap1">
                    <div class="bgBorder" style="margin-top: 10px;">
                        <form name="inputForm" id="inputForm" method="post" action="#" onsubmit="return dofunc();">
                            <table width="100%" border="0" cellspacing="1" cellpadding="0" class="docBoxNoPanel">
                                <tr>
                                    <td align="right" class="nameInput" width="13%">
                                        常见问题：
                                    </td>
                                    <td class="nameInput2">
                                        <input name="commonfault" id="commonfault" type="text" value="${model.commonfault}"/>
                                        <span  style="color:red;">*</span>
                                    </td>
                                    <td align="right" class="nameInput" width="13%">
                                        故障判定：
                                    </td>
                                    <td class="nameInput2">
                                        <input name="faultjudgment" id="faultjudgment" type="text" value="${model.faultjudgment}"/>
                                        <span  style="color:red;">*</span>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" class="nameInput" width="13%">
                                        故障排除：
                                    </td>
                                    <td class="nameInput2">
                                        <input name="faultfix" id="faultfix" type="text" value="${model.faultfix}"/>
                                    </td>
                                    <td align="right" class="nameInput" width="13%">
                                        是否排除：
                                    </td>
                                    <td class="nameInput2">
                                        <%--<input name="isfixed" id="isfixed" type="text" value="${model.isfixed}"/>--%>
                                        <select id="isfixed" name="isfixed" style="width: 160px;">
                                            <option value="">--请选择产品配置类型--</option>
                                            <option value="1" <c:if test="${model.isfixed==1}">selected</c:if>>是</option>
                                            <option value="2" <c:if test="${model.isfixed==0}">selected</c:if>>否</option>
                                        </select>
                                        <span  style="color:red;">*</span>
                                    </td>
                                </tr>

                                <tr>
                                    <td colspan="4" class="nameInput2" style="height:40px;text-align: center;">
                                        <input type="submit"  value="保 存" class="button primary"/>
                                        <input type="button" value="重 填"  class="button" onclick="document.inputForm.reset()"/>
                                        <input type="button" value="返 回"  class="button" onclick="window.location.href='${fullctx}/productcommonfault/list'"/>
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
    $("#inputForm").validate({
        rules: {
            commonfault: "required",
            faultjudgment:"required",
            isfixed:"required",
        },
        messages: {
            commonfault: "必填项",
            faultjudgment: "必填项",
            isfixed: "必填项"
        }
    });
});

    function dofunc()
    {
        if (document.getElementById("id").value.length > 0) {
            document.inputForm.action = "${fullctx}/productcommonfault/edit";
        } else {
            document.inputForm.action ="${fullctx}/productcommonfault/add";
        }
    }
    focusName="";

</script>

</body>

</html>
