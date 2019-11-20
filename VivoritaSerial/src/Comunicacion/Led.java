/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicacion;

import GUI.Usuario;
import java.awt.Color;
import java.awt.Font;
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
        this.boton.setBounds(x*50, y*50, 50, 50);
        this.boton.setFont(new Font("Arial", Font.PLAIN, 10));
        this.boton.setBackground(Color.WHITE);
        this.boton.setText(x + " " + y);
    }
        
    /**/
    public void pintar_comida(int nivel){
        Random r = new Random();
        int rx = r.nextInt(12), ry = r.nextInt(12);
        boolean e = false;            
        if(nivel == 1){
            while(!e){
                if(rx == 6){
                    if(ry>3 && ry<9){
                        rx = r.nextInt(12);
                        ry = r.nextInt(12);
                    }else
                        e = true;
                }else
                    e = true;                
            }
            System.out.println(rx + "  " + ry);
            for(Led i: Usuario.matriz){
                if(rx == i.x && ry == i.y){
                    i.esComida = true;
                    i.boton.setBackground(Color.BLUE);
                    i.valor = true;
                }                
            }
        }else if(nivel == 2){
            boolean a=false, b=false;
            while(!e){
                if(rx == 0 || rx == 11)
                    rx = r.nextInt(12);
                else
                    a = true;
                if(ry == 0 || ry == 11)
                    ry = r.nextInt(12);
                else
                    b = true;
                if(a && b)
                    e = true;
                
            }
            System.out.println(rx + "  " + ry);
            for(Led i: Usuario.matriz){
                if(rx == i.x && ry == i.y){
                    i.esComida = true;
                    i.boton.setBackground(Color.BLUE);
                    i.valor = true;
                }                
            }
        }else if(nivel == 3){
            boolean a =true, b=true;
            while(!e){
                if(rx == 0 || rx == 11 || rx == 6)
                    rx = r.nextInt(12);
                else
                    a = false;                                                                       
                if((ry>0 && ry <5) || (ry>6 && ry <12)){
                    ry = r.nextInt(12);
                    b = false;
                }             
                if(!a && !b)
                    e = true;
            }
            System.out.println(rx + "  " + ry);
            for(Led i: Usuario.matriz){
                if(rx == i.x && ry == i.y){
                    i.esComida = true;
                    i.boton.setBackground(Color.BLUE);
                    i.valor = true;
                }                
            }
        }
    }
    /*
    Metodo para pintar los obstaculos
    */
    public void pintar_obstaculo(int nivel){
        if(nivel == 1){
            for(Led i: Usuario.matriz){
                if(i.x == 6){
                    if(i.y>3 && i.y < 9){
                        i.esObstaculo = true;
                        i.boton.setBackground(Color.BLUE);
                        i.valor = true;                            
                    }
                }
            }            
        }else if(nivel == 2){
            for(Led i: Usuario.matriz){
                if(i.esObstaculo){
                    i.valor = false;
                    i.esObstaculo = false;
                }
                switch(i.x){
                    case 0:
                        if(i.y>=0 && i.y<5){
                            i.esObstaculo = true;
                            i.boton.setBackground(Color.BLUE);
                            i.valor = true;
                        }
                        break;
                    case 11:
                        if(i.y>6 && i.y<12){
                            i.esObstaculo = true;
                            i.boton.setBackground(Color.BLUE);
                            i.valor = true;
                        }
                        break;
                }                                    
                switch(i.y){
                    case 0:
                        if(i.x>=0 && i.x<5){
                            i.esObstaculo = true;
                            i.boton.setBackground(Color.BLUE);
                            i.valor = true;
                        }
                        break;
                    case 11:
                        if(i.x>6 && i.x<12){
                            i.esObstaculo = true;
                            i.boton.setBackground(Color.BLUE);
                            i.valor = true;
                        }
                        break; 
                }
            }
        }else if(nivel == 3){
            pintar_obstaculo(1);
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
