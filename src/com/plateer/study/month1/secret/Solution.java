package com.plateer.study.month1.secret;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int[][] office = {{1, 0, 0, 0}, {0, 0, 0, 1}, {0, 0, 1, 0}, {0, 1, 1, 0}};
        int k = 2;
        solution(office, k);
    }

    // 00 01 10 11
    public static int solution(int[][] office, int k) {
        int answer = -1;
        int sum = 0;
        List<Integer> integerList = new ArrayList<>();

        for (int index = 0; index < office.length; index++) {
            for (int index2 = 0; index2 < office.length; index2++) {
                System.out.print("행 : " + index);
                System.out.println(" 열 : " + index2);
                if (index2 == 1) {
                    break;
                }
            }
        }

        return answer;
    }
}
