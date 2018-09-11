import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class bomb_fire_on_key {

    public void b1_exploration_on_key(int bomb_radius,JLabel person,JFrame frame , JLabel bomb , int c_y_for_bomb , int c_x_for_bomb , int frame_width ,final int[] valid_number_for_bomb, List<Integer> brick_wall , List<Integer> brick_num , List<JLabel> bricks , List<Integer> brick_in_map){



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
                        }












                        for (int i = 0; i<walls_to_remove.size();i++){


                            if (brick_in_map.contains(walls_to_remove.get(i))){

                                int rem = brick_wall.indexOf(walls_to_remove.get(i));
                                brick_wall.remove(rem);
                                int brick_index = brick_num.indexOf(walls_to_remove.get(i));
                                frame.remove(bricks.get(brick_index));

                            }


                        }
                        frame.revalidate();
                        frame.repaint();
                        System.out.println(person_location);

/*
                        if(walls_to_remove.contains(person_location)){
                            JPanel game_over = new JPanel();
                            game_over.setBounds(frame_width/4 , frame_width/4 , frame_width/2,frame_width/2);
                            game_over.setBackground(Color.black);
                            frame.add(game_over);
                        }

*/

                    }
                },
                0





        );



    }
}
