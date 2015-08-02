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
public class Lista_Doble {

    Nodo_Lista primero;
    Nodo_Lista ultimo;

    public void sampar_lista(String nombre, String objeto, int ID) {
        Nodo_Lista nuevo_nodo = new Nodo_Lista(nombre, objeto, ID);
        if (primero == null) {
            primero = nuevo_nodo;
            ultimo = nuevo_nodo;
            nuevo_nodo.anterior = null;
            nuevo_nodo.siguiente = null;
        } else {
            ultimo.siguiente = nuevo_nodo;
            nuevo_nodo.anterior = ultimo;
            nuevo_nodo.siguiente = null;
            ultimo = nuevo_nodo;
        }
    }

    public void imprimir() {
        Nodo_Lista actual = primero;
        while (actual != null) {
            System.out.println("ID: " + actual.ID + " Nombre: " + actual.nombre + " Objeto: " + actual.objeto);
            actual = actual.siguiente;
        }
    }

    public void eliminar_lista(Lista_Doble Lis, int ID) {
        Nodo_Lista actual = Lis.primero;
        while (actual != null) {
            if (actual.ID == ID) {
                if (actual == Lis.primero && actual == Lis.ultimo) {
                    Lis.primero = null;
                    Lis.ultimo = null;
                    actual = null;
                    System.gc();
                    break;
                } else if (actual == Lis.primero) {
                    Lis.primero = actual.siguiente;
                    Lis.primero.anterior = null;
                    actual.siguiente = null;
                    System.gc();
                    reacomodar_indices(Lis);
                } else if (actual == Lis.ultimo) {
                    Lis.ultimo = actual.anterior;
                    Lis.ultimo.siguiente = null;
                    actual.anterior = null;
                    System.gc();
                    reacomodar_indices(Lis);
                } else {
                    actual.anterior.siguiente = actual.siguiente;
                    actual.siguiente.anterior = actual.anterior;
                    actual.siguiente = null;
                    actual.anterior = null;
                    System.gc();
                    reacomodar_indices(Lis);
                }
            }
            actual = actual.siguiente;
        }
    }
    
    public void modificar(Lista_Doble Lis, int ID, String nombre){
        Nodo_Lista temp = Lis.primero;
        while (temp != null) {
            if (temp.ID == ID) {
                temp.nombre = nombre;
                break;
            }
            temp = temp.siguiente;
        }
    }

    public void reacomodar_indices(Lista_Doble Lis) {
        Nodo_Lista temp = Lis.primero;
        int i = 0;
        while (temp != null) {
            temp.ID = i;
            i++;
            temp = temp.siguiente;
        }
    }

    public String busqueda(Lista_Doble Lis, int ID) {
        Nodo_Lista temp = Lis.primero;
        String encontro = "";
        while (temp != null) {
            if (temp.ID == ID) {                
                encontro = temp.objeto;
                return encontro;
            }
            temp = temp.siguiente;
        }
        return null;
    }
}
