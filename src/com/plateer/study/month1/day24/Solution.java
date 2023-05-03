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

        list.sort(Comparator.reverseOrder());
        list.remove(list.size()-1);
        if (list.size() == 0) {
            list.add(-1);
        }

        Integer[] integerList = list.toArray(new Integer[list.size()]);
        int[] answer = Arrays.stream(integerList).mapToInt(item -> item).toArray();
        return answer;
    }
}
