import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        String text = "madam";

        // Use Stack-based strategy
        PalindromeStrategy stackStrategy = new StackStrategy();
        PalindromeService service1 = new PalindromeService(stackStrategy);
        System.out.println("Stack Strategy: " + text + " → " + (service1.isPalindrome(text) ? "Palindrome" : "Not Palindrome"));

        // Use Deque-based strategy
        PalindromeStrategy dequeStrategy = new DequeStrategy();
        PalindromeService service2 = new PalindromeService(dequeStrategy);
        System.out.println("Deque Strategy: " + text + " → " + (service2.isPalindrome(text) ? "Palindrome" : "Not Palindrome"));
    }
}

// Strategy interface
interface PalindromeStrategy {
    boolean check(String text);
}

// PalindromeService class uses a strategy
class PalindromeService {
    private PalindromeStrategy strategy;

    public PalindromeService(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean isPalindrome(String text) {
        return strategy.check(text);
    }
}

// Stack-based strategy
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String text) {
        Stack<Character> stack = new Stack<>();
        for (char ch : text.toCharArray()) {
            stack.push(ch);
        }
        for (char ch : text.toCharArray()) {
            if (ch != stack.pop()) return false;
        }
        return true;
    }
}

// Deque-based strategy
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String text) {
        Deque<Character> deque = new LinkedList<>();
        for (char ch : text.toCharArray()) {
            deque.addLast(ch);
        }
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }
}