package ar.unlam.edu.dominio;

import java.util.ArrayList;
import java.util.List;

public class Alarma implements Comparable<Alarma> {
	private String nombre;
	private Integer id;
	private String codigoActivacionDesactivacion;
	private String codigoConfiguracion;
	private List<Usuario> usuariosValidos;
	private List<Sensor> sensoresDeLaAlarma;
	private EstadoDeAlarma estadoAlarma;

	public Alarma(String nombre, Integer id, String codigoActivacionDesactivacion, String codigoConfiguracion) {
		this.nombre = nombre;
		this.id = id;
		this.codigoActivacionDesactivacion = codigoActivacionDesactivacion;
		this.codigoConfiguracion = codigoConfiguracion;
		estadoAlarma = EstadoDeAlarma.DESACTIVADA;
		sensoresDeLaAlarma = new ArrayList<Sensor>();
		usuariosValidos = new ArrayList<Usuario>();

	}

	public Alarma() {
		usuariosValidos = new ArrayList<Usuario>();

	}

	public Boolean agregarUsuarioALaListaDeUsuariosValidos(Usuario usuarioBuscado) {
		return usuariosValidos.add(usuarioBuscado);

	}

	public Boolean agregarSensorALaListaDeSensores(Sensor sensor) {
		return sensoresDeLaAlarma.add(sensor);

	}

	public Boolean sensorInexistente(Sensor sensor) {
		for (Sensor s : sensoresDeLaAlarma) {
			if (s.getIdentificadorNumerico() == sensor.getIdentificadorNumerico()) {
				return false;
			}
		}
		return true;
	}

	public Boolean sensoresActivados() {
		for (Sensor s : sensoresDeLaAlarma) {
			if (s.getEstadoSensor() == false) {
				return false;
			}
		}
		return true;

	}

	@Override
	public int compareTo(Alarma o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Integer getId() {
		return id;
	}

	public String getCodigoActivacionDesactivacion() {
		return codigoActivacionDesactivacion;
	}

	public String getCodigoConfiguracion() {
		return codigoConfiguracion;
	}

	public List<Usuario> getUsuariosValidos() {
		return usuariosValidos;
	}

	public String getNombre() {
		return nombre;
	}

	public List<Sensor> getSensoresDeLaAlarma() {
		return sensoresDeLaAlarma;
	}

	public Sensor buscarSensorDentroDeLaAlarma(Integer idSensor) throws SensorNoEncontradorException {
		// TODO Auto-generated method stub
		Sensor sensorBuscado = null;
		for (Sensor s : sensoresDeLaAlarma) {
			if (s.getIdentificadorNumerico().equals(idSensor)) {
				sensorBuscado = s;

				return sensorBuscado;
			}
		}
		throw new SensorNoEncontradorException("No se encontro al sensor en la lista de sensores de la alarma");
	}

	public EstadoDeAlarma getEstadoAlarma() {
		return estadoAlarma;
	}

	public void setEstadoAlarma(EstadoDeAlarma estadoAlarma) {
		this.estadoAlarma = estadoAlarma;
	}

}
