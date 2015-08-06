/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.no.pkg1;

import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Tony
 */
public class Graficar_Estructuras {

    Graphviz A = new Graphviz();

    public void Grificar_Lista_Doble() {

        Carga_Objetos CJ = new Carga_Objetos(null, null, 0);
        //Crear_Juego CJ = new Crear_Juego();
        Nodo_Lista actual1 = CJ.Lista_Objetos.primero;
        Nodo_Lista actual2 = CJ.Lista_Objetos.primero;
        Nodo_Lista actual3 = CJ.Lista_Objetos.primero;
        
        if(actual1 != null){
        File Arch = new File("Lista Objetos.txt");
        Arch.delete();
        try {
            A.Guardar_Codigo_GRafo(Arch, "digraph G{");
            while (actual1 != null) {
                A.Guardar_Codigo_GRafo(Arch, "\nNodo"
                        + actual1.ID
                        + " [shape=box, label = \""
                        + actual1.objeto + "\n"
                        + actual1.nombre + "\"];\n");
                actual1 = actual1.siguiente;
            }
            while (actual2.siguiente != null) {
                A.Guardar_Codigo_GRafo(Arch, "\nNodo"
                        + actual2.ID
                        + " -> Nodo"
                        + actual2.siguiente.ID + ";\nNodo"
                        + actual2.siguiente.ID 
                        + " -> Nodo"
                        + actual2.ID + ";\n");
                actual2 = actual2.siguiente;
            }
            A.Guardar_Codigo_GRafo(Arch, "\n{rank = same;");
            while (actual3 != null) {
                A.Guardar_Codigo_GRafo(Arch, " \"Nodo"
                        + actual3.ID
                        + "\";");
                actual3 = actual3.siguiente;
            }
            A.Guardar_Codigo_GRafo(Arch, "}\n}");
        } catch (IOException ex) {
        }
        A.Generar_Imagen_automata("C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe", "Lista Objetos.txt", "Lista Objetos.jpg");
        }else{
            JOptionPane.showMessageDialog(null, "\nNo existen elementos en la lista de objetos", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void Grificar_Matriz() {

        File Arch = new File("Matriz.txt");
        Arch.delete();
        try {
            A.Guardar_Codigo_GRafo(Arch, "digraph G{"
                    + "\nNodo0 [shape=box, label = \" Plantas \"];"
                    + "}");

        } catch (IOException ex) {
        }
        A.Generar_Imagen_automata("C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe", "Matriz.txt", "Matriz.jpg");
    }
}
