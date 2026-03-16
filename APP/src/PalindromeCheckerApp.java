import java.util.Deque;
import java.util.LinkedList;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String text = "madam";
        Deque<Character> deque = new LinkedList<>();

        // Insert all characters into deque
        for (int i = 0; i < text.length(); i++) {
            deque.addLast(text.charAt(i));
        }

        boolean isPalindrome = true;

        // Compare front and rear characters
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                isPalindrome = false;
                break;
            }
        }

        // Print result
        if (isPalindrome) {
            System.out.println("THE STRING \"" + text + "\" IS A PALINDROME");
        } else {
            System.out.println("THE STRING \"" + text + "\" IS NOT A PALINDROME");
        }
    }
}