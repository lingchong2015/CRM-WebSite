package com.zn.web.service.impl;

import com.zn.web.dao.ProductDao;
import com.zn.web.model.Product;
import com.zn.web.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wutingting on 2017/4/4.
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class ProductServiceImpl implements ProductService {
    
    @Resource
    private ProductDao productDao;

    public Product getProductById(Integer id) {
        return productDao.selectByPrimaryKey(id);
    }
    
//    根据条件获得客户信息列表
    public List<Product> getProduct(Product product) {
        return productDao.selectProduct(product);
    }

    public int insertProduct(Product product) {
        return productDao.insert(product);
    }

    public int insertSelectiveProduct(Product product) {
        return productDao.insertSelective(product);
    }

    public int deleteProduct(Integer id ) {
        return productDao.deleteByPrimaryKey(id);
    }

    public int updateProduct(Product product ) {
        return productDao.updateByPrimaryKeySelective(product);
    }
}
