package com.sparta.myselectshop.repository;


import com.sparta.myselectshop.CommonTest;
import com.sparta.myselectshop.dto.*;
import com.sparta.myselectshop.entity.Product;
import com.sparta.myselectshop.entity.User;
import com.sparta.myselectshop.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;

@DisplayName("ProductRepository 테스트")
@ExtendWith(MockitoExtension.class)
public class ProductRepositoryTest implements CommonTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    @DisplayName("ProductRepository User 이름 이용해서 products 찾기")
    public void setProductRepositoryTest(){
        //Given
        User user = new User(USERNAME,PASSWORD,EMAIL,USER);
        ProductRequestDto productRequestDto = new ProductRequestDto(TITLE,IMAGE,LINK,LPRICE);
        ProductRequestDto productRequestDto2 = new ProductRequestDto(TITLE2,IMAGE2,LINK2,LPRICE2);
        Product product = new Product(productRequestDto,user);
        Product product2 = new Product(productRequestDto2,user);
        List<Product> productList = List.of(
                product,
                product2
        );

        //when
        when(productRepository.findAllByUser(product.getUser())).thenReturn(productList);

        List<ProductResponseDto> resultProducts = productService.getProducts(user);

        //then
        assertEquals(productList.size(), resultProducts.size());



    }
}

//public interface ProductRepository extends JpaRepository<Product, Long> {
//    List<Product> findAllByUser(User user);
//}