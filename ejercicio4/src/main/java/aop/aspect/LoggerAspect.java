package aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import service.LoggerService;

@Component
@Aspect
public class LoggerAspect {
	@Autowired
	private LoggerService loggerService;
	
	@Before("execution(* service.OrdenadorServiceImpl.obtenerOrdenadores(..))")
	public void logBefore(JoinPoint joinPoint) {
		loggerService.log("OrdenadorServiceImpl.obtenerOrdenadores()");
	}
}
