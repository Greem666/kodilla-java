package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void testSaveManyToMany() {
        // Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarkson = new Employee("Stephanie", "Clarkson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarkson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);

        stephanieClarkson.getCompanies().add(dataMaesters);

        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        // When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();

        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();

        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        // Then
        Assert.assertNotEquals(0, softwareMachineId);
        Assert.assertNotEquals(0, dataMaestersId);
        Assert.assertNotEquals(0, greyMatterId);


        // Clean-up
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            // Nothing
        }
    }

    @Test
    public void testNamedQueriesDataRetrieval() {
        // Given
        Employee employee1 = new Employee("John", "Smith");
        Employee employee2 = new Employee("Stephanie", "Smith");
        Employee employee3 = new Employee("Linda", "Kovalsky");

        Company company1 = new Company("Software Machine");
        Company company2 = new Company("Data Maesters");
        Company company3 = new Company("Data Matter");

        employee1.getCompanies().add(company1);
        employee1.getCompanies().add(company2);
        employee2.getCompanies().add(company2);
        employee3.getCompanies().add(company3);

        company1.getEmployees().add(employee1);
        company2.getEmployees().add(employee1);
        company2.getEmployees().add(employee2);
        company3.getEmployees().add(employee3);

        companyDao.save(company1);
        int company1Id = company1.getId();

        companyDao.save(company2);
        int company2Id = company2.getId();

        companyDao.save(company3);
        int company3Id = company3.getId();

        // When
        List<Employee> employeesWithSmithLastName = employeeDao.retrieveEmployeeByLastName("Smith");
        List<Company> companiesStartingWithDat = companyDao.retrieveCompaniesWithNameStartingWith("Dat");

        // Then
        Assert.assertEquals(2, employeesWithSmithLastName.size());
        Assert.assertEquals(2, companiesStartingWithDat.size());


        // Clean-up
        try {
            companyDao.deleteById(company1Id);
            companyDao.deleteById(company2Id);
            companyDao.deleteById(company3Id);
        } catch (Exception e) {
            // Nothing
        }
    }
}
