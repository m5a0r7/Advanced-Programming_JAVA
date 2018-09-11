import javax.swing.*;

public class printScore {

    public void print(JLabel person_score , final int[] score){

        Runnable scot_to_show= new Runnable() {
            public void run() {
                try {
                    while (true) {


                        person_score.setText(String.valueOf(score[0]));

                        Thread.sleep(100L);
                    }
                } catch (InterruptedException iex) {}
            }
        };

        Thread sc = new Thread(scot_to_show);

        sc.start();


    }
}
