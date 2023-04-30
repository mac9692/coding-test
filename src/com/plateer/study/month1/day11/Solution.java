package com.plateer.study.month1.day11;

import java.util.*;

// 나누어 떨어지는 숫자 배열 - https://school.programmers.co.kr/learn/courses/30/lessons/12910
public class Solution {
    public static void main(String[] args) {
        int[] arr = {5, 9, 7, 10};
        int divisor = 5;
        solution(arr, divisor);
    }

    public static int[] solution(int[] arr, int divisor) {
        List<Integer> integerList = new ArrayList<>();
        for (int n : arr) {
            if (n % divisor == 0) {
                integerList.add(n);
            }
        }

        if (integerList.size() == 0) {
            integerList.add(-1);
        }
        Collections.sort(integerList);

        int[] answer = new int[integerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = integerList.get(i);
        }

        return answer;
    }
}
