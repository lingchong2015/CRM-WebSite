package com.zn.web.service.impl;

import com.zn.web.dao.CustomerProductDao;
import com.zn.web.model.CustomerProduct;
import com.zn.web.service.CustomerProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wutingting on 2017/4/4.
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class CustomerProductServiceImpl implements CustomerProductService {
    
    @Resource
    private CustomerProductDao customerproductDao;

    public List<CustomerProduct> getCustomerProduct(CustomerProduct customerproduct) {
        return customerproductDao.selectCustomerProduct(customerproduct);
    }

    public int insertCustomerProduct(CustomerProduct customerproduct){
        return customerproductDao.insert(customerproduct);
    }

    public int insertSelectiveCustomerProduct(CustomerProduct customerproduct){
        return customerproductDao.insertSelective(customerproduct);
    }

    public CustomerProduct getCustomerProductById(Integer id) {
        return customerproductDao.selectByPrimaryKey(id);
    }

    public int deleteCustomerProduct(Integer id ) {
        return customerproductDao.deleteByPrimaryKey(id);
    }

    public int updateCustomerProduct(CustomerProduct customerproduct ) {
        return customerproductDao.updateByPrimaryKeySelective(customerproduct);
    }

}
