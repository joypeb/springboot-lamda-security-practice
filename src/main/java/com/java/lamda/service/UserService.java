package com.java.lamda.service;

import com.java.lamda.domain.User;
import com.java.lamda.domain.UserRole;
import com.java.lamda.exception.AppException;
import com.java.lamda.exception.ErrorCode;
import com.java.lamda.repository.UserRepository;
import com.java.lamda.utils.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    @Value("${jwt.token.secret}")
    private String secretKey;
    private long expireTimems = 60 * 60 * 1000;

    public String join(String userName, String password) {
        //username 중복체크
        userRepository.findByUserName(userName)
                .ifPresent(user -> {
                    throw new RuntimeException(String.format("%s는 이미 있습니다", userName));
                });

        //저장
        User user = User.builder()
                .userName(userName)
                .password(encoder.encode(password))
                .userRole(UserRole.USER)
                .build();
        userRepository.save(user);

        return "Success";
    }

    public String login(String userName, String password) {
        //유저이름 확인
        User user = userRepository.findByUserName(userName).orElseThrow(
                () -> new AppException(ErrorCode.USERNAME_NOT_FOUND, userName + "이 없습니다")
        );

        //패스워드 일치 확인
        if(!encoder.matches(password,user.getPassword())) {
            throw new AppException(ErrorCode.PASSWORD_INVALID, "패스워드가 일치하지 않습니다");
        }

        //로그인 토큰 발행
        return JwtTokenUtils.createToken(userName,secretKey,expireTimems);
    }

    public User getUserByUserName(String userName) {
        return userRepository.findByUserName(userName).orElseThrow(
                () -> new AppException(ErrorCode.USERNAME_NOT_FOUND, ""));
    }
}
