package com.java.lamda.controller;

import com.java.lamda.domain.dto.UserJoinRequest;
import com.java.lamda.domain.dto.UserLoginRequest;
import com.java.lamda.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody UserJoinRequest userJoinRequest) {
        String result = userService.join(userJoinRequest.getUserName(),userJoinRequest.getPassword());
        return ResponseEntity.ok().body("회원가입 성공" + result);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginRequest userLoginRequest) {
        log.info("컨트롤러 유저 확인 : " + userLoginRequest.getPassword());
        return ResponseEntity.ok().body(userService.login(userLoginRequest.getUserName(), userLoginRequest.getPassword()));
    }
}
