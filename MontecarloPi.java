import java.util.Random;
import java.util.function.BiFunction;

public class MontecarloPi {
    
    // Expresión lambda para determinar si un punto (x, y) está dentro del círculo unitario
    static BiFunction<Double, Double, Boolean> estaDentro = (x, y) -> x*x + y*y <= 1;
    
    // Función para estimar el valor de pi utilizando Montecarlo
    static double montecarloPi(int numPuntos) {
        int puntosDentro = 0;
        Random rand = new Random();
        
        // Generar puntos aleatorios y contar cuántos están dentro del círculo
        for (int i = 0; i < numPuntos; i++) {
            double x = rand.nextDouble() * 2 - 1; // Generar un valor aleatorio entre -1 y 1
            double y = rand.nextDouble() * 2 - 1; // Generar un valor aleatorio entre -1 y 1
            if (estaDentro.apply(x, y)) {
                puntosDentro++;
            }
        }
        
        // Calcular el valor aproximado de pi
        double piAprox = 4.0 * puntosDentro / numPuntos;
        return piAprox;
    }
    
    public static void main(String[] args) {
        int numPuntos = 1000000; // Número de puntos para la simulación de Montecarlo
        double piAprox = montecarloPi(numPuntos);
        System.out.printf("Valor aproximado de pi usando Montecarlo con %d puntos: %.5f%n", numPuntos, piAprox);
    }
}
