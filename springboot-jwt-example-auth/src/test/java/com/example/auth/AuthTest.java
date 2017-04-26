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
	 * 관리자 암호화할 경우 사용 (임시)
	 */
	@Test
	public void test() {
		BCryptPasswordEncoder bcr = new BCryptPasswordEncoder();
		String result = bcr.encode("1234");  
		System.out.println("관리자 암호 === " + result);
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
		//curl -u client1:client1pwd http://localhost:8081/oauth/token -d  "grant_type=password&username=user&password=test"
		//curl -F "grant_type=password" -F "scope=read write" "http://client1:client1pwd@localhost:8081/oauth/token"
		//curl -u client1:client1pwd http://localhost:8081/oauth/token -d  "grant_type=password"
		//curl -F "grant_type=authorization_code" -F "client_id=client2" -F "scope=read" "http://localhost:8081/oauth/token"
		//curl -u client1:client1pwd http://localhost:8081/oauth/token -d "grant_type=client_credentials"
		//curl -F "grant_type=client_credentials" -F "scope=read" "http://client2:client2pwd@localhost:8081/oauth/token"
		//curl -u client1:client1pwd http://localhost:8081/oauth/token -d  "grant_type=client_credentials"

	}
	
	@Ignore
	@Test
	public void 엑세스토큰_접근() throws Exception {
		String accessToken = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE0OTE4MzY4NTksInVzZXJfbmFtZSI6InVzZXIiLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwianRpIjoiNjhmNGUyMGYtNmY2OS00YTFiLWI2MjItNjNmYjA2NjA2MDY0IiwiY2xpZW50X2lkIjoiY2xpZW50MiIsInNjb3BlIjpbInJlYWQiXX0.ZatMxWztaiXZ2F4WQXOvvhnWvuH1RYEZf-ovbjEuf5Ghig6uror-kKRsxBZuaywVciMe93yaJcItzPhYZbA0CV6nQKIwPq9opbgaU7nTFSLxK0v1_C-jMDt97hoQ8bAmf1DI5PlYc7tK8Nozicrb89xtPnAJwb7ITNI64g99FgokW68W0fKe7VKEzzBUqblc_IOPcs3zX_L8SeMY4qPtRj8bvk4Yc38FDQlqFSQQqJLA_hMPI9tDBBztTcIHfxrgcZ_bzZRf7u2-T4RZUx4iclmeuLGF0089GVE8IMXETlrAwEo9wpftkfOYnx8Lpo5UDiTnXxMtky_q-L6s3DBGHQ";
		
		mockMvc.perform(get("/api/hello")
								.header("authorization", "bearer "+accessToken))
		.andDo(print()).andExpect(status().isOk());
		//curl -H "authorization: bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsic3ByaW5nLWJvb3QtYXBwbGljYXRpb24iXSwidXNlcl9uYW1lIjoidXNlciIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdLCJleHAiOjE0ODkwMjQ0MjMsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJqdGkiOiIzYjBmNTk2ZC1kMTI1LTQ1MTItYTlkNy00ZjY5OWI5NzMwMzAiLCJjbGllbnRfaWQiOiJiYXIifQ.svzhiuACjxXggJOqfackvjXjjQklSlqnFqZdpF6OAQY" http://localhost:8080/simple
	}		

}
