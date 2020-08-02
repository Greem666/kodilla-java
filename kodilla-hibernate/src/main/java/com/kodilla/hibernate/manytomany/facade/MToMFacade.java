package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import com.kodilla.hibernate.manytomany.facade.mapper.CompanyMapper;
import com.kodilla.hibernate.manytomany.facade.mapper.EmployeeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MToMFacade {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(MToMFacade.class);

    public List<CompanyDto> retrieveCompaniesWithNameFeaturingPhrase(String phrase) {
        LOGGER.info("Starting search for company names featuring phrase " + phrase + ".");

        List<Company> companies = companyDao.retrieveCompaniesWithNameFeaturingPhrase("%" + phrase.toLowerCase() + "%");
        if (companies.size() > 0) {
            LOGGER.info("Found " + companies.size() + " companies featuring names with phrase " + phrase + ":");
            companies.forEach(c -> LOGGER.info(c.getName()));
        } else {
            LOGGER.info("No companies featuring names with phrase " + phrase + " were found.");
        }

        return CompanyMapper.mapToListCompanyDto(companies);
    }

    public List<EmployeeDto> retrieveEmployeesWithNameFeaturingPhrase(String phrase) {
        LOGGER.info("Starting search for employee names featuring phrase " + phrase + ".");

        List<Employee> employees = employeeDao.retrieveEmployeesWithNameFeaturingPhrase("%"+phrase+"%");
        if (employees.size() > 0) {
            LOGGER.info("Found " + employees.size() + " employees featuring names with phrase " + phrase.toLowerCase() + ":");
            employees.forEach(e -> LOGGER.info(e.getFirstName() + " " + e.getLastName()));
        } else {
            LOGGER.info("No employees featuring names with phrase " + phrase + " were found.");
        }

        return EmployeeMapper.mapToListEmployeeDto(employees);
    }
}
