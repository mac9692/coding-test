package com.plateer.study.day9;

import java.util.Arrays;

// 자릿수 더하기 - https://school.programmers.co.kr/learn/courses/30/lessons/12931
public class SolutionTwo {
    public static void main(String[] args) {
        int n = 123;
        solution(n);
    }
    public static int solution(int n) {
        int answer = 0;
        Integer[] ints = Arrays.stream(Integer.toString(n).split("")).map(s -> Integer.parseInt(s)).toArray(Integer[]::new);
        for (Integer num : ints) {
            answer += num;
        }

        return answer;
    }
}


