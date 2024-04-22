package com.TaskMicroservice.ASOP;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class MethodExecutionTimeAspect {
    @Around("execution(* com.TaskMicroservice.Controller.*.*(..))")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - startTime;
        System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        return result;
    }
    /**
     * Measures the execution time of methods in controllers.
     * @param joinPoint ProceedingJoinPoint representing the method being executed.
     * @return The result of the method execution.
     * @throws Throwable Thrown if an error occurs during method execution.
     */
}