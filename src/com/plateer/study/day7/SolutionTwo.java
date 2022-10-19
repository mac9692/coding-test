package com.plateer.study.day7;

// 점프와 순간 이동 - https://school.programmers.co.kr/learn/courses/30/lessons/12980
public class SolutionTwo {
    public static void main(String[] args) {
        int n = 5000;
        solution(n);
    }
    public static int solution(int n) {
        int ans = 0;

        while (n != 0) {
            if (n % 2 == 1) {
                ans += 1;
                n -= 1;
            } else {
                n /= 2;
            }
        }

        return ans;
    }
}
