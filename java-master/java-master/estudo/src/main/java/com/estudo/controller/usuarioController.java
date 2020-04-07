package com.estudo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.Dao.usuarioDao;
import com.estudo.Dto.usuarioDto;
import com.estudo.command.usuarioCommand;

@RestController
@RequestMapping(value = "/usuarios")
public class usuarioController {
	@Autowired
	private usuarioDao dao;

	@GetMapping(value = "/{codigoUsuario}")
	public usuarioDto Buscarid(@PathVariable(name = "codigoUsuario", required = true) int codigoUsuario) {
		usuarioDto usuaResponse = new usuarioDto();

		try {
			usuaResponse = dao.buscar(codigoUsuario);
		} catch (Exception e) {
			return (usuarioDto) ResponseEntity.status(HttpStatus.BAD_REQUEST);
		}

		return usuaResponse;
	}

	@GetMapping(value = "/")
	public ResponseEntity<List<usuarioDto>> Buscar() {

		List<usuarioDto> all = null;

		try {
			all = dao.all();

		} catch (Exception e) {
			return new ResponseEntity<List<usuarioDto>>(all, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<List<usuarioDto>>(all, HttpStatus.OK);
	}

	@PutMapping(value = "/", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public usuarioDto atualizar(@RequestBody usuarioDto usuario) {

		try {
			dao.atualizar(usuario);
		} catch (Exception e) {
			return (usuarioDto) ResponseEntity.status(HttpStatus.BAD_REQUEST);
		}

		return usuario;
	}

	@PostMapping(value = "/", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public HttpStatus cadastrar(@RequestBody usuarioCommand usuario) {
		usuarioDto usuaRequest = new usuarioDto();
		usuaRequest.setIdade(usuario.idade);
		usuaRequest.setNome(usuario.nome);
		usuaRequest.setLogin(usuario.login);
		usuaRequest.setSenha(usuario.senha);
		try {
			dao.cadastra(usuaRequest);
		} catch (Exception e) {
			return HttpStatus.BAD_REQUEST;
		}

		return HttpStatus.CREATED;
	}

	@DeleteMapping(value = "/{codigoUsuario}")
	public HttpStatus deletar(@PathVariable(name = "codigoUsuario", required = true) int codigoUsuario) {

		try {
			dao.deletar(codigoUsuario);
		} catch (Exception e) {
			return HttpStatus.NO_CONTENT;
		}

		return HttpStatus.OK;
	}

}
