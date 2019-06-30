package com.company;

public class ProductArray {
    public int[] productArray(int[] arr) {
        int len = arr.length;
        int[] cpy = new int[len];
        int prod = 1;
        for (int i = 0; i < len; i++)
            prod *= arr[i];
        for (int i = 0; i < len; i++)
            cpy[i] = prod;
        for (int i = 0; i < len; i++) {
            if (arr[i] == 0) {
                int prdTmp = 1;
                for (int j = 0; j < len; j++) {
                    if (i == j) continue;
                    prdTmp *= arr[j];
                    cpy[i] = prdTmp;
                }
            } else {
                cpy[i] = cpy[i] / arr[i];
            }
        }

        return cpy;
    }

    private boolean comp(int[] a, int[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++)
            if (a[i] != b[i])
                return false;
        return true;
    }

    public void test() {
        int[][] comp = new int[][] {
                productArray(new int[] { 1, 2, 3, 4 }),
                productArray(new int[] { 5, 2, 1, 4}),
                productArray(new int[] { 10, 1, 3, 5 }),
                productArray(new int[] { 10, 1, 0, 5 }),
                productArray(new int[] { 0, 0, 0, 0, 0 }),
        };
        int[][] answ = new int[][] {
                new int[] {24, 12, 8, 6},
                new int[] {8, 20, 40, 10},
                new int[] {15, 150, 50, 30},
                new int[] {0, 0, 50, 0},
                new int[] { 0, 0, 0, 0, 0 }
        };

        boolean bad = false;
        for (int i = 0; i < comp.length; i++ ){
            if (comp(comp[i], answ[i])) continue;
            System.out.println(i);
            bad = true;
        }
        if (!bad) System.out.println("Tests passed.");
    }
}
