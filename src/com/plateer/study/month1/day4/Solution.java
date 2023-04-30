package com.plateer.study.month1.day4;

import java.util.Arrays;
import java.util.Collections;

// 숫자 짝꿍 - https://school.programmers.co.kr/learn/courses/30/lessons/131128
public class Solution {
    public static void main(String[] args) {
        String x = "12321";
        String y = "42531";

        solution2(x, y);
    }

    public static String solution(String X, String Y) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < X.length(); i++) {
            for (int j = 0; j < Y.length(); j++) {
                char xChar = X.charAt(i);
                char yChar = Y.charAt(j);
                if (xChar == yChar) {
                    stringBuilder.append(xChar);
                    Y = Y.substring(0, j).concat(Y.substring(j + 1));
                }
            }
        }

        String[] strings = stringBuilder.toString().split("");

        Arrays.sort(strings, Collections.reverseOrder());

        stringBuilder.setLength(0);
        for (String s : strings) {
            stringBuilder.append(s);
        }

        if (stringBuilder.toString().isEmpty()) {
            return "-1";
        } else if (stringBuilder.toString().startsWith("0")) {
            return "0";
        } else {
            return stringBuilder.toString();
        }
    }

    public static String solution2(String X, String Y) {
        StringBuilder stringBuilder = new StringBuilder();

        int[] xInts = new int[10];
        int[] yInts = new int[10];
        int[] zInts = new int[10];

        intSolution(xInts, X);
        intSolution(yInts, Y);

        for (int i = 0; i < xInts.length; i++) {
            zInts[i] = Math.min(xInts[i], yInts[i]);
        }

        for (int i = zInts.length - 1; i > -1; i--) {
            while (zInts[i] > 0) {
                stringBuilder.append(i);
                zInts[i]--;
            }
        }

        if (stringBuilder.toString().isEmpty()) {
            return "-1";
        } else if (stringBuilder.toString().startsWith("0")) {
            return "0";
        } else {
            return stringBuilder.toString();
        }
    }

    public static int[] intSolution(int[] ints, String s) {
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - '0';
            ints[index]++;
        }
        return ints;
    }
}
