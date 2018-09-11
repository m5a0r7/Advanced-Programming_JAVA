import javax.swing.*;

public class wall {

    public JLabel wall(int x , int y , int width , int height){

        JLabel wall = new JLabel(new ImageIcon("D:/University/Semester8/AP/New folder (2)/project/Images/Walls/2.gif"));
        wall.setBounds(x,y,width,height);
        return wall;
    }


}
