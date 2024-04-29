package org.example.balun.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class LineReflection356 {

    public static void main(String[] args) {
//        isReflected(new int[][]{{1,1},{2,2},{3,3}});
        System.out.println(isReflected(new int[][]{{1, 1}, {-1, 1}})); //true
        System.out.println(isReflected(new int[][]{{1, 1}, {-1, -1}})); // false
    }
    static public boolean isReflected(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        for (int i = 0; i < points.length; i++) {
            int[] coord = points[i];
            if (map.containsKey(coord[0])) {
                map.get(coord[0]).add(coord[1]);
            } else {
                map.put(coord[0], new HashSet<>(Set.of(coord[1])));
            }
            if (minX > coord[0]) {
                minX = coord[0];
            }
            if (maxX < coord[0]) {
                maxX = coord[0];
            }
        }

        if ((minX + maxX) % 2 != 0) {
            return false;
        }
        int lineX = (minX + maxX) / 2;

        for (Map.Entry<Integer, Set<Integer>> xy : map.entrySet()) {
            Integer x = xy.getKey();
            int reflectedX = lineX + lineX - x;
            if (!Objects.equals(xy.getValue(), map.get(reflectedX))) {
                return false;
            }

        }

        return true;
    }
}
