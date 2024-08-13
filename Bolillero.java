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

    public void verificarNumeros(Carton carton) {
        ArrayList<Integer> numero_carton = carton.getNumeroCarton();
        ArrayList<Integer> numeros_marcados = new ArrayList<>();

        for (int num : numeros_salidos) {
            if (numero_carton.contains(num)) {
                numeros_marcados.add(num);
            }
        }

        int cantidadNumeros = numero_carton.size();

        if (!numeros_marcados.isEmpty()) {
            System.out.println("   * TABLA N°" + carton.getIdentificador() + " (Jugador: " + carton.getPersonaQueJuega().getNombre() + "):");
            System.out.println("");
            System.out.println("       -Números de su tabla:   " + numero_carton);
            System.out.println("       -Números que Marcó:     " + numeros_marcados + ".");
            System.out.println("");
        }

        // Verifica si el jugador ganó la terna
        if (numeros_marcados.size() >= 3) {
            System.out.println("       -¡Felicidades " + carton.getPersonaQueJuega().getNombre() + "! ¡Ganaste la Terna!");
        } else {
            int faltanTerna = 3 - numeros_marcados.size();
            System.out.println("       -Te faltan " + faltanTerna + " números para ganar la terna.");
        }

        // Verifica si el jugador ganó la quinta
        if (numeros_marcados.size() >= 5) {
            System.out.println("       -¡Felicidades " + carton.getPersonaQueJuega().getNombre() + "! ¡Ganaste la Quinta!");
        } else if (numeros_marcados.size() < 5) {
            int faltanQuinta = 5 - numeros_marcados.size();
            System.out.println("       -Te faltan " + faltanQuinta + " números para ganar la quinta.");
        }

        // Verifica si le falta un número para ganar
        if (numeros_marcados.size() == cantidadNumeros - 1) {
            System.out.println("       -¡Estás a un número de ganar la lotería, " + carton.getPersonaQueJuega().getNombre() + "!");
        }

        System.out.println("");

        // Verifica si el jugador ha ganado la lotería
        if (numeros_marcados.size() == cantidadNumeros) {
            System.out.println("   - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            System.out.println("");
            System.out.println("                ¡Felicidades " + carton.getPersonaQueJuega().getNombre() + "!");
            System.out.println("                ¡Ganaste la lotería!");
            System.out.println("");
            System.out.println("   - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            System.out.println("");
        }
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("");
    }
}
