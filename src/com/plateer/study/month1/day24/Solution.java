package com.plateer.study.month1.day24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
        solution(arr);
    }

    public static int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();

        for (int num : arr) {
            list.add(num);
        }

        list.sort(Comparator.naturalOrder());
        list.remove(0);
        if (list.size() == 0) {
            list.add(-1);
        }

        System.out.println(list);
        int[] answer = list.toArray(new Integer[0]);
        return answer;
    }
}
