package com.estudo.Dao;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.estudo.Dto.usuarioDto;

@Component
public class DatabaseLoader implements CommandLineRunner {

	@Autowired
	private usuarioRepository repository;

	@Override
	public void run(String... args) throws Exception {
		for (int x = 1; x <= 10; x++) {
			Random r = new Random();
			usuarioDto usuarioDto = new usuarioDto();
			usuarioDto.setIdade(r.nextInt(10) + 30);
			usuarioDto.setLogin("Padrão" + x);
			usuarioDto.setNome("Rodrigo" + x);
			usuarioDto.setSenha("1234" + x);
			repository.save(Arrays.asList(usuarioDto));
		}

	}

}
