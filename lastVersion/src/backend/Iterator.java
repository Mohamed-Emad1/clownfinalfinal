/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package backend;

import eg.edu.alexu.csd.oop.game.GameObject;

/**
 *
 * @author Detective_CN
 */
public interface Iterator {
    
    public boolean hasnext();
    public GameObject next();
    public void remove(GameObject e);
    
}
