package Lab2Q1;

public class Lab02Q1_Given {
    public static final int WIDTH = 12;
    public static final int HEIGHT = 8;

    /*
     * Given a 2D array of integers, count the values which are between 0 and 100 inclusive.
     * The size of the array is a WIDTH x HEIGHT. The array is passed as the parameter A.
     */
    public static void count_0_to_100(int[][] A)
    {
        int count = 0;

        for(int y=0; y<8; y++)
        {
            for (int x = 0; x < 12; x++){
                if (A[y][x] >= 0 && A[y][x] <= 100){
                    count++;
                }
            }

        }

        System.out.print("The count is: " + count);
    }

    public static void main(String[] args)
    {
        int[][] values = new int[8][12];
        int x, y;

        //create some data in values[][]
        for(y = 0 ; y < HEIGHT; y++){
            for(x = 0 ; x < WIDTH; x++) {
                values[y][x] = ((x + 13) * (y + 29)) % 413 - 139;
            }
        }


        //display contents in values[][]
        for(y = 0 ; y < HEIGHT; y++)
        {
            for(x = 0 ; x < WIDTH ; x++)
                System.out.printf("%5d", values[y][x]); //width = 5, right aligned
            System.out.println();
        }

        //call the function count_0_to_100 for counting(0...100)
        count_0_to_100(values);
    }
}
