public class PalindromeCheckerApp {

    public static void main(String[] args) {
        String text = "madam";

        if (isPalindromeRecursive(text, 0, text.length() - 1)) {
            System.out.println("THE STRING \"" + text + "\" IS A PALINDROME");
        } else {
            System.out.println("THE STRING \"" + text + "\" IS NOT A PALINDROME");
        }
    }

    // Recursive function to check palindrome
    static boolean isPalindromeRecursive(String str, int start, int end) {
        // Base case: 0 or 1 character
        if (start >= end) {
            return true;
        }

        // Compare first and last characters
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call for substring
        return isPalindromeRecursive(str, start + 1, end - 1);
    }
}