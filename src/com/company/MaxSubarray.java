package com.company;

public class MaxSubarray {
    public int[] maxSubarray(int[] arr) {
        // Complete this function
        int currentRun = arr[0];
        int maxRun = arr[0];
        int maxNum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxNum) {
                maxNum = arr[i];
            }
            if (currentRun > maxRun) {
                maxRun = currentRun;
            }
            if (currentRun + arr[i] > 0) {
                currentRun += arr[i];
            } else {
                currentRun = 0;
            }
        }
        if (currentRun > maxRun) {
            maxRun = currentRun;
        }
        if (maxNum < 0) {
            maxRun = maxNum;
        }

        int maxSubSequence = 0;
        maxNum = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                maxSubSequence += arr[i];
            }
            if (arr[i] > maxNum) {
                maxNum = arr[i];
            }
        }
        if (maxNum < 0) {
            maxSubSequence = maxNum;
        }

        return new int[] { maxRun, maxSubSequence };
    }


    private boolean compare(int[] a, int[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public void test() {
        int[][] comp = new int[][] {
                maxSubarray(new int[] {1, 2, 3, 4}),
                maxSubarray(new int[] {2, -1, 2, 3, 4, -5}),
                maxSubarray(new int[] { 1 }),
                maxSubarray(new int[] { -10 }),
                maxSubarray(new int[] { -1, -2, -3, -4, -5, -6 }),
        };
        int[][] answ = new int[][] {
                new int[] { 10, 10 },
                new int[] { 10, 11 },
                new int[] { 1, 1 },
                new int[] { -10, -10 },
                new int[] { -1, -1 },
        };

        boolean bad = false;
        for (int i = 0; i < answ.length; i++) {
            if (!compare(answ[i], comp[i])) {
                System.out.printf("Test: %d: Expected: {%d %d}, Got: {%d %d}\n",
                        i, answ[i][0], answ[i][1], comp[i][0], comp[i][1]);
                bad = true;
            }
        }
        if (!bad) System.out.println("Tests passed.");
    }
}
