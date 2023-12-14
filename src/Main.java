import java.lang.Math;
import java.util.Scanner;
import java.util.Random;

class Main
{

    public static int honorsClasses = 0;
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);

        //introduction
        System.out.println("\n********************!!!HIGH SCHOOL SIMULATOR!!!********************");
        System.out.println("You are a student at View Valley High School and is tasked with completing the A-G requirements in order to graduate with a GPA of 3.0 or more \n\nWhat is your first name?");
        String firstName = kb.nextLine();

        System.out.println("\nWhat is your last name?");
        String lastName = kb.nextLine();

        System.out.println("\n" + firstName + " " + lastName + ", Can you graduate?(yes/no)");
        //gets response
        String response = kb.nextLine();

        // gets straight into the years
        if(response.equalsIgnoreCase("yes"))
        {
            System.out.println("Perfect!");
            freshmanYear();
            sophomoreYear();
            juniorYear();
            seniorYear();
        }
        //gets straight into the years
        else if(response.equalsIgnoreCase("no"))
        {
            System.out.println("\nToo bad :( You don't have a choice");
            freshmanYear();
            sophomoreYear();
            juniorYear();
            seniorYear();
        }
        //makes sure the user inputs a valid response
        else
        {
            checkResponse();
            //then goes straight into the years
            freshmanYear();
            sophomoreYear();
            juniorYear();
            seniorYear();
        }


        //random names for random students
        String firstNames[] = {"Bob", "Joe", "Bill", "Jill", "Sue", "Kim", "Julien", "Eric", "Jeff", "Jerry", "Benjamin", "Adrian", "Aaron", "Austin"};

        String lastNames[] = {"Dominguez", "Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Rodriguez", "Martinez", "Hernandez", "Lopez", "Gonzalez"};

        double generator1 = Math.random();
        double generator2 = Math.random();
        double generator3 = Math.random();


        //generates random names for two different students
        int firstNameIndex2 = (int)(generator2 * firstNames.length);
        int lastNameIndex2 = (int)(generator2 * lastNames.length);

        int firstNameIndex3 = (int)(generator3 * firstNames.length);
        int lastNameIndex3 = (int)(generator3 * lastNames.length);


        //generates random GPA for all three students
        double userGpa = (generator1 * 3.5) + 1;
        double gpa2 = (generator2 * 3.5) + 1;
        double gpa3 = (generator3 * 3.5) + 1;


        //converts the gpas'(doubles) into strings and formats them properly
        String stringUserGpa = String.format("%.2f%n", userGpa);
        String stringGpa2 = String.format("%.2f%n", gpa2);
        String stringGpa3 = String.format("%.2f%n", gpa3);

        userGpa = new Double(stringUserGpa);
        gpa2 = new Double(stringGpa2);
        gpa3 = new Double(stringGpa3);

        boolean graduate = false;
        boolean graduate2 = false;
        boolean graduate3 = false;

        //tests if each student can graduate with their gpa
        if(userGpa >= 3.0)
        {
            graduate = true;
        }
        if(gpa2 >= 3.0)
        {
            graduate2 = true;
        }
        if(gpa3 >= 3.0)
        {
            graduate3 = true;
        }


        //displays records using StudentInfo class
        StudentInfo student1 = new StudentInfo(userGpa, graduate, honorsClasses, firstName, lastName);

        StudentInfo student2 = new StudentInfo(gpa2, graduate2, 3, firstNames[firstNameIndex2], lastNames[lastNameIndex2]);

        StudentInfo student3 = new StudentInfo(gpa3, graduate3, 1, firstNames[firstNameIndex3], lastNames[lastNameIndex3]);

        System.out.println("\nYour four years are over! Here are your records: ");
        System.out.println(student1.toString());
        System.out.println("\nOther student's records: ");
        System.out.println(student2.toString());
        System.out.println("\n" + student3.toString());

        //asks if the user wants to see the weighted GPAs
        System.out.println("\nWould you like to see the GPAs when they are weighted?(yes/no)");
        response = kb.nextLine();

        if(response.equalsIgnoreCase("yes"))
        {
            //user's weighted gpa
            System.out.println("\n" + firstName + "'s(you) weighted GPA is: " + student1.weightedGPA());

            //student 2's weighted gpa
            System.out.println(firstNames[firstNameIndex2] + "'s weighted GPA is : " + student2.weightedGPA());

            //student 3's weighted gpa
            System.out.println(firstNames[firstNameIndex3] + "'s weighted GPA is : " + student3.weightedGPA());
        }

        else if(response.equalsIgnoreCase("no"))
        {
            System.out.println("Ok...");
        }

        else
        {
            System.out.println("You didn't enter a valid response so I'll take that as a no...");
        }

        //asks if the user wants to see the student's school emails
        System.out.println("\n\nWould you like to see the student's emails?(yes/no)");
        response = kb.nextLine();

        if(response.equalsIgnoreCase("yes"))
        {
            //user's email
            System.out.println("\n" + firstName + "'s(you) school email is " + student1.createEmail());

            //student 2's email
            System.out.println(firstNames[firstNameIndex2] + "'s school email is " + student2.createEmail());

            //student 3's email
            System.out.println(firstNames[firstNameIndex3] + "'s school email is " + student3.createEmail());
        }

        else if(response.equalsIgnoreCase("no"))
        {
            System.out.println("Ok...");
        }

        else
        {
            System.out.println("You didn't enter a valid response so I'll take that as a no...");
        }

        //goodbye message(kinda)
        System.out.println("\nOkie dokie thats it!");
    }

    //this is where the main method ends
//*****************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************//
    //seperate methods begin here


    //freshman year
    static void freshmanYear()
    {
        //creates local scanner
        Scanner kb = new Scanner(System.in);
        String localResponse = "";

        //list of classes freshman year
        String[] freshmanClasses = {"English 1", "Elective", "Biology", "Spanish 1", "Sport", "Math 1"};

        //asks if the user wants to take honors
        System.out.println("\nYou are an incoming freshman, do you want to take honors classes?(yes/no)");
        localResponse = kb.nextLine();

        //changes the class names to honors, then outputs the list of classes
        if(localResponse.equalsIgnoreCase("yes"))
        {

            System.out.println("\nVery studious of you!");
            freshmanClasses[0] += " Honors";
            freshmanClasses[2] += " Honors";
            freshmanClasses[5] += " Honors";
            createSchedule(freshmanClasses);
            honorsClasses++;
        }
        //just outputs the list of classes
        else if(localResponse.equalsIgnoreCase("no"))
        {
            System.out.println("\nI see how it is...");
            createSchedule(freshmanClasses);
        }
        //makes sure the user inputs a valid response then outputs non-honor classes
        else
        {
            checkResponse();
            System.out.println("\nYou took too long to decide and now your assigned to regular classes");
            createSchedule(freshmanClasses);
        }
    }

    //sophomore year
    public static void sophomoreYear()
    {
        //creates local scanner
        Scanner kb = new Scanner(System.in);
        String localResponse = "";

        //list of sophomore year classes
        String[] sophomoreClasses = {"Chemistry", "Elective", "Math 2", "Spanish 2", "Sport", "English 2"};

        System.out.println("\nYou are an incoming sophomore, do you want to take honors classes?(yes/no)");
        localResponse = kb.nextLine();

        //changes the class names to honors, then outputs the list of classes
        if(localResponse.equalsIgnoreCase("yes"))
        {

            System.out.println("\nVery studious of you!");
            sophomoreClasses[0] += " Honors";
            sophomoreClasses[2] += " Honors";
            sophomoreClasses[5] += " Honors";
            createSchedule(sophomoreClasses);
            honorsClasses++;
        }
        //just outputs the list of classes
        else if(localResponse.equalsIgnoreCase("no"))
        {
            System.out.println("\nI see how it is...");
            createSchedule(sophomoreClasses);
        }

        //makes sure the user inputs a valid response then outputs non-honor classes
        else
        {
            checkResponse();
            System.out.println("\nYou took too long to decide and now your assigned to regular classes");
            createSchedule(sophomoreClasses);
        }
    }

    public static void juniorYear()
    {
        //creates local scanner
        Scanner kb = new Scanner(System.in);
        String localResponse = "";

        //list of junior year classes
        String[] juniorClasses = {"Math 3", "Sport", "Physics 1", "Spanish 3", "Elective", "English 3"};

        System.out.println("\nYou are an incoming junior, do you want to take honors classes?(yes/no)");
        localResponse = kb.nextLine();

        //changes the class names to honors, then outputs the list of classes
        if(localResponse.equalsIgnoreCase("yes"))
        {

            System.out.println("\nVery studious of you!");
            juniorClasses[0] += " Honors";
            juniorClasses[2] += " Honors";
            juniorClasses[5] += " Honors";
            createSchedule(juniorClasses);
            honorsClasses++;
        }

        else if(localResponse.equalsIgnoreCase("no"))
        {
            System.out.println("\nI see how it is...");
            createSchedule(juniorClasses);
        }

        else
        {
            checkResponse();
            System.out.println("\nYou took too long to decide and now your assigned to regular classes");
            createSchedule(juniorClasses);
        }
    }

    //senior year
    public static void seniorYear()
    {
        //creates local scanner
        Scanner kb = new Scanner(System.in);
        String localResponse = "";

        //list of senior year classes
        String[] seniorClasses = {"Math", "Elective", "Physics 2", "Spanish 4", "Sport", "English 4"};

        System.out.println("\nYou are an incoming senior, do you want to take AP classes?(yes/no)");
        localResponse = kb.nextLine();

        //changes the class names to honors, then outputs the list of classes
        if(localResponse.equalsIgnoreCase("yes"))
        {
            System.out.println("\nVery studious of you!");
            seniorClasses[0] = "AP " + seniorClasses[0];
            seniorClasses[2] = "AP " + seniorClasses[2];
            seniorClasses[5] = "AP " + seniorClasses[5];
            createSchedule(seniorClasses);
            honorsClasses++;
        }
        else if(localResponse.equalsIgnoreCase("no"))
        {
            System.out.println("\nI see how it is...");
            createSchedule(seniorClasses);
        }
        else
        {
            checkResponse();
            System.out.println("\nYou took too long to decide and now your assigned to regular classes");
            createSchedule(seniorClasses);
        }
    }

    //creates a schedule with the electives and generates a grade for each class
    public static void createSchedule(String[] schedule)
    {
        //creates local scanner
        Scanner kb = new Scanner(System.in);
        String localResponse = "";

        //asks for the first elective
        System.out.println("\nYou can take two electives, what is your first elective? (English, Math, Biology, and Spanish are already assigned into your schedule)");

        localResponse = kb.nextLine();

        //assigns elective into the schedule
        schedule[1] = localResponse;

        //asks for the second elective
        System.out.println("\nWhat is your second elective? (You can choose to do a sport)");
        localResponse = kb.nextLine();

        //assigns another elective into the schedule
        schedule[4] = localResponse;

        //outputs each class in order
        System.out.println("\nHere is your schedule:");
        for(int i = 1; i < schedule.length + 1; i++)
        {
            System.out.println("\nPeriod " + i + ".) " + schedule[i-1]);
        }

        System.out.println("\nYou are in school right now. Click enter to finish the year");
        localResponse = kb.nextLine();

        //used to generate random letter grade
        String grades = "ABCDF";
        Random spot = new Random();
        int size = grades.length();

        System.out.println("The year is over!. Here are your grades...");

        //outputs grades for each class
        for(int i = 0; i < schedule.length; i++)
        {
            System.out.println("\n" + schedule[i] + ": " + grades.charAt(spot.nextInt(size)));
        }
    }

    //makes sure there is a valid response
    public static void checkResponse()
    {
        Scanner kb = new Scanner(System.in);
        String localResponse = "";

        //makes sure the user doesn't continue unless they answer with "yes" or "no"
        while((!localResponse.equalsIgnoreCase("no") && !localResponse.equalsIgnoreCase("yes")))
        {
            System.out.println("\nEnter a valid response :|");
            localResponse = kb.nextLine();
        }

        //makes them feel bad
        if(localResponse.equalsIgnoreCase("no"))
        {
            System.out.println("Oh well.. :(");
        }
    }
}