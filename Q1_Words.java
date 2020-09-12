//Q1- To find whether a given pattern exists in a given matrix or not.
import java.util.Scanner;
public class Q1_Words {
    public static boolean checkExist(char[][] matrix, String pattern) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean result = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (checkMatch(matrix, pattern, i, j, 0)) {
                    result = true;
                }
            }
        }

        return result;
    }

    public static boolean checkMatch(char[][] matrix, String pattern, int i, int j, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n) {
            return false;
        }

        if (matrix[i][j] == pattern.charAt(k)) {
            char temp = matrix[i][j];
            matrix[i][j] = '@';
            if (k == pattern.length() - 1) {
                return true;
            } else if (checkMatch(matrix, pattern, i - 1, j, k + 1) ||
                checkMatch(matrix, pattern, i + 1, j, k + 1) ||
                checkMatch(matrix, pattern, i, j - 1, k + 1) ||
                checkMatch(matrix, pattern, i, j + 1, k + 1)) {
                return true;
            }
            matrix[i][j] = temp;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n;
        System.out.println("Enter the number of rows for the matrix : ");
        n = sc.nextInt();
        System.out.println("Enter the number of columns for the matrix : ");
        m = sc.nextInt();
        char[][] ch = new char[n][m];
        System.out.println("Enter the matrix : - ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ch[i][j] = sc.next().charAt(0);
            }
        }
        System.out.print("\nEnter the pattern : ");
        String pattern = sc.next();
        if (checkExist(ch, pattern))
            System.out.print("\nYes, the given pattern exists in the provided matrix.\n");
        else
            System.out.print("\nNo, the given pattern does not exist in the provided matrix.\n");
    }
}