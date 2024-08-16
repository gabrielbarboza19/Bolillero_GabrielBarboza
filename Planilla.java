import java.util.ArrayList;

public class Planilla {

    private Bolillero bolillero;
    private ArrayList<Carton> cartones;

    public Planilla(Bolillero bolillero, ArrayList<Carton> cartones) {
        this.bolillero = bolillero;
        this.cartones = cartones;
    }

    public void verificarCarton(Carton carton) {
        ArrayList<Integer> numeros_salidos = bolillero.getNumerosSalidos();
        ArrayList<Integer> numero_carton = carton.getNumeroCarton();
        ArrayList<Integer> numeros_marcados = new ArrayList<>();

        for (int num : numeros_salidos) {
            if (numero_carton.contains(num)) {
                numeros_marcados.add(num);
            }
        }

        int cantidadNumeros = numero_carton.size();

        if (!numeros_marcados.isEmpty()) {
            System.out.println("   * CARTON N°" + carton.getIdentificador() + " (Jugador: " + carton.getPersonaQueJuega().getNombre() + "):");
            System.out.println("");
            System.out.println("       -Números de su tabla:   " + numero_carton);
            System.out.println("       -Números que Marcó:     " + numeros_marcados);
            System.out.println("");
        }else if(numeros_marcados.isEmpty()){

            System.out.println("   * CARTON N°" + carton.getIdentificador() + " (Jugador: " + carton.getPersonaQueJuega().getNombre() + "):");
            System.out.println("");
            System.out.println("       -Números de su tabla:   " + numero_carton);
            System.out.println("       -Números que Marcó:     [No marco ningúno]");
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
            System.out.println("       -¡Estás a un número de ganar la lotería " + carton.getPersonaQueJuega().getNombre() + "!");
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

    public void verificarTodosCarton() {
        for (Carton carton : cartones) {
            verificarCarton(carton);
        }
    }
}
