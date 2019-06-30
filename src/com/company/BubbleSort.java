package com.company;

public class BubbleSort {
    public void showMinimumBribe(int[] q) {
        int min = minimumBribe(q);
        if (min < 0) {
            System.out.println("Too chaotic");
            return;
        }
        System.out.println(min);
    }

    public int minimumBribe(int[] q) {
        int min = 0;
        int l = q.length;
        int[] swapCounts = new int[q.length];

        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 1; i < l; i++) {
                int first = q[i - 1];
                int second = q[i];
                if (second < first) {
                    q[i-1] = second;
                    q[i] = first;
                    swapCounts[q[i] - 1] += 1;
                    if (swapCounts[q[i] - 1] > 2) {
                        return -1;
                    }
                    swapped = true;
                    min++;
                }
            }
        }

        return min;
    }
}
