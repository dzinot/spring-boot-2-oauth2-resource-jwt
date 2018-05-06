package com.kristijangeorgiev.resource.util;

import java.util.Map;

import org.springframework.boot.autoconfigure.security.oauth2.resource.JwtAccessTokenConverterConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;

import com.kristijangeorgiev.resource.model.OAuth2UserDetails;

/**
 * 
 * @author Kristijan Georgiev
 *
 */
@Component
public class CustomAccessTokenConverter extends DefaultAccessTokenConverter
		implements JwtAccessTokenConverterConfigurer {

	@Override
	public void configure(JwtAccessTokenConverter converter) {
		converter.setAccessTokenConverter(this);
	}

	@Override
	public OAuth2Authentication extractAuthentication(Map<String, ?> map) {
		OAuth2Authentication auth = super.extractAuthentication(map);
		OAuth2UserDetails userDetails = new OAuth2UserDetails();

		userDetails.setEmail(map.get("email").toString());

		auth.setDetails(userDetails);

		return auth;
	}

}
