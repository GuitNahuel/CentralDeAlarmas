package ar.unlam.edu.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Alarma implements Comparable<Alarma> {
	private Integer id;
	private String codigoActivacionDesactivacion;
	private String codigoConfiguracion;
	private List<Usuario> usuariosValidos;

	

	public Alarma(Integer id, String codigoActivacionDesactivacion, String codigoConfiguracion) {
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

	public TreeSet<Usuario> getUsuariosValidos() {
		return usuariosValidos;
	}



}
