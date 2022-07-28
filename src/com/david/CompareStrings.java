package com.david;

import java.io.*;
import java.util.*;

/**
 * @author chenwz38
 * @Date: 2022/7/28
 * 比较两个字符串集
 */

public class CompareStrings {
    private  static final long serialVersionUID=1;
    public static void main(String[] args) throws IOException {
        String path = "D:\\java_test";
        String fileName_input = "input.txt";
        String fileName_input2 = "input2.txt";
        String fileName_output = "output.txt";
        File file_input = new File(path, fileName_input);
        File file_input2 = new File(path, fileName_input2);
        File file_output = new File(path, fileName_output);
        if (!file_input.exists()) {
            System.out.println("no input file!");
            return;
        }
        if (!file_input2.exists()) {
            System.out.println("no input2 file!");
            return;
        }
        if (!file_output.exists()) {
            file_output.createNewFile();
        }

        BufferedReader reader = new BufferedReader(new FileReader(file_input));
        BufferedReader reader2 = new BufferedReader(new FileReader(file_input2));
        String tempString = null;
        Set<String> set = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        while ((tempString = reader.readLine()) != null) {
            set.add(tempString.trim());

        }
        while ((tempString = reader2.readLine()) != null) {
            set2.add(tempString.trim());

        }
        reader.close();
        reader2.close();

        System.out.println("set.count:" + set.size() + "\nset2.count:" + set2.size());

        FileWriter fw = new FileWriter(file_output,true);

        fw.write("set - set2:\n");
        for (String temp:
             set) {
            if (!set2.contains(temp)) {
                fw.write(temp + "\n");
            }
        }
        fw.write("set2 - set:\n");
        for (String temp:
                set2) {
            if (!set.contains(temp)) {
                fw.write(temp + "\n");
            }
        }

        fw.close();
    }
}
