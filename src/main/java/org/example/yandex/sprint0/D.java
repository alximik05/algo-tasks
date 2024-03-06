package org.example.yandex.sprint0;

import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {

    // Если ответ существует, верните список из двух элементов
    // Если нет - то верните пустой список
    private static List<Integer> twoSum(List<Integer> arr, int targetSum) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            if (map.containsKey(arr.get(i))) {
                map.get(arr.get(i)).add(i);
            } else {
                map.put(arr.get(i), new ArrayList<>(Arrays.asList(i)));
            }
        }

        for (int i = 0; i < arr.size(); i++) {
            int complement = targetSum - arr.get(i);
            if (map.containsKey(complement)) {
                if (map.get(complement).get(0) == i && map.get(complement).size() == 1) {
                    continue;
                }
                return List.of(arr.get(i), complement);
            }
        }

        return new ArrayList<>();

        // Ваше решение
    }
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            List<Integer> arr = readList(reader);
            int targetSum = readInt(reader);
            List<Integer> result = twoSum(arr, targetSum);
            if (result.isEmpty()) {
                System.out.println("None");
            } else {
                System.out.println(result.get(0) + " " + result.get(1));
            }
        }
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return  Arrays.asList(reader.readLine().split(" "))
                .stream()
                .map(elem -> Integer.parseInt(elem))
                .collect(Collectors.toList());
    }

}
