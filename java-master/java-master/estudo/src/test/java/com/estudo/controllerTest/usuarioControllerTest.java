package com.estudo.controllerTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.estudo.Dao.usuarioDao;
import com.estudo.Dao.usuarioRepository;
import com.estudo.Dto.usuarioDto;
import com.estudo.controller.usuarioController;

@RunWith(SpringRunner.class)
@WebMvcTest(value = usuarioController.class, secure = false)
public class usuarioControllerTest {
	
	 @Autowired
	  private MockMvc mockMvc;
	 @MockBean
	   private usuarioDao dao;
	 @MockBean
	   private usuarioRepository repository;

	@Test
	public void testGetController() throws Exception  {
		
		usuarioDto dto = new usuarioDto("badaui",33,"login","senha");
		Mockito.when(dao.buscar(Mockito.anyLong())).thenReturn(dto);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/usuarios/8")
                .header("Origin", "*")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());

        String expected = "{\"nome\": \"badaui\",  \"idade\": 33,  \"login\": \"login\",  \"senha\": \"senha\"}";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void testPostController() throws Exception  {
		usuarioDto dto = new usuarioDto("badaui",33,"login","senha");
		String body = "{\"nome\": \"badaui\",  \"idade\": 33,  \"login\": \"login\",  \"senha\": \"senha\"}";
		usuarioDto mock = mock(usuarioDto.class);
		Mockito.when(dao.cadastra(mock)).thenReturn(dto);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/usuarios/")
                .accept(MediaType.APPLICATION_JSON)
                .content(body)
                .header("Origin", "*")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void testPutController() throws Exception  {
		usuarioDto dto = new usuarioDto("badaui",33,"login","senha");
		String body = "{\"nome\": \"badaui\",  \"idade\": 33,  \"login\": \"login\",  \"senha\": \"senha\"}";
		usuarioDto mock = mock(usuarioDto.class);
		Mockito.when(dao.atualizar(mock)).thenReturn(dto);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/usuarios/")
                .accept(MediaType.APPLICATION_JSON)
                .content(body)
                .header("Origin", "*")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void testDeleteController() throws Exception  {
		
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/usuarios/5")
                .accept(MediaType.APPLICATION_JSON)
                .header("Origin", "*");

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void testAllController() throws Exception  {
		
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/usuarios/")
                .accept(MediaType.APPLICATION_JSON)
                .header("Origin", "*");

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	


}
