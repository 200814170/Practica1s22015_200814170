/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.no.pkg1;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Tony
 */
public class Juego extends javax.swing.JFrame {

    /**
     * Creates new form Crear_Juego
     */
    Crear_Juego crear_juego = new Crear_Juego();
    int longitud = 0;
    int longitud1 = 0;
    int contador_filas = 0;
    int contador_columnas = 0;
    int donde = 0;
    int conta_celdas;
    int conta_columnas;
    int contador_ID = 0;
    int donde_mario = 0;
    int puntos = 0;
    int vidas = 1;

    String objeto_seleccionado = "";
    String crono;
    Carga_Objetos carga_objetos = new Carga_Objetos(null, null, 0);
    Matriz Matriz_Tablero_Juego = new Matriz();
    Matriz Matriz_inicial = new Matriz();
    boolean Pausa = false;
    boolean jugar = false;

    javax.swing.JLabel[] label;
    int contador_Lista = 0;
    String hora = "00", min = "00", seg = "00";
    int horas = 0, minutos = 0, segundos = 0, ds = 0;
    Thread cronometro = new Thread() {//declaramos el hilo
        @Override
        public void run() {
            try {
                while (true) {//ciclo infinito
                    if (ds == 99) {//si los decisegundos son iguales a 99
                        ds = 0;//decisegundo vuelve a empezar en cero
                        segundos++;
                        if (segundos < 10) {
                            seg = "0" + segundos;
                        } else {
                            seg = segundos + "";
                        }
                    }
                    if (segundos == 59) {
                        segundos = 0;
                        minutos++;
                        if (minutos < 10) {
                            min = "0" + minutos;
                        } else {
                            min = minutos + "";
                        }
                    }
                    if (minutos == 59) {
                        minutos = 0;
                        horas++;
                        if (horas < 10) {
                            hora = "0" + horas;
                        } else {
                            hora = horas + "";
                        }

                    }
                    ds++;//aumentan las decimas de segundo

                    hora_label(hora, min, seg);

                    cronometro.sleep(10);//que duerma una decima de segundo
                }
            } catch (java.lang.InterruptedException ie) {
                System.out.println(ie.getMessage());
            }
        }
    };

    public Juego(int contador_filas, int contador_columnas, Matriz Matriz) {
        initComponents();
        this.jButton2.setEnabled(false);
        this.jButton5.setEnabled(false);
        this.contador_filas = contador_filas;
        this.contador_columnas = contador_columnas;
        contador_Lista = contador_filas * contador_columnas;
        label = new javax.swing.JLabel[contador_Lista];
        this.jLabel3.setText("0" + puntos);
        this.jLabel5.setText("0" + vidas);

        Nodo_Matriz actual_Matriz1 = Matriz.raiz;
        Nodo_Matriz actual_Matriz2;

        Matriz_inicial.sampar_matriz(actual_Matriz1.objeto, 1, 0);
        actual_Matriz2 = actual_Matriz1.izquierda;
        while (actual_Matriz2 != null) {
            Matriz_inicial.sampar_matriz(actual_Matriz2.objeto, 1, 1);
            actual_Matriz2 = actual_Matriz2.izquierda;
        }

        actual_Matriz1 = Matriz.raiz.abajo;
        while (actual_Matriz1 != null) {
            Matriz_inicial.sampar_matriz(actual_Matriz1.objeto, 1, 2);
            actual_Matriz2 = actual_Matriz1.izquierda;
            while (actual_Matriz2 != null) {
                Matriz_inicial.sampar_matriz(actual_Matriz2.objeto, 1, 3);
                actual_Matriz2 = actual_Matriz2.izquierda;
            }
            actual_Matriz1 = actual_Matriz1.abajo;
        }
        
        Matriz_inicial.reacomodar_indices();

        this.Matriz_Tablero_Juego.raiz = Matriz.raiz;
        this.Pane_principal.setBackground(Color.BLUE);

        this.crear_pane_principal(this.contador_filas, this.contador_columnas);
        SwingUtilities.updateComponentTreeUI(this);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Pane_principal = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout Pane_principalLayout = new javax.swing.GroupLayout(Pane_principal);
        Pane_principal.setLayout(Pane_principalLayout);
        Pane_principalLayout.setHorizontalGroup(
            Pane_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 927, Short.MAX_VALUE)
        );
        Pane_principalLayout.setVerticalGroup(
            Pane_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 472, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(Pane_principal);

        jButton1.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica/no/pkg1/Imagenes/play_1.jpg"))); // NOI18N
        jButton1.setText("Jugar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica/no/pkg1/Imagenes/pause.jpg"))); // NOI18N
        jButton2.setText("Pausa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton2KeyPressed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica/no/pkg1/Imagenes/mostrar.png"))); // NOI18N
        jButton4.setText("Graficar Matriz");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jButton4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton4KeyPressed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica/no/pkg1/Imagenes/Eliminar.gif"))); // NOI18N
        jButton5.setText("Reiniciar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jButton5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton5KeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        jLabel2.setText("Puntos:");

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        jLabel3.setText("0000");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        jLabel4.setText("Vidas:");

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        jLabel5.setText("00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addGap(107, 107, 107))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(280, 280, 280)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Jugar
        this.jButton1.setEnabled(false);
        this.jButton2.setEnabled(true);
        this.jButton5.setEnabled(true);
        jugar = true;
        if (this.Pausa) {
            cronometro.resume();
            Pausa = false;
        } else {
            cronometro.start();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Pausar
        cronometro.suspend();
        jugar = false;
        Pausa = true;
        this.jButton1.setEnabled(true);
        this.jButton2.setEnabled(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Graficar Matriz
        Graficar_Estructuras GE = new Graficar_Estructuras();
        GE.Grificar_Matriz(this.Matriz_Tablero_Juego);
        try {
            File objetofile = new File("Matriz.jpg");
            Desktop.getDesktop().open(objetofile);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // Reiniciar
        cronometro.suspend();//se suspende el hilo.. (NO utilizamos hilo.stop() porque si lo usamos, el hilo se "muere")
        ds = segundos = minutos = horas = 0;
        hora_label("00", "00", "00");
        Pausa = true;
        jugar = false;
        this.jButton1.setEnabled(true);
        this.jButton2.setEnabled(false);
        this.jButton5.setEnabled(false);

        System.out.println("Matriz");
        this.Matriz_Tablero_Juego.imprimir_matriz();
        this.Matriz_Tablero_Juego.eliminar_matriz();
        this.Matriz_Tablero_Juego.raiz = this.Matriz_inicial.raiz;

        System.out.println("Matriz Original");
        this.Matriz_Tablero_Juego.imprimir_matriz();
        
        this.vidas = 1;
        this.puntos = 0;
        
        this.crear_pane_principal(this.contador_filas, this.contador_columnas);
        SwingUtilities.updateComponentTreeUI(this);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
        if (this.jugar == true) {
            if (evt.getKeyCode() == 39) {//izquierda
                //JOptionPane.showMessageDialog(this, "yaaaaaaaaaaaaaaaaaaaaaa" + evt.getKeyCode());
                mover_mario(39);
            }
            if (evt.getKeyCode() == 37) {//derecha
                //JOptionPane.showMessageDialog(this, "yaaaaaaaaaaaaaaaaaaaaaa" + evt.getKeyCode());
                mover_mario(37);
            }
            if (evt.getKeyCode() == 38) {//arriba
                //JOptionPane.showMessageDialog(this, "yaaaaaaaaaaaaaaaaaaaaaa" + evt.getKeyCode());
                mover_mario(38);
            }
            if (evt.getKeyCode() == 40) {//abajo
                //JOptionPane.showMessageDialog(this, "yaaaaaaaaaaaaaaaaaaaaaa" + evt.getKeyCode());
            }
        }
    }//GEN-LAST:event_jButton1KeyPressed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
        // TODO add your handling code here:
        if (this.jugar == true) {
            if (evt.getKeyCode() == 39) {//izquierda
                //JOptionPane.showMessageDialog(this, "yaaaaaaaaaaaaaaaaaaaaaa" + evt.getKeyCode());
                mover_mario(39);
            }
            if (evt.getKeyCode() == 37) {//derecha
                //JOptionPane.showMessageDialog(this, "yaaaaaaaaaaaaaaaaaaaaaa" + evt.getKeyCode());
                mover_mario(37);
            }
            if (evt.getKeyCode() == 38) {//arriba
                //JOptionPane.showMessageDialog(this, "yaaaaaaaaaaaaaaaaaaaaaa" + evt.getKeyCode());
                mover_mario(38);
            }
            if (evt.getKeyCode() == 40) {//abajo
                //JOptionPane.showMessageDialog(this, "yaaaaaaaaaaaaaaaaaaaaaa" + evt.getKeyCode());
            }
        }
    }//GEN-LAST:event_jButton2KeyPressed

    private void jButton5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton5KeyPressed
        // TODO add your handling code here:
        if (this.jugar == true) {
            if (evt.getKeyCode() == 39) {//izquierda
                //JOptionPane.showMessageDialog(this, "yaaaaaaaaaaaaaaaaaaaaaa" + evt.getKeyCode());
                mover_mario(39);
            }
            if (evt.getKeyCode() == 37) {//derecha
                //JOptionPane.showMessageDialog(this, "yaaaaaaaaaaaaaaaaaaaaaa" + evt.getKeyCode());
                mover_mario(37);
            }
            if (evt.getKeyCode() == 38) {//arriba
                //JOptionPane.showMessageDialog(this, "yaaaaaaaaaaaaaaaaaaaaaa" + evt.getKeyCode());
                mover_mario(38);
            }
            if (evt.getKeyCode() == 40) {//abajo
                //JOptionPane.showMessageDialog(this, "yaaaaaaaaaaaaaaaaaaaaaa" + evt.getKeyCode());
            }
        }
    }//GEN-LAST:event_jButton5KeyPressed

    private void jButton4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton4KeyPressed
        // TODO add your handling code here:
        if (this.jugar == true) {
            if (evt.getKeyCode() == 39) {//izquierda
                //JOptionPane.showMessageDialog(this, "yaaaaaaaaaaaaaaaaaaaaaa" + evt.getKeyCode());
                mover_mario(39);
            }
            if (evt.getKeyCode() == 37) {//derecha
                //JOptionPane.showMessageDialog(this, "yaaaaaaaaaaaaaaaaaaaaaa" + evt.getKeyCode());
                mover_mario(37);
            }
            if (evt.getKeyCode() == 38) {//arriba
                //JOptionPane.showMessageDialog(this, "yaaaaaaaaaaaaaaaaaaaaaa" + evt.getKeyCode());
                mover_mario(38);
            }
            if (evt.getKeyCode() == 40) {//abajo
                //JOptionPane.showMessageDialog(this, "yaaaaaaaaaaaaaaaaaaaaaa" + evt.getKeyCode());
            }
        }
    }//GEN-LAST:event_jButton4KeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Juego(0, 0, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pane_principal;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public String cual_objeto(String ob) {
        if (ob.equals("Pared")) {
            return "src\\practica\\no\\pkg1\\Imagenes\\Pared.jpg";
        } else if (ob.equals("Suelo")) {
            return "src\\practica\\no\\pkg1\\Imagenes\\Suelo.jpg";
        } else if (ob.equals("Goomba")) {
            return "src\\practica\\no\\pkg1\\Imagenes\\goomba.png";
        } else if (ob.equals("Mario")) {
            return "src\\practica\\no\\pkg1\\Imagenes\\Mario.png";
        } else if (ob.equals("Tortuga")) {
            return "src\\practica\\no\\pkg1\\Imagenes\\Tortuga.jpg";
        } else if (ob.equals("Ficha")) {
            return "src\\practica\\no\\pkg1\\Imagenes\\ficha.jpg";
        } else if (ob.equals("Hongo")) {
            return "src\\practica\\no\\pkg1\\Imagenes\\Vida.jpg";
        } else if (ob.equals("Castillo")) {
            return "src\\practica\\no\\pkg1\\Imagenes\\Castillo.jpg";
        } else {
            return null;
        }
    }

    public void crear_pane_principal(int fila, int columna) {

        int tamaño_fila;
        int tamaño_columna;

        //Nodo_Lista temporal = /*carga_objetos.*/Lista_Objetos.primero;
        Nodo_Matriz temp1 = this.Matriz_Tablero_Juego.raiz;
        /*while (temporal != null) {
         temporal = temporal.siguiente;
         longitud++;
         }*/
        longitud = columna;

        int largo = 70 * columna;
        int ancho = 70 * fila;

        this.Pane_principal.removeAll();
        this.Pane_principal.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        this.Pane_principal.setPreferredSize(new Dimension(largo, ancho));

        int No_filas = fila;//Integer.parseInt(this.jTextField1.getText());
        int No_columnas = longitud;//Integer.parseInt(this.jTextField2.getText());

        int altura_pane_Matriz = ancho;//this.Pane_objetos.getSize().height;
        int ancho_pane_Matriz = largo;//this.Pane_objetos.getSize().width;

        tamaño_fila = ancho_pane_Matriz / No_columnas;
        tamaño_columna = altura_pane_Matriz / No_filas;

        contador_Lista = (No_filas * No_columnas);

        int columnas;
        int multiplicador_filas = 0;

        for (int Contador_celdas = 0; Contador_celdas < contador_Lista; Contador_celdas++) {
            if (temp1 != null) {
                label[Contador_celdas] = new javax.swing.JLabel();
                label[Contador_celdas].setBounds((tamaño_fila * 0), (tamaño_columna * multiplicador_filas), tamaño_fila, tamaño_columna);
                label[Contador_celdas].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                label[Contador_celdas].setBorder(BorderFactory.createLineBorder(Color.GRAY));
                if (temp1.objeto.equals("vacio")) {
                    label[Contador_celdas].removeAll();
                    label[Contador_celdas].repaint();
                } else {
                    ImageIcon img = new ImageIcon(cual_objeto(temp1.objeto));
                    Icon icono = new ImageIcon(img.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
                    label[Contador_celdas].removeAll();
                    label[Contador_celdas].setIcon(icono);
                    label[Contador_celdas].repaint();
                    label[Contador_celdas].setIcon(icono);
                }
                //label[Contador_celdas].setText("" + (Contador_celdas + 1));
                this.Pane_principal.add(label[Contador_celdas], null);

                int columna_temp = 1;
                //temp1 = temp1.abajo;
                Nodo_Matriz tempo = temp1.izquierda;
                for (columnas = Contador_celdas + 1; columnas < Contador_celdas + No_columnas; columnas++) {
                    if (tempo != null) {
                        label[columnas] = new javax.swing.JLabel();
                        label[columnas].setBounds(tamaño_fila * columna_temp, (tamaño_columna * multiplicador_filas), tamaño_fila, tamaño_columna);
                        label[columnas].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        label[columnas].setBorder(BorderFactory.createLineBorder(Color.GRAY));
                        if (tempo.objeto.equals("vacio")) {
                            label[columnas].removeAll();
                            label[columnas].repaint();
                        } else {
                            ImageIcon img1 = new ImageIcon(cual_objeto(tempo.objeto));
                            Icon icono1 = new ImageIcon(img1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
                            label[columnas].removeAll();
                            label[columnas].setIcon(icono1);
                            label[columnas].repaint();
                            label[columnas].setIcon(icono1);
                        }
                        //label[columnas].setText("" + (columnas + 1));
                        this.conta_columnas = columnas;
                        this.Pane_principal.add(label[columnas], null);

                        columna_temp++;
                        tempo = tempo.izquierda;
                    }
                }
                temp1 = temp1.abajo;
            }

            multiplicador_filas++;
            Contador_celdas = Contador_celdas + No_columnas - 1;
        }
    }

    public void actualizar() {
        SwingUtilities.updateComponentTreeUI(this);
    }

    public void cerrar() {
        this.setVisible(false);
    }

    public void hora_label(String hora, String min, String seg) {
        this.jLabel1.setText("Hora: " + hora + " Minutos: " + min + " Segundos: " + seg);
    }

    public int donde_esta_mario() {
        Nodo_Matriz mario = this.Matriz_Tablero_Juego.raiz;
        Nodo_Matriz mario1;
        while (mario != null) {
            if (mario.objeto.equals("Mario")) {
                return mario.ID;
            } else {
                mario1 = mario.izquierda;
                while (mario1 != null) {
                    if (mario1.objeto.equals("Mario")) {
                        return mario1.ID;
                    }
                    mario1 = mario1.izquierda;
                }
            }
            mario = mario.abajo;
        }
        return 0;
    }

    public String que_sigue(int donde) {
        Nodo_Matriz mario = this.Matriz_Tablero_Juego.raiz;
        Nodo_Matriz mario1;
        while (mario != null) {
            if (mario.objeto.equals("Mario")) {
                return mario.izquierda.objeto;
            } else {
                mario1 = mario.izquierda;
                while (mario1 != null) {
                    if (mario1.ID == donde) {
                        return mario1.izquierda.objeto;
                    }
                    mario1 = mario1.izquierda;
                }
            }
            mario = mario.abajo;
        }
        return null;
    }

    public String que_anterior(int donde) {
        Nodo_Matriz mario = this.Matriz_Tablero_Juego.raiz;
        Nodo_Matriz mario1;
        while (mario != null) {
            if (mario.objeto.equals("Mario")) {
                return mario.derecha.objeto;
            } else {
                mario1 = mario.izquierda;
                while (mario1 != null) {
                    if (mario1.ID == donde) {
                        return mario1.derecha.objeto;
                    }
                    mario1 = mario1.izquierda;
                }
            }
            mario = mario.abajo;
        }
        return null;
    }

    public String que_arriba(int donde) {
        Nodo_Matriz mario = this.Matriz_Tablero_Juego.raiz;
        Nodo_Matriz mario1;
        while (mario != null) {
            if (mario.objeto.equals("Mario")) {
                return mario.arriba.arriba.objeto;
            } else {
                mario1 = mario.izquierda;
                while (mario1 != null) {
                    if (mario1.ID == donde) {
                        return mario1.arriba.arriba.objeto;
                    }
                    mario1 = mario1.izquierda;
                }
            }
            mario = mario.abajo;
        }
        return null;
    }

    public String que_abajo(int donde) {
        Nodo_Matriz mario = this.Matriz_Tablero_Juego.raiz;
        Nodo_Matriz mario1;
        while (mario != null) {
            if (mario.objeto.equals("Mario")) {
                return mario.abajo.objeto;
            } else {
                mario1 = mario.izquierda;
                while (mario1 != null) {
                    if (mario1.ID == donde) {
                        return mario.abajo.objeto;
                    }
                    mario1 = mario1.izquierda;
                }
            }
            mario = mario.abajo;
        }
        return null;
    }

    public void mover_mario(int movimiento) {
        int temp = donde_esta_mario();
        //JOptionPane.showMessageDialog(this, "donde esta mario: " + temp);
        if (movimiento == 39) {
            if (que_sigue(temp).equals("vacio")) {
                Matriz_Tablero_Juego.modificar(temp, "vacio");
                Matriz_Tablero_Juego.modificar(temp + 1, "Mario");
                this.crear_pane_principal(this.contador_filas, this.contador_columnas);
                SwingUtilities.updateComponentTreeUI(this);
            } else if (que_sigue(temp).equals("Ficha")) {
                Matriz_Tablero_Juego.modificar(temp, "vacio");
                Matriz_Tablero_Juego.modificar(temp + 1, "Mario");
                puntos++;
                this.jLabel3.setText(puntos + "");
                this.crear_pane_principal(this.contador_filas, this.contador_columnas);
                SwingUtilities.updateComponentTreeUI(this);
            } else if (que_sigue(temp).equals("Hongo")) {
                Matriz_Tablero_Juego.modificar(temp, "vacio");
                Matriz_Tablero_Juego.modificar(temp + 1, "Mario");
                vidas++;
                this.jLabel5.setText(vidas + "");
                this.crear_pane_principal(this.contador_filas, this.contador_columnas);
                SwingUtilities.updateComponentTreeUI(this);
            } else if (que_sigue(temp).equals("Castillo")) {
                Matriz_Tablero_Juego.modificar(temp, "vacio");
                Matriz_Tablero_Juego.modificar(temp + 1, "Mario");
                JOptionPane.showMessageDialog(this, "Felicidades Ganaste");
                this.carga_objetos.setVisible(true);
                this.setVisible(false);
            }
        } else if (movimiento == 37) {
            if (que_anterior(temp).equals("vacio")) {
                Matriz_Tablero_Juego.modificar(temp, "vacio");
                Matriz_Tablero_Juego.modificar(temp - 1, "Mario");
                this.crear_pane_principal(this.contador_filas, this.contador_columnas);
                SwingUtilities.updateComponentTreeUI(this);
                
            } else if (que_anterior(temp).equals("Ficha")) {
                Matriz_Tablero_Juego.modificar(temp, "vacio");
                Matriz_Tablero_Juego.modificar(temp - 1, "Mario");
                puntos++;
                this.jLabel3.setText(puntos + "");
                this.crear_pane_principal(this.contador_filas, this.contador_columnas);
                SwingUtilities.updateComponentTreeUI(this);
                
            } else if (que_anterior(temp).equals("Hongo")) {
                Matriz_Tablero_Juego.modificar(temp, "vacio");
                Matriz_Tablero_Juego.modificar(temp - 1, "Mario");
                vidas++;
                this.jLabel5.setText(vidas + "");
                this.crear_pane_principal(this.contador_filas, this.contador_columnas);
                SwingUtilities.updateComponentTreeUI(this);
                
            } else if (que_anterior(temp).equals("Castillo")) {
                Matriz_Tablero_Juego.modificar(temp, "vacio");
                Matriz_Tablero_Juego.modificar(temp - 1, "Mario");
                JOptionPane.showMessageDialog(this, "Felicidades Ganaste");
                this.carga_objetos.setVisible(true);
                this.setVisible(false);
            }
        } else if (movimiento == 38) {
            if (que_arriba(temp).equals("vacio")) {
                Matriz_Tablero_Juego.modificar(temp, "vacio");
                Matriz_Tablero_Juego.modificar(temp - (contador_columnas * 2), "Mario");
                this.crear_pane_principal(this.contador_filas, this.contador_columnas);
                SwingUtilities.updateComponentTreeUI(this);

                temp = donde_esta_mario();
                Matriz_Tablero_Juego.modificar(temp, "vacio");
                Matriz_Tablero_Juego.modificar(temp + (contador_columnas * 2), "Mario");
                this.crear_pane_principal(this.contador_filas, this.contador_columnas);
                SwingUtilities.updateComponentTreeUI(this);

            } else if (que_arriba(temp).equals("Ficha")) {
                Matriz_Tablero_Juego.modificar(temp, "vacio");
                Matriz_Tablero_Juego.modificar(temp - (contador_columnas * 2), "Mario");
                puntos++;
                this.jLabel3.setText(puntos + "");
                this.crear_pane_principal(this.contador_filas, this.contador_columnas);
                SwingUtilities.updateComponentTreeUI(this);

                temp = donde_esta_mario();
                Matriz_Tablero_Juego.modificar(temp, "vacio");
                Matriz_Tablero_Juego.modificar(temp + (contador_columnas * 2), "Mario");
                this.crear_pane_principal(this.contador_filas, this.contador_columnas);
                SwingUtilities.updateComponentTreeUI(this);
                
            } else if (que_arriba(temp).equals("Hongo")) {
                Matriz_Tablero_Juego.modificar(temp, "vacio");
                Matriz_Tablero_Juego.modificar(temp - (contador_columnas * 2), "Mario");
                vidas++;
                this.jLabel5.setText(vidas + "");
                this.crear_pane_principal(this.contador_filas, this.contador_columnas);
                SwingUtilities.updateComponentTreeUI(this);

                temp = donde_esta_mario();
                Matriz_Tablero_Juego.modificar(temp, "vacio");
                Matriz_Tablero_Juego.modificar(temp + (contador_columnas * 2), "Mario");
                this.crear_pane_principal(this.contador_filas, this.contador_columnas);
                SwingUtilities.updateComponentTreeUI(this);
                
            } else if (que_arriba(temp).equals("Castillo")) {
                Matriz_Tablero_Juego.modificar(temp, "vacio");
                Matriz_Tablero_Juego.modificar(temp - (contador_columnas * 2), "Mario");
                JOptionPane.showMessageDialog(this, "Felicidades Ganaste");
                this.carga_objetos.setVisible(true);
                this.setVisible(false);
            }
        }
    }
}
