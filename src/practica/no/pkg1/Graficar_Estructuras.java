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

        if (actual1 != null) {
            File Arch = new File("Lista Objetos.txt");
            Arch.delete();
            try {
                A.Guardar_Codigo_GRafo(Arch, "digraph G{ \nlabel = \"Lista de Objetos\";\n");
                while (actual1 != null) {
                    A.Guardar_Codigo_GRafo(Arch, "\nNodo"
                            + actual1.ID
                            + " [shape=box,color=\"blue\", label = \"Objeto: "
                            + actual1.objeto + "\nNombre: "
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
        } else {
            JOptionPane.showMessageDialog(null, "\nNo existen elementos en la lista de objetos", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void prueba() {
        File Arch = new File("Prueba.txt");
        Arch.delete();
        try {
            A.Guardar_Codigo_GRafo(Arch, "digraph G{ \n"
                    + "label = \"Matriz de Juego\";\n"
                    + "1[shape=box,color=\"white\", label = \"\"];\n"
                    + "2[shape=box,color=\"white\", label = \"\"];\n"
                    + "3[shape=box,color=\"white\", label = \"\"];\n"
                    + "4[shape=box,color=\"white\", label = \"\"];\n"
                    + "5[shape=box,color=\"white\", label = \"\"];\n"
                    + "6[shape=box,color=\"white\", label = \"\"];\n"
                    + "7[shape=box,color=\"white\", label = \"\"];\n"
                    + "8[shape=box,color=\"white\", label = \"\"];\n"
                    + "9[shape=box,color=\"white\", label = \"\"];\n"
                    + "10[shape=box,color=\"white\", label = \"\"];\n"
                    + "11[shape=box,color=\"white\", label = \"\"];\n"
                    + "12[shape=box,color=\"white\", label = \"\"];\n"
                    + "Nodo0 [shape=box,color=\"blue\", label = \"vacio 0\"];\n"
                    + "Nodo1 [shape=box,color=\"blue\", label = \"vacio 1\"];\n"
                    + "Nodo2 [shape=box,color=\"blue\", label = \"vacio 2\"];\n"
                    + "Nodo3 [shape=box,color=\"blue\", label = \"vacio 3\"];\n"
                    + "Nodo4 [shape=box,color=\"blue\", label = \"vacio 4\"];\n"
                    + "Nodo5 [shape=box,color=\"blue\", label = \"vacio 5\"];\n"
                    + "Nodo6 [shape=box,color=\"blue\", label = \"vacio 6\"];\n"
                    + "Nodo7 [shape=box,color=\"blue\", label = \"vacio 7\"];\n"
                    + "{rank = same;\"1\";\"2\";\"3\";\"4\";}\n"
                    + "{rank = same;\"5\";\"Nodo0\";\"Nodo1\";\"Nodo2\";\"Nodo3\";\"6\";}\n"
                    + "{rank = same;\"7\";\"Nodo4\";\"Nodo5\"; \"Nodo6\"; \"Nodo7\";\"8\";}\n"
                    + "{rank = same;\"9\";\"10\";\"11\";\"12\";}\n"
                    + "Nodo0->Nodo4; \n"
                    + "Nodo0->Nodo1;\n"
                    + "Nodo4->Nodo0;\n"
                    + "Nodo1->Nodo0;\n"
                    + "Nodo1->Nodo2;\n"
                    + "Nodo2->Nodo1;\n"
                    + "Nodo2->Nodo3;\n"
                    + "Nodo3->Nodo2;\n"
                    + "Nodo4->Nodo5;\n"
                    + "Nodo5->Nodo4;\n"
                    + "Nodo5->Nodo1;\n"
                    + "Nodo1->Nodo5;\n"
                    + "Nodo5->Nodo6;\n"
                    + "Nodo6->Nodo5;\n"
                    + "Nodo6->Nodo7;\n"
                    + "Nodo7->Nodo6;\n"
                    + "Nodo6->Nodo2;\n"
                    + "Nodo2->Nodo6;\n"
                    + "Nodo7->Nodo3;\n"
                    + "Nodo3->Nodo7;\n"
                    + "1->Nodo0[color = red];\n"
                    + "Nodo0->1;\n"
                    + "2->Nodo1[color = white];\n"
                    + "Nodo1->2;\n"
                    + "3->Nodo2[color = white];\n"
                    + "Nodo2->3;\n"
                    + "4->Nodo3[color = white];\n"
                    + "Nodo3->4;\n"
                    + "5->Nodo0[color = white];\n"
                    + "Nodo0->5;\n"
                    + "6->Nodo3[color = white];\n"
                    + "Nodo3->6;\n"
                    + "7->Nodo4[color = white];\n"
                    + "Nodo4->7;\n"
                    + "8->Nodo7[color = white];\n"
                    + "Nodo7->8;\n"
                    + "9->Nodo4[color = white];\n"
                    + "Nodo4->9;\n"
                    + "10->Nodo5[color = white];\n"
                    + "Nodo5->10;\n"
                    + "11->Nodo6[color = white];\n"
                    + "Nodo6->11;\n"
                    + "12->Nodo7[color = white];\n"
                    + "Nodo7->12;\n"
                    + "1->5[color = red];\n"
                    + "5->7[color = white];\n"
                    + "}");
        } catch (IOException ex) {
        }
        A.Generar_Imagen_automata("C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe", "Prueba.txt", "Prueba.jpg");
    }

    public void Grificar_Matriz(Matriz tablero) {

        Nodo_Matriz actual_fila = tablero.raiz;
        Nodo_Matriz actual_columna;

        int contador1 = 1;

        File Arch = new File("Matriz.txt");
        Arch.delete();
        try {
            A.Guardar_Codigo_GRafo(Arch, "digraph G{ \nlabel = \"Matriz de Juego\";\n");
            int contador = 1;
            while (actual_fila != null) {
                A.Guardar_Codigo_GRafo(Arch, contador + " [shape=box,color=\"white\", label = \"\"];\n");
                contador++;
                A.Guardar_Codigo_GRafo(Arch, contador + " [shape=box,color=\"white\", label = \"\"];\n");
                contador++;
                actual_fila = actual_fila.izquierda;
            }
            actual_fila = tablero.raiz;
            while (actual_fila != null) {
                A.Guardar_Codigo_GRafo(Arch, contador + " [shape=box,color=\"white\", label = \"\"];\n");
                contador++;
                A.Guardar_Codigo_GRafo(Arch, contador + " [shape=box,color=\"white\", label = \"\"];\n");
                contador++;
                actual_fila = actual_fila.abajo;
            }

            actual_fila = tablero.raiz;
            actual_columna = null;

            while (actual_fila != null) {
                A.Guardar_Codigo_GRafo(Arch, "\nNodo"
                        + actual_fila.ID
                        + " [shape=box,color=\"blue\", label = \""
                        + actual_fila.objeto + "\n"
                        + actual_fila.ID + "\"];");
                actual_columna = actual_fila.izquierda;
                while (actual_columna != null) {
                    A.Guardar_Codigo_GRafo(Arch, "\nNodo"
                            + actual_columna.ID
                            + " [shape=box,color=\"blue\", label = \""
                            + actual_columna.objeto + "\n"
                            + actual_columna.ID + "\"];");

                    actual_columna = actual_columna.izquierda;
                }
                actual_fila = actual_fila.abajo;
            }

            A.Guardar_Codigo_GRafo(Arch, "\n\n{rank = same;");
            actual_fila = tablero.raiz;

            while (actual_fila != null) {
                A.Guardar_Codigo_GRafo(Arch, "\"" + contador1 + "\";");
                contador1++;
                actual_fila = actual_fila.izquierda;
            }
            A.Guardar_Codigo_GRafo(Arch, "}");

            actual_fila = tablero.raiz;
            while (actual_fila != null) {
                A.Guardar_Codigo_GRafo(Arch, "\n{rank = same;\"" + contador1 + "\";");
                contador1++;
                A.Guardar_Codigo_GRafo(Arch, "\"Nodo" + actual_fila.ID + "\";");
                actual_columna = actual_fila.izquierda;
                while (actual_columna != null) {
                    A.Guardar_Codigo_GRafo(Arch, "\"Nodo" + actual_columna.ID + "\";");
                    actual_columna = actual_columna.izquierda;
                }
                A.Guardar_Codigo_GRafo(Arch, "\"" + contador1 + "\";}");
                contador1++;
                actual_fila = actual_fila.abajo;
            }

            A.Guardar_Codigo_GRafo(Arch, "\n{rank = same;");
            actual_fila = tablero.raiz;

            while (actual_fila != null) {
                A.Guardar_Codigo_GRafo(Arch, "\"" + contador1 + "\";");
                contador1++;
                actual_fila = actual_fila.izquierda;
            }
            A.Guardar_Codigo_GRafo(Arch, "}\n\n");

            actual_fila = tablero.raiz;
            actual_columna = null;
            while (actual_fila != null) {
                if (actual_fila.abajo != null) {
                    A.Guardar_Codigo_GRafo(Arch, "Nodo" + actual_fila.ID + "-> Nodo" + actual_fila.izquierda.ID + ";\n");
                    A.Guardar_Codigo_GRafo(Arch, "Nodo" + actual_fila.izquierda.ID + "-> Nodo" + actual_fila.ID + ";\n");
                    A.Guardar_Codigo_GRafo(Arch, "Nodo" + actual_fila.ID + "-> Nodo" + actual_fila.abajo.ID + ";\n");
                    A.Guardar_Codigo_GRafo(Arch, "Nodo" + actual_fila.abajo.ID + "-> Nodo" + actual_fila.ID + ";\n\n");
                } else {
                    A.Guardar_Codigo_GRafo(Arch, "Nodo" + actual_fila.ID + "-> Nodo" + actual_fila.izquierda.ID + ";\n");
                    A.Guardar_Codigo_GRafo(Arch, "Nodo" + actual_fila.izquierda.ID + "-> Nodo" + actual_fila.ID + ";\n\n");
                }
                actual_columna = actual_fila.izquierda;
                while (actual_columna != null) {
                    if (actual_columna.izquierda != null && actual_columna.abajo != null) {
                        A.Guardar_Codigo_GRafo(Arch, "Nodo" + actual_columna.ID + "-> Nodo" + actual_columna.izquierda.ID + ";\n");
                        A.Guardar_Codigo_GRafo(Arch, "Nodo" + actual_columna.izquierda.ID + "-> Nodo" + actual_columna.ID + ";\n");
                        A.Guardar_Codigo_GRafo(Arch, "Nodo" + actual_columna.ID + "-> Nodo" + actual_columna.abajo.ID + ";\n");
                        A.Guardar_Codigo_GRafo(Arch, "Nodo" + actual_columna.abajo.ID + "-> Nodo" + actual_columna.ID + ";\n\n");
                    } else if (actual_columna.izquierda == null && actual_columna.abajo != null) {
                        A.Guardar_Codigo_GRafo(Arch, "Nodo" + actual_columna.ID + "-> Nodo" + actual_columna.abajo.ID + ";\n");
                        A.Guardar_Codigo_GRafo(Arch, "Nodo" + actual_columna.abajo.ID + "-> Nodo" + actual_columna.ID + ";\n\n");
                    } else if (actual_columna.izquierda != null && actual_columna.abajo == null) {
                        A.Guardar_Codigo_GRafo(Arch, "Nodo" + actual_columna.ID + "-> Nodo" + actual_columna.izquierda.ID + ";\n");
                        A.Guardar_Codigo_GRafo(Arch, "Nodo" + actual_columna.izquierda.ID + "-> Nodo" + actual_columna.ID + ";\n");
                    }
                    actual_columna = actual_columna.izquierda;
                }
                actual_fila = actual_fila.abajo;
            }

            actual_fila = tablero.raiz;
            actual_columna = null;
            int contador2 = 1;
            while (actual_fila != null) {
                if (actual_fila.izquierda != null) {
                    A.Guardar_Codigo_GRafo(Arch, contador2 + "->Nodo" + actual_fila.ID + "[color = red];\n");
                    A.Guardar_Codigo_GRafo(Arch, "Nodo" + actual_fila.ID + "->" + contador2 + ";\n");
                    contador2++;
                    actual_fila = actual_fila.izquierda;
                } else {
                    A.Guardar_Codigo_GRafo(Arch, contador2 + "->Nodo" + actual_fila.ID + "[color = red];\n");
                    A.Guardar_Codigo_GRafo(Arch, "Nodo" + actual_fila.ID + "->" + contador2 + ";\n");
                    contador2++;
                    int contador3 = contador2 + 1;
                    while (actual_fila != null) {
                        A.Guardar_Codigo_GRafo(Arch, contador3 + "->Nodo" + actual_fila.ID + "[color = red];\n");
                        A.Guardar_Codigo_GRafo(Arch, "Nodo" + actual_fila.ID + "->" + contador3 + ";\n");
                        actual_fila = actual_fila.abajo;
                        if (actual_fila != null) {
                            A.Guardar_Codigo_GRafo(Arch, contador3 + "->");
                            contador3 = contador3 + 2;
                            A.Guardar_Codigo_GRafo(Arch, contador3 + "[color = red];\n");
                        }
                    }
                }
            }

            A.Guardar_Codigo_GRafo(Arch, "1->" + contador2 + "[color = red];\n");

            actual_fila = tablero.raiz;
            while (actual_fila != null) {
                A.Guardar_Codigo_GRafo(Arch, contador2 + "->Nodo" + actual_fila.ID + "[color = red];\n");
                A.Guardar_Codigo_GRafo(Arch, "Nodo" + actual_fila.ID + "->" + contador2 + ";\n");
                actual_columna = actual_fila;
                actual_fila = actual_fila.abajo;
                if (actual_fila != null) {
                    A.Guardar_Codigo_GRafo(Arch, contador2 + "->");
                    contador2 = contador2 + 2;
                    A.Guardar_Codigo_GRafo(Arch, contador2 + "[color = red];\n");
                } else {
                    contador2 = contador2 + 2;
                    while (actual_columna != null) {
                        A.Guardar_Codigo_GRafo(Arch, contador2 + "->Nodo" + actual_columna.ID + "[color = red];\n");
                        A.Guardar_Codigo_GRafo(Arch, "Nodo" + actual_columna.ID + "->" + contador2 + ";\n");
                        contador2++;
                        actual_columna = actual_columna.izquierda;
                    }
                }
            }

            A.Guardar_Codigo_GRafo(Arch, "\n}");
        } catch (IOException ex) {
        }
        A.Generar_Imagen_automata(
                "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe", "Matriz.txt", "Matriz.jpg");
    }
}
