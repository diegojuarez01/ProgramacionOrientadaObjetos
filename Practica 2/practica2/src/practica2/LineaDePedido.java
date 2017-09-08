package practica2;

import java.util.ArrayList;

public class LineaDePedido implements IElementoImprimible {

	private int NumLinea;
	private int Cantidad;
	private ArrayList<Productos> producto;
	
	
	
	public LineaDePedido(int NumLinea, int Cantidad,ArrayList<Productos> producto) {
		this.setNumLinea(NumLinea);
		this.setCantidad(Cantidad);
		this.setProducto(producto);
	}
	public int getNumLinea() {
		return NumLinea;
	}
	public void setNumLinea(int numLinea) {
		NumLinea = numLinea;
	}
	public int getCantidad() {
		return Cantidad;
	}
	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}
	public ArrayList<Productos> getProducto() {
		return producto;
	}
	public void setProducto(ArrayList<Productos> carrito) {
		this.producto = carrito;
	}
	
	public String toString()
	{
		return NumLinea + " " + producto + " "+ Cantidad;
	}
	@Override
	public void imprimir() {
	
			System.out.println(NumLinea + " " + producto + " "+ Cantidad); 
		
		
	}
}
