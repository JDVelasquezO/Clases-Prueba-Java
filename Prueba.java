// 201800722
// José Daniel Velásquez Orozco

package app;

class Foto {
    private String pathToFile;
    private String tipoArchivo;
    private float tamanio;
}

class Lugar {
    private String nombre;
    private String direccion;
    private String telefono;

    public Lugar(String nombre, String direccion, String telefono){
        setNombreLugar(nombre);
        setDireccionLugar(direccion);
        setTelefonoLugar(telefono);
    }

    public void setNombreLugar(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreLugar(){
        return this.nombre;
    }

    public void setDireccionLugar(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccionLugar(){
        return this.direccion;
    }

    public void setTelefonoLugar(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefonoLugar() {
        return this.telefono;
    }

    public String formato(String separacion) {
        return nombre + separacion + telefono + separacion + direccion;
    }
}

class Perfil {
    private int tipoPerfil;
    private String descripcion;

    public void setTipoPerfil(int tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }

    public int getTipoPerfil() {
        return this.tipoPerfil;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }
}

class Persona {
    // Atributos
    private String nombre;
    private String apellido;
    private Perfil[] perfiles;
    private Lugar[] lugaresFrecuentes;
    private Foto foto;

    // Metodos
    public Persona(String nombre, String apellido){
        setNombre(nombre);
        setPerfiles(perfiles);
        setLugaresFrecuentes(lugaresFrecuentes);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void agregarLugarFrecuente(Lugar lugar) {
        this.lugaresFrecuentes[0] = lugar;
    }

    public void agregarPerfil() {
        
    }

    public Perfil[] setPerfiles(Perfil perfiles[]) {
        return perfiles;
    }

    public void setLugaresFrecuentes(Lugar[] lugaresFrecuentes) {
        this.lugaresFrecuentes = lugaresFrecuentes;
    }

    public Lugar getLugaresFrecuentes(int index) {
        return this.lugaresFrecuentes[index];
    }
}

public class Prueba {
    public static void main(String[] args) throws Exception {
        Lugar lugar = new Lugar("Belenki", "Col. Belen", "44455898");
        Persona persona = new Persona("Daniel", "Velasquez");
        
        persona.setLugaresFrecuentes(new Lugar[5]);
        persona.agregarLugarFrecuente(lugar);
        System.out.println("El lugar es " + persona.getLugaresFrecuentes(0).formato(", "));

        /*persona.setLugaresFrecuentes(new Lugar[5]);
        persona.agregarLugarFrecuente(lugar);
        System.out.println("EL lugar es: " + persona.getLugaresFrecuentes(0));*/
    }
}