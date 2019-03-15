/*Lee y valida las entradas para el juego del Black Jack*/
import java.util.Scanner;
public class Validar {

    /* INTERFAZ
        Cabecera: public int opcionMenu ()
        Comentario: muestra el menu y valida la opcion
        Precondiciones:
        Datos de entrada:
        Datos de salida: entero que es la opcion
        Datos entrada/salida:
        Postcondiciones: asociado al nombre devuelve un entero
    */
    public static int opcionMenu () {
        Scanner entrada = new Scanner(System.in);
        int opcion;
        do{
            System.out.println("-------MENU------");
            System.out.println("0. Salir");
            System.out.println("1. Jugar");
            System.out.println("2. Instrucciones");
            opcion = entrada.nextInt();
        }while(opcion < 0 || opcion > 2);
    return opcion;
    }

    /* INTERFAZ
        Cabecera: public int opcionMenuCarta ()
        Comentario: muestra el menu del juego del black jack y valida la opcion
        Precondiciones:
        Datos de entrada:
        Datos de salida: entero que es la opcion
        Datos entrada/salida:
        Postcondiciones: asociado al nombre devuelve un entero
    */
    public static int opcionMenuCarta () {
        Scanner entrada = new Scanner(System.in);
        int opcion;
        do{
            System.out.println("-------MENU------");
            System.out.println("0. Salir");
            System.out.println("1. Pedir carta");
            System.out.println("2. Plantarse");
            opcion = entrada.nextInt();
        }while(opcion < 0 || opcion > 2);
        return opcion;
    }
}
