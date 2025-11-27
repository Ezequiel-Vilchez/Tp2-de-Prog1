public class Estudiante extends Persona implements MiembroUniversidad {

    private String carrera;
    private double promedio;
    private ListaEnlazada materias;
    
    public Estudiante(String nombre, String apellido, int edad, String documento, String carrera) {
        super(nombre, apellido, edad, documento);
        this.carrera = carrera;
        this.materias = new ListaEnlazada();
        this.promedio = 0.0;
    }

    public void agregarMateria(Materia m) {
        materias.agregar(m);
        
        this.calcularPromedioRecursivo();
    }

    
    public double calcularPromedioRecursivo() {
        if (materias.estaVacia()) {
            this.promedio = 0.0;
            return 0.0;
        }

        
        this.promedio = calcularPromedioInterno(materias.getPrimero(),0,0.0);
        return this.promedio;
    }

    
    private double calcularPromedioInterno(Nodo actual, int contador, double suma) {
        
        
        if (actual == null) {
            
            return contador == 0 ? 0 : suma / contador;
        }

        Materia materia = (Materia) actual.getDato();
        return calcularPromedioInterno(
                actual.getSiguiente(),       
                contador + 1,                
                suma + materia.getCalificacion() 
        );
    }

    public String getCarrera() {
        return carrera;
    }

    public double getPromedio() {
        return promedio;
    }

    @Override
    public String obtenerRol() {
        return "Estudiante";
    }

    @Override
    public String obtenerInformacionCompleta() {
        return "Estudiante: " + getNombre() + " " + getApellido() + " - Promedio: " + String.format("%.2f", promedio);
    }
}