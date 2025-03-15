package umg.edu.gt.desarrollo.estructuradedatos2025.clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author josue
 */
public class ClaseVectores {

    private static final Logger logger = LogManager.getLogger(ClaseVectores.class);

    /**
     * Ejemplo 1: ArrayList y LinkedList
     */
    public void ejemploListas() {
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(10);
        lista.add(20);
        lista.add(30);
        lista.add(10);
        lista.add(50);

        logger.info("ArrayList: {}", lista);

        ArrayList<String> listaString = new ArrayList<>();
        listaString.add("Walter");
        listaString.add("Anibal");
        listaString.add("Cordova");
        listaString.remove(1);

        logger.info("ArrayList: {}", listaString);

        LinkedList<String> nombres = new LinkedList<>();
        nombres.add("Ana");
        nombres.add("Juan");
        nombres.add("Pedro");

        nombres.remove();

        logger.info("LinkedList: {}", nombres);
    }

    public void ejemploBuscarNumero() {
        int[] numeros = {10, 20, 30, 40, 50};
        int objetivo = 30;

        logger.info("¿El número {} está en el array? {}", objetivo, buscarNumero(numeros, objetivo));
    }

    public static boolean buscarNumero(int[] arr, int objetivo) {
        for (int num : arr) {
            if (num == objetivo) {
                return true;
            }
        }
        return false;
    }

    public void comparacionArraysLinkedListHash() {
        LinkedList<String> lista = new LinkedList<>();
        lista.add("A");
        lista.add("B");
        lista.add("C");
        lista.add("E");
        lista.add("E");
        lista.addFirst("Z");
        lista.addLast("X");
        lista.add(3, "8");
        lista.removeFirst();
        lista.removeLast();
        lista.remove(2);

        logger.info("LinkedList después de operaciones: {}", lista);

        ArrayList<String> lista2 = new ArrayList<>();
        lista2.add("A");
        lista2.add("B");
        lista2.add("C");
        lista2.add("E");
        lista2.add("E");
        lista2.add(3, "8");

        for (String letra : lista2) {
            if ("C".equals(letra)) {
                logger.info("Letra encontrada: {}", letra);
            }
        }

        HashMap<String, Integer> edades = new HashMap<>();
        edades.put("Walter", 34);
        edades.put("Trump", 50);
        edades.put("Almo", 60);
        edades.put("Bukele", 35);
        edades.put("Arevalo", 51);
        edades.put("Walter", 30);

        logger.info("HashMap de edades: {}", edades);
        logger.info("Edad de Almo: {}", edades.get("Almo"));
    }
}