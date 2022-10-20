package com.plateer.study.day8;

import java.util.Arrays;

public class SolutionTwo {
    public static void main(String[] args) {
        String s = "3people unFollowed me";
        solution(s);
    }

    public static String solution(String s) {
        String answer = "";
        String[] strings = s.toLowerCase().split("");
        boolean flag = true;

        for (String str : strings) {
            answer += flag ? str.toUpperCase() : str;
            flag = str.equals(" ") ? true : false;
        }
        return answer;
    }
}
