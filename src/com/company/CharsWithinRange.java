package com.company;

import java.util.*;

public class CharsWithinRange {

    public List<Character> charsWithinRange(String sentence, int range) {
        List<Character> chars = new ArrayList();
        HashMap<Character, List<Integer>> charSet = new HashMap();

        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for (char c : alphabet) {
            List<Integer> l = new ArrayList();

            for (int i = 0; i < sentence.length(); i++) {
                if (sentence.charAt(i) == c) {
                    l.add(i);
                }
            }
            charSet.put(c, l);
        }

        for (char key : charSet.keySet())
        {
            boolean charsWithinRange = false;
            List<Integer> l = charSet.get(key);
            for (int i = 0; i < l.size()-1; i++) {
                if (l.get(i+1) - l.get(i) <= range) {
                    charsWithinRange = true;
                }
            }

            if (charsWithinRange) {
                chars.add(key);
            }
        }

        return chars;
    }

}
