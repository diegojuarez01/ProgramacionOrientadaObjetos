package practica2;

public class TarjetaDeCredito extends MetodosDePago
{

	private String TipoDeTarjeta;
	private String Numero;
	private String FechaDecaducidad;
	private int CVC;
	private String TitularCuenta;
	
	
	public TarjetaDeCredito(String TextoDescriptivo,String TipoDeTarjeta,String Numero,String FechaDeCaducidad,int CVC,String TitularCuenta) 
	{
		super(TextoDescriptivo);
		this.Numero = Numero;
		this.FechaDecaducidad = FechaDeCaducidad;
		this.CVC = CVC;
		this.setTitularCuenta(TitularCuenta);
		
		if(TipoDeTarjeta.toString() == "VISA")
		{
			this.setTipoDeTarjeta(TipoDeTarjeta);
		}
		else if(TipoDeTarjeta.toString() == "4B")
		{
			this.setTipoDeTarjeta(TipoDeTarjeta);
		}
		else if(TipoDeTarjeta.toString() == "Euro6000")
		{
			this.setTipoDeTarjeta(TipoDeTarjeta);
		}
		else if(TipoDeTarjeta.toString() == "American Express")
		{
			this.setTipoDeTarjeta(TipoDeTarjeta);
		}
		else
		{
			System.out.println("Opcion seleccionada incorrecta\n");
			System.out.println("Seleccione un tipo de tarjeta correcto: VISA, 4B, Euro6000, American Express.\n");
		}
	}


	public String getTipoDeTarjeta() {
		return TipoDeTarjeta;
	}


	public void setTipoDeTarjeta(String tipoDeTarjeta) {
		TipoDeTarjeta = tipoDeTarjeta;
	}


	public String getTitularCuenta() {
		return TitularCuenta;
	}


	public void setTitularCuenta(String titularCuenta) {
		TitularCuenta = titularCuenta;
	}

}
