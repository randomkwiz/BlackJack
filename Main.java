/*
 * Alumna: Angela Vazquez Dominguez
 * Comentario: Juego del black jack (las 21)
 * Datos de entrada: opciones del /de los usuarios (dos jugadores, la maquina no juega)
 * Datos de salida: mensajes de ayuda al usuario
 * Restricciones: las entradas por teclado del usuario deberan pertenecer al rango de respuestas validas estipulado por el programador
 *
 * PSEUDOCODIGO
 *   inicio
 *       repetir
 *       mostrarMenuLeerValidarOpcion
 *       si (opcion no es salir)
 *           segun(opcion)
 *               caso 1
 *                   jugar
 *               caso 2
 *                   leerInstrucciones
 *           finSegun
 *       finSi
 *       mientras(opcion no es salir)
 *   fin
 * */

/* PSEUDOCODIGO DEL MODULO JUGAR
* JUGAR
*   inicio
	barajarCartas*
*       repartir cartas iniciales
*   repetir
	turno jugador 1
		mostrarCartasJugadorUno
		si (ha ganado o se ha pasado)
			el juego finaliza
		mostrarValidarMenuCartasOpcion
*       si (opcion no es salir)
*           segun(opcion)
*               caso 1
*                   pedirCarta
*               caso 2
*                   plantarse
	    finSegun
	finSi
	si (opcion de menu cartas no fue plantarse)
	turno jugador 2
		mostrarCartasJugadorDos
		si (ha ganado o se ha pasado)
			el juego finaliza
		mostrarValidarMenuCartasOpcion
*       si (opcion no es salir)
*           segun(opcion)
*               caso 1
*                   pedirCarta
*               caso 2
*                   plantarse
	    finSegun
	finSi
	finSi
*   mientras(el juego continue)
	mostrarResultadosJuego
*   fin
* */
public class Main {

    public static void main(String[] args) {
        int opcion,opcionCartas, ronda;
        boolean juegoFinalizado;
        CartaImpl baraja[] = new CartaImpl[52];

        int puntuacionJugadorUno, puntuacionJugadorDos;
        do{
            //mostrarMenuLeerValidarOpcion
            opcion= Validar.opcionMenu();
            if (opcion != 0 ){
                switch (opcion){
                    case 1:
                        //Jugar
                        juegoFinalizado=false;
                        ronda = 0;
                        puntuacionJugadorUno = 0;
                        puntuacionJugadorDos = 0;
                        CartaImpl manoJugadorUno[] = new CartaImpl[26];
                        CartaImpl manoJugadorDos[] = new CartaImpl[26];
                        GestionBlackjack.cargarBaraja(baraja);
                        UtilidadBaraja.barajarCartas(baraja);
                        //Se reparten las cartas iniciales
                        for(int i =0; i < 2 ;i++) {
                            manoJugadorUno[i] = baraja[UtilidadBaraja.posicionSiguienteCarta(baraja)];
                            UtilidadBaraja.sacarSiguienteCarta(baraja);
                            manoJugadorDos[i] = baraja[UtilidadBaraja.posicionSiguienteCarta(baraja)];
                            UtilidadBaraja.sacarSiguienteCarta(baraja);
                        }
                        do {
                            ronda++;
                            System.out.println("--------------Ronda " + ronda + "--------------");
                            System.out.println("Turno jugador 1");

                            System.out.println("Cartas del jugador 1:");

                            UtilidadBaraja.imprimirBaraja(manoJugadorUno, UtilidadBaraja.buscarSiguientePosicionLibre(manoJugadorUno));
                            puntuacionJugadorUno = GestionBlackjack.sumarPuntuacion(manoJugadorUno);
                            System.out.println("Tienes: "+puntuacionJugadorUno);
                            if (puntuacionJugadorUno >= 21){
                                juegoFinalizado = true;
                            }
                            //mostrar menu
                            opcionCartas = Validar.opcionMenuCarta();
                            if (opcionCartas != 0) {
                                switch (opcionCartas) {
                                    case 1:
                                        //Pedir carta para jugador 1
                                        int posicion = UtilidadBaraja.buscarSiguientePosicionLibre(manoJugadorUno);
                                        manoJugadorUno[posicion] = baraja[UtilidadBaraja.posicionSiguienteCarta(baraja)];
                                        UtilidadBaraja.sacarSiguienteCarta(baraja);
                                        System.out.println(manoJugadorUno[posicion].toString());
                                        puntuacionJugadorUno = GestionBlackjack.sumarPuntuacion(manoJugadorUno);
                                        System.out.println("Tienes: "+puntuacionJugadorUno);
                                        if (puntuacionJugadorUno >= 21){
                                            juegoFinalizado = true;
                                        }

                                        break;
                                    case 2:
                                        //Plantarse
                                        juegoFinalizado = true;
                                        break;
                                }
                            }
                            if (opcionCartas != 2){
                                System.out.println("------------------------------");
                                System.out.println("Turno jugador 2");


                            System.out.println("Cartas del jugador 2: ");
                            UtilidadBaraja.imprimirBaraja(manoJugadorDos, UtilidadBaraja.buscarSiguientePosicionLibre(manoJugadorDos));
                            puntuacionJugadorDos = GestionBlackjack.sumarPuntuacion(manoJugadorDos);
                            System.out.println("Tienes: "+puntuacionJugadorDos);
                            if (puntuacionJugadorDos >= 21){juegoFinalizado=true;}
                            //mostrar menu
                            opcionCartas = Validar.opcionMenuCarta();
                            if (opcionCartas != 0) {
                                switch (opcionCartas) {
                                    case 1:
                                        //Pedir carta para jugador 2
                                        int posicion = UtilidadBaraja.buscarSiguientePosicionLibre(manoJugadorDos);
                                        manoJugadorDos[posicion] = baraja[UtilidadBaraja.posicionSiguienteCarta(baraja)];
                                        UtilidadBaraja.sacarSiguienteCarta(baraja);
                                        System.out.println(manoJugadorDos[posicion].toString());
                                        puntuacionJugadorDos = GestionBlackjack.sumarPuntuacion(manoJugadorDos);
                                        System.out.println("El jugador 2 tiene: "+puntuacionJugadorDos);
                                        if (puntuacionJugadorDos >= 21){juegoFinalizado=true;}
                                        break;
                                    case 2:
                                        //Plantarse
                                        juegoFinalizado = true;
                                        break;
                                }
                            }
                        }

                        }while(!juegoFinalizado);

                        //MostrarResultados del juego
                        UtilidadBaraja.imprimirBaraja(manoJugadorUno, UtilidadBaraja.buscarSiguientePosicionLibre(manoJugadorUno));
                        puntuacionJugadorUno = GestionBlackjack.sumarPuntuacion(manoJugadorUno);
                        System.out.println("El jugador 1 tiene: "+puntuacionJugadorUno+" puntos.");
                        UtilidadBaraja.imprimirBaraja(manoJugadorDos, UtilidadBaraja.buscarSiguientePosicionLibre(manoJugadorDos));
                        puntuacionJugadorDos = GestionBlackjack.sumarPuntuacion(manoJugadorDos);
                        System.out.println("El jugador 2 tiene: "+puntuacionJugadorDos+" puntos.");

                        if (puntuacionJugadorUno == puntuacionJugadorDos || (puntuacionJugadorUno > 21 && puntuacionJugadorDos > 21)) {
                            System.out.println("Nadie gana");
                        } else if (puntuacionJugadorUno == 21 || puntuacionJugadorDos == 21) {
                            if (puntuacionJugadorUno == 21) {
                                System.out.println("Ha ganado el jugador 1");
                            } else {
                                System.out.println("Ha ganado el jugador 2");
                            }
                        }else {
                            if (puntuacionJugadorUno <21 && (puntuacionJugadorUno > puntuacionJugadorDos || puntuacionJugadorDos > 21)) {
                                System.out.println("Ha ganado el jugador 1");
                            } else if (puntuacionJugadorDos < 21 && ( puntuacionJugadorDos > puntuacionJugadorUno || puntuacionJugadorUno > 21)){
                                System.out.println("Ha ganado el jugador 2");
                            }
                        }

                        break;
                    case 2:
                        //leerInstrucciones
                        System.out.println("INSTRUCCIONES DEL JUEGO");

                        System.out.println("El objeto del juego es obtener 21 puntos, o tantos puntos como sea posible sin exceder de 21 en cada mano. \nUn jugador es automáticamente descalificado si las cartas en su mano exceden de 21 puntos. \nLas figuras cuentan 10 puntos y un as puede contar 1 u 11 puntos. \nAsí un jugador puede obtener 21 puntos (¡blackjack!) si tiene un as y una figura, o un as, una figura y un 10. \nSi el jugador tiene menos puntos con sus dos primeras cartas, puede pedir una carta o más, mientras su puntuación no pase de 21 y puede plantarse cuando quiera.\n" +
                                "Téngase en cuentas que la misma carta no puede ser dada más de una vez.\n" +
                                "Se jugarán tantas manos como deseen los jugadores, es decir, bastará con que uno de ellos desee dejar de jugar, \nteniendo en cuenta que el que vaya perdiendo decide si desea la revancha.");
                        break;
                }
            }
        }while (opcion != 0);
    }
}
