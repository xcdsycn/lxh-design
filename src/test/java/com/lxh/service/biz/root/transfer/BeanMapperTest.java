package com.lxh.service.biz.root.transfer;

import com.lxh.ApplicationTests;
import com.lxh.service.biz.root.entity.Employee;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BeanMapperTest extends ApplicationTests {

	@Autowired
	private BeanMapper beanMapper;

	public BeanMapperTest() {
	}

	@Test
	public void createDeployment() {
		Employee employee = new Employee();
		employee.setName("lxh");
		employee.setRole("leader for all");
		employee.setSalary(9999999999L);
		System.out.println(beanMapper.employeeToEmployeeDTO(employee).toString());
	}

}
