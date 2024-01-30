import java.util.Scanner;

class Solution3 {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 1) return "";

        boolean[][] dp = new boolean[n][n];
        int start = 0, maxLength = 1;

        // Initialize single characters as palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Check for two-character palindromes
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // Check for palindromes of length 3 and more
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    start = i;
                    maxLength = len;
                }
            }
        }

        // Return the longest palindromic substring
        return s.substring(start, start + maxLength);
    }
}

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input string
        System.out.println("Enter a string to find the longest palindromic substring:");
        String inputString = scanner.nextLine();

        // Create an instance of the Solution class and call the longestPalindrome method
        Solution3 solution = new Solution3();
        String longestPalindrome = solution.longestPalindrome(inputString);

        // Print the result
        System.out.println("The longest palindromic substring is: " + longestPalindrome);

        scanner.close();
    }
}
