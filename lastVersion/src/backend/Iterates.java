/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.List;
import backend.Iterator;

/**
 *
 * @author Detective_CN
 */
public class Iterates implements Iterator{
    
    
  private java.util.Iterator it;
  public void itttttt(List<GameObject> e){
      
        this.it = e.iterator();
}
    

    @Override
    public boolean hasnext() {
        return this.it.hasNext();
    }

    @Override
    public GameObject next() {
        return (GameObject) this.it.next();
    }

    @Override
    public void remove(GameObject e) {
        it.remove();
    }
    
}
