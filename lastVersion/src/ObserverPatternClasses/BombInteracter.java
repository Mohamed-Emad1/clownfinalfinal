/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObserverPatternClasses;

import Constants.ClownObject;
import backend.ImageObject;
import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class BombInteracter implements Subscriber{
    
    List<GameObject> redundantShapes;
    ImageObject heart;
    ClownObject clown;
    int lives;
    int topLeft;
    int topRight;
    
    public BombInteracter(List<GameObject> redundantShapes, int lives, ImageObject heart, ClownObject clown, int topLeft, int topRight){
        this.redundantShapes = redundantShapes;
        this.heart = heart;
        this.clown = clown;
        this.lives = lives;
        this.topLeft = topLeft;
        this.topRight = topRight;
    }
    
    @Override
    public int update(ImageObject o){
        
        if(bombTouches(o)){
            bombAction(o);
            redundantShapes.add(o);}
        return lives;
    }
    
    private boolean  checkLives(){
       if(lives==0)
            return false;
       return true;
    }
    
    private void bombAction(ImageObject bomb){
        if(bombTouches(bomb)){
            heart.setVisible(false);
            lives--;
        }
    }
      private boolean bombTouches(ImageObject bomb){
        if(clown.getX()<=bomb.getX() && clown.getX()+clown.getWidth()-20 > bomb.getX()  && bomb.getY() > 600 - clown.getHeight()-55&&bomb.getY()<520 &&this.checkLives()) 
            return true;
        return false;
    }
    
    private int max(int x,int y){
        if(x>y)
            return x;
        return y;
    }  

}
