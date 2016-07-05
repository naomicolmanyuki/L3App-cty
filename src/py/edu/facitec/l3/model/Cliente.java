package py.edu.facitec.l3.model;
/**
 * 
 * @author Naomi Colman
 *
 */


public class Cliente {
	//atributos
		private int codigo;
		private String nombre;
		private String apellido;
		private String direcion;
		private int cedula_numero;
		private boolean estado;
		
		//constructores
		//por defecto
		public Cliente() {
			super();
			this.codigo=0;
			this.nombre="";
			this.apellido="";
			this.direcion="";
			this.cedula_numero=0;
			this.estado=false;
		}
		
		//por parametro
		public Cliente(int codigo, String nombre, String apellido, String direcion, int cedula_numero, 
				boolean estado) {
			super();
			this.codigo = codigo;
			this.nombre = nombre;
			this.apellido = apellido;
			this.direcion = direcion;
			this.cedula_numero= cedula_numero;
			this.estado = estado;
		}
		//metodos

		public int getCodigo() {
			return codigo;
		}

		public void setCodigo(int codigo) {
			this.codigo = codigo;
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

		public String getDirecion() {
			return direcion;
		}

		public void setDirecion(String direcion) {
			this.direcion = direcion;
		}

		public int getCedula_numero() {
			return cedula_numero;
		}

		public void setCedula_numero(int cedula_numero) {
			this.cedula_numero = cedula_numero;
		}

		public boolean isEstado() {
			return estado;
		}

		public void setEstado(boolean estado) {
			this.estado = estado;
		}
	
	
	
}
