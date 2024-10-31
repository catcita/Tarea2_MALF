import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try{
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese la expresión regular: ");
            String er = scanner.nextLine();

            ExpresionRegular.comprobarExpresionRegular(er);

            // Paso 2: Convertir ER a GLC
            Gramatica gramatica = new Gramatica();
            // Lógica de conversión de ER a GLC

            System.out.println("GLC 1:");
            gramatica.mostrarGramatica();

            // Paso 3: Convertir GLC a AP
            AutomataPila automataPila = new AutomataPila();
            // Lógica de conversión de GLC a AP

            System.out.println("AP:");
            automataPila.mostrarAutomata();

            // Paso 4: Convertir AP a GLC
            Gramatica nuevaGramatica = automataPila.GLCaAP();
            System.out.println("GLC 2:");
            nuevaGramatica.mostrarGramatica();

            // Paso 5: Minimizar GLC
            nuevaGramatica.minimizarGramatica();
            System.out.println("GLC Minimizada:");
            nuevaGramatica.mostrarGramatica();
        } catch (Exception e) {
            System.out.println(e);;
        }
    }
}
