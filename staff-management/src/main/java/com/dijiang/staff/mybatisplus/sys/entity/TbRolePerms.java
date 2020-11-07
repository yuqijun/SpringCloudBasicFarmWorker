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
public class TbRolePerms implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer rId;

    private Integer pId;


}
