package com.plateer.study.month1.day25;

import java.util.Arrays;

// 올바른 괄호 - https://school.programmers.co.kr/learn/courses/30/lessons/12909
public class Solution {
    public static void main(String[] args) {
        String s = ")(";
        solution(s);
    }


    static boolean solution(String s) {
        int count = 0;

        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (c == '(') {
                count++;
            } else {
                count--;
            }

            if (count < 0) {
                break;
            }
        }

        return count == 0;
    }
}

