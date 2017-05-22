package com.zn.web.dao;

import com.zn.web.model.ProductSpecification;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductSpecificationDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductSpecification record);

    int insertSelective(ProductSpecification record);

    ProductSpecification selectByPrimaryKey(Integer id);

    List<ProductSpecification> selectProductSpecification(ProductSpecification productSpecification);

    int updateByPrimaryKeySelective(ProductSpecification productSpecification);

    int updateByPrimaryKey(ProductSpecification productSpecification);
}