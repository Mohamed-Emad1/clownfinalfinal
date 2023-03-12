/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Constants;

import backend.ImageObject;

/**
 *
 * @author Detective_CN
 */
public class BackgroundObj extends ImageObject{
    
    private static BackgroundObj backgroundobject =null;
    private BackgroundObj(int x, int y, String imaString, int uy) {
        super(x, y, imaString,uy);
    }
    
    public static BackgroundObj getIstance (int x, int y, String imaString) {
        
        if(backgroundobject==null)  {
           backgroundobject = new BackgroundObj(x, y, imaString, 0);
        }
        return backgroundobject;
    }
    
}
