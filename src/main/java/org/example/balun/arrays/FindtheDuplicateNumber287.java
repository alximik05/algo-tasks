package org.example.balun.arrays;

public class FindtheDuplicateNumber287 {

    /*
    * Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
Example 3:

Input: nums = [3,3,3,3,3]
Output: 3
    * */

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }

    static public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;

    }

    static public int findDuplicate2(int[] nums) {

        int expect = 0;
        for (int i = 0; i <= nums.length; i++) {
            expect += i;
        }

        int fact = 0;

        for (int i = 0; i < nums.length; i++) {
            fact += nums[i];
        }

        // 133 = 7 fact
        // 123 = 6 expect
        // 7 = 6 - 2 + 3
        // expect = fact + missed - dubl
        // expect^2 = fact^2 + missed^2 - dubl^2

        // missed = expect - fact + dubl


        // expect^2 = fact^2 + (expect - fact + dubl)^2 - dubl^2
//            36    =  49 + ( 36 - 49 + dubl )^2 - dubl^2

//        -13  =  ( dubl - 13 )^2 - dubl^2
//        -13 =  - 26 * dubl +169
        // 26dubl = 169 - 13
        // dubl = 6






        // dubl = (2 * expect * (missed + expect)) / (2 * (expect + missed))

        return  (int) ((Math.pow(expect, 2) - Math.pow(fact, 2) - Math.pow((expect - fact), 2)) / (2 * (expect - fact)));
    }
}
