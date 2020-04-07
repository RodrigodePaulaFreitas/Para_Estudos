package com.estudo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.Dto.usuarioDto;

public interface usuarioRepository extends JpaRepository<usuarioDto, Long> {

}
