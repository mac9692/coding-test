package com.plateer.study.day5;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

// 체육복 - https://school.programmers.co.kr/learn/courses/30/lessons/42862
public class Solution {
    public static void main(String[] args) {
        int n = 4;
        int[] lost = {2, 3};
        int[] reserve = {3, 4};

        int answer = solution(n, lost, reserve);
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int[] studentNumber = new int[n];
        List<Integer> lostList = Arrays.stream(lost).boxed().sorted().collect(Collectors.toList());
        List<Integer> reserveList = Arrays.stream(reserve).boxed().sorted().collect(Collectors.toList());

        for (Integer i : lostList) {
            i -= 1;
            studentNumber[i]--;
        }

        for (int i = 0; i < lostList.size(); i++) {
            for (int j = 0; j < reserveList.size(); j++) {
                if (lostList.get(i).equals(reserveList.get(j))) {
                    studentNumber[reserveList.get(j)-1]++;
                    lostList.remove(i);
                    reserveList.remove(j);
                }
            }
        }

        for (Integer i : lostList) {
            i -= 1;
            for (Integer j : reserveList) {
                j -= 1;
                if (Objects.equals(j, i) || Objects.equals(j+1, i) || Objects.equals(j-1, i)) {
                    j += 1;
                    studentNumber[i]++;
                    reserveList.remove(j);
                    break;
                }
            }
        }

        int answer = Arrays.stream(studentNumber).filter(x -> x == 0).map(x -> x = 1).sum();

        return answer;
    }
}

/**
 * 사실 체육복 수만 구하면 됨??
 * 최초 잃은 거까지 체육복 수 n - lost.length?
 * reserve 를 요리조리 잘 조작해서 체육복 수 구하면
 * n - lost.length - reserve => return?
 */