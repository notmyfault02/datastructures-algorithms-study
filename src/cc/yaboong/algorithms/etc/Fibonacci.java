package cc.yaboong.algorithms.etc;

/**
 * Created by yaboong on 2018. 2. 6..
 */
public class Fibonacci {
    public static void main(String[] args) throws Exception {
        int N = 50;
        long[] memo = new long[N+1];

        Thread fibSimpleThread = new Thread(() -> {
            long startTime = System.currentTimeMillis();
            System.out.format("fibSimple: %d %n", fibSimple(N));
            System.out.format("fibSimple elapsed time: %d ms%n%n", (System.currentTimeMillis() - startTime));
        });

        Thread fibMemoizationThread = new Thread(() -> {
            long startTime = System.currentTimeMillis();
            System.out.format("fibMemoization: %d %n", fibMemoization(N, memo));
            System.out.format("fibMemoization elapsed time: %d ms%n%n", (System.currentTimeMillis() - startTime));
        });

        Thread fibBottomUpThread = new Thread(() -> {
            long startTime = System.currentTimeMillis();
            System.out.format("fibBottomUp: %d%n", fibBottomUp(N));
            System.out.format("fibBottomUp elapsed time: %d ms%n%n", (System.currentTimeMillis() - startTime));
        });

        fibSimpleThread.start();
        fibMemoizationThread.start();
        fibBottomUpThread.start();
    }

    private static long fibSimple(int n) {
        return (n < 2) ? n : fibSimple(n-1) + fibSimple(n-2);
    }

    private static long fibMemoization(int n, long[] memo) {
        if (memo[n] != 0) return memo[n];
        memo[n] = (n == 1 || n == 2) ? 1 : fibMemoization(n-1, memo) + fibMemoization(n-2, memo);
        return memo[n];
    }

    private static long fibBottomUp(int n) {
        long[] bottomUp = new long[n+1];
        bottomUp[1] = 1;
        bottomUp[2] = 1;
        for (int i=3; i<=n; i++)
            bottomUp[i] = bottomUp[i-1] + bottomUp[i-2];
        return bottomUp[n];
    }
}
