package com.khaja.otpreading;

public class InstanceTest {
    public static void main(String args[]) {
        System.out.println("Hashcode test of String:");
        String str = "java";
        System.out.println(str.length());
        str = str + "tpoint";
        System.out.println(str.length());

        System.out.println("Hashcode test of StringBuffer:");
        StringBuffer sb = new StringBuffer("java");
        System.out.println(sb.length());
        sb.append("tpoint");
        System.out.println(sb.length());
    }
}
