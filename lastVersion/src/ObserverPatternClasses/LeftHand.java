/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObserverPatternClasses;

import Shapes.Shape;
import backend.ImageObject;
import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class LeftHand implements Subscriber{
    private final List<GameObject> leftHandObj;
    private final List<GameObject> control;
    List<GameObject> redundantShapes;
    List<GameObject> noNeeded;
    int score;
    
    public LeftHand(List<GameObject> noNeeded, List<GameObject> leftHandObj, List<GameObject> control, List<GameObject> redundantShapes, int score){
        this.leftHandObj = leftHandObj;
        this.control = control;
        this.redundantShapes = redundantShapes;
        this.score = score;
        this.noNeeded = noNeeded;
    }

    @Override
    public int update(ImageObject o) {
        
        leftHandObj.add(o);
        control.add(o);
        redundantShapes.add(o);
        
        goThroughPlates();
        return score;
    }
    
    public void goThroughPlates(){
        boolean flag = true;
        
        if(leftHandObj.size() >= 3){
            
            Shape imgM = (Shape)leftHandObj.get(leftHandObj.size()-1);
            String type = imgM.getStringDefinition().substring(0, imgM.getStringDefinition().indexOf('_'));
            //System.out.print("First object type: " + type + "\n");
            
            Shape firstCheck = (Shape)leftHandObj.get(leftHandObj.size()-2);
            //System.out.print("second object type: " + firstCheck.getStringDefinition().substring(0, imgM.getStringDefinition().indexOf('_')) + "\n");
            if(!firstCheck.getStringDefinition().contains(type))
                flag = false;
            
            Shape secondCheck = (Shape)leftHandObj.get(leftHandObj.size()-3);
            //System.out.print("third object type: " + secondCheck.getStringDefinition().substring(0, imgM.getStringDefinition().indexOf('_')) + "\n");
            if(!secondCheck.getStringDefinition().contains(type))
                flag = false;
                
            if(flag)
                score ++;
        }
        
        if(flag && leftHandObj.size() >= 3){
            ImageObject shape1 = (ImageObject)leftHandObj.get(leftHandObj.size()-1);
            ImageObject shape2 = (ImageObject)leftHandObj.get(leftHandObj.size()-2);
            ImageObject shape3 = (ImageObject)leftHandObj.get(leftHandObj.size()-3);
            
            control.remove(shape1);
            control.remove(shape2);
            control.remove(shape3);
            leftHandObj.remove(shape1);
            leftHandObj.remove(shape2);
            leftHandObj.remove(shape3);
            
   
        }
    }

}
