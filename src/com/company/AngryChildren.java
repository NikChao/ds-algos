package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class AngryChildren {
    private int cost(int[] packs) {
        int cost = 0;
        for (int i : packs) {
            for (int j : packs) {
                cost += Math.abs(i - j);
            }
        }
        return cost/2;
    }
    public int angryChildren(int K, int[] packets) {
        // Complete this function
        Arrays.sort(packets);
        int ret = this.cost(Arrays.copyOfRange(packets, 0, K));

        int start = 1;
        for (int i = K+1; i <= packets.length; i++) {
            int temp = this.cost(Arrays.copyOfRange(packets, start, i));
            if (temp < ret) {
                ret = temp;
            }
            start++;
        }

        return ret;
    }

    public void test() {
        int[] comp = new int[]{
                angryChildren(3, new int[] { 10, 100, 300, 200, 1000, 20, 30 }),
                angryChildren(4, new int[] { 1, 2, 3, 4, 10, 20, 30, 40, 100, 200 }),
                angryChildren(1, new int[] { 1 }),
                angryChildren(2, new int[] { 2, 2, 10000 }),
                angryChildren(3, new int[] { 2, 2, 3, 10000 }),
                angryChildren(4, new int[] { 1, 2, 3, 4, 10, 20, 30, 40, 100, 200,
                        1000000, 1000000, 1000000, 1000000 })
        };

        int[] answ = new int[] {
                40,
                10,
                0,
                0,
                2,
                0
        };

        boolean bad = false;
        for (int i = 0; i < comp.length; i++) {
            if (answ[i] == comp[i]) continue;
            bad = true;
            System.out.printf("%d Failed, Expected: %d, Got: %d.\n", i, answ[i], comp[i]);
        }
        if (!bad) System.out.println("Passed tests.");
    }
}
