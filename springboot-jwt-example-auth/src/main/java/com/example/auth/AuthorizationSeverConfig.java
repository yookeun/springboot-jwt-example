package com.example.auth;

import java.security.KeyPair;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;


@Configuration
@EnableAuthorizationServer
public class AuthorizationSeverConfig extends AuthorizationServerConfigurerAdapter{
	
	@Value("${resouce.id:spring-boot-application}")
	private String resourceId;
	
	@Value("${access_token.validity_period:3600}")
	int accessTokenValiditySeconds = 3600;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }
	
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		//converter.setSigningKey("secret");
		KeyPair keyPair = new KeyStoreKeyFactory(new ClassPathResource("server.jks"), "passtwo".toCharArray())
				.getKeyPair("auth", "passone".toCharArray());
		converter.setKeyPair(keyPair);
		
		
		return converter;
	}
	
	@Bean
	@Primary
	public DefaultTokenServices tokenService() {
		DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
		defaultTokenServices.setTokenStore(tokenStore());
		defaultTokenServices.setSupportRefreshToken(true);
		return defaultTokenServices;
	}
	

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager).accessTokenConverter(accessTokenConverter());
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {		
		clients.inMemory()
				.withClient("bar").secret("foo")		
				.authorizedGrantTypes("password")
				.authorities("ROLE_USER")
				.scopes("read", "write")
				.resourceIds(resourceId)
				.accessTokenValiditySeconds(accessTokenValiditySeconds);
			
	}
	
	
	
}
