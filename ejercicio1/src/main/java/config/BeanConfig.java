package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import gui.CalculadoraGui;
import service.CalculadoraService;
import service.CalculadoraServiceImpl;

@Configuration
public class BeanConfig {
	@Bean(name = "calculadoraService")
	@Scope("prototype")
	public CalculadoraService getCalculadoraService() {
		return new CalculadoraServiceImpl();
	}

	@Bean
	public CalculadoraGui calculadoraGui1() {
		CalculadoraGui calculadoraGui = new CalculadoraGui();
		calculadoraGui.setCalculadoraService(getCalculadoraService()); // Bean manejado por el container IoC
		return calculadoraGui;
	}

	@Bean
	public CalculadoraGui calculadoraGui2() {
		return new CalculadoraGui();
	}

}
