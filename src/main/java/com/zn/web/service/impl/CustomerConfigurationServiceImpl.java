package com.zn.web.service.impl;

import com.zn.web.dao.CustomerConfigurationDao;
import com.zn.web.model.CustomerConfiguration;
import com.zn.web.service.CustomerConfigurationService;
import com.zn.web.service.CustomerConfigurationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wutingting on 2017/4/4.
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class CustomerConfigurationServiceImpl implements CustomerConfigurationService {
    
    @Resource
    private CustomerConfigurationDao customerConfigurationDao;

    public CustomerConfiguration getCustomerConfigurationById(Integer id) {
        return customerConfigurationDao.selectByPrimaryKey(id);
    }
    
//    public List<CustomerConfiguration> getAllCustomerConfiguration() {
//        return customerConfigurationDao.selectAllCustomerConfiguration();
//    }

//    根据条件获得客户信息列表
//    public List<CustomerConfiguration> getCustomerConfiguration(CustomerConfiguration customerConfiguration) {
//        return customerConfigurationDao.selectCustomerConfiguration(customerConfiguration);
//    }

    public int insertCustomerConfiguration(CustomerConfiguration customerConfiguration) {
        return customerConfigurationDao.insert(customerConfiguration);
    }

    public int deleteCustomerConfiguration(Integer id ) {
        return customerConfigurationDao.deleteByPrimaryKey(id);
    }

    public int updateCustomerConfiguration(CustomerConfiguration customerConfiguration ) {
        return customerConfigurationDao.updateByPrimaryKeySelective(customerConfiguration);
    }
}
