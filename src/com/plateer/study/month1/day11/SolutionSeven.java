package com.plateer.study.month1.day11;

import java.util.*;

// 완주하지 못한 선수 - https://school.programmers.co.kr/learn/courses/30/lessons/42576
public class SolutionSeven {
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        solution(participant, completion);
    }

    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap();

        for (String s : participant) {
            map.put(s, map.getOrDefault(s, -1) + 1);
        }

        for (String s : completion) {
            map.put(s, map.get(s) - 1);
        }

        String answer = "";
        for (String key : map.keySet()) {
            if (map.get(key) == 0) {
                answer = key;
                break;
            }
        }
        return answer;
    }
}
