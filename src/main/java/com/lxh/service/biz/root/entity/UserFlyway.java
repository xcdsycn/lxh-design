package com.lxh.service.biz.root.entity;

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
public class UserFlyway extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * ??
     */
    private String name;

    /**
     * ??
     */
    private Integer age;


}
