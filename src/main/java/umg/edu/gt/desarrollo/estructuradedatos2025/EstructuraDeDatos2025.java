package umg.edu.gt.desarrollo.estructuradedatos2025;

import java.util.Arrays;
import umg.edu.gt.desarrollo.estructuradedatos2025.clases.ClaseVectores;
import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioVectores;
import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioArrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author josue
 */
public class EstructuraDeDatos2025 {

    private static final Logger logger = LogManager.getLogger(EstructuraDeDatos2025.class);

    public static void main(String[] args) {
        EjercicioArrays Ej1 = new EjercicioArrays();
        
        int[][] cuentas1 = { {1, 2, 3}, {3, 2, 1} };
        int[][] cuentas2 = { {1, 5}, {7, 3}, {3, 5} };
        int[][] cuentas3 = { {2, 8, 7}, {7, 1, 3}, {1, 9, 5} };

        logger.info("Riqueza del cliente 1: {}", Ej1.riquezaCliente(cuentas1)); 
        logger.info("Riqueza del cliente 2: {}", Ej1.riquezaCliente(cuentas2)); 
        logger.info("Riqueza del cliente 3: {}", Ej1.riquezaCliente(cuentas3)); 
        
       
        int[][] mat = {
            {3, 3, 1, 1},
            {2, 2, 1, 2},
            {1, 1, 1, 2}
        };

        logger.info("Matriz original:");
        Ej1.imprimirMatriz(mat);

        int[][] matrizOrdenada = Ej1.ordenarMatriz(mat);

        logger.info("\nMatriz ordenada diagonalmente:");
        Ej1.imprimirMatriz(matrizOrdenada);

        
        int[][] matriz = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        
        logger.info("\nSumatoria: ");
        logger.info(Ej1.sumarElementosMatriz(matriz));
        
    }
    
    
    public static void testTribonacci() {  
        EjercicioVectores ejercicio1 = new EjercicioVectores();
        int[] signature = {0, 0, 1};
        int n = 9;
        logger.info(Arrays.toString(ejercicio1.tribonacci(signature, n)));
    }
    
    public static void testFindTotal() { 
        EjercicioVectores ejercicio1 = new EjercicioVectores();
        int[] numbers1 = {1, 2, 3, 4, 5};
        int[] numbers2 = {17, 19, 21};
        int[] numbers3 = {5, 5, 5};
        
        logger.info("Puntuación: {}", ejercicio1.findTotal(numbers1));
        logger.info("Puntuación: {}", ejercicio1.findTotal(numbers2));
        logger.info("Puntuación: {}", ejercicio1.findTotal(numbers3));
    }
    
}