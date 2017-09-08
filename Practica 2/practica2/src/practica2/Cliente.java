package practica2;


public class Cliente  {

	private String Email;
	private String Nombre;
	private String Apellidos;
	private String Direccion;
	
	//Constructor
	
	public Cliente(String email2, String nombre2, String apellidos2, String direccion2)
	{
		this.Email = email2;
		this.Nombre = nombre2;
		this.Apellidos = apellidos2;
		this.Direccion = direccion2;		 		
	}	
		
		public String getEmail() {
			return Email;
		}
		public void setEmail(String email) {
			Email = email;
		}
				
		public String getNombre() {
			return Nombre;
		}
		public void setNombre(String nombre) {
			Nombre = nombre;
		}
		public String getApellidos() {
			return Apellidos;
		}
		public void setApellidos(String apellidos) {
			Apellidos = apellidos;
		}
		public String getDireccion() {
			return Direccion;
		}
		public void setDireccion(String direccion) {
			Direccion = direccion;
		}
		
		public String toString()
		{
			return Email+ "\t" + Nombre  + "\t"  + Apellidos + "\t\t" +  Direccion;
		}
}

