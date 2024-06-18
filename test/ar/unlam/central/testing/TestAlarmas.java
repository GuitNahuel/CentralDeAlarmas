package ar.unlam.central.testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.unlam.edu.dominio.Alarma;
import ar.unlam.edu.dominio.AlarmaException;
import ar.unlam.edu.dominio.Central;
import ar.unlam.edu.dominio.CodigoAlarmaIncorrectoException;
import ar.unlam.edu.dominio.Configurador;
import ar.unlam.edu.dominio.Sensor;
import ar.unlam.edu.dominio.SensorDuplicadoException;
import ar.unlam.edu.dominio.SensorNoEncontradorException;
import ar.unlam.edu.dominio.Usuario;
import ar.unlam.edu.dominio.UsuarioException;

public class TestAlarmas {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void queSePuedaRegistarUnaAlarmaEnLaCentral() {
		Central central = new Central(1111);
		Alarma alarma1 = new Alarma();
		Boolean alarmaAgregada = central.agregarAlarma(alarma1);
		assertTrue(alarmaAgregada);
	}

	@Test
	public void queSePuedaAgregarUnUsuarioConfiguradorAUnaAlarma()
			throws UsuarioException, AlarmaException, CodigoAlarmaIncorrectoException {
		Central central = new Central(1111);
		Usuario usuario = new Usuario("38268183", "GuitNahuel");
		Alarma alarma1 = new Alarma("Pentagono", 1280, "1234", "AX100");
		central.agregarUsuario(usuario);
		central.agregarAlarma(alarma1);
		assertTrue(central.agregarUsuarioValidoAUnaAlarma("38268183", 1280, "AX100"));
	}

	@Test(expected = CodigoAlarmaIncorrectoException.class)
	public void alAgregarUnUsuarioAUnaAlarmaConCodigoDeConfiguracionDeAlarmaInvalidoSeLanceCodigoAlarmaIncorrectoException()
			throws UsuarioException, AlarmaException, CodigoAlarmaIncorrectoException {
		Central central = new Central(1111);
		Usuario usuario = new Usuario("38268183", "GuitNahuel");
		Alarma alarma1 = new Alarma("Pentagono", 1280, "1234", "AX100");
		central.agregarUsuario(usuario);
		central.agregarAlarma(alarma1);
		central.agregarUsuarioValidoAUnaAlarma("38268183", 1280, "AX101");
	}

	@Test(expected = SensorDuplicadoException.class)
	public void alAgregarUnSensorDuplicadoEnUnaAlarmaSeLanceUnaSensorDuplicadoException()
			throws UsuarioException, AlarmaException, CodigoAlarmaIncorrectoException, SensorDuplicadoException {
		Central central = new Central(1111);
		Usuario usuario = new Usuario("38268183", "GuitNahuel");
		Alarma alarma1 = new Alarma("Pentagono", 1280, "1234", "AX100");
		Sensor sensor = new Sensor(1);
		Sensor sensor1 = new Sensor(1);
		central.agregarUsuario(usuario);
		central.agregarAlarma(alarma1);
		central.agregarSensor(sensor);
		central.agregarSensor(sensor1);
		central.agregarUsuarioValidoAUnaAlarma("38268183", 1280, "AX100");
		assertTrue(central.agregarSensorAAlarma(1280, "AX100", sensor, 1111));
		assertTrue(central.agregarSensorAAlarma(1280, "AX100", sensor1, 1111));
	}

	@Test
	public void queNoSePuedaActivarUnaAlarmaSiHayAlMenosUnSensorDesactivado()
			throws AlarmaException, SensorNoEncontradorException, SensorDuplicadoException {
		Central central = new Central(1111);
		Usuario usuario = new Usuario("38268183", "GuitNahuel");
		Alarma alarma1 = new Alarma("Pentagono", 1280, "1234", "AX100");
		Sensor sensor = new Sensor(1);
		Sensor sensor1 = new Sensor(2);
		Configurador configurador = new Configurador("111111", "configurador");
		central.agregarUsuario(usuario);
		central.agregarAlarma(alarma1);
		central.agregarSensor(sensor);
		central.agregarSensor(sensor1);
		central.agregarSensorAAlarma(1280, "AX100", sensor, 1111);
		assertTrue(central.agregarSensorAAlarma(1280, "AX100", sensor1, 1111));

		assertTrue(central.activarSensorDeAlarma(1, 1280, "1234"));
		assertFalse(central.activarDesactivarAlarma(1280, "1234", configurador));

	}
}
