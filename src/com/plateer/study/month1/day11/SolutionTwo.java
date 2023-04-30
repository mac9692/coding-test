package com.plateer.study.month1.day11;

// 두 정수 사이의 합 - https://school.programmers.co.kr/learn/courses/30/lessons/12912
public class SolutionTwo {
    public static void main(String[] args) {
        int a = 3;
        int b = 3;
        solution(a, b);
    }

    public static long solution(int a, int b) {
        long answer = 0;
        int c = Math.max(a, b);
        int d = Math.min(a, b);

        for (int i = d; i < c + 1; i++) {
            answer += i;
        }

        System.out.println(answer);
        return answer;
    }
}
