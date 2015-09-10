package rest.to;

public class GetPersonasResponse {
	private Status status;
	private Object data;
	
	public static enum Status  {
		SUCCESS, ERROR;
	}
	
	public static class Persona {
		private Integer id;
		private String nombre;
		private String apellido;
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getApellido() {
			return apellido;
		}
		public void setApellido(String apellido) {
			this.apellido = apellido;
		}
	}
	
	public GetPersonasResponse() {
		this.status = Status.SUCCESS;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
