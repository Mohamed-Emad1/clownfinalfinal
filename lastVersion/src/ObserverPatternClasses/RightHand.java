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
public class RightHand implements Subscriber{
    private final List<GameObject> rightHandObj;
    private final List<GameObject> control;
    List<GameObject> redundantShapes;
    List<GameObject> noNeeded;
    int score;
    
    public RightHand(List<GameObject> noNeeded, List<GameObject> rightHandObj, List<GameObject> control, List<GameObject> redundantShapes, int score){
        this.rightHandObj = rightHandObj;
        this.control = control;
        this.redundantShapes = redundantShapes;
        this.score = score;
        this.noNeeded = noNeeded;
    }

    @Override
    public int update(ImageObject o) {
        rightHandObj.add(o);
        control.add(o);
        redundantShapes.add(o);     
        goThroughPlates();
        return score;
    }
    
    public void goThroughPlates(){
        boolean flag = true;
        
        if(rightHandObj.size() >= 3){
            
            Shape imgM = (Shape)rightHandObj.get(rightHandObj.size()-1);
            String type = imgM.getStringDefinition().substring(0, imgM.getStringDefinition().indexOf('_'));
            
            Shape firstCheck = (Shape)rightHandObj.get(rightHandObj.size()-2);
            if(!firstCheck.getStringDefinition().contains(type))
                flag = false;
            
            Shape secondCheck = (Shape)rightHandObj.get(rightHandObj.size()-3);
            if(!secondCheck.getStringDefinition().contains(type))
                flag = false;
                
            if(flag)
                score ++;
        }
        
        if(flag && rightHandObj.size() >= 3){
            ImageObject shape1 = (ImageObject)rightHandObj.get(rightHandObj.size()-1);
            ImageObject shape2 = (ImageObject)rightHandObj.get(rightHandObj.size()-2);
            ImageObject shape3 = (ImageObject)rightHandObj.get(rightHandObj.size()-3);
            
            control.remove(shape1);
            control.remove(shape2);
            control.remove(shape3);
            
            rightHandObj.remove(shape1);
            rightHandObj.remove(shape2);
            rightHandObj.remove(shape3);
       
        }
    }
    

}
