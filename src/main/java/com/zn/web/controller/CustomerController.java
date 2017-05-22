package com.zn.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suncreate.commons.RequestUtils;
import com.zn.web.model.CustomerProduct;
import com.zn.web.service.CustomerProductService;
import com.zn.web.utils.MsgUtil;
import com.zn.web.model.Customer;
import com.zn.web.service.CustomerService;
import com.zn.web.utils.PageInfoUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by wutingting on 2017/4/4.
 */

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private Logger log = Logger.getLogger(CustomerController.class);
    @Resource
    private CustomerService customerService;
    @Resource
    private CustomerProductService customerproductService;

    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response, Customer model) {
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
            List<Customer> list = customerService.getCustomer(model);
            PageInfo<Customer> customerList = new PageInfo<Customer>(list);

            pageInfo.getPageLink(customerList, request);
            view.addObject("pageInfo", pageInfo);
            view.addObject("model", model);
            view.setViewName("customer/list");

        } catch (Exception ex) {
            log.error("", ex);
            view.addObject("exception", ex);
            view.setViewName("error");
        }
        return view;
    }

    @RequestMapping("/toAdd")
    public ModelAndView toAdd(HttpServletRequest request, HttpServletResponse response, Customer model) throws Exception {
        ModelAndView view = new ModelAndView();
        try {
            view.addObject("model", model);
            view.setViewName("customer/edit");
        } catch (Exception ex) {
            log.error("", ex);
            view.addObject("exception", ex);
            view.setViewName("error");
        }
        return view;
    }

    @RequestMapping("/add")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response, Customer model) throws Exception {
        ModelAndView view = new ModelAndView();
        try {
            int result = customerService.insertSelectiveCustomer(model);
            if (result <= 0) {
                throw new Exception("对不起，操作没有成功！");
            } else {
                //需要增加提示
//                MsgUtil.Alert(request,response,"success");
                view.setViewName("redirect:/customer/list");
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
            Customer model = customerService.getCustomerById(Integer.valueOf(id.toString()));
            view.addObject("model", model);
            view.setViewName("customer/edit");
        } catch (Exception ex) {
            log.error("", ex);
            view.addObject("exception", ex);
            view.setViewName("/error");
        }
        return view;
    }

    @RequestMapping("/edit")
//    public String edit(HttpServletRequest request, HttpServletResponse response, Customer model) throws Exception {
//        try {
//            if (null == model || null == model.getId() || model.getId() <= 0) {
//                throw new Exception("缺少信息ID");
//            }
//            int result = customerService.updateCustomer(model);
//            if (result <= 0) {
//                throw new Exception("对不起，操作没有成功！");
//            } else {
//                return MsgUtil.JscriptPrint(request, "修改成功！", ResourceUtil.getFullctx(request) + "/customer/list", "Success");
//            }
//        } catch (Exception ex) {
//            log.error("", ex);
//            return MsgUtil.JscriptPrint(request, "修改失败，请重试！", ResourceUtil.getFullctx(request) + "/customer/list" , "Error");
//        }
//    }
    public ModelAndView edit(HttpServletRequest request, HttpServletResponse response, Customer model) throws Exception {
        ModelAndView view = new ModelAndView();
        try {
            if (null == model || null == model.getId() || model.getId() <= 0) {
                throw new Exception("缺少信息ID");
            }
            int result = customerService.updateCustomer(model);
            if (result <= 0) {
                throw new Exception("对不起，操作没有成功！");
            } else {
                view.setViewName("redirect:/customer/list");
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
            Customer customer = customerService.getCustomerById(Integer.valueOf(id.toString()));
            if (null != customer) {
                customerService.deleteCustomer(Integer.valueOf(id.toString()));
                MsgUtil.refreshPage(request, response,"/customer/list");
            }
            return null;
        } catch (Exception ex) {
            log.error("", ex);
            view.addObject("exception", ex);
            view.setViewName("error");
        }
        return view;
    }

    @RequestMapping("/showCustomerProduct")
    public ModelAndView showCustomerProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView view = new ModelAndView();
        try {
            String customerserial = RequestUtils.getStringParameter(request, "serial", "");
            String productSerial = RequestUtils.getStringParameter(request, "productSerial", "");

            PageInfoUtil pageInfo = new PageInfoUtil(request);
            PageHelper.startPage(pageInfo.getPage(), pageInfo.getPerList());
            CustomerProduct customerproduct=new CustomerProduct();

            if(!StringUtils.isEmpty(customerserial)){
                customerproduct.setCustomerserial(customerserial);
            }
            if(!StringUtils.isEmpty(productSerial)){
                customerproduct.setProductserial(productSerial);
            }
            customerproduct.getMap().put("orderBy", " order by a.id desc");
            List<CustomerProduct> list = customerproductService.getCustomerProduct(customerproduct);
            PageInfo<CustomerProduct> customerproductList = new PageInfo<CustomerProduct>(list);
            pageInfo.getPageLink(customerproductList, request);
            view.addObject("pageInfo", pageInfo);
            //查询条件
            view.addObject("productSerial", productSerial);

            view.setViewName("customer/showCustomerProduct");
        } catch (Exception ex) {
            log.error("", ex);
            view.addObject("exception", ex);
            view.setViewName("error");
        }
        return view;
    }

    @RequestMapping("/toAddCustomerProduct")
    public ModelAndView toAddCustomerProduct(HttpServletRequest request, HttpServletResponse response,CustomerProduct model) {
        ModelAndView view = new ModelAndView();
        try {
            String customerserial = RequestUtils.getStringParameter(request, "customerSerial", "");
            if(!StringUtils.isEmpty(customerserial)){
                model.setCustomerserial(customerserial);
            }
            view.addObject("model", model);
            view.setViewName("customer/editCustomerProduct");
        } catch (Exception ex) {
            log.error("", ex);
            view.addObject("exception", ex);
            view.setViewName("/error");
        }
        return view;
    }

    @RequestMapping("/addCustomerProduct")
    public ModelAndView addCustomerProduct(HttpServletRequest request, HttpServletResponse response, CustomerProduct model) throws Exception {
        ModelAndView view = new ModelAndView();
        try {
            int result = customerproductService.insertCustomerProduct(model);
            if (result <= 0) {
                throw new Exception("对不起，操作没有成功！");
            } else {
                //需要增加提示
//                MsgUtil.Alert(request,response,"success");
                view.setViewName("redirect:/customer/list");
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
    @RequestMapping("/toEditCustomerProduct")
    public ModelAndView toEditCustomerProduct(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView();
        try {
            Long id = RequestUtils.getLongParameter(request, "id", -1L);
            CustomerProduct model = customerproductService.getCustomerProductById(Integer.valueOf(id.toString()));
            view.addObject("model", model);
            view.setViewName("customer/editCustomerProduct");
        } catch (Exception ex) {
            log.error("", ex);
            view.addObject("exception", ex);
            view.setViewName("/error");
        }
        return view;
    }

    @RequestMapping("/editCustomerProduct")
    public ModelAndView edit(HttpServletRequest request, HttpServletResponse response, CustomerProduct model) throws Exception {
        ModelAndView view = new ModelAndView();
        try {
            if (null == model || null == model.getId() || model.getId() <= 0) {
                throw new Exception("缺少信息ID");
            }
            int result = customerproductService.updateCustomerProduct(model);
            if (result <= 0) {
                throw new Exception("对不起，操作没有成功！");
            } else {
                view.setViewName("redirect:/customer/showCustomerProduct?serial="+model.getCustomerserial());
            }
        } catch (Exception ex) {
            log.error("", ex);
            view.setViewName("/error");
        }
        return view;
    }

    @RequestMapping("/deleteCustomerProduct")
    public ModelAndView deleteCustomerProduct(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView();
        try {
            Long id = RequestUtils.getLongParameter(request, "id", -1L);
            CustomerProduct customerproduct = customerproductService.getCustomerProductById(Integer.valueOf(id.toString()));
            if (null != customerproduct) {
                customerproductService.deleteCustomerProduct(Integer.valueOf(id.toString()));
                MsgUtil.refreshPage(request, response,"/customer/showCustomerProduct?serial="+customerproduct.getCustomerserial());
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
