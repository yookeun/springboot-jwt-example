package com.example.auth;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
public class AuthTest {
	
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
	}	
	
	/**
	 * 비밀번호암호화
	 */
	@Test
	public void 비밀번호_암호화() {
		BCryptPasswordEncoder bcr = new BCryptPasswordEncoder();
		String result = bcr.encode("1234");  
		System.out.println("암호 === " + result);
		//System.out.println(result.length());
	}

	//@Ignore
	@Test
	public void 엑세스토큰_받기() throws Exception {
		mockMvc.perform(post("/oauth/token")
									.with(user("client2").password("client2pwd"))
									.param("grant_type", "password")
									.param("username", "user1")
									.param("password", "1234"))
			.andDo(print()).andExpect(status().isOk());
		//curl -u client1:client1pwd http://localhost:8081/restauth/oauth/token -d  "grant_type=password&username=user1&password=1234"
		

		/*
		 * {
	"grant_type":"password",
	"username":"user1",
	"password":"1234"
}
		 */
	}
}
