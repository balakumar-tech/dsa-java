package com.jp.ds.recursion;

public class FibanocciR {

    public static void main(String[] args) {
        int n = 6;
        System.out.println(fibannoci(n));
    }

    public static int fibannoci(int n) {

        if(n <= 1) {
            return n;
        }

        return fibannoci(n -1) + fibannoci(n - 2);
    }
}
