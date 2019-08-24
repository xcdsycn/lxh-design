package com.lxh.service.biz.root.service.impl;

import com.lxh.service.biz.root.entity.Employee;
import com.lxh.service.biz.root.mapper.EmployeeMapper;
import com.lxh.service.biz.root.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lxh
 * @since 2019-08-24
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
