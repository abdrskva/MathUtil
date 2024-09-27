public class MathUtil {
    // Static Methods

    /**
     * Checks whether a given number n is prime.
     * @param n the number to check
     * @return true if the number is prime, otherwise false
     */
    public static boolean isPrime(int n) {
        // Prime numbers are greater than 1
        if (n <= 1) return false;
        // Check for factors from 2 to the square root of n
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false; // Found a factor, not prime
        }
        return true; // No factors found, n is prime
    }

    /**
     * Calculates the greatest common divisor (GCD) of two integers using the Euclidean algorithm.
     * @param a first integer
     * @param b second integer
     * @return the GCD of a and b
     */
    public static int gcd(int a, int b) {
        // Apply the Euclidean algorithm
        while (b != 0) {
            int temp = b; // Store b temporarily
            b = a % b; // Update b to a mod b
            a = temp; // Update a to the previous b
        }
        return a; // a now contains the GCD
    }

    /**
     * Computes the least common multiple (LCM) of two numbers.
     * @param a first integer
     * @param b second integer
     * @return the LCM of a and b
     */
    public static int lcm(int a, int b) {
        // LCM can be calculated using the formula: |a * b| / GCD(a, b)
        return Math.abs(a * b) / gcd(a, b);
    }

    /**
     * Returns the nth Fibonacci number.
     * @param n the position in the Fibonacci sequence
     * @return the nth Fibonacci number
     */
    public static int fibonacci(int n) {
        if (n <= 0) return 0; // Fibonacci of 0
        if (n == 1) return 1; // Fibonacci of 1
        int a = 0, b = 1, c = 0; // Initialize the first two Fibonacci numbers
        // Loop to calculate the Fibonacci number at position n
        for (int i = 2; i <= n; i++) {
            c = a + b; // Current Fibonacci number
            a = b; // Update for next iteration
            b = c; // Update for next iteration
        }
        return c; // Return the nth Fibonacci number
    }

    /**
     * Calculates the factorial of a number n.
     * @param n the number to calculate the factorial for
     * @return the factorial of n
     */
    public static long factorial(int n) {
        // Factorial is not defined for negative numbers
        if (n < 0) throw new IllegalArgumentException("Negative numbers do not have factorials.");
        long result = 1; // Start with 1 (0! = 1)
        // Multiply result by each integer up to n
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result; // Return the factorial of n
    }

    // Non-Static Methods

    /**
     * Determines if the given number n is a perfect number.
     * A perfect number is equal to the sum of its proper divisors.
     * @param n the number to check
     * @return true if the number is perfect, otherwise false
     */
    public boolean isPerfectNumber(int n) {
        int sum = 0; // Initialize sum of divisors
        // Check for divisors from 1 to n/2
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                sum += i; // Add divisor to sum
            }
        }
        return sum == n; // Check if sum of divisors equals n
    }

    /**
     * Computes the sum of the digits of the given number n.
     * @param n the number to sum the digits of
     * @return the sum of the digits of n
     */
    public int sumOfDigits(int n) {
        int sum = 0; // Initialize sum of digits
        // Loop to extract each digit
        while (n != 0) {
            sum += n % 10; // Add last digit to sum
            n /= 10; // Remove last digit
        }
        return sum; // Return the total sum of digits
    }

    /**
     * Reverses the digits of a number n.
     * @param n the number to reverse
     * @return the number formed by reversing the digits of n
     */
    public int reverseNumber(int n) {
        int reversed = 0; // Initialize reversed number
        // Loop to reverse the digits
        while (n != 0) {
            reversed = reversed * 10 + n % 10; // Append last digit
            n /= 10; // Remove last digit
        }
        return reversed; // Return the reversed number
    }

    /**
     * Checks if a number is an Armstrong number.
     * An Armstrong number is equal to the sum of its digits raised to the power of the number of digits.
     * @param n the number to check
     * @return true if n is an Armstrong number, otherwise false
     */
    public boolean isArmstrongNumber(int n) {
        int sum = 0; // Initialize sum of powered digits
        int digits = String.valueOf(n).length(); // Count the number of digits
        int temp = n; // Store original number for later use
        // Loop to calculate the sum of powered digits
        while (temp != 0) {
            int digit = temp % 10; // Extract last digit
            sum += Math.pow(digit, digits); // Raise to power of digits and add to sum
            temp /= 10; // Remove last digit
        }
        return sum == n; // Check if sum equals original number
    }

    /**
     * Finds the smallest prime number greater than n.
     * @param n the number to start checking from
     * @return the next prime number after n
     */
    public int nextPrime(int n) {
        int next = n + 1; // Start checking from the next number
        // Keep incrementing until a prime number is found
        while (!isPrime(next)) {
            next++;
        }
        return next; // Return the next prime number
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        // Testing static methods
        System.out.println("Static Method Tests:");
        System.out.println("isPrime(7): " + MathUtil.isPrime(7)); // Expected: true
        System.out.println("gcd(12, 15): " + MathUtil.gcd(12, 15)); // Expected: 3
        System.out.println("lcm(12, 15): " + MathUtil.lcm(12, 15)); // Expected: 60
        System.out.println("fibonacci(5): " + MathUtil.fibonacci(5)); // Expected: 5
        System.out.println("factorial(5): " + MathUtil.factorial(5)); // Expected: 120

        // Testing non-static methods
        MathUtil mathUtil = new MathUtil();
        System.out.println("\nNon-Static Method Tests:");
        System.out.println("isPerfectNumber(28): " + mathUtil.isPerfectNumber(28)); // Expected: true
        System.out.println("sumOfDigits(1234): " + mathUtil.sumOfDigits(1234)); // Expected: 10
        System.out.println("reverseNumber(1234): " + mathUtil.reverseNumber(1234)); // Expected: 4321
        System.out.println("isArmstrongNumber(153): " + mathUtil.isArmstrongNumber(153)); // Expected: true
        System.out.println("nextPrime(10): " + mathUtil.nextPrime(10)); // Expected: 11
    }
}
