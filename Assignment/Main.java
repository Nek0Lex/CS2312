import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);

        System.out.print("Please input the file pathname: ");
        String filepathname = in.nextLine();

        Scanner inFile = new Scanner(new File(filepathname));

        //The first command in the file must be to set the system date
        //(eg. "startNewDay 03-Jan-2018"); and it cannot be undone
        String cmdLine1 = inFile.nextLine();
        String[] cmdLine1Parts = cmdLine1.split("\\|"); //Split by vertical bar character '|' (Regular expression: "\|")
        System.out.println("\n> "+cmdLine1);
        SystemDate.createTheInstance(cmdLine1Parts[1]);

        while (inFile.hasNext())
        {
            String cmdLine = inFile.nextLine().trim();

            //Blank lines exist in data file as separators.  Skip them.
            if (cmdLine.equals("")) continue;

            System.out.println("\n> "+cmdLine);

            //split the words in actionLine => create an array of word strings
            String[] cmdParts = cmdLine.split("\\|");

            if (cmdParts[0].equals("request"))
                (new CmdRequest()).execute(cmdParts);
            if (cmdParts[0].equals("listReservations"))
                (new CmdListReservations()).execute(cmdParts);
            if (cmdParts[0].equals("startNewDay"))
                (new CmdStartNewDay()).execute(cmdParts);
            if (cmdParts[0].equals("undo"))
                RecordedCommand.undoOneCommand();
            if (cmdParts[0].equals("redo"))
                RecordedCommand.redoOneCommand();
        }
        inFile.close();

        in.close();
    }
}
