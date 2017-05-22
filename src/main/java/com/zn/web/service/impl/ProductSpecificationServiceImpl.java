package com.zn.web.service.impl;

import com.zn.web.dao.ProductSpecificationDao;
import com.zn.web.model.ProductSpecification;
import com.zn.web.service.ProductSpecificationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wutingting on 2017/4/4.
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class ProductSpecificationServiceImpl implements ProductSpecificationService {
    
    @Resource
    private ProductSpecificationDao productSpecificationDao;

    public ProductSpecification getProductSpecificationById(Integer id) {
        return productSpecificationDao.selectByPrimaryKey(id);
    }
    
    public List<ProductSpecification> getProductSpecification(ProductSpecification productSpecification) {
        return productSpecificationDao.selectProductSpecification(productSpecification);
    }

    public int insertProductSpecification(ProductSpecification productSpecification) {
        return productSpecificationDao.insert(productSpecification);
    }

    public int insertSelectiveProductSpecification(ProductSpecification productSpecification) {
        return productSpecificationDao.insertSelective(productSpecification);
    }

    public int deleteProductSpecification(Integer id ) {
        return productSpecificationDao.deleteByPrimaryKey(id);
    }

    public int updateProductSpecification(ProductSpecification productSpecification ) {
        return productSpecificationDao.updateByPrimaryKeySelective(productSpecification);
    }
}
