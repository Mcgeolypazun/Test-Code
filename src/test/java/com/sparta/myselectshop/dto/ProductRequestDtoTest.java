package com.sparta.myselectshop.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductRequestDtoTest {

    @Test
    public void testProductRequestDtoCreation() {
        // Given
        String title = "신발";
        String image = "https://example.com/shoes.jpg";
        String link = "https://shop.example.com/shoes";
        int lprice = 50000;

        // When
        ProductRequestDto product = new ProductRequestDto(title, image, link, lprice);

        // Then
        assertEquals(title, product.getTitle());
        assertEquals(image, product.getImage());
        assertEquals(link, product.getLink());
        assertEquals(lprice, product.getLprice());
    }
}
