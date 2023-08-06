package com.example.demojpa_join.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggerAspect {

    @Around("@annotation(CustomLogger)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

        log.warn("Begin executing");
        Object returnObj =  joinPoint.proceed();
        log.warn("Finish executing");

        return returnObj;
    }

    @AfterThrowing(value = "@annotation(CustomLogger)",throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex) {
        //joinPoint
        log.error(joinPoint.getSignature()+ " An exception happened due to : "+ex.getMessage());
    }
}
