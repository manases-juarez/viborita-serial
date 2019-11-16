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
                        i.valor = false;                        
                    }
                }
                if(Control.right){
                    for(int i=0; i<snake.serpiente.size(); i++){
                        if(i==0){
                            snake.serpiente.get(0).y--;
                        }else{
                            int tempx = snake.serpiente.get(i).x;
                            int tempy = snake.serpiente.get(i).y;
                            snake.serpiente.get(i).x = px;
                            snake.serpiente.get(i).y = py;
                            px = tempx;
                            py = tempy;
                        }
                    }                     
                }else if(Control.left){
                    for(int i=0; i<snake.serpiente.size(); i++){
                        if(i==0){
                            snake.serpiente.get(0).y++;
                        }else{
                            int tempx = snake.serpiente.get(i).x;
                            int tempy = snake.serpiente.get(i).y;
                            snake.serpiente.get(i).x = px;
                            snake.serpiente.get(i).y = py;
                            px = tempx;
                            py = tempy;
                        }
                    } 
                }else if(Control.up){
                    for(int i=0; i<snake.serpiente.size(); i++){
                        if(i==0){
                            snake.serpiente.get(0).x--;
                        }else{
                            int tempx = snake.serpiente.get(i).x;
                            int tempy = snake.serpiente.get(i).y;
                            snake.serpiente.get(i).x = px;
                            snake.serpiente.get(i).y = py;
                            px = tempx;
                            py = tempy;
                        }
                    }                     
                }else if(Control.down){
                    for(int i=0; i<snake.serpiente.size(); i++){
                        if(i==0){
                            snake.serpiente.get(0).x++;
                        }else{
                            int tempx = snake.serpiente.get(i).x;
                            int tempy = snake.serpiente.get(i).y;
                            snake.serpiente.get(i).x = px;
                            snake.serpiente.get(i).y = py;
                            px = tempx;
                            py = tempy;
                        }
                    }                    
                } 
            }


            
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){} 
        }
    }
}
