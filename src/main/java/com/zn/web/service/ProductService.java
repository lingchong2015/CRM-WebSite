package com.zn.web.service;

import com.zn.web.model.Product;

import java.util.List;

/**
 * Created by wutingting on 2017/4/4.
 */
public interface ProductService {

//    List<Product> getAllProduct();

    List<Product> getProduct(Product product);

    Product getProductById(Integer id);

    int insertProduct(Product product);

    int insertSelectiveProduct(Product product);

    int deleteProduct(Integer id );

    int updateProduct(Product product );
}
