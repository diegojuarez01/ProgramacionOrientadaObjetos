package practica1;


public class Carta {

	private String palos;
	private String numeros;
	
	
	
	public Carta (String numeros,String palo)
	{
		this.setNumeros(numeros);
		this.setPalos(palo);
		
	}
	
	public String getPalos() {
		return palos;
	}
	
@Override
 public String toString(){
	 return numeros +" " +palos; 
 }

	public void setPalos(String palos) {
		this.palos = palos;
	}



	public String getNumeros() {
		return numeros;
	}



	public void setNumeros(String numeros) {
		this.numeros = numeros;
	}
	
	
}