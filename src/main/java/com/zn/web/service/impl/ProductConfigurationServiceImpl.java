package com.zn.web.service.impl;

import com.zn.web.dao.ProductConfigurationDao;
import com.zn.web.model.ProductConfiguration;
import com.zn.web.service.ProductConfigurationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wutingting on 2017/4/4.
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class ProductConfigurationServiceImpl implements ProductConfigurationService {
    
    @Resource
    private ProductConfigurationDao productConfigurationDao;

    public ProductConfiguration getProductConfigurationById(Integer id) {
        return productConfigurationDao.selectByPrimaryKey(id);
    }

    public List<ProductConfiguration> getProductConfiguration(ProductConfiguration productConfiguration) {
        return productConfigurationDao.selectProductConfiguration(productConfiguration);
    }

    public int insertProductConfiguration(ProductConfiguration productConfiguration) {
        return productConfigurationDao.insert(productConfiguration);
    }

    public int deleteProductConfiguration(Integer id ) {
        return productConfigurationDao.deleteByPrimaryKey(id);
    }

    public int updateProductConfiguration(ProductConfiguration productConfiguration ) {
        return productConfigurationDao.updateByPrimaryKeySelective(productConfiguration);
    }
}
