package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MtoMFacadeTestSuite {
    @Autowired
    private MToMFacade facade;
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void testCompanySearchByPhrase() {
        // Given
        Company company1 = new Company("Can into space");
        Company company2 = new Company("Can into roads");
        Company company3 = new Company("Can into water");
        Company company4 = new Company("Can into air");

        companyDao.saveAll(Arrays.asList(company1, company2, company3, company4));

        int company1Id = company1.getId();
        int company2Id = company2.getId();
        int company3Id = company3.getId();
        int company4Id = company4.getId();

        // When
        List<CompanyDto> canCompanies = facade.retrieveCompaniesWithNameFeaturingPhrase("Can");
        List<CompanyDto> intoCompanies = facade.retrieveCompaniesWithNameFeaturingPhrase("into");
        List<CompanyDto> spaceCompanies = facade.retrieveCompaniesWithNameFeaturingPhrase("space");
        List<CompanyDto> roadCompanies = facade.retrieveCompaniesWithNameFeaturingPhrase("road");
        List<CompanyDto> waterCompanies = facade.retrieveCompaniesWithNameFeaturingPhrase("water");
        List<CompanyDto> airCompanies = facade.retrieveCompaniesWithNameFeaturingPhrase("air");
        List<CompanyDto> miscCompanies = facade.retrieveCompaniesWithNameFeaturingPhrase("misc");

        List<CompanyDto> canCompaniesCaseInsensitive = facade.retrieveCompaniesWithNameFeaturingPhrase("can");

        // Then
        Assert.assertEquals(4, canCompanies.size());
        Assert.assertEquals(4, intoCompanies.size());
        Assert.assertEquals(1, spaceCompanies.size());
        Assert.assertEquals(1, roadCompanies.size());
        Assert.assertEquals(1, waterCompanies.size());
        Assert.assertEquals(1, airCompanies.size());
        Assert.assertEquals(0, miscCompanies.size());

        Assert.assertEquals(4, canCompaniesCaseInsensitive.size());

        // CleanUp
        for (int companyId: Arrays.asList(company1Id, company2Id, company3Id, company4Id)) {
            companyDao.deleteById(companyId);
        }
    }

    @Test
    public void testEmployeeSearchByPhrase() {
        // Given
        Employee employee1 = new Employee("Jack", "Smith");
        Employee employee2 = new Employee("Jack", "Durden");
        Employee employee3 = new Employee("Matt", "Green");
        Employee employee4 = new Employee("Emily", "Green");

        employeeDao.saveAll(Arrays.asList(employee1, employee2, employee3, employee4));

        int employee1Id = employee1.getId();
        int employee2Id = employee2.getId();
        int employee3Id = employee3.getId();
        int employee4Id = employee4.getId();

        // When
        List<EmployeeDto> jackEmployees = facade.retrieveEmployeesWithNameFeaturingPhrase("Jack");
        List<EmployeeDto> greenEmployees = facade.retrieveEmployeesWithNameFeaturingPhrase("Green");
        List<EmployeeDto> smithEmployees = facade.retrieveEmployeesWithNameFeaturingPhrase("Smith");
        List<EmployeeDto> durdenEmployees = facade.retrieveEmployeesWithNameFeaturingPhrase("Durden");
        List<EmployeeDto> mattEmployees = facade.retrieveEmployeesWithNameFeaturingPhrase("Matt");
        List<EmployeeDto> emilyEmployees = facade.retrieveEmployeesWithNameFeaturingPhrase("Emily");
        List<EmployeeDto> miscEmployees = facade.retrieveEmployeesWithNameFeaturingPhrase("misc");

        List<EmployeeDto> jackEmployeesCaseInsensitive = facade.retrieveEmployeesWithNameFeaturingPhrase("jack");
        List<EmployeeDto> greenEmployeesCaseInsensitive = facade.retrieveEmployeesWithNameFeaturingPhrase("green");

        // Then
        Assert.assertEquals(2, jackEmployees.size());
        Assert.assertEquals(2, greenEmployees.size());
        Assert.assertEquals(1, smithEmployees.size());
        Assert.assertEquals(1, durdenEmployees.size());
        Assert.assertEquals(1, mattEmployees.size());
        Assert.assertEquals(1, emilyEmployees.size());
        Assert.assertEquals(0, miscEmployees.size());

        Assert.assertEquals(2, jackEmployeesCaseInsensitive.size());
        Assert.assertEquals(2, greenEmployeesCaseInsensitive.size());

        // CleanUp
        for (int employeeId: Arrays.asList(employee1Id, employee2Id, employee3Id, employee4Id)) {
            employeeDao.deleteById(employeeId);
        }
    }
}
