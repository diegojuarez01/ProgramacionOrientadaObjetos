package practica2;

public abstract class MetodosDePago{

	private String TextoDescriptivo;
	
	public MetodosDePago(String TextoDescriptivo)
	{
		this.setTextoDescriptivo(TextoDescriptivo);
	}
	
	public String getTextoDescriptivo() {
		return TextoDescriptivo;
	}
	public void setTextoDescriptivo(String TextoDescriptivo) {
		this.TextoDescriptivo = TextoDescriptivo;
	}

	
	
}


