package com.seypak.study.intellij.service.impl;

import com.seypak.study.intellij.data.dto.ProductDto;
import com.seypak.study.intellij.data.entity.ProductEntity;
import com.seypak.study.intellij.data.handler.ProductDataHandler;
import com.seypak.study.intellij.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductDataHandler productDataHandler;

    @Override
    public ProductDto saveProduct(String productId, String productName, int productPrice, int productStock) {
        ProductEntity productEntity = productDataHandler.saveProductEntity(productId,productName,productPrice,productStock);

        return new ProductDto(
                productEntity.getProductId(), productEntity.getProductName(), productEntity.getProductPrice(), productEntity.getProductStock());

    }

    @Override
    public ProductDto getProduct(String productId) {
        ProductEntity productEntity = productDataHandler.getProductEntity(productId);

        return new ProductDto(
                productEntity.getProductId(), productEntity.getProductName(), productEntity.getProductPrice(), productEntity.getProductStock());
    }
}
