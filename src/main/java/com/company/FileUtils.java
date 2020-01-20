package com.company;

import com.google.common.io.Resources;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FileUtils {

    public static String readFile() throws IOException {
        return readFile(null);
    }

    public static String readFile(String filePath) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        if (filePath == null) filePath = "C:\\Users\\caadmin\\Desktop\\details.txt";
        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            stringBuilder.append(st);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
