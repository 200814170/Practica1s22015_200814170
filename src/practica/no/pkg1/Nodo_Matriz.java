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
public class Nodo_Matriz {
    String objeto;
    int ID;
    Nodo_Matriz derecha;
    Nodo_Matriz izquierda;
    Nodo_Matriz arriba;
    Nodo_Matriz abajo;
    public Nodo_Matriz (String objeto, int ID){
        this.objeto = objeto;
        this.ID = ID;
        derecha = null;
        izquierda  = null;
        arriba = null;
        abajo  = null;
    }
    
}
