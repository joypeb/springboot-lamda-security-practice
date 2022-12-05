package com.java.lamda.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void name() {
        List<Teacher> teachers = new ArrayList<>();
        Teacher kyeongrok = new Teacher("김경록", true, true);
        Teacher kyrongwan = new Teacher("고경환", true,false);
        Teacher sujin = new Teacher("김수진", false,false);
        Teacher sohyun = new Teacher("강소현", true,false);
        Teacher kimK = new Teacher("김", true,true);

        teachers.add(kyeongrok);
        teachers.add(kyrongwan);
        teachers.add(sujin);
        teachers.add(sohyun);

        // DB에서 읽어오기
        List<Teacher> likeAlgorithem = teachers.stream()
                .filter(teacher -> teacher.isLikeAlgorithm() == true)
                .collect(Collectors.toList());

        for(Teacher t : likeAlgorithem) {
            System.out.println(t.getName());
        }

        // 개선판 .map이용
        List<String> likeAlgorithem2 = teachers.stream()
                .filter(teacher -> teacher.isLikeAlgorithm() == true)
                .map(teacher -> teacher.getName())//map을 이용해 getName만 추출
                .collect(Collectors.toList());

        for(String t : likeAlgorithem2) {
            System.out.println(t);
        }
    }

    @Test
    void predicateTest() {
        Predicate<Integer> predicate = num -> num > 10;
        System.out.println(predicate.test(10));
    }

    @Test
    void map() {
        List<Teacher> teachers = new ArrayList<>();
        Teacher kyeongrok = new Teacher("김경록", true, true);
        Teacher kyrongwan = new Teacher("고경환", true,false);
        Teacher sujin = new Teacher("김수진", false,false);
        Teacher sohyun = new Teacher("강소현", true,false);
        Teacher kimK = new Teacher("김", true,true);

        teachers.add(kyeongrok);
        teachers.add(kyrongwan);
        teachers.add(sujin);
        teachers.add(sohyun);
        teachers.add(kimK);

        List<Integer> teacherNameLength = teachers
                .stream()
                .filter(teacher -> teacher.isLikeSpringBoot() == true)
                .map(teacher -> teacher.getName().length())
                .collect(Collectors.toList());

        for(int t : teacherNameLength) {
            System.out.println(t);
        }
    }

    @Test
    void reduceTest() {
        String[] list = {"1","2","3","4","5"};

        int reduceSum = Arrays.stream(list)
                .map(s -> Integer.parseInt(s))
                .reduce(0,(a,b) -> a+b);

        System.out.println(reduceSum);
    }
}