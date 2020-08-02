package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface EmployeeDao extends CrudRepository<Employee, Integer> {
    List<Employee> retrieveEmployeeByLastName(@Param("LASTNAME") String lastName);

    @Query(
            "from Employee where lower(firstName) like :PHRASE or lastName like :PHRASE"
    )
    List<Employee> retrieveEmployeesWithNameFeaturingPhrase(@Param("PHRASE") String phrase);
}
