/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObserverPatternClasses;

import Constants.ClownObject;
import Shapes.Shape;
import backend.ImageObject;

/**
 *
 * @author LENOVO
 */
public class ConditionCheckers {
    ClownObject clown;
    int topLeft;
    int topRight;
    int lives;
    
    public ConditionCheckers(ClownObject clown, int topLeft, int topRight, int lives){
        this.clown = clown;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.lives = lives;
    }
    
    public boolean objectTouchesLeftHand(ImageObject o1){
        Shape m = (Shape)o1;
        if(this.checkLives()){
            if(m.getStringDefinition().contains("plate")){
                if(o1.getX() > clown.getX()-35 && o1.getX() <(clown.getX()+85) && o1.getY() > topLeft - 14&&o1.getY()<topLeft){
                    return true;
                }
                else
                    return false;
            }
            else{
                if(o1.getX() <clown.getX()+55 &&  o1.getX() > clown.getX()-25 && o1.getY() > topLeft - 38&&o1.getY()<topLeft){
                    return true;
                }
                else
                    return false;
            }
        }
        return false;
    }
    
    public boolean objectTouchesRightHand(ImageObject o1){
        Shape m = (Shape)o1;
        if(this.checkLives()){
            if(m.getStringDefinition().contains("plate")){
                if(o1.getX() > clown.getX()+90&& o1.getX() <(clown.getX()+180) && o1.getY() > topRight - 14&&o1.getY()<topRight){
                    return true;
                }
                else
                    return false;
            }
            else{
                if(o1.getX() > clown.getX()+90&& o1.getX() <(clown.getX()+190) && o1.getY() > topRight - 38&&o1.getY()<topRight){
                    return true;
                }
                else
                    return false;
            }
        }
            return false;
    }
    
    private boolean  checkLives(){
       if(lives==0)
            return false;
       return true;
    }
        public boolean bombTouches(ImageObject bomb){
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
