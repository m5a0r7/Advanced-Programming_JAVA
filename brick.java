import javax.swing.*;

public class brick {
    public JLabel brick(int x , int y , int width , int height){
        JLabel b = new JLabel(new ImageIcon("D:/University/Semester8/AP/New folder (2)/project/Images/Brick/2.gif"));
        b.setBounds(x,y,width,height);
        return b;
    }
}
