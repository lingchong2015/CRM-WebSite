package com.zn.web.utils;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * Title: ResourceUtil.java
 * </p>
 * <p>
 * Description:system.properties配置文件工具类
 * </p>
 * <p>
 * Copyright: Copyright (c) 2014
 * </p>
 * 
 * @author fanlianwei
 * @date 2014-8-11 14:23:58
 * @version V1.0
 */
public class ResourceUtil {

	private static final ResourceBundle bundle = java.util.ResourceBundle.getBundle("system");


	/**
	 * 获取系统标题
	 *
	 * @return
	 */
	public static String getSystemTitle() {
		return bundle.getString("system.title");
	}


	/**
	 * 获取协议
	 *
	 * @return
	 */
	public static String getScheme() {
		return bundle.getString("http.scheme");
	}

	/**
	 * 获取全路径上下文
	 * 
	 * @param request
	 * @return
	 */
	public static String getFullctx(HttpServletRequest request) {
		String ctx = request.getContextPath();
		String serverName_ = request.getServerName();
		int serverPort_ = request.getServerPort();
		String fullctx = "";
		if (serverPort_ == 80) {
			fullctx = getScheme() + "//" + serverName_ + ctx;
		} else {
			fullctx = getScheme() + "//" + serverName_ + ":" + serverPort_ + ctx;
		}
		return fullctx;
	}

}
