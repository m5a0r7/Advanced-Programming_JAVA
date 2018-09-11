import javax.swing.*;
import java.awt.*;

public class player {

    JLabel p = new JLabel();


    public JLabel player_right(int x,int y , int width , int height){

        JLabel b = new JLabel(new ImageIcon("D:/University/Semester8/AP/New folder (2)/project/Images/Bombermans/Player 1/31.gif"));
        b.setBounds(x,y,width,height);
        return b;

    }

    public JLabel player_left(int x,int y , int width , int height){

        JLabel b = new JLabel(new ImageIcon("D:/University/Semester8/AP/New folder (2)/project/Images/Bombermans/Player 1/21.gif"));
        b.setBounds(x,y,width,height);
        return b;

    }

    public JLabel player_up(int x,int y , int width , int height){

        JLabel b = new JLabel(new ImageIcon("D:/University/Semester8/AP/New folder (2)/project/Images/Bombermans/Player 1/01.gif"));
        b.setBounds(x,y,width,height);
        return b;

    }

    public JLabel player_down(int x,int y , int width , int height){

        JLabel b = new JLabel(new ImageIcon("D:/University/Semester8/AP/New folder (2)/project/Images/Bombermans/Player 1/11.gif"));
        b.setBounds(x,y,width,height);
        return b;

    }
}
