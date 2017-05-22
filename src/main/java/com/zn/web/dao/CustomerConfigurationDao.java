package com.zn.web.dao;

import com.zn.web.model.CustomerConfiguration;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerConfigurationDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CustomerConfiguration record);

    int insertSelective(CustomerConfiguration record);

    CustomerConfiguration selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CustomerConfiguration record);

    int updateByPrimaryKey(CustomerConfiguration record);
}