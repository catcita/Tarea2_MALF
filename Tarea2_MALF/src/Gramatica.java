import java.util.*;

public class Gramatica {
    private Set<String> variables;
    private Set<Character> terminales;
    private Map<String, List<String>> reglas;
    private String simboloInicial;

    public Gramatica() {
        this.variables = new HashSet<>();
        this.terminales = new HashSet<>();
        this.reglas = new HashMap<>();
    }

    // Métodos para agregar reglas, terminales y definir el símbolo inicial
    public void agregarRegla(String variable, List<String> producciones) {
        reglas.put(variable, producciones);
    }
    public void agregarTerminal(char terminal) {
        terminales.add(terminal);
    }
    public void definirSimboloInicial(String simbolo) {
        this.simboloInicial = simbolo;
    }

    public void minimizarGramatica() {
        //eliminarProduccionesInutiles();
        //eliminarProduccionesRedundantes();
        // Implementación específica para eliminar producciones y reglas innecesarias.
    }


    public void mostrarGramatica() {
        System.out.println("V=" + variables);
        System.out.println("Sigma=" + terminales);
        System.out.println("R=" + reglas);
        System.out.println("S=" + simboloInicial);
    }
}

