package com.zn.web.service;

import com.zn.web.model.ProductConfiguration;

import java.util.List;

/**
 * Created by wutingting on 2017/4/4.
 */
public interface ProductConfigurationService {

    List<ProductConfiguration> getProductConfiguration(ProductConfiguration productConfiguration);

    ProductConfiguration getProductConfigurationById(Integer id);

    int insertProductConfiguration(ProductConfiguration productConfiguration);

    int deleteProductConfiguration(Integer id );

    int updateProductConfiguration(ProductConfiguration productConfiguration );
}
