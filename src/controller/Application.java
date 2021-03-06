package controller;

import java.io.File;
import java.io.IOException;

import model.Opleiding;
import server.JSONFileServer;

public class Application {
	/**
	 * Deze klasse is het startpunt voor de applicatie. Hierin maak je een server 
	 * op een bepaalde poort (bijv. 8888). Daarna is er een PrIS-object gemaakt. Dit
	 * object fungeert als toegangspunt van het domeinmodel. Hiervandaan kan alle
	 * informatie bereikt worden.
	 * 
	 * Om het domeinmodel en de Polymer-GUI aan elkaar te koppelen zijn diverse controllers
	 * gemaakt. Er zijn meerdere controllers om het overzichtelijk te houden. Je mag zoveel
	 * controller-klassen maken als je nodig denkt te hebben. Elke controller krijgt een
	 * koppeling naar het PrIS-object om benodigde informatie op te halen.
	 * 
	 * Je moet wel elke URL die vanaf Polymer aangeroepen kan worden registreren! Dat is
	 * hieronder gedaan voor een drietal URLs. Je geeft daarbij ook aan welke controller
	 * de URL moet afhandelen.
	 * 
	 * Als je alle URLs hebt geregistreerd kun je de server starten en de applicatie in de
	 * browser opvragen! Zie ook de controller-klassen voor een voorbeeld!
	 * @throws IOException 
	 * 
	 */
	public static void main(String[] args) throws IOException {
		JSONFileServer server = new JSONFileServer(new File("webapp/app"), 80);
		
		Opleiding infoSysteem = new Opleiding();
		
		
		
		// Nieuwe knop toevoegen : 
		// Maak nieuwe controller, maak object
		// server.registerHandler
		// elements.html : <link rel="import" href="{{te gebruiken klasse}}.html">
		// in je controller : controle op pad 
		// routing.html : nieuwe page toevoegen
		// in elements/{{nieuwe route}}/my-{{route}}.html
		
		
		Controller controller = new Controller(infoSysteem);
//		UserController userController = new UserController(infoSysteem);
//		DocentController docentController = new DocentController(infoSysteem);
//		StudentController studentController = new StudentController(infoSysteem);
//		RoosterController roosterController = new RoosterController(infoSysteem);
//		AbsentieController absentieController = new AbsentieController(infoSysteem);
//		VakController vakController = new VakController(infoSysteem);
		
		server.registerHandler("/api", controller);
//		server.registerHandler("/login", userController);
//		server.registerHandler("/docent/mijnvakken", docentController);
//		server.registerHandler("/student/mijnmedestudenten", studentController);
//		server.registerHandler("/student/mijnrooster", roosterController);
//		server.registerHandler("/student/absenties", absentieController);
		
		server.start();
	}
}