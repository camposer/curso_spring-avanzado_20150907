import org.springframework.context.support.ClassPathXmlApplicationContext;

import gui.CalculadoraGui;

public class AppXmlConfig2 {
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("applicationContext2.xml")
			.getBean(CalculadoraGui.class)
			.iniciar();
	}
}
