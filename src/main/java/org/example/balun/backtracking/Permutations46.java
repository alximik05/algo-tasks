package org.example.balun.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations46 {

    public static void main(String[] args) {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
        permute.forEach(System.out::println);
    }
    static public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> used = new HashSet<>(nums.length);
        startPermutation(new ArrayList<>(),nums, used, result);
        return result;
    }

    static private void startPermutation(List<Integer> currentPermut, int[] nums, Set<Integer> used, List<List<Integer>> result) {
        if (currentPermut.size() == nums.length) {
            result.add(new ArrayList<>(currentPermut));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used.contains(nums[i])) {
                continue;
            }
            used.add(nums[i]);
            currentPermut.add(nums[i]);
            startPermutation(currentPermut, nums, used, result);
            currentPermut.remove(currentPermut.size() - 1);
            used.remove(nums[i]);
        }
    }
}
