import java.sql.*;

public class addStudents {

    public addStudents(){


    }

    public void add(String id , String fname , String lname , String email , String dob){





        String sql = "INSERT INTO `students`(`id` , `fname` , lname` , `email` , `DOB`) VALUES (`?` , `?` , `?` , `?` ,`?`)";

        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/school" , "aaa" , "aaa");

            PreparedStatement stmt = conn.prepareStatement(dob);


        ) {

            stmt.setString(1 , id);
            stmt.setString(2 , fname);
            stmt.setString(3 , lname);
            stmt.setString(4 , email);
            stmt.setString(5 , dob);

            stmt.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
