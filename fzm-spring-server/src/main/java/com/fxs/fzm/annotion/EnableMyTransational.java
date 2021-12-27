package com.fxs.fzm.annotion;

import com.fxs.fzm.aspect.TransactionAspect;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(value = TransactionAspect.class)
public @interface EnableMyTransational {
}
