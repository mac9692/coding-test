package com.plateer.study.day6;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 입차", "06:00 0000 입차", "06:34 0000 출차", "07:59 5961 출차", "07:59 0148 입차",
                "18:59 0000 입차", "19:09 0148 출차", "22:59 5961 입차", "23:00 5961 출차"};
        solution(fees, records);
    }
    public static int[] solution(int[] fees, String[] records) {
        List<Car> recordsList = Arrays.stream(records).map(x -> x.split(" ")).map(x -> new Car(x)).collect(Collectors.toList());
        recordsList.sort(Comparator.comparing(Car::getCarNumber));
        recordsList.forEach(x-> System.out.println(x.toString()));

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < recordsList.size(); i++) {
            if ("입차".equals(recordsList.get(i).getGbn()) && "출차".equals(recordsList.get(i + 1).getGbn())) {
                if (map.containsKey(recordsList.get(i).getCarNumber())) {
                    map.replace(recordsList.get(i).getCarNumber(), (int) (map.get(recordsList.get(i).getCarNumber()) + ChronoUnit.MINUTES.between(recordsList.get(i).getTime(), recordsList.get(i + 1).getTime())));
                } else {
                    map.put(recordsList.get(i).getCarNumber(), (int) ChronoUnit.MINUTES.between(recordsList.get(i).getTime(), recordsList.get(i + 1).getTime()));
                }
                i++;
            } else if ("입차".equals(recordsList.get(i).getGbn()) && "입차".equals(recordsList.get(i + 1).getGbn())) {
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
            System.out.println("key : " + key + ", value : " + map.get(key));
            valueList.add(map.get(key));
        }

        int[] answer = new int[valueList.size()];

        for (int i = 0; i < valueList.size(); i++) {
            if (i <= fees[0]) {
                answer[i] = fees[1];
                break;
            } else {
                answer[i] = fees[1];
                while (i % fees[3] > 0) {
                    answer[i] += fees[4];
                    if (i % fees[3] < fees[4]) {
                        break;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(answer));
        return answer;
    }


    public static class Car {
        private LocalTime time;
        private String carNumber;
        private String gbn;
        private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");


        public Car(String[] records) {
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
                    ", dateTimeFormatter=" + dateTimeFormatter +
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