import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n= Integer.parseInt(scan.nextLine());

        printRow(n);
    }

    private static void printRow(int n) {
        for (int row = 0; row <n ; row++) {
            printUpper(row,n);
        }
        for (int row = 0; row <n-1 ; row++) {
            printBottom(row,n);
        }

    }

    private static void printBottom(int row, int n) {
        for (int i = 0; i <=row ; i++) {
            System.out.print(" ");
        }
        for (int i = row; i <n-1 ; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }

    private static void printUpper(int row,int n) {
        for (int i = row; i <n-1 ; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i <=row ; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}
