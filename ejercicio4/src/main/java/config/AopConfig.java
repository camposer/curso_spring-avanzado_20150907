package config;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import service.PersonaService;

@Configuration
@EnableAspectJAutoProxy // Activa aspectos
public class AopConfig {
	@Autowired
	private PersonaService personaService;
	
	@Bean
	public ProxyFactoryBean personaServiceProxy() {
		ProxyFactoryBean proxy = new ProxyFactoryBean();
		proxy.setTarget(personaService);
		proxy.setInterceptorNames("loggerAdvice");
		return proxy;
	}
}
