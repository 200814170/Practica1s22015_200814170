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
public class Nodo_Lista {
    int ID;
    String nombre;
    String objeto;
    Nodo_Lista siguiente;
    Nodo_Lista anterior;
    
    public Nodo_Lista(String nombre, String objeto, int ID){
        this.nombre = nombre;
        this.objeto = objeto;
        this.ID = ID;
        siguiente = null;
        anterior = null;
    }
}
