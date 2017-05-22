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
            <li class="active">客户信息/新增&编辑</li>
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
                                    <td align="right" class="nameInput" width="18%">
                                        客户编码：
                                    </td>
                                    <td class="nameInput2">
                                        <input name="customerserial" id="customerserial" type="hidden" value="${model.customerserial}"/>
                                        ${model.customerserial}
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" class="nameInput" width="18%">
                                        产品编码：
                                    </td>
                                    <td class="nameInput2">
                                        <input name="productserial" id="productserial" type="text" value="${model.productserial}"/>
                                        <span  style="color:red;">*</span>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" class="nameInput" width="18%">
                                        是否需要配置：
                                    </td>
                                    <td class="nameInput2">
                                        <select name="isconfigurationneed" id="isconfigurationneed">
                                            <option value=1 <c:if test="${model.isconfigurationneed==1}">selected</c:if>>是</option>
                                            <option value=0 <c:if test="${model.isconfigurationneed==0}">selected</c:if>>否</option>
                                        </select>
                                        <span  style="color:red;">*</span>
                                    </td>
                                </tr>
                                <tr class="hideTr">
                                    <td align="right" class="nameInput" width="18%">
                                        特殊配置Id列表（以,分隔）：
                                    </td>
                                    <td class="nameInput2">
                                            <textarea name="customerconfigurationidlist" id="customerconfigurationidlist" style="width: 600px;height: 200px;">${model.customerconfigurationidlist}</textarea>
                                            <%--<input type="text" name="customerconfigurationidlist" id="customerconfigurationidlist" value="${model.customerconfigurationidlist}"/>--%>
                                        <span  style="color:red;">*</span>
                                    </td>
                                </tr>

                                <tr>
                                    <td colspan="4" class="nameInput2" style="height:40px;text-align: center;">
                                        <input type="submit"  value="保 存" class="button primary"/>
                                        <input type="button" value="重 填"  class="button" onclick="document.inputForm.reset()"/>
                                        <input type="button" value="返 回"  class="button" onclick="history.go(-1);"/>
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
            productserial:"required",
            isconfigurationneed:"required"
        },
        messages: {
            productserial: "必填项",
            isconfigurationneed: "必填项"
        }
    });

    var isconfigurationneedValue=${model.isconfigurationneed eq '' ? 0 : model.isconfigurationneed};
    if(isconfigurationneedValue==1){
        $(".hideTr").css("display","");
    }else{
        $(".hideTr").css("display","none");
    }
    $("#isconfigurationneed").change(function(){
        if($("#isconfigurationneed").val()==0){
            $(".hideTr").css("display","none");
        }else{
            $(".hideTr").css("display","");
        }
    });
});

    function dofunc()
    {
        if (document.getElementById("id").value.length > 0) {
            document.inputForm.action = "${fullctx}/customer/editCustomerProduct";
        } else {
            document.inputForm.action ="${fullctx}/customer/addCustomerProduct";
        }
    }
    focusName="";

</script>

</body>

</html>
