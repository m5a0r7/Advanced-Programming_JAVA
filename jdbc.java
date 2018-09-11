import javax.xml.transform.Result;
import java.sql.*;
import java.util.Scanner;

public class jdbc {


    private static final String user = "aaa";
    private static final String pass = "aaa";
    private static final String url = "jdbc:mysql://localhost/school";

    public static void main(String[] args) throws SQLException {

        //Class.forName(com.mysql.jdbc.Driver);


        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;


        try {
            con = DriverManager.getConnection(url , user , pass);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE , ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT * FROM students");

            students.getStudents(rs);

            //rs.last();
            //System.out.println("Last Student is: " + rs.getString("first_name") + " " + rs.getString("last_name"));

            //rs.absolute(3);





            //System.out.println("Connected");
            //System.out.println(rs.getRow());



        }catch (SQLException e){

            System.out.println(e);
        }



        finally {
            if (rs != null){

                rs.close();

            }
            if (stmt != null){
                stmt.close();
            }

            if (con != null){
                con.close();
            }
        }


/*


        Scanner input = new Scanner(System.in);

        System.out.println("Do you want to add Students?");

        String ans = input.nextLine();

        if (ans.equalsIgnoreCase("yes")){

            System.out.println("Enter Id : ");
            String id = input.nextLine();

            System.out.println("Enter First Name : ");
            String fname = input.nextLine();

            System.out.println("Enter Last namr ");
            String lname = input.nextLine();

            System.out.println("Enter email: ");
            String email = input.nextLine();

            System.out.println("Enter DOB : ");
            String dob = input.nextLine();

            addStudents create = new addStudents();

            create.add(id , fname , lname , email , dob);

        }



*/



    }
}
