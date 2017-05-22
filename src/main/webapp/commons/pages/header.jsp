<%-- 
    Document   : 公共头页面
    Created on : 2017-4-4
    Author     : wutingting
--%>
<%@ page language="java"  contentType="text/html; charset=UTF-8" %>
<%@ include file="/commons/pages/taglibs.jsp"%>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#"><span>CRM管理系统</span>&nbsp;管理员</a>
			<ul class="user-menu">
				<li class="dropdown pull-right">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> 用户 <span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#"><span class="glyphicon glyphicon-user"></span> 详情</a></li>
						<li><a href="#"><span class="glyphicon glyphicon-cog"></span> 设置</a></li>
						<li><a href="#"><span class="glyphicon glyphicon-log-out"></span> 退出</a></li>
					</ul>
				</li>
			</ul>
		</div>

	</div><!-- /.container-fluid -->
</nav>

	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<form role="search">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Search">
			</div>
		</form>
		<ul class="nav menu">
			<li class="active"><a href="index.jsp" target="mainFrame"><span class="glyphicon glyphicon-dashboard"></span> Dashboard</a></li>
			<li><a href="widgets.jsp" target="mainFrame"><span class="glyphicon glyphicon-th"></span> Widgets</a></li>
			<li><a href="charts.jsp" target="mainFrame"><span class="glyphicon glyphicon-stats"></span> Charts</a></li>
			<li><a href="${ctx}/customer/list" target="mainFrame"><span class="glyphicon glyphicon-list-alt"></span> 客户信息</a></li>
			<li><a href="widgets.jsp" target="mainFrame"><span class="glyphicon glyphicon-pencil"></span> Form</a></li>
			<li><a href="panels.jsp" target="mainFrame"><span class="glyphicon glyphicon-info-sign"></span> Alerts &amp; Panels</a></li>
			<li class="parent ">
				<a href="#">
					<span class="glyphicon glyphicon-list"></span> 产品信息 <span data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><em class="glyphicon glyphicon-s glyphicon-plus"></em></span>
				</a>
				<ul class="children collapse" id="sub-item-1">
					<li>
						<a class="" href="${ctx}/productconfiguration/list" target="mainFrame">
							<span class="glyphicon glyphicon-share-alt"></span> 产品配置
						</a>
					</li>
					<li>
						<a class="" href="${ctx}/productcommonfault/list" target="mainFrame">
							<span class="glyphicon glyphicon-share-alt"></span> 产品问题
						</a>
					</li>
					<li>
						<a class="" href="${ctx}/productspecification/list" target="mainFrame">
							<span class="glyphicon glyphicon-share-alt"></span> 产品规格
						</a>
					</li>
					<li>
						<a class="" href="${ctx}/product/list" target="mainFrame">
							<span class="glyphicon glyphicon-share-alt"></span> 产品列表
						</a>
					</li>

				</ul>
			</li>
			<li role="presentation" class="divider"></li>
			<li><a href="login.jsp"><span class="glyphicon glyphicon-user"></span> Login Page</a></li>
		</ul>
	</div><!--/.sidebar-->



