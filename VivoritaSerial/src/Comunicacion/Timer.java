/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicacion;

import GUI.Usuario;

/**
 *
 * @author GRUPO1
 */
public class Timer extends Thread{
    @Override
    public void run(){
        while(Usuario.play){
            while(!Control.pause){
                Usuario.tiempo++;
                try{
                Thread.sleep(1000);
                }catch(InterruptedException e){}
            }
            
        }
    }
}
