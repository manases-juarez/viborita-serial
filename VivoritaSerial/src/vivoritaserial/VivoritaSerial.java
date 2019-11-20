/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vivoritaserial;

import GUI.Login;
import Usuarios.Usuario;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author PICHU
 */
public class VivoritaSerial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*La aplicacion inica con el login, las estructuras de almacenamiento estan en Run_app
            En el login se colocan las variables estaticas y dinamicas
        */
        Run_app inicio = new Run_app();
        
        
        /*
        Usuarios de prueba
        */
        for(int i=0; i<25; i++){
            Login.inicio.usuarios.add(new Usuario("a"+i, "123"));
        }
        Random r = new Random();
        int var = 0;
        for(Usuario i:Login.inicio.usuarios){
            var = r.nextInt(100)+1;
            i.setPuntos(var);
            var = r.nextInt(100)+1;
            i.setTiempo(var);
        }
        // TODO code application logic here
        //JFrame.setDefaultLookAndFeelDecorated(true);
        //SubstanceLookAndFeel.setSkin("org.pushingpixels.substance.api.SubstanceSkin.BusinessSkin");
        //SubstanceLookAndFeel.se
        //UIManager.setLookAndFeel("");
        Login login = new Login();        
        login.show();
    }
    
}
