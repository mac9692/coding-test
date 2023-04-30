package com.plateer.study.month1.day19;

// 핸드폰 번호 가리기 - https://school.programmers.co.kr/learn/courses/30/lessons/12948
public class Solution {
    public static void main(String[] args) {
        String phone_number = "01033334444";
        solution2(phone_number);
    }

    public static String solution(String phone_number) {
        String[] strings = phone_number.split("");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            if (i < strings.length - 4) {
                strings[i] = "*";
            }
            stringBuilder.append(strings[i]);
        }
        return stringBuilder.toString();
    }

    public static String solution2(String phone_number) {
        char[] chars = phone_number.toCharArray();
        for (int i = 0; i < chars.length - 4; i++) {
            chars[i] = '*';
        }
        return String.valueOf(chars);
    }
}
