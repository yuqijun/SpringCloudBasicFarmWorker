package com.dijiang.staff.mybatisplus.sys.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2020-11-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class StaffAndRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 表主键
     */
    private Long id;

    /**
     * 员工id
     */
    private Long staffId;

    /**
     * 角色id
     */
    private Long roleId;


}
