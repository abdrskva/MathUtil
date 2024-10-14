package org.example;

public class MathUtil {

    // Static Methods

    /**
     * Checks whether a given number n is prime.
     * @param n The number to check
     * @return true if the number is prime, otherwise false
     */
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    /**
     * Calculates the greatest common divisor (GCD) of two integers.
     * @param a The first integer
     * @param b The second integer
     * @return The GCD of a and b
     */
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    /**
     * Computes the least common multiple (LCM) of two numbers.
     * @param a The first integer
     * @param b The second integer
     * @return The LCM of a and b
     */
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    /**
     * Returns the nth Fibonacci number.
     * @param n The position in the Fibonacci sequence
     * @return The nth Fibonacci number
     */
    public static int fibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    /**
     * Calculates the factorial of a number n.
     * @param n The number to calculate the factorial for
     * @return The factorial of n
     */
    public static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Negative numbers do not have factorials.");
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Non-static Methods

    /**
     * Determines if the given number n is a perfect number.
     * @param n The number to check
     * @return true if the number is perfect, otherwise false
     */
    public boolean isPerfectNumber(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) sum += i;
        }
        return sum == n;
    }

    /**
     * Computes the sum of the digits of the given number n.
     * @param n The number to analyze
     * @return The sum of the digits of n
     */
    public int sumOfDigits(int n) {
        int sum = 0;
        n = Math.abs(n); // Handle negative numbers
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    /**
     * Reverses the digits of a number n.
     * @param n The number to reverse
     * @return The reversed number
     */
    public int reverseNumber(int n) {
        int reversed = 0;
        n = Math.abs(n); // Handle negative numbers
        while (n > 0) {
            reversed = reversed * 10 + n % 10;
            n /= 10;
        }
        return reversed;
    }

    /**
     * Checks if a number is an Armstrong number.
     * @param n The number to check
     * @return true if n is an Armstrong number, otherwise false
     */
    public boolean isArmstrongNumber(int n) {
        int original = n;
        int sum = 0;
        int digits = String.valueOf(n).length();
        while (n > 0) {
            int digit = n % 10;
            sum += (int) Math.pow(digit, digits);
            n /= 10;
        }
        return sum == original;
    }

    /**
     * Finds the smallest prime number greater than n.
     * @param n The number to check
     * @return The next prime number after n
     */
    public int nextPrime(int n) {
        do {
            n++;
        } while (!isPrime(n));
        return n;
    }

    public static void main(String[] args) {
        // Testing the static methods
        System.out.println("Is 7 prime? " + isPrime(7));
        System.out.println("GCD of 48 and 18: " + gcd(48, 18));
        System.out.println("LCM of 4 and 6: " + lcm(4, 6));
        System.out.println("Fibonacci of 5: " + fibonacci(5));
        System.out.println("Factorial of 5: " + factorial(5));

        // Testing the non-static methods
        MathUtil mathUtil = new MathUtil();
        System.out.println("Is 28 a perfect number? " + mathUtil.isPerfectNumber(28));
        System.out.println("Sum of digits in 12345: " + mathUtil.sumOfDigits(12345));
        System.out.println("Reverse of 123: " + mathUtil.reverseNumber(123));
        System.out.println("Is 153 an Armstrong number? " + mathUtil.isArmstrongNumber(153));
        System.out.println("Next prime after 10: " + mathUtil.nextPrime(10));
    }
}
