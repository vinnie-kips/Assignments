import java.sql.*;     // Use classes in java.sql package

public class ODBC {    // Save as "ODBC.java"
    public static void main(String[] args) {
        try (
                // Step 1: Allocate a database 'Connection' object
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/students",
                        "user", "9971"); // for MySQL only

                // Step 2: Allocate a 'Statement' object in the Connection
                Statement stmt = conn.createStatement();
        ) {
            // Step 3 & 4: Execute a SQL INSERT|DELETE statement via executeUpdate(),
            //   which returns an int indicating the number of rows affected.

            // DELETE records with id>=3000 and id<4000
            String sqlDelete = "delete from student where id >= 3000 and id < 4000";
            System.out.println("The SQL statement is: " + sqlDelete + "\n");  // Echo for debugging
            int countDeleted = stmt.executeUpdate(sqlDelete);
            System.out.println(countDeleted + " records deleted.\n");

            // INSERT a record
            String sqlInsert = "insert into student values (3001, 'Gilbert', 'English', 70,'A')";
            System.out.println("The SQL statement is: " + sqlInsert + "\n");  // Echo for debugging
            int countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + " records inserted.\n");

            // INSERT multiple records
            sqlInsert = "insert into books values "
                    + "(3002, 'Gilbert 2', 'Kishwahili', 78,'B'),"
                    + "(3003, 'Gilbert 3', 'Maths', 80, 'A')";
            System.out.println("The SQL statement is: " + sqlInsert + "\n");  // Echo for debugging
            countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + " records inserted.\n");

            // INSERT a partial record
            sqlInsert = "insert into student (id, name, grade) values (3004, 'Alice', 'A')";
            System.out.println("The SQL statement is: " + sqlInsert + "\n");  // Echo for debugging
            countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + " records inserted.\n");

            // Issue a SELECT to check the changes
            String strSelect = "select * from student";
            System.out.println("The SQL statement is: " + strSelect + "\n");  // Echo For debugging
            ResultSet rset = stmt.executeQuery(strSelect);
            while(rset.next()) {   // Move the cursor to the next row
                System.out.println(rset.getInt("id") + ", "
                        + rset.getString("name") + ", "
                        + rset.getString("subjects") + ", "
                        + rset.getDouble("percentage") + ", "
                        + rset.getInt("grade"));
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }  // Step 5: Close conn and stmt - Done automatically by try-with-resources
    }
}