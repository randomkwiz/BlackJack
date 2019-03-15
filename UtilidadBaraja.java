/*Clase de utilidad para arrays del tipo CartaImpl*/
public class UtilidadBaraja {
    /*
     * Estudio de Interfaz
     * Signatura: public static void barajarCartas (CartaImpl[] baraja)
     * Comentario: baraja la baraja de cartas
     * Precondiciones: se pasa una baraja de cartas
     * Datos de entradas: array de cartas
     * Datos de salida:
     * Datos de entrada/salida:
     * Postcondiciones: no devuelve nada asociado al nombre pero modifica el objeto
     * */
    public static void barajarCartas (CartaImpl[] baraja) {
        CartaImpl auxiliarBaraja[] = new CartaImpl[52];

        int posicionAuxiliar;
        for(int i = 0; i < baraja.length; i++){
            do {
                posicionAuxiliar = (int) Math.floor(Math.random() * 52);
            }while ( !( isPosicionAsignada(auxiliarBaraja, posicionAuxiliar) )  );
            auxiliarBaraja[posicionAuxiliar] = baraja[i];
        }

        for (int i = 0; i<baraja.length;i++){
            baraja[i] = auxiliarBaraja[i];
        }
    }

    /*Estudio de interfaz
     * Signatura: public static boolean isCasillaVacia (CartaImpl[] baraja, int posicion)
     * Comentario: comprueba si una posicion de un array de cartas tiene ya asignada una carta o no
     * Precondiciones: por referencia se pasa un array de objetos
     * Datos de entrada: baraja de cartas
     * Datos de salida: booleano que devuelve true si la casilla esta vacia y false si esta llena
     * Postcondiciones: asociado al nombre se devuelve un boolean devuelve true si la casilla esta vacia y false si esta llena
     *
     * */
    public static boolean isPosicionAsignada (CartaImpl[] baraja, int posicion){
        boolean vacia = false;
        if (baraja[posicion] == null){
            vacia = true;
        }
        return vacia;
    }

    /* Estudio de interfaz
     * Signatura: public static void sacarSiguienteCarta (CartaImpl[] baraja)
     * Comentario: saca de la baraja de cartas la siguiente carta disponible
     * Precondiciones: por referencia se pasa una baraja de cartas
     * Datos de entrada: baraja de cartas
     * Datos de salida: ninguno
     * Postcondiciones: se modifica el array de objetos
     */
    public static void sacarSiguienteCarta (CartaImpl[] baraja){

        baraja[posicionSiguienteCarta(baraja)] = null;	//asi indico que se ha sacado esa carta de la baraja
    }

    /* Estudio de interfaz
     * Signatura: public static int posicionSiguienteCarta (CartaImpl[] baraja)
     * Comentario: busca la siguiente carta en la baraja
     * Precondiciones: por referencia se pasa una baraja de cartas
     * Datos de entrada: baraja de cartas
     * Datos de salida: posicion de la siguiente carta en la baraja(entero)
     * Postcondiciones:  asociado al nombre se devuelve la posicion
     */
    public static int posicionSiguienteCarta (CartaImpl[] baraja){
        int posicion=0;
        for(int i = baraja.length-1;( i>=0 && baraja[i] != null );i--){ //la condicion funciona no la toques mas
            posicion = i;
        }
        return posicion;
    }
    /*
     * Estudio de Interfaz
     * Signatura: public static void imprimirBaraja (CartaImpl[] baraja)
     * Comentario: imprime en pantalla una baraja de cartas dada
     * Precondiciones: por referencia se pasa un array de cartas
     * Datos de entradas: array de cartas
     * Datos de salida:
     * Datos de entrada/salida:
     * Postcondiciones: imprime en pantalla
     * */
    public static void imprimirBaraja (CartaImpl[] baraja){
        for(int i = 0; i < baraja.length; i++){
            System.out.println(baraja[i].toString());
        }
    }
    /*
     * Estudio de Interfaz
     * Signatura: public static void imprimirBaraja(CartaImpl[] baraja, int posicionMax)
     * Comentario: Es un metodo sobrecargado. Imprime en pantalla una baraja de cartas dada hasta una posicion dada
     * Precondiciones: por referencia se pasa un array de cartas y por valor un entero que es la posicion maxima hasta la que
     *                  se mostrara la baraja
     * Datos de entradas: array de cartas y entero posicion
     * Datos de salida:
     * Datos de entrada/salida:
     * Postcondiciones: imprime en pantalla
     * */
    public static void imprimirBaraja(CartaImpl[] baraja, int posicionMax){
        for(int i = 0; i < posicionMax; i++){
            System.out.println(baraja[i].toString());
        }

    }

    /* Estudio de interfaz
     * Signatura: public static int buscarSiguientePosicionLibre (CartaImpl[] baraja)
     * Comentario: busca el siguiente hueco libre en un array de cartas (una mano, para colocar la siguiente carta robada)
     * Precondiciones: por referencia se pasa una baraja de cartas
     * Datos de entrada: array de cartas
     * Datos de salida: el numero de la posicion libre
     * Postcondiciones: asociado al nombre se devuelve la posicion
     */
    public static int buscarSiguientePosicionLibre (CartaImpl[] baraja){
        int posicion=0;

        for(int i = 0;( i<(baraja.length) && baraja[i] != null );i++){
            posicion = i+1;     /*Para que devuelva el que si es nulo. Funciona. No tocar mas*/
        }
        return posicion;
    }
}
