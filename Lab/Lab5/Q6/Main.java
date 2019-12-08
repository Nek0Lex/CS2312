package Lab5.Q6;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        //Read input file pathname
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the filename: ");
        String filepathname = in.next();

        //Grab the StatisticsSystem ss and add counters
        StatisticsSystem ss = StatisticsSystem.getInstance();
        ss.addCounter(new Counter());
		in.nextLine(); // There is now a '\n' in the input stream, skip it: in.nextLine();
		System.out.print("\nEnter the area names (e.g. TaiPo YuenLong WongTaiSin KwunTong): ");
		String line = in.nextLine(); //Read a line: in.nextLine();
		Scanner scannerLine = new Scanner(line); //Create the scanner for input from the string: new Scanner(line);
		while (scannerLine.hasNext()) //Still have contents or not: hasNext()
			ss.addCounter(new AreaCounter(scannerLine.next())); //Area name is grabbed from the string: scannerLine.next()

//		System.out.print("\nEnter the age groups ('-1 -1' to end): ");
//		in.nextLine()
		int ageStart = 0, ageEnd = 0;
		while (ageStart != -1 || ageEnd != -1){
			System.out.print("Enter the age groups ('-1 -1' to end): ");
			ageStart = in.nextInt();
			ageEnd = in.nextInt();
			if (ageStart == -1 || ageEnd == -1){
				break;
			}
			ss.addCounter(new AgeGroupCounter(ageStart, ageEnd));
		}
		scannerLine.close();

        //TODO: Part (a)(ii), (b)

        //The ss will load file data and tell its counters to count
        ss.countData(filepathname);

        //The ss will tell its counters to report
        ss.report();

        in.close();
    }
}
