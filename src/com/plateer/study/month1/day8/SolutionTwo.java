package com.plateer.study.month1.day8;

// JadenCase 문자열 만들기 - https://school.programmers.co.kr/learn/courses/30/lessons/12951
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
