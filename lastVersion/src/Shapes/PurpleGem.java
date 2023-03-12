/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

import backend.ImageObject;
import Shapes.Shape;

/**
 *
 * @author User
 */
public class PurpleGem extends ImageObject implements Shape{
    public PurpleGem(int x, int y, String imagePath){
        super( x, y, imagePath,7);
    } 
    
    @Override
    public String getStringDefinition(){
        return "purple_gem"; 
    }
}
