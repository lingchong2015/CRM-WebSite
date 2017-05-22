<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/commons/pages/taglibs.jsp" %>

<script type="text/javascript" language="javascript" src="${ctx}/scripts/jquery-1.11.1.min.js"></script>
<script type="text/javascript" language="javascript" src="${ctx}/scripts/commons/main.js?v=1.2.2"></script>
<script type="text/javascript" language="javascript" src="${ctx}/scripts/commons/tools.js?v=1.2.1"></script>
<script type="text/javascript" language="javascript" src="${ctx}/scripts/commons/common.js?v=1.2.1"></script>
<script type="text/javascript" language="javascript" src="${ctx}/scripts/commons/placefolder.js?v=1.2.1"></script>
<script type="text/javascript" language="javascript" src="${ctx}/scripts/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" language="javascript" src="${ctx}/scripts/commons/autostyle.js?v=1.1.1"></script>
<script type="text/javascript" language="javascript" src="${ctx}/scripts/commons/selected.js?v=1.1.1"></script>
<script type="text/javascript" language="javascript" src="${ctx}/scripts/commons/selectarea.js?v=1.1.1"></script>
<script type="text/javascript" language="javascript" src="${ctx}/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" language="javascript">var rootpath="${fullctx}";</script>
<script type="text/javascript" language="javascript">var ctx="${ctx}";</script>
<!-- 上传控件 -->
<script type="text/javascript" src="${ctx}/scripts/plupload-2.1.8/js/plupload.full.min.js"></script>
<!-- ueditor文本编辑器JS -->
<script type="text/javascript"  charset="utf-8" src="${ctx}/scripts/ueditor/ueditor.config.js"></script>
<%-- <script type="text/javascript"  charset="utf-8" src="${ctx}/scripts/ueditor/ueditorForIE.js"></script> --%>
<script type="text/javascript"  charset="utf-8" src="${ctx}/scripts/ueditor/ueditor.all.js"></script>
<script type="text/javascript"  charset="utf-8" src="${ctx}/scripts/ueditor/lang/zh-cn/zh-cn.js"></script>
<!-- 弹出框 -->
<script src="${ctx}/scripts/dialog/jquery.dialog.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	try{
		var mainObj=$(".toub span");
		mainObj.css("cursor","pointer");
		mainObj.attr("title","返回首页");
		if(mainObj.attr("disBack")!="true"){
			mainObj.click(function(){
		    	top.window.location.href="${ctx}/web/admin/index/frame";
		  	});
	  	}
  	}catch(e){}
});
</script>