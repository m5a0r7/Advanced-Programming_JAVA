import java.awt.*;

public class handleKeyPress {



    int x_diff ;
    int y_diff ;

    public Point handleKeyPress(int keyCode , int[] speed) {

        Point n = new Point();


        switch (keyCode) {
            case 37://LEFT KEY
                x_diff = -speed[0];
                y_diff = 0;
                break;
            case 38://UP KEY
                y_diff = speed[0];
                x_diff = 0;
                break;
            case 39://RIGHT KEY
                x_diff = speed[0];
                y_diff = 0;
                break;
            case 40://DOWN KEY
                y_diff =-speed[0];
                x_diff = 0;
                break;

            case 66://DOWN KEY
                y_diff =1000;
                x_diff =0;
                break;



            case 70://DOWN KEY
                y_diff =2000;
                x_diff =0;
                break;


        }
        n.x = x_diff;

        n.y = y_diff;

        return n;




    }

}
