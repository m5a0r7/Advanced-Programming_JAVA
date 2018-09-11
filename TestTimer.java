import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class TestTimer {

    public void counter(JLabel label , final int[] timeRemaining , JFrame frame , int width , int height){

        ImageIcon image = new ImageIcon("D:\\University\\Semester8\\AP\\Project_revise\\images\\time\\end_time.png");
        JLabel imageLabel = new JLabel(image);
        imageLabel.setBounds(0, 0, width, height);
        imageLabel.setVisible(true);





        Runnable r1 = new Runnable() {
            public void run() {
                try {
                    while (true) {

                        if (timeRemaining[0] > 0){

                            timeRemaining[0] = timeRemaining[0] - 1;

                            String time_in_jlable = new Integer(timeRemaining[0]).toString();
                            label.setText(time_in_jlable);

                        }

                        else {

                            //frame.dispatchEvent((new WindowEvent(frame, WindowEvent.WINDOW_CLOSING)));
                            frame.getContentPane().removeAll();
                            frame.setContentPane(imageLabel);
                            break;


                        }






                        Thread.sleep(1000L);
                    }
                } catch (InterruptedException iex) {}
            }
        };

        Thread thr1 = new Thread(r1);

        thr1.start();

    }





}