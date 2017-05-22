package com.zn.web.dao;

import com.zn.web.model.CustomerProduct;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerProductDao {

    int insert(CustomerProduct record);

    //根据客户编号查询客户购买的产品信息列表
    List<CustomerProduct> selectCustomerProduct(CustomerProduct customerproduct);

    CustomerProduct selectByPrimaryKey(@Param("id") Integer id);

    int deleteByPrimaryKey(@Param("id") Integer id);

    int updateByPrimaryKeySelective(CustomerProduct record);

//    int updateByPrimaryKey(CustomerProduct record);

    int insertSelective(CustomerProduct record);

}