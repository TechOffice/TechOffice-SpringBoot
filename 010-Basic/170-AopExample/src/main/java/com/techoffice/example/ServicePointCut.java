package com.techoffice.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ServicePointCut {

    @Before("execution(* EmployeeManager.getEmployeeById(..))")         //point-cut expression
    public void logBeforeV1(JoinPoint joinPoint) {
        System.out.println("EmployeeCRUDAspect.logBeforeV1() : " + joinPoint.getSignature().getName());
    }
}
