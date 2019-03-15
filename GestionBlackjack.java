
public class GestionBlackjack {

		/*
		 * Estudio de Interfaz
		 * Signatura:public static void cargarBaraja (CartaImpl[] baraja)
		 * Comentario: carga la baraja de cartas con la baraja inglesa
		 * Precondiciones: como parametro se pasa el array de objetos de tipo CartaImpl
		 * Datos de entradas: como parametro se pasa el array de objetos de tipo CartaImpl
		 * Datos de salida:
		 * Datos de entrada/salida:
		 * Postcondiciones: no devuelve nada asociado al nombre pero modifica el objeto
		 * */
	public static void cargarBaraja (CartaImpl[] baraja){
		
		Palo corazon = Palo.CORAZONES;
		Palo diamante = Palo.DIAMANTES;
		Palo trebol = Palo.TREBOLES;
		Palo pica = Palo.PICAS;
		/*Los numeros ya estan puestos correctamente, no tocar*/
		for (int i = 0; i<=12; i++){
			baraja[i] = new CartaImpl((i+1),corazon);
			} 
		for (int i = 13, j=0; i<=25; i++, j++){
			baraja[i] = new CartaImpl((j+1),diamante);
			} 
		for (int i =26, j=0 ; i<=38; i++, j++){
			baraja[i] = new CartaImpl((j+1),trebol);
			} 
		for (int i = 39, j=0; i<=51; i++, j++){
			baraja[i] = new CartaImpl((j+1),pica);
			} 		
		
		}
	/*
	 * Estudio de Interfaz
	 * Signatura: public static int sumarPuntuacion (CartaImpl[] manoJugador)
	 * Comentario: calcula los puntos optimos (decide automaticamente si un AS vale 1 u 11) que tiene un jugador en su mano.
	 * Precondiciones: como parametro se pasa el array de objetos de tipo CartaImpl por referencia
	 * Datos de entradas: como parametro se pasa el array de objetos de tipo CartaImpl
	 * Datos de salida: la puntuacion que tiene
	 * Datos de entrada/salida:
	 * Postcondiciones: asociado al nombre devuelve la puntuacion de esa mano
	 * */
		public static int sumarPuntuacion (CartaImpl[] manoJugador){
			int puntuacion=0;
			boolean asCorazones = false;
			boolean asTreboles = false;
			boolean asDiamantes = false;
			boolean asPicas = false;
			for(int i =0; i<manoJugador.length && i<UtilidadBaraja.buscarSiguientePosicionLibre(manoJugador); i++){
				switch(manoJugador[i].getNumero()){
					case 2:
					case 3:
					case 4:
					case 5:
					case 6:
					case 7:
					case 8:
					case 9:
						puntuacion+=manoJugador[i].getNumero();
						if (puntuacion > 21 ) {

							for (int j = 0; j < i; j++) {
								if (manoJugador[i].getNumero() == 1) {
									switch (manoJugador[i].getPalo()) {
										case PICAS:
											if (asPicas) {
												puntuacion -= 10;
												asPicas = false;
											}
											break;
										case TREBOLES:
											if (asTreboles) {
												puntuacion -= 10;
												asTreboles = false;
											}
											break;
										case CORAZONES:
											if (asCorazones) {
												puntuacion -= 10;
												asCorazones = false;
											}
											break;
										case DIAMANTES:
											if (asDiamantes) {
												puntuacion -= 10;
												asDiamantes = false;
											}
											break;
									}
								}
							}
						}
						break;
					case 10:
					case 11:
					case 12:
					case 13:
						puntuacion+=10;
						if (puntuacion > 21 ) {

							for (int j = 0; j < i; j++) {
								if (manoJugador[i].getNumero() == 1) {
									switch (manoJugador[i].getPalo()) {
										case PICAS:
											if (asPicas) {
												puntuacion -= 10;
												asPicas = false;
											}
											break;
										case TREBOLES:
											if (asTreboles) {
												puntuacion -= 10;
												asTreboles = false;
											}
											break;
										case CORAZONES:
											if (asCorazones) {
												puntuacion -= 10;
												asCorazones = false;
											}
											break;
										case DIAMANTES:
											if (asDiamantes) {
												puntuacion -= 10;
												asDiamantes = false;
											}
											break;
									}
								}
							}
						}
						break;
					case 1:
							if ((puntuacion + 11 )<= 21){
								puntuacion +=11;
								switch (manoJugador[i].getPalo()){
									case PICAS:
										asPicas = true;
										break;
									case TREBOLES:
										asTreboles = true;
										break;
									case CORAZONES:
										asCorazones = true;
										break;
									case DIAMANTES:
										asDiamantes = true;
										break;
								}
							} else {
								puntuacion +=1;
								switch (manoJugador[i].getPalo()){
									case PICAS:
										asPicas = false;
										break;
									case TREBOLES:
										asTreboles = false;
										break;
									case CORAZONES:
										asCorazones = false;
										break;
									case DIAMANTES:
										asDiamantes = false;
										break;
								}
							}
						break;
				}

			}

			return puntuacion;
		}


}


