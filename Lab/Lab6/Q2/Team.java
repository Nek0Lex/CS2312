package Lab6.Q2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Team {

    //Instance data field
    private ArrayList<Member> allMembers;

    //Constructor
    public Team(String filepathname) throws FileNotFoundException {
        Scanner inFile = new Scanner(new File(filepathname));

        int tot = inFile.nextInt(); //Read from file: nextInt();
        inFile.nextLine(); //skip line break after the count: inFile.nextLine();
        allMembers = new ArrayList<>(tot); //Create the array: new Member[tot];
        for (int i = 0; i < tot; i++) //loop how many times?
        {
            String name = inFile.next();
            char roleType = inFile.next().charAt(0); //Read a string of one character and get that character: inFile.next().charAt(0);
            Role r;
            if (roleType == 'l') {
                r = new RLeader();//create a RLeader role object: new RLeader();
            } else if (roleType == 'n') {
                r = new RNormalMember();
            } else {
                r = new RDisappeared();
            }

            allMembers.add(new Member(name, r));  // Create a member object: new ____________;
        }

        inFile.close(); //close the file
    }

    //Return total count of members (simply allMembers.length)
    public int getMemberCount() {
        return allMembers.size();
    }

    //Return a string of listing of all members
    public String getStringOfAllMembers() {
        String result = "";
        for (int i = 0; i < allMembers.size(); i++) //loop for each member
            result += allMembers.get(i).getNameAndRole() + " ";// allMembers[i].getName()+" ";
        result = result.trim(); //.trim() is for removing leading and trailing spaces
        return result;
    }

    //Display team contact messages
    public void printTeamContactMessages() {
        String allNames = getStringOfAllMembers(); //obtains a string like: "Helena Peter Mary Paul"
        for (int i = 0; i < allMembers.size(); i++) {
            String name_i = allMembers.get(i).getName(); //e.g. "Helena"
            System.out.print("Dear " + name_i + ",  ");
            String teammates = allMembers.get(i).getRole().genTeamContactMsg(this); // allMembers[i].getRole().genTeamContactMsg(this);
            System.out.println(teammates); // teammates
        }
    }

    public Member getLeader() {
        for (int i = 0; i < allMembers.size(); i++)
            if (allMembers.get(i).getRole() instanceof RLeader) {
                return allMembers.get(i); //checking:  allMembers[i].getRole() instanceof RLeader
            }
        return null;
    }

    public String getStringOfNormalMember() {
        String result = "";
        for (int i = 0; i < allMembers.size(); i++) {
            if (allMembers.get(i).getRole() instanceof RNormalMember) {
                result += allMembers.get(i).getNameAndRole() + " ";
            }
        }
        result = result.trim(); //.trim() is for removing leading and trailing spaces
        return result;
    }

    public Member findMember(String name) {
        for (Member allMember : allMembers) {
            if (allMember.getName().equals(name)) {
                return allMember;
            }
        }
        return null;
    }

    public void changeLeader(String newLeaderName) {
        for (Member member : allMembers) {
            if (member.getRole() instanceof RLeader) {
                member.setRole(new RNormalMember());
            }
        }
        findMember(newLeaderName).setRole(new RLeader());
    }

    public String findMemberWithTeamNumber(String name, ArrayList<Team> teamList) {
        for (int i = 0; i < teamList.size(); i++) {
            for (int j = 0; j < teamList.get(i).getMemberCount(); j++) {
                Member result = teamList.get(i).findMember(name);
                return result.getName() + " is " + result.getRoleDescription() + " in Team " + (i+1);
            }
        }

        return "Not found";
    }
}
