public class PalindromeCheckerApp {
    static void main(String[] args) {
        String original = "madam";
        String reversed = "";

        for (int i = original.length() -1 ; i>=0 ; i--) {
            reversed = reversed + original.charAt(i);
        }

        if (original.equals(reversed)) {
            System.out.println("THE STRING\"" + original + "\" IS A PALINDROME");
        }else{
            System.out.println("THE STRING\"" + original + "\" IS NOT A PALINDROME");
        }

        System.out.println("Original: " + original);
        System.out.println("Reversed :" + reversed);

    }
}
