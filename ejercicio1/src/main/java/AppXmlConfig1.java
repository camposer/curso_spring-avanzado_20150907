import org.springframework.context.support.ClassPathXmlApplicationContext;

import gui.CalculadoraGui;

public class AppXmlConfig1 {
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("applicationContext1.xml")
			.getBean(CalculadoraGui.class)
			.iniciar();
	}
}
