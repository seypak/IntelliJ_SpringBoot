package com.seypak.study.intellij.controller;

import com.seypak.study.intellij.data.dto.ProductDto;
import com.seypak.study.intellij.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

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

    // http://localhost:8080/api/v1/product-api/product
    @PostMapping(value = "/product")
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto) {

        // Validation Code Example
        // 아래와 같은 코드를 줄이기위한 @Valid annotation 사용
        if(!StringUtils.hasText(productDto.getProductId())) {
            LOGGER.error("[createProduct] failed Response :: productId is Empty");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(productDto);
        }

        String productId = productDto.getProductId();
        String productName = productDto.getProductId();
        int productPrice = productDto.getProductPrice();
        int productStock = productDto.getProductStock();

        ProductDto response = productService.saveProduct(productId, productName, productPrice, productStock);
        LOGGER.info("[createProduct] Response >> productId ='{}', productName ='{}', productPrice ='{}', productStock ='{}'"
        , response.getProductId(), response.getProductName(), response.getProductPrice(), response.getProductStock());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }
}
