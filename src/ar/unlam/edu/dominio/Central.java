package ar.unlam.edu.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Central {
	private TreeSet<Alarma> alarmas;
	private List<Usuario> usuarios;
	private List<Sensor> sensores;
	private Integer idUsuarioConfigurador;

	public Central(Integer idConfigurador) {
		this.idUsuarioConfigurador = idConfigurador;
		alarmas = new TreeSet<Alarma>();
		usuarios = new ArrayList<Usuario>();
		sensores = new ArrayList<Sensor>();
	}

	public Boolean agregarAlarma(Alarma alarma) {
		return alarmas.add(alarma);

	}

	public Boolean agregarUsuario(Usuario usuario) {
		return usuarios.add(usuario);

	}

	public TreeSet<Alarma> getAlarmas() {
		return alarmas;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public Boolean agregarUsuarioValidoAUnaAlarma(String dniUsuarioAAgregar, Integer idAlarma,
			String codigoConfiguracionAlarma)
			throws UsuarioException, AlarmaException, CodigoAlarmaIncorrectoException {
		Usuario usuarioBuscado = busquedaDeUsuario(dniUsuarioAAgregar);
		Alarma alarmaBuscada = busquedaDeAlarma(idAlarma);
		if (usuarioBuscado != null && alarmaBuscada != null) {
			if (alarmaBuscada.getCodigoConfiguracion().equals(codigoConfiguracionAlarma)) {
				return alarmaBuscada.agregarUsuarioALaListaDeUsuariosValidos(usuarioBuscado);
			} else {
				throw new CodigoAlarmaIncorrectoException("Codigo de configuracion de Alarma incorrecto");
			}
		}

		return false;

	}

	private Alarma busquedaDeAlarma(Integer idAlarma) throws AlarmaException {
		Alarma alarmaBuscada = null;
		for (Alarma a : alarmas) {
			if (a.getId().equals(idAlarma)) {
				alarmaBuscada = a;
				return alarmaBuscada;

			}
		}
		throw new AlarmaException("No se encontro la alarma");
	}

	private Usuario busquedaDeUsuario(String dniUsuarioAAgregar) throws UsuarioException {
		Usuario usuarioBuscado = null;
		for (Usuario u : usuarios) {
			if (u.getDni().equals(dniUsuarioAAgregar)) {
				usuarioBuscado = u;
				return usuarioBuscado;
			}
		}
		throw new UsuarioException("No se encontro al usuario");

	}

	public List<Sensor> getSensores() {
		return sensores;
	}

	public Boolean agregarSensorAAlarma(Integer idAlarma, String codigoConfigAlarma, Sensor sensor,
			Integer usuarioConfigurador) throws AlarmaException, SensorDuplicadoException {
		Alarma alarma = busquedaDeAlarma(idAlarma);

		if (idUsuarioConfigurador.equals(usuarioConfigurador)) {
			if (alarma.getCodigoConfiguracion().equals(codigoConfigAlarma)) {

				if (alarma.sensorInexistente(sensor)) {
					return alarma.agregarSensorALaListaDeSensores(sensor);
				} else
					throw new SensorDuplicadoException("Ya existe ese sensor");
			}

		}

		return false;

	}

	public Integer getIdUsuarioConfigurador() {
		return idUsuarioConfigurador;
	}

	public Boolean agregarSensor(Sensor sensor) {
		return sensores.add(sensor);
	}

	public Boolean activarSensorDeAlarma(Integer idSensor, Integer idAlarma, String codigoActivacionAlarma) {
		
		return	false;
	}

}
