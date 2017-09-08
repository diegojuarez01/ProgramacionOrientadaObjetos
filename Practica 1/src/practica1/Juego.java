package practica1;


import java.util.Scanner;


public class Juego {
	
	//Declaracion de atributos y creacion de objetos
	 private int modoJuego;
	 private String continuar;
	 Scanner scanIn = new Scanner(System.in);
	 Jugador jugador1 = new Jugador();
	 Jugador jugador2 = new Jugador();
	 Baraja barajatipo = new Baraja();
	 	 
	//Declaracion del metodo que mostrara nuestra cabecera con el nombre del programa
	private  void mostrarEncabezado()
	
	{
		System.out.println("/*********************************************/");
		System.out.println("/********* JUEGO DEL 7 y MEDIO ***************/");
		System.out.println("/*********************************************/\n");
		
	}
	
	//Declaracion del metodo que recogera los datos de los jugadores dependiendo del modo de juego seleccionado
	private void solicitarDatosJugadores(){
		
		System.out.println("Modos de juego: ");
		System.out.println("(1) un jugador");
		System.out.println("(2) dos jugadores");
		System.out.println("Elija el modo de juego: ");
		
	//Guardamos en la variable modoJuego el valor introducido por pantalla que sera del tipo int
		modoJuego = scanIn.nextInt();
		
	//Diferente codigo dependiendo de la opcion de modo de juego selecionada por el usuario
			if (modoJuego==1)
			{
					
				System.out.println("Introduzca los datos del jugador 1");
				scanIn.nextLine();
				
				System.out.println("Alias:");
				jugador1.setAlias(scanIn.nextLine());
				
				System.out.println("Nombre:");
				jugador1.setNombre(scanIn.nextLine());
				
				System.out.println("Apellidos:");
				jugador1.setApellidos(scanIn.nextLine());
				
		// Creamos el jugador 2 de forma automatica con los valores por defecto especificados en el constructor y comprobamos con una impresion por pantalla
				System.out.println("El jugador2 se ha creado por defecto con los siguientes valores:");
				System.out.println("Alias: " + jugador2.getAlias());
				System.out.println("Nombre: " + jugador2.getNombre());
				System.out.println("Apellidos: " + jugador2.getApellidos());
				System.out.println("Tipo de jugador: "+jugador2.getTipodejugador());
			}
				
				else if (modoJuego==2)
			{
					
					System.out.println("Introduzca los datos del jugador 1");
					scanIn.nextLine();
					
					System.out.println("Alias:");
					jugador1.setAlias(scanIn.nextLine());
					
					System.out.println("Nombre:");
					jugador1.setNombre(scanIn.nextLine());
					
					System.out.println("Apellidos");
					jugador1.setApellidos(scanIn.nextLine());
					
					System.out.println("Introduzca los datos del jugador 2");
								
					System.out.println("Alias:");
					jugador2.setAlias(scanIn.nextLine());
					
					System.out.println("Nombre:");
					jugador2.setNombre(scanIn.nextLine());
					
					System.out.println("Apellidos");
					jugador2.setApellidos(scanIn.nextLine());
					
			}
				else 
			{
					System.out.println("El modo de juego seleccionado no existe.");
					System.out.println("El programa se cerrara automaticamente.");
					System.exit(0);
			}
				
												}
	
	//Declaracion del metodo que diferenciara entre los 2 tipos de baraja disponibles dependiendo de la opcion seleccionada por el usuario
	private void solicitarTipoBaraja(){
		System.out.println("Tipos de baraja:");
		System.out.println("(E) Española");
		System.out.println("(F) Francesa");
		System.out.println("Elija el tipo de baraja:");
		
	//Guarda dentro del atributo tipo en el objeto barajatipo el string que imprimamos por pantalla
		barajatipo.setTipo(scanIn.nextLine());
		
	//Utilizamos el metodo seleccionarBaraja de clase baraja que creara las barajas dependiendo de la baraja que haya seleccionado el usuario
		barajatipo.selecionarBaraja();
		
	}
	
	private void iniciarJugada()
	{
		
	//Inicia el juego el jugador 1, indicamos sus datos y despues mostramos la primera carta seleccionada que sera la que se encuentra en la posicion 0 de nuestro array.
		System.out.println("----------------------------------------");
		System.out.println("Inicio jugada jugador 1 - "+ jugador1.getNombre()+" "+ jugador1.getApellidos()+ "(" + jugador1.getAlias() + ")");
		System.out.println("----------------------------------------");
		System.out.println("Carta: ");
		jugador1.setCartasmano(barajatipo.obtenerCartas());
		
	//Hacemos un bucle con  while mientras el usuario sigua pidiendo cartas se ejecute el bloque.
		while (continuar !="N"){
	//Limpiamos la puntuacion y volvemos a evaluar con la nueva carta añadida		
			jugador1.setPuntuacion(0);
			jugador2.setPuntuacion(0);
			puntuar();
				if (jugador1.getPuntuacion()<7.5)
				{
	//Llamamos al metodo opcion que sera el encargado de preguntar al usuario si quiere mas cartas, solo lo llamamos cuando la puntuacion es menor a 7.5 ya que sino es asi el juego acabara automaticamente				
					Opcion();
	// Switch que depende del valor de continuar, que sera la pregunta que le haremos al usuario por si quiere mas cartas, tendra 2 valores S/N tanto en mayuscula como minuscula.
		switch (continuar)
				{
		case "s":
		case "S":
			
			System.out.println("Carta: ");
			jugador1.setCartasmano(barajatipo.obtenerCartas());
			break;
		
		case "n":						
		case "N":
			
			System.out.println("El jugador 1 se planta con las siguientes cartas:");
			System.out.println("----------------------------------------");
			//Recorre las cartas de jugador1 y las muestra
			for(int x=0;x<jugador1.getCartasmano().size();x++) {
				  System.out.println("Carta: " +jugador1.getCartasmano().get(x));
				}
			//Al plantarse se llama a iniciarJugada2(); que iniciara la jugada del jugador2, solo se llamara si el jugador 1 se planta.
			iniciarJugada2();						
			continuar = "N";
				break;
				}
		 }
				// Para cuando jugador1 saca 7.5  se inicia la jugada de jugador2.
				else if(jugador1.getPuntuacion()==7.5) {
					iniciarJugada2();
					continuar = "N";
					break;
				}
				else {
					System.out.println("El jugador 1 se paso con las siguientes cartas:");
					
					//Recorre las cartas de jugador1 y las muestra
					for(int x=0;x<jugador1.getCartasmano().size();x++) {
						  System.out.println("Carta: " +jugador1.getCartasmano().get(x));
						}
											
					continuar = "N";
						break;
				}
		}
			
	}
	//Llamada al metodo que inicia la jugada del jugador2, solo se iniciara si el jugador 1 se ha plantado, en caso de que el jugador 1 se pase del 7,5 o saque 7,5 no se iniciara ya que el jugador2 ganara automaticamente sin jugar.
	private void iniciarJugada2()
	{
	
	//Se haran las jugadas automaticamente ya que el segundo jugador es una maquina, sacara 2 cartas dependiendo del valor de esas cartas pedira otra o se plantara, y si se pasa del 7,5 perdera..
		if(modoJuego==1)
		{
			System.out.println("----------------------------------------");
			System.out.println("Inicio jugada jugador 2 - "+ jugador2.getNombre()+" "+ jugador2.getApellidos()+ "(" + jugador2.getAlias() + ")");
			System.out.println("----------------------------------------");
			System.out.println("Carta: ");
			jugador2.setCartasmano(barajatipo.obtenerCartas());
			System.out.println("Carta: ");
			jugador2.setCartasmano(barajatipo.obtenerCartas());	
			puntuar();
	//Si la maquina saca en sus dos primeras cartas menos de 5.5, pedira otra carta		
			if (jugador2.getPuntuacion()<5.5)
			{
				System.out.println("Carta: ");
				jugador2.setCartasmano(barajatipo.obtenerCartas());
				
			}
	//Si la maquina saca en sus dos primeras cartas mas de 7.5, imprime las cartas con las que se ha pasado.		
			else if(jugador2.getPuntuacion()>7.5)
			{
				System.out.println("El jugador 2 se paso con las siguientes cartas");
				
				//Recorre las cartas de jugador1 y las muestra
				for(int x=0;x<jugador2.getCartasmano().size();x++) {
					  System.out.println("Carta: " +jugador2.getCartasmano().get(x));
					}
			}
	//Si la maquina saca en sus dos primeras cartas entre 5.5 y 7.5 se plantara.		
			else {
				System.out.println("El jugador 2 se planta con las siguientes cartas");
				
				//Recorre las cartas de jugador1 y las muestra
				for(int x=0;x<jugador2.getCartasmano().size();x++) {
					  System.out.println("Carta: " +jugador2.getCartasmano().get(x));
					}
     			}
			
		}
	//Si el modojuego seleccionado es el 2 el jugador sera manual y hara sera el mismo codigo que para el jugador1.
		else if (modoJuego==2){
	//Inicia el juego el jugador 1, indicamos sus datos y despues mostramos la primera carta seleccionada que sera la que se encuentra en la posicion 0 de nuestro array.
		System.out.println("----------------------------------------");
		System.out.println("Inicio jugada jugador 2 - "+ jugador2.getNombre()+" "+ jugador2.getApellidos()+ "(" + jugador2.getAlias() + ")");
		System.out.println("----------------------------------------");
		System.out.println("Carta: ");
		jugador2.setCartasmano(barajatipo.obtenerCartas());
		
		//Hacemos un bucle con  while mientras el usuario sigua pidiendo cartas se ejecute el bloque
				while (continuar !="N"){
			//Limpiamos la puntuacion y volvemos a evaluar con la nueva carta añadida		
					jugador1.setPuntuacion(0);
					jugador2.setPuntuacion(0);
					puntuar();
						if (jugador2.getPuntuacion()<7.5)
						{
			//Llamamos al metodo opcion que sera el encargado de preguntar al usuario si quiere mas cartas, solo lo llamamos cuando la puntuacion es menor a 7.5 ya que sino es asi el juego acabara automaticamente				
							Opcion();
			// Switch que depende del valor de continuar, que sera la pregunta que le haremos al usuario por si quiere mas cartas, tendra 2 valores S/N tanto en mayuscula como minuscula.
				switch (continuar)
						{
				case "s":
				case "S":
					System.out.println("Carta: ");
					jugador2.setCartasmano(barajatipo.obtenerCartas());
					break;
				
				case "n":						
				case "N":
					
					System.out.println("El jugador 2 se planta con las siguientes cartas:");
					System.out.println("----------------------------------------");
					//Recorre las cartas de jugador1 y las muestra
					for(int x=0;x<jugador2.getCartasmano().size();x++) {
						  System.out.println("Carta: " +jugador2.getCartasmano().get(x));
						}
											
					continuar = "N";
						break;
						}
				 }
						// Para cuando jugador2 saca 7.5 no pida mas cartas
						else if(jugador2.getPuntuacion()==7.5) {
							
							continuar = "N";
							break;
						}
						
						// Para cuando jugador2 saca mas de 7.5 no pida mas cartas e imprima un mensaje diciendo que te has pasado junto con todas las cartas sacadas.
						else {
							System.out.println("El jugador 2 se paso con las siguientes cartas:");
							
							//Recorre las cartas de jugador1 y las muestra
							for(int x=0;x<jugador2.getCartasmano().size();x++) {
								  System.out.println("Carta: " +jugador2.getCartasmano().get(x));
								}
													
							continuar = "N";
								break;
						}
						
				}
		System.out.println("");
		jugador1.setPuntuacion(0);
		jugador2.setPuntuacion(0);
		}
	}
			
	//Metodo encargado de preguntar al usuario si quiere mas cartas y guarda el comando introducido del usuario en la variable continuar
	private void Opcion ()
	{
		
		System.out.println("¿Desea una nueva carta? S/N");
		continuar = scanIn.nextLine();
		
	}	
	//Metodo encargado de establecer puntuaciones dependiendo de la carta sacada para cada uno de los jugadores.
	private void puntuar()
	{
		jugador1.setPuntuacion(0);
		jugador2.setPuntuacion(0);	
		for (int j = 0; j < jugador1.getCartasmano().size() ; j++)
		{
		if(jugador1.getCartasmano().get(j).getNumeros().matches("1|2|3|4|5|6|7")){
			jugador1.setPuntuacion(jugador1.getPuntuacion() + Double.parseDouble(jugador1.getCartasmano().get(j).getNumeros()));		
		}
		else if (jugador1.getCartasmano().get(j).getNumeros().matches("As")){
			jugador1.setPuntuacion(jugador1.getPuntuacion() + 1.0);		
		}
		else {
			jugador1.setPuntuacion(jugador1.getPuntuacion() + 0.5);	
		}
		}
		
		for (int j = 0; j < jugador2.getCartasmano().size() ; j++)
		{
		if(jugador2.getCartasmano().get(j).getNumeros().matches("1|2|3|4|5|6|7")){
				jugador2.setPuntuacion(jugador2.getPuntuacion() + Double.parseDouble(jugador2.getCartasmano().get(j).getNumeros()));		
		}
		else if (jugador2.getCartasmano().get(j).getNumeros().matches("As")){
				jugador2.setPuntuacion(jugador2.getPuntuacion() + 1.0);		
		}
		else{
				jugador2.setPuntuacion(jugador2.getPuntuacion() + 0.5);	
		}
		}
	}
	//Metodo encargado de establecer un ganador dependiendo de las puntuaciones y teniendo en cuenta que si es mayor a 7,5 equivale a derrota
	private void establecerGanador ()
	{
		System.out.println("++++Ganador+++");
		System.out.println("----------------------------------------");
	//Establecemos los valores para asignar el ganador de las partidas
		
			if (jugador1.getPuntuacion()==jugador2.getPuntuacion())
			{
				System.out.println("No hay ganador, resultado empate.");
			}
			else if(jugador1.getPuntuacion()>7.5 && jugador2.getPuntuacion()>7.5){
				
				System.out.println("No hay ganador, resultado los dos jugadores se pasaron.");
			}
			else if(jugador1.getPuntuacion()>jugador2.getPuntuacion() && jugador1.getPuntuacion()<7.5)
			{
				System.out.println("Ganador" + " " +jugador1.getNombre()+" "+ jugador1.getApellidos()+ "(" + jugador1.getAlias() + ")" +"¡¡¡Enhorabuena CAMPEÓN!!!");				
			}
			else if(jugador2.getPuntuacion()>jugador1.getPuntuacion() && jugador2.getPuntuacion()<7.5)
			{
				System.out.println("Ganador" + " " +jugador2.getNombre()+" "+ jugador2.getApellidos()+ "(" + jugador2.getAlias() + ")" +"¡¡¡Enhorabuena CAMPEÓN!!!");				
			}
			else if(jugador1.getPuntuacion()<jugador2.getPuntuacion() && jugador2.getPuntuacion()>7.5)
			{
				System.out.println("Ganador" + " " +jugador1.getNombre()+" "+ jugador1.getApellidos()+ "(" + jugador1.getAlias() + ")" +"¡¡¡Enhorabuena CAMPEÓN!!!");
			}
			else if(jugador2.getPuntuacion()<jugador1.getPuntuacion() && jugador1.getPuntuacion()>7.5)
			{
				System.out.println("Ganador" + " " +jugador2.getNombre()+" "+ jugador2.getApellidos()+ "(" + jugador2.getAlias() + ")" +"¡¡¡Enhorabuena CAMPEÓN!!!");
			}
			else if (jugador2.getPuntuacion()==7.5 && jugador1.getPuntuacion()!=7.5){
				System.out.println("Ganador" + " " +jugador2.getNombre()+" "+ jugador2.getApellidos()+ "(" + jugador2.getAlias() + ")" +"¡¡¡Enhorabuena CAMPEÓN!!!");
			}
			else if (jugador1.getPuntuacion()==7.5 && jugador2.getPuntuacion()!=7.5){
				System.out.println("Ganador" + " " +jugador1.getNombre()+" "+ jugador1.getApellidos()+ "(" + jugador1.getAlias() + ")" +"¡¡¡Enhorabuena CAMPEÓN!!!");
			}
						
		System.out.println("        -------------Fin del juego--------------");
	}
		
	//Metodo encargado de mostrar el resumen de la jugada
	private void mostrarResumen()
	
	{
		System.out.println("\n++++Resumen de la jugada+++");
		System.out.println("----------------------------------------");
		System.out.println("Jugador 1 con" + " " +jugador1.getPuntuacion() + " " +"y estas cartas:");
		
		//Recorre las cartas de jugador1 y las muestra
		for(int x=0;x<jugador1.getCartasmano().size();x++) {
			  System.out.println("Carta: " +jugador1.getCartasmano().get(x));
			}
		// Con esta impresion creamos un salto de linea, tambien podemos hacerlo con "\n"
		System.out.println("");
		
		System.out.println("Jugador 2 con" + " " +jugador2.getPuntuacion() + " " +"y estas cartas:");
		
		//Recorre las cartas de jugador2 y las muestra
		for(int x=0;x<jugador2.getCartasmano().size();x++) {
			  System.out.println("Carta: " +jugador2.getCartasmano().get(x));
			}
		
	}
			
	//Declaracion del metodo iniciarJuego que sera el que llame a todos los metodos, que sera publico y llamaremos desde el main
	public void iniciarJuego(){
		
	//Llamada al metodo mostrarEncabezado
		mostrarEncabezado();
	//Llamada al metodo solicitarDatosJugadores
		solicitarDatosJugadores();
	//Llamada al metodo solicitarTipoBaraja
		solicitarTipoBaraja();
	//Llamada al metodo iniciarJugada
		iniciarJugada();
	//Llamada al metodo Puntuacion
		puntuar();
	//Llamada al metodo mostrarResumen	
		mostrarResumen();
	//Llamada al metodo establecerGanador
		establecerGanador();
	}
}

