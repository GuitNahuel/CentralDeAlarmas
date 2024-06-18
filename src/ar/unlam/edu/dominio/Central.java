package ar.unlam.edu.dominio;

import java.util.TreeSet;

public class Central {
	private TreeSet<Alarma>alarmas;
	
	
	public Central() {
		alarmas=new TreeSet<Alarma>();
	}


	public Boolean agregarAlarma(Alarma alarma) {
		return alarmas.add(alarma);
		
	}


	public TreeSet<Alarma> getAlarmas() {
		return alarmas;
	}

}
