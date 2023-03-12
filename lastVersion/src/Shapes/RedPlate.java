/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

import backend.ImageObject;
import Shapes.Shape;

/**
 *
 * @author LENOVO
 */
public class RedPlate extends ImageObject implements Shape{
    public RedPlate(int x, int y, String imagePath){
        super( x, y, imagePath,2);
    }
    
    @Override
    public String getStringDefinition(){
        return "red_plate"; 
    }
}
