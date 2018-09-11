import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class enemy_4 {

    public  void enemy(final int[] score,JLabel person ,List<Integer> location , JFrame frame , int width , int height , List<Integer> place_to_go , List<Integer> forbidden_place , List<Integer> enemy_1_lives , List<Integer> bombs_locations){


        /*
        final int[] x_location = new int[1];

        final int[] y_location = new int[1];

        final int[] person_location = new int[1];



        Runnable r2= new Runnable() {
            public void run() {
                try {
                    while (true) {


                        x_location[0] = person.getLocation().x;

                        y_location[0] = person.getLocation().y;

                        person_location[0] = (width/50)*(y_location[0] /50) + x_location[0] /50;



                        Thread.sleep(100L);
                    }
                } catch (InterruptedException iex) {}
            }
        };

        Thread thr2 = new Thread(r2);

        thr2.start();
*/

        ImageIcon image = new ImageIcon("D:\\University\\Semester8\\AP\\Project_revise\\images\\GameOver\\gameover.png");
        JLabel imageLabel = new JLabel(image);
        imageLabel.setBounds(0, 0, width, height);
        imageLabel.setVisible(true);

        JLabel enemy_1 = new JLabel(new ImageIcon("D:/University/Semester8/AP/New folder (2)/project/Images/Bombermans/Player 4/41.gif"));
        enemy_1.setBounds((location.get(0) %(width/50))*50, (location.get(0) /(width/50))*50 , 50 , 50);


        JLabel enemy_2 = new JLabel(new ImageIcon("D:/University/Semester8/AP/New folder (2)/project/Images/Bombermans/Player 4/41.gif"));
        enemy_2.setBounds((location.get(1) %(width/50))*50, (location.get(1) /(width/50))*50 , 50 , 50);


        JLabel enemy_3 = new JLabel(new ImageIcon("D:/University/Semester8/AP/New folder (2)/project/Images/Bombermans/Player 4/41.gif"));
        enemy_3.setBounds((location.get(2) %(width/50))*50, (location.get(2) /(width/50))*50 , 50 , 50);


        frame.add(enemy_1);
        frame.add(enemy_2);
        frame.add(enemy_3);




        Runnable sc = new Runnable() {
            public void run() {
                try {
                    while (true) {


                        if(enemy_1_lives.get(0) == 0){
                            score[0] = score[0] + 400;

                            break;
                        }



                        Thread.sleep(5000L);
                    }
                } catch (InterruptedException iex) {}
            }
        };

        Thread aaa = new Thread(sc);

        aaa.start();


        Runnable sc2 = new Runnable() {
            public void run() {
                try {
                    while (true) {


                        if(enemy_1_lives.get(1) == 0){
                            score[0] = score[0] + 400;

                            break;
                        }



                        Thread.sleep(5000L);
                    }
                } catch (InterruptedException iex) {}
            }
        };

        Thread aaa2 = new Thread(sc2);

        aaa2.start();


        Runnable sc3 = new Runnable() {
            public void run() {
                try {
                    while (true) {


                        if(enemy_1_lives.get(2) == 0){
                            score[0] = score[0] + 400;

                            break;
                        }



                        Thread.sleep(5000L);
                    }
                } catch (InterruptedException iex) {}
            }
        };

        Thread aaa3 = new Thread(sc3);

        aaa3.start();


        Runnable r1 = new Runnable() {
            public void run() {
                try {
                    while (true) {



                        int x_location = person.getLocation().x;

                        int y_location = person.getLocation().y;


                        int person_location = (width/50)*(y_location/50) + x_location/50;


                        System.out.println("Person location");

                        System.out.println(person_location);

                        System.out.println("Person location");




                        if(enemy_1_lives.get(0) == 0){
                            frame.remove(enemy_1);
                        }
                        if(enemy_1_lives.get(1) == 0){
                            frame.remove(enemy_2);
                        }
                        if(enemy_1_lives.get(2) == 0){
                            frame.remove(enemy_3);
                        }


                        System.out.println("Hello, world!");

                        System.out.println("bombs_location");

                        for(int i = 0 ; i< bombs_locations.size();i++){

                            System.out.println(bombs_locations.get(i));
                        }

                        System.out.println("bombs_location");





                        List<Integer> valid_place_to_go_for_enemy_1 = new ArrayList<>();
                        List<Integer> distances_for_enemy_1 = new ArrayList<>();
                        List<Integer> valid_place_to_go_for_enemy_1_with_minimum_distance = new ArrayList<>();

                        if(!bombs_locations.contains(location.get(0) + 1)){
                            valid_place_to_go_for_enemy_1.add(location.get(0) + 1);
                        }
                        if(!bombs_locations.contains(location.get(0) - 1)){
                            valid_place_to_go_for_enemy_1.add(location.get(0) - 1);
                        }
                        if(!bombs_locations.contains(location.get(0) + width/50)){
                            valid_place_to_go_for_enemy_1.add(location.get(0) + width/50);
                        }
                        if(!bombs_locations.contains(location.get(0) - width/50)){
                            valid_place_to_go_for_enemy_1.add(location.get(0) - width/50);
                        }

                        if(valid_place_to_go_for_enemy_1.size() == 0){
                            valid_place_to_go_for_enemy_1.add(location.get(0));
                        }




                        for(int i = 0; i< valid_place_to_go_for_enemy_1.size();i++){
                            distances_for_enemy_1.add(Math.abs(person_location - valid_place_to_go_for_enemy_1.get(i)));

                        }


                        for(int j = 0; j< distances_for_enemy_1.size();j++){
                            if(Collections.min(distances_for_enemy_1) == distances_for_enemy_1.get(j)){
                                valid_place_to_go_for_enemy_1_with_minimum_distance.add(valid_place_to_go_for_enemy_1.get(j));
                            }
                        }

                        Collections.shuffle(valid_place_to_go_for_enemy_1_with_minimum_distance);


                        List<Integer> valid_place_to_go_for_enemy_2 = new ArrayList<>();
                        List<Integer> distances_for_enemy_2 = new ArrayList<>();
                        List<Integer> valid_place_to_go_for_enemy_2_with_minimum_distance = new ArrayList<>();



                        if(!bombs_locations.contains(location.get(1) + 1)){
                            valid_place_to_go_for_enemy_2.add(location.get(1) + 1);
                        }
                        if(!bombs_locations.contains(location.get(1) - 1)){
                            valid_place_to_go_for_enemy_2.add(location.get(1) - 1);
                        }
                        if(!bombs_locations.contains(location.get(1) + width/50)){
                            valid_place_to_go_for_enemy_2.add(location.get(1) + width/50);
                        }
                        if(!bombs_locations.contains(location.get(1) - width/50)){
                            valid_place_to_go_for_enemy_2.add(location.get(1) - width/50);
                        }

                        if(valid_place_to_go_for_enemy_2.size() == 0){
                            valid_place_to_go_for_enemy_2.add(location.get(1));
                        }
                        for(int i = 0; i< valid_place_to_go_for_enemy_2.size();i++){
                            distances_for_enemy_2.add(Math.abs(person_location - valid_place_to_go_for_enemy_2.get(i)));

                        }
                        for(int j = 0; j< distances_for_enemy_2.size();j++){
                            if(Collections.min(distances_for_enemy_2) == distances_for_enemy_2.get(j)){
                                valid_place_to_go_for_enemy_2_with_minimum_distance.add(valid_place_to_go_for_enemy_2.get(j));
                            }
                        }
                        Collections.shuffle(valid_place_to_go_for_enemy_2_with_minimum_distance);


                        List<Integer> valid_place_to_go_for_enemy_3 = new ArrayList<>();
                        List<Integer> distances_for_enemy_3 = new ArrayList<>();
                        List<Integer> valid_place_to_go_for_enemy_3_with_minimum_distance = new ArrayList<>();



                        if(!bombs_locations.contains(location.get(2) + 1)){
                            valid_place_to_go_for_enemy_3.add(location.get(2) + 1);
                        }
                        if(!bombs_locations.contains(location.get(2) - 1)){
                            valid_place_to_go_for_enemy_3.add(location.get(2) - 1);
                        }
                        if(!bombs_locations.contains(location.get(2) + width/50)){
                            valid_place_to_go_for_enemy_3.add(location.get(2) + width/50);
                        }
                        if(!bombs_locations.contains(location.get(2) - width/50)){
                            valid_place_to_go_for_enemy_3.add(location.get(2) - width/50);
                        }

                        if(valid_place_to_go_for_enemy_3.size() == 0){
                            valid_place_to_go_for_enemy_3.add(location.get(2));
                        }
                        for(int i = 0; i< valid_place_to_go_for_enemy_3.size();i++){
                            distances_for_enemy_3.add(Math.abs(person_location - valid_place_to_go_for_enemy_3.get(i)));

                        }
                        for(int j = 0; j< distances_for_enemy_3.size();j++){
                            if(Collections.min(distances_for_enemy_3) == distances_for_enemy_3.get(j)){
                                valid_place_to_go_for_enemy_3_with_minimum_distance.add(valid_place_to_go_for_enemy_3.get(j));
                            }
                        }
                        Collections.shuffle(valid_place_to_go_for_enemy_3_with_minimum_distance);


                        enemy_1.setBounds((valid_place_to_go_for_enemy_1_with_minimum_distance.get(0) %(width/50))*50, (valid_place_to_go_for_enemy_1_with_minimum_distance.get(0) /(width/50))*50 , 50 , 50);
                        enemy_2.setBounds((valid_place_to_go_for_enemy_2_with_minimum_distance.get(0) %(width/50))*50, (valid_place_to_go_for_enemy_2_with_minimum_distance.get(0) /(width/50))*50 , 50 , 50);
                        enemy_3.setBounds((valid_place_to_go_for_enemy_3_with_minimum_distance.get(0) %(width/50))*50, (valid_place_to_go_for_enemy_3_with_minimum_distance.get(0) /(width/50))*50 , 50 , 50);

                        location.set(0 , valid_place_to_go_for_enemy_1_with_minimum_distance.get(0));
                        location.set(1 , valid_place_to_go_for_enemy_2_with_minimum_distance.get(0));
                        location.set(2 , valid_place_to_go_for_enemy_3_with_minimum_distance.get(0));


                        if ((person_location == location.get(0) & enemy_1_lives.get(0) == 1) | (person_location == location.get(1) & enemy_1_lives.get(1) == 1) | (person_location == location.get(2) & enemy_1_lives.get(2) == 1)){

                            frame.getContentPane().removeAll();
                            frame.setContentPane(imageLabel);

                        }


                        List<Integer> valid_place = new ArrayList<>();
                        for(int i = 0; i < width * height/2500 ; i++){
                            if(!bombs_locations.contains(i)){
                                valid_place.add(i);

                            }
                        }

                        Thread.sleep(2500L);
                    }
                } catch (InterruptedException iex) {}
            }
        };

        Thread thr1 = new Thread(r1);

        thr1.start();






    }



}
