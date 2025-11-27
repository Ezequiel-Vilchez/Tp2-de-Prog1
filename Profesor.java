public class Profesor extends Persona implements MiembroUniversidad {
    private String especialidad;
    private String aniosDeExperencia;
    
    
    private ListaEnlazada materiasAsignadas; 

    public Profesor(String nombre, String apellido, int edad, String documento, String especialidad, String aniosDeExperencia) {
        super(nombre, apellido, edad, documento);
        this.especialidad = especialidad;
        this.aniosDeExperencia = aniosDeExperencia;
        this.materiasAsignadas = new ListaEnlazada();
    }

    public void asignarMateria(Materia materia) {
        
        materiasAsignadas.agregar(materia);
        System.out.println("El profesor " + this.getNombre() + " se ha inscrito a la materia: " + materia.getNombre());
    }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
    public String getAniosDeExperencia() { return aniosDeExperencia; }
    public void setAniosDeExperencia(String aniosDeExperencia) { this.aniosDeExperencia = aniosDeExperencia; }

    @Override
    public String obtenerRol() { return "Profesor"; }

    @Override
    public String obtenerInformacionCompleta() {
        return "Profesor: " + getNombre() + " " + getApellido() + ", Especialidad: " + especialidad;
    }
    
    @Override
    public String toString() { return obtenerInformacionCompleta(); }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Profesor that = (Profesor) obj;
        return this.documento.equals(that.documento);
    }
}

