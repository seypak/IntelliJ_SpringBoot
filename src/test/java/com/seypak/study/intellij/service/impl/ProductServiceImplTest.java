package com.seypak.study.intellij.service.impl;

import com.seypak.study.intellij.data.dto.ProductDto;
import com.seypak.study.intellij.data.entity.ProductEntity;
import com.seypak.study.intellij.data.handler.impl.ProductDataHandlerImpl;
import com.seypak.study.intellij.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.verify;

//서로 상호 대체 가능
@SpringBootTest(classes = {ProductDataHandlerImpl.class, ProductServiceImpl.class})
//@ExtendWith(SpringExtension.class)
//@Import({ProductDataHandlerImpl.class, ProductServiceImpl.class})
public class ProductServiceImplTest {

    @MockBean
    ProductDataHandlerImpl productDataHandler;

    @Autowired
    ProductService productService;

    @Test
    @DisplayName("ProductServiceImplTest.getProductTest")
    public void getProductTest() {
        //given
        Mockito.when(productDataHandler.getProductEntity("123"))
                .thenReturn(new ProductEntity("123", "pen", 2000, 3000));

        ProductDto productDto = productService.getProduct("123");

        Assertions.assertEquals(productDto.getProductId(), "123");

        verify(productDataHandler).getProductEntity("123");
    }


    @Test
    @DisplayName("ProductServiceImplTest.saveProductTest")
    public void saveProductTest() {
        //given
        Mockito.when(productDataHandler.saveProductEntity("123", "pen", 2000, 3000))
                .thenReturn(new ProductEntity("123", "pen", 2000, 3000));

        ProductDto productDto = productService.saveProduct("123","pen", 2000, 3000);

        Assertions.assertEquals(productDto.getProductId(), "123");
        Assertions.assertEquals(productDto.getProductName(), "pen");
        Assertions.assertEquals(productDto.getProductPrice(), 2000);
        Assertions.assertEquals(productDto.getProductStock(), 3000);

        verify(productDataHandler).saveProductEntity("123", "pen", 2000, 3000);
    }
}
