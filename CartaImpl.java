/* Estudio de la clase
 *
 * Clase: CartaImpl
 * Propiedades:
 * 	Basicas:
 * 		-Palo palo	-consultable
 * 		-int Numero -consultable
 * 	derivadas:
 * 	compartidas:
 * Restricciones: Los numeros deben estar comprendidos entre 1 y 12 ambos inclusive
 * Metodos para interface:
 *	public Palo getPalo ();
	public int getNumero();
 * Metodos añadidos:
 *
 * Metodos Object:
 * 		toString
 * 		clone
 *
 * */


public class CartaImpl implements Carta, Cloneable{

    private Palo palo;
    private int numero;

    //Constructor

    /*Constructor por defecto*/
    public CartaImpl(){
        palo = palo.NULL;
        numero = 1;
    }

    /*Constructor con parametros*/
    public CartaImpl(int numero, Palo palo){
        this.palo = palo;
        this.numero = numero;
    }

    /*Constructor de copia*/
    public CartaImpl (CartaImpl carta) {
        this.palo = carta.getPalo();
        this.numero = carta.getNumero();
    }

    //getters

    public Palo getPalo (){
        return this.palo;
    }
    public int getNumero(){return this.numero;}

    /*No hay setters porque no existen propiedades derivadas ni modificables*/

    //Metodos object

    public String toString() {
        String carta=" ";
        if (this.getNumero() == 1){
            carta = "AS de "+this.getPalo();
        } else if (this.getNumero() == 11 || this.getNumero() == 12 || this.getNumero() == 13){
            switch(this.getNumero()) {
                case 11:
                    carta = "J de "+this.getPalo();
                    break;
                case 12:
                    carta = "Q de "+this.getPalo();
                    break;
                case 13:
                    carta = "K de "+this.getPalo();
                    break;

            }
        }else {
            carta = numero+" de "+this.getPalo();
        }

        return carta;
    }
/*Clone*/
    @Override
    public CartaImpl clone(){
        CartaImpl copia = null;
        try{
            copia = (CartaImpl) super.clone();
        }catch(CloneNotSupportedException error){System.out.println("Error en la copia");}
        return copia;
    }
}

