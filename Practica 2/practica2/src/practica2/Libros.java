package practica2;

public class Libros extends Productos implements IElementoImprimible
{
	private String CodigoISBN;
	private String Titulo;
	private String Editorial;
	private static double IVA= 0.1;
	
	Libros(String CodigoProducto, String DescripcionProducto, Double PrecioSinImpuesto,double PrecioConIva,String CodigoISBN,String Titulo,String Editorial,int Cantidad) 
	{
		super(CodigoProducto, DescripcionProducto, PrecioSinImpuesto, PrecioConIva,Cantidad);
		// TODO Auto-generated constructor stub
		this.setCodigoISBN(CodigoISBN);
		this.setTitulo(Titulo);
		this.Editorial = Editorial;
		
	}

	@Override
	public void imprimir() {
		
		System.out.println(String.format("%-5s %-10s %-15s %-15s %-20s %-25s %-15s ","Linea", "Codigo","Descripcion","Precio neto","Total","CodigoISBN","Titulo"));
	
}

	public String getCodigoISBN() {
		return CodigoISBN;
	}

	public void setCodigoISBN(String codigoISBN) {
		CodigoISBN = codigoISBN;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}


}
