package com.example.mylibrary;

public class Series {
    /**
     * Returns the sum of all numbers from 0 to n
     * The first 10 numbers are: 0, 1, 3, 6, 10, 15, 21, 28, 36, 45, 55
     *
     * @param n
     * @return
     */
    public static long nSum(int n) {
        return n * (n + 1) / 2;
    }


    /**
     * Returns the product of all numbers from 1 to n
     * 1 * 2 * 3 * 4 * ... * (n-1) * n
     * The first 10 factorials are: 0, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800
     *
     * @param n
     * @return
     */
    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }

        return fact;
    }

    /**
     * Returns the product of all numbers from 1 to n, using recursion
     * n! = (n-1) * n
     *
     * @param n
     * @return
     */
    public static long factorialRecursiv(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        return factorialRecursiv(n - 1) * n;
    }

    /**
     * Returns the nth Fibonacci number.
     * These are defined as: f(0) = 0; f(1) = 1; f(2) = 1; f(3) = 2; ... f(n) = f(n-1) + f(n-2)
     * The first 10 Series numbers are: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
     *
     * @param n
     */
    public static long fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        long fib = 0;

        long nMin1 = 1;
        long nMin2 = 0;

        for (int i = 1; i < n; i++) {
            fib = nMin1 + nMin2;

            //incrementing
            nMin2 = nMin1;
            nMin1 = fib;
        }

        return fib;

    }


}
