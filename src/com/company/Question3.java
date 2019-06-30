package com.company;

import java.io.*;
import java.util.*;

public class Question3 {
    int solution(int[] A, int K) {
        int n = A.length;
        int best = 0;
        int count = 0;
        for (int i = 0; i < n - K - 1; i++) {
            if (A[i] == A[i + 1])
                count = count + 1;
            else
                count = 0;
            if (count > best)
                best = count;
        }
        int result = Math.min(best + 1 + K, A.length);

        return result;
    }
}
