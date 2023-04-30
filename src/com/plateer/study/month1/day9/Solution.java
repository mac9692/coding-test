package com.plateer.study.month1.day9;

import java.util.Arrays;
import java.util.Collections;

// 최솟값 만들기 - https://school.programmers.co.kr/learn/courses/30/lessons/12941
public class Solution {
    public static void main(String[] args) {
        int[] intsA = {1, 4, 2};
        int[] intsB = {5, 4, 4};
        solution2(intsA, intsB);
    }
    public static int solution(int []A, int []B)
    {
        int answer = 0;

        Integer[] integersB = Arrays.stream(B).boxed().toArray(Integer[]::new);
        Arrays.sort(A);
        Arrays.sort(integersB, Collections.reverseOrder());

        for (int i = 0; i < A.length; i++) {
            answer += (A[i] * integersB[i]);
        }

        return answer;
    }

    public static int solution2(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int index = A.length - 1;
        for (int i = 0; i < A.length; i++) {
            answer += (A[i] * B[index]);
            index--;
        }

        return answer;
    }
}
