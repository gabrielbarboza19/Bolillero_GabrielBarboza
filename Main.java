import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Crear objetos Persona
        Persona persona1 = new Persona("Niko Bellic");
        Persona persona2 = new Persona("Roman Bellic");
        Persona persona3 = new Persona("Bruce Kibuttz");

        // Instanciar 3 objetos de la clase Carton y asociar cada uno a una persona
        Carton carton1 = new Carton(1, persona1);
        Carton carton2 = new Carton(2, persona2);
        Carton carton3 = new Carton(3, persona3);
        
        // Llenar los cartones con números aleatorios
        carton1.llenarNumeroCarton();
        carton2.llenarNumeroCarton();
        carton3.llenarNumeroCarton();

        // Crear objeto Bolillero y llenar su lista de números salidos
        Bolillero bolillero = new Bolillero();
        bolillero.llenarNumerosSalidos();

        // Mostrar los números de la bolilla
        bolillero.mostrarNumerosSalidos();

        // Crear objeto Planilla y pasar el Bolillero y la lista de Cartones
        ArrayList<Carton> cartones = new ArrayList<>();
        cartones.add(carton1);
        cartones.add(carton2);
        cartones.add(carton3);

        Planilla planilla = new Planilla(bolillero, cartones);

        // Verificar los números marcados en las tablas
        planilla.verificarTodosCarton();
    }
}
