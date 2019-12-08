package Lab2Q3;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException //We will learn exceptions later
    {
        System.out.print("Please input the file pathname: ");

        Scanner scannerObj = new Scanner(System.in);
        String filePathName = scannerObj.nextLine();
        Table2dMxSumRowCol tableObj = new Table2dMxSumRowCol(filePathName);

        tableObj.print();

        //Your tasks:
        //  Create a new Table2dMxSumRowCol object and assign it to a variable of Table2dMxSumRowCol
        //      Call its constructor with the filePathName as argument
        //  Then apply the .print(), .getRowSumMax() and
        //      .getColSumMax() methods to finish the work.
        //

//        System.out.println("Maximum row sum: "+ tableObj.getRowSumMax());
        tableObj.getRowSumMaxNumber();

        System.out.println("Maximum col sum: "+ tableObj.getColSumMax());

        scannerObj.close();
    }
}
