package com.sparta.myselectshop.dto;

import com.sparta.myselectshop.CommonTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductRequestDtoTest implements CommonTest {

    @Test
    public void testProductRequestDtoCreation() {
        // Given
        String title = TITLE;
        String image = IMAGE;
        String link = LINK;
        int lprice = LPRICE;

        // When
        ProductRequestDto product = new ProductRequestDto(title, image, link, lprice);

        // Then
        assertEquals(title, product.getTitle());
        assertEquals(image, product.getImage());
        assertEquals(link, product.getLink());
        assertEquals(lprice, product.getLprice());
    }
}
