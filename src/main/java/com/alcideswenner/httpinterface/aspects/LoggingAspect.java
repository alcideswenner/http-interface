package com.alcideswenner.httpinterface.aspects;

import java.util.Objects;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("@within(com.alcideswenner.httpinterface.annotations.RegisterLog)")
    public void applicationPackagePointcut() {
        LOGGER.info("####LOGS####");
    }

    @Before("applicationPackagePointcut()")
    public void logBefore(JoinPoint joinPoint) {
        if (joinPoint.getSignature() != null) {
            final String nameMethod = Objects.toString(joinPoint.getSignature().toShortString(), "");
            LOGGER.info("Antes de executar o metodo: {}",
                    nameMethod);
        }

    }

    @AfterReturning(pointcut = "applicationPackagePointcut()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        if (joinPoint.getSignature() != null) {
            final String nameMethod = Objects.toString(joinPoint.getSignature().toShortString(), "");
            LOGGER.info("Apos a execução do metodo: {}. Resultado: {}",
                    nameMethod,
                    result);
        }

    }
}
