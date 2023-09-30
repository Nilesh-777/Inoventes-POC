package com.innoventes.test.app.service.impl;

import com.innoventes.test.app.entity.Company;
import com.innoventes.test.app.error.ApplicationErrorCodes;
import com.innoventes.test.app.exception.ResourceNotFoundException;
import com.innoventes.test.app.exception.ValidationException;
import com.innoventes.test.app.repository.CompanyRepository;
import com.innoventes.test.app.service.CompanyService;
import com.innoventes.test.app.util.ServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private ServiceHelper serviceHelper;

    @Override
    public List<Company> getAllCompanies() {
        ArrayList<Company> companyList = new ArrayList<Company>();
        companyRepository.findAll().forEach(companyList::add);
        return companyList;
    }

    @Override
    public Company getCompanyById(final Long id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Company for given id not found" + id,
                        ApplicationErrorCodes.COMPANY_NOT_FOUND));
    }

    @Override
    public Company addCompany(Company company) throws ValidationException {
        return companyRepository.save(company);
    }

    @Override
    public Company updateCompany(Long id, Company company) throws ValidationException {
        Company existingCompanyRecord = companyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format(serviceHelper.getLocalizedMessage(ApplicationErrorCodes.COMPANY_NOT_FOUND), id),
                        ApplicationErrorCodes.COMPANY_NOT_FOUND));
        company.setId(existingCompanyRecord.getId());
        return companyRepository.save(company);
    }

    @Override
    public void deleteCompany(Long id) {
        Company existingCompanyRecord = companyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format(serviceHelper.getLocalizedMessage(ApplicationErrorCodes.COMPANY_NOT_FOUND), id),
                        ApplicationErrorCodes.COMPANY_NOT_FOUND));
        companyRepository.deleteById(existingCompanyRecord.getId());
    }
}
