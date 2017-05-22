package com.zn.web.dao;

import com.zn.web.model.Customer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDao {

    Customer selectByPrimaryKey(@Param("id") Integer id);

    List<Customer> selectAllCustomer();

    //根据条件查找客户信息
    List<Customer> selectCustomer(Customer customer);

    int insert(Customer record);

    int deleteByPrimaryKey(@Param("id") Integer id);

    int updateByPrimaryKeySelective(Customer customer);

    int insertSelective(Customer record);

//    int updateByPrimaryKey(Customer customer);
}