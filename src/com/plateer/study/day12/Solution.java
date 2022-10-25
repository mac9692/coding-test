package com.plateer.study.day12;

import java.util.Arrays;
import java.util.Comparator;

// 문자열 내림차순으로 배치하기 - https://school.programmers.co.kr/learn/courses/30/lessons/12917
public class Solution {
    public static void main(String[] args) {
        String s = "Zbcdefg";
        solution(s);
    }

    public static String solution(String s) {
        String[] strings = s.split("");
        Arrays.sort(strings, Comparator.reverseOrder());
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strings) {
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }
}
