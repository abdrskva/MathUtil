public class MathUtil {
  
    public static boolean isPrime(int n) {
        // Prime numbers are greater than 1
        if (n <= 1) return false;
        // Check for factors from 2 to the square root of n
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false; // Found a factor, not prime
        }
        return true; 
    }

    
    
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b; // Store b temporarily
            b = a % b; // Update b to a mod b
            a = temp; // Update a to the previous b
        }
        return a; // a now contains the GCD
    }

   
    public static int lcm(int a, int b) {
        // LCM can be calculated using the formula: |a * b| / GCD(a, b)
        return Math.abs(a * b) / gcd(a, b);
    }

   
    public static int fibonacci(int n) {
        if (n <= 0) return 0; // Fibonacci of 0
        if (n == 1) return 1; // Fibonacci of 1
        int a = 0, b = 1, c = 0; // Initialize the first two Fibonacci numbers
        for (int i = 2; i <= n; i++) {
            c = a + b; 
            a = b; 
            b = c; 
        }
        return c; 
    }

   
    public static long factorial(int n) {
        // Factorial is not defined for negative numbers
        if (n < 0) throw new IllegalArgumentException("Negative numbers do not have factorials.");
        long result = 1; // Start with 1 (0! = 1)
        // Multiply result by each integer up to n
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result; 
    }

    
    public boolean isPerfectNumber(int n) {
        int sum = 0; // Initialize sum of divisors
        // Check for divisors from 1 to n/2
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                sum += i; // Add divisor to sum
            }
        }
        return sum == n; 
    }

   
    public int sumOfDigits(int n) {
        int sum = 0; 
        while (n != 0) {
            sum += n % 10; // Add last digit to sum
            n /= 10; // Remove last digit
        }
        return sum; 
    }

  
    public int reverseNumber(int n) {
        int reversed = 0; // Initialize reversed number
        while (n != 0) {
            reversed = reversed * 10 + n % 10; // Append last digit
            n /= 10; 
        }
        return reversed;
    }

   
    public boolean isArmstrongNumber(int n) {
        int sum = 0; 
        int digits = String.valueOf(n).length(); 
        int temp = n;
        while (temp != 0) {
            int digit = temp % 10; 
            sum += Math.pow(digit, digits); // Raise to power of digits and add to sum
            temp /= 10; 
        }
        return sum == n; 
    }

  
    public int nextPrime(int n) {
        int next = n + 1; // Start checking from the next number
        while (!isPrime(next)) {
            next++;
        }
        return next; 
    }

   
    public static void main(String[] args) {
        System.out.println("Static Method Tests:");
        System.out.println("isPrime(7): " + MathUtil.isPrime(7)); 
        System.out.println("gcd(12, 15): " + MathUtil.gcd(12, 15)); 
        System.out.println("lcm(12, 15): " + MathUtil.lcm(12, 15)); 
        System.out.println("fibonacci(5): " + MathUtil.fibonacci(5)); 
        System.out.println("factorial(5): " + MathUtil.factorial(5)); 

       
        MathUtil mathUtil = new MathUtil();
        System.out.println("\nNon-Static Method Tests:");
        System.out.println("isPerfectNumber(28): " + mathUtil.isPerfectNumber(28)); 
        System.out.println("sumOfDigits(1234): " + mathUtil.sumOfDigits(1234)); 
        System.out.println("reverseNumber(1234): " + mathUtil.reverseNumber(1234)); 
        System.out.println("isArmstrongNumber(153): " + mathUtil.isArmstrongNumber(153)); 
        System.out.println("nextPrime(10): " + mathUtil.nextPrime(10)); 
    }
}
