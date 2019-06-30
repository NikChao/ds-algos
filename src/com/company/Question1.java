package com.company;

import java.io.*;
import java.util.*;

public class Question1 {
    public int solution(String s) {
        final String lowercase = "abcdefghijklmnopqrstuvwxyz";
        final String upperCase = lowercase.toUpperCase();
        final String digits = "1234567890";

        int maxLen = -1;
        int currentRunStart = 0;
        int currentRunLength = 0;
        boolean isCurrentRunValid = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (digits.indexOf(c) >= 0) {
                isCurrentRunValid = false;
                currentRunLength = 0;
                continue;
            }
            if (upperCase.indexOf(c) >= 0) {
                isCurrentRunValid = true;
            }
            currentRunLength++;
            if (currentRunLength > maxLen && isCurrentRunValid) {
                maxLen = currentRunLength;
            }
        }

        return maxLen;
    }
}
