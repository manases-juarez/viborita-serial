/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicacion;

import static Comunicacion.Control.snake;
import GUI.Usuario;
import java.awt.Color;


/**
 *
 * @author PICHU
 */
public class Hilo_serpiente extends Thread{
    
    @Override
    public void run(){
        while(Usuario.play){
            if(!Control.pause){
                int px = snake.serpiente.get(0).x;
                int py = snake.serpiente.get(0).y;
                for(Led i: Usuario.matriz){
                    if(i.esSnake){
                        i.esSnake = false;
                        i.valor = false;
                        i.boton.setBackground(Color.darkGray);
                    }
                }
                if(Control.right){
                    System.out.println("moviendo a la derecha");
                    for(Coordenada i: snake.serpiente){
                        i.x = px;
                        i.y = py;
                        px = i.x;
                        py = i.y;                        
                    }
                    snake.serpiente.get(0).y--;                    
                }else if(Control.left){
                    System.out.println("moviendo a la izquierda");
                    for(Coordenada i: snake.serpiente){
                        i.x = px;
                        i.y = py;
                        px = i.x;
                        py = i.y;                        
                    }
                    snake.serpiente.get(0).y++; 
                }else if(Control.up){
                    System.out.println("moviendo haca arriba");
                    for(Coordenada i: snake.serpiente){
                        i.x = px;
                        i.y = py;
                        px = i.x;
                        py = i.y;                        
                    }
                    snake.serpiente.get(0).x--;
                }else if(Control.down){
                    System.out.println("moviendo haca abajo");
                    for(Coordenada i: snake.serpiente){
                        i.x = px;
                        i.y = py;
                        px = i.x;
                        py = i.y;                        
                    }
                    snake.serpiente.get(0).x++;
                } 
            }


            
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){} 
        }
    }
}
