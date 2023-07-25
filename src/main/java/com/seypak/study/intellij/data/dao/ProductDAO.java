package com.seypak.study.intellij.data.dao;

import com.seypak.study.intellij.data.entity.ProductEntity;

public interface ProductDAO {

    /**
     * 상품저장
     * @return ProductEntity
     */
    ProductEntity saveProduct(ProductEntity productEntity);

    /**
     * 상품조회 - productId
     * @return ProductEntity
     */
    ProductEntity getProduct(String productId);
}
