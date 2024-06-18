package ar.unlam.edu.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Central {
	private TreeSet<Alarma> alarmas;
	private List<Usuario> usuarios;

	public Central() {
		alarmas = new TreeSet<Alarma>();
		usuarios=new ArrayList<Usuario>();
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

	public Boolean agregarUsuarioValidoAUnaAlarma(String dniUsuarioAAgregar, Integer idAlarma, String codigoConfiguracionAlarma)
			throws UsuarioException, AlarmaException {
		Usuario usuarioBuscado = busquedaDeUsuario(dniUsuarioAAgregar);
		Alarma alarmaBuscada = busquedaDeAlarma(idAlarma);
		if (usuarioBuscado != null && alarmaBuscada != null) {
			if (alarmaBuscada.getId().equals(idAlarma)
					&& alarmaBuscada.getCodigoConfiguracion().equals(codigoConfiguracionAlarma)) {
				return alarmaBuscada.agregarUsuarioALaListaDeUsuariosValidos(usuarioBuscado);
			}

		}
		return null;

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

}
