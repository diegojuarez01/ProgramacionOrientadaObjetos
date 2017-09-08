package practica2;

public abstract class Productos  {

	private String CodigoProducto;
	private String DescripcionProducto;
	private Double PrecioSinImpuesto;
	// IVA 21% por defecto
	private static double IVA = 0.21;
	private Double PrecioConIva;
	private int Cantidad;
	//Constructor Productos
	
	Productos(String CodigoProducto,String DescripcionProducto,Double PrecioSinImpuesto,double PrecioConIva,int Cantidad)
	
	{
		this.setCantidad(Cantidad);
		this.setCodigoProducto(CodigoProducto);
		this.setDescripcionProducto(DescripcionProducto);
		this.setPrecioSinImpuesto(PrecioSinImpuesto);
		this.setPrecioConIva((PrecioSinImpuesto * IVA) + PrecioSinImpuesto);
		
	}

	public String getCodigoProducto() {
		return CodigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		CodigoProducto = codigoProducto;
	}

	public String getDescripcionProducto() {
		return DescripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		DescripcionProducto = descripcionProducto;
	}

	public Double getPrecioSinImpuesto() {
		return PrecioSinImpuesto;
	}

	public void setPrecioSinImpuesto(Double precioSinImpuesto) {
		PrecioSinImpuesto = precioSinImpuesto;
	}

	public Double getPrecioConIva() {
		return PrecioConIva;
	}

	public void setPrecioConIva(Double precioConIva) {
		PrecioConIva = precioConIva;
	}

	public int getCantidad() {
		return Cantidad;
	}

	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}
	
	public String toString()
	{
		return String.format("%-10s %-15s %-15s %-10s", CodigoProducto + DescripcionProducto + PrecioSinImpuesto + PrecioConIva);
	}
	
}