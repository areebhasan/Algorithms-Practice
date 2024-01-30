public class ReverseInteger {
    public static int reverse(int x) {
        int reversed = 0;

        while (x != 0) {
            // Extract the last digit of x
            int digit = x % 10;
            x /= 10;

            // Check for overflow before actually adding the digit
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7)) return 0;
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8)) return 0;

            // Add the digit to the reversed number
            reversed = reversed * 10 + digit;
        }

        return reversed;
    }

    public static void main(String[] args) {
        int input1 = 123;
        System.out.println(reverse(input1)); // Output: 321

        int input2 = -123;
        System.out.println(reverse(input2)); // Output: -321

        int input3 = 120;
        System.out.println(reverse(input3)); // Output: 21
    }
}
