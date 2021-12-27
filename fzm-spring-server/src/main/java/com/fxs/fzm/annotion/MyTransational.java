package com.fxs.fzm.annotion;

import com.fxs.fzm.enums.Propagation;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyTransational {
    public Propagation propagation() default Propagation.REQUIRED;
}
