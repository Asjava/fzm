package com.fxs.fzm.security.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.fxs.fzm.common.base.BaseEntity;
import com.fxs.fzm.common.base.ICreate;
import com.fxs.fzm.common.base.IModify;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Title: 人员表实体类
 * Description:
 * Copyright: Copyright (c) 2020-09-15 22:16:47
 * Company: 北京福富软件技术股份有限公司福州分公司
 * @author: fuzm
 */
@Data
@Table(name = "tbl_cms_web_user")
public class WebUser extends BaseEntity implements ICreate, IModify, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    @Column(name = "id")
    private Long id;

    @Column(name = "uid")
    private String uid;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "login_name")
    private String loginName;

    @Column(name = "password")
    private String password;

    @Column(name = "org_id")
    private Long orgId;

    @Column(name = "dept_id")
    private Long deptId;

    @Column(name = "is_admin")
    private Integer isAdmin;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "id_num")
    private String idNum;

    @Column(name = "sex")
    private Integer sex;

    @Column(name = "age")
    private Integer age;

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

    @Column(name = "status")
    private Integer status;

    @Column(name = "job_num")
    private String jobNum;

    @Column(name = "email")
    private String email;

    @Column(name = "sort")
    private Integer sort;

    @Column(name = "is_lock")
    private Integer isLock;

    @Column(name = "login_lately_time")
    private Date loginLatelyTime;

    @Column(name = "login_num")
    private Integer loginNum;

    @Column(name = "is_super_admin")
    private String isSuperAdmin;

    @Column(name = "ret_password")
    private Integer retPassword;

    @Column(name = "res_password_time")
    private Date resPasswordTime;

    @Column(name = "jc_user_id")
    private Long jcUserId;

    @Column(name = "position_id")
    private Long positionId;

    @Transient
    private List<Role> roles;


    @Override
    public Serializable id() {
        return this.id;
    }

    @JSONField(serialize = false)
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @JSONField(serialize = false)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JSONField(serialize = false)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JSONField(serialize = false)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JSONField(serialize = false)
    @Override
    public boolean isEnabled() {
        return true;
    }
}