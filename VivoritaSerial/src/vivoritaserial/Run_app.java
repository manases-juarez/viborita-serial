/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vivoritaserial;

import Usuarios.Usuario;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 *
 * @author PICHU
 */
public class Run_app {
    /*
     * Listas de almacenamiento de los usuarios
     * usuarios son los que ya estan registrados
     * solicitudes son lo que estan pendientes de que se aprueben    
    */
    public LinkedList<Usuario> usuarios = new LinkedList<>();
    public LinkedList<Usuario> solicitudes = new LinkedList<>();
    
    public Run_app(){
        //Llamada del constructor
    }
        
    /*
    Metodo para el encabezado de los usuarios completo
    */
    public String[] getColumnasT(){
        String columnas[] = new String[5];
        columnas[0] = "No";
        columnas[1] = "Nombre";
        columnas[2] = "Nivel";        
        columnas[3] = "Puntos";
        columnas[4] = "Tiempo";            
        
        return columnas;    
    }
    
    /*
    Metodo para las filas de los usuarios completo
    */
    public Object[][] getFilasT(){
        int c = usuarios.size();
        int cont = 0;
        Object[][] fila = new Object[c][5];            
        for(Usuario i: usuarios){
            if(i != null){
                fila[cont][0] = cont;
                fila[cont][1] = i.getName();
                fila[cont][2] = i.getNivel();
                fila[cont][3] = i.getPuntos();   
                fila[cont][4] = i.getTiempo();   
                cont++;
            }                
        }
        return fila;
    }
    
    /*
    Metodo que obtiene datos para las filas
    P puntos
    T tiempo
    */
    public Object[][] getFilas(String orden){
        int c = 0;
        Object[][] fila = new Object[10][4];            
        if(orden.equals("P")){
            for(Usuario i: usuarios){
                if(i != null){
                    if(c<10){
                        fila[c][0] = c;
                        fila[c][1] = i.getName();
                        fila[c][2] = i.getPuntos();
                        fila[c][3] = i.getNivel();
                        c++;
                    }                    
                }                
            }            
        }else{
            for(Usuario i: usuarios){
                if(i != null){
                    if(c<10){
                        fila[c][0] = c;
                        fila[c][1] = i.getName();
                        fila[c][2] = i.getTiempo();
                        fila[c][3] = i.getNivel();
                        c++;
                    }                    
                }                
            }
        }
        return fila;
    }
    
    /*
    Metod que obtiene datos para el encabezado
    */
    public String[] getColumnas(String orden){
        String columnas[] = new String[4];
        columnas[0] = "No";
        columnas[1] = "Nombre";
        columnas[3] = "Nivel";
            
        if(orden.equals("P")){
            columnas[2] = "Puntos";
        }else{
            columnas[2] = "Tiempo";
        }
        return columnas;    
    }
    
    
    /*
    Metodo que ordena la lista por tiempo
    */
    public void Ordenar_tiempo(){
        Collections.sort(usuarios, new Comparator<Usuario>(){
            @Override
            public int compare(Usuario u1, Usuario u2){
                return u2.getTiempo() - u1.getTiempo();
            }
        });
    }
      
    /*
    Metodo que orden la lista por usuario
    */
    public void Ordenar_usuario(){
        Collections.sort(usuarios, new Comparator<Usuario>(){
            @Override
            public int compare(Usuario u1, Usuario u2){
                return u2.getName().compareTo(u1.getName());
            }
        });
    }
    
    /*
    Metodo que ordena la lista por puntos
    */
    public void Ordenar_puntos(){
        Collections.sort(usuarios, new Comparator<Usuario>(){
            @Override
            public int compare(Usuario u1, Usuario u2){
                return u2.getPuntos() - u1.getPuntos();
            }
        });
    }
    
    
    /*
    Metodo que verifica el usuario de contraseña a la hora de iniciar
    sesion devuelve un objeto de tipo Usuario
    */
    public Usuario iniciarSesion(String usuario, String contraseña){
        for(Usuario i: usuarios){
            if(i != null){
                if(usuario.equals(i.getName()) && contraseña.equals(i.getContraseña())){
                    return i;
                }
            }
        }
        return null;
    }
    
    /*
    Metodo que verifica si existe un usuario por medio del nombre
    de usuario
    */
    public Boolean existe_usuario(String usuario){
        for(Usuario i: usuarios){
            if(i != null){
                if(usuario.equals(i.getName())){
                    return true;
                }
            }
        }
        return false;
    }
    
    /*
    Metodo que verifica si un usuario ha realizado una solicitud
    devuelve true si existe la solicitud
    */
    public Boolean existe_solicitud(String usuario){
        for(Usuario i: solicitudes){
            if(i != null){
                if(usuario.equals(i.getName())){
                    return true;
                }
            }
        }
        return false;
    }
    
    /*
    Agrega una nueva solicitud a la lista
    */
    public void addSolicitud(Usuario usuario){
        solicitudes.add(usuario);
    }
    
    /*
    Agrega un nuevo usuario la estrucutura de usuarios
    */
    public void addUsuario(Usuario usuario){
        this.usuarios.add(usuario);
    }
}
