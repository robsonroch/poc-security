package br.com.robson.pocsecurity.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.robson.pocsecurity.model.Usuario;

@Repository
public class UsuarioRepository {
	
	Map<String, Usuario> usuarios = new HashMap<>();
	private int ids = 1;
	
	public Usuario save(Usuario usuario) {
		
		return saveUsuarios(usuario);
	}

	private Usuario saveUsuarios(Usuario usuario) {
		
		if(!usuarios.containsKey(usuario.getLogin())) {
			ids = ids +1;
			usuario.setId(ids);
			usuarios.put(usuario.getLogin(), usuario);
		}
		
		return usuario;
	}

	private Map<String, Usuario> getUsuarios() {
		
		Usuario fulano = Usuario.builder().admin(true).id(1).login("fulano").senha("123").build();
		usuarios.put(fulano.getLogin(), fulano);
		return usuarios;
	}

	public Optional<Usuario> findByLogin(String username) {
		Usuario usuario = getUsuarios().get(username);
        return Optional.ofNullable(usuario);
	}

}
