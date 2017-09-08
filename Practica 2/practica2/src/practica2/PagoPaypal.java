package practica2;

public class PagoPaypal extends MetodosDePago 
{

	private String CodigoUsuario;
	private String FechaAltaCuenta;
	
	public PagoPaypal(String TextoDescriptivo,String CodigoUsuario,String FechaAltaCuenta) 
	{
		super(TextoDescriptivo);
		this.CodigoUsuario = CodigoUsuario;
		this.FechaAltaCuenta = FechaAltaCuenta;
		
	}

	public String getCodigoUsuario() {
		return CodigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		CodigoUsuario = codigoUsuario;
	}

	public String getFechaAltaCuenta() {
		return FechaAltaCuenta;
	}

	public void setFechaAltaCuenta(String fechaAltaCuenta) {
		FechaAltaCuenta = fechaAltaCuenta;
	}

}
