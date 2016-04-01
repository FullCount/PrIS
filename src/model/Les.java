package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Les {
	private LocalDateTime beginTijd;
	private LocalDateTime eindTijd;
	private String lokaal;
	private ArrayList<Student> aanwezigeStudenten = new ArrayList<Student>();
	private Docent docent;
	
	public Les(LocalDateTime bTijd, LocalDateTime eTijd, String lK, Docent d1)	{
		beginTijd = bTijd;
		eindTijd = eTijd;
		lokaal = lK;
		docent = d1;	
	}
	
	public boolean equals(Object obj)	{
		boolean isGelijk = false;
		if(obj instanceof Les)	{
			Les andereLes = (Les) obj;
				
			if(	this.beginTijd == andereLes.beginTijd &&
				this.eindTijd == andereLes.eindTijd)	{
				isGelijk = true;
			}	
		}
		
		return isGelijk;
	}
	
	public String getDocentNaam()	{
		return docent.getVolledigeNaam();
	}
	
	public ArrayList getAanwezigeStudenten()	{
		return aanwezigeStudenten;
	}
	
	public LocalDateTime getBeginTijd()	{
		return beginTijd;
	}
	
	public void setBeginTijd(LocalDateTime bT)	{
		beginTijd = bT;
	}
	
	public String getLokaalCode()	{
		return lokaal;
	}
	
	public void setLokaalCode(String cd)	{
		lokaal = cd;
	}
	
	public LocalDateTime getEindTijd()	{
		return eindTijd;
	}
	
	public void setEindTijd(LocalDateTime eT)	{
		eindTijd = eT;
	}
	
	public String toString()	{
		return "Les heeft begintijd " + beginTijd + " en eindtijd " + eindTijd;
	}
}
