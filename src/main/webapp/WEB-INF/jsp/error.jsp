<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/pages/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<title>出错啦...</title>
	<link rel="Shortcut Icon" href="${ctx}/img/custom.png" />
</head>
<body>
	<table border="0" align="center" cellpadding="0" cellspacing="0" style="text-align:center; height:100%; width:350px;color:#0672CC;align:center; margin: 0 auto;">
		<tr>
			<td style="vertical-align: middle;font-family: 黑体;text-align: right;">
				<img alt="" src="${ctx}/img/promptImg.gif" border="0" />
			</td>
			<td style="text-align: left;padding-bottom:0px;font-size:20px;">
				<%
		            Exception e = (Exception) request.getAttribute("exception");
		            out.print(e);
		        %> 
			</td>
		</tr>
	</table>
</body>
</html>