/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Comunicacion.Control;
import Comunicacion.Coordenada;
import Comunicacion.Hilo_comparacion;
import Comunicacion.Hilo_serpiente;
import Comunicacion.Led;
import Comunicacion.Timer;
import GUI.User.About;
import java.awt.Color;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import jnpout32.pPort;
import vivoritaserial.Run_app;

/**
 *
 * @author PICHU
 */
public class Usuario extends javax.swing.JFrame implements Runnable{

    public static Boolean play = false;
    public static LinkedList<Led> matriz = new LinkedList<>();
    public static int nivel = 1;
    public static int velocidad = 750;
    public static int puntos = 0;
    public static int tiempo = 0;
    Thread hilo1;
        
    
    /**
     * Creates new form Usuario
     */
    public Usuario() {
        initComponents();
        this.setTitle(Login.app_usuario);
        Usuarios.Usuario a = Login.inicio.buscar_usuario(Login.app_usuario, "U");
        this.jLabel7.setText(Integer.toString(a.getTiempo()));
        this.jLabel8.setText(Integer.toString(a.getPuntos()));
        this.jLabel9.setText(Integer.toString(a.getNivel()));
        this.jLabel10.setText(a.getName());
        this.jButton4.setEnabled(false);
        for(int i=0; i<12; i++){
            for(int j=0; j<12; j++){
                Led led = new Led(j, i);
                matriz.add(led);
                this.jPanel1.add(led.boton);
                this.jPanel1.repaint();
            }
        }
        
        Led b = new Led(1,2);
        b.pintar_obstaculo(nivel);
        b.pintar_comida(nivel);
        /*
        7 - Tiempo
        8 - Puntos
        9 - Nivel
        10 - Usuario        
        */
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("Tiempo");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setText("Puntos");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setText("Nivel");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setText("Usuario");

        jButton1.setText("Acerda de");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Ayuda");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Fin");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Play");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Log out");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel6.setText("Snake");

        jLabel7.setText("jLabel7");

        jLabel8.setText("jLabel8");

        jLabel9.setText("jLabel9");

        jLabel10.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 603, Short.MAX_VALUE)
        );

        jButton6.setText("Right");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Left");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Up");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Down");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Iniciar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton9))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(35, 35, 35)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(28, 28, 28)
                        .addComponent(jButton6)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton8)
                            .addComponent(jButton9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton4)
                            .addComponent(jButton10))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel10))
                        .addGap(43, 43, 43))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 14, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //About
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        About a = new About();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    //Salir
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Control.pause = !Control.pause;
        Control.snake.serpiente.clear();
        Control.snake.serpiente.add(new Coordenada(0, 11));
        Control.snake.serpiente.add(new Coordenada(0, 10));
        Control.snake.serpiente.add(new Coordenada(0, 9));
        Login a = new Login();
        a.setVisible(true);
        this.dispose();
        Run_app.usuario = null;
        
    }//GEN-LAST:event_jButton5ActionPerformed

    //Play
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Control.pause = !Control.pause;                               
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        play = false;
    }//GEN-LAST:event_jButton2ActionPerformed

    //Right
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if(!Control.left){
            Control.down = false;
            Control.left = false;
            Control.right = true;
            Control.up = false;
        }
        
    }//GEN-LAST:event_jButton6ActionPerformed

    //Left
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if(!Control.right){
            Control.down = false;
            Control.left = true;
            Control.right = false;
            Control.up = false;
        }
        
    }//GEN-LAST:event_jButton7ActionPerformed

    //Up
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if(!Control.down){
            Control.down = false;
            Control.left = false;
            Control.right = false;
            Control.up = true;
        }
        
    }//GEN-LAST:event_jButton8ActionPerformed

    //Down
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if(!Control.up){
            Control.down = true;
            Control.left = false;
            Control.right = false;
            Control.up = false;
        }
        
    }//GEN-LAST:event_jButton9ActionPerformed

    //Iniciar
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        Control.pause = !Control.pause;
        this.jButton4.setEnabled(true);
        this.jButton10.setEnabled(false);
        Hilo_serpiente serpiente = new Hilo_serpiente();
        Hilo_comparacion datos = new Hilo_comparacion();
        Timer timer = new Timer();
        if(!play){
            play = true;
            hilo1 = new Thread(this);
            serpiente.start();
            datos.start();
            hilo1.start();
            timer.start();
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    //salir
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Login a = new Login();
        Control.pause = !Control.pause;
        Control.snake.serpiente.clear();
        Control.snake.serpiente.add(new Coordenada(0, 11));
        Control.snake.serpiente.add(new Coordenada(0, 10));
        Control.snake.serpiente.add(new Coordenada(0, 9));
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
   

    /*
    Comunicacion serial por medio del puerto paralelo
    pin 2: envio de las señales
    pin 3: clock carga de las señales
    pin 4:
    */
    pPort puerto = new pPort();
    short pin2 = 2;
    short pin3 = 3;
    short uno = 1;
    short cero = 0;
    @Override
    public void run() {
        while(play){
            this.jLabel7.setText(Integer.toString(tiempo));
            this.jLabel8.setText(Integer.toString(puntos));
            this.jLabel9.setText(Integer.toString(nivel));
            if(!Control.pause){
                for(Led i:matriz){
                    if(i.valor){
                        i.boton.setBackground(Color.blue);
                        i.boton.repaint();
                        puerto.setPin(pin2, uno);
                    }else{
                        puerto.setPin(pin2, cero);
                        i.boton.setBackground(Color.white);
                    }
                    puerto.setPin(pin3, uno);
                    try{
                        Thread.sleep(1);
                    }catch(InterruptedException e){}
                    puerto.setPin(pin3, cero);
                    try{
                        Thread.sleep(1);
                    }catch(InterruptedException e){}                                        
                }
                for(Led i:matriz){
                    Boolean hay = false, muere = false;                   
                    Coordenada cor = new Coordenada(0,0);                        
                    for(Coordenada j: Control.snake.serpiente){
                        if(j.x>11 || j.y>11 || j.x<0 || j.y<0){
                            play = false;
                            JOptionPane.showMessageDialog(null, "Juego finalizado 1");
                            muere = true;
                            break;
                        }
                        if(j.x == i.x && j.y == i.y){
                            i.boton.setBackground(Color.blue);
                            i.esSnake = true;
                            i.valor = true; //Jorge 56358841
                            if(i.esComida){
                                hay = true;
                                puntos = puntos +10;
                                System.out.println(puntos);
                                cor.setCoordenada(i.x, i.y);
                                Led b = new Led(1,2);
                                b.pintar_comida(nivel);
                                i.esComida = false;
                            }else if(i.esObstaculo){
                                play = false;
                                muere = true;
                                JOptionPane.showMessageDialog(null, "Juego finalizado xd");
                            }
                        }                        
                    }
                    if(muere){
                        Usuarios.Usuario a = Login.inicio.buscar_usuario(Login.app_usuario, "U");
                        a.setNivel(nivel);
                        a.setPuntos(puntos);
                        a.setTiempo(tiempo);
                        break;                    
                    }                        
                    if(hay){
                        Control.snake.serpiente.add(cor);
                        System.out.println(Control.snake.serpiente.size());
                    }
                }                
            }                       
        }                
        
    }
}
