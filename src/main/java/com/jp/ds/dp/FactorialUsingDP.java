package com.jp.ds.dp;

public class FactorialUsingDP {

    public static void main(String[] args) {
        int n = 31;
        long millis = System.currentTimeMillis();
        System.out.println(factorial(n));
        System.out.println("Total time: "+(System.currentTimeMillis() - millis)+"ms");
    }

    public static int factorial(int n) {

        int[] dp = new int[n+1];

        dp[0] = 1;
        for(int i=1; i <= n; i++) {
            dp[i] = i * dp[i-1];
        }

        return dp[n];
    }
}
