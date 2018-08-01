import java.util.Stack;
import java.util.Scanner;
class PalindromeTest {

    public static void main(String[] args) {
        System.out.print("Enter any string:");
        Scanner input = new Scanner(System.in);
        String inputString = input.nextLine();
        Stack stack = new Stack();

        for (int i = 0; i < inputString.length(); i++) {
            stack.push(inputString.charAt(i));
        }

        String reverseString = "";
        while (!stack.isEmpty()) {
            reverseString = reverseString + stack.pop();
        }

        if (inputString.equals(reverseString))
            System.out.println("The input String is a palindrome.");
        else
            System.out.println("The input String is not a palindrome.");
    }
}