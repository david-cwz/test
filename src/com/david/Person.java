package com.david;

/**
 * @author chenwz38
 * @date 2020-05-26 15:25
 */
public class Person {
    private String name = "aa";

    public Person() {
        System.out.println("x");;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String args[]) {
        //Person p = new Person();
//        Object o = (Object) "dfsa";
//        Person p1 = (Person) o;

        System.out.println("a\nb");
        System.out.println("a\\nb");
    }
}