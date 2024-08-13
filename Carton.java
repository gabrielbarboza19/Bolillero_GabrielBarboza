import java.util.ArrayList;
import java.util.Random;
import java.util.HashSet;

public class Carton {
    private int identificador;
    private ArrayList<Integer> numero_tabla;
    private ArrayList<Integer> numeros_recibidos;
    private Persona personaQueJuega;

    public Carton(int identificador, Persona persona) {
        this.identificador = identificador;
        this.numero_tabla = new ArrayList<>();
        this.numeros_recibidos = new ArrayList<>();
        this.personaQueJuega = persona;
    }

    public void setIdentificador(int ide) {
        this.identificador = ide;
    }

    public int getIdentificador() {
        return identificador;
    }

    public ArrayList<Integer> getNumeroCarton() {
        return numero_tabla;
    }

    public ArrayList<Integer> getNumerosRecibidos() {
        return numeros_recibidos;
    }

    public void llenarNumeroCarton() {
        Random random = new Random();
        HashSet<Integer> numerosUnicos = new HashSet<>();
        
        while (numerosUnicos.size() < 15) {
            int num = random.nextInt(100) + 1; // Números aleatorios entre 1 y 8
            numerosUnicos.add(num);
        }
        
        numero_tabla.addAll(numerosUnicos);
    }

    public void recibirNumero(int num) {
        numeros_recibidos.add(num);
    }

    public Persona getPersonaQueJuega() {
        return personaQueJuega;
    }

    public void setPersonaQueJuega(Persona persona) {
        this.personaQueJuega = persona;
    }
}