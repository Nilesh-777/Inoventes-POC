package com.innoventes.test.app.validator.impl;

import com.innoventes.test.app.dto.CompanyDTO;
import com.innoventes.test.app.exception.InvalidCompanyNameException;
import com.innoventes.test.app.validator.CompanyValidator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class CompanyValidatorImpl implements CompanyValidator {

    @Override
    public void validate(final CompanyDTO companyDTO) {
        validateCompanyName(companyDTO.getCompanyName());
        validateCompanyStrength(companyDTO.getStrength());
        //...
    }

    private void validateCompanyName(final String companyName) {
        if (StringUtils.isBlank(companyName)) {
            throw new InvalidCompanyNameException("Company name should not be empty");
        } else if (companyName.length() < 5) {
            throw new InvalidCompanyNameException("Company name should be greater than or equal to 5");
        }
    }

    private void validateCompanyStrength(Integer strength) {

    }


}
