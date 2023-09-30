package com.innoventes.test.app.exception;

import lombok.Getter;

public class InvalidCompanyNameException extends RuntimeException {

    private static final long serialVersionUID = 763040204220054875L;

	public InvalidCompanyNameException(final String message) {
		super(message);
    }
}

