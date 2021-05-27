import java.util.*;

class CoinChange {
    private static int min = Integer.MAX_VALUE;
    public static int coinChange(int[] coins, int amount) {
        // idea: sort coins by ascending order, iterate from last to first index, add as much as possible of curr coin val
        // new idea: backtrack
        min = Integer.MAX_VALUE;
        if (coins == null || coins.length < 1) {
            return -1;
        }
        Arrays.sort(coins);
        backtrack(coins, amount, 0, 0);
        return min;
    }
    
    public static void backtrack(int[] coins, int amount, int numCoins, int index) {
        if (amount <= 0 || numCoins > min) {
            if (numCoins < min) {
                min = numCoins;
            }
            return;
        }
        for (int i = index; i < coins.length; i++) {
            backtrack(coins, amount-coins[i], numCoins+1, index+1);
        }
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2,5}, 11));   // 3
        System.out.println(coinChange(new int[]{2}, 3));    // -1
        System.out.println(coinChange(new int[]{1}, 0));    // 0
        System.out.println(coinChange(new int[]{1}, 1));   // 1
        System.out.println(coinChange(new int[]{1}, 2));    // 2

    }
}