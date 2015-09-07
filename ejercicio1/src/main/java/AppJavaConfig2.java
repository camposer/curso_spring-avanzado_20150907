import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import gui.CalculadoraGui;

@ComponentScan(basePackages = { "service", "gui" })
public class AppJavaConfig2 {
	public static void main(String[] args) {
		new AnnotationConfigApplicationContext(AppJavaConfig2.class)
			.getBean(CalculadoraGui.class)
			.iniciar();
	}
}
