package com.lxh.service.biz.root.transfer;

import com.lxh.service.biz.root.dto.EmployeeDto;
import com.lxh.service.biz.root.entity.Employee;
import org.mapstruct.Mapper;

/**
 * @author lxh
 */
@Mapper(componentModel = "spring")
public interface BeanMapper {

	EmployeeDto employeeToEmployeeDTO(Employee employee);

}
