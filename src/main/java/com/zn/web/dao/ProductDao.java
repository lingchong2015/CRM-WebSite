package com.zn.web.dao;

import com.zn.web.model.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    //根据条件查找客户信息
    List<Product> selectProduct(Product product);

    Product selectByPrimaryKey(@Param("id") Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}