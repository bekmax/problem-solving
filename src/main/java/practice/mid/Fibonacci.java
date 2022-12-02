package practice.mid;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(10));
    }

    public static int fibonacci(int n) {
        int[] fibonacci_numbers = new int[n + 1];
        fibonacci_numbers[0] = 1;
        fibonacci_numbers[1] = 1;
        for (int i = 2; i < fibonacci_numbers.length; i++) {
            fibonacci_numbers[i] = fibonacci_numbers[i - 1] + fibonacci_numbers[i - 2];
        }
        return fibonacci_numbers[n];
    }

}
