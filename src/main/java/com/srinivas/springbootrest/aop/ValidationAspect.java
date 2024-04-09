package com.srinivas.springbootrest.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ValidationAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    /*
    Let's say user passed a negative number, we need to perform validations and change it to positive.
    We need to mention the variable in the argms and perform validations
    Then, we need to proceed using the modified variable.
     */

    @Around("execution(* com.srinivas.springbootrest.service.JobService.getJob(..)) && args(postId)")
    public Object validateAndUpdate(ProceedingJoinPoint proceedingJoinPoint, int postId) throws Throwable {

        if(postId < 0){
            LOGGER.info("Postid is negative, updating it");
            postId = -postId;
            LOGGER.info("new value " + postId);
        }

        Object obj = proceedingJoinPoint.proceed(new Object[]{postId});

        return obj;
    }
}
