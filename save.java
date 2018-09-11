

import java.sql.*;


public class save{
    public save(){



    }
    public void contectDatabase(){

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/singleschool" , "root" , "Mohroh93"
            );

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM sc_staffdetails");

            while (rs.next()){
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + "    " + rs.getString(4));

            }
            stmt.close();
            con.close();

        }catch (Exception e) {
            System.out.println(e);

        }



    }
}