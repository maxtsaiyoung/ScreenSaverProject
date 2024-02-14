import java.awt.*;

public class Hero {
    //declaration section
    public String name; //name of hero
    public int xpos;    //the x position
    public int ypos;    //the y position
    public int dx;  //the speed of the hero in the x direction
    public int dy;  //the speed of the hero in the y position
    public int width;
    public int height;
    public boolean isAlive; //a boolean to denote if the hero is alive
    public Rectangle rec;

    //constructor section

    public Hero(int pXpos,int pYpos, int pDx, int pDy){
        name = "Astronaut";
        xpos = pXpos;
        ypos = pYpos;
        dx = pDx;
        dy = pDy;
        width = 70;
        height = 90;
        isAlive = true;
        rec = new Rectangle(xpos,ypos,width-5,height-5);

    }
    //make a move method

    public void move(){
        ypos = ypos +dy;
        xpos = xpos+dx;
        rec = new Rectangle(xpos,ypos,width,height);
    }

    public void bouncingMove(){
        if (xpos>1000-width){
            dx=-dx;
        }
        if(ypos>700-height){
            dy=-dy;
        }
        if(xpos<0){
            dx=-dx;
        }
        if(ypos<0){
            dy=-dy;
        }
        ypos = ypos +dy;
        xpos = xpos+dx;
        rec = new Rectangle(xpos,ypos,width,height);
    }

    public void wrappingMove(){
        if(xpos>1000){
            xpos = 0;
        }

        if(ypos>700){
            ypos=0;
        }

        if(xpos<0){
            xpos=1000;
        }

        if(ypos<0){
            ypos=700;
        }
        ypos = ypos +dy;
        xpos = xpos+dx;
        rec = new Rectangle(xpos,ypos,width,height);
    }

    //printInfo() section
    public void printInfo(){
        System.out.println("(x,y): ("+xpos+","+ypos+")");
        System.out.println("x speed:" + dx);
        System.out.println("y speed" + dy);
        System.out.println("width: " + width);
        System.out.println("height: " + height);
        System.out.println("isAlive: " + isAlive);
    }


}
