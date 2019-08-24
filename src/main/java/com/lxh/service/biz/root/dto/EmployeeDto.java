package com.lxh.service.biz.root.dto;

import com.lxh.service.biz.root.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author lxh
 * @since 2019-08-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class EmployeeDto extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String name;

	private String role;

	private Long salary;

}
