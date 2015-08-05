/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.no.pkg1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Tony
 */
public class Crear_Juego extends javax.swing.JFrame {

    /**
     * Creates new form Crear_Juego
     */
    int longitud = 0;
    int longitud1 = 0;
    int contador_filas = 2;
    int contador_columnas = 4;
    int donde = 0;
    int conta_celdas;
    int conta_columnas;
    String objeto_seleccionado = "";
    //Carga_Objetos carga_objetos = new Carga_Objetos(null, null, 0);
    //Nodo_Lista temp = /*carga_objetos.*/Lista_Objetos.primero;
    Lista_Doble Lista_Objetos = new Lista_Doble();
    Matriz Matriz_Tablero = new Matriz();

    public Crear_Juego() {
        initComponents();

        Lista_Objetos.sampar_lista("Mario1", "Suelo", 0);
        Lista_Objetos.sampar_lista("Mario2", "Pared", 2);
        Lista_Objetos.sampar_lista("Mario3", "Castillo", 3);
        Lista_Objetos.sampar_lista("Mario4", "Mario", 4);
        Lista_Objetos.sampar_lista("Mario5", "Mario", 5);
        Lista_Objetos.sampar_lista("Mario6", "Mario", 6);
        Lista_Objetos.sampar_lista("Mario7", "Mario", 7);
        Lista_Objetos.sampar_lista("Mario8", "Mario", 8);
        Lista_Objetos.sampar_lista("Mario9", "Mario", 9);
        Lista_Objetos.sampar_lista("Mario10", "Mario", 10);
        Lista_Objetos.sampar_lista("Mario11", "Mario", 11);
        Lista_Objetos.sampar_lista("Mario12", "Mario", 12);
        Lista_Objetos.sampar_lista("Mario13", "Mario", 13);
        Lista_Objetos.sampar_lista("Mario14", "Mario", 14);
        Lista_Objetos.sampar_lista("Mario15", "Mario", 15);
        Lista_Objetos.sampar_lista("Mario1", "Mario", 16);
        Lista_Objetos.sampar_lista("Mario2", "Mario", 17);
        Lista_Objetos.sampar_lista("Mario3", "Mario", 18);
        Lista_Objetos.sampar_lista("Mario4", "Mario", 19);
        Lista_Objetos.sampar_lista("Mario5", "Mario", 20);
        Lista_Objetos.sampar_lista("Mario6", "Mario", 21);
        Lista_Objetos.sampar_lista("Mario7", "Mario", 22);
        Lista_Objetos.sampar_lista("Mario8", "Mario", 23);
        Lista_Objetos.sampar_lista("Mario9", "Mario", 24);
        Lista_Objetos.sampar_lista("Mario10", "Mario", 25);
        Lista_Objetos.sampar_lista("Mario11", "Mario", 26);
        Lista_Objetos.sampar_lista("Mario12", "Mario", 27);
        Lista_Objetos.sampar_lista("Mario13", "Mario", 28);
        Lista_Objetos.sampar_lista("Mario14", "Mario", 29);
        Lista_Objetos.sampar_lista("Mario15", "Pared", 30);
        Lista_Objetos.sampar_lista("Mario1", "Mario", 1);
        Lista_Objetos.sampar_lista("Mario2", "Mario", 2);
        Lista_Objetos.sampar_lista("Mario3", "Mario", 3);
        Lista_Objetos.sampar_lista("Mario4", "Mario", 4);
        Lista_Objetos.sampar_lista("Mario5", "Mario", 5);
        Lista_Objetos.sampar_lista("Mario6", "Mario", 6);
        Lista_Objetos.sampar_lista("Mario7", "Mario", 7);
        Lista_Objetos.sampar_lista("Mario8", "Mario", 8);
        Lista_Objetos.sampar_lista("Mario9", "Mario", 9);
        Lista_Objetos.sampar_lista("Mario10", "Mario", 10);
        Lista_Objetos.sampar_lista("Mario11", "Mario", 11);
        Lista_Objetos.sampar_lista("Mario12", "Mario", 12);
        Lista_Objetos.sampar_lista("Mario13", "Mario", 13);
        Lista_Objetos.sampar_lista("Mario14", "Mario", 14);
        Lista_Objetos.sampar_lista("Mario15", "Mario", 15);
        Lista_Objetos.sampar_lista("Mario1", "Mario", 16);
        Lista_Objetos.sampar_lista("Mario2", "Mario", 17);
        Lista_Objetos.sampar_lista("Mario3", "Mario", 18);
        Lista_Objetos.sampar_lista("Mario4", "Mario", 19);
        Lista_Objetos.sampar_lista("Mario5", "Mario", 20);
        Lista_Objetos.sampar_lista("Mario6", "Mario", 21);
        Lista_Objetos.sampar_lista("Mario7", "Mario", 22);
        Lista_Objetos.sampar_lista("Mario8", "Mario", 23);
        Lista_Objetos.sampar_lista("Mario9", "Mario", 24);
        Lista_Objetos.sampar_lista("Mario10", "Mario", 25);
        Lista_Objetos.sampar_lista("Mario11", "Mario", 26);
        Lista_Objetos.sampar_lista("Mario12", "Mario", 27);
        Lista_Objetos.sampar_lista("Mario13", "Mario", 28);
        Lista_Objetos.sampar_lista("Mario14", "Mario", 29);
        Lista_Objetos.sampar_lista("Mario15", "Pared", 30);

        //Lista_Objetos.imprimir();
        
        this.llenar_matriz(contador_columnas, contador_filas, "vacio");

        this.crear_pane_objetos();
        this.crear_pane_principal(contador_filas, contador_columnas);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pane_objetos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Pane_principal = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout Pane_objetosLayout = new javax.swing.GroupLayout(Pane_objetos);
        Pane_objetos.setLayout(Pane_objetosLayout);
        Pane_objetosLayout.setHorizontalGroup(
            Pane_objetosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        Pane_objetosLayout.setVerticalGroup(
            Pane_objetosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        javax.swing.GroupLayout Pane_principalLayout = new javax.swing.GroupLayout(Pane_principal);
        Pane_principal.setLayout(Pane_principalLayout);
        Pane_principalLayout.setHorizontalGroup(
            Pane_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 881, Short.MAX_VALUE)
        );
        Pane_principalLayout.setVerticalGroup(
            Pane_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(Pane_principal);

        jButton1.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica/no/pkg1/Imagenes/agregar.png"))); // NOI18N
        jButton1.setText("Agregar Fila");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica/no/pkg1/Imagenes/agregar.png"))); // NOI18N
        jButton2.setText("Agregar Columna");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Pane_objetos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pane_objetos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Agregar fila
        contador_filas++;
        this.crear_pane_principal(contador_filas, contador_columnas);
        this.Matriz_Tablero.eliminar_matriz();
        System.out.print("\n \n\n agregando fila\n");
        this.llenar_matriz(contador_columnas, contador_filas, "vacio");
        SwingUtilities.updateComponentTreeUI(this);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Agregar Columna
        contador_columnas++;
        this.crear_pane_principal(contador_filas, contador_columnas);
        this.Matriz_Tablero.eliminar_matriz();
        System.out.print("\n \n\n agregando columna\n");
        this.llenar_matriz(contador_columnas, contador_filas, "vacio");
        SwingUtilities.updateComponentTreeUI(this);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Crear_Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Crear_Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Crear_Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Crear_Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Crear_Juego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pane_objetos;
    private javax.swing.JPanel Pane_principal;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
        }
        return null;
    }

    public void crear_pane_principal(int fila, int columna) {

        int tamaño_fila;
        int tamaño_columna;

        //Nodo_Lista temporal = /*carga_objetos.*/Lista_Objetos.primero;
        //Nodo_Lista temp1 = /*carga_objetos.*/Lista_Objetos.primero;
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

        int contador_Lista = (No_filas * No_columnas);
        javax.swing.JLabel[] label = new javax.swing.JLabel[contador_Lista];

        int columnas;
        int multiplicador_filas = 0;

        for (int Contador_celdas = 0; Contador_celdas < contador_Lista; Contador_celdas++) {
            //if (temp1 != null) {
            label[Contador_celdas] = new javax.swing.JLabel();
            label[Contador_celdas].setBounds((tamaño_fila * 0), (tamaño_columna * multiplicador_filas), tamaño_fila, tamaño_columna);
            label[Contador_celdas].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            label[Contador_celdas].setBorder(BorderFactory.createLineBorder(Color.BLUE));
            //ImageIcon img = new ImageIcon(cual_objeto(temp1.objeto));
            //Icon icono = new ImageIcon(img.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
            label[Contador_celdas].removeAll();
            //label[Contador_celdas].setIcon(icono);
            label[Contador_celdas].repaint();
            //label[Contador_celdas].setIcon(icono);
            label[Contador_celdas].setText("" + (Contador_celdas + 1));
            label[Contador_celdas].addMouseListener(new MouseListener() {

                @Override
                public void mouseClicked(MouseEvent me) {
                    for (int i = 0; i < contador_Lista; i++) {
                        if (me.getSource().equals(label[i])) {
                            JOptionPane.showMessageDialog(null, "DONDE: " + i);
                            if (objeto_seleccionado.equals("")) {
                                JOptionPane.showMessageDialog(null, "\nNo ha seleccionado un objeto\nSeleccione uno porfavor", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                donde = i;
                                conta_celdas = i;
                                JOptionPane.showMessageDialog(null, "Contador celdas: " + (conta_celdas + 1));
                                ImageIcon img = new ImageIcon(cual_objeto(objeto_seleccionado));
                                Icon icono = new ImageIcon(img.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
                                label[donde].removeAll();
                                label[donde].setIcon(icono);
                                label[donde].repaint();
                                label[donde].setIcon(icono);
                                //Matriz_Tablero.modificar(conta_celdas, conta_celdas, objeto_seleccionado);
                                //Matriz_Tablero.imprimir_matriz();
                            }
                        }
                    }
                    //actualizar();
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void mousePressed(MouseEvent me
                ) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void mouseReleased(MouseEvent me
                ) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void mouseEntered(MouseEvent me
                ) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void mouseExited(MouseEvent me
                ) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });

            this.Pane_principal.add(label[Contador_celdas], null);

            int columna_temp = 1;
            //temp1 = temp1.siguiente;

            for (columnas = Contador_celdas + 1;
                    columnas < Contador_celdas + No_columnas;
                    columnas++) {
                //if (temp1 != null) {
                label[columnas] = new javax.swing.JLabel();
                label[columnas].setBounds(tamaño_fila * columna_temp, (tamaño_columna * multiplicador_filas), tamaño_fila, tamaño_columna);
                label[columnas].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                label[columnas].setBorder(BorderFactory.createLineBorder(Color.BLUE));
                //ImageIcon img1 = new ImageIcon(cual_objeto(temp1.objeto));
                //Icon icono1 = new ImageIcon(img1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
                label[columnas].removeAll();
                //label[columnas].setIcon(icono1);
                label[columnas].repaint();
                //label[columnas].setIcon(icono1);
                label[columnas].setText("" + (columnas + 1));
                this.conta_columnas = columnas;
                label[columnas].addMouseListener(new MouseListener() {

                    @Override
                    public void mouseClicked(MouseEvent me) {
                        for (int i = 0; i < contador_Lista; i++) {
                            if (me.getSource().equals(label[i])) {
                                //JOptionPane.showMessageDialog(null, "DONDE: " + i);
                                if (objeto_seleccionado.equals("")) {
                                    JOptionPane.showMessageDialog(null, "\nNo ha seleccionado un objeto\nSeleccione uno porfavor", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    donde = i;
                                    conta_columnas = i;
                                    JOptionPane.showMessageDialog(null, "Contador celdas: " + (conta_celdas + 1) + " Contador columnas: " + (conta_columnas + 1));
                                    ImageIcon img = new ImageIcon(cual_objeto(objeto_seleccionado));
                                    Icon icono = new ImageIcon(img.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
                                    label[donde].removeAll();
                                    label[donde].setIcon(icono);
                                    label[donde].repaint();
                                    label[donde].setIcon(icono);
                                    objeto_seleccionado = "";
                                    //Matriz_Tablero.modificar(conta_celdas, conta_columnas, objeto_seleccionado);
                                    //Matriz_Tablero.imprimir_matriz();
                                }
                            }
                        }
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void mousePressed(MouseEvent me) {
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void mouseReleased(MouseEvent me) {
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void mouseEntered(MouseEvent me) {
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void mouseExited(MouseEvent me) {
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                });
                this.Pane_principal.add(label[columnas], null);

                columna_temp++;
                //temp1 = temp1.siguiente;
                //}
            }
            //}
            multiplicador_filas++;
            Contador_celdas = Contador_celdas + No_columnas - 1;
        }
    }

    public void crear_pane_objetos() {
        Nodo_Lista temp = /*carga_objetos.*/ Lista_Objetos.primero;
        int tamaño_fila;
        int tamaño_columna;

        Nodo_Lista temporal = /*carga_objetos.*/ Lista_Objetos.primero;
        while (temporal != null) {
            temporal = temporal.siguiente;
            longitud1++;
        }

        int largo = 70 * longitud1;
        int ancho = 200;

        int No_filas = 3;//Integer.parseInt(this.jTextField1.getText());
        int No_columnas = longitud1;//Integer.parseInt(this.jTextField2.getText());

        int altura_pane_Matriz = ancho;//this.Pane_objetos.getSize().height;
        int ancho_pane_Matriz = largo;//this.Pane_objetos.getSize().width;

        if (longitud1 == 0) {
            tamaño_fila = 1 / 1;
            tamaño_columna = altura_pane_Matriz / No_filas;
        } else {
            tamaño_fila = ancho_pane_Matriz / No_columnas;
            tamaño_columna = altura_pane_Matriz / No_filas;
        }
        int contador_Lista = (No_filas * No_columnas);
        javax.swing.JLabel[] label = new javax.swing.JLabel[contador_Lista];

        int columnas;
        int multiplicador_filas = 0;

        for (int Contador_celdas = 0; Contador_celdas < contador_Lista; Contador_celdas++) {
            if (temp != null) {
                label[Contador_celdas] = new javax.swing.JLabel();
                label[Contador_celdas].setBounds((tamaño_fila * 0), (tamaño_columna * multiplicador_filas), tamaño_fila, tamaño_columna);
                label[Contador_celdas].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                label[Contador_celdas].setBorder(BorderFactory.createLineBorder(Color.BLUE));
                ImageIcon img = new ImageIcon(cual_objeto(temp.objeto));
                Icon icono = new ImageIcon(img.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
                label[Contador_celdas].removeAll();
                label[Contador_celdas].setIcon(icono);
                label[Contador_celdas].repaint();
                label[Contador_celdas].setIcon(icono);
                label[Contador_celdas].setText("" + (Contador_celdas + 1));
                label[Contador_celdas].addMouseMotionListener(new MouseMotionListener() {

                    @Override
                    public void mouseDragged(MouseEvent me) {
                    }

                    @Override
                    public void mouseMoved(MouseEvent me) {
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                });

                label[Contador_celdas].addMouseListener(new MouseListener() {

                    @Override
                    public void mouseClicked(MouseEvent me) {
                        objeto_seleccionado = Lista_Objetos.primero.objeto;
                        Lista_Objetos.eliminar_lista(Lista_Objetos, 0);
                        //Crear_Juego CJ = new Crear_Juego();
                        //cerrar();
                        //CJ.setVisible(true);
                        //actualizar();
                        //JOptionPane.showMessageDialog(null, objeto_seleccionado);
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void mousePressed(MouseEvent me) {
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void mouseReleased(MouseEvent me) {
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void mouseEntered(MouseEvent me) {
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void mouseExited(MouseEvent me) {
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                });

                this.Pane_objetos.add(label[Contador_celdas], null);

                int columna_temp = 1;
                temp = temp.siguiente;

                for (columnas = Contador_celdas + 1; columnas < Contador_celdas + No_columnas; columnas++) {
                    if (temp != null) {
                        label[columnas] = new javax.swing.JLabel();
                        label[columnas].setBounds(tamaño_fila * columna_temp, (tamaño_columna * multiplicador_filas), tamaño_fila, tamaño_columna);
                        label[columnas].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        label[columnas].setBorder(BorderFactory.createLineBorder(Color.BLUE));
                        ImageIcon img1 = new ImageIcon(cual_objeto(temp.objeto));
                        Icon icono1 = new ImageIcon(img1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
                        label[columnas].removeAll();
                        label[columnas].setIcon(icono1);
                        label[columnas].repaint();
                        label[columnas].setIcon(icono1);
                        label[columnas].setText("" + (columnas + 1));

                        this.Pane_objetos.add(label[columnas], null);

                        columna_temp++;
                        temp = temp.siguiente;
                    }
                }
            }
        }
    }

    public void actualizar() {
        SwingUtilities.updateComponentTreeUI(this);
    }

    public void cerrar() {
        this.setVisible(false);
    }

    public void llenar_matriz(int largo, int ancho, String contenido) {
        Matriz_Tablero.sampar_matriz(contenido, 0);
        for (int i = 0; i < largo - 1; i++) {
            Matriz_Tablero.sampar_matriz(contenido, 1);
        }
        for (int i = 0; i < ancho - 1; i++) {
            Matriz_Tablero.sampar_matriz(contenido, 2);
            for (int j = 0; j < largo - 1; j++) {
                Matriz_Tablero.sampar_matriz(contenido, 3);
            }
        }
        Matriz_Tablero.imprimir_matriz();
    }
    
    public void agregar_fila(){
        
    }
}
