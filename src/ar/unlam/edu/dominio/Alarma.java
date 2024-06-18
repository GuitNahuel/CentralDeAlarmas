package ar.unlam.edu.dominio;

import java.util.ArrayList;
import java.util.List;

public class Alarma implements Comparable<Alarma> {
	private String nombre;
	private Integer id;
	private String codigoActivacionDesactivacion;
	private String codigoConfiguracion;
	private List<Usuario> usuariosValidos;

	

	public Alarma(String nombre,Integer id, String codigoActivacionDesactivacion, String codigoConfiguracion) {
		this.nombre=nombre;
		this.id = id;
		this.codigoActivacionDesactivacion = codigoActivacionDesactivacion;
		this.codigoConfiguracion = codigoConfiguracion;
		usuariosValidos= new ArrayList<Usuario>();

	}
	public Alarma() {
		usuariosValidos= new ArrayList<Usuario>();


	}
	public Boolean agregarUsuarioALaListaDeUsuariosValidos(Usuario usuarioBuscado) {
		return usuariosValidos.add(usuarioBuscado);
		
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



}
