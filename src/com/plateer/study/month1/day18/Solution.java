package com.plateer.study.month1.day18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 정수 내림차순으로 배치하기 - https://school.programmers.co.kr/learn/courses/30/lessons/12933
public class Solution {
    public static void main(String[] args) {
        long n = 118372;
        solution2(n);
    }

    public static long solution(long n) {
        List<Long> longList = new ArrayList<>();

        while (n > 0) {
            longList.add(n % 10);
            n /= 10;
        }

        longList.sort(Collections.reverseOrder());
        StringBuilder stringBuilder = new StringBuilder();

        longList.forEach(stringBuilder::append);

        return Long.parseLong(stringBuilder.toString());
    }

    public static long solution2(long n) {
        String[] strings = String.valueOf(n).split("");

        Arrays.sort(strings, Collections.reverseOrder());

        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strings) {
            stringBuilder.append(s);
        }

        return Long.parseLong(stringBuilder.toString());
    }
}
