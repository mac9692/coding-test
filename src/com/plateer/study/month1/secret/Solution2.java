package com.plateer.study.month1.secret;

import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) {
        long n = 11;
        System.out.println(solution(n));
    }

    public static long solution(long n) {
        long[] binaryLongArr = makeBinaryLongArr(n);

        long sum = 0;

        int arrLength = binaryLongArr.length;
        for (int index = 0; index < arrLength; index++) {
            if (binaryLongArr[index] == 1) {
                sum += pow(arrLength - index - 1);
            }
        }

        return sum;
    }

    private static long[] makeBinaryLongArr(long n) {
        String binaryString = Integer.toBinaryString((int) n);
        String[] strings = binaryString.split("");

        return Arrays.stream(strings).mapToLong(Long::parseLong).toArray();
    }

    private static long pow(int count) {
        long value = 1L;
        for (int i = 0; i < count; i++) {
            value *= 3;
        }
        return value;
    }
}
