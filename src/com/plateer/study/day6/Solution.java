package com.plateer.study.day6;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

// 주차 요금 계산 - https://school.programmers.co.kr/learn/courses/30/lessons/92341
public class Solution {
    public static void main(String[] args) {
/*
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
                "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
*/

        int[] fees = {120, 0, 60, 591};
        String[] records = {"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"};
/*
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
                "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
*/

        solution(fees, records);
    }
    public static int[] solution(int[] fees, String[] records) {
        List<Car> recordsList = Arrays.stream(records).map(x -> x.split(" ")).map(x -> new Car(x)).collect(Collectors.toList());
        recordsList.sort(Comparator.comparing(Car::getCarNumber));

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < recordsList.size(); i++) {
            if (i + 1 == recordsList.size()) {
                if (map.containsKey(recordsList.get(i).getCarNumber())) {
                    map.replace(recordsList.get(i).getCarNumber(), (int) (map.get(recordsList.get(i).getCarNumber()) + ChronoUnit.MINUTES.between(recordsList.get(i).getTime(), LocalTime.of(23, 59))));
                    break;
                } else {
                    map.put(recordsList.get(i).getCarNumber(), (int) ChronoUnit.MINUTES.between(recordsList.get(i).getTime(), LocalTime.of(23, 59)));
                    break;
                }
            }
            if ("IN".equals(recordsList.get(i).getGbn()) && "OUT".equals(recordsList.get(i + 1).getGbn())) {
                if (map.containsKey(recordsList.get(i).getCarNumber())) {
                    map.replace(recordsList.get(i).getCarNumber(), (int) (map.get(recordsList.get(i).getCarNumber()) + ChronoUnit.MINUTES.between(recordsList.get(i).getTime(), recordsList.get(i + 1).getTime())));
                } else {
                    map.put(recordsList.get(i).getCarNumber(), (int) ChronoUnit.MINUTES.between(recordsList.get(i).getTime(), recordsList.get(i + 1).getTime()));
                }
                i++;
            } else if ("IN".equals(recordsList.get(i).getGbn()) && "IN".equals(recordsList.get(i + 1).getGbn())) {
                if (map.containsKey(recordsList.get(i).getCarNumber())) {
                    map.replace(recordsList.get(i).getCarNumber(), (int) (map.get(recordsList.get(i).getCarNumber()) + ChronoUnit.MINUTES.between(recordsList.get(i).getTime(), LocalTime.of(23, 59))));
                } else {
                    map.put(recordsList.get(i).getCarNumber(), (int) ChronoUnit.MINUTES.between(recordsList.get(i).getTime(), LocalTime.of(23, 59)));
                }
            }
        }

        List<String> keyList = new ArrayList<>(map.keySet());
        keyList.sort(String::compareTo);

        List<Integer> valueList = new ArrayList<>();
        for (String key : keyList) {
            valueList.add(map.get(key));
        }

        int[] answer = new int[valueList.size()];


        for (int i = 0; i < valueList.size(); i++) {
            if (valueList.get(i) <= fees[0]) {
                answer[i] = fees[1];
            } else {
                int chargeTime = 0;
                if (((valueList.get(i) - fees[0]) % fees[2]) != 0) {
                    chargeTime = ((valueList.get(i) - fees[0] + fees[2]) / fees[2]);
                } else {
                    chargeTime = ((valueList.get(i) - fees[0]) / fees[2]);
                }
                answer[i] = fees[1] + (chargeTime * fees[3]);
            }
        }
        return answer;
    }


    public static class Car {
        private LocalTime time;
        private String carNumber;
        private String gbn;

        public Car(String[] records) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
            this.time = LocalTime.parse(records[0], dateTimeFormatter);
            this.carNumber = records[1];
            this.gbn = records[2];
        }

        public LocalTime getTime() {
            return time;
        }

        public String getGbn() {
            return gbn;
        }

        public String getCarNumber() {
            return this.carNumber;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "time=" + time +
                    ", carNumber=" + carNumber +
                    ", gbn='" + gbn + '\'' +
                    '}';
        }
    }
}



/**
 * 출차된 내역이 없으면 23:59분 출차로 간주
 * 00:00 부터 23:59 까지의 주차 시간으로 요금 정산
 * 누적 주차 시간이 기본 시간 이하라면 기본 요금
 * 누적 주차 시간이 기본 시간 초과하면 단위 시간마다 단위요금 + 기본 요금
 * 초과한 시간이 단위 시간으로 나뉘지 않으면, 올림
 * 차량 번호가 작은 자동차부터 청구할 주차 요금을 차례대로 정수 배열에 담아서 리턴
 */