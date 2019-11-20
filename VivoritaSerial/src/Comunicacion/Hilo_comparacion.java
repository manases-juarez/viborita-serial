/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicacion;

import GUI.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author GRUPO1
 */
public class Hilo_comparacion extends Thread{
    
    @Override
    public void run(){   
        while(Usuario.play){
            while(!Control.pause){
                if(Usuario.puntos == 30){
                    Control.pause = true;
                    Usuario.nivel = 2;
                    Usuario.velocidad = 500;
                    Led b = new Led(1 , 2);
                    Usuario.puntos = Usuario.puntos + 10;
                    Control.snake.serpiente.clear();
                    Control.snake.serpiente.add(new Coordenada(0, 11));
                    Control.snake.serpiente.add(new Coordenada(0, 10));
                    Control.snake.serpiente.add(new Coordenada(0, 9));
                    b.pintar_obstaculo(2);
                    Control.down = false;
                    Control.left = false;
                    Control.right = true;
                    Control.up = false;
                    JOptionPane.showMessageDialog(null, "Bonus + 10");
                }else if(Usuario.puntos == 60){
                    Control.pause = true;
                    Usuario.nivel = 3;
                    Usuario.velocidad = 300;
                    Usuario.puntos = Usuario.puntos + 10;
                    Control.snake.serpiente.clear();
                    Control.snake.serpiente.add(new Coordenada(0, 11));
                    Control.snake.serpiente.add(new Coordenada(0, 10));
                    Control.snake.serpiente.add(new Coordenada(0, 9));
                    Control.down = false;
                    Control.left = false;
                    Control.right = true;
                    Control.up = false;
                    Led b = new Led(2,3);
                    b.pintar_obstaculo(3);
                    JOptionPane.showMessageDialog(null, "Bonus + 10");
                }else if(Usuario.puntos == 90){
                    Control.pause = true;
                    Usuario.nivel = 3;
                    Usuario.velocidad = 300;
                    JOptionPane.showMessageDialog(null, "Has ganado el juego");
                }
                try{
                    Thread.sleep(10);
                }catch(InterruptedException e){} 
            }
    
        }
            
    }
}
