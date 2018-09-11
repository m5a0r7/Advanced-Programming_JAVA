import javax.swing.*;

public class bomb {
    public JLabel bomb(int x , int y , int width , int height , int timeToExplosion){
        JLabel bomb = new JLabel(new ImageIcon("D:/University/Semester8/AP/New folder (2)/project/Images/BomberBombs/2.gif"));
        bomb.setBounds(x,y,width,height);

        return bomb;

    }


    public float time_spend(){
        long startTime = System.currentTimeMillis();
        long estimatedTime = System.currentTimeMillis() - startTime;
        return estimatedTime;
    }


}
