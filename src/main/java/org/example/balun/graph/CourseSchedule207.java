package org.example.balun.graph;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule207 {



     public boolean hasCycle(int currCourseNum, int[] colors, List<List<Integer>> matrix) {
         if (colors[currCourseNum] == 1) {
             return true;
         }
         if (colors[currCourseNum] == 2) {
             return false;
         }

         colors[currCourseNum] = 1;

         List<Integer> courses = matrix.get(currCourseNum);

         for (Integer course : courses) {
             if (hasCycle(course, colors, matrix)) {
                 return true;
             }
         }
         colors[currCourseNum] = 2;
         return false;
     }

     public boolean canFinish(int numCourses, int[][] prerequisites) {
         List<List<Integer>> matrix = new ArrayList<>();

         for (int i = 0; i < numCourses; i++) {
             matrix.add(new ArrayList<>());
         }

         for (int[] prerequisite : prerequisites) {
             matrix.get(prerequisite[0]).add(prerequisite[1]);
         }
         int[] colors = new int[numCourses];

         for (int i = 0; i < numCourses; i++) {
             if (hasCycle(i, colors, matrix)) {
                 return false;
             }
         }
         return true;
     }

}
