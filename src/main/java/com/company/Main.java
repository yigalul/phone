package com.company;

public class Main {

    public static void main(String[] strings) {
	// write your code here
        String s = "00:01:07,400-234-090\r\n00:05:01,701-080-080\r\n00:05:00,400-234-090";
        Solution sol = new Solution();
        int i =  sol.solution(s);
        return;
    }
}
