/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;


/**
 *
 * @author PICHU
 */
public class Usuario {
    //Atributos de un usuario
    String usuario;
    String contraseña;
    int tiempo = 0;
    int puntos = 0;
    int nivel = 1;
    
    //constructor
    public Usuario(String usuario, String contraseña){
        this.usuario = usuario;
        this.contraseña = contraseña;
    }
    
    //set y get de cada atributo
    public String getName(){
        return this.usuario;
    }
    
    public String getContraseña(){
        return this.contraseña;
    }
    
    public int getTiempo(){
        return this.tiempo;
    }
    
    public int getPuntos(){
        return this.puntos;
    }
    
    public int getNivel(){        
        return this.nivel;        
    }
    
    public void setTiempo(int tiempo){
        this.tiempo = tiempo;
    }
    
    public void setPuntos(int puntos){
        this.puntos = puntos;
    }
    
    public void setNivel(int nivel){
        this.nivel = nivel;
    }
}
