package com.zn.web.service;

import com.zn.web.model.ProductCommonFault;

import java.util.List;

/**
 * Created by wutingting on 2017/4/4.
 */
public interface ProductCommonFaultService {

    List<ProductCommonFault> getProductCommonFault(ProductCommonFault productCommonFault);

    ProductCommonFault getProductCommonFaultById(Integer id);

    int insertProductCommonFault(ProductCommonFault productCommonFault);

    int insertSelectiveProductCommonFault(ProductCommonFault productCommonFault);

    int deleteProductCommonFault(Integer id );

    int updateProductCommonFault(ProductCommonFault productCommonFault );
}
