package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] strings) throws IOException {
        String property = System.getProperty("file.path");
        String s = FileUtils.readFile(property);
        Solution sol = new Solution();
        int i =  sol.solution(s);
        return;
    }
}
