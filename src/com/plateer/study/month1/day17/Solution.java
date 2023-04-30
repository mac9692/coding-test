package com.plateer.study.month1.day17;

import java.util.*;

// 같은 숫자는 싫어 - https://school.programmers.co.kr/learn/courses/30/lessons/12906
public class Solution {

    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        solution(arr);
    }

    public static int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        stack.push(arr[0]);

        for (int num : arr) {
            if (num == stack.peek()) {
                continue;
            }
            stack.push(num);
        }

        int[] answer = new int[stack.size()];
        int size = stack.size();

        for (int i = 0; i < size; i++) {
            answer[size - 1 - i] = stack.pop();
        }

        return answer;
    }
}
