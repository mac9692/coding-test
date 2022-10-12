package com.plateer.study.day3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 최소직사각형 - https://school.programmers.co.kr/learn/courses/30/lessons/86491
public class Solution {
    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        solution(sizes);
    }
    public static int solution(int[][] sizes) {
        List<int[]> intArr = Arrays.stream(sizes).distinct().collect(Collectors.toList());

        intArr.stream().forEach(ints -> {
            System.out.println(ints[0]);
            System.out.println(ints[1]);
        });

        int answer = 0;
        return answer;
    }
}
