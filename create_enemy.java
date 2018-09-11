import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.Scanner;

public class create_enemy {
    private static String ghost;
    private static String directly;
    private static int speed;

    public static void main(String[] args) throws SQLException {

        Scanner reader = new Scanner(System.in);
        System.out.println("Ghost?");
        ghost = reader.nextLine();
        System.out.println(ghost);

        System.out.println("Go directly to the target?");
        directly = reader.nextLine();
        System.out.println(directly);

        System.out.println("Speed");
        speed = reader.nextInt();
        System.out.println(speed);

    }






}
