package com.plateer.study.month1.day24;

import java.util.Arrays;

// 제일 작은 수 제거하기 - https://school.programmers.co.kr/learn/courses/30/lessons/12935
public class Solution {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
        solution(arr);
    }

    public static int[] solution(int[] arr) {
        if (arr.length == 1) {
            arr[0] = -1;
        } else {
            int min = arr[0];

            for (Integer num : arr) {
                min = Math.min(min, num);
            }

            int filter = min;

            arr = Arrays.stream(arr)
                    .filter(i -> i != filter)
                    .toArray();
        }

        return arr;
    }
}
