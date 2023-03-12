/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Constants;

import eg.edu.alexu.csd.oop.game.GameObject;
import backend.ImageObject;
/**
 *
 * @author Detective_CN
 */
public class ClownObject extends ImageObject {
    //private static ClownObject clown=null;
    private int score=0;
             
    private static ClownObject clown =null;
    private ClownObject(int x, int y, String imaString,int uy) {
        super(x, y, imaString,uy);
    }
    
    public static ClownObject getIstance (int x, int y, String imaString) {
        
        if(clown==null)  {
            clown = new ClownObject(x, y, imaString,0);
        }
        return clown;
    }
    
    public boolean incrementScore(GameObject obj){
     if(obj.getY()==clown.getY()+20&&isIn(obj))   
     {score++;
         System.out.println("score ="+score);
     obj.setY(clown.getX()-10);
         obj.setX(clown.getX()+20);
         return true;
         
         
     }
     return false;   
    }
 private boolean isIn(GameObject obj){
int w=obj.getWidth();
int x=obj.getX();
 return (((clown.getX()+20)<x+w)&&(x<(clown.getX()+20)));  }
 
 
 @Override
 public void setY(int y){
     
 }
    
}
