package com.plateer.study.month1.day8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// 최댓값과 최솟값 - https://school.programmers.co.kr/learn/courses/30/lessons/12939
public class Solution {
    public static void main(String[] args) {
        String s = "1 2 3 4";
        solution(s);
    }

    public static String solution(String s) {
        List<Integer> integerList = Arrays.stream(s.split(" ")).map(Integer::parseInt).sorted(Collections.reverseOrder()).collect(Collectors.toList());
        return String.valueOf(integerList.get(integerList.size()-1)).concat(" ").concat(String.valueOf(integerList.get(0)));
    }
}
