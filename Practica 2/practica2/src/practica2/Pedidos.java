package practica2;

import java.util.ArrayList;

public class Pedidos implements IElementoImprimible{

	private int NumeroPedido = 0;
	private String DireccionDeEnvio;
	private MetodosDePago Metododepago;
	private ArrayList<LineaDePedido> pedidoProducto = new ArrayList<LineaDePedido>();
	private FormasDeEnvio envio;
	public Pedidos (int NumeroPedido, String DireccionDeEnvio,ArrayList<LineaDePedido> pedidoProducto,MetodosDePago Metododepago,FormasDeEnvio envio){
		this.setNumeroPedido(NumeroPedido);
		this.setDireccionDeEnvio(DireccionDeEnvio);
		this.setMetododepago(Metododepago);
		this.pedidoProducto = pedidoProducto;
		this.envio = (envio);
	}

	@Override
	//Imprimira el pedido final
	public void imprimir() {
		
		System.out.println("Opción de envío: " + envio);
		System.out.println("Direccion de entrega: "+ DireccionDeEnvio);
		System.out.println("-----------------------------------");
		System.out.println("-- Listado de productos seleccionados");
		System.out.println(String.format("%-5s %-10s %-15s %-10s %-15s %-5s","Linea", "Codigo","Descripcion","Cantidad","Precio neto","Total"));
		for(int i=0; i<pedidoProducto.size(); i++)
		{
		System.out.println(String.format("%-5s %-10s %-15s %-10s %-15s %-5s ",pedidoProducto.get(i).getNumLinea(), pedidoProducto.get(i).getProducto().get(i).getCodigoProducto(),pedidoProducto.get(i).getProducto().get(i).getDescripcionProducto() , pedidoProducto.get(i).getCantidad(),pedidoProducto.get(i).getProducto().get(i).getPrecioSinImpuesto()+" €"  , pedidoProducto.get(i).getProducto().get(i).getPrecioConIva()+" €"  ));
		}
		System.out.println("-----------------------------------");
		System.out.println("Gastos de envio: " +getEnvio().getCosteEnvio()+" €");
	}

	public FormasDeEnvio getEnvio() {
		return envio;
	}

	public void setEnvio(FormasDeEnvio envio) {
		this.envio = envio;
	}

	public String getDireccionDeEnvio() {
		return DireccionDeEnvio;
	}

	public void setDireccionDeEnvio(String direccionDeEnvio) {
		DireccionDeEnvio = direccionDeEnvio;
	}

	public MetodosDePago getMetododepago() {
		return Metododepago;
	}

	public void setMetododepago(MetodosDePago metododepago) {
		Metododepago = metododepago;
	}

	public int getNumeroPedido() {
		return NumeroPedido;
	}

	public void setNumeroPedido(int numeroPedido) {
		NumeroPedido = numeroPedido;
	}
	
	
	
	
}
