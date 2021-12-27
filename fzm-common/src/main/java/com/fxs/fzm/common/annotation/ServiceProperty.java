package com.fxs.fzm.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Title: 业务属性配置信息
 * Description:
 * Copyright: Copyright (c) 2019-09-27 16:42:09
 * Company: 北京福富软件技术股份有限公司福州分公司
 * @author: wj
 */
@Target(ElementType.TYPE)
@Retention(RUNTIME)
@Documented
public @interface ServiceProperty {
    public String model() default "";

    public boolean local() default false;

    public boolean remote() default false;
}
