package com.zn.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suncreate.commons.RequestUtils;
import com.zn.web.model.Product;
import com.zn.web.model.ProductCommonFault;
import com.zn.web.model.ProductSpecification;
import com.zn.web.service.ProductCommonFaultService;
import com.zn.web.service.ProductService;
import com.zn.web.service.ProductSpecificationService;
import com.zn.web.utils.MsgUtil;
import com.zn.web.utils.ResourceUtil;
import com.zn.web.utils.PageInfoUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by wutingting on 2017/4/4.
 */

@Controller
@RequestMapping("/product")
public class ProductController {

    private Logger log = Logger.getLogger(ProductController.class);
    @Resource
    private ProductService productService;

    private ProductSpecificationService productSpecificationService;

    private ProductCommonFaultService productCommonFaultService;

    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response, Product model) {
        ModelAndView view = new ModelAndView();
        try {
            PageInfoUtil pageInfo = new PageInfoUtil(request);
            PageHelper.startPage(pageInfo.getPage(), pageInfo.getPerList());
//            if (pageInfo.getOrderBy().isEmpty()) {
            model.getMap().put("orderBy", " order by a.id desc");
//            } else {
//                String column = shoppingArticleService.getColumn(pageInfo.getSortField());
//                model.getMap().put("orderBy", pageInfo.getOrderBy(column));
//            }
            List<Product> list = productService.getProduct(model);
            PageInfo<Product> productList = new PageInfo<Product>(list);

            pageInfo.getPageLink(productList, request);
            view.addObject("pageInfo", pageInfo);
            view.addObject("model", model);
            view.setViewName("product/list");

        } catch (Exception ex) {
            log.error("", ex);
            view.addObject("exception", ex);
            view.setViewName("error");
        }
        return view;
    }


    // /产品问题弹框
    @RequestMapping("/productCommonFault")
    public ModelAndView productCommonFault(HttpServletRequest request, HttpServletResponse response, ProductCommonFault model) {
        String productcommonfaultlist=RequestUtils.getStringParameter(request,"productcommonfaultlist");
        ModelAndView view = new ModelAndView();
        try {
            view.addObject("productcommonfaultlist",productcommonfaultlist);
            view.setViewName("product/productCommonFault");
        } catch (Exception ex) {
            log.error("", ex);
            view.addObject("exception", ex);
            view.setViewName("error");
        }
        return view;
    }

    @RequestMapping("/toAdd")
    public ModelAndView toAdd(HttpServletRequest request, HttpServletResponse response, Product model) throws Exception {
        ModelAndView view = new ModelAndView();
        try {
            view.addObject("model", model);
            view.setViewName("product/edit");
        } catch (Exception ex) {
            log.error("", ex);
            view.addObject("exception", ex);
            view.setViewName("error");
        }
        return view;
    }

    @RequestMapping("/add")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response, Product model) throws Exception {
        ModelAndView view = new ModelAndView();
        try {
            int result = productService.insertSelectiveProduct(model);
            if (result <= 0) {
                throw new Exception("对不起，操作没有成功！");
            } else {
                //需要增加提示
//                MsgUtil.Alert(request,response,"success");
                view.setViewName("redirect:/product/list");
            }
        } catch (Exception ex) {
            log.error("", ex);
            view.setViewName("error");
        }
        return view;
    }

    /**
     * 转到编辑信息
     */
    @RequestMapping("/toEdit")
    public ModelAndView toEdit(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView();
        try {
            Long id = RequestUtils.getLongParameter(request, "id", -1L);
            Product model = productService.getProductById(Integer.valueOf(id.toString()));
            view.addObject("model", model);
            view.setViewName("product/edit");
        } catch (Exception ex) {
            log.error("", ex);
            view.addObject("exception", ex);
            view.setViewName("/error");
        }
        return view;
    }

    @RequestMapping("/edit")
    public ModelAndView edit(HttpServletRequest request, HttpServletResponse response, Product model) throws Exception {
        ModelAndView view = new ModelAndView();
        try {
            if (null == model || null == model.getId() || model.getId() <= 0) {
                throw new Exception("缺少信息ID");
            }
            int result = productService.updateProduct(model);
            if (result <= 0) {
                throw new Exception("对不起，操作没有成功！");
            } else {
                view.setViewName("redirect:/product/list");
            }
        } catch (Exception ex) {
            log.error("", ex);
            view.setViewName("/error");
        }
        return view;
    }

    @RequestMapping("/delete")
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView();
        try {
            Long id = RequestUtils.getLongParameter(request, "id", -1L);
            Product product = productService.getProductById(Integer.valueOf(id.toString()));
            if (null != product) {
                productService.deleteProduct(Integer.valueOf(id.toString()));
                MsgUtil.refreshPage(request, response,"/product/list");
            }
            return null;
        } catch (Exception ex) {
            log.error("", ex);
            view.addObject("exception", ex);
            view.setViewName("error");
        }
        return view;
    }

}
