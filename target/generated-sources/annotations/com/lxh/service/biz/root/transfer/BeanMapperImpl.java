package com.lxh.service.biz.root.transfer;

import com.lxh.service.biz.root.dto.EmployeeDto;
import com.lxh.service.biz.root.entity.Employee;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-11T19:06:50+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_45 (Oracle Corporation)"
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
