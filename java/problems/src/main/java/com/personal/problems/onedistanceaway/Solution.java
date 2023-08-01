package com.personal.problems.onedistanceaway;

class Solution {
    // Funcion to check if the string u is subsequence of v , u << v
    boolean subsequence(String u, String v) {
        if (u.isEmpty()) return true;
        int i = 0;
        int j = 0;
        for (; i < u.length() && j < v.length(); j++) {
            if (u.charAt(i) == v.charAt(j)) {
                i++;
            }
        }
        return i == u.length();
    }

    boolean oneReplacement(String u, String v) {
        int dif = 0;
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) != v.charAt(i)) {
                dif++;
            }
        }
        return dif == 1;
    }

    public boolean isOneEditDistance(String s, String t) {
        if (s.length() + 1 == t.length()) {
            return subsequence(s, t);
        } else if (s.length() == t.length() + 1) {
            return subsequence(t, s);
        } else if (s.length() == t.length()) {
            return oneReplacement(s, t);
        } else {
            return false;
        }
    }
}
