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
    Nodo_Matriz temp1;
    Nodo_Matriz temp2;
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
        } else if (opcion == 4) {//opcion cuatro insertar un nuevo nodo en la ultima fila para crear una nueva columna
            temp1 = ultimo_fila;
            temp1.izquierda = nuevo;
            nuevo.derecha = temp1;
            nuevo.izquierda = null;
            nuevo.abajo = null;
            nuevo.arriba = null;
            ultimo_fila = nuevo;
            temp2 = ultimo_fila;
        } else if (opcion == 5) {// opcion cinco insertar un nuevo nodo en la nueva columna
            temp1 = temp1.arriba;
            temp1.izquierda = nuevo;
            temp2.arriba = nuevo;
            nuevo.derecha = temp1;
            nuevo.izquierda = null;
            nuevo.abajo = temp2;
            nuevo.arriba = null;
            temp2 = nuevo;
        }
    }

    public void reacomodar_indices() {
        int nuevo_indice = 0;
        Nodo_Matriz actual_columna = raiz;
        for (int j = 0; j < 1000; j++) {
            if (actual_columna != null) {
                Nodo_Matriz actual_fila = actual_columna;
                for (int i = 0; i < 1000; i++) {
                    if (actual_fila != null) {
                        actual_fila.ID = nuevo_indice;
                        nuevo_indice++;
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

    public void eliminar_fila(int fila) {
        Nodo_Matriz actual = raiz;
        int i = 1;

        while (actual != null) {
            if (fila == i) {
                if (actual == raiz) {
                    if (raiz.abajo != null) {
                        raiz = raiz.abajo;
                        while (actual != null) {
                            actual.abajo.arriba = null;
                            actual.abajo = null;
                            actual = actual.izquierda;
                        }
                        reacomodar_indices();
                    } else {
                        raiz = null;
                        primero_fila = null;
                        ultimo_fila = null;
                        primero_columna = null;
                        ultimo_columna = null;
                    }
                    System.gc();
                    break;
                } else if (actual.abajo != null) {
                    while (actual != null) {
                        actual.arriba.abajo = actual.abajo;
                        actual.abajo.arriba = actual.arriba;
                        actual.arriba = null;
                        actual.abajo = null;
                        actual = actual.izquierda;
                    }
                    reacomodar_indices();
                    System.gc();
                    break;
                } else {
                    primero_fila = primero_fila.arriba;
                    ultimo_columna = ultimo_columna.arriba;
                    ultimo_fila = ultimo_fila.arriba;
                    while (actual != null) {
                        actual.arriba.abajo = null;
                        actual.arriba = null;
                        actual = actual.izquierda;
                    }
                    reacomodar_indices();
                    System.gc();
                    break;
                }
            }
            actual = actual.abajo;
            i++;
        }
    }

    public void eliminar_columna(int columna) {
        Nodo_Matriz actual = raiz;
        int i = 1;

        while (actual != null) {
            if (columna == i) {
                if (actual == raiz) {
                    if (raiz.izquierda != null) {
                        raiz = raiz.izquierda;
                        while (actual != null) {
                            actual.izquierda.derecha = null;
                            actual.izquierda = null;
                            actual = actual.abajo;
                        }
                        reacomodar_indices();
                    } else {
                        raiz = null;
                        primero_fila = null;
                        ultimo_fila = null;
                        primero_columna = null;
                        ultimo_columna = null;
                    }
                    System.gc();
                    break;
                } else if (actual.izquierda != null) {
                    while (actual != null) {
                        actual.izquierda.derecha = actual.derecha;
                        actual.derecha.izquierda = actual.izquierda;
                        actual.izquierda = null;
                        actual.derecha = null;
                        actual = actual.abajo;
                    }
                    reacomodar_indices();
                    System.gc();
                    break;
                } else {
                    ultimo_fila = ultimo_fila.derecha;
                    while (actual != null) {
                        actual.derecha.izquierda = null;
                        actual.derecha = null;
                        actual = actual.abajo;
                    }
                    reacomodar_indices();
                    System.gc();
                    break;
                }
            }
            actual = actual.izquierda;
            i++;
        }
    }

    public boolean fila_vacia(int fila) {
        Nodo_Matriz actual = raiz;
        int i = 1;

        while (actual != null) {
            if (fila == i) {
                while (actual != null) {
                    if (actual.objeto.equals("vacio")) {
                        actual = actual.izquierda;
                    } else {
                        return false;
                    }
                }
                return true;
            }
            actual = actual.abajo;
            i++;
        }
        return false;
    }

    public boolean columna_vacia(int columna) {
        Nodo_Matriz actual = raiz;
        int i = 1;

        while (actual != null) {
            if (columna == i) {
                while (actual != null) {
                    if (actual.objeto.equals("vacio")) {
                        actual = actual.abajo;
                    } else {
                        return false;
                    }
                }
                return true;
            }
            actual = actual.izquierda;
            i++;
        }
        return false;
    }
}
