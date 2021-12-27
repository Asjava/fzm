package com.fxs.fzm.order.bean;

import com.fxs.fzm.common.base.BaseEntity;
import com.fxs.fzm.common.base.ICreate;
import com.fxs.fzm.common.base.IModify;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Title: 实体类
 * Description:
 * Copyright: Copyright (c) 2020-09-09 10:41:51
 * Company: 北京福富软件技术股份有限公司福州分公司
 * @author: fuzm
 */
@Data
@Table(name = "tbl_fzm_order")
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "count")
    private Integer count;

    @Column(name = "money")
    private Long money;

    @Column(name = "status")
    private Integer status;


    @Override
    public Serializable id() {
        return this.id;
    }
}