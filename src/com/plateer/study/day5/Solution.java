package com.plateer.study.day5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};

        int answer = solution(n, lost, reserve);
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int[] studentNumber = new int[n];

        List<Integer> reserveList = Arrays.stream(reserve).boxed().collect(Collectors.toList());


        for (int i : lost) {
            studentNumber[i]--;
        }

        for (int i : lost) {
            for (Integer j : reserveList) {
                if ((i == j + 1) || (i == j - 1)) {
                    studentNumber[i]++;
                    reserveList.remove(j);
                    break;
                }
            }
        }


        System.out.println(Arrays.toString(studentNumber));
        System.out.println(reserveList);
        int answer = Arrays.stream(studentNumber).filter(x -> x == 0).map(x -> x = 1).sum();
        System.out.println(answer);
        return answer;
    }
}


/**
 * 사실 체육복 수만 구하면 됨??
 * 최초 잃은 거까지 체육복 수 n - lost.length?
 * reserve 를 요리조리 잘 조작해서 체육복 수 구하면
 * n - lost.length - reserve => return?
 */