package Lab2Q3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Table2dMxSumRowCol {
    //(1) Add the instance field, nums, for the 2D array here
    // (Answer is in Given_Code.txt!!)
    private int[][] nums;

    //Constructor
    public Table2dMxSumRowCol(String filepathname) throws FileNotFoundException //learn exceptions later
    {
        //Part I. Create the 2D array
        // (2) nums = ____________
        nums = new int[10][10];
        // (Answer is in Given_Code.txt!!)

        //Part II. Perform file reading and insert values into the 2D array
        Scanner inFile = new Scanner(System.in);
        inFile = new Scanner(new File(filepathname)); //(3) construct the scanner object for file reading
        // (Answer is in Given_Code.txt!!)
        //
        // (4) read the file until the end and add values
        // (Answer is in Given_Code.txt!!)
        while (inFile.hasNext()) //replace the blank with: inFile.hasNext()
        {
            int row, col, value;
            row = inFile.nextInt();
            col = inFile.nextInt();
            value = inFile.nextInt();
            nums[row][col] = value; //Note: should be [row][col], do not change the order
        }

        //
        //
        inFile.close();
    }

    //
    //Other methods
    public void print() {

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                System.out.print("\t" + nums[row][col]); //separated by tabs
            }
            System.out.println();
        }
    }

    public int getRowSumMax() {
        int max = 0;
        for (int row = 0; row < 10; row++) {
            int sum = 0;

            for (int col = 0; col < 10; col++) {
                sum += nums[row][col];
            }

            if (sum > max) {
                max = sum;
            }

        }

        return max;
    }
    //int maxArray = new int[];

    //        for (int x=0; x<10; x++){
//            for(int y=0; y<10; y++){
//
//            }
//        }
    public int getColSumMax() {
        //Your task: implement this method
        int max = 0;
        for (int col = 0; col < 10; col++) {
            int sum = 0;

            for (int row = 0; row < 10; row++) {
                sum += nums[row][col];
            }

            if (sum > max) {
                max = sum;
            }

        }

        return max;
    }

    public void getRowSumMaxNumber(){
        ArrayList rowSave = new ArrayList();
        int max = 0;
        for (int row = 0; row < 10; row++) {
            int sum = 0;

            for (int col = 0; col < 10; col++) {
                sum += nums[row][col];
            }

            if (sum > max) {
                max = sum;
                rowSave.add(row);
                }

    }

        System.out.print("Maximum row sum: "+ max + "(row ");
                for (int x=0; x<rowSave.size(); x++){
        System.out.print(rowSave.get(x));
                }
        System.out.println(" ) ");
    }


    //  (See Given_Code.txt!!)
}
