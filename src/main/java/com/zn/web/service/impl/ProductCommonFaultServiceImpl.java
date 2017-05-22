package com.zn.web.service.impl;

import com.zn.web.dao.ProductCommonFaultDao;
import com.zn.web.model.ProductCommonFault;
import com.zn.web.service.ProductCommonFaultService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wutingting on 2017/4/4.
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class ProductCommonFaultServiceImpl implements ProductCommonFaultService {
    
    @Resource
    private ProductCommonFaultDao productCommonFaultDao;

    public List<ProductCommonFault> getProductCommonFault(ProductCommonFault productCommonFault) {
        return productCommonFaultDao.selectProductCommonFault(productCommonFault);
    }

    public int insertProductCommonFault(ProductCommonFault productCommonFault){
        return productCommonFaultDao.insert(productCommonFault);
    }

    public int insertSelectiveProductCommonFault(ProductCommonFault productCommonFault){
        return productCommonFaultDao.insertSelective(productCommonFault);
    }

    public ProductCommonFault getProductCommonFaultById(Integer id) {
        return productCommonFaultDao.selectByPrimaryKey(id);
    }

    public int deleteProductCommonFault(Integer id ) {
        return productCommonFaultDao.deleteByPrimaryKey(id);
    }

    public int updateProductCommonFault(ProductCommonFault productCommonFault ) {
        return productCommonFaultDao.updateByPrimaryKeySelective(productCommonFault);
    }

}
