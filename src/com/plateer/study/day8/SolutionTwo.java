package com.plateer.study.day8;

import java.util.Arrays;

public class SolutionTwo {
    public static void main(String[] args) {
        String s = "3people unFollowed me";
        solution(s);
    }

    public static String solution(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(s.trim().split(" ")).map(String::toLowerCase).map(x -> x.substring(0, 1).toUpperCase().concat(x.substring(1))).forEach(str -> stringBuilder.append(str + " "));

        return stringBuilder.toString().trim();
    }
}
