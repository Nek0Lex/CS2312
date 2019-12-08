package Lab6.Q2;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        ArrayList<Team> teamList = new ArrayList<>();
        Team t = null;
        String filepathname;

        System.out.print("Please input the file pathname of each team: ");
        String line = in.nextLine();
        Scanner scannerLine = new Scanner(line); //Create the scanner for input from the string: new Scanner(line);
        while (scannerLine.hasNext()) {
//            filepathname = in.nextLine();
            teamList.add(new Team(scannerLine.next()));//Still have contents or not: hasNext()
        }

//        System.out.printf(
//                "\nThere are %d members in the team: %s\n\n",
//                t.getMemberCount(), t.getStringOfAllMembers()); //call Team methods to get the results: getMemberCount, getStringOfAllMembers
        System.out.println("Listing of team:");
        for (int i=0; i < teamList.size(); i++){
            System.out.println("[Team "+(i+1)+"] "
                                + teamList.get(i).getMemberCount()
                                + " members: "
                                + teamList.get(i).getStringOfAllMembers());
        }


        System.out.print("Enter a name for searching: ");
        String searchName = in.next();
        Member result = null;
        String report = "Not found";
        System.out.print("Result: ");
        for (int i = 0; i < teamList.size(); i++) {
            result = teamList.get(i).findMember(searchName);
            if (result != null){
                report = result.getName() + " is " + result.getRoleDescription() + " in Team " + (i+1);
            }
        }
        System.out.println(report);

        in.close();
    }
}

///Users/moonnek0/Documents/CS2312_program/src/Lab6/m3.txt Users/moonnek0/Documents/CS2312_program/src/Lab6/m3a.txt Users/moonnek0/Documents/CS2312_program/src/Lab6/m3b.txt