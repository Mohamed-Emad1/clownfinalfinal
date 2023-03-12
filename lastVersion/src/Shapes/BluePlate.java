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
public class BluePlate extends ImageObject implements Shape {
    public BluePlate(int x, int y, String imagePath){
        super( x, y, imagePath,1);
    }
    
    @Override
    public String getStringDefinition(){
        return "blue_plate";  
    }
}
