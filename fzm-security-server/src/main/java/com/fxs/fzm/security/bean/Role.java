package com.fxs.fzm.security.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.fxs.fzm.common.base.BaseEntity;
import com.fxs.fzm.common.base.ICreate;
import com.fxs.fzm.common.base.IModify;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Title: 角色表实体类
 * Description:
 * Copyright: Copyright (c) 2020-09-15 22:16:48
 * Company: 北京福富软件技术股份有限公司福州分公司
 * @author: fuzm
 */
@Data
@Table(name = "tbl_cms_role")
public class Role extends BaseEntity implements ICreate, IModify, GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    @Column(name = "id")
    private Long id;

    @Column(name = "dept_id")
    private Long deptId;

    @Column(name = "name")
    private String name;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "create_user_id")
    private Long createUserId;

    @Column(name = "modify_time")
    private Date modifyTime;

    @Column(name = "modify_user_id")
    private Long modifyUserId;

    @Column(name = "is_delete")
    private Integer isDelete;

    @Column(name = "jc_role_id")
    private Long jcRoleId;


    @Override
    public Serializable id() {
        return this.id;
    }

    @JSONField(serialize = false)
    @Override
    public String getAuthority() {
        return name;
    }
}