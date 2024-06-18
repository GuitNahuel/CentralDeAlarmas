package ar.unlam.central.testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.unlam.edu.dominio.Alarma;
import ar.unlam.edu.dominio.AlarmaException;
import ar.unlam.edu.dominio.Central;
import ar.unlam.edu.dominio.Usuario;
import ar.unlam.edu.dominio.UsuarioException;

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
	@Test
	public void queSePuedaAgregarUnUsuarioConfiguradorAUnaAlarma() throws UsuarioException, AlarmaException {
		Central central = new Central();
		Usuario usuario= new Usuario("38268183", "GuitNahuel");
		Alarma alarma1 = new Alarma(1280,"1234","AX100");
		central.agregarUsuario(usuario);
		central.agregarAlarma(alarma1);
		assertTrue(central.agregarUsuarioValidoAUnaAlarma("38268183", 1280 ,"AX100"));
	}

}
