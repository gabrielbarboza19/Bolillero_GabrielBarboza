public class Main {
    public static void main(String[] args) {
        // Crear objetos Persona
        Persona persona1 = new Persona("Niko Bellick");
        Persona persona2 = new Persona("Roman Bellick");
        Persona persona3 = new Persona("Bruce Kibuttz");
        Persona persona4 = new Persona("Malorie");

        // Instanciar 3 objetos de la clase Tabla y asociar cada uno a una persona
        Carton carton1 = new Carton(1, persona1);
        Carton carton2 = new Carton(2, persona2);
        Carton carton3 = new Carton(3, persona3);
        Carton carton4 = new Carton(4, persona4);
        
        // Llenar las tablas con números aleatorios
        carton1.llenarNumeroCarton();
        carton2.llenarNumeroCarton();
        carton3.llenarNumeroCarton();
        carton4.llenarNumeroCarton();

        // Crear objeto Bolita y llenar su lista de números salidos
        Bolillero bolillero = new Bolillero();
        bolillero.llenarNumerosSalidos();

        // Mostrar los números de la bolita
        bolillero.mostrarNumerosSalidos();

        // Verificar los números marcados en las tablas
        bolillero.verificarNumeros(carton1);
        bolillero.verificarNumeros(carton2);
        bolillero.verificarNumeros(carton3);
        bolillero.verificarNumeros(carton4);
    }
}