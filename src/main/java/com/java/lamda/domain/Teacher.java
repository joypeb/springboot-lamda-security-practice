package com.java.lamda.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Teacher {
    private String name;
    private boolean isLikeAlgorithm;
    private boolean isLikeSpringBoot;
}
