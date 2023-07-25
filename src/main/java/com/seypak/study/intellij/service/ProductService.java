package com.seypak.study.intellij.service;

import com.seypak.study.intellij.data.dto.ProductDto;

public interface ProductService {

    /**
     * 상품저장
     * @param productId
     * @param productName
     * @param productPrice
     * @param productStock
     * @return ProductDto
     */
    ProductDto saveProduct(String productId, String productName, int productPrice, int productStock);

    /**
     * 상품조회 - productId
     * @param productId
     * @return ProductDto
     */
    ProductDto getProduct(String productId);

}
