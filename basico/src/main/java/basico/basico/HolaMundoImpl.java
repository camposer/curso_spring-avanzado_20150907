package basico.basico;

public class HolaMundoImpl implements HolaMundo {
	private String nombre;
	
	@Override
	public String saludar() {
		return "Hola " + nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
