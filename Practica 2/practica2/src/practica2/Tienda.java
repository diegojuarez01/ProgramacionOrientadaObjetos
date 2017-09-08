package practica2;
import java.util.ArrayList;
import java.util.Scanner;

public class Tienda implements IElementoImprimible {
	
	// Scann para Strings
	Scanner scanIn = new Scanner(System.in);
	// Scann para int
	Scanner Menu = new Scanner(System.in);
	private String opcionesMenu;
	private int opcionesMenu2;
	private ArrayList<Productos> Carrito = new ArrayList<Productos>();
	private static ArrayList<Registrado> ArrayRegistrado = new ArrayList<Registrado>();
	private static ArrayList<Libros> ArrayLibros = new ArrayList<Libros>();
	private static ArrayList<DiscosDeMusica> ArrayDiscosDeMusica = new ArrayList <DiscosDeMusica>();
	private static ArrayList<Alimentacion> ArrayAlimento = new ArrayList<Alimentacion>();
	//Para los usuarios que estan registrados
	private Registrado autentificado = new Registrado("","","","","","");
	// Para crear un nuevo usuario registrado, primero creamos un nuevo objeto registrado con valores nulos y vamos asignando los valores conforme los introduzca el usuario por pantalla
	private Registrado registrado2 = new Registrado("","","","","","");
	//Para los usuarios invitados que completaron sus datos al final
	private Cliente clienteFinal = new Cliente("","","","");
	private String tipoUsuario;
	private ArrayList<LineaDePedido> ListaDeCarrito = new ArrayList<LineaDePedido>();
	//Creamos el pedido que luego modificaremos segun los datos introducidos del usuario al formalizar la compra
	private Pedidos pedido = new Pedidos(123, "",ListaDeCarrito,null,null);
	//Creamos un objeto de la clase tarjetaDeCredito por si seleccionamos esta opcion de pago	
	private TarjetaDeCredito tarjeta = new TarjetaDeCredito ("Tarjeta de Credito","VISA", "0000 0000 0000 0000", "01/20", 345,"Pepico");
	// Creamos un objeto de la clase PagoPaypal por si elegimos la opcion paypal  
	private PagoPaypal paypal = new PagoPaypal("Cuenta paypal","Pepico","12/12/1940");
	private int x=0;
	//Para calcular el importe total de la compra
	private Double ImporteTotal = 0.0;
	//Para calcular el precio neto de los productos
	private Double PrecioNeto = 0.0;
	//Metodo al que se llamara desde el main e iniciara los metodos
	public void IniciarTienda()
	
	{
		//Carga los datos de los usuarios registrados 
		obtenerRegistrados();
		//Carga los datos de los DiscosDeMusica
		obtenerDiscoDeMusica();
		//Carga los datos de los alimentos
		obtenerAlimentos();
		//Carga los datos de los libros
		obtenerLibros();
		//Metodo que mostrara la cabecera
		MostrarCabecera();
		//Metodo que solicitara el tipo de usuario
		SolicitarTipousuario();
		//Metodo dependiendo del tipo de usuario ejecutara diferentes codigos
		TipoDeUsuario();
		 
	}
	
private  void MostrarCabecera()

	{
		System.out.println("/*********************************************/");
		System.out.println("/********** TIENDA VIRTUAL POO ***************/");
		System.out.println("/*********************************************/");
		System.out.println("-----------------------------------");
	}

//Metodo para solicitar el tipo de usuario (Registrado o invitado) o si damos de alta un nuevo usuario (Creara un nuevo usuario registrado)	
private void SolicitarTipousuario()
{

	System.out.println("(R) Usuario registrado ");
	System.out.println("(A) Alta de usuario ");
	System.out.println("(I) Entrar como invitado ");
	System.out.println("(S) Salir del programa ");
	System.out.println("-----------------------------------");
	System.out.println("Seleccione una opcion: ");
	
	//Almacenamos el string introducido por el usuario en la variable TipoUsuario
	setTipoUsuario(scanIn.nextLine());
	getTipoUsuario();
}
private void TipoDeUsuario(){
	switch(getTipoUsuario())
	
	{
	case "A":
	case "a":
		
		System.out.println("Introduzca su nombre: ");
		registrado2.setNombre(scanIn.nextLine());
		System.out.println("Nombre: "+registrado2.getNombre());
		System.out.println("Introduzca sus apellidos: ");
		registrado2.setApellidos(scanIn.nextLine());
		System.out.println("Apellidos: "+registrado2.getApellidos());
		System.out.println("Introduzca su email: ");
		registrado2.setEmail(scanIn.nextLine());
		System.out.println("email: "+registrado2.getEmail());
		System.out.println("Introduzca su contraseña: ");
		registrado2.setPassword(scanIn.nextLine());
		System.out.println("Password: "+registrado2.getPassword());
		//Mostrara un mensaje de bienvenida con los valores introducidos por el usuario previamente(nombre y apellido)
		System.out.println("-----------------------------------");
		System.out.println("Bienvenido de nuevo: " + registrado2.getNombre() +" - "  +registrado2.getApellidos());
		System.out.println("-----------------------------------");
		MostrarMenu();
		break;
		
	case "s":
	case "S":
		//Caso para salir del programa cuando el usuario introduzca s o S
		System.out.println("Ha seleccionada la opción: (S) Salir del programa");
		System.out.println("El programa se cerrara automaticamente.");
		System.exit(0);
		
	case "i":
	case "I":
				MostrarMenu();
				break;
	case "R":
	case "r":
		//Para iniciar sesion con un usuario registrado previamente para ello tenemos que acceder a los usuarios registrados que tenemos creados previamente.
		imprimir();
		System.out.println("\nIntroduzca su email: ");
		autentificado.setEmail(scanIn.nextLine());
		System.out.println("Mostrar email: " + autentificado.getEmail());
		//Comprobamos si el Email introducido esta dentro de nuestra base de datos creada, si es asi continua pidiendo la password sino vuelve a pedir el email
		for(int i=0; i<ArrayRegistrado.size(); i++)
		{
			if(ArrayRegistrado.get(i).getEmail().equals(autentificado.getEmail())){
				System.out.println("Introduzca su password: ");						
				autentificado.setPassword(scanIn.nextLine());
				
				if(ArrayRegistrado.get(i).getPassword().equals(autentificado.getPassword()))
				{
					System.out.println("-----------------------------------");
					System.out.println("Bienvenido de nuevo: " + ArrayRegistrado.get(i).getNombre() +" - "  +ArrayRegistrado.get(i).getApellidos());
					System.out.println("-----------------------------------");
					//Le asignamos los valores a nuestro usuario autentificado 
					autentificado.setNombre(ArrayRegistrado.get(i).getNombre());
					autentificado.setApellidos(ArrayRegistrado.get(i).getApellidos());
					autentificado.setDireccion(ArrayRegistrado.get(i).getDireccion());
					autentificado.setFechaNacimiento(ArrayRegistrado.get(i).getFechaNacimiento());
					//Inciamos el metodo Mostrar menu ya que hemos autentificado al usuario.
					MostrarMenu();
					//Finalizamos la ejecucion del metodo y seguimos con MostrarMenu
					return;
				}
				else {
					//Si la clave introducida no es la correcta para el email introducido se muestra un mensaje de error y se vuelve al inicio del metodo
					System.out.println("Contraseña incorrecta, vuelva a introducir los datos");
					TipoDeUsuario();
					break;
				}
			}	
		}
		//Si no hemos encontrado un usuario registrado con los datos introducidos por el usuario volvemos al inicio del metodo, ya que puede que el usuario se haya equivocado introduciendo algun dato.
		System.out.println("El email que ha introducido no corresponde con ningun usuario registrado...");
		System.out.println("Vuelva a introducir los datos");
		TipoDeUsuario();	
		}	
}

private void MostrarMenu()
{
	System.out.println("(L) Listar productos seleccionados: ");
	System.out.println("(B) Buscar producto: ");
	System.out.println("(S) Salir: Saldra del programa ");
	System.out.println("-----------------------------------");
	System.out.println("Seleccione una opcion: ");
	
	opcionesMenu=(scanIn.nextLine());
	
	switch(opcionesMenu)
	{
	case "L":
	case "l":
		System.out.println("-----------------------------------");
		System.out.println("-- Listado de productos de seleccionados");
		System.out.println("-----------------------------------");
		//Muestra los elementos del carrito
		System.out.println(String.format("%-5s %-10s %-15s %-10s %-15s %-5s","Linea", "Codigo","Descripcion","Cantidad","Precio neto","Total"));
		
		// Si el carrito esta vacio muestra directamente el menu, si hay algo en el carrito se mostrara el carrito
		if (ListaDeCarrito.isEmpty()){
			System.out.println("-----------------------------------");
			System.out.println("Su carrito esta vacio");
			System.out.println("-----------------------------------");
			MostrarMenu2();
		}
		//Si el carrito no esta vacio se mostrara sus elementos
		else{
			//Queremos calcular el importe total, primero Lo ponemos nulo por si se vuelve a comprobar 
			ImporteTotal=0.0;
			PrecioNeto = 0.0;
		for(int i=0; i<ListaDeCarrito.size(); i++)
		{
			//Imprime el Array ListaDeCarrito que contiene todos los productos añadidos al carrito junto con la cantidad
			System.out.println(String.format("%-5s %-10s %-15s %-10s %-15s %-5s ",ListaDeCarrito.get(i).getNumLinea(), ListaDeCarrito.get(i).getProducto().get(i).getCodigoProducto(),ListaDeCarrito.get(i).getProducto().get(i).getDescripcionProducto() , ListaDeCarrito.get(i).getCantidad(),ListaDeCarrito.get(i).getProducto().get(i).getPrecioSinImpuesto()+" €"  , ListaDeCarrito.get(i).getProducto().get(i).getPrecioConIva()+" €"  ));
			//Se hace la suma al Importe del bucle previo + el precio del ultimo multiplicandolo por la cantidad de productos
			ImporteTotal= ImporteTotal +ListaDeCarrito.get(i).getProducto().get(i).getPrecioConIva() * ListaDeCarrito.get(i).getCantidad();
			PrecioNeto = PrecioNeto + ListaDeCarrito.get(i).getProducto().get(i).getPrecioSinImpuesto() * ListaDeCarrito.get(i).getCantidad();
		}
		
		System.out.println("-----------------------------------");
		System.out.println("IMPORTE TOTAL: " + ImporteTotal + " €");
		System.out.println("-----------------------------------");
		//Metodo que mostrar el siguiente menu debajo del array donde tenemos los productos de nuestro carrito
		MostrarMenu2();
		}
		break;
	case "B":
	case "b":
		//Llamada al metodo que mostrara los distintos productos de la tienda
				MostrarProductos();
				break;
	case "S":
	case "s":
		//Cerramos el programa
		System.out.println("Ha seleccionada la opción: (S) Salir del programa");
		System.out.println("El programa se cerrara automaticamente.");
		System.exit(0);		
	}

}

private void MostrarMenu2()
{
	System.out.println("Acciones: ");
	System.out.println("(F) Formalizar compra");
	System.out.println("(R) Vaciar los productos seleccionados");
	System.out.println("(V) Volver al menu anterior");
	System.out.println("Seleccione una opcion: ");
	opcionesMenu= scanIn.nextLine();
	
	switch(opcionesMenu)
	
	{
	// Caso para volver al menu anterior
	case "V":
	case "v":
		//Llamada al metodo MostrarMenu(); que nos manda al menu anterior
		MostrarMenu();
		break;
		
	case "F":
	case "f":
		//Para cuando el usuario ha elegido la opcion de invitado, llegado a este punto le pedira unos datos como nombre apellidos...
		if (getTipoUsuario().toUpperCase().contentEquals("I"))
		{
			
			System.out.println("Introduzca su nombre: ");
			clienteFinal.setNombre(scanIn.nextLine());
			System.out.println("Introduzca sus apellidos: ");
			clienteFinal.setApellidos(scanIn.nextLine());
			System.out.println("Introduzca su email: ");
			clienteFinal.setEmail(scanIn.nextLine());
			System.out.println("Introduzca su direccion: ");
			clienteFinal.setDireccion(scanIn.nextLine());
		}
		
		//Mostramos al usuario los pasos que va a seguir para terminar con la compra
		System.out.println("\n-----------------------------------");
		System.out.println("A continuación le guiaremos en el proceso de compra del pedido,\npara ello pasará por los siguientes pasos:");
		System.out.println("\nPaso1. Opción de envío ");
		System.out.println("Paso2. Dirección de envío ");
		System.out.println("Paso3. Forma de pago ");
		System.out.println("Paso4. Resumen y confirmación ");
		System.out.println("-----------------------------------");
		System.out.println("Paso1. Opción de envío: \n");
		//Opciones de envio, el usuario tendra que elegir una de ellas.
		System.out.println("(1) Entrega hoy (9,99€, mismo día)");
		System.out.println("(2) Envío 1 día (5€, al día siguiente)");
		System.out.println("(3) Envío exprés (3,45€, 3 días laborales)");
		System.out.println("(4) Envío estándar (gratis, 5 días laborales)");
		System.out.println("(V) Volver al menu anterior");
		opcionesMenu = Menu.next();
		
		switch(opcionesMenu)
		{
		case "1":
			// Si el usuario elije el "1" crearemos un objeto FormasDeEnvio con texto descriptivo "Entrega hoy" que le otorgara todos los valores restantes que tenemos asignados en el constructor de FormasDeEnvio
			FormasDeEnvio forma1 = new FormasDeEnvio("Entrega hoy");
			pedido.setEnvio(forma1);
			//Llamada al metodo DireccionDeEnvio que ejecuta el paso 2
			DireccionDeEnvio();
			//Llamada al metodo FormaDePago que ejecuta el paso 3
			FormaDePago();
			//Llamada al metodo ResumenYConfirmacion que ejecuta el paso 4
			ResumenYConfirmacion();
			break;
			
		case "2":
			// Si el usuario elije el "2" crearemos un objeto FormasDeEnvio con texto descriptivo "Envio 1 dia" que le otorgara todos los valores restantes que tenemos asignados en el constructor de FormasDeEnvio
			FormasDeEnvio forma2 = new FormasDeEnvio("Envio 1 dia");
			pedido.setEnvio(forma2);
			//Llamada al metodo DireccionDeEnvio que ejecuta el paso 2
			DireccionDeEnvio();
			//Llamada al metodo FormaDePago que ejecuta el paso 3
			FormaDePago();
			//Llamada al metodo ResumenYConfirmacion que ejecuta el paso 4
			ResumenYConfirmacion();
			break;
			
		case "3":
			// Si el usuario elije el "3" crearemos un objeto FormasDeEnvio con texto descriptivo "Envio expres" que le otorgara todos los valores restantes que tenemos asignados en el constructor de FormasDeEnvio
			FormasDeEnvio forma3 = new FormasDeEnvio("Envio expres");
			pedido.setEnvio(forma3);
			//Llamada al metodo DireccionDeEnvio que ejecuta el paso 2
			DireccionDeEnvio();
			//Llamada al metodo FormaDePago que ejecuta el paso 3
			FormaDePago();
			//Llamada al metodo ResumenYConfirmacion que ejecuta el paso 4
			ResumenYConfirmacion();
			break;
			
		case "4":	
			// Si el usuario elije el "4" crearemos un objeto FormasDeEnvio con texto descriptivo "Envio estandar" que le otorgara todos los valores restantes que tenemos asignados en el constructor de FormasDeEnvio
			FormasDeEnvio forma4 = new FormasDeEnvio("Envio estandar");
			pedido.setEnvio(forma4);
			//Llamada al metodo DireccionDeEnvio que ejecuta el paso 2
			DireccionDeEnvio();
			//Llamada al metodo FormaDePago que ejecuta el paso 3
			FormaDePago();
			//Llamada al metodo ResumenYConfirmacion que ejecuta el paso 4
			ResumenYConfirmacion();
			break;
			
		case "v":
		case "V":
			//Llamada al metodo MostrarMenu2(); que nos mandara el menu anterior
			MostrarMenu2();
			break;	
		}
		
		break;
		
	case "R":
	case "r":
		//Vacia el Array carrito donde tenemos almacenados todos los productos seleccionados y vuelve al menu anterior
		ListaDeCarrito.clear();
		Carrito.clear();
		//Volvemos a poner el valor de x en 0
		x=0; 
		MostrarMenu();	
		break;
	}	
}
//Metodo que mostrara un menu con las diferentes categorias que tenemos en la tienda
private void MostrarProductos()
{
	System.out.println("-----------------------------------");
	System.out.println("--Listado de categorias");
	System.out.println("-----------------------------------");
	System.out.println("(A) Alimentacion");
	System.out.println("(L) Libros");
	System.out.println("(D) Discos");
	System.out.println("(V) Volver al menu principal");
	System.out.println("-----------------------------------");
	System.out.println("Seleccione una opcion: ");
	opcionesMenu= scanIn.nextLine();
	
	switch(opcionesMenu){
	
	// caso para alimentacion
	case "A":
	case "a":
		
		Alimentacion alimento = new Alimentacion(null, null, 0.0, 0, null,1);
		System.out.println("-----------------------------------");
		System.out.println("--Productos de Alimentacion");
		System.out.println("-----------------------------------");
		alimento.imprimir();
		//Bucle que recorre todo el array y lo muestra.
		for(int i=0; i<ArrayAlimento.size(); i++){
			System.out.println(String.format("%-5s %-10s %-15s %-15s %-20s", i+1,ArrayAlimento.get(i).getCodigoProducto(),ArrayAlimento.get(i).getDescripcionProducto(),ArrayAlimento.get(i).getPrecioSinImpuesto(),ArrayAlimento.get(i).getPrecioConIva()));
	}
		System.out.println("Acciones:");
		System.out.println("\t(A) Agregar productos al carrito");
		System.out.println("\t(V) Volver al menu anterior");
		System.out.println("Seleccione una opcion: ");
		opcionesMenu= scanIn.nextLine();
		switch(opcionesMenu)
		{
		
		// Caso para agregar un Alimento al carrito crearemos un arrayList<Productos> donde meteremos cualquier Alimento que seleccionemos ademas de la cantidad
		case "A":
		case "a":
			//Se repetira este bucle mientras el usuario pulse "s" o "S" cuando le preguntemos si quiere añadir otro producto
			do{
			System.out.println("Seleccione la linea del pedido: ");
			opcionesMenu2= Menu.nextInt();
			for(int i=0; i<ArrayAlimento.size(); i++)
				{
					//Para la linea que hayamos seleccionado anteriormente por pantalla
					if (opcionesMenu2==i+1)
					{
						//Añadimos al Array Carrito el elemento en la posicion i
						Carrito.add(ArrayAlimento.get(i));
					
					}
				}
			System.out.println("Cuantas unidades desea: ");
			opcionesMenu2= Menu.nextInt();
			
			//Le asignara valores a el array ListaDeCarrito dependiendo de los productos añadidos					
			ListaDeCarrito.add(new LineaDePedido(0,0,Carrito));
			//Asigna el valor introducido previamente a la cantidad en el array ListaDeCarrito
			ListaDeCarrito.get(x).setCantidad(opcionesMenu2);
			// Dara el valor de x a la linea empezando por 1 e ira sumando 1 cada vez que se añada un producto
			ListaDeCarrito.get(x).setNumLinea(x+1);
			x++;
			//Preguntamos si quiere añadir otro producto al array 
			System.out.println("¿Desea agregar otro producto? (S/N): ");
			opcionesMenu = Menu.nextLine();
			}
			//Mientras que el usuario elija la opcion s o S seguira ejecutandose el codigo
			while(Menu.nextLine().toUpperCase().contentEquals("S"));
			//volvera a el menu anterior cuando no se cumpla, es decir cuando el usuario no quiera seguir agregando productos. 
			MostrarProductos();
				break;
				
			//Caso para volver al menu anterior	
		case "V":
		case "v":
			//Llamada al metodo MostrarProductos(); para volver al menu anterior
				MostrarProductos();
		}
		break;
		
	case "L":
	case "l":	
		
		Libros libro = new Libros("", "", 0.0, 0.0, "","" ,"", 0);
		System.out.println("-----------------------------------");
		System.out.println("--Productos de Libros");
		System.out.println("-----------------------------------");
		//Imprimir formato 
		libro.imprimir();
		//Bucle que recorre todo el array y lo muestra.
		for(int i=0; i<ArrayLibros.size(); i++){
			System.out.println(String.format("%-5s %-10s %-15s %-15s %-20s %-25s %-15s", i+1,ArrayLibros.get(i).getCodigoProducto(),ArrayLibros.get(i).getDescripcionProducto(),ArrayLibros.get(i).getPrecioSinImpuesto(),ArrayLibros.get(i).getPrecioConIva(),ArrayLibros.get(i).getCodigoISBN(),ArrayLibros.get(i).getTitulo()));
	}
		System.out.println("Acciones:");
		System.out.println("\t(A) Agregar productos al carrito");
		System.out.println("\t(V) Volver al menu anterior");
		System.out.println("Seleccione una opcion: ");
		opcionesMenu= scanIn.nextLine();
		switch(opcionesMenu)
		{
		
		// Caso para agregar un Libro al carrito crearemos un arrayList<Productos> donde meteremos cualquier libro que seleccionemos ademas de la cantidad
		case "A":
		case "a":
		//Se repetira este bucle mientras el usuario pulse "s" o "S" cuando le preguntemos si quiere añadir otro producto
		do{
		System.out.println("Seleccione la linea del pedido: ");
		opcionesMenu2= Menu.nextInt();
		for(int i=0; i<ArrayLibros.size(); i++)
			{
				//Para la linea que hayamos seleccionado anteriormente por pantalla
				if (opcionesMenu2==i+1)
				{
					//Añadimos al Array Carrito el elemento en la posicion i
					Carrito.add(ArrayLibros.get(i));
				
				}
			}
		System.out.println("Cuantas unidades desea: ");
		opcionesMenu2= Menu.nextInt();
		
		//Le asignara valores a el array ListaDeCarrito dependiendo de los productos añadidos					
		ListaDeCarrito.add(new LineaDePedido(0,0,Carrito));
		//Asigna el valor introducido previamente a la cantidad en el array ListaDeCarrito
		ListaDeCarrito.get(x).setCantidad(opcionesMenu2);
		// Dara el valor de x a la linea empezando por 1 e ira sumando 1 cada vez que se añada un producto
		ListaDeCarrito.get(x).setNumLinea(x+1);
		x++;
		//Preguntamos si quiere añadir otro producto al array 
		System.out.println("¿Desea agregar otro producto? (S/N): ");
		opcionesMenu = Menu.nextLine();
		}
		//Mientras que el usuario elija la opcion s o S seguira ejecutandose el codigo
		while(Menu.nextLine().toUpperCase().contentEquals("S"));
		//volvera a el menu anterior cuando no se cumpla, es decir cuando el usuario no quiera seguir agregando productos. 
		MostrarProductos();
		break;
		case "v":
		case "V":
			MostrarProductos();
			break;
		}
		break;
		
	case "D":
	case "d":
		
		DiscosDeMusica disco = new DiscosDeMusica("", "", 0.0, 0.0, "", "", 0);
		System.out.println("-----------------------------------");
		System.out.println("--Productos de Discos De Musica");
		System.out.println("-----------------------------------");
		//Imprimir formato 
		disco.imprimir();
		//Bucle que recorre todo el array y lo muestra.
		for(int i=0; i<ArrayDiscosDeMusica.size(); i++){
			System.out.println(String.format("%-5s %-10s %-15s %-15s %-20s %-20s %-20s", i+1,ArrayDiscosDeMusica.get(i).getCodigoProducto(),ArrayDiscosDeMusica.get(i).getDescripcionProducto(),ArrayDiscosDeMusica.get(i).getPrecioSinImpuesto(),ArrayDiscosDeMusica.get(i).getPrecioConIva(),ArrayDiscosDeMusica.get(i).getNombreArtista(),ArrayDiscosDeMusica.get(i).getGenero()));
	}
		System.out.println("Acciones:");
		System.out.println("\t(A) Agregar productos al carrito");
		System.out.println("\t(V) Volver al menu anterior");
		System.out.println("Seleccione una opcion: ");
		opcionesMenu= scanIn.nextLine();
		switch(opcionesMenu)
		{
		
		// Caso para agregar un disco al carrito crearemos un arrayList<Productos>(Carrito) donde meteremos cualquier disco que seleccionemos ademas de la cantidad
		case "A":
		case "a":
		//Se repetira este bucle mientras el usuario pulse "s" o "S" cuando le preguntemos si quiere añadir otro producto
		do{
		System.out.println("Seleccione la linea del pedido: ");
		opcionesMenu2= Menu.nextInt();
		for(int i=0; i<ArrayDiscosDeMusica.size(); i++)
			{
				//Para la linea que hayamos seleccionado anteriormente por pantalla
				if (opcionesMenu2==i+1)
				{
					//Añadimos al Array Carrito el elemento en la posicion i
					Carrito.add(ArrayDiscosDeMusica.get(i));
				
				}
			}
		System.out.println("Cuantas unidades desea: ");
		opcionesMenu2= Menu.nextInt();
		
		//Le asignara valores a el array ListaDeCarrito dependiendo de los productos añadidos					
		ListaDeCarrito.add(new LineaDePedido(0,0,Carrito));
		//Asigna el valor introducido previamente a la cantidad en el array ListaDeCarrito
		ListaDeCarrito.get(x).setCantidad(opcionesMenu2);
		// Dara el valor de x a la linea empezando por 1 e ira sumando 1 cada vez que se añada un producto
		ListaDeCarrito.get(x).setNumLinea(x+1);
		x++;
		//Preguntamos si quiere añadir otro producto al array 
		System.out.println("¿Desea agregar otro producto? (S/N): ");
		opcionesMenu = Menu.nextLine();
		}
		//Mientras que el usuario elija la opcion s o S seguira ejecutandose el codigo
		while(Menu.nextLine().toUpperCase().contentEquals("S"));
		//volvera a el menu anterior cuando no se cumpla, es decir cuando el usuario no quiera seguir agregando productos. 
		MostrarProductos();
		//Caso para volver al menu anterior	
		case "V":
		case "v":
			//Llamada al metodo MostrarProductos(); para volver al menu anterior
				MostrarProductos();
				break;
		}
		break;
		
	case "V":
	case "v":
		//llamada al metodo para ir al menu anterior
		MostrarMenu();
		break;
		
}
}
//Metodo para el paso 4 del pedido
private void ResumenYConfirmacion()
{
	System.out.println("-----------------------------------");
	System.out.println("Paso 1 >> Paso2 >> Paso3 >> Paso4. Resumen y confirmación");
	System.out.println("-----------------------------------");
	System.out.println("NUMERO DE PEDIDO: "+ pedido.getNumeroPedido());
	//Dependiendo del tipo usuario llamaremos a un objeto distinto
	if (getTipoUsuario().toUpperCase().contentEquals("R"))
	{
	System.out.println("Usuario: "+autentificado.getNombre() + " "+autentificado.getApellidos());
	
	}
	else if (getTipoUsuario().toUpperCase().contentEquals("A"))
	{
		System.out.println("Usuario: "+registrado2.getNombre() + " "+registrado2.getApellidos());	
	}
	else if(getTipoUsuario().toUpperCase().contentEquals("I"))
	{
		System.out.println("Usuario: "+clienteFinal.getNombre() + " "+clienteFinal.getApellidos());
	}
	System.out.println("-----------------------------------");
	//Imprimira el pedido final
	pedido.imprimir();
	System.out.println("Importe neto total: "+PrecioNeto + " €");
	System.out.println("IMPORTE TOTAL SIN GASTOS DE ENVIO :"+ImporteTotal + " €");
	// Le sumamos al importe total el gasto de envio y lo imprimimos por pantalla
	System.out.println("IMPORTE TOTAL GASTOS DE ENVIO INCLUIDO:"+(ImporteTotal+pedido.getEnvio().getCosteEnvio()) + " €");
	
	System.out.println("-----------------------------------");
	System.out.println("Paso4. Resumen y confirmación:\n");
	System.out.println("(R) Realizar pedido");
	System.out.println("(D) Descartar pedido");
	System.out.println("(V) Volver al menú anterior.");
	System.out.println("\nSeleccione una opcion: ");
	opcionesMenu= scanIn.nextLine();
	//Para cuando el usuario quiera terminar el pedido
	if (opcionesMenu.toUpperCase().contentEquals("R"))
	{
		System.out.println("\nPEDIDO REALIZADO CORRECTAMENTE, ESPERAMOS VERLE PRONTO EN");
		System.out.println("NUESTRA TIENDA ");
	}
	//Para cuando el usuario quiere descartar el pedido
	else if(opcionesMenu.toUpperCase().contentEquals("D"))
	{
		//Para volver a poner los valores por defecto al pedido
		pedido = new Pedidos(123, "",ListaDeCarrito,null,null);
		//Nos manda al menu de nuevo
		MostrarMenu2();
	}
	//Para volver al menu principal
	else if (opcionesMenu.toUpperCase().contentEquals("V"))
	{
		//Nos manda el menu anterior(paso e)
		FormaDePago();
		//Vuelve a ejecutar este bloque una vez termine con el paso anterior
		ResumenYConfirmacion();
	}
	
}
//Metodo para el paso 3 del pedido
private void FormaDePago()
{
	System.out.println("-----------------------------------");
	System.out.println("Paso 1 >> Paso2 >> Paso3. Forma de pago");
	System.out.println("-----------------------------------\n");
	System.out.println("(P) Paypal");
	System.out.println("(T) Tarjeta de credito");
	System.out.println("(V) Volver al menu anterior.");
	System.out.println("Seleccione una opcion: ");
	opcionesMenu = scanIn.nextLine();
	switch(opcionesMenu)
	{
	// Caso para cuando el usuario elije de metodo de pago Paypal
	case "P":
	case "p":
		// Introducimos el metodo elegido en el pedido
		pedido.setMetododepago(paypal);
		//Usuario creado por defecto para probar, sera para todos el mismo
		System.out.println("Usuario Paypal: "+paypal.getCodigoUsuario());
		System.out.println("Fecha de alta: "+paypal.getFechaAltaCuenta());
		break;
		
	//Caso para cuando el usuario elije el metodo de pago tarjetadecredito					
	case "T":
	case "t":
		// Introducimos el metodo elegido en el pedido
		pedido.setMetododepago(tarjeta);
		System.out.println("Tipos de tarjeta disponibles: VISA, 4B, Euro600 o American Express ");
		System.out.println("Opcion seleccionada: " +tarjeta.getTipoDeTarjeta());
		System.out.println("Titular de la cuenta: "+tarjeta.getTitularCuenta());
		break;
		
	case "V":
	case "v":
	//Llamada al metodo DireccionDeEnvio(); que nos mandara al paso anterior
	DireccionDeEnvio();
	//Llamada a la forma de pago para que se vuelva a ejecutar
	FormaDePago();
	break;
	}
}
//Metodo para el paso 2 del pedido
private void DireccionDeEnvio()
{
	System.out.println("-----------------------------------");
	System.out.println("Paso 1 >> Paso2. Dirección de envío");
	System.out.println("-----------------------------------\n");
	System.out.println("Introduzca la dirección de envío: ");
	//Establece como direccion de envio la direccion introducida por el usuario
	pedido.setDireccionDeEnvio(scanIn.nextLine());
	System.out.println("-----------------------------------");
}

//Metodo para crear un array de usuarios registrados y guardarlos
public static ArrayList<Registrado> obtenerRegistrados()

{
ArrayRegistrado.add(new Registrado("Diegojuarez@gmail.com", "Diego","Juarez","Pintor Murillo","1234","13/01/1992"));
ArrayRegistrado.add(new Registrado("PacoM@gmail.com", "Paco","Morales","Del arenal","mano","30/08/1990"));
ArrayRegistrado.add(new Registrado("AntonioGAR@gmail.com", "Antonio","Garcia","Del ambar","cara","15/02/1993"));
ArrayRegistrado.add(new Registrado("Teresapz@gmail.com", "Teresa","Perez","Abegonde","unodos","25/03/1994"));
ArrayRegistrado.add(new Registrado("Pepe12@gmail.com","Pepe","Lopez","Tristeza","hola","10/05/1991"));
return ArrayRegistrado;

}

//Metodo para crear array<Alimentacion> y guardar los elementos que introduzcamos.
public static ArrayList<Alimentacion> obtenerAlimentos()

{
ArrayAlimento.add(new Alimentacion("AL12", "Queso",1.5,0,"17/10/2016",1));
ArrayAlimento.add(new Alimentacion("AL13", "Lomo",2.34,0,"14/02/2017",1));
ArrayAlimento.add(new Alimentacion("AL14", "Jamon",2.84,0,"23/04/2016",1));
ArrayAlimento.add(new Alimentacion("AL15", "Lubina",2.4,0,"26/06/2016",1));
ArrayAlimento.add(new Alimentacion("AL16", "Sardina",3.15,0,"22/07/2016",1));
return ArrayAlimento;

}
//Metodo para crear array<DiscosDeMusica> y guardarlos
public static ArrayList<DiscosDeMusica> obtenerDiscoDeMusica()

{
ArrayDiscosDeMusica.add(new DiscosDeMusica("DC12", "Eminem",15.3,0,"Manolo","Infantil",1));
ArrayDiscosDeMusica.add(new DiscosDeMusica("DC13", "Nikone",10.54,0,"Diego","Pop",1));
ArrayDiscosDeMusica.add(new DiscosDeMusica("DC14", "Nach",22.99,0,"Alejandro","Rock",1));
ArrayDiscosDeMusica.add(new DiscosDeMusica("DC15", "Kase.o",13.64,0,"Pablo","Dance",1));
ArrayDiscosDeMusica.add(new DiscosDeMusica("DC16", "Swan fhaboy",20.5,0,"Fernando","Infantil",1));
return ArrayDiscosDeMusica;

}
//Metodo para crear array<Libros> y guardarlos
public static ArrayList<Libros> obtenerLibros()

{
ArrayLibros.add(new Libros("LB11", "Los 3 cerditos",25.5,0,"ISBN-10: 55-3381-336-6","Los 3 cerditos","SM",1));
ArrayLibros.add(new Libros("LB12", "Amor a tres",12.5,0,"ISBN-10: 30-9434-887-9","Amor a tres","Gargola",1));
ArrayLibros.add(new Libros("LB13", "Locura",24.99,0,"ISBN-10: 55-4232-201-3","Locura","Edn",1));
ArrayLibros.add(new Libros("LB14", "Caballo blanco",23.6,0,"ISBN-10: 44-1111-245-2","Caballo blanco","Estrada",1));
ArrayLibros.add(new Libros("LB15", "Harry Potter",21.5,0,"ISBN-10: 84-8181-227-7","Harry Potter","Kapeluz ", 1));
return ArrayLibros;

}

@Override
public void imprimir() {
	System.out.println("USUARIOS REGISTRADOS GUARDADOS UTILIZA ALGUNO DE ESTOS PARA ACCEDER(VERSION DE PRUEBA)\n");
	
	System.out.println(String.format("%-5s %-25s %-10s %-15s %-15s %-20s","Linea", "Email","Nombre","Apellidos","Direccion","Password","FechaNacimiento"));
	for(int i=0; i<ArrayRegistrado.size(); i++){
		System.out.println(String.format("%-5s %-25s %-10s %-15s %-15s %-20s", i+1,ArrayRegistrado.get(i).getEmail(),ArrayRegistrado.get(i).getNombre(),ArrayRegistrado.get(i).getApellidos(),ArrayRegistrado.get(i).getDireccion(),ArrayRegistrado.get(i).getPassword(),ArrayRegistrado.get(i).getFechaNacimiento()));
		
	}

}

public String getTipoUsuario() {
	return tipoUsuario;
}

public void setTipoUsuario(String tipoUsuario) {
	this.tipoUsuario = tipoUsuario;
}
}






