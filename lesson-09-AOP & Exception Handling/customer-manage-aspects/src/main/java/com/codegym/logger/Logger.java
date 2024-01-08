package com.codegym.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.Arrays;

@Aspect
@Controller
public class Logger {
    @AfterThrowing(value = "execution(public * com.codegym.service.impl.CustomerService.*(..))",throwing = "e")
    public void logMethod(JoinPoint joinPoint,Exception e){
        String method = joinPoint.getSignature().getName();
        System.out.println("[CMS] có lỗi xảy ra " + method+ e.getMessage());
    }
    @Before("execution(public * com.codegym.service.impl.CustomerService.*(..))")
    public void logClass(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.printf("[CMS] co loi xay ra: %s.%s%s: %s%n", className, method, args);
    }
}
