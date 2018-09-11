import javafx.scene.layout.BorderPane;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;
import java.util.Timer;

public class main extends Thread{


    private static String ghost_set;
    private static String directly;
    private static int speed_enemy;


    public static void main(String[] args){


        Scanner reader = new Scanner(System.in);
        System.out.println("Ghost?");
        ghost_set = reader.nextLine();
        System.out.println(ghost_set);

        System.out.println("Go directly to the target?");
        directly = reader.nextLine();
        System.out.println(directly);

        System.out.println("Speed");
        speed_enemy = reader.nextInt();
        System.out.println(speed_enemy);


        final int[] level = {1};


        JFrame frame = new JFrame();


        final int[] bomb_number = {2};

        int width = 1000;
        int height = 800;

        final int[] score = {0};

        final int[] bomb_radius = {1};

        final int[] bomb_control = {0};
        final int[] speed = {10};

        List<Integer> possible_speed = new ArrayList<>();

        possible_speed.add(10);
        possible_speed.add(20);
        possible_speed.add(40);


        final int[] ind_speed = {0};



        int[] brick_number = new int[width*height*3/(100*100)];

        main t = new main();
        t.start();




        JPanel cover = new JPanel();
        frame.setSize(width,height);


        JLabel b1 = new bomb().bomb(1000000 , 1000000 , 50,50,5);
        JLabel b2 = new bomb().bomb(1000000 , 1000000 , 50,50,5);
        JLabel b3 = new bomb().bomb(1000000 , 1000000 , 50,50,5);
        JLabel b4 = new bomb().bomb(1000000 , 1000000 , 50,50,5);
        JLabel b5 = new bomb().bomb(1000000 , 1000000 , 50,50,5);


        final int[] ghost_powerup = {0};




        List<JLabel> bomb_lable = new ArrayList<>();

        bomb_lable.add(b1);
        bomb_lable.add(b2);
        bomb_lable.add(b3);
        bomb_lable.add(b4);
        bomb_lable.add(b5);





        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
        frame.add(b5);

        JLabel person_score = new JLabel();

        person_score.setText(String.valueOf(score[0]));

        frame.add(person_score);
        person_score.setBounds(width - 50 , 0 , 50 , 50);



        List<JLabel> Object_to_add = new ArrayList<>();

        List<b1_set> bombs = new ArrayList<>();


        b1_set bomb_1 = new b1_set();
        b1_set bomb_2 = new b1_set();
        b1_set bomb_3 = new b1_set();
        b1_set bomb_4 = new b1_set();
        b1_set bomb_5 = new b1_set();

        bombs.add(bomb_1);
        bombs.add(bomb_2);
        bombs.add(bomb_3);
        bombs.add(bomb_4);
        bombs.add(bomb_5);



        List<bomb_fire_on_key> bombs_with_control = new ArrayList<>();

        bomb_fire_on_key bomb_control_1 = new bomb_fire_on_key();
        bomb_fire_on_key bomb_control_2 = new bomb_fire_on_key();
        bomb_fire_on_key bomb_control_3 = new bomb_fire_on_key();
        bomb_fire_on_key bomb_control_4 = new bomb_fire_on_key();
        bomb_fire_on_key bomb_control_5 = new bomb_fire_on_key();

        bombs_with_control.add(bomb_control_1);
        bombs_with_control.add(bomb_control_2);
        bombs_with_control.add(bomb_control_3);
        bombs_with_control.add(bomb_control_4);
        bombs_with_control.add(bomb_control_5);









        /////.
        BorderLayout kkk = new BorderLayout();
        frame.setLayout(kkk);

        JLabel[] walls = new JLabel[width*height/(100*100)];



        List<Integer> wall_number = new ArrayList<>();

       for(int i=0; i< width*height/(100*100);i++){

            walls[i] = new wall().wall((i%(width/100))*100 + 50 , (i/(width/100))*100 +50 , 50 , 50);
            frame.add(walls[i]);

        }

        List<Integer> brick_num = new ArrayList<>();

        for(int i = 0; i < width*height/(50*50);i++){

            if((((i) / (width/50))%2 == 0  | ((i) % (width/50))%2 == 0)){

                brick_num.add(i);
            }

            else {
                wall_number.add(i);
            }

        }
        brick_num.remove(width/50);
        brick_num.remove(1);
        brick_num.remove(0);






        Collections.shuffle(brick_num);

        List<JLabel> brick = new ArrayList<>();

        List<Integer> brick_and_wall = new ArrayList<>();
        brick_and_wall.addAll(wall_number);


        List<Integer> brick_in_map = new ArrayList<>();



        for (int i = 0 ; i < brick_num.size()/4;i++){
            JLabel x = new brick().brick((brick_num.get(i)%(width/50))*50, (brick_num.get(i)/(width/50))*50 , 50 , 50);
            frame.add(x);
            brick.add(x);
            brick_and_wall.add(brick_num.get(i));
            brick_in_map.add(brick_num.get(i));

        }


        Collections.shuffle(brick_in_map);

        final int[] ghost_location = {brick_in_map.get(0)};

        JLabel g = new Ghost().ghost((ghost_location[0] %(width/50))*50, (ghost_location[0] /(width/50))*50 , 50 , 50);

        frame.add(g);





        List<Integer> points_location = new ArrayList<>();
        points_location.add(brick_in_map.get(1));
        points_location.add(brick_in_map.get(2));
        points_location.add(brick_in_map.get(3));
        points_location.add(brick_in_map.get(4));
        points_location.add(brick_in_map.get(5));

        JLabel point1 = new IncreasePoints().point((points_location.get(0) %(width/50))*50, (points_location.get(0) /(width/50))*50 , 50 , 50);
        JLabel point2 = new IncreasePoints().point((points_location.get(1) %(width/50))*50, (points_location.get(1) /(width/50))*50 , 50 , 50);
        JLabel point3 = new IncreasePoints().point((points_location.get(2) %(width/50))*50, (points_location.get(2) /(width/50))*50 , 50 , 50);
        JLabel point4 = new IncreasePoints().point((points_location.get(3) %(width/50))*50, (points_location.get(3) /(width/50))*50 , 50 , 50);
        JLabel point5 = new IncreasePoints().point((points_location.get(4) %(width/50))*50, (points_location.get(4) /(width/50))*50 , 50 , 50);

        frame.add(point1);
        frame.add(point2);
        frame.add(point3);
        frame.add(point4);
        frame.add(point5);





        List<Integer> inc_rad_location = new ArrayList<>();

        inc_rad_location.add(brick_in_map.get(6));
        inc_rad_location.add(brick_in_map.get(7));
        inc_rad_location.add(brick_in_map.get(8));


        JLabel inc_rad1 = new IncreaseRadius().inc_rad((inc_rad_location.get(0) %(width/50))*50, (inc_rad_location.get(0) /(width/50))*50 , 50 , 50);
        JLabel inc_rad2 = new IncreaseRadius().inc_rad((inc_rad_location.get(1) %(width/50))*50, (inc_rad_location.get(1) /(width/50))*50 , 50 , 50);
        JLabel inc_rad3 = new IncreaseRadius().inc_rad((inc_rad_location.get(2) %(width/50))*50, (inc_rad_location.get(2) /(width/50))*50 , 50 , 50);


        frame.add(inc_rad1);
        frame.add(inc_rad2);
        frame.add(inc_rad3);


        List<Integer> dec_rad_location = new ArrayList<>();

        dec_rad_location.add(brick_in_map.get(14));
        dec_rad_location.add(brick_in_map.get(15));
        dec_rad_location.add(brick_in_map.get(16));

        JLabel dec_rad1 = new DecreaseRadius().dec_rad((dec_rad_location.get(0) %(width/50))*50, (dec_rad_location.get(0) /(width/50))*50 , 50 , 50);
        JLabel dec_rad2 = new DecreaseRadius().dec_rad((dec_rad_location.get(1) %(width/50))*50, (dec_rad_location.get(1) /(width/50))*50 , 50 , 50);
        JLabel dec_rad3 = new DecreaseRadius().dec_rad((dec_rad_location.get(2) %(width/50))*50, (dec_rad_location.get(2) /(width/50))*50 , 50 , 50);

        frame.add(dec_rad1);
        frame.add(dec_rad2);
        frame.add(dec_rad3);







        List<Integer> inc_bomb_num = new ArrayList<>();

        inc_bomb_num.add(brick_in_map.get(9));
        inc_bomb_num.add(brick_in_map.get(10));
        inc_bomb_num.add(brick_in_map.get(11));


        JLabel inc_bomb_num1 = new IncreaseBombs().inc_bomb_((inc_bomb_num.get(0) %(width/50))*50, (inc_bomb_num.get(0) /(width/50))*50 , 50 , 50);
        JLabel inc_bomb_num2 = new IncreaseBombs().inc_bomb_((inc_bomb_num.get(1) %(width/50))*50, (inc_bomb_num.get(1) /(width/50))*50 , 50 , 50);
        JLabel inc_bomb_num3 = new IncreaseBombs().inc_bomb_((inc_bomb_num.get(2) %(width/50))*50, (inc_bomb_num.get(2) /(width/50))*50 , 50 , 50);


        frame.add(inc_bomb_num1);
        frame.add(inc_bomb_num2);
        frame.add(inc_bomb_num3);







        List<Integer> speed_up = new ArrayList<>();

        speed_up.add(brick_in_map.get(12));
        speed_up.add(brick_in_map.get(13));


        JLabel speed_up1 = new IncreaseSpeed().speed_up((speed_up.get(0) %(width/50))*50, (speed_up.get(0) /(width/50))*50 , 50 , 50);
        JLabel speed_up2 = new IncreaseSpeed().speed_up((speed_up.get(1) %(width/50))*50, (speed_up.get(1) /(width/50))*50 , 50 , 50);

        frame.add(speed_up1);
        frame.add(speed_up2);


        List<Integer> speed_down = new ArrayList<>();

        speed_down.add(brick_in_map.get(17));
        speed_down.add(brick_in_map.get(18));


        JLabel speed_down1 = new DecreaseSpeed().speed_down((speed_down.get(0) %(width/50))*50, (speed_down.get(0) /(width/50))*50 , 50 , 50);
        JLabel speed_down2 = new DecreaseSpeed().speed_down((speed_down.get(1) %(width/50))*50, (speed_down.get(1) /(width/50))*50 , 50 , 50);

        frame.add(speed_down1);
        frame.add(speed_down2);




        List<bomb_fire_on_key> bomb_with_key_control = new ArrayList<>();

        List<Integer> bomb_with_key_location = new ArrayList<>();


        List<Integer> control_of_bomb = new ArrayList<>();
        control_of_bomb.add(brick_in_map.get(19));

        JLabel control = new bomb_controler().control((control_of_bomb.get(0) %(width/50))*50, (control_of_bomb.get(0) /(width/50))*50 , 50 , 50);


        frame.add(control);



        List<Integer> x_location_for_controling_bomb = new ArrayList<>();
        List<Integer> y_location_for_controling_bomb = new ArrayList<>();

        List<Integer> free_place = new ArrayList<>();
        for(int i = 0; i < width * height/2500; i++){
            if(!brick_and_wall.contains(i) & i != 0 & i != 1 & i != width){
                free_place.add(i);

            }
        }



        Collections.shuffle(free_place);






        List<Integer> enemy_1_location = new ArrayList<>();
        enemy_1_location.add(free_place.get(0));
        enemy_1_location.add(free_place.get(1));
        enemy_1_location.add(free_place.get(2));

        List<Integer> enemy_2_location = new ArrayList<>();
        enemy_2_location.add(free_place.get(4));
        enemy_2_location.add(free_place.get(5));
        enemy_2_location.add(free_place.get(6));

        List<Integer> enemy_3_location = new ArrayList<>();
        enemy_3_location.add(free_place.get(7));
        enemy_3_location.add(free_place.get(8));
        enemy_3_location.add(free_place.get(9));

        List<Integer> enemy_4_location = new ArrayList<>();
        enemy_4_location.add(free_place.get(10));
        enemy_4_location.add(free_place.get(11));
        enemy_4_location.add(free_place.get(12));

        List<Integer> lives_for_enemy_1 = new ArrayList<>();
        lives_for_enemy_1.add(1);
        lives_for_enemy_1.add(1);
        lives_for_enemy_1.add(1);

        JLabel person = new player().player_right(0,0,50,50);
        frame.add(person);


        List<Integer> bomb_location = new ArrayList<>();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        System.out.println(level[0]);
        System.out.println(level[0] == 1);





        final int[] remove_enemy1 = {0};



        if((ghost_set.equals("no")) && (speed_enemy == 10) && (directly.equals("no"))) {


            enemy_1 level_1 = new enemy_1();

            level_1.enemy(score,person,enemy_1_location , frame , width , height,  free_place , brick_and_wall , lives_for_enemy_1 , bomb_location , remove_enemy1);
        }

        if ((ghost_set.equals("no")) && (speed_enemy == 10) && (directly.equals("yes"))) {

            lives_for_enemy_1.set(0,1);
            lives_for_enemy_1.set(1,1);
            lives_for_enemy_1.set(2,1);

            enemy_2 level_2 = new enemy_2();
            level_2.enemy(score,person , enemy_1_location , frame , width , height,  free_place , brick_and_wall , lives_for_enemy_1 , bomb_location);

        }

        if ((ghost_set.equals("no")) && (speed_enemy == 20) && (directly.equals("yes"))) {
            lives_for_enemy_1.set(0,1);
            lives_for_enemy_1.set(1,1);
            lives_for_enemy_1.set(2,1);

            enemy_3 level_3 = new enemy_3();
            level_3.enemy(score,person , enemy_1_location , frame , width , height,  free_place , brick_and_wall , lives_for_enemy_1 , bomb_location);

        }

        if((ghost_set.equals("yes"))){
            lives_for_enemy_1.set(0,1);
            lives_for_enemy_1.set(1,1);
            lives_for_enemy_1.set(2,1);

            enemy_4 level_4 = new enemy_4();
            level_4.enemy(score,person , enemy_1_location , frame , width , height,  free_place , brick_and_wall , lives_for_enemy_1 , bomb_location);

        }



        JLabel timer = new JLabel("time");

        final int[] time_remaining = {300};

        person_score.setText(String.valueOf(score[0]));

        frame.add(person_score);
        person_score.setBounds(width - 50 , 0 , 50 , 50);








        frame.add(timer);
        timer.setBounds(50 , 0 , 50 , 50 );

        TestTimer tt = new TestTimer();

        tt.counter(timer , time_remaining , frame , width , height);











        ImageIcon image = new ImageIcon("D:\\University\\Semester8\\AP\\Project_revise\\images\\GameOver\\gameover.png");
        JLabel imageLabel = new JLabel(image);
        imageLabel.setBounds(0, 0, width, height);
        imageLabel.setVisible(true);



        JLabel door = new JLabel(new ImageIcon("D:\\University\\Semester8\\AP\\New folder (2)\\bomberman\\Images\\BomberFireBricks\\22.gif"));

        door.setBounds((brick_in_map.get(20) %(width/50))*50, (brick_in_map.get(20) /(width/50))*50 , 50 , 50);


        frame.add(door);

        System.out.println("Doooooooor");

        System.out.println(brick_in_map.get(20));

        System.out.println("Doooooooor");










        System.out.println("$$$$$$$$$");


        System.out.println(control_of_bomb.get(0));

        System.out.println("$$$$$$$$$");


        List<Integer> bombs_to_remove = new ArrayList<>();

        List<Integer> enemy_lcation = new ArrayList<>();



         printScore sc = new printScore();
         sc.print(person_score , score);






        ///System.out.println(brick_and_wall.size());

        cover.setBackground(Color.green);

        frame.add(cover);

        frame.revalidate();

        for (int i = 0; i<139;i++){
            //System.out.println(brick_and_wall.get(i));
        }

        frame.setVisible(true);

        //level[0] = 11;



        Runnable level_two = new Runnable() {
            public void run() {
                try {
                    while (true) {

                        if(level[0] > 1){

                            level[0] = 2;

                            remove_enemy1[0] = 1;

                            int s = brick.size();
                            for(int i =0 ; i < s ; i++){
                                frame.remove(brick.get(i));
                            }

                            //// person.setBounds(0 , 0 , 50 , 50);

                            frame.remove(g);

                            frame.remove(point1);
                            frame.remove(point2);
                            frame.remove(point3);
                            frame.remove(point4);
                            frame.remove(point5);


                            frame.remove(inc_rad1);
                            frame.remove(inc_rad2);
                            frame.remove(inc_rad3);



                            frame.remove(dec_rad1);
                            frame.remove(dec_rad2);
                            frame.remove(dec_rad3);



                            frame.remove(inc_bomb_num1);
                            frame.remove(inc_bomb_num2);
                            frame.remove(inc_bomb_num3);


                            frame.remove(speed_up1);
                            frame.remove(speed_up2);

                            frame.remove(speed_down1);
                            frame.remove(speed_down2);


                            frame.remove(control);


                            frame.remove(door);




                            //frame.getContentPane().removeAll();

                            bomb_radius[0] = 1;


                            bomb_control[0] = 0;
                            speed[0] = 10;

                            ind_speed[0] = 0;

                            ghost_powerup[0] = 0;


                            frame.add(b1);
                            frame.add(b2);
                            frame.add(b3);
                            frame.add(b4);
                            frame.add(b5);

                            Object_to_add.clear();

                            bombs.clear();

                            bombs.add(bomb_1);
                            bombs.add(bomb_2);
                            bombs.add(bomb_3);
                            bombs.add(bomb_4);
                            bombs.add(bomb_5);

                            /////.
                            BorderLayout kkk_1 = new BorderLayout();
                            frame.setLayout(kkk_1);



/*
                            wall_number.clear();

                            for(int i=0; i< width*height/(100*100);i++){

                                walls[i] = new wall().wall((i%(width/100))*100 + 50 , (i/(width/100))*100 +50 , 50 , 50);
                                frame.add(walls[i]);

                            }
*/
                            brick_num.clear();

                            for(int i = 0; i < width*height/(50*50);i++){

                                if((((i) / (width/50))%2 == 0  | ((i) % (width/50))%2 == 0)){

                                    brick_num.add(i);
                                }

                                else {
                                    wall_number.add(i);
                                }

                            }
                            brick_num.remove(width/50);
                            brick_num.remove(1);
                            brick_num.remove(0);


                            Collections.shuffle(brick_num);

                            brick.clear();

                            brick_and_wall.clear();

                            brick_and_wall.addAll(wall_number);


                            brick_in_map.clear();



                            for (int i = 0 ; i < brick_num.size()/4;i++){
                                JLabel x = new brick().brick((brick_num.get(i)%(width/50))*50, (brick_num.get(i)/(width/50))*50 , 50 , 50);
                                frame.add(x);
                                brick.add(x);
                                brick_and_wall.add(brick_num.get(i));
                                brick_in_map.add(brick_num.get(i));

                            }


                            Collections.shuffle(brick_in_map);

                            ghost_location[0] = brick_in_map.get(0);

                            JLabel g = new Ghost().ghost((ghost_location[0] %(width/50))*50, (ghost_location[0] /(width/50))*50 , 50 , 50);
                            frame.add(g);

                            points_location.clear();

                            points_location.add(brick_in_map.get(1));
                            points_location.add(brick_in_map.get(2));
                            points_location.add(brick_in_map.get(3));
                            points_location.add(brick_in_map.get(4));
                            points_location.add(brick_in_map.get(5));

                            JLabel point1 = new IncreasePoints().point((points_location.get(0) %(width/50))*50, (points_location.get(0) /(width/50))*50 , 50 , 50);
                            JLabel point2 = new IncreasePoints().point((points_location.get(1) %(width/50))*50, (points_location.get(1) /(width/50))*50 , 50 , 50);
                            JLabel point3 = new IncreasePoints().point((points_location.get(2) %(width/50))*50, (points_location.get(2) /(width/50))*50 , 50 , 50);
                            JLabel point4 = new IncreasePoints().point((points_location.get(3) %(width/50))*50, (points_location.get(3) /(width/50))*50 , 50 , 50);
                            JLabel point5 = new IncreasePoints().point((points_location.get(4) %(width/50))*50, (points_location.get(4) /(width/50))*50 , 50 , 50);

                            frame.add(point1);
                            frame.add(point2);
                            frame.add(point3);
                            frame.add(point4);
                            frame.add(point5);





                            inc_rad_location.clear();

                            inc_rad_location.add(brick_in_map.get(6));
                            inc_rad_location.add(brick_in_map.get(7));
                            inc_rad_location.add(brick_in_map.get(8));


                            JLabel inc_rad1 = new IncreaseRadius().inc_rad((inc_rad_location.get(0) %(width/50))*50, (inc_rad_location.get(0) /(width/50))*50 , 50 , 50);
                            JLabel inc_rad2 = new IncreaseRadius().inc_rad((inc_rad_location.get(1) %(width/50))*50, (inc_rad_location.get(1) /(width/50))*50 , 50 , 50);
                            JLabel inc_rad3 = new IncreaseRadius().inc_rad((inc_rad_location.get(2) %(width/50))*50, (inc_rad_location.get(2) /(width/50))*50 , 50 , 50);


                            frame.add(inc_rad1);
                            frame.add(inc_rad2);
                            frame.add(inc_rad3);


                            dec_rad_location.clear();

                            dec_rad_location.add(brick_in_map.get(14));
                            dec_rad_location.add(brick_in_map.get(15));
                            dec_rad_location.add(brick_in_map.get(16));

                            JLabel dec_rad1 = new DecreaseRadius().dec_rad((dec_rad_location.get(0) %(width/50))*50, (dec_rad_location.get(0) /(width/50))*50 , 50 , 50);
                            JLabel dec_rad2 = new DecreaseRadius().dec_rad((dec_rad_location.get(1) %(width/50))*50, (dec_rad_location.get(1) /(width/50))*50 , 50 , 50);
                            JLabel dec_rad3 = new DecreaseRadius().dec_rad((dec_rad_location.get(2) %(width/50))*50, (dec_rad_location.get(2) /(width/50))*50 , 50 , 50);

                            frame.add(dec_rad1);
                            frame.add(dec_rad2);
                            frame.add(dec_rad3);







                            inc_bomb_num.clear();

                            inc_bomb_num.add(brick_in_map.get(9));
                            inc_bomb_num.add(brick_in_map.get(10));
                            inc_bomb_num.add(brick_in_map.get(11));


                            JLabel inc_bomb_num1 = new IncreaseBombs().inc_bomb_((inc_bomb_num.get(0) %(width/50))*50, (inc_bomb_num.get(0) /(width/50))*50 , 50 , 50);
                            JLabel inc_bomb_num2 = new IncreaseBombs().inc_bomb_((inc_bomb_num.get(1) %(width/50))*50, (inc_bomb_num.get(1) /(width/50))*50 , 50 , 50);
                            JLabel inc_bomb_num3 = new IncreaseBombs().inc_bomb_((inc_bomb_num.get(2) %(width/50))*50, (inc_bomb_num.get(2) /(width/50))*50 , 50 , 50);


                            frame.add(inc_bomb_num1);
                            frame.add(inc_bomb_num2);
                            frame.add(inc_bomb_num3);





                            speed_up.clear();

                            speed_up.add(brick_in_map.get(12));
                            speed_up.add(brick_in_map.get(13));


                            JLabel speed_up1 = new IncreaseSpeed().speed_up((speed_up.get(0) %(width/50))*50, (speed_up.get(0) /(width/50))*50 , 50 , 50);
                            JLabel speed_up2 = new IncreaseSpeed().speed_up((speed_up.get(1) %(width/50))*50, (speed_up.get(1) /(width/50))*50 , 50 , 50);

                            frame.add(speed_up1);
                            frame.add(speed_up2);


                            speed_down.clear();

                            speed_down.add(brick_in_map.get(17));
                            speed_down.add(brick_in_map.get(18));


                            JLabel speed_down1 = new DecreaseSpeed().speed_down((speed_down.get(0) %(width/50))*50, (speed_down.get(0) /(width/50))*50 , 50 , 50);
                            JLabel speed_down2 = new DecreaseSpeed().speed_down((speed_down.get(1) %(width/50))*50, (speed_down.get(1) /(width/50))*50 , 50 , 50);

                            frame.add(speed_down1);
                            frame.add(speed_down2);




                            bomb_with_key_control.clear();

                            bomb_with_key_location.clear();


                            control_of_bomb.clear();
                            control_of_bomb.add(brick_in_map.get(19));

                            JLabel control = new bomb_controler().control((control_of_bomb.get(0) %(width/50))*50, (control_of_bomb.get(0) /(width/50))*50 , 50 , 50);


                            frame.add(control);



                            x_location_for_controling_bomb.clear();
                            y_location_for_controling_bomb.clear();

                            free_place.clear();
                            for(int i = 0; i < width * height/2500; i++){
                                if(!brick_and_wall.contains(i) & i != 0 & i != 1 & i != width){
                                    free_place.add(i);

                                }
                            }



                            Collections.shuffle(free_place);






                            enemy_1_location.clear();
                            enemy_1_location.add(free_place.get(0));
                            enemy_1_location.add(free_place.get(1));
                            enemy_1_location.add(free_place.get(2));

                            lives_for_enemy_1.clear();
                            lives_for_enemy_1.add(1);
                            lives_for_enemy_1.add(1);
                            lives_for_enemy_1.add(1);

                            bomb_location.clear();

                            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                            enemy_2 level_2 = new enemy_2();
                            level_2.enemy(score,person , enemy_1_location , frame , width , height,  free_place , brick_and_wall , lives_for_enemy_1 , bomb_location);

                            time_remaining[0] = 300;


                            tt.counter(timer , time_remaining , frame , width , height);











                            ImageIcon image = new ImageIcon("D:\\University\\Semester8\\AP\\Project_revise\\images\\GameOver\\gameover.png");
                            JLabel imageLabel = new JLabel(image);
                            imageLabel.setBounds(0, 0, width, height);
                            imageLabel.setVisible(true);



                            JLabel door = new JLabel(new ImageIcon("D:\\University\\Semester8\\AP\\New folder (2)\\bomberman\\Images\\BomberFireBricks\\22.gif"));

                            door.setBounds((brick_in_map.get(20) %(width/50))*50, (brick_in_map.get(20) /(width/50))*50 , 50 , 50);


                            frame.add(door);

                            System.out.println("Doooooooor");

                            System.out.println(brick_in_map.get(20));

                            System.out.println("Doooooooor");










                            System.out.println("$$$$$$$$$");


                            System.out.println(control_of_bomb.get(0));

                            System.out.println("$$$$$$$$$");



                            printScore sc = new printScore();
                            sc.print(person_score , score);






                            ///System.out.println(brick_and_wall.size());

                            cover.setBackground(Color.green);

                            frame.add(cover);

                            frame.revalidate();

                            for (int i = 0; i<139;i++){
                                //System.out.println(brick_and_wall.get(i));
                            }


                            frame.revalidate();
                            frame.repaint();
                            frame.setVisible(true);

                            Thread.sleep(1000);

                            break;

                        }







                        Thread.sleep(5000L);
                    }
                } catch (InterruptedException iex) {}
            }
        };

        Thread l_1 = new Thread(level_two);

        l_1.start();








                        //public void processKeys() {
            KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(


                    new KeyEventDispatcher() {
                        public boolean dispatchKeyEvent(KeyEvent e) {
                            if (e.getID() == KeyEvent.KEY_PRESSED) {

                                Point k;
                                k = new handleKeyPress().handleKeyPress(e.getKeyCode() , speed);

                                //System.out.println(person.getLocation());

                                int c_x;

                                int c_y;

                                c_x = person.getLocation().x;

                                c_y = person.getLocation().y;

                                if (k.x == 10 | k.x == 20 | k.x == 40) {

                                    if(ghost_powerup[0] == 0){

                                        if ((c_y % 100) == 0) {

                                            int t_x = c_x + 50;

                                            int t_y = c_y;
                                            //System.out.println((width/50) * (t_y / 50) + t_x / 50);



                                            if (!brick_and_wall.contains((width/50) * (t_y / 50) + t_x / 50)) {

                                                person.setBounds(c_x + k.x, c_y - k.y, 50, 50);

                                                person.setIcon(new ImageIcon("D:/University/Semester8/AP/New folder (2)/project/Images/Bombermans/Player 1/31.gif"));


                                                if (((enemy_1_location.get(0) == (width/50) * (t_y / 50) + t_x / 50) & (lives_for_enemy_1.get(0) == 1)) | ((enemy_1_location.get(1) == (width/50) * (t_y / 50) + t_x / 50) & (lives_for_enemy_1.get(1) == 1)) | ((enemy_1_location.get(2) == (width/50) * (t_y / 50) + t_x / 50) & (lives_for_enemy_1.get(2) == 1))){

                                                    frame.getContentPane().removeAll();
                                                    frame.setContentPane(imageLabel);

                                                }


                                                if(ghost_location[0] == (width/50) * (t_y / 50) + t_x / 50){
                                                    ghost_location[0] = ghost_location[0] + 10000000;
                                                    g.setBounds(1000000000,100000000,50,50);
                                                    ghost_powerup[0] = ghost_powerup[0] + 1;

                                                }


                                                if(brick_in_map.get(20) == (width/50) * (t_y / 50) + t_x / 50){
                                                    if(lives_for_enemy_1.get(0) == 0 & lives_for_enemy_1.get(1) == 0 & lives_for_enemy_1.get(2) == 0){

                                                        level[0] = level[0] + 1;
                                                        System.out.println(level[0]);


                                                    }

                                                }


                                                if(control_of_bomb.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    control_of_bomb.set(0, 100000000);
                                                    control.setBounds(100002200, 144000000, 50, 50);
                                                    bomb_control[0] = bomb_control[0] + 1;

                                                }

                                                if(points_location.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    points_location.set(0, 100000000);
                                                    point1.setBounds(100002200, 144000000, 50, 50);
                                                    score[0] = score[0] + 100;
                                                    person_score.setText(String.valueOf(score[0]));

                                                }
                                                if(points_location.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    points_location.set(1, 100000000);
                                                    point2.setBounds(10000000, 100200000, 50, 50);
                                                    score[0] = score[0] + 100;
                                                    person_score.setText(String.valueOf(score[0]));

                                                }
                                                if(points_location.get(2) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    points_location.set(2, 100000000);
                                                    point3.setBounds(1000000, 100200000, 50, 50);
                                                    score[0] = score[0] + 100;
                                                    person_score.setText(String.valueOf(score[0]));

                                                }
                                                if(points_location.get(3) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    points_location.set(3, 100000000);
                                                    point4.setBounds(400000000, 100000000, 50, 50);
                                                    score[0] = score[0] + 100;
                                                    person_score.setText(String.valueOf(score[0]));

                                                }
                                                if(points_location.get(4) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    points_location.set(4, 100000000);
                                                    point5.setBounds(50000000, 10000000, 50, 50);
                                                    score[0] = score[0] + 100;
                                                    person_score.setText(String.valueOf(score[0]));

                                                }













                                                if(inc_rad_location.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    inc_rad_location.set(0, 100000000);
                                                    inc_rad1.setBounds(100002200, 144000000, 50, 50);
                                                    bomb_radius[0] = bomb_radius[0] + 1;

                                                }

                                                if(inc_rad_location.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    inc_rad_location.set(1, 100000000);
                                                    inc_rad2.setBounds(100002200, 144000000, 50, 50);
                                                    bomb_radius[0] = bomb_radius[0] + 1;

                                                }

                                                if(inc_rad_location.get(2) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    inc_rad_location.set(2, 100000000);
                                                    inc_rad3.setBounds(100002200, 144000000, 50, 50);
                                                    bomb_radius[0] = bomb_radius[0] + 1;

                                                }


                                                if(dec_rad_location.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    dec_rad_location.set(0, 100000000);
                                                    dec_rad1.setBounds(100002200, 144000000, 50, 50);
                                                    if(bomb_radius[0] > 1){
                                                        bomb_radius[0] = bomb_radius[0] - 1;
                                                    }
                                                }
                                                if(dec_rad_location.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    dec_rad_location.set(1, 100000000);
                                                    dec_rad2.setBounds(100002200, 144000000, 50, 50);
                                                    if(bomb_radius[0] > 1){
                                                        bomb_radius[0] = bomb_radius[0] - 1;
                                                    }
                                                }
                                                if(dec_rad_location.get(2) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    dec_rad_location.set(2, 100000000);
                                                    dec_rad3.setBounds(100002200, 144000000, 50, 50);
                                                    if(bomb_radius[0] > 1){
                                                        bomb_radius[0] = bomb_radius[0] - 1;
                                                    }
                                                }









                                                if(inc_bomb_num.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    inc_bomb_num.set(0, 100000000);
                                                    inc_bomb_num1.setBounds(100002200, 144000000, 50, 50);
                                                    bomb_number[0] = bomb_number[0] + 1;

                                                }
                                                if(inc_bomb_num.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    inc_bomb_num.set(1, 100000000);
                                                    inc_bomb_num2.setBounds(100002200, 144000000, 50, 50);
                                                    bomb_number[0] = bomb_number[0] + 1;

                                                }
                                                if(inc_bomb_num.get(2) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    inc_bomb_num.set(2, 100000000);
                                                    inc_bomb_num3.setBounds(100002200, 144000000, 50, 50);
                                                    bomb_number[0] = bomb_number[0] + 1;

                                                }








                                                if(speed_up.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    ind_speed[0] = ind_speed[0] + 1;
                                                    speed_up.set(0, 100000000);
                                                    speed_up1.setBounds(100002200, 144000000, 50, 50);
                                                    speed[0] = possible_speed.get(ind_speed[0]);

                                                }

                                                if(speed_up.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    ind_speed[0] = ind_speed[0] + 1;
                                                    speed_up.set(1, 100000000);
                                                    speed_up2.setBounds(100002200, 144000000, 50, 50);
                                                    speed[0] = possible_speed.get(ind_speed[0]);

                                                }


                                                if(speed_down.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    if(ind_speed[0] > 0){
                                                        ind_speed[0] = ind_speed[0] - 1;
                                                    }
                                                    speed_down.set(0, 100000000);
                                                    speed_down1.setBounds(100002200, 144000000, 50, 50);
                                                    speed[0] = possible_speed.get(ind_speed[0]);

                                                }

                                                if(speed_down.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    if(ind_speed[0] > 0){
                                                        ind_speed[0] = ind_speed[0] - 1;
                                                    }
                                                    speed_down.set(1, 100000000);
                                                    speed_down2.setBounds(100002200, 144000000, 50, 50);
                                                    speed[0] = possible_speed.get(ind_speed[0]);

                                                }
















                                            }

                                            if (((width/50) * (t_y / 50) + t_x / 50) == 1 | ((width/50) * (t_y / 50) + t_x / 50) == (width/50) | ((width/50) * (t_y / 50) + t_x / 50) == 0) {

                                                person.setBounds(c_x + k.x, c_y - k.y, 50, 50);
                                                person.setIcon(new ImageIcon("D:/University/Semester8/AP/New folder (2)/project/Images/Bombermans/Player 1/31.gif"));

                                            }


                                        }


                                    }


                                    if(ghost_powerup[0] == 1){

                                        int t_x = c_x + 50;

                                        int t_y = c_y;

                                        if (((width/50) * (t_y / 50) + t_x / 50) == 1 | ((width/50) * (t_y / 50) + t_x / 50) == (width/50) | ((width/50) * (t_y / 50) + t_x / 50) == 0) {

                                            person.setBounds(c_x + k.x, c_y - k.y, 50, 50);
                                            person.setIcon(new ImageIcon("D:/University/Semester8/AP/New folder (2)/project/Images/Bombermans/Player 1/31.gif"));

                                        }


                                        person.setBounds(c_x + k.x, c_y - k.y, 50, 50);

                                        person.setIcon(new ImageIcon("D:/University/Semester8/AP/New folder (2)/project/Images/Bombermans/Player 1/31.gif"));

                                        if(ghost_location[0] == (width/50) * (t_y / 50) + t_x / 50){
                                            ghost_location[0] = ghost_location[0] + 10000000;
                                            g.setBounds(1000000000,100000000,50,50);
                                            ghost_powerup[0] = ghost_powerup[0] + 1;

                                        }

                                        if(brick_in_map.get(20) == (width/50) * (t_y / 50) + t_x / 50){
                                            if(lives_for_enemy_1.get(0) == 0 & lives_for_enemy_1.get(1) == 0 & lives_for_enemy_1.get(2) == 0){

                                                level[0] = level[0] + 1;
                                                System.out.println(level[0]);


                                            }

                                        }

                                        if (enemy_1_location.contains((width/50) * (t_y / 50) + t_x / 50)){

                                            frame.getContentPane().removeAll();
                                            frame.setContentPane(imageLabel);

                                        }

                                        if(control_of_bomb.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                            control_of_bomb.set(0, 100000000);
                                            control.setBounds(100002200, 144000000, 50, 50);
                                            bomb_control[0] = bomb_control[0] + 1;

                                        }

                                        if(points_location.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                            points_location.set(0, 100000000);
                                            point1.setBounds(100002200, 144000000, 50, 50);
                                            score[0] = score[0] + 100;
                                            person_score.setText(String.valueOf(score[0]));

                                        }
                                        if(points_location.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                            points_location.set(1, 100000000);
                                            point2.setBounds(10000000, 100200000, 50, 50);
                                            score[0] = score[0] + 100;
                                            person_score.setText(String.valueOf(score[0]));

                                        }
                                        if(points_location.get(2) == (width/50) * (t_y / 50) + t_x / 50) {
                                            points_location.set(2, 100000000);
                                            point3.setBounds(1000000, 100200000, 50, 50);
                                            score[0] = score[0] + 100;
                                            person_score.setText(String.valueOf(score[0]));

                                        }
                                        if(points_location.get(3) == (width/50) * (t_y / 50) + t_x / 50) {
                                            points_location.set(3, 100000000);
                                            point4.setBounds(400000000, 100000000, 50, 50);
                                            score[0] = score[0] + 100;
                                            person_score.setText(String.valueOf(score[0]));

                                        }
                                        if(points_location.get(4) == (width/50) * (t_y / 50) + t_x / 50) {
                                            points_location.set(4, 100000000);
                                            point5.setBounds(50000000, 10000000, 50, 50);
                                            score[0] = score[0] + 100;
                                            person_score.setText(String.valueOf(score[0]));

                                        }













                                        if(inc_rad_location.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                            inc_rad_location.set(0, 100000000);
                                            inc_rad1.setBounds(100002200, 144000000, 50, 50);
                                            bomb_radius[0] = bomb_radius[0] + 1;

                                        }

                                        if(inc_rad_location.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                            inc_rad_location.set(1, 100000000);
                                            inc_rad2.setBounds(100002200, 144000000, 50, 50);
                                            bomb_radius[0] = bomb_radius[0] + 1;

                                        }

                                        if(inc_rad_location.get(2) == (width/50) * (t_y / 50) + t_x / 50) {
                                            inc_rad_location.set(2, 100000000);
                                            inc_rad3.setBounds(100002200, 144000000, 50, 50);
                                            bomb_radius[0] = bomb_radius[0] + 1;

                                        }


                                        if(dec_rad_location.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                            dec_rad_location.set(0, 100000000);
                                            dec_rad1.setBounds(100002200, 144000000, 50, 50);
                                            if(bomb_radius[0] > 1){
                                                bomb_radius[0] = bomb_radius[0] - 1;
                                            }
                                        }
                                        if(dec_rad_location.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                            dec_rad_location.set(1, 100000000);
                                            dec_rad2.setBounds(100002200, 144000000, 50, 50);
                                            if(bomb_radius[0] > 1){
                                                bomb_radius[0] = bomb_radius[0] - 1;
                                            }
                                        }
                                        if(dec_rad_location.get(2) == (width/50) * (t_y / 50) + t_x / 50) {
                                            dec_rad_location.set(2, 100000000);
                                            dec_rad3.setBounds(100002200, 144000000, 50, 50);
                                            if(bomb_radius[0] > 1){
                                                bomb_radius[0] = bomb_radius[0] - 1;
                                            }
                                        }









                                        if(inc_bomb_num.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                            inc_bomb_num.set(0, 100000000);
                                            inc_bomb_num1.setBounds(100002200, 144000000, 50, 50);
                                            bomb_number[0] = bomb_number[0] + 1;

                                        }
                                        if(inc_bomb_num.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                            inc_bomb_num.set(1, 100000000);
                                            inc_bomb_num2.setBounds(100002200, 144000000, 50, 50);
                                            bomb_number[0] = bomb_number[0] + 1;

                                        }
                                        if(inc_bomb_num.get(2) == (width/50) * (t_y / 50) + t_x / 50) {
                                            inc_bomb_num.set(2, 100000000);
                                            inc_bomb_num3.setBounds(100002200, 144000000, 50, 50);
                                            bomb_number[0] = bomb_number[0] + 1;

                                        }








                                        if(speed_up.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                            ind_speed[0] = ind_speed[0] + 1;
                                            speed_up.set(0, 100000000);
                                            speed_up1.setBounds(100002200, 144000000, 50, 50);
                                            speed[0] = possible_speed.get(ind_speed[0]);

                                        }

                                        if(speed_up.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                            ind_speed[0] = ind_speed[0] + 1;
                                            speed_up.set(1, 100000000);
                                            speed_up2.setBounds(100002200, 144000000, 50, 50);
                                            speed[0] = possible_speed.get(ind_speed[0]);

                                        }


                                        if(speed_down.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                            if(ind_speed[0] > 0){
                                                ind_speed[0] = ind_speed[0] - 1;
                                            }
                                            speed_down.set(0, 100000000);
                                            speed_down1.setBounds(100002200, 144000000, 50, 50);
                                            speed[0] = possible_speed.get(ind_speed[0]);

                                        }

                                        if(speed_down.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                            if(ind_speed[0] > 0){
                                                ind_speed[0] = ind_speed[0] - 1;
                                            }
                                            speed_down.set(1, 100000000);
                                            speed_down2.setBounds(100002200, 144000000, 50, 50);
                                            speed[0] = possible_speed.get(ind_speed[0]);

                                        }







                                    }


                            }

                                if (k.x == -10 | k.x == -20 | k.x == -40) {


                                    if(ghost_powerup[0] == 0){

                                        if ((c_y % 100) == 0) {

                                            int t_x = c_x-5;

                                            int t_y = c_y;

                                            if (!brick_and_wall.contains((width/50) * (t_y / 50) + t_x / 50)) {

                                                person.setBounds(c_x + k.x, c_y - k.y, 50, 50);
                                                person.setIcon(new ImageIcon("D:/University/Semester8/AP/New folder (2)/project/Images/Bombermans/Player 1/21.gif"));
                                                if(ghost_location[0] == (width/50) * (t_y / 50) + t_x / 50){
                                                    ghost_location[0] = ghost_location[0] + 10000000;
                                                    g.setBounds(1000000000,100000000,50,50);
                                                    ghost_powerup[0] = ghost_powerup[0] + 1;

                                                }

                                                if (((enemy_1_location.get(0) == (width/50) * (t_y / 50) + t_x / 50) & (lives_for_enemy_1.get(0) == 1)) | ((enemy_1_location.get(1) == (width/50) * (t_y / 50) + t_x / 50) & (lives_for_enemy_1.get(1) == 1)) | ((enemy_1_location.get(2) == (width/50) * (t_y / 50) + t_x / 50) & (lives_for_enemy_1.get(2) == 1))){

                                                    frame.getContentPane().removeAll();
                                                    frame.setContentPane(imageLabel);

                                                }

                                                if(brick_in_map.get(20) == (width/50) * (t_y / 50) + t_x / 50){
                                                    if(lives_for_enemy_1.get(0) == 0 & lives_for_enemy_1.get(1) == 0 & lives_for_enemy_1.get(2) == 0){

                                                        level[0] = level[0] + 1;
                                                        System.out.println(level[1]);


                                                    }

                                                }

                                                if(control_of_bomb.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    control_of_bomb.set(0, 100000000);
                                                    control.setBounds(100002200, 144000000, 50, 50);
                                                    bomb_control[0] = bomb_control[0] + 1;

                                                }



                                                if(points_location.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    points_location.set(0, 100000000);
                                                    point1.setBounds(100002200, 144000000, 50, 50);
                                                    score[0] = score[0] + 100;
                                                    person_score.setText(String.valueOf(score[0]));

                                                }
                                                if(points_location.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    points_location.set(1, 100000000);
                                                    point2.setBounds(10000000, 100200000, 50, 50);
                                                    score[0] = score[0] + 100;
                                                    person_score.setText(String.valueOf(score[0]));

                                                }
                                                if(points_location.get(2) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    points_location.set(2, 100000000);
                                                    point3.setBounds(1000000, 100200000, 50, 50);
                                                    score[0] = score[0] + 100;
                                                    person_score.setText(String.valueOf(score[0]));

                                                }
                                                if(points_location.get(3) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    points_location.set(3, 100000000);
                                                    point4.setBounds(400000000, 100000000, 50, 50);
                                                    score[0] = score[0] + 100;
                                                    person_score.setText(String.valueOf(score[0]));

                                                }
                                                if(points_location.get(4) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    points_location.set(4, 100000000);
                                                    point5.setBounds(50000000, 10000000, 50, 50);
                                                    score[0] = score[0] + 100;
                                                    person_score.setText(String.valueOf(score[0]));

                                                }


















                                                if(inc_rad_location.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    inc_rad_location.set(0, 100000000);
                                                    inc_rad1.setBounds(100002200, 144000000, 50, 50);
                                                    bomb_radius[0] = bomb_radius[0] + 1;

                                                }

                                                if(inc_rad_location.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    inc_rad_location.set(1, 100000000);
                                                    inc_rad2.setBounds(100002200, 144000000, 50, 50);
                                                    bomb_radius[0] = bomb_radius[0] + 1;

                                                }

                                                if(inc_rad_location.get(2) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    inc_rad_location.set(2, 100000000);
                                                    inc_rad3.setBounds(100002200, 144000000, 50, 50);
                                                    bomb_radius[0] = bomb_radius[0] + 1;

                                                }
                                                if(dec_rad_location.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    dec_rad_location.set(0, 100000000);
                                                    dec_rad1.setBounds(100002200, 144000000, 50, 50);
                                                    if(bomb_radius[0] > 1){
                                                        bomb_radius[0] = bomb_radius[0] - 1;
                                                    }
                                                }
                                                if(dec_rad_location.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    dec_rad_location.set(1, 100000000);
                                                    dec_rad2.setBounds(100002200, 144000000, 50, 50);
                                                    if(bomb_radius[0] > 1){
                                                        bomb_radius[0] = bomb_radius[0] - 1;
                                                    }
                                                }
                                                if(dec_rad_location.get(2) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    dec_rad_location.set(2, 100000000);
                                                    dec_rad3.setBounds(100002200, 144000000, 50, 50);
                                                    if(bomb_radius[0] > 1){
                                                        bomb_radius[0] = bomb_radius[0] - 1;
                                                    }
                                                }








                                                if(inc_bomb_num.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    inc_bomb_num.set(0, 100000000);
                                                    inc_bomb_num1.setBounds(100002200, 144000000, 50, 50);
                                                    bomb_number[0] = bomb_number[0] + 1;

                                                }
                                                if(inc_bomb_num.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    inc_bomb_num.set(1, 100000000);
                                                    inc_bomb_num2.setBounds(100002200, 144000000, 50, 50);
                                                    bomb_number[0] = bomb_number[0] + 1;

                                                }
                                                if(inc_bomb_num.get(2) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    inc_bomb_num.set(2, 100000000);
                                                    inc_bomb_num3.setBounds(100002200, 144000000, 50, 50);
                                                    bomb_number[0] = bomb_number[0] + 1;

                                                }








                                                if(speed_up.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    ind_speed[0] = ind_speed[0] + 1;
                                                    speed_up.set(0, 100000000);
                                                    speed_up1.setBounds(100002200, 144000000, 50, 50);
                                                    speed[0] = possible_speed.get(ind_speed[0]);

                                                }

                                                if(speed_up.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    ind_speed[0] = ind_speed[0] + 1;
                                                    speed_up.set(1, 100000000);
                                                    speed_up2.setBounds(100002200, 144000000, 50, 50);
                                                    speed[0] = possible_speed.get(ind_speed[0]);

                                                }



                                                if(speed_down.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    if(ind_speed[0] > 0){
                                                        ind_speed[0] = ind_speed[0] - 1;
                                                    }
                                                    speed_down.set(0, 100000000);
                                                    speed_down1.setBounds(100002200, 144000000, 50, 50);
                                                    speed[0] = possible_speed.get(ind_speed[0]);

                                                }

                                                if(speed_down.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    if(ind_speed[0] > 0){
                                                        ind_speed[0] = ind_speed[0] - 1;
                                                    }
                                                    speed_down.set(1, 100000000);
                                                    speed_down2.setBounds(100002200, 144000000, 50, 50);
                                                    speed[0] = possible_speed.get(ind_speed[0]);

                                                }







                                            }

                                            if (((width/50) * (t_y / 50) + t_x / 50) == 1 | ((width/50) * (t_y / 50) + t_x / 50) == (width/50) | ((width/50) * (t_y / 50) + t_x / 50) == 0) {

                                                person.setBounds(c_x + k.x, c_y - k.y, 50, 50);
                                                person.setIcon(new ImageIcon("D:/University/Semester8/AP/New folder (2)/project/Images/Bombermans/Player 1/21.gif"));

                                            }


                                        }

                                    }

                                    if(ghost_powerup[0] == 1){

                                        int t_x = c_x;

                                        int t_y = c_y;

                                        if (((width/50) * (t_y / 50) + t_x / 50) == 1 | ((width/50) * (t_y / 50) + t_x / 50) == (width/50) | ((width/50) * (t_y / 50) + t_x / 50) == 0) {

                                            person.setBounds(c_x + k.x, c_y - k.y, 50, 50);
                                            person.setIcon(new ImageIcon("D:/University/Semester8/AP/New folder (2)/project/Images/Bombermans/Player 1/21.gif"));

                                        }

                                        person.setBounds(c_x + k.x, c_y - k.y, 50, 50);
                                        person.setIcon(new ImageIcon("D:/University/Semester8/AP/New folder (2)/project/Images/Bombermans/Player 1/21.gif"));
                                        if(ghost_location[0] == (width/50) * (t_y / 50) + t_x / 50){
                                            ghost_location[0] = ghost_location[0] + 10000000;
                                            g.setBounds(1000000000,100000000,50,50);
                                            ghost_powerup[0] = ghost_powerup[0] + 1;

                                        }

                                        if (enemy_1_location.contains((width/50) * (t_y / 50) + t_x / 50)){

                                            frame.getContentPane().removeAll();
                                            frame.setContentPane(imageLabel);

                                        }


                                        if(control_of_bomb.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                            control_of_bomb.set(0, 100000000);
                                            control.setBounds(100002200, 144000000, 50, 50);
                                            bomb_control[0] = bomb_control[0] + 1;

                                        }

                                        if(brick_in_map.get(20) == (width/50) * (t_y / 50) + t_x / 50){
                                            if(lives_for_enemy_1.get(0) == 0 & lives_for_enemy_1.get(1) == 0 & lives_for_enemy_1.get(2) == 0){

                                                level[0] = level[0] + 1;
                                                System.out.println(level[0]);


                                            }

                                        }


                                        if(points_location.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                            points_location.set(0, 100000000);
                                            point1.setBounds(100002200, 144000000, 50, 50);
                                            score[0] = score[0] + 100;
                                            person_score.setText(String.valueOf(score[0]));

                                        }
                                        if(points_location.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                            points_location.set(1, 100000000);
                                            point2.setBounds(10000000, 100200000, 50, 50);
                                            score[0] = score[0] + 100;
                                            person_score.setText(String.valueOf(score[0]));

                                        }
                                        if(points_location.get(2) == (width/50) * (t_y / 50) + t_x / 50) {
                                            points_location.set(2, 100000000);
                                            point3.setBounds(1000000, 100200000, 50, 50);
                                            score[0] = score[0] + 100;
                                            person_score.setText(String.valueOf(score[0]));

                                        }
                                        if(points_location.get(3) == (width/50) * (t_y / 50) + t_x / 50) {
                                            points_location.set(3, 100000000);
                                            point4.setBounds(400000000, 100000000, 50, 50);
                                            score[0] = score[0] + 100;
                                            person_score.setText(String.valueOf(score[0]));

                                        }
                                        if(points_location.get(4) == (width/50) * (t_y / 50) + t_x / 50) {
                                            points_location.set(4, 100000000);
                                            point5.setBounds(50000000, 10000000, 50, 50);
                                            score[0] = score[0] + 100;
                                            person_score.setText(String.valueOf(score[0]));

                                        }


















                                        if(inc_rad_location.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                            inc_rad_location.set(0, 100000000);
                                            inc_rad1.setBounds(100002200, 144000000, 50, 50);
                                            bomb_radius[0] = bomb_radius[0] + 1;

                                        }

                                        if(inc_rad_location.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                            inc_rad_location.set(1, 100000000);
                                            inc_rad2.setBounds(100002200, 144000000, 50, 50);
                                            bomb_radius[0] = bomb_radius[0] + 1;

                                        }

                                        if(inc_rad_location.get(2) == (width/50) * (t_y / 50) + t_x / 50) {
                                            inc_rad_location.set(2, 100000000);
                                            inc_rad3.setBounds(100002200, 144000000, 50, 50);
                                            bomb_radius[0] = bomb_radius[0] + 1;

                                        }
                                        if(dec_rad_location.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                            dec_rad_location.set(0, 100000000);
                                            dec_rad1.setBounds(100002200, 144000000, 50, 50);
                                            if(bomb_radius[0] > 1){
                                                bomb_radius[0] = bomb_radius[0] - 1;
                                            }
                                        }
                                        if(dec_rad_location.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                            dec_rad_location.set(1, 100000000);
                                            dec_rad2.setBounds(100002200, 144000000, 50, 50);
                                            if(bomb_radius[0] > 1){
                                                bomb_radius[0] = bomb_radius[0] - 1;
                                            }
                                        }
                                        if(dec_rad_location.get(2) == (width/50) * (t_y / 50) + t_x / 50) {
                                            dec_rad_location.set(2, 100000000);
                                            dec_rad3.setBounds(100002200, 144000000, 50, 50);
                                            if(bomb_radius[0] > 1){
                                                bomb_radius[0] = bomb_radius[0] - 1;
                                            }
                                        }








                                        if(inc_bomb_num.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                            inc_bomb_num.set(0, 100000000);
                                            inc_bomb_num1.setBounds(100002200, 144000000, 50, 50);
                                            bomb_number[0] = bomb_number[0] + 1;

                                        }
                                        if(inc_bomb_num.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                            inc_bomb_num.set(1, 100000000);
                                            inc_bomb_num2.setBounds(100002200, 144000000, 50, 50);
                                            bomb_number[0] = bomb_number[0] + 1;

                                        }
                                        if(inc_bomb_num.get(2) == (width/50) * (t_y / 50) + t_x / 50) {
                                            inc_bomb_num.set(2, 100000000);
                                            inc_bomb_num3.setBounds(100002200, 144000000, 50, 50);
                                            bomb_number[0] = bomb_number[0] + 1;

                                        }








                                        if(speed_up.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                            ind_speed[0] = ind_speed[0] + 1;
                                            speed_up.set(0, 100000000);
                                            speed_up1.setBounds(100002200, 144000000, 50, 50);
                                            speed[0] = possible_speed.get(ind_speed[0]);

                                        }

                                        if(speed_up.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                            ind_speed[0] = ind_speed[0] + 1;
                                            speed_up.set(1, 100000000);
                                            speed_up2.setBounds(100002200, 144000000, 50, 50);
                                            speed[0] = possible_speed.get(ind_speed[0]);

                                        }



                                        if(speed_down.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                            if(ind_speed[0] > 0){
                                                ind_speed[0] = ind_speed[0] - 1;
                                            }
                                            speed_down.set(0, 100000000);
                                            speed_down1.setBounds(100002200, 144000000, 50, 50);
                                            speed[0] = possible_speed.get(ind_speed[0]);

                                        }

                                        if(speed_down.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                            if(ind_speed[0] > 0){
                                                ind_speed[0] = ind_speed[0] - 1;
                                            }
                                            speed_down.set(1, 100000000);
                                            speed_down2.setBounds(100002200, 144000000, 50, 50);
                                            speed[0] = possible_speed.get(ind_speed[0]);

                                        }




                                    }


                                }

                                if (k.y == 10 | k.y == 20 | k.y == 40) {


                                    if(ghost_powerup[0] == 0){
                                        if ((c_x % 100) == 0) {

                                            int t_x = c_x;

                                            int t_y = c_y - 5;

                                            if (!brick_and_wall.contains((width/50) * (t_y / 50) + t_x / 50)) {

                                                person.setBounds(c_x + k.x, c_y - k.y, 50, 50);
                                                person.setIcon(new ImageIcon("D:/University/Semester8/AP/New folder (2)/project/Images/Bombermans/Player 1/01.gif"));

                                                if(ghost_location[0] == (width/50) * (t_y / 50) + t_x / 50){
                                                    ghost_location[0] = ghost_location[0] + 10000000;
                                                    g.setBounds(1000000000,100000000,50,50);
                                                    ghost_powerup[0] = ghost_powerup[0] + 1;

                                                }

                                                if (((enemy_1_location.get(0) == (width/50) * (t_y / 50) + t_x / 50) & (lives_for_enemy_1.get(0) == 1)) | ((enemy_1_location.get(1) == (width/50) * (t_y / 50) + t_x / 50) & (lives_for_enemy_1.get(1) == 1)) | ((enemy_1_location.get(2) == (width/50) * (t_y / 50) + t_x / 50) & (lives_for_enemy_1.get(2) == 1))){

                                                    frame.getContentPane().removeAll();
                                                    frame.setContentPane(imageLabel);

                                                }

                                                if(brick_in_map.get(20) == (width/50) * (t_y / 50) + t_x / 50){
                                                    if(lives_for_enemy_1.get(0) == 0 & lives_for_enemy_1.get(1) == 0 & lives_for_enemy_1.get(2) == 0){

                                                        level[0] = level[0] + 1;
                                                        System.out.println(level[0]);


                                                    }

                                                }

                                                if(control_of_bomb.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    control_of_bomb.set(0, 100000000);
                                                    control.setBounds(100002200, 144000000, 50, 50);
                                                    bomb_control[0] = bomb_control[0] + 1;

                                                }


                                                if(points_location.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    points_location.set(0, 100000000);
                                                    point1.setBounds(100002200, 144000000, 50, 50);
                                                    score[0] = score[0] + 100;
                                                    person_score.setText(String.valueOf(score[0]));

                                                }
                                                if(points_location.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    points_location.set(1, 100000000);
                                                    point2.setBounds(10000000, 100200000, 50, 50);
                                                    score[0] = score[0] + 100;
                                                    person_score.setText(String.valueOf(score[0]));

                                                }
                                                if(points_location.get(2) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    points_location.set(2, 100000000);
                                                    point3.setBounds(1000000, 100200000, 50, 50);
                                                    score[0] = score[0] + 100;
                                                    person_score.setText(String.valueOf(score[0]));

                                                }
                                                if(points_location.get(3) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    points_location.set(3, 100000000);
                                                    point4.setBounds(400000000, 100000000, 50, 50);
                                                    score[0] = score[0] + 100;
                                                    person_score.setText(String.valueOf(score[0]));

                                                }
                                                if(points_location.get(4) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    points_location.set(4, 100000000);
                                                    point5.setBounds(50000000, 10000000, 50, 50);
                                                    score[0] = score[0] + 100;
                                                    person_score.setText(String.valueOf(score[0]));

                                                }







                                                if(inc_rad_location.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    inc_rad_location.set(0, 100000000);
                                                    inc_rad1.setBounds(100002200, 144000000, 50, 50);
                                                    bomb_radius[0] = bomb_radius[0] + 1;

                                                }

                                                if(inc_rad_location.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    inc_rad_location.set(1, 100000000);
                                                    inc_rad2.setBounds(100002200, 144000000, 50, 50);
                                                    bomb_radius[0] = bomb_radius[0] + 1;

                                                }

                                                if(inc_rad_location.get(2) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    inc_rad_location.set(2, 100000000);
                                                    inc_rad3.setBounds(100002200, 144000000, 50, 50);
                                                    bomb_radius[0] = bomb_radius[0] + 1;

                                                }





                                                if(dec_rad_location.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    dec_rad_location.set(0, 100000000);
                                                    dec_rad1.setBounds(100002200, 144000000, 50, 50);
                                                    if(bomb_radius[0] > 1){
                                                        bomb_radius[0] = bomb_radius[0] - 1;
                                                    }
                                                }
                                                if(dec_rad_location.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    dec_rad_location.set(1, 100000000);
                                                    dec_rad2.setBounds(100002200, 144000000, 50, 50);
                                                    if(bomb_radius[0] > 1){
                                                        bomb_radius[0] = bomb_radius[0] - 1;
                                                    }
                                                }
                                                if(dec_rad_location.get(2) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    dec_rad_location.set(2, 100000000);
                                                    dec_rad3.setBounds(100002200, 144000000, 50, 50);
                                                    if(bomb_radius[0] > 1){
                                                        bomb_radius[0] = bomb_radius[0] - 1;
                                                    }
                                                }









                                                if(inc_bomb_num.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    inc_bomb_num.set(0, 100000000);
                                                    inc_bomb_num1.setBounds(100002200, 144000000, 50, 50);
                                                    bomb_number[0] = bomb_number[0] + 1;

                                                }
                                                if(inc_bomb_num.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    inc_bomb_num.set(1, 100000000);
                                                    inc_bomb_num2.setBounds(100002200, 144000000, 50, 50);
                                                    bomb_number[0] = bomb_number[0] + 1;

                                                }
                                                if(inc_bomb_num.get(2) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    inc_bomb_num.set(2, 100000000);
                                                    inc_bomb_num3.setBounds(100002200, 144000000, 50, 50);
                                                    bomb_number[0] = bomb_number[0] + 1;

                                                }




                                                if(speed_up.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    ind_speed[0] = ind_speed[0] + 1;
                                                    speed_up.set(0, 100000000);
                                                    speed_up1.setBounds(100002200, 144000000, 50, 50);
                                                    speed[0] = possible_speed.get(ind_speed[0]);

                                                }

                                                if(speed_up.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    ind_speed[0] = ind_speed[0] + 1;
                                                    speed_up.set(1, 100000000);
                                                    speed_up2.setBounds(100002200, 144000000, 50, 50);
                                                    speed[0] = possible_speed.get(ind_speed[0]);

                                                }

                                                if(speed_down.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    if(ind_speed[0] > 0){
                                                        ind_speed[0] = ind_speed[0] - 1;
                                                    }
                                                    speed_down.set(0, 100000000);
                                                    speed_down1.setBounds(100002200, 144000000, 50, 50);
                                                    speed[0] = possible_speed.get(ind_speed[0]);

                                                }

                                                if(speed_down.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    if(ind_speed[0] > 0){
                                                        ind_speed[0] = ind_speed[0] - 1;
                                                    }
                                                    speed_down.set(1, 100000000);
                                                    speed_down2.setBounds(100002200, 144000000, 50, 50);
                                                    speed[0] = possible_speed.get(ind_speed[0]);

                                                }




                                            }

                                            if (((width/50) * (t_y / 50) + t_x / 50) == 1 | ((width/50) * (t_y / 50) + t_x / 50) == (width/50) | ((width/50) * (t_y / 50) + t_x / 50) == 0) {

                                                person.setBounds(c_x + k.x, c_y - k.y, 50, 50);
                                                person.setIcon(new ImageIcon("D:/University/Semester8/AP/New folder (2)/project/Images/Bombermans/Player 1/01.gif"));


                                            }


                                        }


                                    }

                                    if(ghost_powerup[0] == 1){
                                        int t_x = c_x;

                                        int t_y = c_y;

                                        if (((width/50) * (t_y / 50) + t_x / 50) == 1 | ((width/50) * (t_y / 50) + t_x / 50) == (width/50) | ((width/50) * (t_y / 50) + t_x / 50) == 0) {

                                            person.setBounds(c_x + k.x, c_y - k.y, 50, 50);
                                            person.setIcon(new ImageIcon("D:/University/Semester8/AP/New folder (2)/project/Images/Bombermans/Player 1/01.gif"));


                                        }


                                        person.setBounds(c_x + k.x, c_y - k.y, 50, 50);
                                        person.setIcon(new ImageIcon("D:/University/Semester8/AP/New folder (2)/project/Images/Bombermans/Player 1/01.gif"));

                                        if(ghost_location[0] == (width/50) * (t_y / 50) + t_x / 50){
                                            ghost_location[0] = ghost_location[0] + 10000000;
                                            g.setBounds(1000000000,100000000,50,50);
                                            ghost_powerup[0] = ghost_powerup[0] + 1;

                                        }

                                        if (enemy_1_location.contains((width/50) * (t_y / 50) + t_x / 50)){

                                            frame.getContentPane().removeAll();
                                            frame.setContentPane(imageLabel);

                                        }

                                        if(brick_in_map.get(20) == (width/50) * (t_y / 50) + t_x / 50){
                                            if(lives_for_enemy_1.get(0) == 0 & lives_for_enemy_1.get(1) == 0 & lives_for_enemy_1.get(2) == 0){

                                                level[0] = level[0] + 1;
                                                System.out.println(level[0]);


                                            }

                                        }


                                        if(control_of_bomb.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                            control_of_bomb.set(0, 100000000);
                                            control.setBounds(100002200, 144000000, 50, 50);
                                            bomb_control[0] = bomb_control[0] + 1;

                                        }


                                        if(points_location.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                            points_location.set(0, 100000000);
                                            point1.setBounds(100002200, 144000000, 50, 50);
                                            score[0] = score[0] + 100;
                                            person_score.setText(String.valueOf(score[0]));

                                        }
                                        if(points_location.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                            points_location.set(1, 100000000);
                                            point2.setBounds(10000000, 100200000, 50, 50);
                                            score[0] = score[0] + 100;
                                            person_score.setText(String.valueOf(score[0]));

                                        }
                                        if(points_location.get(2) == (width/50) * (t_y / 50) + t_x / 50) {
                                            points_location.set(2, 100000000);
                                            point3.setBounds(1000000, 100200000, 50, 50);
                                            score[0] = score[0] + 100;
                                            person_score.setText(String.valueOf(score[0]));

                                        }
                                        if(points_location.get(3) == (width/50) * (t_y / 50) + t_x / 50) {
                                            points_location.set(3, 100000000);
                                            point4.setBounds(400000000, 100000000, 50, 50);
                                            score[0] = score[0] + 100;
                                            person_score.setText(String.valueOf(score[0]));

                                        }
                                        if(points_location.get(4) == (width/50) * (t_y / 50) + t_x / 50) {
                                            points_location.set(4, 100000000);
                                            point5.setBounds(50000000, 10000000, 50, 50);
                                            score[0] = score[0] + 100;
                                            person_score.setText(String.valueOf(score[0]));

                                        }







                                        if(inc_rad_location.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                            inc_rad_location.set(0, 100000000);
                                            inc_rad1.setBounds(100002200, 144000000, 50, 50);
                                            bomb_radius[0] = bomb_radius[0] + 1;

                                        }

                                        if(inc_rad_location.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                            inc_rad_location.set(1, 100000000);
                                            inc_rad2.setBounds(100002200, 144000000, 50, 50);
                                            bomb_radius[0] = bomb_radius[0] + 1;

                                        }

                                        if(inc_rad_location.get(2) == (width/50) * (t_y / 50) + t_x / 50) {
                                            inc_rad_location.set(2, 100000000);
                                            inc_rad3.setBounds(100002200, 144000000, 50, 50);
                                            bomb_radius[0] = bomb_radius[0] + 1;

                                        }





                                        if(dec_rad_location.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                            dec_rad_location.set(0, 100000000);
                                            dec_rad1.setBounds(100002200, 144000000, 50, 50);
                                            if(bomb_radius[0] > 1){
                                                bomb_radius[0] = bomb_radius[0] - 1;
                                            }
                                        }
                                        if(dec_rad_location.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                            dec_rad_location.set(1, 100000000);
                                            dec_rad2.setBounds(100002200, 144000000, 50, 50);
                                            if(bomb_radius[0] > 1){
                                                bomb_radius[0] = bomb_radius[0] - 1;
                                            }
                                        }
                                        if(dec_rad_location.get(2) == (width/50) * (t_y / 50) + t_x / 50) {
                                            dec_rad_location.set(2, 100000000);
                                            dec_rad3.setBounds(100002200, 144000000, 50, 50);
                                            if(bomb_radius[0] > 1){
                                                bomb_radius[0] = bomb_radius[0] - 1;
                                            }
                                        }









                                        if(inc_bomb_num.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                            inc_bomb_num.set(0, 100000000);
                                            inc_bomb_num1.setBounds(100002200, 144000000, 50, 50);
                                            bomb_number[0] = bomb_number[0] + 1;

                                        }
                                        if(inc_bomb_num.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                            inc_bomb_num.set(1, 100000000);
                                            inc_bomb_num2.setBounds(100002200, 144000000, 50, 50);
                                            bomb_number[0] = bomb_number[0] + 1;

                                        }
                                        if(inc_bomb_num.get(2) == (width/50) * (t_y / 50) + t_x / 50) {
                                            inc_bomb_num.set(2, 100000000);
                                            inc_bomb_num3.setBounds(100002200, 144000000, 50, 50);
                                            bomb_number[0] = bomb_number[0] + 1;

                                        }




                                        if(speed_up.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                            ind_speed[0] = ind_speed[0] + 1;
                                            speed_up.set(0, 100000000);
                                            speed_up1.setBounds(100002200, 144000000, 50, 50);
                                            speed[0] = possible_speed.get(ind_speed[0]);

                                        }

                                        if(speed_up.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                            ind_speed[0] = ind_speed[0] + 1;
                                            speed_up.set(1, 100000000);
                                            speed_up2.setBounds(100002200, 144000000, 50, 50);
                                            speed[0] = possible_speed.get(ind_speed[0]);

                                        }

                                        if(speed_down.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                            if(ind_speed[0] > 0){
                                                ind_speed[0] = ind_speed[0] - 1;
                                            }
                                            speed_down.set(0, 100000000);
                                            speed_down1.setBounds(100002200, 144000000, 50, 50);
                                            speed[0] = possible_speed.get(ind_speed[0]);

                                        }

                                        if(speed_down.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                            if(ind_speed[0] > 0){
                                                ind_speed[0] = ind_speed[0] - 1;
                                            }
                                            speed_down.set(1, 100000000);
                                            speed_down2.setBounds(100002200, 144000000, 50, 50);
                                            speed[0] = possible_speed.get(ind_speed[0]);

                                        }


                                    }


                                }

                                if (k.y == -10 | k.y == -20 | k.y == -40) {


                                    if(ghost_powerup[0] == 0){

                                        if ((c_x % 100) == 0) {

                                            int t_x = c_x;

                                            int t_y = c_y + 50;

                                            //System.out.println((width/50) * (t_y / 50) + t_x / 50);


                                            if (!brick_and_wall.contains((width/50) * (t_y / 50) + t_x / 50)) {

                                                person.setBounds(c_x + k.x, c_y - k.y, 50, 50);

                                                person.setIcon(new ImageIcon("D:/University/Semester8/AP/New folder (2)/project/Images/Bombermans/Player 1/11.gif"));

                                                if(ghost_location[0] == (width/50) * (t_y / 50) + t_x / 50){
                                                    ghost_location[0] = ghost_location[0] + 10000000;
                                                    g.setBounds(1000000000,100000000,50,50);
                                                    ghost_powerup[0] = ghost_powerup[0] + 1;

                                                }

                                                if (((enemy_1_location.get(0) == (width/50) * (t_y / 50) + t_x / 50) & (lives_for_enemy_1.get(0) == 1)) | ((enemy_1_location.get(1) == (width/50) * (t_y / 50) + t_x / 50) & (lives_for_enemy_1.get(1) == 1)) | ((enemy_1_location.get(2) == (width/50) * (t_y / 50) + t_x / 50) & (lives_for_enemy_1.get(2) == 1))){

                                                    frame.getContentPane().removeAll();
                                                    frame.setContentPane(imageLabel);

                                                }

                                                if(control_of_bomb.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    control_of_bomb.set(0, 100000000);
                                                    control.setBounds(100002200, 144000000, 50, 50);
                                                    bomb_control[0] = bomb_control[0] + 1;

                                                }

                                                if(brick_in_map.get(20) == (width/50) * (t_y / 50) + t_x / 50){
                                                    if(lives_for_enemy_1.get(0) == 0 & lives_for_enemy_1.get(1) == 0 & lives_for_enemy_1.get(2) == 0){

                                                        level[0] = level[0] + 1;

                                                        System.out.println(level[0]);


                                                    }

                                                }

                                                if(points_location.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    points_location.set(0, 100000000);
                                                    point1.setBounds(100002200, 144000000, 50, 50);
                                                    score[0] = score[0] + 100;
                                                    person_score.setText(String.valueOf(score[0]));

                                                }
                                                if(points_location.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    points_location.set(1, 100000000);
                                                    point2.setBounds(10000000, 100200000, 50, 50);
                                                    score[0] = score[0] + 100;
                                                    person_score.setText(String.valueOf(score[0]));

                                                }
                                                if(points_location.get(2) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    points_location.set(2, 100000000);
                                                    point3.setBounds(1000000, 100200000, 50, 50);
                                                    score[0] = score[0] + 100;
                                                    person_score.setText(String.valueOf(score[0]));

                                                }
                                                if(points_location.get(3) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    points_location.set(3, 100000000);
                                                    point4.setBounds(400000000, 100000000, 50, 50);
                                                    score[0] = score[0] + 100;
                                                    person_score.setText(String.valueOf(score[0]));

                                                }
                                                if(points_location.get(4) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    points_location.set(4, 100000000);
                                                    point5.setBounds(50000000, 10000000, 50, 50);
                                                    score[0] = score[0] + 100;
                                                    person_score.setText(String.valueOf(score[0]));

                                                }







                                                if(inc_rad_location.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    inc_rad_location.set(0, 100000000);
                                                    inc_rad1.setBounds(100002200, 144000000, 50, 50);
                                                    bomb_radius[0] = bomb_radius[0] + 1;

                                                }

                                                if(inc_rad_location.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    inc_rad_location.set(1, 100000000);
                                                    inc_rad2.setBounds(100002200, 144000000, 50, 50);
                                                    bomb_radius[0] = bomb_radius[0] + 1;

                                                }

                                                if(inc_rad_location.get(2) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    inc_rad_location.set(2, 100000000);
                                                    inc_rad3.setBounds(100002200, 144000000, 50, 50);
                                                    bomb_radius[0] = bomb_radius[0] + 1;

                                                }

                                                if(dec_rad_location.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    dec_rad_location.set(0, 100000000);
                                                    dec_rad1.setBounds(100002200, 144000000, 50, 50);
                                                    if(bomb_radius[0] > 1){
                                                        bomb_radius[0] = bomb_radius[0] - 1;
                                                    }
                                                }
                                                if(dec_rad_location.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    dec_rad_location.set(1, 100000000);
                                                    dec_rad2.setBounds(100002200, 144000000, 50, 50);
                                                    if(bomb_radius[0] > 1){
                                                        bomb_radius[0] = bomb_radius[0] - 1;
                                                    }
                                                }
                                                if(dec_rad_location.get(2) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    dec_rad_location.set(2, 100000000);
                                                    dec_rad3.setBounds(100002200, 144000000, 50, 50);
                                                    if(bomb_radius[0] > 1){
                                                        bomb_radius[0] = bomb_radius[0] - 1;
                                                    }
                                                }








                                                if(inc_bomb_num.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    inc_bomb_num.set(0, 100000000);
                                                    inc_bomb_num1.setBounds(100002200, 144000000, 50, 50);
                                                    bomb_number[0] = bomb_number[0] + 1;

                                                }
                                                if(inc_bomb_num.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    inc_bomb_num.set(1, 100000000);
                                                    inc_bomb_num2.setBounds(100002200, 144000000, 50, 50);
                                                    bomb_number[0] = bomb_number[0] + 1;

                                                }
                                                if(inc_bomb_num.get(2) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    inc_bomb_num.set(2, 100000000);
                                                    inc_bomb_num3.setBounds(100002200, 144000000, 50, 50);
                                                    bomb_number[0] = bomb_number[0] + 1;

                                                }






                                                if(speed_up.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    ind_speed[0] = ind_speed[0] + 1;
                                                    speed_up.set(0, 1000002000);
                                                    speed_up1.setBounds(1000202200, 1440400000, 50, 50);
                                                    speed[0] = possible_speed.get(ind_speed[0]);

                                                }

                                                if(speed_up.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    ind_speed[0] = ind_speed[0] + 1;
                                                    speed_up.set(1, 1000003000);
                                                    speed_up2.setBounds(1000302200, 144000000, 50, 50);
                                                    speed[0] = possible_speed.get(ind_speed[0]);

                                                }


                                                if(speed_down.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    if(ind_speed[0] > 0){
                                                        ind_speed[0] = ind_speed[0] - 1;
                                                    }
                                                    speed_down.set(0, 100000000);
                                                    speed_down1.setBounds(100002200, 144000000, 50, 50);
                                                    speed[0] = possible_speed.get(ind_speed[0]);

                                                }

                                                if(speed_down.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                                    if(ind_speed[0] > 0){
                                                        ind_speed[0] = ind_speed[0] - 1;
                                                    }
                                                    speed_down.set(1, 100000000);
                                                    speed_down2.setBounds(100002200, 144000000, 50, 50);
                                                    speed[0] = possible_speed.get(ind_speed[0]);

                                                }








                                            }

                                            if (((width/50) * (t_y / 50) + t_x / 50) == 1 | ((width/50) * (t_y / 50) + t_x / 50) == (width/50) | ((width/50) * (t_y / 50) + t_x / 50) == 0) {

                                                person.setBounds(c_x + k.x, c_y - k.y, 50, 50);
                                                person.setIcon(new ImageIcon("D:/University/Semester8/AP/New folder (2)/project/Images/Bombermans/Player 1/11.gif"));


                                            }


                                        }



                                    }

                                    if(ghost_powerup[0] == 1){
                                        int t_x = c_x;

                                        int t_y = c_y + 50;

                                        if (((width/50) * (t_y / 50) + t_x / 50) == 1 | ((width/50) * (t_y / 50) + t_x / 50) == (width/50) | ((width/50) * (t_y / 50) + t_x / 50) == 0) {

                                            person.setBounds(c_x + k.x, c_y - k.y, 50, 50);
                                            person.setIcon(new ImageIcon("D:/University/Semester8/AP/New folder (2)/project/Images/Bombermans/Player 1/11.gif"));


                                        }

                                        person.setBounds(c_x + k.x, c_y - k.y, 50, 50);

                                        person.setIcon(new ImageIcon("D:/University/Semester8/AP/New folder (2)/project/Images/Bombermans/Player 1/11.gif"));

                                        if(ghost_location[0] == (width/50) * (t_y / 50) + t_x / 50){
                                            ghost_location[0] = ghost_location[0] + 10000000;
                                            g.setBounds(1000000000,100000000,50,50);
                                            ghost_powerup[0] = ghost_powerup[0] + 1;

                                        }

                                        if (enemy_1_location.contains((width/50) * (t_y / 50) + t_x / 50)){

                                            frame.getContentPane().removeAll();
                                            frame.setContentPane(imageLabel);

                                        }

                                        if(control_of_bomb.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                            control_of_bomb.set(0, 100000000);
                                            control.setBounds(100002200, 144000000, 50, 50);
                                            bomb_control[0] = bomb_control[0] + 1;

                                        }

                                        if(brick_in_map.get(20) == (width/50) * (t_y / 50) + t_x / 50){
                                            if(lives_for_enemy_1.get(0) == 0 & lives_for_enemy_1.get(1) == 0 & lives_for_enemy_1.get(2) == 0){

                                                level[0] = level[0] + 1;
                                                System.out.println(level[0]);


                                            }

                                        }

                                        if(points_location.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                            points_location.set(0, 100000000);
                                            point1.setBounds(100002200, 144000000, 50, 50);
                                            score[0] = score[0] + 100;
                                            person_score.setText(String.valueOf(score[0]));

                                        }
                                        if(points_location.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                            points_location.set(1, 100000000);
                                            point2.setBounds(10000000, 100200000, 50, 50);
                                            score[0] = score[0] + 100;
                                            person_score.setText(String.valueOf(score[0]));

                                        }
                                        if(points_location.get(2) == (width/50) * (t_y / 50) + t_x / 50) {
                                            points_location.set(2, 100000000);
                                            point3.setBounds(1000000, 100200000, 50, 50);
                                            score[0] = score[0] + 100;
                                            person_score.setText(String.valueOf(score[0]));

                                        }
                                        if(points_location.get(3) == (width/50) * (t_y / 50) + t_x / 50) {
                                            points_location.set(3, 100000000);
                                            point4.setBounds(400000000, 100000000, 50, 50);
                                            score[0] = score[0] + 100;
                                            person_score.setText(String.valueOf(score[0]));

                                        }
                                        if(points_location.get(4) == (width/50) * (t_y / 50) + t_x / 50) {
                                            points_location.set(4, 100000000);
                                            point5.setBounds(50000000, 10000000, 50, 50);
                                            score[0] = score[0] + 100;
                                            person_score.setText(String.valueOf(score[0]));

                                        }







                                        if(inc_rad_location.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                            inc_rad_location.set(0, 100000000);
                                            inc_rad1.setBounds(100002200, 144000000, 50, 50);
                                            bomb_radius[0] = bomb_radius[0] + 1;

                                        }

                                        if(inc_rad_location.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                            inc_rad_location.set(1, 100000000);
                                            inc_rad2.setBounds(100002200, 144000000, 50, 50);
                                            bomb_radius[0] = bomb_radius[0] + 1;

                                        }

                                        if(inc_rad_location.get(2) == (width/50) * (t_y / 50) + t_x / 50) {
                                            inc_rad_location.set(2, 100000000);
                                            inc_rad3.setBounds(100002200, 144000000, 50, 50);
                                            bomb_radius[0] = bomb_radius[0] + 1;

                                        }

                                        if(dec_rad_location.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                            dec_rad_location.set(0, 100000000);
                                            dec_rad1.setBounds(100002200, 144000000, 50, 50);
                                            if(bomb_radius[0] > 1){
                                                bomb_radius[0] = bomb_radius[0] - 1;
                                            }
                                        }
                                        if(dec_rad_location.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                            dec_rad_location.set(1, 100000000);
                                            dec_rad2.setBounds(100002200, 144000000, 50, 50);
                                            if(bomb_radius[0] > 1){
                                                bomb_radius[0] = bomb_radius[0] - 1;
                                            }
                                        }
                                        if(dec_rad_location.get(2) == (width/50) * (t_y / 50) + t_x / 50) {
                                            dec_rad_location.set(2, 100000000);
                                            dec_rad3.setBounds(100002200, 144000000, 50, 50);
                                            if(bomb_radius[0] > 1){
                                                bomb_radius[0] = bomb_radius[0] - 1;
                                            }
                                        }








                                        if(inc_bomb_num.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                            inc_bomb_num.set(0, 100000000);
                                            inc_bomb_num1.setBounds(100002200, 144000000, 50, 50);
                                            bomb_number[0] = bomb_number[0] + 1;

                                        }
                                        if(inc_bomb_num.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                            inc_bomb_num.set(1, 100000000);
                                            inc_bomb_num2.setBounds(100002200, 144000000, 50, 50);
                                            bomb_number[0] = bomb_number[0] + 1;

                                        }
                                        if(inc_bomb_num.get(2) == (width/50) * (t_y / 50) + t_x / 50) {
                                            inc_bomb_num.set(2, 100000000);
                                            inc_bomb_num3.setBounds(100002200, 144000000, 50, 50);
                                            bomb_number[0] = bomb_number[0] + 1;

                                        }






                                        if(speed_up.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                            ind_speed[0] = ind_speed[0] + 1;
                                            speed_up.set(0, 1000002000);
                                            speed_up1.setBounds(1000202200, 1440400000, 50, 50);
                                            speed[0] = possible_speed.get(ind_speed[0]);

                                        }

                                        if(speed_up.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                            ind_speed[0] = ind_speed[0] + 1;
                                            speed_up.set(1, 1000003000);
                                            speed_up2.setBounds(1000302200, 144000000, 50, 50);
                                            speed[0] = possible_speed.get(ind_speed[0]);

                                        }


                                        if(speed_down.get(0) == (width/50) * (t_y / 50) + t_x / 50) {
                                            if(ind_speed[0] > 0){
                                                ind_speed[0] = ind_speed[0] - 1;
                                            }
                                            speed_down.set(0, 100000000);
                                            speed_down1.setBounds(100002200, 144000000, 50, 50);
                                            speed[0] = possible_speed.get(ind_speed[0]);

                                        }

                                        if(speed_down.get(1) == (width/50) * (t_y / 50) + t_x / 50) {
                                            if(ind_speed[0] > 0){
                                                ind_speed[0] = ind_speed[0] - 1;
                                            }
                                            speed_down.set(1, 100000000);
                                            speed_down2.setBounds(100002200, 144000000, 50, 50);
                                            speed[0] = possible_speed.get(ind_speed[0]);

                                        }
                                    }



                                }

                                if(k.y == 1000){

                                    if(bomb_control[0] == 0){


                                        if(bomb_number[0] > 0){


                                            if((c_x%50 ==0) & (c_y % 50) == 0){

                                                bomb_number[0] = bomb_number[0] - 1;

                                                bomb_lable.get(bomb_number[0]).setBounds(c_x, c_y, 50, 50);

                                                Object_to_add.add(bomb_lable.get(bomb_number[0]));

                                                brick_and_wall.add((width/50)*(c_y/50) + c_x/50);

                                                bomb_location.add((width/50)*(c_y/50) + c_x/50);

                                                System.out.println((width/50)*(c_y/50) + c_x/50);

                                                //b1_set b1_has_set = new b1_set();

                                                bombs.get(bomb_number[0]).b1_exploration(score,bomb_radius[0],person,frame , bomb_lable.get(bomb_number[0]) , c_y,c_x, width,bomb_number,brick_and_wall , brick_num , brick , enemy_1_location , lives_for_enemy_1 , bomb_location , brick_in_map);


                                                //b1_has_set.b1_exploration(bomb_radius[0],person,frame , b1 , c_y,c_x, width,bomb_number,brick_and_wall , brick_num , brick);


                                            }
                                        }



                                    }


                                    ////////////////////////////////////////////////////////////////gfhgdfdgfdgfdhdgdhgdfd

                                    if(bomb_control[0] == 1){

                                        if(bomb_number[0] > 0){


                                            if((c_x%50 ==0) & (c_y % 50) == 0){

                                                bomb_number[0] = bomb_number[0] - 1;

                                                bomb_lable.get(bomb_number[0]).setBounds(c_x, c_y, 50, 50);

                                                Object_to_add.add(bomb_lable.get(bomb_number[0]));

                                                bombs_to_remove.add(bomb_number[0]);

                                                brick_and_wall.add((width/50)*(c_y/50) + c_x/50);

                                                bomb_location.add((width/50)*(c_y/50) + c_x/50);

                                                bomb_with_key_location.add((width/50)*(c_y/50) + c_x/50);

                                                bomb_with_key_control.add(bombs_with_control.get(bomb_number[0]));

                                                x_location_for_controling_bomb.add(c_x);

                                                y_location_for_controling_bomb.add(c_y);

                                                System.out.println((width/50)*(c_y/50) + c_x/50);

                                                //bombs.get(bomb_number[0]).b1_exploration(bomb_radius[0],person,frame , bomb_lable.get(bomb_number[0]) , c_y,c_x, width,bomb_number,brick_and_wall , brick_num , brick);


                                                //b1_has_set.b1_exploration(bomb_radius[0],person,frame , b1 , c_y,c_x, width,bomb_number,brick_and_wall , brick_num , brick);


                                            }
                                        }


                                    }









                                }


                                if (k.y == 2000){

                                    bomb_with_key_control.get(0).b1_exploration_on_key(bomb_radius[0],person,frame , bomb_lable.get(bombs_to_remove.get(0)) , y_location_for_controling_bomb.get(0),x_location_for_controling_bomb.get(0), width,bomb_number,brick_and_wall , brick_num , brick , brick_in_map);
                                    bomb_with_key_control.remove(0);
                                    x_location_for_controling_bomb.remove(0);
                                    y_location_for_controling_bomb.remove(0);
                                    bombs_to_remove.remove(0);



                                }


                                //System.out.println(Object_to_add.size());
                            }
                            return false;
                        }


                    });


        ////////////

        //}



    }



}
