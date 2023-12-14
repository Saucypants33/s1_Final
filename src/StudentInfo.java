public class StudentInfo
{
    static int numOfStudents = 0;
    //instance variables
    double gpa;
    boolean graduate;
    int honorClassesTaken;
    String firstName;
    String lastName;

    //2.)  Constructors
    public StudentInfo()
    {
        gpa = 0.0;
        graduate = false;
        honorClassesTaken = 0;
        firstName = "";
        lastName = "";
    }

    public StudentInfo(double gpa, boolean graduate, int honorClassesTaken, String firstName, String lastName)
    {
        this.gpa = gpa;
        this.graduate = graduate;
        this.honorClassesTaken = honorClassesTaken;
        this.firstName = firstName;
        this.lastName = lastName;
        numOfStudents++;
    }

    //3.) toString
    public String toString()
    {
        return "\nStudent name: " + firstName + " " + lastName + "\nHigh School GPA: " + gpa + "\nIs able to graduate: " + graduate + " \nHonor Classes Taken: " + honorClassesTaken * 3 + "(" + honorClassesTaken + " year(s))";
    }

    //4.) getters and setters
    public double getGPA()
    {
        return gpa;
    }

    public boolean getGraduate()
    {
        return graduate;
    }

    public int getHonorClassesTaken()
    {
        return honorClassesTaken;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setGPA(double newGpa)
    {
        gpa = newGpa;
    }

    public void setGraduate(boolean newGraduate)
    {
        graduate = newGraduate;
    }

    public void setHonorClassesTaken(int newHonorClassesTaken)
    {
        honorClassesTaken = newHonorClassesTaken;
    }

    public void setFirstName(String newFirstName)
    {
        firstName = newFirstName;
    }

    public void setLastName(String newLastName)
    {
        lastName = newLastName;
    }

    //5.) Brain Methods
    //brain method(weighed and unweighed gpa)
    //creates an email for the user

    public double weightedGPA()
    {
        double gpaBoost = 1;
        if(honorClassesTaken == 1)
        {
            gpaBoost += 0.1;
        }

        else if(honorClassesTaken == 2)
        {
            gpaBoost += 0.2;
        }

        else if(honorClassesTaken == 3)
        {
            gpaBoost += 0.3;
        }

        else if(honorClassesTaken == 4)
        {
            gpaBoost += 0.4;
        }

        gpa *= gpaBoost;
        //converts and formats the double to 2 decimal places
        String stringGpa = String.format("%.2f%n", gpa);
        stringGpa = stringGpa.substring(0, 4);
        gpa = new Double(stringGpa);

        return gpa;
    }

    public String createEmail()
    {
        return firstName.substring(0,1) + lastName + "@g.mvusd.net";
    }
}
