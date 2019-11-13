/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicacion;

import jnpout32.pPort;

/**
 *
 * @author PICHU
 */
public class Led {
    private final int x;
    private final int y;
    private final Boolean valor;
    
    public Led(int x, int y){
        this.x = x;
        this.y = y;
        this.valor = false;
    }
    
    public void ejecutar_(String cadena){
        System.out.println("Star connection...");
        
        try{
            pPort puerto = new pPort();
            short pin = 2;
            
            for(int i=0; i<cadena.length(); i++){
                if(cadena.charAt(i) == '0')
                    puerto.setPin(pin, (short)0);
                else
                    puerto.setPin(pin, (short)1);
                System.out.println("Pin "+cadena.charAt(i));
                Thread.sleep(1000);
            }                                              
        }catch (Exception e){
            System.out.println("Failed to open port with exeption: " + e);
        }
        System.out.println("END ---------- XXXXXXX");
    } 
}
