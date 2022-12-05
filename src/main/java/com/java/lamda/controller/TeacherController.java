package com.java.lamda.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/teachers")
@RequiredArgsConstructor
public class TeacherController {


    @GetMapping
    public String get() throws Exception {
/*
        Exception e = new RuntimeException("선생이 없습니다");
        throw e;

        고의로 에러를 발생시켰다
        특정 에러가 발생할 경우 RestControllerAdvice로가게된다
*/
        return "hello";
    }

    /*@GetMapping("/world")
    public String world() throws HospitalException {
        teacherService.world();
        return "";
    }*/
}
