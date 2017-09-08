package practica2;

import java.util.ArrayList;

public class Alimentacion extends Productos implements IElementoImprimible
{

	private String FechaCaducidad;
	private static double IVA= 0.04;
	
	Alimentacion(String CodigoProducto, String DescripcionProducto, Double PrecioSinImpuesto,
			double PrecioConIva,String FechaCaducidad,int Cantidad) 
	{
		super(CodigoProducto, DescripcionProducto, PrecioSinImpuesto,PrecioConIva,Cantidad);
		this.FechaCaducidad = FechaCaducidad;
		//Para alimentacion utilizaremos IVA del 4%
		
		
	}

	

	@Override
	public void imprimir() {
		System.out.println(String.format("%-5s %-10s %-15s %-15s %-10s ","Linea", "Codigo","Descripcion","Precio neto","Total"));
		}
	
	public String toString()
	{
		return String.format("%-10s %-15s %-15s %-10s", getCodigoProducto() , getDescripcionProducto() , getPrecioSinImpuesto() , getPrecioConIva());
	}
	
}	
