package com.sparta.myselectshop.entity;

import com.sparta.myselectshop.dto.ProductMypriceRequestDto;
import com.sparta.myselectshop.dto.ProductRequestDto;
import com.sparta.myselectshop.naver.dto.ItemDto;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@DisplayName("product 엔티티 테스트")
public class ProductTest {

    @Test
    @DisplayName("product 엔티티 생성 테스트")
    void testProductCreation(){
        var title = "맥북";
        var image = "맥북 이미지";
        var link = "www.link.com";
        var lprice = 450000;

        User user = new User("철수","1234","qiz05@naver.com",UserRoleEnum.USER);
        ProductRequestDto productRequestDto = new ProductRequestDto(title,image,link,lprice);

        //when
        Product product = new Product(productRequestDto,user);

        //then
        assertEquals(title,product.getTitle());
        assertEquals(image,product.getImage());
        assertEquals(link,product.getLink());
        assertEquals(lprice,product.getLprice());
        assertEquals(user,product.getUser());

    }
    @Test
    @DisplayName("product 엔티티 업데이트 테스트")
    void productUpdateTest(){
        //Given
        var title = "맥북";
        var image = "맥북 이미지";
        var link = "www.link.com";
        var lprice = 450000;
        var myprice = 500000;
        User user = new User("철수","1234","qiz05@naver.com",UserRoleEnum.USER);
        ProductRequestDto productRequestDto = new ProductRequestDto(title,image,link,lprice);
        Product product = new Product(productRequestDto,user);
        ProductMypriceRequestDto productMypriceRequestDto = new ProductMypriceRequestDto();
        productMypriceRequestDto.setMyprice(myprice);
        String jsonString = "{ \"title\": \"Product Title\", \"link\": \"https://example.com\", \"image\": \"https://example.com/image.jpg\", \"lprice\": 100 }";
        JSONObject itemJson = new JSONObject(jsonString);
        ItemDto itemDto = new ItemDto(itemJson);


        //when
        product.update(productMypriceRequestDto);


        //When
        product.update(productMypriceRequestDto);
        product.updateByItemDto(itemDto);

        //Then
        assertEquals(myprice,product.getMyprice());
        assertEquals(itemDto.getLprice(),product.getLprice());
    }
}
