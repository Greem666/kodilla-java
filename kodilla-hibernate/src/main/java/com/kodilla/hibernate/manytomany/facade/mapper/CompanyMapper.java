package com.kodilla.hibernate.manytomany.facade.mapper;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.facade.CompanyDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyMapper {
    public static CompanyDto mapToCompanyDto(Company company) {
        return new CompanyDto(
          company.getId(),
          company.getName()
        );
    }

    public static List<CompanyDto> mapToListCompanyDto(List<Company> companies) {
        return companies.stream()
                .map(CompanyMapper::mapToCompanyDto)
                .collect(Collectors.toList());
    }
}
