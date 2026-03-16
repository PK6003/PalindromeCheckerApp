import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String text = "madam";

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // Add characters to queue (FIFO) and stack (LIFO)
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            queue.add(ch);   // enqueue
            stack.push(ch);  // push
        }

        boolean isPalindrome = true;

        // Compare dequeue vs pop
        while (!queue.isEmpty()) {
            if (queue.remove() != stack.pop()) {
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