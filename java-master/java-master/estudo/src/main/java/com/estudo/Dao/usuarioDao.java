package com.estudo.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.estudo.Dto.usuarioDto;

@Component
public class usuarioDao {

	@Autowired
	private usuarioRepository repository;

	public usuarioDto atualizar(usuarioDto dto) {
		usuarioDto save = repository.save(dto);
		return save;

	}

	public usuarioDto buscar(long codigo) {
		usuarioDto select = repository.findOne(codigo);
		return select;

	}

	public List<usuarioDto> all() {
		Iterable<usuarioDto> findAll = repository.findAll();
		return (List<usuarioDto>) findAll;
	}

	public usuarioDto cadastra(usuarioDto dto) {
		usuarioDto save = repository.save(dto);
		return save;
	}

	public void deletar(long codigo) {
		repository.delete(codigo);
	}
}
