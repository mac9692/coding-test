package com.plateer.study.month1.day10;

// 하샤드 수 - https://school.programmers.co.kr/learn/courses/30/lessons/12947
public class SolutionTwo {
    public static void main(String[] args) {
        int x = 100;
        solution(x);
    }

    public static boolean solution(int x) {
        int a = x;
        int b = 0;

        while (x > 0) {
            b += (x % 10);
            x /= 10;
        }

        if (a % b == 0) {
            return true;
        } else {
            return false;
        }
    }
}
