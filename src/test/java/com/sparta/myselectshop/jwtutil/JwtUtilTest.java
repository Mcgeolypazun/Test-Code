package com.sparta.myselectshop.jwtutil;

import com.sparta.myselectshop.CommonTest;
import com.sparta.myselectshop.jwt.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@DisplayName("JWTUtil 테스트")
public class JwtUtilTest implements CommonTest {

    @MockBean
    HttpServletRequest request;

    JwtUtil jwtUtil;
    @BeforeEach
    void setup(){
        jwtUtil = new JwtUtil();
        // secretKey 설정
        ReflectionTestUtils.setField(jwtUtil, "secretKey", "7Iqk7YyM66W07YOA7L2U65Sp7YG065+9U3ByaW5n6rCV7J2Y7Yqc7YSw7LWc7JuQ67mI7J6F64uI64ukLg==");
        // init 메서드 수동 호출
        jwtUtil.init();
    }
    //@PostConstruct
    //    public void init() {
    //        byte[] bytes = Base64.getDecoder().decode(secretKey);
    //        key = Keys.hmacShaKeyFor(bytes);
    //    }

    @Test
    @DisplayName("토큰 발급")
    void jwtCreateTokenTest(){
        //Given //When
        String token = jwtUtil.createToken(USERNAME,USER);

        //Then
        assertNotNull(token);
        assertTrue(token.startsWith(JwtUtil.BEARER_PREFIX));
    }
}
