package com.zn.web.service;

import com.zn.web.model.CustomerProduct;

import java.util.List;

/**
 * Created by wutingting on 2017/4/4.
 */
public interface CustomerProductService {
    List<CustomerProduct> getCustomerProduct(CustomerProduct customerproduct);

    int insertCustomerProduct(CustomerProduct customerproduct);

    int insertSelectiveCustomerProduct(CustomerProduct customerproduct);

    CustomerProduct getCustomerProductById(Integer id);

    int deleteCustomerProduct(Integer id );

    int updateCustomerProduct(CustomerProduct customerproduct );

}
