package com.estudo.DtoTest;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.mockito.Mockito.*;

import com.estudo.Dto.usuarioDto;

public class usuarioDtoTest {

	private usuarioDto dto;
	@Test
	public void test()  {
		dto = mock(usuarioDto.class);
		assertNotNull(dto);
	}

}
