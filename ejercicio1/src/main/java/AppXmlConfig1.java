import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import gui.CalculadoraGui;

public class AppXmlConfig1 {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext1.xml");
		ctx.getBean(CalculadoraGui.class).iniciar();
		ctx.close();
	}
}
