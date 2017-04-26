package com.example.api;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
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
		//String accessToken = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsic3ByaW5nLWJvb3QtYXBwbGljYXRpb24iXSwidXNlcl9uYW1lIjoidXNlciIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdLCJleHAiOjE0ODkxMTQzODIsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJqdGkiOiJlZmQ5N2IyMi05YThjLTQ2ODQtODUxNy0xNWE2NDFiMjU5NjciLCJjbGllbnRfaWQiOiJiYXIifQ.TgPWW14KHAX4nKy0mFgSE0-qxQSMTziThbeb5ltJSdRcIqVnir1GoyVlSSjErQ7j_YDZZDYxvwj_lo716AR6iHv3FS1JADXaYh1OaRrxUtytwrbSx893mfPqAJis5f06ulHL6y5NpQHi6paIB9atxVWQguiggxUMqCzx9mdOQn4drwsB7EY6_j_tOugbZOPI_-Uf5w_GzszPtm4A03z98Y4tV8bOv9CD-g4g5vU1wO0yanOitL1HLqxlgJfggM8le06rQ6cuMf2IutA0IhEHYLaGSpxD2JGatIoGdQy9RcU98UZJHLAieeiJEqhfHJuDi5cSZwul6deV66AWP4vnUQ";
		String accessToken = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE0OTE4MzY4NTksInVzZXJfbmFtZSI6InVzZXIiLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwianRpIjoiNjhmNGUyMGYtNmY2OS00YTFiLWI2MjItNjNmYjA2NjA2MDY0IiwiY2xpZW50X2lkIjoiY2xpZW50MiIsInNjb3BlIjpbInJlYWQiXX0.ZatMxWztaiXZ2F4WQXOvvhnWvuH1RYEZf-ovbjEuf5Ghig6uror-kKRsxBZuaywVciMe93yaJcItzPhYZbA0CV6nQKIwPq9opbgaU7nTFSLxK0v1_C-jMDt97hoQ8bAmf1DI5PlYc7tK8Nozicrb89xtPnAJwb7ITNI64g99FgokW68W0fKe7VKEzzBUqblc_IOPcs3zX_L8SeMY4qPtRj8bvk4Yc38FDQlqFSQQqJLA_hMPI9tDBBztTcIHfxrgcZ_bzZRf7u2-T4RZUx4iclmeuLGF0089GVE8IMXETlrAwEo9wpftkfOYnx8Lpo5UDiTnXxMtky_q-L6s3DBGHQ";
		mockMvc.perform(get("/api/user")
				.header("authorization", "bearer "+accessToken))
		.andDo(print()).andExpect(status().isOk());
	}
	
	
}
