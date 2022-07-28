package com.david;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author chenwz38
 * @date 2019-12-24 09:43
 */
public class test implements Runnable{
    static boolean flag = true;
    public static void main(String[] args) {
//        test1();
        test2();
    }

    private static void test1() {
        Scanner input = new Scanner(System.in);
        System.out.println(input.next());
    }

    private static void test2() {
        byte a = 'c';
//        System.out.println(Integer.toBinaryString(a));
        String x = Integer.toHexString(a & 0xff) ;
        byte[] bytes = x.getBytes();
        for (byte b:bytes) {
            System.out.println(b + ": " + Integer.toBinaryString(b));
        }
//        System.out.println(x);
    }

    @Override
    public void run() {

    }
}


