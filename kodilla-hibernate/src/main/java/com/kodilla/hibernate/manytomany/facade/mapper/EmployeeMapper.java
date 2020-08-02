package com.kodilla.hibernate.manytomany.facade.mapper;

import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.facade.EmployeeDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName()
        );
    }

    public static List<EmployeeDto> mapToListEmployeeDto(List<Employee> employees) {
        return employees.stream()
                .map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }
}
