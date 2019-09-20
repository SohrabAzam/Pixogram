package com.social.imageApp.Pixogram;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.social.imageApp.Pixogram.controllers.RegisterController;
import com.social.imageApp.Pixogram.model.User;
import com.social.imageApp.Pixogram.services.AccountService;

@RunWith(SpringRunner.class)
@WebMvcTest(value=RegisterController.class)
public class RegisterControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AccountService accountService;
	
	@Test
	public void registerUser() throws Exception
	{
		User mockUser=new User();
		mockUser.setUserId(1);
		mockUser.setUsername("sohrabazam");
		mockUser.setFirstName("Sohrab");
		mockUser.setLastName("Azam");
		mockUser.setEmail("abc@gmail.com");
		mockUser.setPassword("snowleopard");
		mockUser.setProfilePicture("image");
		mockUser.setAbout("sohrab azam");
		mockUser.setImageCount(2);
		mockUser.setVideoCount(3);
		mockUser.setFollowerCount(4);
		mockUser.setFollowingCount(5);
		
		String inputInJson=this.mapToJson(mockUser);
		System.out.println(inputInJson);
		
		String URI="/account/register";
		
		Mockito.when(accountService.registerUser(Mockito.any(User.class))).thenReturn(mockUser);
		
		RequestBuilder requestBuilder=MockMvcRequestBuilders
				.post(URI)
				.accept(MediaType.APPLICATION_JSON).content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result=mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response=result.getResponse();
		
		String outputInJson=response.getContentAsString();
		
		assertThat(outputInJson).isEqualTo(inputInJson);
	
	}
	
	@Test
	public void checkUsername() throws Exception
	{
		User mockUser1=new User();
		mockUser1.setUserId(1);
		mockUser1.setUsername("John");
		mockUser1.setFirstName("John");
		mockUser1.setLastName("Doe");
		mockUser1.setEmail("johndoe@gmail.com");
		mockUser1.setPassword("Doe123@");
		mockUser1.setProfilePicture("image");
		mockUser1.setAbout("john doe");
		mockUser1.setImageCount(2);
		mockUser1.setVideoCount(3);
		mockUser1.setFollowerCount(4);
		mockUser1.setFollowingCount(5);
		
		String expectedJson=this.mapToJson(mockUser1);
		Mockito.when(accountService.checkUserName(Mockito.anyString())).thenReturn(mockUser1);
		
		String URI="/account/check";
		
		RequestBuilder requestBuilder=MockMvcRequestBuilders
				.post(URI)
				.accept(MediaType.APPLICATION_JSON).content(expectedJson)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result=mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response=result.getResponse();
		
		String outputInJson=response.getContentAsString();
		
		assertThat(outputInJson).isEqualTo(expectedJson);
		
		
	}
	
	private String mapToJson(Object object)throws JsonProcessingException{
		ObjectMapper objectMapper=new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

}
