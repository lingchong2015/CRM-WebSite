package com.zn.web.service;

import com.zn.web.model.ProductSpecification;

import java.util.List;

/**
 * Created by wutingting on 2017/4/4.
 */
public interface ProductSpecificationService {

    List<ProductSpecification> getProductSpecification(ProductSpecification product);

    ProductSpecification getProductSpecificationById(Integer id);

    int insertProductSpecification(ProductSpecification product);

    int insertSelectiveProductSpecification(ProductSpecification product);

    int deleteProductSpecification(Integer id );

    int updateProductSpecification(ProductSpecification product );
}
