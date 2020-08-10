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
            // �����ļ���
            //myFile.mkdir();
            // myFile.mkdirs();

            //�����ļ�
            file_output.createNewFile();

            // ɾ���ļ���
            //myFile.delete();
        }

        // �����֣�����Ϊ��λ��ȡ�ļ��������ڶ������еĸ�ʽ���ļ�
        BufferedReader reader = new BufferedReader(new FileReader(file_input));
        String tempString = null;
        int line = 1;
        Set<String> set = new HashSet<>();

// һ�ζ���һ�У�ֱ������nullΪ�ļ�����
        while ((tempString = reader.readLine()) != null) {
            set.add(tempString.trim());
            // ��ʾ�к�
//            System.out.println("line " + line + ": " + tempString);
//            line++;
        }
        reader.close();
        List<String> list = new ArrayList<>();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            list.add(it.next());
        }
        int n = (int)Math.ceil(list.size() / 1000.0); //������ÿ999�����һ������,��n��
        System.out.println(n);
        System.out.println(list.size());

        // �ڶ��֣�FileWriter(����trueΪ׷�����ݣ��������Ǹ�������)
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
