package com.zn.web.dao;

import com.zn.web.model.ProductCommonFault;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCommonFaultDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductCommonFault record);

    int insertSelective(ProductCommonFault record);

    ProductCommonFault selectByPrimaryKey(Integer id);

    List<ProductCommonFault> selectProductCommonFault(ProductCommonFault productCommonFault);

    int updateByPrimaryKeySelective(ProductCommonFault record);

    int updateByPrimaryKey(ProductCommonFault record);
}