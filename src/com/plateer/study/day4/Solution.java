package com.plateer.study.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        String x = "12321";
        String y = "42531";

        solution(x, y);
    }

    public static String solution(String X, String Y) {
        List<String> stringList = Arrays
                .stream(X.split(""))
                .distinct()
                .filter(x -> Arrays.stream(Y.split("")).distinct().anyMatch(Predicate.isEqual(x)))
                .collect(Collectors.toList());

        System.out.println(stringList.toString());

        String answer = "";
        return answer;
    }
}
