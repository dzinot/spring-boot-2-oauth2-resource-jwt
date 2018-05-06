package com.kristijangeorgiev.resource.controller;

import java.security.Principal;
import java.util.UUID;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kristijangeorgiev.resource.model.OAuth2UserDetails;

/**
 * 
 * @author Kristijan Georgiev
 *
 */
@RestController
public class ResourceController {

	@GetMapping("/secured")
	@PreAuthorize("hasAuthority('role_admin')")
	public String secured(OAuth2UserDetails oAuth2UserDetails, Principal principal) {
		return principal.getName() + " " + oAuth2UserDetails.getEmail();
	}

	@GetMapping("/resource")
	public String resource() {
		return UUID.randomUUID().toString();
	}
}
