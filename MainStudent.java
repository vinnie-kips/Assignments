import java.io.InterruptedIOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MainStudent {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedIOException {
        String string=("SELECT * FROM STUDENT");
        try
        {
            Class.forName("com.jdbc.Driver");

            // Establishing Connection
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/students");

            if (con != null){
                System.out.println("Connected");
            }
            else{
                System.out.println("Not Connected");
                }
           Statement st=con.createStatement();
            ResultSet rs=st.executeQuery( "SELECT * FROM STUDENT");
            rs.next();
            String id=rs.getString(2);
            System.out.println(id);
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }




             /**
        //Create a list of student
        List<Student> studentList = new ArrayList<Student>();
        Scanner input = new Scanner(System.in);
        int g1, g2, g3;
        String name;
        int choice;
        do {
            //Instantiate a new object student
            Student student = new Student();

            System.out.println(" --Please enter the student name: ");
            name = input.next();
            student.setName(name);

            System.out.println(" --Please enter the first grade(Integers only): ");//Integers only
            g1 = input.nextInt();
            student.setGrade1(g1);

            System.out.println(" --Please enter the the second grade(Integers only): ");//Integers only
            g2 = input.nextInt();
            student.setGrade2(g2);

            System.out.println(" --Please enter the the third grade(Integers only): ");//Integers only
            g3 = input.nextInt();
            student.setGrade3(g3);

            System.out.println(" Do you want to continue?  enter the number ");//Integers only
            System.out.println(" 1- YES     2- NO ");
            choice = input.nextInt();

            student.setAverage(student.calculateAverage());

            //Push a new object to student list
            studentList.add(student);
        }
        while (choice != 2);

        //Get student object with the higher average
        Student higherStudent = Collections.max(studentList, Comparator.comparing(c -> c.getAverage()));
//Displays the highest avg with the student name
        System.out.println("THE HIGHEST AVG :" + higherStudent.getAverage() + "\n BELONG'S TO: " + higherStudent.getName());
              **/
    }
}
