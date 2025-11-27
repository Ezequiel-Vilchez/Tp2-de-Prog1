public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("--- SISTEMA EDUCATIVO CON LISTAS ENLAZADAS ---");

        
        Universidad u1 = new Universidad("Unvime", "Los poetas");

        
        Profesor profe1 = new Profesor("Carlos", "Gomez", 45, "99887766", "Matematicas", "20 años");
        u1.agregarMiembros(profe1);

        
        Materia materia1 = new Materia("Base de datos", "Bs101", 4, 9.8, profe1);
        Materia materia2 = new Materia("Ingles", "ing1301", 0, 2.7, profe1);
        Materia materia3 = new Materia("Matematicas", "MT201", 2, 7.0, profe1);

       
        Estudiante e1 = new Estudiante("Ezequiel", "Vilchez", 21, "12345678", "Ingenieria");
        Estudiante e2 = new Estudiante("Nicolas", "Sanchez", 22, "87654321", "Programador");
        Estudiante e3 = new Estudiante("Juan", "Guzman", 23, "11223344", "Programador");

        
        e1.agregarMateria(materia1);
        e1.agregarMateria(materia2);
        e1.agregarMateria(materia3); 

        e2.agregarMateria(materia1); 
        
        
        u1.agregarMiembros(e1);
        u1.agregarMiembros(e2);
        u1.agregarMiembros(e3);

        System.out.println("Promedios Recursivos");
        
        System.out.println(e1.getNombre() + " promedio: " + String.format("%.2f", e1.getPromedio())); 
        System.out.println(e2.getNombre() + " promedio: " + String.format("%.2f", e2.getPromedio()));
        System.out.println(e3.getNombre() + " promedio: " + e3.getPromedio()); // Debería ser 0.0

        System.out.println("\n--- PRUEBA 2: Búsqueda Binaria (Convierte Lista -> Array -> Ordena -> Busca) ---");
        
        String dniBuscado = "87654321";
        Estudiante encontrado = u1.buscarEstudianteBinario(dniBuscado);
        
        if (encontrado != null) {
            System.out.println("EXITO: Se encontró a " + encontrado.getNombre() + " con DNI " + dniBuscado);
        } else {
            System.out.println("FALLO: No se encontró al estudiante.");
        }

        
        if (u1.buscarEstudianteBinario("0000000") == null) {
            System.out.println("EXITO: Correctamente no se encontró un DNI inexistente.");
        }
        
        System.out.println("\n--- LISTADO FINAL ---");
        u1.mostrarMiembros();
    }
}