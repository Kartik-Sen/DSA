public class Fibonacci {
    // Function to print N Fibonacci Number
    static void fibonacciSeries(int N)
    {
        int n1 = 0, n2 = 1;

        for (int i = 0; i < N; i++) {
            // Print the number
            System.out.print(n1 + " ");

            // Swap
            int n3 = n2 + n1;
            n1 = n2;
            n2 = n3;
        }
    }

    public static void main(String args[])
    {
        // Given Number N
        int N = 10;

        // Function Call
        fibonacciSeries(N);
    }
}
