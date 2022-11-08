package com.plateer.study.day20;

// 푸드 파이트 대회 - https://school.programmers.co.kr/learn/courses/30/lessons/134240
public class SolutionTwo {
    public static void main(String[] args) {
        int[] food = {1, 3, 4, 6};
        solution(food);
    }
    public static String solution(int[] food) {
        String answer = "";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            if (food[i] % 2 == 1) {
                food[i] -= 1;
            }
            if (food[i] == 0) {
                continue;
            }
            food[i] /= 2;
            int index = food[i];
            while (index > 0) {
                stringBuilder.append(i);
                index--;
            }
        }
        stringBuilder.append(0);
        for (int i = food.length - 1; i > 0; i--) {
            if (food[i] == 0) {
                continue;
            }
            int index = food[i];
            while (index > 0) {
                stringBuilder.append(i);
                index--;
            }
        }
        return stringBuilder.toString();
    }
}
