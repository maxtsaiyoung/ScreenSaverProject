//Game Example
//Lockwood Version 2023-24
// Learning goals:
// make an object class to go with this main class
// the object class should have a printInfo()
//input picture for background
//input picture for object and paint the object on the screen at a given point
//create move method for the object, and use it
// create a wrapping move method and a bouncing move method
//create a second object class
//give objects rectangles
//start interactions/collisions

//*******************************************************************************
//Import Section
//Add Java libraries needed for the game
//import java.awt.Canvas;

//Graphics Libraries

import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;


//*******************************************************************************
// Class Definition Section

public class GameLand implements Runnable {

    //Variable Declaration Section
    //Declare the variables used in the program
    //You can set their initial values here if you want

    //Sets the width and height of the program window
    final int WIDTH = 1000;
    final int HEIGHT = 700;

    //Declare the variables needed for the graphics
    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;

    public BufferStrategy bufferStrategy;

    //Declare the objects used in the program below
    /**  Step 1: Declare your object and give it a name**/
    //public Hero astro;
    public Hero FighterJet;
    public Hero EvilShip;
    public Hero EvilShip2;
    public Hero SpaceShip;
    /** Step 2: make room for your image**/
    //public Image astroPic;
    public Image FighterJetPic;
    public Image SpaceBackground;
    public Image EvilShipPic;
    public Image EvilShipPic2;
    public Image SpaceShipPic;
    public boolean FighterJetIntersectingEvilShip;
    public boolean EvilShipIntersectingEvilShip2;
    public boolean EvilShip2IntersectingFighterJet;
    public boolean SpaceShipIntersectingEvilShip2;





    // Main method definition: PSVM
    // This is the code that runs first and automatically
    public static void main(String[] args) {
       GameLand ex = new GameLand();   //creates a new instance of the game and tells GameLand() method to run
        new Thread(ex).start();       //creates a thread & starts up the code in the run( ) method
    }

    // Constructor Method
    // This has no return type and has the same name as the class
    // This section is the setup portion of the program
    // Initialize your variables and construct your program objects here.
    public GameLand() {
        setUpGraphics(); //this calls the setUpGraphics() method

        //create (construct) the objects needed for the game below
        //for each object that has a picture, load in images as well

        /**  Step 3: Construct a specific Hero**/
//astro = new Hero(400,500,-10,13);
FighterJet = new Hero(400,400,10,7);
EvilShip = new Hero(300,300,3,-5);
EvilShip2 = new Hero(200,500,-8,10);
SpaceShip = new Hero(500,300,-15,20);

/** Step 4: load in the image for your object**/
//astroPic = Toolkit.getDefaultToolkit().getImage("astronaut.png");
FighterJetPic = Toolkit.getDefaultToolkit().getImage("FighterJet.png");
SpaceBackground = Toolkit.getDefaultToolkit().getImage("SpaceBackground.jpeg");
EvilShipPic = Toolkit.getDefaultToolkit().getImage("EvilShip.png");
EvilShipPic2 = Toolkit.getDefaultToolkit().getImage("EvilShip2.png");
SpaceShipPic = Toolkit.getDefaultToolkit().getImage("SpaceShip.png");



//astro.printInfo();
FighterJet.printInfo();
EvilShip.printInfo();
EvilShip2.printInfo();
SpaceShip.printInfo();



    }// GameLand()

//*******************************************************************************
//User Method Section
//
// put your code to do things here.

    // main thread
    // this is the code that plays the game after you set things up
    public void run() {
        //for the moment we will loop things forever using a while loop
        while (true) {
            moveThings();  //move all the game objects
            collisions();//check for rectangle intersections
            render();  // paint the graphics
            pause(20); // sleep for 20 ms

        }
    }

    //paints things on the screen using bufferStrategy
    private void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);

        //draw the image of your objects below:
        /**Step 5 draw the image of your object to the screen**/
        g.drawImage(SpaceBackground,0,0,WIDTH,HEIGHT,null);
        //g.drawImage(astroPic, astro.xpos,astro.ypos,astro.width,astro.height,null);

        g.drawImage(FighterJetPic, FighterJet.xpos, FighterJet.ypos, FighterJet.width, FighterJet.height, null);
        g.drawImage(EvilShipPic,EvilShip.xpos,EvilShip.ypos,EvilShip.width,EvilShip.height,null);
        g.drawImage(EvilShipPic2,EvilShip2.xpos,EvilShip2.ypos,EvilShip2.width,EvilShip2.height,null);
        g.drawImage(SpaceShipPic,SpaceShip.xpos,SpaceShip.ypos,SpaceShip.width,SpaceShip.height,null);


        //dispose the images each time(this allows for the illusion of movement).
        g.dispose();

        bufferStrategy.show();
    }

    public void moveThings() {
        //call the move() method code from your object class
        //astro.bouncingMove();
        FighterJet.bouncingMove();
        EvilShip.bouncingMove();
        EvilShip2.bouncingMove();
        SpaceShip.bouncingMove();
    }

    public void collisions(){
        if(FighterJet.rec.intersects(EvilShip.rec)&&FighterJetIntersectingEvilShip==false){
            FighterJetIntersectingEvilShip = true;
            System.out.println("ouch");
            FighterJet.dx=-FighterJet.dx;
            FighterJet.dy = -FighterJet.dy;
            FighterJet.height = FighterJet.height+2;
            FighterJet.width = FighterJet.width+2;
        }
        if(FighterJet.rec.intersects(EvilShip.rec)==false){
            FighterJetIntersectingEvilShip=false;
        }

        if(EvilShip.rec.intersects(EvilShip2.rec)&&EvilShipIntersectingEvilShip2==false){
            EvilShipIntersectingEvilShip2 = true;
            System.out.println("ow");
            EvilShip.dx = -EvilShip.dx+10;
            EvilShip.dy = -EvilShip.dy+10;
        }
        if(EvilShip.rec.intersects(EvilShip2.rec)==false){
            EvilShipIntersectingEvilShip2=false;
        }

        if(EvilShip2.rec.intersects(FighterJet.rec)&&EvilShip2IntersectingFighterJet==false){
            EvilShip2IntersectingFighterJet = true;
            System.out.println("oof");
            EvilShip2.dx = EvilShip2.dx+1;
            EvilShip2.dy = EvilShip2.dy+1;
            EvilShip2.dx = -EvilShip2.dx;
            EvilShip2.dy = -EvilShip2.dy;

        }

        if(EvilShip2.rec.intersects(FighterJet.rec)==false){
            EvilShip2IntersectingFighterJet = false;
        }

        if(SpaceShip.rec.intersects(EvilShip2.rec)&&SpaceShipIntersectingEvilShip2==false){
            SpaceShipIntersectingEvilShip2 = true;
            System.out.println("ouchy");
            SpaceShip.dx = -SpaceShip.dx+1;
            SpaceShip.dy = -SpaceShip.dy+1;
        }
        if(SpaceShip.rec.intersects(EvilShip2.rec)==false){
            SpaceShipIntersectingEvilShip2 = false;
        }


    }


    //Pauses or sleeps the computer for the amount specified in milliseconds
    public void pause(int time) {
        //sleep
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {

        }
    }

    //Graphics setup method
    private void setUpGraphics() {
        frame = new JFrame("Game Land");   //Create the program window or frame.  Names it.

        panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
        panel.setLayout(null);   //set the layout

        // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
        // and trap input events (Mouse and Keyboard events)
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);

        panel.add(canvas);  // adds the canvas to the panel.

        // frame operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
        frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
        frame.setResizable(false);   //makes it so the frame cannot be resized
        frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

        // sets up things so the screen displays images nicely.
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
        System.out.println("DONE graphic setup");
    }

}