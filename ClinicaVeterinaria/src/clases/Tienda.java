package clases;

public class Tienda {
	private String codigo;
	private String nombre;
	private String descripcion;
	private String animal;
	private String tipo;
	private float precioPVP;
	private int almacenados;
	
	// methods setter & getter
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getAnimal() {
		return animal;
	}
	public void setAnimal(String animal) {
		this.animal = animal;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public float getPrecio() {
		return precioPVP;
	}
	public void setPrecio(float precio) {
		this.precioPVP = precio;
	}
	public int getAlmacenados() {
		return almacenados;
	}
	public void setAlmacenados(int almacenados) {
		this.almacenados = almacenados;
	}
	
	
}
