/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicacion;

import GUI.Usuario;
import java.awt.Color;
import java.util.Random;
import javax.swing.JButton;
import jnpout32.pPort;

/**
 *
 * @author PICHU
 */
public class Led {
    public int x;
    public int y;
    public Boolean valor = false;
    public Boolean esComida = false;
    public Boolean esObstaculo = false;
    public Boolean esSnake = false;
    public JButton boton = new JButton();
    
    
    public Led(int x, int y){
        this.x = x;
        this.y = y;
        this.boton.setBounds(x*25, y*25, 25, 25);
        this.boton.setBackground(Color.DARK_GRAY);
    }
    
    /*
    Metodo para pintar los obstaculos
    */
    public void pintar_obstaculo(int nivel){
        if(nivel == 1){
            Random r = new Random();
            int rx = r.nextInt(12), ry = r.nextInt(12);
            for(Led i: Usuario.matriz){
                if(rx == i.x && ry == i.y){
                    i.esComida = true;
                    i.boton.setBackground(Color.BLUE);
                    i.valor = true;
                }
                else if(i.x == 6){
                    if(i.y>3 && i.y < 9){
                        i.esObstaculo = true;
                        i.boton.setBackground(Color.BLUE);
                        i.valor = true;                            
                    }
                }
            }            
        }
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
