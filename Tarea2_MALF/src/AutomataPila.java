import java.util.*;

public class AutomataPila {
    private Set<String> estados;
    private Set<Character> alfabeto;
    private Set<String> pila;
    private Map<String, List<String>> transiciones;
    private String estadoInicial;
    private Set<String> estadosFinales;

    public AutomataPila() {
        this.estados = new HashSet<>();
        this.alfabeto = new HashSet<>();
        this.pila = new HashSet<>();
        this.transiciones = new HashMap<>();
        this.estadosFinales = new HashSet<>();
    }

    public void agregarTransicion(String estadoDesde, String simboloEntrada, String simboloPila, String estadoHasta, String nuevoSimboloPila) {
        // Implementación de transiciones de la forma (q, a, X) -> (p, gamma)
        transiciones.putIfAbsent(estadoDesde, new ArrayList<>());
        transiciones.get(estadoDesde).add(/* forma detallada de la transición */);
    }

    public Gramatica GLCaAP(){
        //
        return null;
    }

    public void mostrarAutomata() {
        System.out.println("K=" + estados);
        System.out.println("Sigma=" + alfabeto);
        System.out.println("Gamma=" + pila);
        System.out.println("Delta=" + transiciones);
        System.out.println("s=" + estadoInicial);
        System.out.println("F=" + estadosFinales);
    }
}
