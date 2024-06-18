package ar.unlam.central.testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.unlam.edu.dominio.Alarma;
import ar.unlam.edu.dominio.Central;

public class TestAlarmas {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void queSePuedaRegistarUnaAlarmaEnLaCentral() {
		Central central = new Central();
		Alarma alarma1 = new Alarma();
		Boolean alarmaAgregada = central.agregarAlarma(alarma1);
		assertTrue(alarmaAgregada);

	}

}
