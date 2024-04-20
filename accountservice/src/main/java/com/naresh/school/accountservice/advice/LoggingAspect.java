package com.naresh.school.accountservice.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {


    @Pointcut("execution(public * com.naresh.school.accountservice..*.*(..))")
    private void loggingPointCut(){

    }

    @Around(value = "loggingPointCut()")
    public Object aroundAspect(ProceedingJoinPoint pJoinPoint){
        Logger logger = LoggerFactory.getLogger(pJoinPoint.getSignature().getDeclaringType());
        try {
            Signature befoureSignature = pJoinPoint.getSignature();
            logger.info("Before - Method {} ",befoureSignature.getName() );
            return pJoinPoint.proceed();
        } catch (Throwable e) {
            logger.error("Error - Method {} ",e.getMessage() );
        }finally{
            Signature afterSignature = pJoinPoint.getSignature();
            logger.info("After - Method {} ",afterSignature.getName() );
        }
        return null;
    }

}
