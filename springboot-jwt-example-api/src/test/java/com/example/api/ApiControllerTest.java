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
		String accessToken = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE0OTU0NzIyOTMsInVzZXJfbmFtZSI6InVzZXIxIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImp0aSI6IjI3OGUxYzIyLTFmY2UtNDk4NC1iYmE1LWM5ZmM3MTEwNTZhYiIsImNsaWVudF9pZCI6ImNsaWVudDIiLCJzY29wZSI6WyJyZWFkIl19.dZSBt2tzrGlNcaz4lqRTX69h90-qFwTgmEHjZm9MvRtRqCMiQRKM13GtLiiraoVen2f6zpQc45_umlPP9JBQ7jpKiTgDcjH0ENBWNEch4JnfSGybWGDePv68BpN6rKhME6cfN1BIWn3E8PstND1Yh_LFB69wuP5k1Yh04OJWhHC9YIv8W1U8CcJFGdZasf-ksTvz_xb_8fe-mujDH0m54LoP1Av0oiZq_jdgMDRJLWs_nB2ilUtgAPhc-dvchjGA1sIIo6nL63Wai777FJyTMpWEjjUEwyCGsLbhUZjBytP2AT6rY9hH11tpWG4Ay76LVW1tsB86XAoNpLhftrQYSA";
		mockMvc.perform(get("/api/user")
				.header("authorization", "bearer "+accessToken))
		.andDo(print()).andExpect(status().isOk());
		//curl -H "authorization: bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE0OTMyMDgzMzUsInVzZXJfbmFtZSI6InVzZXIxIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImp0aSI6ImM2OTZlODRhLTNjZGYtNGFjNC04YzJkLWNlODAzNjMxODUwYSIsImNsaWVudF9pZCI6ImNsaWVudDEiLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXX0.EeQ0cCQF5hPEpuY2c95Bw7zdGP0tBCt3BBBwlh83YEIvexI82oUoHUxxDHRrsVCSWD5vTfahqY_FsUyhI5yoFkXUpUMarXDmIWz-5Ww_XPyzAoLIqmcjw-WCR9aJDn36w9ylz7-vXXmPnCXpxUpETBmgqKmJBF-6Yi-THi4OPs7kP0eZ_pyUB5pZSIO6pnH0E2kbqZfjEgoQ84AZJD2oXCjFXFO48HaMOLVU8nDTI1VnwM_5f5BfsA_UzJH_ktD8lUpARBvVkRSQVRU5Ek4p8FPZHNhPfxJlilDwaN4BSjpIfCQg0NMbzqQ4s7twlRr2Yi3gGCykMJlkzTz2LPNwtQ" http://localhost:8080/api/user
		
		
	}
	
	
}
