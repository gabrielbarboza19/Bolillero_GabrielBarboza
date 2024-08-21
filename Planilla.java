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

        verificarTerna(carton, numeros_marcados);
        verificarQuinta(carton, numeros_marcados);
        verificarFaltaUno(carton, numeros_marcados, numero_carton.size());
        verificarLoteria(carton, numeros_marcados, numero_carton.size());
        
        System.out.println("");
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("");
    }

    private void verificarTerna(Carton carton, ArrayList<Integer> numeros_marcados) {
        if (numeros_marcados.size() >= 3) {
            System.out.println("            -¡FELICIDADES " + carton.getPersonaQueJuega().getNombre() + "! ¡GANASTE LA TERNA!");
        } else {
            int faltanTerna = 3 - numeros_marcados.size();
            System.out.println("            -Te faltan (" + faltanTerna + ") números para ganar la terna.");
        }
    }

    private void verificarQuinta(Carton carton, ArrayList<Integer> numeros_marcados) {
        if (numeros_marcados.size() >= 5) {
            System.out.println("            -¡FELICIDADES " + carton.getPersonaQueJuega().getNombre() + "! ¡GANASTE LA QUINTA!");
        } else {
            int faltanQuinta = 5 - numeros_marcados.size();
            System.out.println("            -Te faltan (" + faltanQuinta + ") números para ganar la quinta.");
        }
    }

    private void verificarFaltaUno(Carton carton, ArrayList<Integer> numeros_marcados, int cantidadNumeros) {
        if (numeros_marcados.size() == cantidadNumeros - 1) {
            System.out.println("            -¡ESTÁS A (1) NÚMERO DE GANAR LA LOTERÍA " + carton.getPersonaQueJuega().getNombre() + "!");
        }
    }

    private void verificarLoteria(Carton carton, ArrayList<Integer> numeros_marcados, int cantidadNumeros) {
        if (numeros_marcados.size() == cantidadNumeros) {
            System.out.println("   - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            System.out.println("");
            System.out.println("                ¡Felicidades " + carton.getPersonaQueJuega().getNombre() + "!");
            System.out.println("                ¡Ganaste la lotería!");
            System.out.println("");
            System.out.println("   - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            System.out.println("");
        }
    }

    public void verificarTodosCarton() {
        for (Carton carton : cartones) {
            verificarCarton(carton);
        }
    }
}
