package com.plateer.study.day1;

import java.util.ArrayList;
import java.util.List;

// 성격 유형 검사하기 - https://school.programmers.co.kr/learn/courses/30/lessons/118666
public class Solution {
    public static void main(String[] args) {
        String[] survey = {"TR", "RT", "TR"};
        int[] choices = {7, 1, 3};

        solution(survey, choices);
    }
    public static String solution(String[] survey, int[] choices) {
        List<KaKao> kaKaoList = new ArrayList<>();
        kaKaoList.add(new KaKao("R", 0, "T", 0));
        kaKaoList.add(new KaKao("C", 0, "F", 0));
        kaKaoList.add(new KaKao("J", 0, "M", 0));
        kaKaoList.add(new KaKao("A", 0, "N", 0));

        List<String[]> surveyList = new ArrayList<>();
        List<Integer> pointList = new ArrayList<>();

        System.out.println(surveyList);
        for (String s : survey) {
            surveyList.add(s.split(""));
        }

        for (int number : choices) {
            switch (number) {
                case 1: case 7:
                    pointList.add(3);
                    break;
                case 2: case 6:
                    pointList.add(2);
                    break;
                case 3: case 5:
                    pointList.add(1);
                    break;
                default:
                    pointList.add(0);
                    break;
            }
        }

        for (int index = 0; index < pointList.size(); index++) {
            if (choices[index] < 4) {
                for (KaKao kaKao : kaKaoList) {
                    if (kaKao.getPersonality().equals(surveyList.get(index)[0])) {
                        kaKao.setPersonalityPoint(kaKao.getPersonalityPoint() + pointList.get(index));
                    } else if (kaKao.getPersonality2().equals(surveyList.get(index)[0])) {
                        kaKao.setPersonalityPoint2(kaKao.getPersonalityPoint2() + pointList.get(index));
                    }
                }
            } else if (choices[index] > 4) {
                for (KaKao kaKao : kaKaoList) {
                    if (kaKao.getPersonality2().equals(surveyList.get(index)[1])) {
                        kaKao.setPersonalityPoint2(kaKao.getPersonalityPoint2() + pointList.get(index));
                    } else if (kaKao.getPersonality().equals(surveyList.get(index)[1])) {
                        kaKao.setPersonalityPoint(kaKao.getPersonalityPoint() + pointList.get(index));
                    }
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        kaKaoList.forEach(kaKao -> {
            if (kaKao.getPersonalityPoint() == kaKao.getPersonalityPoint2()) {
                if (kaKao.getPersonality().compareTo(kaKao.getPersonality2()) <= 0) {
                    stringBuilder.append(kaKao.getPersonality());
                } else {
                    stringBuilder.append(kaKao.getPersonality2());
                }
            } else if (kaKao.getPersonalityPoint() > kaKao.getPersonalityPoint2()) {
                stringBuilder.append(kaKao.getPersonality());
            } else {
                stringBuilder.append(kaKao.getPersonality2());
            }
        });
        String answer = stringBuilder.toString();
        return answer;
    }

    static class KaKao {
        private String personality;
        private int personalityPoint;
        private String personality2;
        private int personalityPoint2;

        public KaKao(String personality, int personalityPoint, String personality2, int personalityPoint2) {
            this.personality = personality;
            this.personalityPoint = personalityPoint;
            this.personality2 = personality2;
            this.personalityPoint2 = personalityPoint2;
        }

        public String getPersonality() {
            return personality;
        }

        public int getPersonalityPoint() {
            return personalityPoint;
        }

        public void setPersonalityPoint(int personalityPoint) {
            this.personalityPoint = personalityPoint;
        }

        public String getPersonality2() {
            return personality2;
        }

        public int getPersonalityPoint2() {
            return personalityPoint2;
        }

        public void setPersonalityPoint2(int personalityPoint2) {
            this.personalityPoint2 = personalityPoint2;
        }
    }
}

