/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.no.pkg1;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author Tony
 */
public class Modificar_Eliminar extends javax.swing.JFrame {

    /**
     * Creates new form Modificar_Eliminar
     */
    int longitud = 0;
    String mario_estado;
    String castillo_estado;
    int ID;
    Carga_Objetos carga_objetos = new Carga_Objetos(mario_estado, castillo_estado, ID);
    Nodo_Lista temp = carga_objetos.Lista_Objetos.primero;
    Nodo_Lista temp1 = carga_objetos.Lista_Objetos.primero;
    Nodo_Lista temp2 = carga_objetos.Lista_Objetos.primero;
    String event = "";

    public Modificar_Eliminar(String evento, String mario_estado_local, String castillo_estado_local, int ID_local) {
        initComponents();
        this.event = evento;
        this.mario_estado = mario_estado_local;
        this.castillo_estado = castillo_estado_local;
        this.ID = ID_local;
        longitud = 0;
        int tamaño_fila;
        int tamaño_columna;
        Nodo_Lista temporal = carga_objetos.Lista_Objetos.primero;
        while (temporal != null) {
            temporal = temporal.siguiente;
            longitud++;
        }
        System.out.println("longitud de lista: " + longitud);
        int largo = 70 * longitud;
        int ancho = 200;
        this.Pane_objetos.removeAll();
        this.Pane_objetos.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        this.Pane_objetos.setPreferredSize(new Dimension(largo, ancho));

        int altura_pane_Matriz = ancho;//this.Pane_objetos.getSize().height;
        int ancho_pane_Matriz = largo;//this.Pane_objetos.getSize().width;

        int No_filas = 3;//Integer.parseInt(this.jTextField1.getText());
        int No_columnas = longitud;//Integer.parseInt(this.jTextField2.getText());

        if (longitud == 0) {
            tamaño_fila = 1 / 1;
            tamaño_columna = altura_pane_Matriz / No_filas;
        } else {
            tamaño_fila = ancho_pane_Matriz / No_columnas;
            tamaño_columna = altura_pane_Matriz / No_filas;
        }

        //GridLayout cuadricula = new GridLayout(No_columnas, No_filas, 0, 0);
        //cuadricula.setColumns(No_columnas);
        //cuadricula.setRows(No_filas);
        int contador_Lista = (No_filas * No_columnas);

        javax.swing.JLabel[] label = new javax.swing.JLabel[contador_Lista];
        javax.swing.JButton[] botones = new javax.swing.JButton[contador_Lista];

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
            Contador_celdas += No_columnas - 1;
            multiplicador_filas++;

            if (temp1 != null) {
                label[Contador_celdas] = new javax.swing.JLabel();
                label[Contador_celdas].setBounds((tamaño_fila * 0), (tamaño_columna * multiplicador_filas), tamaño_fila, tamaño_columna);
                label[Contador_celdas].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                label[Contador_celdas].setBorder(BorderFactory.createLineBorder(Color.BLUE));
                //ImageIcon img = new ImageIcon(cual_objeto(temp1.nombre));
                //Icon icono = new ImageIcon(img.getImage().getScaledInstance(140, 150, Image.SCALE_DEFAULT));
                label[Contador_celdas].removeAll();
                //label[Contador_celdas].setIcon(icono);
                label[Contador_celdas].repaint();
                //label[Contador_celdas].setIcon(icono);
                label[Contador_celdas].setText("" + temp1.nombre);

                this.Pane_objetos.add(label[Contador_celdas], null);

                int columna_temp = 1;
                temp1 = temp1.siguiente;

                for (columnas = Contador_celdas + 1; columnas < Contador_celdas + No_columnas; columnas++) {
                    if (temp1 != null) {
                        label[columnas] = new javax.swing.JLabel();
                        label[columnas].setBounds(tamaño_fila * columna_temp, (tamaño_columna * multiplicador_filas), tamaño_fila, tamaño_columna);
                        label[columnas].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        label[columnas].setBorder(BorderFactory.createLineBorder(Color.BLUE));
                        //ImageIcon img1 = new ImageIcon(cual_objeto(temp1.nombre));
                        //Icon icono1 = new ImageIcon(img1.getImage().getScaledInstance(140, 150, Image.SCALE_DEFAULT));
                        label[columnas].removeAll();
                        //label[columnas].setIcon(icono1);
                        label[columnas].repaint();
                        //label[columnas].setIcon(icono1);
                        label[columnas].setText("" + temp1.nombre);

                        this.Pane_objetos.add(label[columnas], null);

                        columna_temp++;
                        temp1 = temp1.siguiente;
                    }
                }
            }
            Contador_celdas += No_columnas - 1;
            multiplicador_filas++;

            if (temp2 != null) {
                Contador_celdas = 0;
                botones[Contador_celdas] = new javax.swing.JButton();
                botones[Contador_celdas].setBounds((tamaño_fila * 0), (tamaño_columna * multiplicador_filas), tamaño_fila, tamaño_columna);
                botones[Contador_celdas].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                botones[Contador_celdas].setBorder(BorderFactory.createLineBorder(Color.BLUE));
                ImageIcon img = new ImageIcon(obtener_icono());
                Icon icono = new ImageIcon(img.getImage().getScaledInstance(10, 10, Image.SCALE_DEFAULT));
                botones[Contador_celdas].removeAll();
                botones[Contador_celdas].setIcon(icono);
                botones[Contador_celdas].repaint();
                botones[Contador_celdas].setIcon(icono);
                botones[Contador_celdas].setText("" + evento);
                botones[Contador_celdas].addMouseListener(new MouseListener() {

                    @Override
                    public void mouseClicked(MouseEvent me) {
                        int conta = 0;
                        for (int i = 0; i < longitud; i++) {
                            if (me.getSource().equals(botones[i])) {
                                //JOptionPane.showMessageDialog(null, "" + i);
                                conta = i;
                                //JOptionPane.showMessageDialog(null, evento + "\nClic en " + conta);
                                if (evento.equals("Eliminar")) {
                                    JOptionPane.showMessageDialog(null, "\nEliminado el objeto: " + carga_objetos.Lista_Objetos.busqueda(carga_objetos.Lista_Objetos, conta), evento, JOptionPane.INFORMATION_MESSAGE);
                                    if (carga_objetos.Lista_Objetos.busqueda(carga_objetos.Lista_Objetos, conta).equals("Mario")) {
                                        mario_estado = "";
                                    }
                                    if (carga_objetos.Lista_Objetos.busqueda(carga_objetos.Lista_Objetos, conta).equals("Castillo")) {
                                        castillo_estado = "";
                                    }
                                    carga_objetos.Lista_Objetos.eliminar_lista(carga_objetos.Lista_Objetos, conta);
                                    carga_objetos.Lista_Objetos.imprimir();
                                    if (carga_objetos.Lista_Objetos.primero == null) {
                                        Modificar_Eliminar MD = new Modificar_Eliminar(event, "", "", 0);
                                        cerrar();
                                        MD.setVisible(true);
                                    } else {
                                        Modificar_Eliminar MD = new Modificar_Eliminar(event, mario_estado, castillo_estado, (ID - 1));
                                        cerrar();
                                        MD.setVisible(true);
                                    }
                                } else if (evento.equals("Modificar")) {
                                    String nuevo_nombre = JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre al objeto", "Nuevo nombre", JOptionPane.QUESTION_MESSAGE);
                                    carga_objetos.Lista_Objetos.modificar(carga_objetos.Lista_Objetos, conta, nuevo_nombre);
                                    Modificar_Eliminar MD = new Modificar_Eliminar(event, mario_estado, castillo_estado, ID);
                                    cerrar();
                                    MD.setVisible(true);
                                }
                                //Lista_Doble LD = new Lista_Doble();
                                //LD.eliminar_lista(conta);

                                break;
                            }
                        }//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

                this.Pane_objetos.add(botones[Contador_celdas], null);

                int columna_temp = 1;
                temp2 = temp2.siguiente;

                for (columnas = Contador_celdas + 1; columnas < Contador_celdas + No_columnas; columnas++) {
                    if (temp2 != null) {
                        botones[columnas] = new javax.swing.JButton();
                        botones[columnas].setBounds(tamaño_fila * columna_temp, (tamaño_columna * multiplicador_filas), tamaño_fila, tamaño_columna);
                        botones[columnas].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        botones[columnas].setBorder(BorderFactory.createLineBorder(Color.BLUE));
                        ImageIcon img1 = new ImageIcon(obtener_icono());
                        Icon icono1 = new ImageIcon(img1.getImage().getScaledInstance(10, 10, Image.SCALE_DEFAULT));
                        botones[columnas].removeAll();
                        botones[columnas].setIcon(icono1);
                        botones[columnas].repaint();
                        botones[columnas].setIcon(icono1);
                        botones[columnas].setText("" + evento);

                        botones[columnas].addMouseListener(new MouseListener() {

                            @Override
                            public void mouseClicked(MouseEvent me) {
                                int conta = 0;
                                for (int i = 0; i < longitud; i++) {
                                    if (me.getSource().equals(botones[i])) {
                                        //JOptionPane.showMessageDialog(null, "" + i);
                                        conta = i;
                                        //JOptionPane.showMessageDialog(null, evento + "\nClic en " + conta);
                                        if (evento.equals("Eliminar")) {
                                            JOptionPane.showMessageDialog(null, "\nEliminado el objeto: " + carga_objetos.Lista_Objetos.busqueda(carga_objetos.Lista_Objetos, conta), evento, JOptionPane.INFORMATION_MESSAGE);
                                            if (carga_objetos.Lista_Objetos.busqueda(carga_objetos.Lista_Objetos, conta).equals("Mario")) {
                                                mario_estado = "";
                                            }
                                            if (carga_objetos.Lista_Objetos.busqueda(carga_objetos.Lista_Objetos, conta).equals("Castillo")) {
                                                castillo_estado = "";
                                            }
                                            carga_objetos.Lista_Objetos.eliminar_lista(carga_objetos.Lista_Objetos, conta);
                                            carga_objetos.Lista_Objetos.imprimir();
                                            if (carga_objetos.Lista_Objetos.primero == null) {
                                                Modificar_Eliminar MD = new Modificar_Eliminar(event, "", "", 0);
                                                cerrar();
                                                MD.setVisible(true);
                                            } else {
                                                Modificar_Eliminar MD = new Modificar_Eliminar(event, mario_estado, castillo_estado, (ID - 1));
                                                cerrar();
                                                MD.setVisible(true);
                                            }
                                        } else if (evento.equals("Modificar")) {
                                            String nuevo_nombre = JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre al objeto", "Nuevo nombre", JOptionPane.QUESTION_MESSAGE);
                                            carga_objetos.Lista_Objetos.modificar(carga_objetos.Lista_Objetos, conta, nuevo_nombre);
                                            Modificar_Eliminar MD = new Modificar_Eliminar(event, mario_estado, castillo_estado, ID);
                                            cerrar();
                                            MD.setVisible(true);
                                        }
                                        break;
                                    }
                                }                                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                        this.Pane_objetos.add(botones[columnas], null);

                        columna_temp++;
                        temp2 = temp2.siguiente;
                    }
                }
            }
        }
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
        Pane_objetos = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N

        Pane_objetos.setPreferredSize(new java.awt.Dimension(100, 81));

        javax.swing.GroupLayout Pane_objetosLayout = new javax.swing.GroupLayout(Pane_objetos);
        Pane_objetos.setLayout(Pane_objetosLayout);
        Pane_objetosLayout.setHorizontalGroup(
            Pane_objetosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 712, Short.MAX_VALUE)
        );
        Pane_objetosLayout.setVerticalGroup(
            Pane_objetosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 202, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(Pane_objetos);

        jButton1.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica/no/pkg1/Imagenes/agregar.png"))); // NOI18N
        jButton1.setText("Agregar mas Objetos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica/no/pkg1/Imagenes/mostrar.png"))); // NOI18N
        jButton2.setText("Graficar Lista");
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jButton1)
                .addGap(80, 80, 80)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Regresar
        Carga_Objetos CO = new Carga_Objetos(this.mario_estado, this.castillo_estado, this.ID);
        CO.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Graficar Lista
        Graficar_Estructuras GE = new Graficar_Estructuras();
        GE.Grificar_Lista_Doble();
        try {
            File objetofile = new File("Lista Objetos.jpg");
            Desktop.getDesktop().open(objetofile);
        } catch (IOException ex) {
            System.out.println(ex);
        }
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
            java.util.logging.Logger.getLogger(Modificar_Eliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modificar_Eliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modificar_Eliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modificar_Eliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Modificar_Eliminar(null, null, null, 0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pane_objetos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public String obtener_icono() {
        if (this.event.equals("Modificar")) {
            return "src\\practica\\no\\pkg1\\Imagenes\\modificar.png";
        } else if (this.event.equals("Eliminar")) {
            return "src\\practica\\no\\pkg1\\Imagenes\\Eliminar.gif";
        }
        return null;
    }

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

    public void cerrar() {
        this.setVisible(false);
    }
}
