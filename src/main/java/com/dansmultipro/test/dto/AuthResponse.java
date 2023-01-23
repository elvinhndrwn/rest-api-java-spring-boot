package com.dansmultipro.test.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private String token;

}