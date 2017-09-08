package practica2;

public class DiscosDeMusica extends Productos implements IElementoImprimible{

	
	private String nombreArtista;
	private String genero;
		
	DiscosDeMusica(String CodigoProducto, String DescripcionProducto, Double PrecioSinImpuesto,
			double PrecioConIva,String nombreArtista,String genero,int Cantidad) 
		{
		super(CodigoProducto, DescripcionProducto, PrecioSinImpuesto, PrecioConIva,Cantidad);
		this.setNombreArtista(nombreArtista);
		
		if (genero.toString() == "Infantil")
		{
			this.setGenero(genero);
		}
		else if(genero.toString() == "Pop")
		{
			this.setGenero(genero);
		}
		else if(genero.toString() == "Rock")
		{
			this.setGenero(genero);
		}
		else if(genero.toString() == "Dance")
		{
			this.setGenero(genero);
		}
		else
		{
			System.out.println("Opcion seleccionada incorrecta\n");
			System.out.println("Seleccione un genero correcto: Infantil,Pop, Rock, Dance.\n");
		}
		
		
		
	}

	public String getNombreArtista() {
		return nombreArtista;
	}

	public void setNombreArtista(String nombreArtista) {
		this.nombreArtista = nombreArtista;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public void imprimir() {
		
			System.out.println(String.format("%-5s %-10s %-15s %-15s %-20s %-20s %-20s ","Linea", "Codigo","Descripcion","Precio neto","Total","Nombre Del Artista","Genero"));
		
	}

}
