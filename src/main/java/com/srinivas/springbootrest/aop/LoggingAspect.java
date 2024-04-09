package com.srinivas.springbootrest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    /*
    We need to specify arguments in the execution statement
    Return type, package name and class, method name, parameters
    This execution statement is called "Pointcut Expression"
    */

    /*
    1. @Before, @After are the advices which define the action taken at a particular join point
    2. Join Point is the specific point in the execution of a program. It is used to get specific behaviors at specific
    time such as getName of the method called.

    */
    @Before("execution(* com.srinivas.springbootrest.service.JobService.getAllJobs(..))")
    public void logMethodCall(JoinPoint jp){
        LOGGER.info("Method Called "+ jp.getSignature().getName());
    }

    @After("execution(* com.srinivas.springbootrest.service.JobService.getAllJobs(..))")
    public void logMethodExecuted(JoinPoint jp){
        LOGGER.info("Method Executed "+ jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.srinivas.springbootrest.service.JobService.getAllJobs(..))")
    public void logMethodCrash(JoinPoint jp){
        LOGGER.info("Method has some issues "+ jp.getSignature().getName());
    }

}
