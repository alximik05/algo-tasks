package org.example.balun.twoPointers;

public class ValidPalindrome125 {
    public boolean isPalindrome(String s) {
        char[] charArray = s.toLowerCase().toCharArray();
        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            if (!Character.isLetterOrDigit(charArray[left])) {
                left++;
                continue;
            }

            if (!Character.isLetterOrDigit(charArray[right])) {
                right--;
                continue;
            }

            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
