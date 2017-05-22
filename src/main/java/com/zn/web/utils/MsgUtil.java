package com.zn.web.utils;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author fanlianwei
 */
public class MsgUtil {

	private static final String META_SET="<meta http-equiv=\"X-UA-Compatible\" content=\" IE=9;IE=8;IE=7; IE=edge;chrome=1\"/><meta name=\"viewport\" content=\"width=device-width\" />";
//    private static final String LIBRARY_MSG_CSS = "<link rel=\"stylesheet\" type=\"text/css\" href=\"{ctx}/scripts/msg/library/msg.css?v=1.1\"/>";
    private static final String LIBRARY_MSG_CSS = "<link rel=\"stylesheet\" type=\"text/css\" href=\"{ctx}/js/custom/msg/library/msg.css?v=1.1\"/>";
//    private static final String JQUERY_1_11_1_MIN_JS = "<script type=\"text/javascript\" language=\"javascript\" src=\"{ctx}/scripts/jquery-1.11.1.min.js\"></script>";
    private static final String JQUERY_1_11_1_MIN_JS = "<script type=\"text/javascript\" language=\"javascript\" src=\"{ctx}/js/jquery-1.11.1.min.js\"></script>";
//    private static final String JSMSG_JS = "<script type=\"text/javascript\" language=\"javascript\" src=\"{ctx}/scripts/msg/jsmsg.js?v=1.1\"></script>";
    private static final String JSMSG_JS = "<script type=\"text/javascript\" language=\"javascript\" src=\"{ctx}/js/custom/msg/jsmsg.js?v=1.1\"></script>";
    private static final String LIBRARY_MSG_JS = "<script type=\"text/javascript\" language=\"javascript\" src=\"{ctx}/scripts/msg/library/msg.js?v=1.1\"></script>";

	/**
	 * 添加编辑删除提示
	 * 
	 * @param request
	 * @param response
	 * @param msgtitle
	 *            提示文字
	 * @param url
	 *            返回地址
	 * @param msgcss
	 *            CSS样式 Success Error Warning
	 * @throws Exception
	 */
	public static void JscriptPrint(HttpServletRequest request, HttpServletResponse response, String msgtitle, String url, String msgcss) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=" + "UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.print(JscriptPrint(request, msgtitle, url, msgcss));
	}

	/**
	 * 生成编辑删除提示
	 * 
	 * @param request
	 * @param msgtitle
	 *            提示文字
	 * @param url
	 *            返回地址
	 * @param msgcss
	 *            CSS样式 Success Error Warning
	 * @throws Exception
	 */
	public static String JscriptPrint(HttpServletRequest request, String msgtitle, String url, String msgcss) throws Exception {
		StringBuffer buffer = new StringBuffer();
		buffer.append(META_SET);
		buffer.append(LIBRARY_MSG_CSS.replace("{ctx}", ResourceUtil.getFullctx(request)));
		buffer.append(JQUERY_1_11_1_MIN_JS.replace("{ctx}", ResourceUtil.getFullctx(request)));
		buffer.append(JSMSG_JS.replace("{ctx}", ResourceUtil.getFullctx(request)));
		buffer.append("<script type=\"text/javascript\">");
		if (url.length() > 0 && !url.equals("back")) {
			msgtitle += "2秒后页面将自动跳转，<a href='" + url + "' style='font-size: 14px;'>如果页面没有跳转请点击这里手动跳转。</a>";
		}
		buffer.append("$(function(){ jsprint(\"" + msgtitle + "\",\"" + url + "\",\"" + msgcss + "\");});");
		buffer.append("</script>");
		System.out.println(buffer.toString());
		return buffer.toString();
	}

	/**
	 * 生成编辑删除提示
	 *
	 * @param request
	 * @param msgtitle
	 *            提示文字
	 * @param url
	 *            返回地址
	 * @param msgcss
	 *            CSS样式 Success Error Warning
	 * @throws Exception
	 */
	public static String JscriptPrintSimple(HttpServletRequest request, String msgtitle, String url, String msgcss) throws Exception {
		StringBuffer buffer = new StringBuffer();
		buffer.append(META_SET);
		buffer.append(LIBRARY_MSG_CSS.replace("{ctx}", ResourceUtil.getFullctx(request)));
		buffer.append(JQUERY_1_11_1_MIN_JS.replace("{ctx}", ResourceUtil.getFullctx(request)));
		buffer.append(JSMSG_JS.replace("{ctx}", ResourceUtil.getFullctx(request)));
		buffer.append("<script type=\"text/javascript\">");
		buffer.append("$(function(){ jsprint(\"" + msgtitle + "\",\"" + url + "\",\"" + msgcss + "\");});");
		buffer.append("</script>");
		return buffer.toString();
	}

	/**
	 * 刷新页面
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public static void refreshPage(HttpServletRequest request, HttpServletResponse response,String url) throws Exception {
//		String htmlStr = "<script language='javascript'>window.opener.window.DPF.submit();window.close();</script>";
		String fullctx=ResourceUtil.getFullctx(request);
		String htmlStr = "<script language='javascript'> window.location.href='"+fullctx+url+"'</script>";
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().print(htmlStr);
	}

	/**
	 * 刷新页面
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public static void Alert(HttpServletRequest request, HttpServletResponse response, String msg) throws Exception {
		String htmlStr = "<script language='javascript'>alert('" + msg + "');window.close();</script>";
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().print(htmlStr);
	}
}
