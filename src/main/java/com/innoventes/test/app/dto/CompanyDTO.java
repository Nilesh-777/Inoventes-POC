package com.innoventes.test.app.dto;

import com.innoventes.test.app.validator.annotations.EvenNumberOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CompanyDTO {

	private Long id;

	@NotEmpty(message = "Company name cannot be null or empty")
	@Size(min = 5, message = "Company name must be at least 5 characters long")
	private String companyName;

	private String companyCode;

	@NotEmpty
	@Email
	private String email;

	@EvenNumberOrZero(message = "Strength should be even.")
	private Integer strength;

	private String webSiteURL;

	private LocalDateTime cretedDate;
}
