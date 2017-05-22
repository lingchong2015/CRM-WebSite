package com.zn.web.service.impl;

import com.zn.web.dao.CustomerDao;
import com.zn.web.model.Customer;
import com.zn.web.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wutingting on 2017/4/4.
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class CustomerServiceImpl implements CustomerService {
    
    @Resource
    private CustomerDao customerDao;

    public Customer getCustomerById(Integer id) {
        return customerDao.selectByPrimaryKey(id);
    }
    
    public List<Customer> getAllCustomer() {
        return customerDao.selectAllCustomer();
    }

    //根据条件获得客户信息列表
    public List<Customer> getCustomer(Customer customer) {
        return customerDao.selectCustomer(customer);
    }

    public int insertCustomer(Customer customer) {
        return customerDao.insert(customer);
    }

    public int insertSelectiveCustomer(Customer customer) {
        return customerDao.insertSelective(customer);
    }

    public int deleteCustomer(Integer id ) {
        return customerDao.deleteByPrimaryKey(id);
    }

    public int updateCustomer(Customer customer ) {
        return customerDao.updateByPrimaryKeySelective(customer);
    }
}
