/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

import Circus_of_Plates.startGame;
import eg.edu.alexu.csd.oop.game.GameObject;
import backend.ImageObject;
import static folders.FileNames.*;
import mainm.Main;


/**
 *
 * @author LENOVO
 */
public class ShapeFactory {

    public ImageObject createShape(int x,int y, int num){
        //System.out.println(num);

           ImageObject c=null;
       switch (num) {
            case 1 ->c= new BluePlate(x,y, plateBlue);
            case 2 ->c= new RedPlate(x, y, plateRed);
            case 3 ->c= new PurplePlate(x, y, platePurble);
            case 7 -> c=new Bomb(x, y, bombFile);
            case 5 ->c= new BlueGem(x,y, blueGemFile);
            case 6 -> c=new RedGem(x,y,redGemFile ); 
            case 4 ->c= new PurpleGem(x,y,purbleGemFile ); 
          
        }
       return c;
       
    }
}
