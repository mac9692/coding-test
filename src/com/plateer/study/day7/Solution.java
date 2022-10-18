package com.plateer.study.day7;

// 숫자의 표현 - https://school.programmers.co.kr/learn/courses/30/lessons/12924
public class Solution {
    public static void main(String[] args) {
        int n = 15;
        solution3(n);
    }


/*    public static int solution(int n) {
        int answer = 0;
        int sum = 0;

        for (int i = 1; i < n; i++) {
            for (int j = n; j > 0; j--) {
                if (((i * j) + sum) == n) {
                    answer++;
                }
            }
            sum += i;
        }
        return answer;
    }*/

    public static int solution2(int n) {
        int answer = 0;
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                sum += j;
                if (sum == n) {
                    answer++;
                    break;
                }
            }
            sum = 0;
        }
        return answer;
    }


    public static int solution3(int n) {
        int answer = 0;
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                sum += j;
                if (sum == n) {
                    answer++;
                    break;
                }
            }
            sum = 0;
        }

        System.out.println(answer);
        return answer;
    }
}
