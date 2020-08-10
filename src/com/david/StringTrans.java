package com.david;

import java.io.*;
import java.util.*;

/**
 * @author chenwz38
 * @date 2019-10-31 09:46
 */
public class StringTrans {
    public static void main(String[] args) throws IOException {
        String path = "D:\\java_test";
        String fileName_input = "input.txt";
        String fileName_output = "output.txt";
        File file_input = new File(path, fileName_input);
        File file_output = new File(path, fileName_output);
        if (!file_input.exists()) {
            System.out.println("no input file!");
            return;
        }
        if (!file_input.exists()) {
            // 创建文件夹
            //myFile.mkdir();
            // myFile.mkdirs();

            //创建文件
            file_output.createNewFile();

            // 删除文件夹
            //myFile.delete();
        }

        // 第三种：以行为单位读取文件，常用于读面向行的格式化文件
        BufferedReader reader = new BufferedReader(new FileReader(file_input));
        String tempString = null;
        int line = 1;
        Set<String> set = new HashSet<>();

// 一次读入一行，直到读入null为文件结束
        while ((tempString = reader.readLine()) != null) {
            set.add(tempString.trim());
            // 显示行号
//            System.out.println("line " + line + ": " + tempString);
//            line++;
        }
        reader.close();
        List<String> list = new ArrayList<>();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            list.add(it.next());
        }
        int n = (int)Math.ceil(list.size() / 1000.0); //计数，每999个输出一个括号,第n段
        System.out.println(n);
        System.out.println(list.size());

        // 第二种：FileWriter(参数true为追加内容，若无则是覆盖内容)
        FileWriter fw = new FileWriter(file_output,true);
        for (int j = 1; j <= n; j++) {
            if (j < n) {
                fw.write("(");
                for (int i = 1000 * (j - 1); i < 1000 * j - 1; i++) {
                    fw.write("'" + list.get(i) + "',");
                }
                fw.write("'" + list.get(1000 * j - 1) + "')\n");
            } else {
                fw.write("(");
                for (int i = 1000 * (n - 1); i < list.size() - 1; i++) {
                    fw.write("'" + list.get(i) + "',");
                }
                fw.write("'" + list.get(list.size() - 1) + "')\n");
            }
        }
//        fw.write("(");
//        for (int i = 0; i < list.size() - 1; i++) {
//            fw.write("'" + list.get(i) + "',");
//        }
//        fw.write("'" + list.get(list.size() - 1) + "')\n");
        fw.close();
    }
}
