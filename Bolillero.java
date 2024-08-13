import java.util.ArrayList;
import java.util.Random;
import java.util.HashSet;

public class Bolillero {
    private ArrayList<Integer> numeros_salidos;

    public Bolillero() {
        numeros_salidos = new ArrayList<>();
    }

    public void llenarNumerosSalidos() {
        Random random = new Random();
        HashSet<Integer> numerosUnicos = new HashSet<>();
        
        while (numerosUnicos.size() < 15) {
            int num = random.nextInt(98) + 1; // Números aleatorios entre 1 y 100
            numerosUnicos.add(num);
        }
        numeros_salidos.addAll(numerosUnicos);
    }

    public void mostrarNumerosSalidos() {
        System.out.println("");
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println(" * Los números que salieron:   " + numeros_salidos);
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("");
    }

    // Método para obtener los números salidos
    public ArrayList<Integer> getNumerosSalidos() {
        return numeros_salidos;
    }
}
