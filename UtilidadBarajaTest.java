


public class UtilidadBarajaTest {
	
	public static void main (String[] args) {
		CartaImpl baraja[] = new CartaImpl[52];
        CartaImpl manoJugadorUno[] = new CartaImpl[26];


		GestionBlackjack.cargarBaraja(baraja);

		//GestionBlackjack.imprimirBaraja(baraja);
		UtilidadBaraja.barajarCartas(baraja);
		//System.out.println("\n\nBARAJADO\n\n");
		//UtilidadBaraja.imprimirBaraja(baraja);
		//System.out.println("FIN\n\n");
/*
		for(int i = 0; i < baraja.length; i++) {
			UtilidadBaraja.sacarSiguienteCarta(baraja);
		}
	*/
/*
        manoJugadorUno[0] = baraja[UtilidadBaraja.posicionSiguienteCarta(baraja)];
        System.out.println(UtilidadBaraja.posicionSiguienteCarta(baraja));
		System.out.println(manoJugadorUno[0].toString() );
        UtilidadBaraja.sacarSiguienteCarta(baraja);
        System.out.println(UtilidadBaraja.posicionSiguienteCarta(baraja));
        UtilidadBaraja.sacarSiguienteCarta(baraja);
        System.out.println(UtilidadBaraja.posicionSiguienteCarta(baraja));
        UtilidadBaraja.sacarSiguienteCarta(baraja);
        System.out.println(UtilidadBaraja.posicionSiguienteCarta(baraja));
        UtilidadBaraja.imprimirBaraja(manoJugadorUno, (UtilidadBaraja.buscarSiguientePosicionLibre(manoJugadorUno)) );
*/

        System.out.println(UtilidadBaraja.buscarSiguientePosicionLibre(manoJugadorUno));

        manoJugadorUno[UtilidadBaraja.buscarSiguientePosicionLibre(manoJugadorUno)] = baraja[UtilidadBaraja.posicionSiguienteCarta(baraja)];
        UtilidadBaraja.sacarSiguienteCarta(baraja);
       /*
        manoJugadorUno[1] = baraja[1];
        manoJugadorUno[2] = baraja[2];
        manoJugadorUno[3] = baraja[3];
        */
        System.out.println(UtilidadBaraja.buscarSiguientePosicionLibre(manoJugadorUno));

        manoJugadorUno[UtilidadBaraja.buscarSiguientePosicionLibre(manoJugadorUno)] = baraja[UtilidadBaraja.posicionSiguienteCarta(baraja)];

        UtilidadBaraja.sacarSiguienteCarta(baraja);

        System.out.println(UtilidadBaraja.buscarSiguientePosicionLibre(manoJugadorUno));
        manoJugadorUno[UtilidadBaraja.buscarSiguientePosicionLibre(manoJugadorUno)] = baraja[UtilidadBaraja.posicionSiguienteCarta(baraja)];
        UtilidadBaraja.sacarSiguienteCarta(baraja);

        System.out.println(UtilidadBaraja.buscarSiguientePosicionLibre(manoJugadorUno));

        //System.out.println(manoJugadorUno[posicion].toString());

        UtilidadBaraja.imprimirBaraja(manoJugadorUno, UtilidadBaraja.buscarSiguientePosicionLibre(manoJugadorUno));

	}
}

