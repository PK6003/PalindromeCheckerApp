import java.util.Stack;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        String text = "madam";

        // Create PalindromeChecker object
        PalindromeChecker checker = new PalindromeChecker(text);

        // Check palindrome
        if (checker.checkPalindrome()) {
            System.out.println("THE STRING \"" + text + "\" IS A PALINDROME");
        } else {
            System.out.println("THE STRING \"" + text + "\" IS NOT A PALINDROME");
        }
    }
}

// PalindromeChecker class encapsulates palindrome logic
class PalindromeChecker {

    private String text;

    // Constructor
    public PalindromeChecker(String text) {
        this.text = text;
    }

    // Method to check palindrome using stack
    public boolean checkPalindrome() {
        Stack<Character> stack = new Stack<>();

        // Push characters to stack
        for (int i = 0; i < text.length(); i++) {
            stack.push(text.charAt(i));
        }

        // Compare popped characters with original
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}