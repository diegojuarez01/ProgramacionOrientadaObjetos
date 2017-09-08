
package practica1;

import java.util.ArrayList;
import java.util.Collections;


public class Baraja {
	
	//Declaracion de variables
	private String tipo;
	ArrayList<Carta> barajaArrayList =new ArrayList<Carta> ();	
	
	
	//Metodo para diferenciar entre los diferentes tipos de barajas
	public void selecionarBaraja()
	{
		
	switch (tipo) {
	
	case "e":
	case "E":
		
	//Creamos las cartas de la baraja española y las introducimos en el array barajaArrayList	
		for (int i=1;i<7;i++)
	{
		Carta carta1 = new Carta (""+i,"Copas");
		barajaArrayList.add(carta1);
	}
								
		Carta carta2 = new Carta ("Sota","Copas");
		barajaArrayList.add(carta2);
		Carta carta3 = new Carta ("Caballo","Copas");
		barajaArrayList.add(carta3);
		Carta carta4 = new Carta ("Rey","Copas");
		barajaArrayList.add(carta4);
		
		for (int i=1;i<7;i++)
		{
			Carta carta1 = new Carta (""+i,"Oros");
			barajaArrayList.add(carta1);
		}
		
		Carta carta5 = new Carta ("Sota","Oros");
		barajaArrayList.add(carta5);
		Carta carta6 = new Carta ("Caballo","Oros");
		barajaArrayList.add(carta6);
		Carta carta7 = new Carta ("Rey","Oros");
		barajaArrayList.add(carta7);
		
		for (int i=1;i<7;i++)
		{
			Carta carta1 = new Carta (""+i,"Espadas");
			barajaArrayList.add(carta1);
		}
		
		Carta carta8 = new Carta ("Sota","Espadas");
		barajaArrayList.add(carta8);
		Carta carta9 = new Carta ("Caballo","Espadas");
		barajaArrayList.add(carta9);
		Carta carta10 = new Carta ("Rey","Espadas");
		barajaArrayList.add(carta10);
		
		for (int i=1;i<7;i++)
		{
			Carta carta1 = new Carta (""+i,"Bastos");
			barajaArrayList.add(carta1);
		}
		
		Carta carta11 = new Carta ("Sota","Bastos");
		barajaArrayList.add(carta11);
		Carta carta12 = new Carta ("Caballo","Bastos");
		barajaArrayList.add(carta12);
		Carta carta13 = new Carta ("Rey","Bastos");
		barajaArrayList.add(carta13);
		
		Barajar();
		System.out.println("Baraja española seleccionada");
		break;
		
	case "f":	
	case "F":
		
		for (int i=2;i<10;i++)
		{
			Carta carta1 = new Carta (""+i,"Picas");
			barajaArrayList.add(carta1);
		}
		
		Carta carta14 = new Carta ("Jota","Picas");
		barajaArrayList.add(carta14);
		Carta carta15 = new Carta ("Caballo","Picas");
		barajaArrayList.add(carta15);
		Carta carta16 = new Carta ("Rey","Picas");
		barajaArrayList.add(carta16);
		Carta carta17 = new Carta ("As","Picas");
		barajaArrayList.add(carta17);
		
		for (int i=2;i<10;i++)
		{
			Carta carta1 = new Carta (""+i,"Rombos");
			barajaArrayList.add(carta1);
		}
		
		Carta carta18 = new Carta ("Jota","Rombos");
		barajaArrayList.add(carta18);
		Carta carta19 = new Carta ("Caballo","Rombos");
		barajaArrayList.add(carta19);
		Carta carta20 = new Carta ("Rey","Rombos");
		barajaArrayList.add(carta20);
		Carta carta21 = new Carta ("As","Rombos");
		barajaArrayList.add(carta21);
		
		for (int i=2;i<10;i++)
		{
			Carta carta1 = new Carta (""+i,"Treboles");
			barajaArrayList.add(carta1);
		}
		
		Carta carta22 = new Carta ("Jota","Treboles");
		barajaArrayList.add(carta22);
		Carta carta23 = new Carta ("Caballo","Treboles");
		barajaArrayList.add(carta23);
		Carta carta24 = new Carta ("Rey","Treboles");
		barajaArrayList.add(carta24);
		Carta carta25 = new Carta ("As","Treboles");
		barajaArrayList.add(carta25);
		
		for (int i=2;i<10;i++)
		{
			Carta carta1 = new Carta (""+i,"Corazones");
			barajaArrayList.add(carta1);
		}
		
		Carta carta26 = new Carta ("Jota","Corazones");
		barajaArrayList.add(carta26);
		Carta carta27 = new Carta ("Caballo","Corazones");
		barajaArrayList.add(carta27);
		Carta carta28 = new Carta ("Rey","Corazones");
		barajaArrayList.add(carta28);
		Carta carta29 = new Carta ("As","Corazones");
		barajaArrayList.add(carta29);
		
		System.out.println("Baraja francesa seleccionada");
		Barajar();
	
	default:
		break;
	}
	
	}
	

	
   //funcion para crear las cartas con sus respectivos palos

	//private void CrearCartasPalos()
		
	
	//Modificamos el metodo toString
	@Override
	public String toString() {
	    return barajaArrayList.toString();
	}
		
	//Metodo para dar carta a los jugadores y borrarlas
	public Carta obtenerCartas()
	{
		
			Carta carta = new Carta("","");
			carta.setNumeros(barajaArrayList.get(0).getNumeros());
			carta.setPalos(barajaArrayList.get(0).getPalos());
			barajaArrayList.remove(0);
			System.out.println(carta);
			return carta;
	}
	
	//Metodo para mover los elementos de posicion en el array barajaArrayList.
	private void Barajar()
	
	{
		Collections.shuffle(barajaArrayList);
	}

		
	//Metodos get and set para la variable tipo de baraja
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	 
}
