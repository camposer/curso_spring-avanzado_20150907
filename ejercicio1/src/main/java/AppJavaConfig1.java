import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import config.BeanConfig;
import gui.CalculadoraGui;

public class AppJavaConfig1 {
	public static void main(String[] args) {
		try (AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class)) {
			ctx.getBean("calculadoraGui2", CalculadoraGui.class).iniciar();
		}
	}
}
