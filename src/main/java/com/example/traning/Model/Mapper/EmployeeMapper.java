package com.example.traning.Model.Mapper;

import com.example.traning.Model.DTO.EmployeeDTO;
import com.example.traning.Model.Entity.Employee;
import com.example.traning.Model.MapperCommon;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface EmployeeMapper extends MapperCommon<Employee, EmployeeDTO> {
}
