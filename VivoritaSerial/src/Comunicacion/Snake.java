/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicacion;

import java.util.LinkedList;

/**
 *
 * @author PICHU
 */
public class Snake {
    public int tamaño = 2;
    public LinkedList<Coordenada> serpiente = new LinkedList<>();   
    
    public Snake(){
        serpiente.add(new Coordenada(0, 11));
        serpiente.add(new Coordenada(0, 10));
    }
    
    
    
}
