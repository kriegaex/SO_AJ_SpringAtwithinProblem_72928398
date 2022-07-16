package com.example.accessingdatajpa;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CustomRepositoryAnnotationAspect {

    private static final Logger log = LoggerFactory.getLogger(CustomRepositoryAnnotationAspect.class);

    @Pointcut("execution(* com.example.tlw.CustomerRepositoryImpl.*(..))")
    public void impl() {
        // nop - pointcut
    }

    @Pointcut("execution(* (@com.example.accessingdatajpa.CustomRepositoryAnnotation *..*).*(..))")
    public void annotated() {
        // nop - pointcut
    }

    @Around("annotated()")
    public Object invoke(ProceedingJoinPoint pjp) throws Throwable {
        return doProceed(pjp);
    }

    protected Object doProceed(ProceedingJoinPoint pjp) throws Throwable {
        log.info("CustomRepositoryAnnotationAspect: {}", pjp.getSignature().getName());
        return pjp.proceed();
    }
}
