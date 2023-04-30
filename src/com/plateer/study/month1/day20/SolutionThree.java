package com.plateer.study.month1.day20;

import java.util.ArrayList;
import java.util.List;

public class SolutionThree {
    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        solution(n, arr1, arr2);
    }
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = {};
        List<String> integerList1 = new ArrayList<>();
        List<String> integerList2 = new ArrayList<>();

        for (int i : arr1) {
            integerList1.add(Integer.toBinaryString(i));
        }

        for (int i : arr2) {
            integerList2.add(Integer.toBinaryString(i));
        }

        integerList1.stream().filter(str -> (str.length()< n)).forEach(str -> {
            int count = n - str.length();
            while (count > 0) {
                str = "0".concat(str);
                count--;
            }
        });
        List<String> integerList3 = new ArrayList<>(integerList1);
        System.out.println(integerList3);
        System.out.println(integerList2);

        return answer;
    }
}
