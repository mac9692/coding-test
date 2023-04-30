package com.plateer.study.month1.day23;

//x만큼 간격이 있는 n개의 숫자 - https://school.programmers.co.kr/learn/courses/30/lessons/12954
public class Solution {
    public static void main(String[] args) {
        solution(-4, 2);
    }

    public static long[] solution(int x, int n) {

        long[] answer = new long[n];
        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += x;
            answer[i] = sum;
        }

        for (long num : answer) {
            System.out.println(num);
        }

        return answer;
    }
}
