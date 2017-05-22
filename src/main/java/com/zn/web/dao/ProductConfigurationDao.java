package com.zn.web.dao;

import com.zn.web.model.ProductConfiguration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductConfigurationDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductConfiguration record);

    int insertSelective(ProductConfiguration record);

    ProductConfiguration selectByPrimaryKey(Integer id);

    List<ProductConfiguration> selectProductConfiguration(ProductConfiguration productConfiguration);

    int updateByPrimaryKeySelective(ProductConfiguration record);

    int updateByPrimaryKey(ProductConfiguration record);
}