package com.example.accessingdatajpa;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

//@Component
public class CustomRepositoryAnnotationAdvisor extends AbstractPointcutAdvisor {

    private static final Logger log = LoggerFactory.getLogger(CustomRepositoryAnnotationAdvisor.class);

    private final Advice advice;

    private final Pointcut pointcut;

    public CustomRepositoryAnnotationAdvisor() {
        this.advice = new MethodInterceptor() {
            @Nullable
            @Override
            public Object invoke(@NonNull MethodInvocation invocation) throws Throwable {
              System.out.println("DemoAnnotationAdvisor: " + invocation.getMethod().getName());
                return invocation.proceed();
            }
        };
        this.pointcut = new AnnotationMatchingPointcut(CustomRepositoryAnnotation.class, null, true);
    }

    @Override
    public Pointcut getPointcut() {
        return pointcut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

}
