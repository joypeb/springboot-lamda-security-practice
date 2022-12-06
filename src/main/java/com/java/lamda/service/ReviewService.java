package com.java.lamda.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReviewService {

    public String write(String userName) {
        return userName + "의 리뷰가 등록되었습니다";
    }
}
