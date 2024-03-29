package com.plateer.study.month1.day15;

// 옹알이1 - https://school.programmers.co.kr/learn/courses/30/lessons/120956
public class Solution {
    public static void main(String[] args) {
        String[] babbling = {"aya", "yee", "u", "maa", "wyeoo"};
        solution(babbling);
    }
    public static int solution(String[] babbling) {
        String[] canSpeak = {"aya", "ye", "woo", "ma"};

        int answer = 0;

        for (String b : babbling) {
            for (String c : canSpeak) {
                if (b.contains(c)) {
                    b = b.replace(c, "-");
                }
            }
            b = b.replace("-", "");
            if (b.equals("")) {
                answer++;
            }
        }

        return answer;
    }
}
