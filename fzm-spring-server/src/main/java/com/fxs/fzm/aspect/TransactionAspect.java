package com.fxs.fzm.aspect;

import com.fxs.fzm.annotion.MyTransational;
import com.fxs.fzm.bean.Transaction;
import com.fxs.fzm.enums.Propagation;
import com.fxs.fzm.util.TransactionUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

@Aspect
public class TransactionAspect {

    @Around(value = "@annotation(com.fxs.fzm.annotion.MyTransational)")
    public Object transationEnhance(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature sig = joinPoint.getSignature();
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalAccessException("连接点只能用于方法上");
        }
        MethodSignature msig = (MethodSignature) sig;
        Object target = joinPoint.getTarget();
        System.out.println("进入" + target.getClass().getName() + ":" + msig.getName());
        Method method = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
        MyTransational annotation = method.getAnnotation(MyTransational.class);
        Propagation propagation = annotation.propagation();
        Transaction transaction = null;
        if (propagation.equals(Propagation.REQUIRED)) {
            transaction = TransactionUtil.requiredTransation();
            if (!transaction.isOpen()) {
                transaction.setName(msig.getName());
                transaction.begin();
            }
        } else {
            transaction = TransactionUtil.newTransaction();
            transaction.setName(msig.getName());
            transaction.begin();
        }

        Object returnValue = null;
        try {
            returnValue = joinPoint.proceed();
        } catch (Throwable throwable) {
            transaction.rollback();
            throw new RuntimeException("发生异常，事物回滚");
        }

        if (transaction.getCount() == 0) {
            transaction.commit();
            TransactionUtil.destoryTransaction();
        } else {
            transaction.decreaseCount();
        }
        return returnValue;
    }

}
