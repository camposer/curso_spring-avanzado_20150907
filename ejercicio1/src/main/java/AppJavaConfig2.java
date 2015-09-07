import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.AbstractApplicationContext;

import gui.CalculadoraGui;

@ComponentScan(basePackages = { "service", "gui" })
public class AppJavaConfig2 {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppJavaConfig2.class);
		ctx.getBean(CalculadoraGui.class).iniciar();
		ctx.close();
	}
}
