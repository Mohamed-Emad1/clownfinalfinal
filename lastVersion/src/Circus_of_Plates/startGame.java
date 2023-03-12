/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Circus_of_Plates;

import backend.Iterates;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import static folders.FileNames.*;
import static java.lang.Math.ceil;
import java.util.LinkedList;
import java.util.List;
import Constants.BackgroundObj;
import Constants.ClownObject;
import ObserverPatternClasses.ConditionCheckers;
import ObserverPatternClasses.Publisher;
import backend.ImageObject;
import Shapes.Shape;
import Shapes.ShapeFactory;
import Strategy.getDifficulty;


/**
 *
 * @author Detective_CN
 */
public class startGame extends ConditionCheckers implements World {
    
    private final int width;
    private final int height;
    private final List<GameObject> constant;
    private final List<GameObject> moving;
    private final List<GameObject> control;

    private String backgroundPath;
    private final List<GameObject> leftHandObj;
    private final List<GameObject> rightHandObj;
    
    private Iterates objTOIterartes =new Iterates();
    private getDifficulty Difficulty=new getDifficulty();
    private boolean GameOverFlag= false;
    
    ClownObject clown = null;
    BackgroundObj backgroundImage=null;
    ShapeFactory factory = new ShapeFactory();
    int[]startingPositions = new int[]{50,150,250,350,450,550,100, 200, 300, 400, 500, 600};
    int cooldown = 20;
    int bombCoolDown=200;
    int score = 0;
    int lives = 3;
    int topLeft;
    int topRight;
    int a=0;
    private static   List<GameObject> noNeeded = null;
   
    ImageObject scoreImage = new ImageObject(0, 0, scText);
    ImageObject heart = new ImageObject(750,0, heartFile);
    
    public startGame(int width, int height) {            //constructor
        //System.out.println(height+" "+width);
        
        super(ClownObject.getIstance(width / 3, 390, clownFile), 0, 0, 3);
        
        this.width = width;
        this.height = height;
        this.constant = new LinkedList<>();
        this.moving = new LinkedList<>();
        this.control = new LinkedList<>();
        startGame.noNeeded= new LinkedList<>();
        this.leftHandObj = new LinkedList<>();
        this.rightHandObj = new LinkedList<>();
        
        checkBackground();
       
        backgroundImage = BackgroundObj.getIstance(0,0,backgroundPath );
        constant.add(backgroundImage);
      
        
        //Add control objects
        clown = ClownObject.getIstance(width / 3, 390, clownFile);
        control.add(clown);
        this.addLives();
        constant.add(scoreImage);

    }
    
    
      public void checkBackground(){
       int x = Difficulty.getSpeedClown();
       if(x == 10)
           backgroundPath =backgroundhard;
       else if(x== 25){
           System.out.println(backgroundnormal);
           backgroundPath = backgroundnormal;
       }
       else
           backgroundPath =backgroundeasy;
           
   }

    @Override
    public List<GameObject> getConstantObjects() {
        return this.constant;
    }

    @Override
    public List<GameObject> getMovableObjects() {
        return this.moving;
    }

    @Override
    public List<GameObject> getControlableObjects() {
        return this.control;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }
    
    @Override
    public String getStatus() {
        return "Your current Score = "+Integer.toString(score);
    }

    @Override
    public int getSpeed() {
        return Difficulty.getSpeedObjects();
    }

    @Override
    public int getControlSpeed() {
        return Difficulty.getSpeedClown();
    }
    
    
    
    
    @Override
    public boolean refresh() {
        scoreToImage();
          // Spawning new objects
        int laneNumber = (int) (Math.random() * 12);
        int x = startingPositions[laneNumber];
        int y = 0;
        if(cooldown == 0){     
            int imgNum = (int)ceil(Math.random()*6);
            moving.add(factory.createShape(x,y,imgNum));
            cooldown = Difficulty.checkcooldown();
        }
        else
            cooldown --;
        sendBomb(x,y);
        
        // Dynamics of moving objects
        List<GameObject> redundantShapes = new LinkedList<>();
        
        objTOIterartes.itttttt(moving);
        GameObject n;
               
        while(objTOIterartes.hasnext()){
            n=objTOIterartes.next();
          
            n.setY((n.getY() + 1));
            
            if(n.getY()==getHeight()){
		redundantShapes.add(n);
            }

            else{
                n.setX(n.getX() + (Math.random() > 0.5 ? 1 : -1));
                
                Publisher publisher = new Publisher(moving, noNeeded, leftHandObj, rightHandObj, control, redundantShapes, heart, (ImageObject)n, lives, score, clown, topLeft, topRight);
                int[]output = publisher.inform();
                score = output[0];
                lives = output[1];
           
                if(lives == 0)
                    GameOverFlag = true;
            }
	}
              
        for(GameObject m : redundantShapes){
            moving.remove(m);
            Shape q=(Shape)m;
       
        }
        
        int leftHandTop = 450;
        int rightHandTop = 450;
        //System.out.println(Difficulty.getSpeedObjects());
        objTOIterartes.itttttt(leftHandObj);
        while(objTOIterartes.hasnext()){
            n=objTOIterartes.next();
            Shape obj = (Shape)n;
            
            if(obj.getStringDefinition().contains("plate")){
                n.setX(clown.getX()-15);
                n.setY(leftHandTop - 13);
                leftHandTop = leftHandTop - 13;
            }
            else{
                n.setX(clown.getX());
                n.setY(leftHandTop - 37);
                leftHandTop = leftHandTop - 37;
            }
        }
        //a++;
       objTOIterartes.itttttt(rightHandObj);
        while(objTOIterartes.hasnext()){
            n=objTOIterartes.next();
            Shape obj = (Shape)n;
            
            if(obj.getStringDefinition().contains("plate")){
                n.setX(clown.getX() + 135);
                n.setY(rightHandTop - 13);
                rightHandTop = rightHandTop - 13;
            }
            else{
                n.setX(clown.getX() + 150);
                n.setY(rightHandTop - 37);
                rightHandTop = rightHandTop - 37;
            }
        }
        //System.out.println("xxscx");
       if(leftHandTop<=0 || rightHandTop<=0)
            return false;
        redundantShapes.clear();
        topLeft = leftHandTop;
        topRight = rightHandTop;
        if(GameOverFlag)
            return false;
        return true;
    }
    
    public void scoreToImage(){
        constant.clear();
        constant.add(backgroundImage);
        
        constant.add(scoreImage);
        this.addLives();
        if(score == 0){
            ImageObject zero = new ImageObject(80, 5, scoreFile+"0"+".png");
            constant.add(zero);
        }
        else
        {
            int number =score;
            String  n= Integer.toString(number);

            for(int j=0;j<n.length();j++){
                char  digit = n.charAt(j);
                ImageObject digitImage = new ImageObject(80+(j*14),5, scoreFile+digit+".png");
                constant.add(digitImage);
                number = number / 10;
            }
        }
    }
    public void addLives(){
       int x=lives;
        for(;lives>0;lives--){
            heart = new ImageObject(750-lives*50,0, heartFile);
            constant.add(heart);
        }
        lives=x;
    } 
    
    private void sendBomb(int x,int y){
         if(this.bombCoolDown == 0){     
            int imgNum = 7;
            moving.add(factory.createShape(x,y,imgNum));
            bombCoolDown  =Difficulty.getBombCoolDown();
        }
        else
               bombCoolDown --;
    }

    public static List<GameObject> getNoNeeded() {
        return noNeeded;
    }

}
