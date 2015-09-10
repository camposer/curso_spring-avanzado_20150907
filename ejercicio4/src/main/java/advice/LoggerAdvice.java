package advice;

import java.util.Date;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import service.LoggerService;

@Component
public class LoggerAdvice implements MethodInterceptor {
	@Autowired
	private LoggerService loggerService;

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		Long timestamp = new Date().getTime();
		StringBuilder argumentos = new StringBuilder();
		if (methodInvocation.getArguments() != null) {
			for (Object a : methodInvocation.getArguments()) {
				argumentos.append(a);
			}
		}
		
		String mensaje = "[método = " + methodInvocation.getMethod().getName() +
				", argumentos = " + argumentos + 
				", timestamp = " + timestamp + "]"; 
		loggerService.log(mensaje);

		return methodInvocation.proceed();
	}

}
