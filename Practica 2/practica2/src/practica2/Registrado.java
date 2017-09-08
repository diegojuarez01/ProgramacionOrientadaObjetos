package practica2;

import java.util.ArrayList;
import java.util.Scanner;


public class Registrado extends Cliente implements IElementoImprimible  {

//Constructor de la subclase donde incluimos los parametros de la clase superior
public Registrado(String email, String nombre, String apellidos, String direccion,String Password,String FechaNacimiento) 

{
	super(email,nombre,apellidos,direccion);
	this.setPassword(Password);
	this.FechaNacimiento = FechaNacimiento;	
}

	private String Password;
	private String FechaNacimiento;
	//Parte opcional ListaDePedidosRealizados, FormasDePago,DireccionesDeEnvios
	private ArrayList<Pedidos> ListaDePedidosRealizados = new ArrayList<Pedidos>();
	private ArrayList<MetodosDePago> FormasDePago = new ArrayList <MetodosDePago>();
	private ArrayList<String> DireccionesDeEnvios = new ArrayList<String>();
	Scanner scanIn2 = new Scanner(System.in);
	
	//Cliente cliente1 = new Cliente (Email, Nombre, Apellidos, Direccion, tipoUsuario);

public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public String getFechaNacimiento() {
	return FechaNacimiento;
}
public void setFechaNacimiento(String fechaNacimiento) {
	FechaNacimiento = fechaNacimiento;
}

public void imprimir() {
	System.out.println(String.format("%-25s %-10s %-15s %-15s %-20s", "Email","Nombre","Apellidos","Direccion","Password","FechaNacimiento"));
	
		}
	
			
	


}



	
