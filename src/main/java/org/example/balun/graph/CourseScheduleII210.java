package org.example.balun.graph;

import java.util.ArrayList;
import java.util.List;

public class CourseScheduleII210 {

    boolean hasLoop(int curCourse, int[] colors, List<List<Integer>> matrix, List<Integer> orderList) {
        if (colors[curCourse] == 1) {
            return true;
        }

        if (colors[curCourse] == 2) {
            return false;
        }

        colors[curCourse] = 1;
        List<Integer> courses = matrix.get(curCourse);
        for (Integer course : courses) {
            if (hasLoop(course, colors, matrix, orderList)) {
                return true;
            }
        }
        orderList.add(curCourse);
        colors[curCourse] = 2;
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            matrix.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            matrix.get(prerequisite[0]).add(prerequisite[1]);
        }
        int[] colors = new int[numCourses];

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            boolean hasLoop = hasLoop(i, colors, matrix, result);
            if (hasLoop) {
                return new int[0];
            }

        }
        return result.stream().mapToInt(value -> value).toArray();
    }
}
