package practica2;

public class FormasDeEnvio 
{
	private String TextoDescriptivo;
	private String PlazoDeEntrega;
	private String DescripcionDetallada;
	private double CosteEnvio;
		
	public String getTextoDescriptivo() {
		return TextoDescriptivo;
	}

	public void setTextoDescriptivo(String textoDescriptivo) {
		TextoDescriptivo = textoDescriptivo;
	}

	public String getPlazoDeEntrega() {
		return PlazoDeEntrega;
	}

	public void setPlazoDeEntrega(String plazoDeEntrega) {
		PlazoDeEntrega = plazoDeEntrega;
	}

	public String getDescripcionDetallada() {
		return DescripcionDetallada;
	}

	public void setDescripcionDetallada(String descripcionDetallada) {
		DescripcionDetallada = descripcionDetallada;
	}

	public double getCosteEnvio() {
		return CosteEnvio;
	}

	public void setCosteEnvio(double costeEnvio) {
		CosteEnvio = costeEnvio;
	}

	//Constructor para las distinas formas de Envio disponibles
	public FormasDeEnvio (String TextoDescriptivo) 
	{
		if (TextoDescriptivo.toString() == "Entrega hoy") 
		{
			this.TextoDescriptivo = TextoDescriptivo;
			this.DescripcionDetallada = ("El pedido será entregado hoy mismo.");
			this.PlazoDeEntrega = ("mismo dia");
			this.CosteEnvio = 9.99;

		}
		else if (TextoDescriptivo.toString() == "Envio 1 dia") 
		{
			this.TextoDescriptivo = TextoDescriptivo;
			this.DescripcionDetallada = ("El pedido sera entregado al dia siguiente");
			this.PlazoDeEntrega = ("dia siguiente");
			this.CosteEnvio = 5;

		}
		else if (TextoDescriptivo.toString() == "Envio expres") 
		{
			this.TextoDescriptivo = TextoDescriptivo;
			this.DescripcionDetallada = ("El pedido será entregado en 3 dias laborales");
			this.PlazoDeEntrega = ("3 dias laborales");
			this.CosteEnvio = 3.45;
		}
		else if (TextoDescriptivo.toString() == "Envio estandar") 
		{
			this.TextoDescriptivo = TextoDescriptivo;
			this.DescripcionDetallada = ("El pedido será  en 5 dias laborales, envio gratuito");
			this.PlazoDeEntrega = ("5 dias laborales");
			this.CosteEnvio = 0;

		} 
		else 
		{
			System.out.println("Opcion seleccionada incorrecta\n");
			System.out.println("Seleccione un tipo correcto: Entrega hoy, Envio 1 dia, Envio expres, Envio estandar.\n");
		}
	}
	
	public String toString()
	{
		return TextoDescriptivo + " "+"("+ CosteEnvio+", "+PlazoDeEntrega + ")";
	}
	
}

