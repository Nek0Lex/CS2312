

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /*===================================
    The main() Method
===================================*/

    public static void main(String [] args) throws FileNotFoundException
    {
        System.out.print("Please input the file pathname: ");
        Scanner in = new Scanner(System.in);
        String filepathname = in.nextLine();

        Student[] students; //Define an array of students: Student[] students;
        students = Student.createStudentListFromFile(filepathname); //Call the given static method in the Student class for reading from file: Student.createStudentListFromFile(filepathname);

        System.out.println("Total number of students: "+students.length);
        System.out.print("Enter the number of teams: ");
        int numOfTeams = in.nextInt();

        Team[] teams = new Team[numOfTeams];
        if (students.length % numOfTeams == 0){
            teams = createTeams(students, numOfTeams);
        } else {
            System.out.println("Wrong input - It is not a factor of "+students.length+".");
            System.exit(0);
        }

        //Print the grouping result:
        System.out.println("\nGrouping result: ");
        for (int i=0; i<teams.length; i++){
            System.out.println(teams[i].toString());
        }

        //Create the assignments
        System.out.println();
        System.out.print("Enter "+numOfTeams+" task names (eg. \"Lab05 Lab06 Lab07 ..\"): ");
        String taskNamesList[] = new String[numOfTeams];
        for (int i=0; i<numOfTeams; i++){
            taskNamesList[i] = in.next();
        }
        //Lab02 Lab04 Lab05 Lab07 Lab08 Lab09 Lab11 Lab12

        Assignment[] assignments; //Define an array of assignments: Assignment[] assignments
        assignments = decideTasks(teams, in, taskNamesList);//Call the private method (one of the 3 methods in Main.java) to input the tasks for each team: decideTasks(teams, in);

        //Display sorted listing by tasks:
        System.out.println("\nSorted listing by tasks: ");
        for (int i=0; i<assignments.length; i++){
            Assignment.printTaskTeam(taskNamesList[i] , assignments);
        }

        in.close();
    }

/*===================================
    The createTeams() Method
===================================*/

    //Create the teams from the students array: students[0..5] go to team A, students[6..11] go to team B, etc..
    private static Team[] createTeams(Student[] students, int numOfTeams)
    {
        Team[] result; //Define an array of teams to store the result: Team[] result;
        result = new Team[numOfTeams]; //Create the array: new Team[5];
        int numOfTeamMember = students.length/numOfTeams;

        char teamLetter;
        int start =0 , end=numOfTeamMember;
        for (int i=0; i<numOfTeams; i++){
            teamLetter = (char)('A'+i);
            result[i] = new Team("Team "+teamLetter, Arrays.copyOfRange(students, start, end));
            start = end;
            end += numOfTeamMember;
        }

        return  result; //Return the result: return result;
    }

/*===================================
    The decideTasks() Method
=================================== */

    //assignment of lab tasks to teams based on user input
    private static Assignment[] decideTasks(Team[] teams, Scanner in, String[] taskNameList)
    {
        Assignment[] assignments; //Define an array of assignments to store the result: Assignment[] assignments;
        assignments = new Assignment[taskNameList.length]; //Create the array: new Assignment[5];

        System.out.print("\nEnter tasks for the teams (");
        for (int j=0; j<taskNameList.length; j++){
            System.out.print(taskNameList[j]);
            if (j != taskNameList.length-1){
                System.out.print(",");
            }
        }
        System.out.println("): ");

        for (int i=0; i<teams.length; i++)
        {
            System.out.print(teams[i].getName()+ ": "); //Prompt for a team: teams[i].getName()
            String taskName = in.next(); //Get user input of the task name from keyboard: in.next();
            assignments[i] = new Assignment(teams[i], new Task(taskName)); //Create the assignment for:  teams[i], new Task(taskName)
        }
        return  assignments; //Return the result: return assignments;
    }

}
