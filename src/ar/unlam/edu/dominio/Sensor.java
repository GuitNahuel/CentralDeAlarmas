package ar.unlam.edu.dominio;

public class Sensor {
	private Integer identificadorNumerico;
	private Boolean estadoSensor;

	public Sensor(Integer identificadorNumerico) {
//True es activado - false desactivado
		this.identificadorNumerico = identificadorNumerico;
		estadoSensor=false;
	}

	public Integer getIdentificadorNumerico() {
		return identificadorNumerico;
	}

	public Boolean getEstadoSensor() {
		return estadoSensor;
	}
}
