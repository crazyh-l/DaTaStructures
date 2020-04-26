package com.com.test;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {

        int[] nums = new int[]{3,2,4};
        int target = 6;
        calcIndex(nums,target);
    }


    public static void calcIndex (int[] nums ,int target) {

        int[] newNums = new int[2];

        for (int i = 0; i < nums.length; i++) {
          for (int j = i + 1; j < nums.length;j ++) {
              if (nums[i] + nums[j] == target) {
                  System.out.println( i + "--" + j);
              }
          }
        }
    }


    public boolean isValid(String s) {


        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char topChar = stack.pop();
                if (c == ')' && topChar != '(') {
                    return false;
                }
                if (c == ']' && topChar != '[') {
                    return false;
                }
                if (c =='}' && topChar != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }



}
