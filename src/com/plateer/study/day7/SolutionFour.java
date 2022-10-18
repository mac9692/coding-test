package com.plateer.study.day7;

import java.util.Arrays;

public class SolutionFour {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        solution(arr);
    }

    public static double solution(int[] arr) {
        double answer = Arrays.stream(arr).mapToDouble(Double::valueOf).sum() / arr.length;
        System.out.println(answer);
        return answer;
    }
}
