package com.plateer.study.day22;

// 수박수박수박수박수박수? - https://school.programmers.co.kr/learn/courses/30/lessons/12922
public class Solution {
    public static void main(String[] args) {
        int n = 3;
        solution(3);
    }

    public static String solution(int n) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String s = (i % 2 == 0) ? "수" : "박";
            stringBuilder.append(s);
        }

        return stringBuilder.toString();
    }
}
