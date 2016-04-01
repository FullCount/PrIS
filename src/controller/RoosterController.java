package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import javax.json.Json;
import javax.json.JsonArrayBuilder;

import model.Klas;
import model.Les;
import model.Opleiding;
import model.Student;
import model.User;
import model.Vak;

public class RoosterController extends Controller {
	public RoosterController(Opleiding opleiding) {
		super(opleiding);
	}
	
	
	public JsonArrayBuilder rooster(User user)	{
		Student student = (Student) user;
//		if(user instanceof Student)	{
//			Student student = (Student) user;
//		}	else if(user instanceof Docent)	{
//			Docent docent = (Docent) user;
//		}
		
		Klas klas = null;
		try {
			// student = this.opleiding.getStudent(gebruikersnaam);			// Student-object opzoeken
			klas = this.opleiding.getKlasBijStudent(student);
		}	catch(Exception ex)	{
			this.handleError(102);
			System.out.println("Kan klas bij Student niet vinden");
		}
		
		ArrayList<Vak> vakken = null;
		try	{
			vakken = student.getVakken();
		}	catch(Exception ex)	{
			this.handleError(103);
			System.out.println("Kan vakken bij student niet vinden");
		}
		
		try	{
			JsonArrayBuilder jab = Json.createArrayBuilder();
			
			ArrayList<Object> lessen = null;
			String klascode;
			String vakcode;
			String begintijd;
			String eindtijd;
			
			for (Vak v : vakken) {
				Collections.sort(v.getLessen(), new Comparator<Les>() {
					@Override
					public int compare(Les l1, Les l2) {
						return l1.getBeginTijd().compareTo(l2.getBeginTijd());
					}
				});
				for(Les l : v.getLessen())	{					
					jab.add(
							Json.createObjectBuilder()							// daarin voor elk vak een JSON-object...
								.add("klascode", klas.getKlasCode())
								.add("vakcode", v.getVakCode())
//								.add("vaknaam", v.getVakNaam())
								.add("begintijd", l.getBeginTijd().toString())
								.add("eindtijd", l.getEindTijd().toString())
								.add("docent", l.getDocentNaam())
								.add("lokaal", l.getLokaalCode())
						);
				}
			}
			
			
			
			return jab;
		}	catch(Exception ex)	{
			this.handleError(104);
			return null;
		}
	}
}
