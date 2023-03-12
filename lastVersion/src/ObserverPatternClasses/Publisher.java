/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObserverPatternClasses;

import Constants.ClownObject;
import Shapes.Shape;
import backend.ImageObject;
import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class Publisher extends ConditionCheckers{
    private final List<Subscriber> subscribers = new LinkedList<>();
    List<GameObject> redundantShapes;
    List<GameObject> noNeeded;
    List<GameObject> moving;
    ImageObject manageableObject;
    int score;
    
    public Publisher(List<GameObject> moving, List<GameObject> noNeeded, List<GameObject> leftHandObj, List<GameObject> rightHandObj, List<GameObject> control, List<GameObject> redundantShapes, ImageObject heart, ImageObject manageableObject, int lives, int score,ClownObject clown, int topLeft, int topRight){
        super(clown, topLeft, topRight, lives);
        
        this.moving = moving;
        this.noNeeded = noNeeded;
        this.redundantShapes = redundantShapes;
        
        this.manageableObject = manageableObject;
        this.lives = lives;
        this.clown = clown;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.score = score;
        
        LeftHand lh = new LeftHand(noNeeded, leftHandObj, control, redundantShapes, score);
        RightHand rh = new RightHand(noNeeded, rightHandObj, control, redundantShapes, score);
        BombInteracter b = new BombInteracter(redundantShapes, lives, heart, clown, topLeft, topRight);
        
        this.subscribe(lh);
        this.subscribe(rh);
        this.subscribe(b);
    }
    
    public void subscribe(Subscriber sub){
        subscribers.add(sub);
    }
    
    public void unsubscribe(Subscriber sub){
        subscribers.remove(sub);
    }
    
    public void setManageableObject(ImageObject manageableObject){
        this.manageableObject = manageableObject;
    }
    
    public ImageObject getManageableObject(){
        return this.manageableObject;
    }
    
    public int[] inform(){
        if(manageableObject.getType() == 4){
            lives = subscribers.get(2).update(manageableObject);

        }
        else{
                       if(objectTouchesLeftHand(manageableObject))
                score = subscribers.get(0).update(manageableObject);
            else if(objectTouchesRightHand(manageableObject))
                score = subscribers.get(1).update(manageableObject);
        }
        
        return new int[]{score, lives};
    }
    

}
