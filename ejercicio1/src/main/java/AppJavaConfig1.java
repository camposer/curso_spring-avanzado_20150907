import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import config.BeanConfig;
import gui.CalculadoraGui;

public class AppJavaConfig1 {
	public static void main(String[] args) {
		new AnnotationConfigApplicationContext(BeanConfig.class)
			.getBean("calculadoraGui2", CalculadoraGui.class)
			.iniciar();
	}
}
