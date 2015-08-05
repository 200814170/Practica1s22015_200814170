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
public class PracticaNo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Carga_Objetos Carga_Objetos = new Carga_Objetos(null, null, 0);
        //Carga_Objetos.setVisible(true);

        Crear_Juego crear_juego = new Crear_Juego();
        crear_juego.setVisible(true);

        /*Matriz nuevamariz = new Matriz();
        nuevamariz.sampar_matriz("uno", 0);
        nuevamariz.sampar_matriz("dos", 1);
        nuevamariz.sampar_matriz("tres", 1);
        nuevamariz.sampar_matriz("cuatro", 1);
        nuevamariz.sampar_matriz("cinco", 2);
        nuevamariz.sampar_matriz("seis", 3);
        nuevamariz.sampar_matriz("siete", 3);
        nuevamariz.sampar_matriz("ocho", 3);
        nuevamariz.sampar_matriz("nuevo", 2);
        nuevamariz.sampar_matriz("diez", 3);
        nuevamariz.sampar_matriz("once", 3);
        nuevamariz.sampar_matriz("doce", 3);

        //llenar_matriz(10,10);
        System.out.println("Matriz Original");
        nuevamariz.imprimir_matriz();
        
        System.out.println("\nModificando\n");
        nuevamariz.modificar(3, 3, "Jose Miguel");
        
        System.out.println("\nMatriz ya modificada");
        nuevamariz.imprimir_matriz();*/

    }

    public static void llenar_matriz(int largo, int ancho) {
        Matriz nmatriz = new Matriz();
        nmatriz.sampar_matriz("La raiz de la matriz", 0);
        for (int i = 0; i < largo - 1; i++) {
            nmatriz.sampar_matriz("jose " + i, 1);
        }
        for (int i = 0; i < ancho - 1; i++) {
            nmatriz.sampar_matriz("jose " + i, 2);
            for (int j = 0; j < largo - 1; j++) {
                nmatriz.sampar_matriz("jose " + j, 3);
            }
        }
        nmatriz.imprimir_matriz();
    }
}
