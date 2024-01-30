import java.util.Scanner;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        // Negative numbers or numbers ending in 0 (except 0 itself) are not palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        // Initialize the reversed half of the number
        int reversed = 0;

        // Build the reversed number for the second half
        while (x > reversed) {
            int lastDigit = x % 10;
            reversed = reversed * 10 + lastDigit;
            x /= 10;
        }

        // Check if the first half of the number matches the reversed second half
        // or its truncated version (for odd length numbers)
        return x == reversed || x == reversed / 10;
    }

    public static void main(String[] args) {
        PalindromeNumber sol = new PalindromeNumber();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an integer to check if it's a palindrome:");
        int number = scanner.nextInt();

        boolean isPalindrome = sol.isPalindrome(number);
        System.out.println("Is " + number + " a palindrome? " + isPalindrome);
        
        scanner.close();
    }
}
