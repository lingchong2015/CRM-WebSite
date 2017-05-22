package com.zn.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suncreate.commons.RequestUtils;
import com.zn.web.model.Product;
import com.zn.web.model.ProductCommonFault;
import com.zn.web.model.ProductSpecification;
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
import java.util.Date;
import java.util.List;

/**
 * Created by wutingting on 2017/4/4.
 */

@Controller
@RequestMapping("/productspecification")
public class ProductSpecificationController {

    private Logger log = Logger.getLogger(ProductSpecificationController.class);

    @Resource
    private ProductSpecificationService productSpecificationService;

    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response, ProductSpecification model) {
        ModelAndView view = new ModelAndView();
        try {
            PageInfoUtil pageInfo = new PageInfoUtil(request);
            PageHelper.startPage(pageInfo.getPage(), pageInfo.getPerList());
            model.getMap().put("orderBy", " order by a.id desc");
            List<ProductSpecification> list = productSpecificationService.getProductSpecification(model);
            PageInfo<ProductSpecification> productSpecificationList = new PageInfo<ProductSpecification>(list);

            pageInfo.getPageLink(productSpecificationList, request);
            view.addObject("pageInfo", pageInfo);
            view.addObject("model", model);
            view.setViewName("productSpecification/list");

        } catch (Exception ex) {
            log.error("", ex);
            view.addObject("exception", ex);
            view.setViewName("error");
        }
        return view;
    }

    @RequestMapping("/productConfiguration")
    public ModelAndView productSpecification(HttpServletRequest request, HttpServletResponse response, ProductSpecification model) {
        String productconfigurationlist = RequestUtils.getStringParameter(request, "productconfigurationlist");
        ModelAndView view = new ModelAndView();
        try {
            view.addObject("productconfigurationlist",productconfigurationlist);
            view.setViewName("productSpecification/productConfiguration");

        } catch (Exception ex) {
            log.error("", ex);
            view.addObject("exception", ex);
            view.setViewName("error");
        }
        return view;
    }

    @RequestMapping("/productSpecificationList")
    public ModelAndView productSpecificationList(HttpServletRequest request, HttpServletResponse response, ProductSpecification model) {
        String specification = RequestUtils.getStringParameter(request, "specification");
        ModelAndView view = new ModelAndView();
        try {
            PageInfoUtil pageInfo = new PageInfoUtil(request);
            PageHelper.startPage(pageInfo.getPage(), pageInfo.getPerList());
            model.getMap().put("orderBy", " order by a.id desc");
            List<ProductSpecification> list = productSpecificationService.getProductSpecification(model);
            PageInfo<ProductSpecification> productSpecificationList = new PageInfo<ProductSpecification>(list);

            pageInfo.getPageLink(productSpecificationList, request);
            view.addObject("pageInfo", pageInfo);
            view.addObject("model", model);
            view.addObject("specification",specification);
            view.setViewName("productSpecification/productSpecificationList");

        } catch (Exception ex) {
            log.error("", ex);
            view.addObject("exception", ex);
            view.setViewName("error");
        }
        return view;
    }

    @RequestMapping("/toAdd")
    public ModelAndView toAdd(HttpServletRequest request, HttpServletResponse response, ProductSpecification model) throws Exception {
        ModelAndView view = new ModelAndView();
        try {
            view.addObject("model", model);

            view.setViewName("productSpecification/edit");
        } catch (Exception ex) {
            log.error("", ex);
            view.addObject("exception", ex);
            view.setViewName("error");
        }
        return view;
    }

    @RequestMapping("/add")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response, ProductSpecification model) throws Exception {
        ModelAndView view = new ModelAndView();
        try {
            //添加时间
            model.setAdddatetime(new Date());
            //未删除标志
            model.setIsdeleted(0);
            int result = productSpecificationService.insertSelectiveProductSpecification(model);
            if (result <= 0) {
                throw new Exception("对不起，操作没有成功！");
            } else {
                //需要增加提示
//                MsgUtil.Alert(request,response,"success");
                view.setViewName("redirect:/productspecification/list");
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
            ProductSpecification model = productSpecificationService.getProductSpecificationById(Integer.valueOf(id.toString()));
            view.addObject("model", model);
            view.setViewName("productSpecification/edit");
        } catch (Exception ex) {
            log.error("", ex);
            view.addObject("exception", ex);
            view.setViewName("/error");
        }
        return view;
    }

    @RequestMapping("/edit")
    public ModelAndView edit(HttpServletRequest request, HttpServletResponse response, ProductSpecification model) throws Exception {
        ModelAndView view = new ModelAndView();
        try {
            if (null == model || null == model.getId() || model.getId() <= 0) {
                throw new Exception("缺少信息ID");
            }
            int result = productSpecificationService.updateProductSpecification(model);
            if (result <= 0) {
                throw new Exception("对不起，操作没有成功！");
            } else {
                view.setViewName("redirect:/productspecification/list");
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
            ProductSpecification productSpecification = productSpecificationService.getProductSpecificationById(Integer.valueOf(id.toString()));
            if (null != productSpecification) {
                //此处的删除等价于更新
                //添加删除时间
                productSpecification.setDeletedatetime(new Date());
                //删除标志
                productSpecification.setIsdeleted(1);
//                productSpecificationService.deleteProductSpecification(Integer.valueOf(id.toString()));
                int result= productSpecificationService.updateProductSpecification(productSpecification);
                if (result <= 0) {
                    throw new Exception("对不起，操作没有成功！");
                } else {
                    MsgUtil.refreshPage(request, response,"/productspecification/list");
                }

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
