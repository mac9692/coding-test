package com.plateer.study.two;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};

        solution(id_list, report, 2);
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        // 신고 생성
        Set<String> set = new LinkedHashSet<>(Arrays.asList(report));

        // 신고 카운트 생성
        Map<String, Integer> map = new LinkedHashMap<>();
        for (String id : id_list) {
            map.put(id, 0);
        }

        // 신고 카운트 집계
        set.forEach(s -> {
            String[] strings = s.split("\\s");
            if (map.containsKey(strings[1])) {
                map.replace(strings[1], map.get(strings[1])+1);
            }
        });

        // 신고자 명단 생성
        List<String[]> list = new ArrayList<>();
        set.forEach(s -> list.add(s.split("\\s")));

        // 메일 발송 명단 생성
        Map<String, Integer> mailMap = new LinkedHashMap<>();
        for (String id : id_list) {
            mailMap.put(id, 0);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= k) {
                list.forEach(reportMember -> {
                    if (reportMember[1].contains(entry.getKey())){
                        mailMap.replace(reportMember[0], mailMap.get(reportMember[0])+1);
                    }
                });
            }
        }

        // 배열 생성
        int[] answer = new int[mailMap.size()];

        int index = 0;
        for (Integer integer : mailMap.values()) {
            answer[index++] = integer;
        }

        // 눈에 잘보이게..
        System.out.println("신고자 명단 : " + set);
        System.out.println("신고 카운트 : " + map);
        System.out.println("신고자 명단 : " + list);
        System.out.println("메일 발송 명단 : " + mailMap);
        System.out.println(mailMap.values());

        return answer;
    }
}

