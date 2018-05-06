package com.kristijangeorgiev.resource.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Kristijan Georgiev
 *
 */
@Data
@Component
@NoArgsConstructor
public class OAuth2UserDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	private String email;

}
