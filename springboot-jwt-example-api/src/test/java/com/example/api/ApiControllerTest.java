package com.example.api;

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
import org.springframework.http.HttpHeaders;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
public class ApiControllerTest {
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
	}	
	
	@Test
	public void 엑세스토큰으로_접속() throws Exception {
		String accessToken = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsic3ByaW5nLWJvb3QtYXBwbGljYXRpb24iXSwidXNlcl9uYW1lIjoidXNlciIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdLCJleHAiOjE0ODkxMTQzODIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJqdGkiOiJlZmQ5N2IyMi05YThjLTQ2ODQtODUxNy0xNWE2NDFiMjU5NjciLCJjbGllbnRfaWQiOiJiYXIifQ.TgPWW14KHAX4nKy0mFgSE0-qxQSMTziThbeb5ltJSdRcIqVnir1GoyVlSSjErQ7j_YDZZDYxvwj_lo716AR6iHv3FS1JADXaYh1OaRrxUtytwrbSx893mfPqAJis5f06ulHL6y5NpQHi6paIB9atxVWQguiggxUMqCzx9mdOQn4drwsB7EY6_j_tOugbZOPI_-Uf5w_GzszPtm4A03z98Y4tV8bOv9CD-g4g5vU1wO0yanOitL1HLqxlgJfggM8le06rQ6cuMf2IutA0IhEHYLaGSpxD2JGatIoGdQy9RcU98UZJHLAieeiJEqhfHJuDi5cSZwul6deV66AWP4vnUQ";
		mockMvc.perform(get("/api/user")
				.header("authorization", "bearer "+accessToken))
		.andDo(print()).andExpect(status().isOk());
	}
	
	
}
