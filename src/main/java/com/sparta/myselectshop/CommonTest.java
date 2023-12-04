package com.sparta.myselectshop;

import com.sparta.myselectshop.entity.User;
import com.sparta.myselectshop.entity.UserRoleEnum;

public interface CommonTest {
    String USERNAME = "username";
    String PASSWORD = "password";
    String EMAIL = "email@naver.com";
    String ANOTHER_PREFIX = "another-";
    UserRoleEnum USER = UserRoleEnum.USER;
    UserRoleEnum ADMIN = UserRoleEnum.ADMIN;

    String TITLE = "신발";
    String IMAGE = "https://example.com/shoes.jpg";
    String LINK = "https://shop.example.com/shoes";
    int LPRICE = 50000;

    String TITLE2 = "맥북";
    String IMAGE2 = "https://example.com/mac.jpg";
    String LINK2 = "https://shop.example.com/mac";
    int LPRICE2 = 500000;

    User TEST_USER = User.builder()
            .username(USERNAME)
            .password(PASSWORD)
            .email(EMAIL)
            .build();
    User TEST_USER2 = User.builder()
            .username(ANOTHER_PREFIX+USERNAME)
            .password(ANOTHER_PREFIX+PASSWORD)
            .email(ANOTHER_PREFIX+EMAIL)
            .build();

}
