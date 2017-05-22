package com.zn.web.utils;

import com.github.pagehelper.PageInfo;
import com.suncreate.commons.RequestUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 * 分页链接信息包装类
 *
 * @author fanlianwei
 *
 */
public class PageInfoUtil implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 3452906908472756063L;
    /**
     * 记录总数
     */
    private long itemCount = 0L;
    /**
     * 当前页号
     */
    private int page = 1;
    /**
     * 页总数
     */
    private int pageCount = 0;
    /**
     * 每页记录数
     */
    private int perList = -1;
    /**
     * 排序字段
     */
    private String sortField = "";
    /**
     * 排序方式
     */
    private String sortSequence = "";

    /**
     * 结果数据
     */
    private List<Object> data = null;

    /**
     * 偏移量,即显示2x3+1=7个
     */
    private static int STEP = 3;

    /**
     * 左界限
     */
    private static int LEFT_NUM = 0;

    /**
     * 右界限
     */
    private static int RIGHT_NUM = 0;

    /**
     * 链接字符串
     */
    private String links = "";

    /**
     * 分页解析参数时需要过滤的名称
     */
    private static ArrayList<String> ignoreNameList = new ArrayList<String>();

    /**
     * 初始化分页大小列表
     */
    private static Integer[] itemPerList = new Integer[]{5, 10, 15, 20, 30, 50, 100};

    /**
     * 分页Form名称
     */
    private String pageFormName = "DPF";

    public PageInfoUtil() {
        this.sortField = "";
        this.sortSequence = " asc";
        this.perList = -1;
        this.pageCount = 0;
        this.itemCount = 0L;
        this.initIgnoreNameList();
    }

    /**
     * 带参数构造方法
     *
     * @param request
     * @param pageNo 当前页号
     * @param perList 每页记录数
     */
    public PageInfoUtil(HttpServletRequest request, int pageNo, int perList) {
        this.page = pageNo;
        this.sortField = "";
        this.sortSequence = " asc";
        this.perList = perList;
        this.pageCount = 0;
        this.itemCount = 0L;
        this.initIgnoreNameList();
        this.getShowPage(request);
    }

    public PageInfoUtil(HttpServletRequest request) {
        this.perList = RequestUtils.getIntegerParameter(request, "perList"+this.pageFormName, 10);
        this.pageFormName = RequestUtils.getStringParameter(request, "pageFormName", this.pageFormName);
        this.pageCount = 0;
        this.itemCount = 0L;
        this.initIgnoreNameList();
        this.getShowPage(request);
    }

    /**
     * 从request中获取显示页号、排序字段、排序方式
     *
     * @param request
     */
    public void getShowPage(HttpServletRequest request) {
        this.page = RequestUtils.getIntegerParameter(request, "showpage" + this.pageFormName, 1);
        this.sortField = RequestUtils.getStringParameter(request, "sortField" + this.pageFormName, "");
        String ss=RequestUtils.getStringParameter(request, "sortSequence" + this.pageFormName,"0");
        this.sortSequence = " " + (ss.trim().equals("1")?"desc":"asc");
    }

    public static PageInfoUtil getNullInstance() {
        PageInfoUtil pi = new PageInfoUtil();
        pi.page = 0;
        pi.sortField = "";
        pi.sortSequence = " asc";
        pi.perList = -1;
        pi.pageCount = 0;
        pi.itemCount = 0L;
        return pi;
    }

    /**
     * 获取排序字符串
     *
     * @return
     */
    public String getOrderBy() {
        if (this.sortField.length() > 0) {
            return " order by " + this.sortField + " " + this.sortSequence;
        }
        return "";
    }
    
    /**
     * 转换排序字段
     * @param field
     * @return
     */
    public String getOrderBy(String field) {
        if (field.length() > 0) {
            return " order by " + field + " " + this.sortSequence;
        }else if (this.sortField.length() > 0) {
            return " order by " + this.sortField + " " + this.sortSequence;
        }
        return "";
    }

    /**
     * 初始化需要过滤参数名称列表
     */
    private void initIgnoreNameList() {
        if (ignoreNameList.isEmpty()) {
            ignoreNameList.add("itotal"+this.pageFormName);
            ignoreNameList.add("perList"+this.pageFormName);
            ignoreNameList.add("perListSelect"+this.pageFormName);
            ignoreNameList.add("ipage"+this.pageFormName);
            ignoreNameList.add("sortField" + this.pageFormName);
            ignoreNameList.add("sortSequence" + this.pageFormName);
        }
    }

    public static ArrayList<String> getIgnoreNameList() {
        return ignoreNameList;
    }

    public static void setIgnoreNameList(ArrayList<String> ignoreNameList) {
        PageInfoUtil.ignoreNameList = ignoreNameList;
    }

    /**
     * 获取分页Form名称
     *
     * @return
     */
    public String getPageFormName() {
        return this.pageFormName;
    }

    /**
     * 设置分页Form名称
     *
     * @param formName
     */
    public void setPageFormName(String formName) {
        this.pageFormName = formName;
    }

    /**
     * 改变总记录数,相应的也会改变页数
     *
     * @param aItemCount 总记录数
     */
    public void changeItemCount(long aItemCount) {
        this.itemCount = aItemCount;
        int aPageCount = 1;
        if (this.perList > 0) {
            if (this.itemCount > this.perList) {
                if (this.itemCount % this.perList == 0L) {
                    aPageCount = (int) this.itemCount / this.perList;
                } else {
                    aPageCount = (int) this.itemCount / this.perList + 1;
                }
            } else {
                aPageCount = 1;
            }
        }
        this.pageCount = aPageCount;
    }

    /**
     * 记录总数
     *
     * @return
     */
    public long getItemCount() {
        return this.itemCount;
    }

    /**
     * 当前页号
     *
     * @return
     */
    public int getPage() {
        return this.page;
    }

    /**
     * 页总数
     *
     * @return
     */
    public int getPageCount() {
        return this.pageCount;
    }

    /**
     * 每页记录数
     *
     * @return
     */
    public int getPerList() {
        return this.perList;
    }

    /**
     * 排序字段
     *
     * @return
     */
    public String getSortField() {
        return this.sortField;
    }

    /**
     * 排序方式
     *
     * @return
     */
    public String getSortSequence() {
        return this.sortSequence;
    }

    public void setItemCount(long aItemCount) {
        this.itemCount = aItemCount;
    }

    /**
     * 设置当前页
     *
     * @param aPage 页数
     */
    public void setPage(int aPage) {
        if (aPage <= 0) {
            aPage = 1;
        }
        if (aPage > getPageCount() && getPageCount() >= 1) {
            aPage = getPageCount();
        }
        this.page = aPage;
    }

    public void setPageCount(int aPageCount) {
        this.pageCount = aPageCount;
    }

    public void setPerList(int aPerList) {
        this.perList = aPerList;
    }

    public void setSortField(String aSortField) {
        this.sortField = aSortField;
    }

    public void setSortSequence(String aSortSequence) {
        this.sortSequence = aSortSequence;
    }

    public List<Object> getData() {
        return this.data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("page=");
        sb.append(getPage());
        sb.append(" ; pageCount=");
        sb.append(getPageCount());
        sb.append(" ; perList=");
        sb.append(getPerList());
        sb.append(" ; sortField=");
        sb.append(getSortField());
        sb.append(" ; itemCount=");
        sb.append(getItemCount());
        return sb.toString();
    }

    /**
     * 获取分页字符串
     *
     * @return links
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public String getPageLink(PageInfo pageInfo, HttpServletRequest request) {
        this.changeItemCount(pageInfo.getTotal());
        this.data = pageInfo.getList();
        /**
         * 总页数大于1时候才进行分页处理 *
         */
//        if (this.pageCount > 1) {
        this.links += PageInfoUtil.setLink(this.page, this.pageCount, this.itemCount, this.perList, request, this
                .getPageFormName(), this.sortField, this.sortSequence)
                + PageInfoUtil.setScript(this.pageFormName);
//        } else {
//            this.links += getUrl(request, this.pageFormName, this.sortField, this.sortSequence)
//                    + PageInfoUtil.setScript(this.pageFormName);
//        }
        StringBuffer sb = new StringBuffer();
        sb.append("<form name=\"" + this.pageFormName + "\" id=\"" + this.pageFormName + "\" action=\"" + request.getRequestURL()
                + "\" method=\"post\">");
        sb.append(this.links);
        sb.append("</form>");
        this.links = sb.toString();
        return this.links;
    }

    /**
     * 获取隐藏查询条件
     *
     * @return url
     */
    @SuppressWarnings({"rawtypes" })
    public static String getUrl(HttpServletRequest request, String formName, String sortField, String sortSequence) {
        String url = "";
        /**
         * 获取所有的参数 *
         */
        Enumeration param = request.getParameterNames();
        /**
         * 遍历所有参数,如果不等于showpage,则把当前参数加入url中,其中showpage为固定参数,表示为当前页码 *
         */
        String curPage = "1";
        while (param.hasMoreElements()) {
            String pname = param.nextElement().toString();
            String[] strs = request.getParameterValues(pname);
            String str = "";
            if (strs != null && strs.length > 1) {
                for (int i = 0; i < strs.length; i++) {
                    str = strs[i];
                    if (!pname.equalsIgnoreCase("sortField" + formName) && !pname.equalsIgnoreCase("sortSequence" + formName)
                            && !pname.equalsIgnoreCase("showpage" + formName) && !PageInfoUtil.ignoreNameList.contains(pname)) {
                        url += "<input type='hidden' name='" + pname + "' value='" + str + "'/>";
                    } else if (pname.equalsIgnoreCase("showpage" + formName)) {
                        curPage = str;
                    }
                }
            } else {
                str = request.getParameter(pname);
                if (!pname.equalsIgnoreCase("sortField" + formName) && !pname.equalsIgnoreCase("sortSequence" + formName)
                        && !pname.equalsIgnoreCase("showpage" + formName) && !PageInfoUtil.ignoreNameList.contains(pname)) {
                    url += "<input type='hidden' name='" + pname + "' value='" + str + "'/>";
                } else if (pname.equalsIgnoreCase("showpage" + formName)) {
                    curPage = str;
                }
            }
        }
        if (curPage != null) {
            curPage = curPage.replace("/", "");
        }
        url += "<input type='hidden' name='showpage" + formName + "' id='showpage" + formName + "' value='" + curPage  + "'/>";
        url += "<input type='hidden' name='sortField" + formName + "' id='sortField" + formName + "' value='"+ sortField + "'/>";
        url += "<input type='hidden' name='sortSequence" + formName + "' id='sortSequence" + formName + "' value='" + (sortSequence.contains("desc")?1:0) + "'/>";
        url += "<input type='hidden' name='pageFormName' id='pageFormName' value='" + formName + "'/>";
        return url;
    }

    /**
     * 处理数字链接的左右边界值
     *
     * @param currentPage
     * @param totalPage
     */
    public static void setBounds(int currentPage, int totalPage) {
        if (currentPage - STEP < 1) {
            LEFT_NUM = 1;
        } else {
            LEFT_NUM = currentPage - STEP;
        }
        if (currentPage + STEP > totalPage) {
            RIGHT_NUM = totalPage;
        } else {
            RIGHT_NUM = currentPage + STEP;
        }

        /**
         * 如果页数大于(2xSTEP+1),但是显示少于(2xSTEP+1),则强制显示(2xSTEP+1) *
         */
        if (totalPage <= 2 * STEP + 1) {
            LEFT_NUM = 1;
            RIGHT_NUM = totalPage;
        } else {
            if (2 * STEP + 1 <= totalPage) {
                if (RIGHT_NUM < 2 * STEP + 1) {
                    RIGHT_NUM = 2 * STEP + 1;
                }
            }
            if (totalPage - 2 * STEP > 0) {
                if (LEFT_NUM > totalPage - 2 * STEP) {
                    LEFT_NUM = totalPage - 2 * STEP;
                }
            }
        }
    }

    public static String setLink(int currentPage, int totalPage, long itemCount, int perList,
            HttpServletRequest request, String fn, String sortField, String sortSequence) {
        /**
         * 处理链接 *
         */
        String links2 = getUrl(request, fn, sortField, sortSequence);
        StringBuffer sb = new StringBuffer();
        sb.append(links2);
        sb.append("&nbsp;");

        if (currentPage == 1) {
            sb.append("首页&nbsp;");
            sb.append("上一页&nbsp;");
        } else {
            sb.append("<a href='javascript:showpage" + fn + "(1)'>首页</a>&nbsp;");
            sb.append("<a href='javascript:showpage" + fn + "(" + (currentPage - 1) + ")'>上一页</a>&nbsp;");
        }
        if (currentPage == totalPage) {// 已经到最后一页
            sb.append("下一页&nbsp;");
            sb.append("末页&nbsp;");
        } else {
            sb.append("<a href='javascript:showpage" + fn + "(" + (currentPage + 1) + ")'>下一页</a>&nbsp;");
            sb.append("<a href='javascript:showpage" + fn + "(" + totalPage + ")'>末页</a>&nbsp;");
        }

        /**
         * 获取左右边界值 *
         */
        setBounds(currentPage, totalPage);

        sb.append("&nbsp;&nbsp;");
        /**
         * 处理中间页 *
         */
        for (int i = LEFT_NUM; i <= RIGHT_NUM; i++) {
            if (i != currentPage) {
                sb.append("<a href='javascript:showpage" + fn + "(" + i + ")'>" + i + "</a>&nbsp;");
            } else {
                sb.append("<span class='curPage'>" + currentPage + "</span>&nbsp;");
            }
        }
        sb.append("&nbsp;&nbsp;第&nbsp;");
        sb.append("<font color='red'>" + currentPage + "</font>/" + totalPage + "&nbsp;页 共&nbsp;" + itemCount + "&nbsp;条记录&nbsp;&nbsp;");
        sb.append("<input type=\"hidden\" name=\"perList"+fn+"\" id=\"perList"+fn+"\" value=\"" + perList + "\"/>");
        sb.append("&nbsp;&nbsp;每页");
        sb.append("<select name=\"perListSelect"+fn+"\" id=\"perListSelect"+fn+"\" class=\"perListSelect\">");
        int curValue = 0;
        for (int i = 0; i < itemPerList.length; i++) {
            curValue = itemPerList[i];
            sb.append("<option value=\"" + curValue + "\" " + (perList == curValue ? "selected=\"selected\"" : "") + ">" + curValue + "</option>");
        }
        sb.append("</select>");
        sb.append("条记录&nbsp;&nbsp;");

        /**
         * 添加跳转框 *
         */
        sb.append("<input type='text'  name='ipage"+fn+"' id='ipage"+fn+"' class='goPage' title='请输入页码' value='" + currentPage + "'/>");
        sb.append("<input title='总页数' type='hidden' name='itotal"+fn+"' id='itotal"+fn+"' class='goPage' value='" + totalPage+ "' readonly='readonly'/>");
        sb.append("&nbsp;<a href='javascript:void(0)' onclick='doGo" + fn + "();' name='igo"+fn+"' id='igo"+fn+"' class='igo'>跳转</a>");
        return sb.toString();
    }

    public static String setScript(String fn) {

        String script = "";
        script += "<script type='text/javascript'>";
        script += "G" + fn + "=function(name){return eval(\"document." + fn + ".\"+name);};";
        script += "FORMAT" + fn + "=function(){";
        script += "	var ie=navigator.appName=='Microsoft Internet Explorer'?true:false;";
        script += " var theEvent = window.event || arguments.callee.caller.arguments[0];";
        script += "	if(!ie) var key = theEvent.which;";
        script += "	else{ var key = theEvent.keyCode;}";
        script += "	if (key==8||key==46|| key == 13||(key>=48&&key<=57)){";
        script += "if(key==13){";
        script += "	var ipage=G" + fn + "('ipage"+fn+"').value;";
        script += "	if(CHECK" + fn + "(ipage)) showpage" + fn + "(ipage);else return false;";
        script += "}";
        script += " return true;";
        script += "}else{alert('请输入合法数字');return false;}";
        script += "};";

        script += "showpage" + fn + "=function(page){";
        script += "G" + fn + "('showpage" + fn + "').value=page;";
        script += "document." + fn + ".submit();";
        script += "};";

        script += "Sort" + fn + "=function(fieldName){";
        script += "G" + fn + "(\"sortField" + fn + "\").value=fieldName;";
        script += "var sortSequence=G" + fn + "(\"sortSequence" + fn + "\");";
        script += "if(sortSequence.value.Trim" + fn + "()=='1'){";
        script += "sortSequence.value='0';";
        script += "}else{";
        script += "sortSequence.value='1';";
        script += "}";
        script += "document." + fn + ".submit();";
        script += "};";

        script += "String.prototype.Trim" + fn + " = function () {";
        script += "return this.replace(/(^\\s*)|(\\s*$)/g, \"\");";
        script += "};";

        script += "CHECK" + fn + "=function(page){";
        script += "	var itotal=parseInt(G" + fn + "('itotal"+fn+"').value);";
        script += "	if(page>itotal||page<1){alert('输入超出有效范围');G" + fn + "('ipage"+fn+"').value=1; return false;}";
        script += "	else return true;";
        script += "};";

        script += "doGo" + fn + "=function(){";
        script += "	var ipage=G" + fn + "('ipage"+fn+"').value;";
        script += "	if(CHECK" + fn + "(ipage)) showpage" + fn + "(ipage);";
        script += "};";

        script += "try{";
        script += "G" + fn + "('ipage"+fn+"').onkeypress=function(){return FORMAT" + fn + "();};";

        script += "G" + fn + "('perListSelect"+fn+"').onchange=function(){";
        script += "	var s=G" + fn + "('perListSelect"+fn+"').value;";
        script += "	G" + fn + "('perList"+fn+"').value=s;";
        script += "	showpage" + fn + "(1);";
        script += "};";

        script += "}catch(e){}";

        script += "</script>";

        return script;
    }

    /**
     * 克隆分页信息，用于第二个分页信息，必须先clone，再setNewLinks
     * @return 
     */
    @Override
    public PageInfoUtil clone() {
        PageInfoUtil pageInfo = new PageInfoUtil();
        pageInfo.setData(this.data);//数据
        pageInfo.setItemCount(this.itemCount);//记录总数
        pageInfo.setPage(this.page);//当前页
        pageInfo.setPageCount(this.pageCount);//页总数
        pageInfo.setPerList(this.perList);//每页记录数
        pageInfo.setSortField(this.sortField);//排序字段
        pageInfo.setSortSequence(this.sortSequence);//排序方式
        return pageInfo;
    }

    /**
     * 生成新的分页信息
     *
     * @param oldPageInfo 原有分页对象
     * @return 新的查询Form名称
     */
    public String setNewLinks(PageInfoUtil oldPageInfo) {
        String newPageForm = "NewPage" + System.currentTimeMillis();
        //替换原有的Form名称
        this.setLinks(oldPageInfo.getLinks().replace(oldPageInfo.getPageFormName(), newPageForm));
        this.setPageFormName(newPageForm);
        return this.pageFormName;
    }
}
