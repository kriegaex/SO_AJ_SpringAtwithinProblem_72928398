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

    private static final Logger log = LoggerFactory.getLogger(CustomRepositoryAnnotationAdvisor.class);

    @Pointcut("@within(com.example.accessingdatajpa.CustomRepositoryAnnotation)")
    public void annotated() {
        // nop - pointcut
    }

    @Around("annotated()")
    public Object invoke(ProceedingJoinPoint pjp) {
        return doProceed(pjp);
    }

    protected Object doProceed(ProceedingJoinPoint pjp) {
        try {
            log.info("CustomRepositoryAnnotationAspect: {}", pjp.getSignature().getName());
            return pjp.proceed();
        } catch (RuntimeException | Error ex) {
            throw ex;
        } catch (Throwable ex) {
            throw new RuntimeException(ex);
        }
    }
}
