package com.plateer.study.month1.day10;

import java.util.Arrays;

// 자연수 뒤집어 배열로 만들기 - https://school.programmers.co.kr/learn/courses/30/lessons/12932
public class Solution {
    public static void main(String[] args) {
        long n = 12345;
        solution(n);
    }

    public static int[] solution(long n) {
        int[] array = Arrays.stream(String.valueOf(n).split("")).mapToInt(Integer::parseInt).toArray();
        int[] answer = new int[array.length];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = array[array.length - 1 - i];
        }

        return answer;
    }
}
