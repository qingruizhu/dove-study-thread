package com.dove.thread.t9;

import java.util.HashSet;

/**
 * @Description:
 * @Auther: qingruizhu
 * @Date: 2020/6/11 18:19
 */
public class Solution {

    public static void main(String[] args) {
        String ss = "abcdefd";
        boolean test = test(ss);

        System.out.println(test);
    }

    public static boolean test(String astr) {
        char[] chars = astr.toCharArray();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            set.add(chars[i]);
        }
        return chars.length == set.size();
    }
}
