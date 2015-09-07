package basico.basico;

public class Wrapper {
	private String message;
	
	public Wrapper(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "[ message = " + message + " ]";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
