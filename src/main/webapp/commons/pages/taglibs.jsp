<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request['contextPath']}" />
<c:set var="scheme_" value="${pageContext.request['scheme']}" />
<c:set var="serverName_" value="${pageContext.request['serverName']}" />
<c:set var="serverPort_" value="${pageContext.request['serverPort']}" />
<c:set var="fullctx" value="${scheme_}://${serverName_}:${serverPort_}${ctx}" />
<c:url var="www_url" value="${ctx}" />
<!--[if lte IE 8]><!--<script>window.location.href='${ctx}/upgrade-your-browser.html?referrer='+location.href;</script>--><![endif]-->
<!--[if lte IE 8]><script>window.location.href='${ctx}/upgrade-your-browser.jsp';</script><![endif]-->