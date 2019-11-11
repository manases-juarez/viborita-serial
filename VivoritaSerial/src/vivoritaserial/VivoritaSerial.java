/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vivoritaserial;

import GUI.Login;
import javax.swing.JFrame;
import javax.swing.UIManager;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;

/**
 *
 * @author PICHU
 */
public class VivoritaSerial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //JFrame.setDefaultLookAndFeelDecorated(true);
        //SubstanceLookAndFeel.setSkin("org.pushingpixels.substance.api.SubstanceSkin.BusinessSkin");
        //SubstanceLookAndFeel.se
        //UIManager.setLookAndFeel("");
        Login login = new Login();
        
        login.show();
    }
    
}
