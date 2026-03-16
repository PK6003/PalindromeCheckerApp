import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        String text = "madam";

        // Stack-based strategy
        PalindromeStrategy stackStrategy = new StackStrategy();
        PalindromeService service1 = new PalindromeService(stackStrategy);

        long startTime1 = System.nanoTime();
        boolean result1 = service1.isPalindrome(text);
        long endTime1 = System.nanoTime();
        System.out.println("Stack Strategy: \"" + text + "\" → " + (result1 ? "Palindrome" : "Not Palindrome"));
        System.out.println("Execution Time: " + (endTime1 - startTime1) + " ns");

        // Deque-based strategy
        PalindromeStrategy dequeStrategy = new DequeStrategy();
        PalindromeService service2 = new PalindromeService(dequeStrategy);

        long startTime2 = System.nanoTime();
        boolean result2 = service2.isPalindrome(text);
        long endTime2 = System.nanoTime();
        System.out.println("Deque Strategy: \"" + text + "\" → " + (result2 ? "Palindrome" : "Not Palindrome"));
        System.out.println("Execution Time: " + (endTime2 - startTime2) + " ns");
    }
}

// Strategy interface
interface PalindromeStrategy {
    boolean check(String text);
}

// Service class uses a strategy
class PalindromeService {
    private PalindromeStrategy strategy;

    public PalindromeService(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean isPalindrome(String text) {
        return strategy.check(text);
    }
}

// Stack-based implementation
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

// Deque-based implementation
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