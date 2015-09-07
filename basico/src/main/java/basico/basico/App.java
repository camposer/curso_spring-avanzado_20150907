package basico.basico;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main( String[] args ) {
    	ApplicationContext ctx = 
    			new ClassPathXmlApplicationContext("applicationContext.xml");
        
    	HolaMundo hm1 = ctx.getBean("holaMundo1", HolaMundo.class);
    	System.out.println(hm1.saludar());
    	
    	HolaMundo hm2 = ctx.getBean("holaMundo1", HolaMundo.class);
    	((HolaMundoImpl)hm2).setNombre("Pedro");
    	
    	System.out.println(hm1.saludar()); // => Hola Pedro

    	/******** PROTOTYPE *******/
    	
    	HolaMundo hm3 = ctx.getBean("holaMundo2", HolaMundo.class);
    	System.out.println(hm3.saludar());
    	
    	HolaMundo hm4 = ctx.getBean("holaMundo2", HolaMundo.class);
    	((HolaMundoImpl)hm4).setNombre("Pedro");
    	
    	System.out.println(hm3.saludar()); // => Hola Juan
    
    	/********* COLABORADORES ********/
    	
    	HelloWorld hw1 = ctx.getBean(HelloWorld.class);
    	System.out.println(hw1.hi()); // => [ message = Hello María ]

    	ctx.getBean(Wrapper.class).setMessage("Hello Roberto");
    	
    	System.out.println(hw1.hi()); // => [ message = Hello Roberto ]
    	System.out.println(ctx.getBean(HelloWorld.class).hi()); // => [ message = Hello Roberto ]
    }
}
