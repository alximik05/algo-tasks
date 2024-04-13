package org.example.balun.intervals;

public class VideoStitching1024 {
    public static void main(String[] args) {

        int[][] clips = {{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}};
        System.out.println(videoStitching(clips, 10));
    }

    static public int videoStitching(int[][] clips, int time) {

        int currentMax = 0;
        int result = 0;

        while (currentMax < time) {
            int localMax = currentMax;

            for (int[] clip : clips) {
                if (clip[0] <= currentMax && localMax < clip[1]) {
                    localMax = clip[1];
                }
            }

            if (localMax == currentMax) {
                return -1;
            }

            currentMax = localMax;
            result++;

        }
        return result;
    }
}
