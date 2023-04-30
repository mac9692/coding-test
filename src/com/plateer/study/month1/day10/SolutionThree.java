package com.plateer.study.month1.day10;

import java.util.Arrays;

// 문자열 내 p와 y의 개수 - https://school.programmers.co.kr/learn/courses/30/lessons/12916
public class SolutionThree {
    public static void main(String[] args) {
        String s = "pPoooyY";

    }
    static boolean solution(String s) {
        String[] strings = Arrays.stream(s.split("")).toArray(String[]::new);
        int countP = 0;
        int countY = 0;

        for (String str : strings) {
            if ("p".equalsIgnoreCase(str)) {
                countP++;
            } else if ("y".equalsIgnoreCase(str)) {
                countY++;
            }
        }

        if (countP == countY || (countP == 0 && countY == 0)) {
            return true;
        } else {
            return false;
        }
    }
}
