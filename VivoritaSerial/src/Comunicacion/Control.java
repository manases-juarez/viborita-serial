/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicacion;

/**
 *
 * @author PICHU
 */
public class Control {
    public static Boolean right = true;
    public static Boolean left = false;
    public static Boolean up = false;
    public static Boolean down = false;
    public static Boolean pause = true;
    
    public static Snake snake = new Snake();
    private Boolean play = false;
    
    public Boolean getPlay(){
        return play;
    }
    
    public void setPlay(Boolean play){
        this.play = play;
    }
    
    
    public Control(){
        
    }
}
