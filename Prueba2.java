package app;

//Ing. Moisés Velásquez
//FIUSAC

import java.util.*; //ultimo paso, recordar incluir las librerías necesarias para utilizar colecciones
//Recomendacion: Cada clase contempla el uso el método toString, en la primera leída del código omitan, visualmente, su lectura por que el objetivo es que vean el funcionamiento.
//PASO 1: Seguir instrucciones, estableciendo la clase publica Prueba, con su único método main

//Por el momento esta clase esta comentada por que será hasta en el paso 3 que se use y así evitar los errores de compilación al copiar y pegar este código en su IDE/block de notas/compilador en linea

/*public class Prueba {
	public static void main(String args[]){
	}
}*/

//PASO 2: Codificar todas las clases independientes.

class Foto {
	//Recordar que solo una clase explicita publica (public) puede existir por archivo. Y todas las demás deben de retirarsele el modo de visibilidad para que se vuelvan "amigables"

	private String pathToFile, tipoArchivo; private float tamanyo;
	
	public Foto(){ this( "C:/", "*", 0.0f ); }
	public Foto(String pathToFile, String tipoArchivo, float tamanyo){ 
		setPathToFile(pathToFile); setTipoArchivo(tipoArchivo); setTamanyo(tamanyo); }
	
	public void setPathToFile( String pathToFile ){ this.pathToFile = pathToFile; }
	public String getPathToFile(){ return pathToFile; }
	public void setTipoArchivo( String tipoArchivo ){ this.tipoArchivo = tipoArchivo; }
	public String getTipoArchivo(){ return tipoArchivo; }
	public void setTamanyo(float tamanyo){ this.tamanyo = tamanyo; }
	public float getTamanyo(){ return tamanyo; }
	
	public String toString() {
	    return "\n" + "fotografia {\n\tpath:\t " + pathToFile 
	        + "\n\ttipo:\t " + tipoArchivo 
	        + "\n\ttamanyo: " + tamanyo + "bytes" 
	        + "\n};";
	}
}

class Lugar {
	private String nombre, direccion, telefono;
	
	public Lugar(){ this( "-vacio-", "-vacio-", "-vacio-" ); }
	
	public Lugar(String nombre, String direccion, String telefono) { 
		setNombre(nombre); setDireccion(direccion); setTelefono(telefono); 
	}
	
	//Pueden, no es obligatorio, agrupar todos los métodos set's
	public void setNombre(String nombre){ this.nombre = nombre; }
	public void setDireccion(String direccion){ this.direccion = direccion; }
	public void setTelefono(String telefono){ this.telefono = telefono; }

	//Y después todos los métodos get's.
	public String getDireccion(){ return direccion; }
	public String getNombre(){ return nombre; }
	public String getTelefono(){ return telefono; }
	
	public String toString() {
	    return "\n\t" + "lugar {\n\t\tnom: " + nombre
	        + "\n\t\tdir: " + direccion 
	        + "\n\t\ttel: " + telefono + "(local)" 
	        + "\n\t}";
	}
}

//PASO 2.1: Considerar, fuertemente, implementar  clases enumeradas para evitar el uso excesivo de String's cuando se refiere a constantes del sistema

enum TipoPerfil {
	LOCAL, MOVIL, OBLIGATORIO, TEMPORAL, CRONOLOGICO;
	public String toString() {
		switch(this) {
			case LOCAL: return "Perfil local";
			case MOVIL: return "Perfil móvil";
			case OBLIGATORIO: return "Perfil obligatorio";
			case TEMPORAL: return "Perfil temporal";
			case CRONOLOGICO: return "Perfil cronológico";
			default: return "Perfil por defecto";
		}
	}
}
//PASO 2: Continuación de paso
class Perfil {
	private String descripcion;
	private TipoPerfil tipoPerfil;

	public Perfil( TipoPerfil tipoPerfil, String descripcion ){ 
		setTipoPerfil(tipoPerfil); setDescripcion(descripcion);
	}
	public Perfil(){ this( TipoPerfil.LOCAL, "---" ); }
	
	//En este segmento de código, los métodos set's y get's estan en parejas, es decir, un set y un get de cada atributo

	public void setTipoPerfil(TipoPerfil tipoPerfil){ this.tipoPerfil = tipoPerfil; }
	public TipoPerfil getTipoPerfil(){ return tipoPerfil; }
	public void setDescripcion(String descripcion){ this.descripcion = descripcion; }
	public String getDescripcion(){ return descripcion; }
	
	public String toString() {
	    return "\n\tperfil {\n\t\ttipo:\t " + tipoPerfil
	        +  "\n\t\tdesc:\t " + descripcion
	        +  "\n\t}";
	}
}

class Persona {
	private String nombre, apellidos;
	private List<Perfil> perfiles; //Recordemos el uso de Generic's,  que sirve para que la colección se vuelva homogenea y que permita detectar cualquier ingreso anomalo de un tipo de dato diferente

	private List<Lugar> lugaresFrecuentes;
	private Foto foto;
	
	public Persona(String nombre, String apellidos, Foto foto){
		setNombre(nombre); setApellidos(apellidos); setFoto(foto);
		perfiles = new LinkedList<Perfil>(); 
		lugaresFrecuentes = new LinkedList<Lugar>();
	}
	
	public void setNombre(String nombre){ this.nombre = nombre; }
	public String getNombre(){ return nombre; }
	
	public void setApellidos(String apellidos){ this.apellidos = apellidos; }
	public String getApellidos(){ return apellidos; }
	
	public void setFoto(Foto foto){ this.foto = foto; }
	public Foto getFoto(){ return foto; }
	
	public void agregarLugarFrecuente(Lugar lugar) {
		lugaresFrecuentes.add( lugar );
	}
	
	public void agregarLugarFrecuente(String nombre, String direccion, String telefono) {
		lugaresFrecuentes.add( new Lugar( nombre, direccion, telefono ) );
	}
	
	public void agregarPerfil() {
		perfiles.add( new Perfil( TipoPerfil.LOCAL, "mi primer perfil" ) );
	}
	
	public void agregarPerfil(TipoPerfil tipoPerfil, String descripcion ) {
		perfiles.add( new Perfil( tipoPerfil, descripcion ) );
	}
	
	public void setPerfiles(List<Perfil> perfiles){ this.perfiles = perfiles; }
	public void setLugaresFrecuentes(List<Lugar> lugaresFrecuentes)
	{ this.lugaresFrecuentes = lugaresFrecuentes; }
	
	public String atributosBasicosToString() {
	    return "nombre:\t\t" + nombre + "\n" + "apellidos:\t" + apellidos;
	}
	
	public String linkedListToString(boolean flag, String tit, List lista) {
	    String str = "";
	    str = (flag)?"\n" + tit +" [": "";
	    
	    for (Object o : lista)
            str += o.toString();
	    
	    str = (flag)?str + "\n];":str + "";
	    
	    return str;
	}
	
	public String lugaresFrecuentesToString() {
	    return this.linkedListToString(true, "Lugares", lugaresFrecuentes);
	}
	
	public String perfilesToString() {
	    return this.linkedListToString(true, "Perfiles", perfiles);
	}
	
	public String toString() {
	    return atributosBasicosToString() + foto.toString() + lugaresFrecuentesToString() + perfilesToString();
	}
}

//PASO 3: Ingresar datos de prueba para corroborar correcto funcionamiento del ejercicio
public class Prueba2 {
	public static void main(String args[]){
		Persona persona = new Persona( "Moises", "Velasquez", new Foto( "C:/", "y.jpg", 35.0f ) );
		persona.agregarLugarFrecuente( "USAC", "zona 12", "87654321" );
		persona.agregarLugarFrecuente( "Hogar", "zona", "12345678" );
		persona.agregarPerfil();
		persona.agregarPerfil( TipoPerfil.OBLIGATORIO, "mi perfil universitario" );
		System.out.println(persona);
	}
}