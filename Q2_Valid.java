import java.util.*;
import java.io.*;
public class Q2_Valid {
    public static int checkValid(String str) {
        Stack < Character > s = new Stack < Character > ();
        int l = str.length();
        for (int i = 0; i < l; i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                s.push(c);
            } else if (s.empty() == true) {
                return 0;
            } else if (checkMatch(s.peek(), c) == false) {
                return 0;
            } else {
                s.pop();
            }
        }
        if (s.empty() == true) {
            return 1;
        }
        return 0;
    }
    public static boolean checkMatch(char a, char b) {
        return ((a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}'));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your string for validation : ");
        String s = sc.next();
        int n = checkValid(s);
        if (n == 1) {
            System.out.println("\nValid");
        } else {
            System.out.println("\nInvalid");
        }
    }
}