package com.java.lamda.controller;

import com.java.lamda.domain.dto.ReviewCreateRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    @PostMapping
    public String write(@RequestBody ReviewCreateRequest dto) {
        return "리뷰 등록 성공";
    }
}
