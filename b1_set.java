import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class b1_set {

    public void b1_exploration(final int[] score,int bomb_radius,JLabel person,JFrame frame , JLabel bomb , int c_y_for_bomb , int c_x_for_bomb , int frame_width ,final int[] valid_number_for_bomb, List<Integer> brick_wall , List<Integer> brick_num , List<JLabel> bricks , List<Integer> enemy_1_location , List<Integer> enemy_1_lives , List<Integer> bombs_location , List<Integer> brick_in_map){


        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        // your code here


                        int x_location = person.getLocation().x;

                        int y_location = person.getLocation().y;


                        int person_location = (frame_width/50)*(y_location/50) + x_location/50;


                        List<Integer> walls_to_remove = new ArrayList<>();   //check if elements be in brick_and_wall then remove them

                        bomb.setBounds(1000000,1000000,50,50);

                        int current_location = (frame_width/50)*(c_y_for_bomb/50) + c_x_for_bomb/50;

                        int remove = brick_wall.indexOf((frame_width/50)*(c_y_for_bomb/50) + c_x_for_bomb/50);
                        brick_wall.remove(remove);
                        valid_number_for_bomb[0] = valid_number_for_bomb[0] + 1;

                        if(bomb_radius == 1){

                            if(current_location % (frame_width/50) == 0){

                                walls_to_remove.add(current_location - (frame_width/50));
                                walls_to_remove.add(current_location + (frame_width/50));
                                walls_to_remove.add(current_location + 1);

                            }

                            if(current_location % (frame_width/50) == ((frame_width/50) -1)){

                                walls_to_remove.add(current_location - (frame_width/50));
                                walls_to_remove.add(current_location + (frame_width/50));
                                walls_to_remove.add(current_location - 1);

                            }




                            if(current_location % (frame_width/50) != ((frame_width/50) -1) & current_location % (frame_width/50) != 0){

                                walls_to_remove.add(current_location - (frame_width/50));
                                walls_to_remove.add(current_location + (frame_width/50));
                                walls_to_remove.add(current_location - 1);
                                walls_to_remove.add(current_location + 1);


                            }

                            if((current_location - 1) == enemy_1_location.get(0) | (current_location + 1) == enemy_1_location.get(0) | (current_location + frame_width/50) == enemy_1_location.get(0) | (current_location - frame_width/50) == enemy_1_location.get(0)){
                                enemy_1_lives.set(0 , 0);
                            }
                            if((current_location - 1) == enemy_1_location.get(1) | (current_location + 1) == enemy_1_location.get(1) | (current_location + frame_width/50) == enemy_1_location.get(1) | (current_location - frame_width/50) == enemy_1_location.get(1)){
                                enemy_1_lives.set(1 , 0);
                            }
                            if((current_location - 1) == enemy_1_location.get(2) | (current_location + 1) == enemy_1_location.get(2) | (current_location + frame_width/50) == enemy_1_location.get(2) | (current_location - frame_width/50) == enemy_1_location.get(2)){
                                enemy_1_lives.set(2 , 0);
                            }


                        }



                        if(bomb_radius == 2){


                            if(current_location % (frame_width/50) == 0){

                                walls_to_remove.add(current_location - (frame_width/50));
                                walls_to_remove.add(current_location - 2*(frame_width/50));
                                walls_to_remove.add(current_location + (frame_width/50));
                                walls_to_remove.add(current_location + 2*(frame_width/50));
                                walls_to_remove.add(current_location + 1);
                                walls_to_remove.add(current_location + 2);

                            }

                            if(current_location % (frame_width/50) == ((frame_width/50) -1)){

                                walls_to_remove.add(current_location - (frame_width/50));
                                walls_to_remove.add(current_location - 2*(frame_width/50));
                                walls_to_remove.add(current_location + (frame_width/50));
                                walls_to_remove.add(current_location + 2*(frame_width/50));
                                walls_to_remove.add(current_location - 1);
                                walls_to_remove.add(current_location - 2);

                            }

                            if(current_location % (frame_width/50) == ((frame_width/50) -2)){
                                walls_to_remove.add(current_location - (frame_width/50));
                                walls_to_remove.add(current_location - 2*(frame_width/50));
                                walls_to_remove.add(current_location + (frame_width/50));
                                walls_to_remove.add(current_location + 2*(frame_width/50));
                                walls_to_remove.add(current_location - 1);
                                walls_to_remove.add(current_location - 2);
                                walls_to_remove.add(current_location + 1);
                            }

                            if(current_location % (frame_width/50) == 1){
                                walls_to_remove.add(current_location - (frame_width/50));
                                walls_to_remove.add(current_location - 2*(frame_width/50));
                                walls_to_remove.add(current_location + (frame_width/50));
                                walls_to_remove.add(current_location + 2*(frame_width/50));
                                walls_to_remove.add(current_location - 1);
                                walls_to_remove.add(current_location + 2);
                                walls_to_remove.add(current_location + 1);
                                walls_to_remove.addAll(enemy_1_location);
                            }




                            if(current_location % (frame_width/50) != ((frame_width/50) -1) & current_location % (frame_width/50) != 0   & (current_location % (frame_width/50) != 1)  & (current_location % (frame_width/50) != ((frame_width/50) -2))   ){

                                walls_to_remove.add(current_location - (frame_width/50));
                                walls_to_remove.add(current_location - 2*(frame_width/50));
                                walls_to_remove.add(current_location + (frame_width/50));
                                walls_to_remove.add(current_location + 2*(frame_width/50));
                                walls_to_remove.add(current_location - 1);
                                walls_to_remove.add(current_location - 2);
                                walls_to_remove.add(current_location + 1);
                                walls_to_remove.add(current_location + 2);

                            }



                            if((current_location - 1) == enemy_1_location.get(0) | (current_location + 1) == enemy_1_location.get(0) | (current_location + frame_width/50) == enemy_1_location.get(0) | (current_location - frame_width/50) == enemy_1_location.get(0) | (current_location - 2) == enemy_1_location.get(0) | (current_location + 2) == enemy_1_location.get(0) | (current_location + 2*frame_width/50) == enemy_1_location.get(0) | (current_location - 2*frame_width/50) == enemy_1_location.get(0)){
                                enemy_1_lives.set(0 , 0);
                            }
                            if((current_location - 1) == enemy_1_location.get(1) | (current_location + 1) == enemy_1_location.get(1) | (current_location + frame_width/50) == enemy_1_location.get(1) | (current_location - frame_width/50) == enemy_1_location.get(1) |(current_location - 2) == enemy_1_location.get(1) | (current_location + 2) == enemy_1_location.get(1) | (current_location + 2*frame_width/50) == enemy_1_location.get(1) | (current_location - 2*frame_width/50) == enemy_1_location.get(1) ){
                                enemy_1_lives.set(1 , 0);
                            }
                            if((current_location - 1) == enemy_1_location.get(2) | (current_location + 1) == enemy_1_location.get(2) | (current_location + frame_width/50) == enemy_1_location.get(2) | (current_location - frame_width/50) == enemy_1_location.get(2) | (current_location - 2) == enemy_1_location.get(2) | (current_location + 2) == enemy_1_location.get(2) | (current_location + 2*frame_width/50) == enemy_1_location.get(2) | (current_location - 2*frame_width/50) == enemy_1_location.get(2) ){
                                enemy_1_lives.set(2 , 0);
                            }
                        }





                        if(bomb_radius >= 3){


                            if(current_location % (frame_width/50) == 0){

                                walls_to_remove.add(current_location - (frame_width/50));
                                walls_to_remove.add(current_location - 2*(frame_width/50));
                                walls_to_remove.add(current_location - 3*(frame_width/50));
                                walls_to_remove.add(current_location + (frame_width/50));
                                walls_to_remove.add(current_location + 2*(frame_width/50));
                                walls_to_remove.add(current_location + 3*(frame_width/50));
                                walls_to_remove.add(current_location + 1);
                                walls_to_remove.add(current_location + 2);
                                walls_to_remove.add(current_location + 3);

                            }


                            if(current_location % (frame_width/50) == 1){
                                walls_to_remove.add(current_location - (frame_width/50));
                                walls_to_remove.add(current_location - 2*(frame_width/50));
                                walls_to_remove.add(current_location - 3*(frame_width/50));
                                walls_to_remove.add(current_location + (frame_width/50));
                                walls_to_remove.add(current_location + 2*(frame_width/50));
                                walls_to_remove.add(current_location + 3*(frame_width/50));
                                walls_to_remove.add(current_location - 1);
                                walls_to_remove.add(current_location + 2);
                                walls_to_remove.add(current_location + 1);
                                walls_to_remove.add(current_location + 3);
                            }



                            if(current_location % (frame_width/50) == 2){
                                walls_to_remove.add(current_location - (frame_width/50));
                                walls_to_remove.add(current_location - 2*(frame_width/50));
                                walls_to_remove.add(current_location - 3*(frame_width/50));
                                walls_to_remove.add(current_location + (frame_width/50));
                                walls_to_remove.add(current_location + 2*(frame_width/50));
                                walls_to_remove.add(current_location + 3*(frame_width/50));
                                walls_to_remove.add(current_location - 1);
                                walls_to_remove.add(current_location - 2);
                                walls_to_remove.add(current_location + 2);
                                walls_to_remove.add(current_location + 1);
                                walls_to_remove.add(current_location + 3);
                            }

                            if(current_location % (frame_width/50) == ((frame_width/50) -1)){

                                walls_to_remove.add(current_location - (frame_width/50));
                                walls_to_remove.add(current_location - 2*(frame_width/50));
                                walls_to_remove.add(current_location - 3*(frame_width/50));
                                walls_to_remove.add(current_location + (frame_width/50));
                                walls_to_remove.add(current_location + 2*(frame_width/50));
                                walls_to_remove.add(current_location + 3*(frame_width/50));
                                walls_to_remove.add(current_location - 1);
                                walls_to_remove.add(current_location - 2);
                                walls_to_remove.add(current_location - 3);

                            }

                            if(current_location % (frame_width/50) == ((frame_width/50) -2)){
                                walls_to_remove.add(current_location - (frame_width/50));
                                walls_to_remove.add(current_location - 2*(frame_width/50));
                                walls_to_remove.add(current_location - 3*(frame_width/50));
                                walls_to_remove.add(current_location + (frame_width/50));
                                walls_to_remove.add(current_location + 2*(frame_width/50));
                                walls_to_remove.add(current_location + 3*(frame_width/50));
                                walls_to_remove.add(current_location - 1);
                                walls_to_remove.add(current_location - 2);
                                walls_to_remove.add(current_location - 3);
                                walls_to_remove.add(current_location + 1);
                            }

                            if(current_location % (frame_width/50) == ((frame_width/50) -3)){
                                walls_to_remove.add(current_location - (frame_width/50));
                                walls_to_remove.add(current_location - 2*(frame_width/50));
                                walls_to_remove.add(current_location - 3*(frame_width/50));
                                walls_to_remove.add(current_location + (frame_width/50));
                                walls_to_remove.add(current_location + 2*(frame_width/50));
                                walls_to_remove.add(current_location + 3*(frame_width/50));
                                walls_to_remove.add(current_location - 1);
                                walls_to_remove.add(current_location - 2);
                                walls_to_remove.add(current_location - 3);
                                walls_to_remove.add(current_location + 1);
                                walls_to_remove.add(current_location + 2);
                            }







                            if(current_location % (frame_width/50) != ((frame_width/50) -1) & current_location % (frame_width/50) != 0   & (current_location % (frame_width/50) != 1)  & (current_location % (frame_width/50) != ((frame_width/50) -2))  & (current_location % (frame_width/50) == ((frame_width/50) -3)) & (current_location % (frame_width/50) == ((frame_width/50) -2)) ){

                                walls_to_remove.add(current_location - (frame_width/50));
                                walls_to_remove.add(current_location - 2*(frame_width/50));
                                walls_to_remove.add(current_location - 3*(frame_width/50));
                                walls_to_remove.add(current_location + (frame_width/50));
                                walls_to_remove.add(current_location + 2*(frame_width/50));
                                walls_to_remove.add(current_location + 3*(frame_width/50));
                                walls_to_remove.add(current_location - 1);
                                walls_to_remove.add(current_location - 2);
                                walls_to_remove.add(current_location - 3);
                                walls_to_remove.add(current_location + 1);
                                walls_to_remove.add(current_location + 2);
                                walls_to_remove.add(current_location + 3);



                            }




                            if((current_location - 1) == enemy_1_location.get(0) | (current_location + 1) == enemy_1_location.get(0) | (current_location + frame_width/50) == enemy_1_location.get(0) | (current_location - frame_width/50) == enemy_1_location.get(0) | (current_location - 2) == enemy_1_location.get(0) | (current_location + 2) == enemy_1_location.get(0) | (current_location + 2*frame_width/50) == enemy_1_location.get(0) | (current_location - 2*frame_width/50) == enemy_1_location.get(0) | (current_location - 3) == enemy_1_location.get(0) | (current_location + 3) == enemy_1_location.get(0) | (current_location + 3*frame_width/50) == enemy_1_location.get(0) | (current_location - 3*frame_width/50) == enemy_1_location.get(0) ){
                                enemy_1_lives.set(0 , 0);
                                score[0] = score[0] + 100;

                                System.out.println("Khailiiiiii Khariiiiii");


                            }
                            if((current_location - 1) == enemy_1_location.get(1) | (current_location + 1) == enemy_1_location.get(1) | (current_location + frame_width/50) == enemy_1_location.get(1) | (current_location - frame_width/50) == enemy_1_location.get(1) |(current_location - 2) == enemy_1_location.get(1) | (current_location + 2) == enemy_1_location.get(1) | (current_location + 2*frame_width/50) == enemy_1_location.get(1) | (current_location - 2*frame_width/50) == enemy_1_location.get(1) | (current_location - 3) == enemy_1_location.get(1) | (current_location + 3) == enemy_1_location.get(1) | (current_location + 3*frame_width/50) == enemy_1_location.get(1) | (current_location - 3*frame_width/50) == enemy_1_location.get(1) ){
                                enemy_1_lives.set(1 , 0);
                                score[0] = score[0] + 100;

                                System.out.println("Khailiiiiii Khariiiiii");

                            }
                            if((current_location - 1) == enemy_1_location.get(2) | (current_location + 1) == enemy_1_location.get(2) | (current_location + frame_width/50) == enemy_1_location.get(2) | (current_location - frame_width/50) == enemy_1_location.get(2) | (current_location - 2) == enemy_1_location.get(2) | (current_location + 2) == enemy_1_location.get(2) | (current_location + 2*frame_width/50) == enemy_1_location.get(2) | (current_location - 2*frame_width/50) == enemy_1_location.get(2) | (current_location - 3) == enemy_1_location.get(2) | (current_location + 3) == enemy_1_location.get(2) | (current_location + 3*frame_width/50) == enemy_1_location.get(2) | (current_location - 3*frame_width/50) == enemy_1_location.get(2) ){
                                enemy_1_lives.set(2 , 0);
                                score[0] = score[0] + 100;

                                System.out.println("Khailiiiiii Khariiiiii");
                            }
                        }












                        for (int i = 0; i<walls_to_remove.size();i++){


                            if (brick_in_map.contains(walls_to_remove.get(i))){

                                int rem = brick_wall.indexOf(walls_to_remove.get(i));
                                brick_wall.remove(rem);
                                int brick_index = brick_num.indexOf(walls_to_remove.get(i));
                                frame.remove(bricks.get(brick_index));

                            }


                        }


                        System.out.println("**********");

                        for(int i = 0 ; i < 3 ; i++){
                            System.out.println(enemy_1_lives.get(i));
                        }


                        System.out.println("**********");
                        frame.revalidate();
                        frame.repaint();
                        System.out.println(person_location);

                        System.out.println("person_location");
                        System.out.println(score[0]);

                        System.out.println("person_location");

                        bombs_location.remove(bombs_location.indexOf(current_location));


                    }
                },
                5000





        );



    }
}
