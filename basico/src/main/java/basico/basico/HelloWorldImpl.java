package basico.basico;

public class HelloWorldImpl implements HelloWorld {
	private Wrapper wrapper;
	
	@Override
	public String hi() {
		return wrapper.toString();
	}

	public Wrapper getWrapper() {
		return wrapper;
	}

	public void setWrapper(Wrapper wrapper) {
		this.wrapper = wrapper;
	}
}
