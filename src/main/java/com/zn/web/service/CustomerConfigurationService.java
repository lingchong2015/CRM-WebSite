package com.zn.web.service;

import com.zn.web.model.CustomerConfiguration;

import java.util.List;

/**
 * Created by wutingting on 2017/4/4.
 */
public interface CustomerConfigurationService {

//    List<CustomerConfiguration> getAllCustomerConfiguration();

//    List<CustomerConfiguration> getCustomerConfiguration(CustomerConfiguration customerConfiguration);

    CustomerConfiguration getCustomerConfigurationById(Integer id);

    int insertCustomerConfiguration(CustomerConfiguration customerConfiguration);

    int deleteCustomerConfiguration(Integer id );

    int updateCustomerConfiguration(CustomerConfiguration customerConfiguration );
}
