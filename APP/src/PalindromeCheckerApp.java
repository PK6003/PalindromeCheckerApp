public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String text = "madam";

        // Convert string to character array
        char[] characters = text.toCharArray();

        int start = 0;
        int end = characters.length - 1;
        boolean isPalindrome = true;

        // Two-pointer comparison
        while (start < end) {
            if (characters[start] != characters[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        if (isPalindrome) {
            System.out.println("THE STRING \"" + text + "\" IS A PALINDROME");
        } else {
            System.out.println("THE STRING \"" + text + "\" IS NOT A PALINDROME");
        }
    }
}