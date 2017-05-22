package com.zn.web.service;

import com.zn.web.model.Customer;

import java.util.List;

/**
 * Created by wutingting on 2017/4/4.
 */
public interface CustomerService {

    List<Customer> getAllCustomer();

    //根据条件获得客户信息列表
    List<Customer> getCustomer(Customer customer);

    Customer getCustomerById(Integer id);

    int insertCustomer(Customer customer);

    int insertSelectiveCustomer(Customer customer);

    int deleteCustomer(Integer id );

    int updateCustomer(Customer customer );
}
