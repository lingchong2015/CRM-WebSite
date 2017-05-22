package com.zn.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suncreate.commons.RequestUtils;
import com.zn.web.model.Product;
import com.zn.web.model.ProductCommonFault;
import com.zn.web.model.ProductConfiguration;
import com.zn.web.model.ProductSpecification;
import com.zn.web.service.ProductCommonFaultService;
import com.zn.web.service.ProductConfigurationService;
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
@RequestMapping("/productconfiguration")
public class ProductConfigurationController {

    private Logger log = Logger.getLogger(ProductConfigurationController.class);
    
    @Resource
    private ProductConfigurationService productConfigurationService;

    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response, ProductConfiguration model) {
        ModelAndView view = new ModelAndView();
        try {
            PageInfoUtil pageInfo = new PageInfoUtil(request);
            PageHelper.startPage(pageInfo.getPage(), pageInfo.getPerList());
            model.getMap().put("orderBy", " order by a.id desc");
            List<ProductConfiguration> list = productConfigurationService.getProductConfiguration(model);
            PageInfo<ProductConfiguration> productConfigurationList = new PageInfo<ProductConfiguration>(list);

            pageInfo.getPageLink(productConfigurationList, request);
            view.addObject("pageInfo", pageInfo);
            view.addObject("model", model);
            view.setViewName("productConfiguration/list");

        } catch (Exception ex) {
            log.error("", ex);
            view.addObject("exception", ex);
            view.setViewName("error");
        }
        return view;
    }

    @RequestMapping("/productConfigurationList")
    public ModelAndView productConfigurationList(HttpServletRequest request, HttpServletResponse response, ProductConfiguration model) {
        String productconfigurationlist = RequestUtils.getStringParameter(request, "productconfigurationlist");
        ModelAndView view = new ModelAndView();
        try {
            PageInfoUtil pageInfo = new PageInfoUtil(request);
            PageHelper.startPage(pageInfo.getPage(), pageInfo.getPerList());
            model.getMap().put("orderBy", " order by a.id desc");
            List<ProductConfiguration> list = productConfigurationService.getProductConfiguration(model);
            PageInfo<ProductConfiguration> productConfigurationList = new PageInfo<ProductConfiguration>(list);

            pageInfo.getPageLink(productConfigurationList, request);
            view.addObject("pageInfo", pageInfo);
            view.addObject("model", model);
            view.addObject("productconfigurationlist",productconfigurationlist);
            view.setViewName("productConfiguration/productConfigurationList");

        } catch (Exception ex) {
            log.error("", ex);
            view.addObject("exception", ex);
            view.setViewName("error");
        }
        return view;
    }


    @RequestMapping("/toAdd")
    public ModelAndView toAdd(HttpServletRequest request, HttpServletResponse response, ProductConfiguration model) throws Exception {
        ModelAndView view = new ModelAndView();
        try {
            view.addObject("model", model);

            view.setViewName("productConfiguration/edit");
        } catch (Exception ex) {
            log.error("", ex);
            view.addObject("exception", ex);
            view.setViewName("error");
        }
        return view;
    }

    @RequestMapping("/add")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response, ProductConfiguration model) throws Exception {
        ModelAndView view = new ModelAndView();
        try {
            int result = productConfigurationService.insertProductConfiguration(model);
            if (result <= 0) {
                throw new Exception("对不起，操作没有成功！");
            } else {
                //需要增加提示
//                MsgUtil.Alert(request,response,"success");
                view.setViewName("redirect:/productconfiguration/list");
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
            ProductConfiguration model = productConfigurationService.getProductConfigurationById(Integer.valueOf(id.toString()));
            view.addObject("model", model);
            view.setViewName("productConfiguration/edit");
        } catch (Exception ex) {
            log.error("", ex);
            view.addObject("exception", ex);
            view.setViewName("/error");
        }
        return view;
    }

    @RequestMapping("/edit")
    public ModelAndView edit(HttpServletRequest request, HttpServletResponse response, ProductConfiguration model) throws Exception {
        ModelAndView view = new ModelAndView();
        try {
            if (null == model || null == model.getId() || model.getId() <= 0) {
                throw new Exception("缺少信息ID");
            }
            int result = productConfigurationService.updateProductConfiguration(model);
            if (result <= 0) {
                throw new Exception("对不起，操作没有成功！");
            } else {
                view.setViewName("redirect:/productconfiguration/list");
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
            ProductConfiguration productConfiguration = productConfigurationService.getProductConfigurationById(Integer.valueOf(id.toString()));
            if (null != productConfiguration) {
                productConfigurationService.deleteProductConfiguration(Integer.valueOf(id.toString()));
                MsgUtil.refreshPage(request, response,"/productconfiguration/list");
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
