package ar.unlam.central.testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.unlam.edu.dominio.Alarma;

public class TestAlarmas {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void queSePuedaRegistarUnaAlarmaEnLaCentral() {	
		Alarma alarma1= new Alarma();
		assertNotNull(alarma1);
		
	}

}
