package com.plateer.study.day16;

import java.util.ArrayList;
import java.util.List;

// 햄버거 만들기 - https://school.programmers.co.kr/learn/courses/30/lessons/133502/solution_groups?language=java&type=my
public class SolutionTwo {
    public static void main(String[] args) {
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
//        int[] ingredient = {1, 3, 2, 1, 2, 1, 3, 1, 2};
        solution(ingredient);
    }
    public static int solution(int[] ingredient) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : ingredient) {
            stringBuilder.append(i);
        }
        String s = stringBuilder.toString();
        int answer = 0;

        while (s.contains("1231")) {
            s = s.replaceFirst("1231", "");
            answer++;
        }
        return answer;
    }

    public static int solution2(int[] ingredient) {
        List<Integer> ingredientList = new ArrayList<>();
        List<Integer> burgerList = new ArrayList<>();
        burgerList.add(1);
        burgerList.add(2);
        burgerList.add(3);
        burgerList.add(1);

        int answer = 0;

        for (int i = 0; i < ingredient.length; i++) {
            ingredientList.add(ingredient[i]);

            if (ingredientList.size() >= 4) {
                List<Integer> tempList = new ArrayList<>();
                tempList.add(ingredientList.get(ingredientList.size() - 4));
                tempList.add(ingredientList.get(ingredientList.size() - 3));
                tempList.add(ingredientList.get(ingredientList.size() - 2));
                tempList.add(ingredientList.get(ingredientList.size() - 1));

                if (tempList.equals(burgerList)) {
                    answer++;
                    ingredientList.remove(ingredientList.size() - 1);
                    ingredientList.remove(ingredientList.size() - 1);
                    ingredientList.remove(ingredientList.size() - 1);
                    ingredientList.remove(ingredientList.size() - 1);
                }
            }
        }

        return answer;
    }
}
