package com.plateer.study.day11;

// 콜라츠 추측 - https://school.programmers.co.kr/learn/courses/30/lessons/12943
public class SolutionSix {
    public static void main(String[] args) {
        int n = 6;
        solution(n);
    }

    public static int solution(int num) {
        int answer = 0;

        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
                answer++;
                continue;
            }
            if (num % 2 == 1) {
                num = (num * 3) + 1;
                answer++;
                continue;
            }
            answer++;
            if (answer == 500) {
                answer = -1;
                break;
            }
        }
        return answer;
    }
}
