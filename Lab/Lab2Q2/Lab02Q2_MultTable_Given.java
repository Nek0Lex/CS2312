package Lab2Q2;

import java.util.Scanner;

public class Lab02Q2_MultTable_Given {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int width, height;
        System.out.print("Input the width of the multiplication table (2-10): ");
        width = input.nextInt();

        System.out.print("Input the height of the multiplication table (2-10): ");
        height = input.nextInt();

        for (int x = 0; x<height; x++){
            for (int y = 0; y<width; y++){
                System.out.printf("%5d", (x+1)*(y+1));
                System.out.print("|");
            }
            System.out.println();
        }



		/* Notes to students:
			1.  We need a Scanner object to get user input (like Lab01-Q1 Page 3):
			- Add the import statement at the beginning: import java.util.*;
			- Declare a scanner object: Scanner [object variable name];
			- Create a scanner object as: new Scanner(System.in);
			- To read an integer, we call the .nextInt() method: [scanner object].nextInt();
			- Close the scanner object: [scanner object].close();

	 		2.  Learn from Q1: System.out.printf("%5d", x); // Show x, "%" means a field,
								// right aligned, width=5,
								// d means decimal
		*/


    }
}
