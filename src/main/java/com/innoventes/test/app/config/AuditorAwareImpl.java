package com.innoventes.test.app.config;

import java.util.Optional;

import lombok.val;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		// Set a hard-coded user as a fallback option
		val user = "system";
		return Optional.of(user);
	}
}
