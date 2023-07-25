package com.seypak.study.intellij.data.handler.impl;

import com.seypak.study.intellij.data.dao.ProductDAO;
import com.seypak.study.intellij.data.entity.ProductEntity;
import com.seypak.study.intellij.data.handler.ProductDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductDataHandlerImpl implements ProductDataHandler {

    @Resource
    private ProductDAO productDao;

    @Override
    public ProductEntity saveProductEntity(String productId, String productName, int productPrice, int productStock) {
        ProductEntity productEntity = new ProductEntity(productId, productName, productPrice, productStock);

        return productDao.saveProduct(productEntity);
    }

    @Override
    public ProductEntity getProductEntity(String productId) {
        return productDao.getProduct(productId);
    }
}
