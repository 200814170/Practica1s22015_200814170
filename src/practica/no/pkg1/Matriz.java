/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.no.pkg1;

/**
 *
 * @author Tony
 */
public class Matriz {

    Nodo_Matriz primero_fila;
    Nodo_Matriz ultimo_fila;
    Nodo_Matriz primero_columna;
    Nodo_Matriz ultimo_columna;
    Nodo_Matriz raiz;

    public void sampar_matriz(String objeto, int ID, int opcion) {
        Nodo_Matriz nuevo = new Nodo_Matriz(objeto, ID);
        if (primero_fila == null && opcion == 0) {//opcion cero insertar el primer nodo
            nuevo.izquierda = null;
            nuevo.derecha = null;
            nuevo.abajo = null;
            nuevo.arriba = null;
            primero_fila = nuevo;
            ultimo_fila = nuevo;
            primero_columna = nuevo;
            ultimo_columna = nuevo;
            raiz = nuevo;
        } else if (opcion == 1) {//opcion uno insertar un nuevo nodo en la primera fila
            nuevo.derecha = ultimo_fila;
            nuevo.izquierda = null;
            nuevo.abajo = null;
            nuevo.arriba = null;
            ultimo_fila.izquierda = nuevo;
            ultimo_fila = nuevo;
        } else if (opcion == 2) {//opcion dos insertar un nuevo nodo en la columna
            nuevo.arriba = ultimo_columna;
            nuevo.izquierda = null;
            nuevo.derecha = null;
            nuevo.abajo = null;
            ultimo_columna.abajo = nuevo;
            primero_fila = nuevo;
            ultimo_fila = nuevo;
            ultimo_columna = nuevo;
            primero_columna = nuevo.arriba;
        } else if (opcion == 3) {//opcion tres insertar un nuevo nodo en las siguientes filas
            nuevo.derecha = ultimo_fila;
            nuevo.izquierda = null;
            nuevo.abajo = null;
            nuevo.arriba = primero_columna.izquierda;
            primero_columna.izquierda.abajo = nuevo;
            ultimo_fila.izquierda = nuevo;
            primero_columna = nuevo.arriba;
            ultimo_fila = nuevo;
        }
    }

    public void imprimir_matriz() {
        Nodo_Matriz actual_columna = raiz;
        for (int j = 0; j < 1000; j++) {
            if (actual_columna != null) {
                System.out.println("-----Fila No. " + (j + 1) + "-----");
                Nodo_Matriz actual_fila = actual_columna;
                for (int i = 0; i < 1000; i++) {
                    if (actual_fila != null) {
                        System.out.println("ID: " + actual_fila.ID + " Objeto: " + actual_fila.objeto);
                    } else {
                        break;
                    }
                    actual_fila = actual_fila.izquierda;
                }
            } else {
                break;
            }
            actual_columna = actual_columna.abajo;
        }
    }

    public void modificar(int donde, String contenido) {
        Nodo_Matriz actual_columna = raiz;
        for (int j = 1; j < 1000 + 1; j++) {
            Nodo_Matriz actual_fila = actual_columna;
            for (int i = 1; i < 1000 + 1; i++) {
                if (actual_fila.ID == donde) {
                    System.out.println("\nEncontrado: " + actual_fila.objeto);
                    actual_fila.objeto = contenido;
                }
                actual_fila = actual_fila.izquierda;
                if (actual_fila == null) {
                    break;
                }
            }
            actual_columna = actual_columna.abajo;
            if (actual_columna == null) {
                break;
            }
        }
    }

    public void eliminar_matriz() {
        raiz = null;
        primero_fila = null;
        ultimo_fila = null;
        primero_columna = null;
        ultimo_columna = null;
        System.gc();
    }
}
