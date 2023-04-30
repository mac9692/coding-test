package com.plateer.study.month1.day14;

// 부족한 금액 계산하기 - https://school.programmers.co.kr/learn/courses/30/lessons/82612
public class Solution {
    public static void main(String[] args) {
        int price = 3;
        int money = 20;
        int count = 5;
        solution(price, money, count);
    }
    public static long solution(int price, int money, int count) {
        long answer = 0;
        long sum = 0;
        for (int i = 1; i <= count; i++) {
            sum += i * price;
        }

        if (sum > money) {
            answer = sum - money;
        }
        return answer;
    }
}
