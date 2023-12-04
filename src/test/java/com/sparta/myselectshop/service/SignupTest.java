package com.sparta.myselectshop.service;

import com.sparta.myselectshop.dto.SignupRequestDto;
import com.sparta.myselectshop.entity.User;
import com.sparta.myselectshop.repository.UserRepository;
import com.sparta.myselectshop.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@DisplayName("회원가입 테스트")
public class SignupTest {

    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    UserService userService;

    @BeforeEach
    public void setup() {
        userRepository = mock(UserRepository.class);
        passwordEncoder = mock(PasswordEncoder.class);
        userService = new UserService(userRepository, passwordEncoder);
    }

    @DisplayName("일반 회원 가입 성공")
    @Transactional
    @Test
    public void makeSignup(){
        //given
        String username = "username";
        String password = "password";
        String email = "email@naver.com";
        var request = new SignupRequestDto();
        request.setUsername(username);
        request.setPassword(password);
        request.setEmail(email);



        //when
        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
        userService.signup(request);

        //then
        verify(userRepository, times(1)).save(any(User.class));

    }
}
