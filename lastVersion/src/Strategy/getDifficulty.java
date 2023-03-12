/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Strategy;

import javax.swing.JOptionPane;
import Strategy.Strategy;

/**
 *
 * @author Detective_CN
 */
public class getDifficulty implements Strategy{
    
    private static int type=0;
    @Override
    public int getSpeedObjects(){
        
        switch (type) {
            case 2:
                return 1;          //Hard mode
            case 1:
                return 10;          //Normal
            default:
                return 20;          //Easy mode
        }
    }
    
    
      private static int typeclown=0;
    @Override
    public int getSpeedClown(){
        
        switch (typeclown) {
            case 2:
                return 10;          //Hard mode
            case 1:
                return 25;          //Normal
            default:
                return 35;          //Easy mode
        }
    }
    
    @Override
    public void SetDifficultyObjects(String s){
         
        if(s.equalsIgnoreCase("easy")){
            getDifficulty.type=0;
            getDifficulty.typeclown=0;
        }
        
        else if(s.equalsIgnoreCase("normal")){
            getDifficulty.type=1;
            getDifficulty.typeclown=1;
        }
        else if(s.equalsIgnoreCase("hard")){
            getDifficulty.type=2;
            getDifficulty.typeclown=2;
        }
            //System.out.println("inside");
    }

    @Override
    public int getBombCoolDown() {
        int a=1000;
       switch(type){
           case 0->a=1200;
           case 1->a=800;
           case 2->a=400;
    }
return a;
}
    @Override
    public int checkcooldown(){
        int cooldown=100;
    switch(type){
        case 2 ->cooldown=75;
        case 1->cooldown= 85;
        case 0 ->cooldown =100;
    }
    return cooldown;
    
}
}
