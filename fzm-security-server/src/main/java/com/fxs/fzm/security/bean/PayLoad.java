package com.fxs.fzm.security.bean;

import lombok.Data;

import java.util.Date;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2020-09-13
 * Company: 北京福富软件技术股份有限公司福州分公司
 *
 * @author: fuzhm
 */
@Data
public class PayLoad<T> {
    private String id;

    private T userInfo;

    private Date expiration;

}
