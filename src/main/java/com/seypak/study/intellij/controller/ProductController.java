package com.seypak.study.intellij.controller;

import com.seypak.study.intellij.data.dto.ProductDto;
import com.seypak.study.intellij.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/v1/product-api")
public class ProductController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Resource
    private ProductService productService;

    //http://localhost:8080/api/v1/product-api/product/{productId}
    @GetMapping(value = "/product/{productId}")
    public ProductDto getProduct(@PathVariable String productId) {
        long startTime = System.currentTimeMillis();
        LOGGER.info("[ProductController] perform '{}' of seypak API.", startTime);

        ProductDto productDto = productService.getProduct(productId);
        // void info(String var1, Object... var2);
        // var1에 들어가는 argument {}가 순서대로 2,3,4... 파라미터에 데이터가 주입된다.
        LOGGER.info("[ProductController] Response :: productId ='{}', productName ='{}', productPrice ='{}', productStock ='{}', Response Time = '{}'ms"
                , productDto.getProductId()
                , productDto.getProductName()
                , productDto.getProductPrice()
                , productDto.getProductStock()
                , (System.currentTimeMillis()- startTime));

        return productDto;
    }
}
