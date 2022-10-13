package com.plateer.study.day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 최소직사각형 - https://school.programmers.co.kr/learn/courses/30/lessons/86491
public class Solution {
    public static void main(String[] args) {
//        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
//        int[][] sizes = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
        int[][] sizes = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};

        solution(sizes);
    }
    public static int solution(int[][] sizes) {
        List<Integer> bigInts = new ArrayList<>();
        List<Integer> smallInts = new ArrayList<>();

        for (int i = 0; i < sizes.length; i++) {
            if (Integer.compare(sizes[i][0], sizes[i][1]) > 0) {
                bigInts.add(sizes[i][0]);
                smallInts.add(sizes[i][1]);
            } else {
                bigInts.add(sizes[i][1]);
                smallInts.add(sizes[i][0]);
            }
        }

        Collections.sort(bigInts, Collections.reverseOrder());
        Collections.sort(smallInts, Collections.reverseOrder());

        return bigInts.get(0) * smallInts.get(0);
    }
}
