package com.jp.ds.dp;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {

        int[] c1 = {1,5,8,9};
        int amt1 = 4;
        System.out.println(coinChange(c1, amt1));

        int[] c2 = {1,4,8,9};
        int amt2 = 13;
        System.out.println(coinChange(c2, amt2));
    }

    public static int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount +1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for(int i=1; i <= amount; i++) {

            for(int coin: coins) {
                if(coin <= i) {
                    int subProblem = dp[i-coin];
                    if(subProblem != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], subProblem + 1);
                    }
                }
            }
        }
        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }
}
