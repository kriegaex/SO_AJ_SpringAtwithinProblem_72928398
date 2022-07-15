package com.example.accessingdatajpa;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.Advised;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class CustomRepositoryAnnotationAspect {

  private static final Logger log = LoggerFactory.getLogger(CustomRepositoryAnnotationAdvisor.class);

  @Pointcut(
    "execution(* (@com.example.accessingdatajpa.CustomRepositoryAnnotation *..*).*(..))"
//    "execution(* (" +
//    "@com.example.accessingdatajpa.CustomRepositoryAnnotation " +
//    "org.springframework.data.repository.CrudRepository+" +
//    ").*(..))"
  )
  public void annotated() {
    // nop - pointcut
  }

  @Around("annotated()")
  public Object invoke(ProceedingJoinPoint pjp) {
    return doProceed(pjp);
  }

  protected Object doProceed(ProceedingJoinPoint pjp) {
    try {
      System.out.println("CustomRepositoryAnnotationAspect: " + pjp.getSignature().getName());
//      System.out.println("  Target: " + pjp.getTarget());
//      System.out.println("  Target class: " + pjp.getTarget().getClass());
//      System.out.println("  Advised, proxied interfaces: " + Arrays.toString(((Advised) pjp.getTarget()).getProxiedInterfaces()));
//      System.out.println("  Interfaces: " + Arrays.toString(pjp.getTarget().getClass().getInterfaces()));
      return pjp.proceed();
    }
    catch (RuntimeException | Error ex) {
      throw ex;
    }
    catch (Throwable ex) {
      throw new RuntimeException(ex);
    }
  }
}
