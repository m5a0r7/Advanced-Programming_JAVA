import javax.swing.*;

public class Ghost {

    public JLabel ghost(int x , int y , int width , int height){

        JLabel g = new JLabel(new ImageIcon("D:\\University\\Semester8\\AP\\Project_revise\\images\\bunes\\ghost/12.gif"));
        g.setBounds(x,y,width,height);
        return g;

    }

}
