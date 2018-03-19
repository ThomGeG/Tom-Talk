package main.java.configuration;

import org.springframework.boot.context.properties.NestedConfigurationProperty;

import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;

public class OAuthClientResources {
	
	@NestedConfigurationProperty
	private AuthorizationCodeResourceDetails client = new AuthorizationCodeResourceDetails();
	
	@NestedConfigurationProperty
	private ResourceServerProperties resource = new ResourceServerProperties();
	
	public AuthorizationCodeResourceDetails getClient() {
		return client;
	}
	
	public ResourceServerProperties getResource() {
		return resource;
	}

}
