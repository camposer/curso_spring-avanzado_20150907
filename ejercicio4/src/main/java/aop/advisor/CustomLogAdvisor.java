package aop.advisor;

import java.lang.reflect.Method;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import annotation.CustomLog;
import aop.interceptor.LoggerInterceptor;

@Component
public class CustomLogAdvisor extends AbstractPointcutAdvisor {

    private static final long serialVersionUID = 1L;

    @Autowired
    private LoggerInterceptor interceptor;

    @Override
    public Pointcut getPointcut() {
        return new StaticMethodMatcherPointcut() {
            @Override
            public boolean matches(Method method, Class<?> targetClass) {
                return method.isAnnotationPresent(CustomLog.class);
            }
        };
    }

    @Override
    public Advice getAdvice() {
        return this.interceptor;
    }
}    