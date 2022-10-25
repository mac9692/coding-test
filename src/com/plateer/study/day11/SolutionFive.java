package com.plateer.study.day11;

// 나머지가 1이 되는 수 찾기 - https://school.programmers.co.kr/learn/courses/30/lessons/87389
public class SolutionFive {
    public static void main(String[] args) {
        int n = 3;
        solution(n);
    }

    public static int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 1) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}
