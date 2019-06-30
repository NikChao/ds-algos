package com.company;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.io.*;
import java.util.*;

public class Question2 {
    public int solution(int[] A, int[] B, int M, int X, int Y) {
        int stops = 0;

        int i = 0;
        HashMap<Integer, Boolean> currentTripMap = new HashMap<>();
        while (i < A.length) {

            currentTripMap = new HashMap<>();
            int currentTripWeight = 0;
            int currentTripHeadcount = 0;

            while(currentTripHeadcount < X && currentTripWeight < Y) {
                int nextWeight = A[i];
                int nextDest = B[i];

                if (currentTripWeight + nextWeight > Y) {
                    break;
                }

                currentTripWeight += nextWeight;
                currentTripHeadcount++;

                if (!currentTripMap.getOrDefault(nextDest, false)) {
                    currentTripMap.put(nextDest, true);
                }
                if (i == A.length - 1) {
                    break;
                }
                i++;
            }

            stops += currentTripMap.size() + 1;
            if (i == A.length - 1) {
                break;
            } else {
                i++;
            }
        }
        stops += currentTripMap.size();
        return stops;
    }
}
