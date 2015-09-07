import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import config.BeanConfig;
import gui.CalculadoraGui;

public class AppJavaConfig2 {
	public static void main(String[] args) {
		new AnnotationConfigApplicationContext(Config.class)
			.getBean(CalculadoraGui.class)
			.iniciar();
	}
	
	@Configuration
	@ComponentScan(basePackages = { "service", "gui" })
	//@ComponentScan(basePackageClasses = BeanConfig.class)
	public static class Config {
		
	}
}
