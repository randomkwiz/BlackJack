

public class CartaTest {
	
	public static void main (String[] args) {
		
		Palo palo1 = Palo.CORAZONES;
		Palo palo2 = Palo.DIAMANTES;
		Palo palo3 = Palo.TREBOLES;
		Palo palo4 = Palo.PICAS;
		
		
		CartaImpl carta1 = new CartaImpl(1, palo1);
		CartaImpl carta2 = new CartaImpl(12, palo2);
		CartaImpl carta3 = new CartaImpl(5, palo3);
		CartaImpl carta4 = new CartaImpl(11, palo2);
		CartaImpl carta5 = new CartaImpl(13, palo1);
		
		System.out.println(palo1.toString());
		System.out.println(palo2.toString());
		System.out.println(palo3.toString());
		System.out.println(palo4.toString());
		
		System.out.println(carta1.toString());
		System.out.println(carta2.toString());
		System.out.println(carta3.toString());
		System.out.println(carta4.toString());
		System.out.println(carta5.toString());
		
		
		
		
	}
}

