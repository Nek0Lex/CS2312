package Lab4Q2;

import java.util.Scanner;

public class MainQ06countDigits {
    // Return the number of digits in integer x.
    static int countDigits(int x) {
        if (x < 10){
            return 1;
        }
        return countDigits(x/10)+1;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int x;
        System.out.print("input x (-1 to end) : ");
        x = s.nextInt();

        while (x != -1) {
            System.out.println(countDigits(x));
            System.out.print("input x (-1 to end) : ");
            x = s.nextInt();
        }

        s.close();
    }
}
