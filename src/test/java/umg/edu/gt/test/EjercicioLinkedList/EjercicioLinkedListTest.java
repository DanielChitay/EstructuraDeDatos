package umg.edu.gt.test.EjercicioLinkedList;

import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioLinkedList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.LinkedList;

public class EjercicioLinkedListTest {

    @Test
    public void testEliminarDuplicados() {
        
    // Mandamos una lista de datos para el test de eliminacion de duplicados    
        EjercicioLinkedList ejercicio = new EjercicioLinkedList();
        LinkedList<Integer> lista = new LinkedList<>();
        lista.add(1);
        lista.add(2);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(4);

        ejercicio.eliminarDuplicados(lista);

        LinkedList<Integer> esperado = new LinkedList<>();
        esperado.add(1);
        esperado.add(2);
        esperado.add(3);
        esperado.add(4);

        assertEquals(esperado, lista);
    }

    @Test
    public void testInvertirLista() {
    // Mandamos una lista de datos para el test de inversion de datos de la lista 
        EjercicioLinkedList ejercicio = new EjercicioLinkedList();
        LinkedList<String> lista = new LinkedList<>();
        lista.add("A");
        lista.add("B");
        lista.add("C");

        ejercicio.invertirLista(lista);

        LinkedList<String> esperado = new LinkedList<>();
        esperado.add("C");
        esperado.add("B");
        esperado.add("A");

        assertEquals(esperado, lista);
    }

    @Test
    public void testIntercalarListasOrdenadas() {
        
    // Mandamos una lista de datos para el test de intercalar las listas 
        EjercicioLinkedList ejercicio = new EjercicioLinkedList();
        LinkedList<Integer> lista1 = new LinkedList<>();
        lista1.add(1);
        lista1.add(3);
        lista1.add(5);

        LinkedList<Integer> lista2 = new LinkedList<>();
        lista2.add(2);
        lista2.add(4);
        lista2.add(6);

        LinkedList<Integer> resultado = ejercicio.intercalarListasOrdenadas(lista1, lista2);

        LinkedList<Integer> esperado = new LinkedList<>();
        esperado.add(1);
        esperado.add(2);
        esperado.add(3);
        esperado.add(4);
        esperado.add(5);
        esperado.add(6);

        assertEquals(esperado, resultado);
    }

    @Test
    public void testIntercalarListasOrdenadas_Fallo() {
        EjercicioLinkedList ejercicio = new EjercicioLinkedList();
        LinkedList<Integer> lista1 = new LinkedList<>();
        lista1.add(1);
        lista1.add(3);
        lista1.add(5);

        LinkedList<Integer> lista2 = new LinkedList<>();
        lista2.add(2);
        lista2.add(4);
        lista2.add(6);

        LinkedList<Integer> resultado = ejercicio.intercalarListasOrdenadas(lista1, lista2);

        LinkedList<Integer> esperado = new LinkedList<>();
        esperado.add(1);
        esperado.add(2);
        esperado.add(3);
        esperado.add(4);
        esperado.add(5);

        // Forzar un fallo en la prueba
        assertNotEquals(esperado, resultado);
    }
}