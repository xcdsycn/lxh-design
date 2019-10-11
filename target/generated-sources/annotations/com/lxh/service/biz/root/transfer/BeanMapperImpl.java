package com.lxh.service.biz.root.transfer;

import com.lxh.service.biz.root.dto.EmployeeDto;
import com.lxh.service.biz.root.entity.Employee;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 1.8.0_221 (Oracle Corporation)"
)
@Component
public class BeanMapperImpl implements BeanMapper {

    @Override
    public EmployeeDto employeeToEmployeeDTO(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setName( employee.getName() );
        employeeDto.setRole( employee.getRole() );
        employeeDto.setSalary( employee.getSalary() );

        return employeeDto;
    }
}
