package org.maintech.usuario;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> getAllUsuario() {
		List<Usuario> usuarios = new ArrayList<>();
		usuarioRepository.findAll().forEach(usuarios::add);
		return usuarios;
	}
	
	public Usuario getUsuario(Integer id) {
		return usuarioRepository.findOne(id);
	}

	public void addUsuario(Usuario topic) {		
		usuarioRepository.save(topic);
	}

	public void updateUsuario(Integer id, Usuario topic) {		
		usuarioRepository.save(topic);
	}

	public void deleteUsuario(Integer id) {
		usuarioRepository.delete(id);
	}
	
	public void softDeleteUsuario(Integer id) {
		usuarioRepository.softDeleteUsuario(id);
	}
	
	public Integer getAreaByMail(String mail) {
		return usuarioRepository.getAreaByMail(mail);
	}

	public Object getautorizan(Integer id) {
		List<Object> usuarios = new ArrayList<>();
		usuarioRepository.getautorizan(id).forEach(usuarios::add);
		return usuarios;
	}

	public Object getliberacion(Integer id) {
		List<Object> usuarios = new ArrayList<>();
		usuarioRepository.getliberacion(id).forEach(usuarios::add);
		return usuarios;
	}
}
